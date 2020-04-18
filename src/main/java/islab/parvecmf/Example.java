package islab.parvecmf;

import islab.parvecmf.factorizer.ParVecMFFactorizer;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.recommender.svd.Factorizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.SVDRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

/**
 * Demonstrates the usage of the <a href="https://git.islab.ntua.gr/gealexandri/parvecmf/src/master/javadoc/islab/parvecmf/factorizer/ParVecMFFactorizer.html">ParVecMFFactorizer</a> class.
 */
public class Example {

    public static void main( String[] args ) throws IOException, TasteException, URISyntaxException {
        Example example = new Example();

        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);

        // Read ratings from resources
        ExampleDataModel model = new ExampleDataModel(new File(example.getResource("ratings.dat")));

        // Construct the ParVecMFFactorizer, using 50 features for latent user/item representations and reading the
        // user/item paragraph vectors from the user.dat and item.dat resources, respectively. Set the number of
        // iterations to 30 and the hyper-parameters according to the suggested values in the paper.
        Factorizer fc = new ParVecMFFactorizer(
                model,
                model.getIDMigrator(),
                50,
                example.getResource("user.dat"),
                example.getResource("item.dat"),
                30,
                0.5,
                0.5,
                1.0,
                Runtime.getRuntime().availableProcessors()
        );

        // Build the recommender
        Recommender rec = new SVDRecommender(model, fc);

        String strUser = "AAOYA0DKWED4W";
        int howMany = 5;

        System.out.println("\nRecommendations for " + strUser);
        System.out.println("---------------------------------");

        // Output 5 recommendations for user AAOYA0DKWED4W
        for (RecommendedItem ri :rec.recommend(model.getIDMigrator().toLongID(strUser), howMany))
            System.out.println("Item: " + model.getIDMigrator().toStringID(ri.getItemID()) + " Score: " + ri.getValue());

    }

    /**
     * Copies a resource from the jar to a temporary file in the filesystem, in order to be read by subsequent classes
     * (deletes the file on program exit)
     *
     * @param name a {@link String} containing the resources name
     * @return The path of the temporary file
     * @throws IOException in case of an I/O error
     */
    private String getResource(String name) throws IOException {
        File tempFile = File.createTempFile("parvecmf", ".dat");
        tempFile.deleteOnExit();
        Files.copy(
                Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(name)),
                tempFile.toPath(),
                StandardCopyOption.REPLACE_EXISTING);
        return tempFile.toString();
    }
}

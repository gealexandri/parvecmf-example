package islab.parvecmf;

import org.apache.mahout.cf.taste.impl.model.MemoryIDMigrator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.IDMigrator;

import java.io.File;
import java.io.IOException;

/**
 * An extension to {@link FileDataModel} that supports an in-build {@link MemoryIDMigrator}
 *
 */
public final class ExampleDataModel extends FileDataModel {
    // The in-build MemoryIDMigrator
    public MemoryIDMigrator idMigrator;

    public ExampleDataModel(File dataFile) throws IOException {
        super(dataFile);
    }

    @Override
    protected DataModel buildModel() throws IOException {
        // create the MemoryIDMigrator, if it does not exist already
        if (idMigrator == null) idMigrator = new MemoryIDMigrator();
        return super.buildModel();
    }

    @Override
    protected long readItemIDFromString(String value) {
        long result = idMigrator.toLongID(value);
        idMigrator.storeMapping(result, value);
        return result;
    }

    @Override
    protected long readUserIDFromString(String value) {
        long result = idMigrator.toLongID(value);
        idMigrator.storeMapping(result, value);
        return result;
    }

    /**
     * Get the in-build {@link MemoryIDMigrator}
     *
     * @return the {@link MemoryIDMigrator} as an instance of {@link IDMigrator}
     */
    public IDMigrator getIDMigrator() {
        return this.idMigrator;
    }
}


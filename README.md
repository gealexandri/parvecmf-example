# ParVecMF Example

Repository containg a working example of the ParVecMF methodology introduced in "[ParVecMF: A Paragraph Vector-based Matrix Factorization Recommender System](https://arxiv.org/abs/1706.07513)" and in "[From Free-text User Reviews to Product Recommendation using Paragraph Vectors and Matrix Factorization](https://doi.org/10.1145/3308560.3316601)".

## Requirements

1. Oracle Java Version 1.8
2. Apache Maven 3.6.0

## Usage

1. Clone the [parvecmf](https://github.com/gealexandri/parvecmf) repository & follow the instructions there.
2. Clone the current repository to a local folder (e.g. ```git clone https://github.com/gealexandri/parvecmf-example.git```)
4. Change to that folder and issue ```mvn package```
5. Run the example, issuing ```java -cp target/parvecmf-example-0.0.1-standalone.jar islab.parvecmf.Example```

## Details

The example code resources include an excerpt from the *Home and Kitchen* dataset of the [Amazon product data](http://jmcauley.ucsd.edu/data/amazon/) (file ```./src/main/resources/data.json```). This json file has been converted to a CSV file (```./src/main/resources/ratings.dat```) in the format preferred by [Apache Mahout](https://mahout.apache.org)'s [FileDataModel](https://mahout.apache.org/docs/0.13.0/api/docs/mahout-mr/org/apache/mahout/cf/taste/impl/model/file/FileDataModel.html) class. The user (```./src/main/resources/user.dat```) and item (```./src/main/resources/item.dat```) paragraph vectors have been generated according the methodology described in the ParVecMF papers, using [gensim](https://radimrehurek.com/gensim/).
 

## Licence & Citations

The source code is provided under an Apache Licence, Version 2 (please read LICENCE.txt for more details). If you plan to use this code in your project or research, please cite the following two publications:

<pre>
@inproceedings{Alexandridis:2019:FUR:3308560.3316601,
 author = {Alexandridis, Georgios and Tagaris, Thanos and Siolas, Giorgos and Stafylopatis, Andreas},
 title = {From Free-text User Reviews to Product Recommendation Using Paragraph Vectors and Matrix Factorization},
 booktitle = {Companion Proceedings of The 2019 World Wide Web Conference},
 series = {WWW '19},
 year = {2019},
 isbn = {978-1-4503-6675-5},
 location = {San Francisco, USA},
 pages = {335--343},
 numpages = {9},
 url = {http://doi.acm.org/10.1145/3308560.3316601},
 doi = {10.1145/3308560.3316601},
 acmid = {3316601},
 publisher = {ACM},
 address = {New York, NY, USA},
 keywords = {Collaborative Filtering, Free-text reviews, Matrix Factorization, Maximum A-posteriori Estimation, Neural Language Processing, Paragraph Vectors, Recommender Systems, Word2Vec},
} 
</pre>

and

<pre>
@misc{alex2017parvecmf,
    title={ParVecMF: A Paragraph Vector-based Matrix Factorization Recommender System},
    author={Georgios Alexandridis and Georgios Siolas and Andreas Stafylopatis},
    year={2017},
    eprint={1706.07513},
    archivePrefix={arXiv},
    primaryClass={cs.IR}
}
</pre>
# Artificial Intelligence Engineer
Reference materials for Software Engineers/Developers to kick start in 
AI

## Technology Stack
- Programming Language
    - [Python](https://www.python.org/)
- IDE
    - [PyCharm](https://www.jetbrains.com/pycharm/)
    - [Jupyter](https://jupyter.org/)
    - [Jupyter Lab](https://jupyterlab.readthedocs.io/en/stable/getting_started/installation.html)
- Virtual Environment
    - [Anaconda](https://www.anaconda.com/)
- Visualization
    - [Plotly](https://plot.ly/)
    - [Matplotlib](https://matplotlib.org/)
    - [Seaborn](https://seaborn.pydata.org/)
- Scietific Computing
    - [Numpy](https://numpy.org/)
    - [Scipy](https://www.scipy.org/)
- NLP
    - [NLTK](https://www.nltk.org/)
    - [spaCy](https://spacy.io/)
    - [Pytorch Text](https://github.com/pytorch/text)
- Machine Learning
    - [Scikit Learn](https://scikit-learn.org/stable/)
- Deep Learning
    - [Pytorch](https://pytorch.org)
    - [Tensorflow](https://www.tensorflow.org/)
- Big Data
    - [Apache Spark](https://spark.apache.org/)
    - [Apache Kafka](https://kafka.apache.org/)
- Web Application (Front End/Back End)
    - [Flask](https://palletsprojects.com/p/flask/)
    - [Django](https://www.djangoproject.com/)
    - [GraphQL](https://dgraph.io/)
- Misc
    - [Turn the repo in interactive notebooks](https://mybinder.org/)
    
     
## Development Environment Setup
Virtual environment `Conda` is used to setup the Python development
arena!

Follow the steps [here](https://docs.conda.io/projects/conda/en/latest/user-guide/install/linux.html) to install `conda`.

```
#create a virtual env with a specific location, to take load out of root path
conda create --prefix=/opt/envs/aie/ python=3.7
conda activate /opt/envs/aie
pip install -r requirements.txt
python -m spacy download en_core_web_sm
python -m spacy download en_core_web_lg #install if you need to work on word vectors!
conda install pytorch torchvision cudatoolkit=10.1 -c pytorch

jupyter-lab # http://localhost:8888/lab

``` 

## [Natural Language Processing](docs/nlp)


# Data Science 

## Mathematics


## Machine Learning


## Deep Learning
1. Activation Functions

### Q&A
- When can a loss go as `nan`?
  - NaNs can arise from division by zero or natural log of zero or negative number. 
  - If the loss function is using `log` and the lables are in negative region
  - When using cross enropy as loss function and the predictions are having same probability distribution
  - When `Nan` is in the input data. Avoid it by assserting `assert not np.any(np.isnan(x))`

### Reference Links
- http://neuralnetworksanddeeplearning.com/


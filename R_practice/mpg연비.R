library("ggplot2")
mpg <- ggplot2::mpg
qplot(data = mpg, x = drv, y = hwy)
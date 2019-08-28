mpg <- ggplot2::mpg
ggplot(data=mpg, aes(x=hwy)) + geom_histogram(bins=100)
qplot(data=mpg, x=drv, y=hwy, geom = 'line')

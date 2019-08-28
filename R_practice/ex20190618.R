library("dplyr")
mpg <- ggplot2::mpg

data(mpg)
str(mpg)
mpg <- as.data.frame(mpg)
str(mpg)
qplot(data=mpg, x = drv, y= hwy)
ggplot(data=mpg, aes(x=displ, y=hwy)) + geom_point() +ylim(10,60)
length(which(mpg$drv==4))
length(which(mpg$drv=="r"))
length(which(mpg$drv=="f"))
head(mpg)
qplot(data=mpg, x = drv)

mpg <- mpg %>% group_by(drv) %>% summarise(mean_hwy = mean(hwy))
mpg
ggplot(data=mpg, aes(x = class)) + geom_bar()

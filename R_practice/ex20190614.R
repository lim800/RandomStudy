a <- data.frame(x=c(1,2,3,4,5), y=c(2,4,6,8,10))
a
a <- data.frame(x=c(1,2,3,4,5), y=c(2,4,6,8,10), z=c("M","F","M","F","M"))
a
a$v <- c(3,6,9,12,15)
a
a$x
a[1,]
a[c(1,4),]
a[1:4,]
a[,c(1,4)]
a[,"z"]
a[,"z",drop = F]

(x <-data.frame(a = 1:3, b = 4:6, c= 7:9))
x[,names(x) %in% c("b","c")]
x[,!names(x) %in% c("b","c")]

(d <- data.frame(x=c(1,2,3,4,5), y=c("a","b","c","d","e")))
d[c(T,T,F,T,F),]
d[,c(T,F)]
d
x
head(x)
str(x)
(a <- data.frame(x = 1:1000))
head(a)
tail(a)


library('ggplot2')
mpg <- ggplot2::mpg
mpg
x <- boxplot(mpg$cty)
x
str(x)

x <- data.frame((1:3))
x
names(x) <-c("col")
colnames(x) <-c("column")
x
rownames(x) <- c("row1","row2","row3")
x

eng <- c(90,80,70,60)
mth <- c(50,60,100,20)
record <- data.frame(eng,mth,grp)
record
grp <- c(1,2,2,1)
record
mean(record$'eng')
mean(record$mth)
mean(record$c(eng,mth))
for (a in c('eng','mth')) {
  print(a)
}

(x <- matrix(c(1,2,3,4), ncol=2, byrow = T))
(x <- matrix(c(1,2,3,4), ncol=2))

# 역행렬 구하기
(x <- solve(x))

# 전치행렬 구하기
(t(x))

array(1:12, dim = c(3,4))
array(1:12, dim = c(5,2))

x <- array(c('a','b','c','d','e','f','g','h','i','j','k','l'), dim = c(2,2,3))
x
x[,,1]
x[,1,]
x
x[5]
x

mpg <- ggplot2::mpg
df <- data.frame(mpg)
df
head(df)
head(mpg)
class(df$drv)
df$drv
drvs <- as.factor(df$drv)
drvs
levels(drvs)
?"factor"
?"as"
 
x <- list(a=list(val=c(1,2,3),col=c(2,3)), b=list(val=c(1,2,3,4)))
x$a$col
x[1]
x
x[[1]]
x[[1]]

x<- boxplot(df$cty)
x
df$cty
head(data.frame(df$cty))
x
x$stats[4,1]
x$stats[,1][4]
str(x)
data.frame(x)
x

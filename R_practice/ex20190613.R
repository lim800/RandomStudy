rm(list = ls())

a <- 3
b <- 4.5
c <- a+b
c
print(c)
print('3+4.5는', c)
cat('3+4.5는', c)

a <- '3'
a

TRUE & FALSE
TRUE | FALSE
T & F
F<- TRUE
T & F

a <- NA
A <- '1'
is.na(a)
NA & T
NA & TRUE
NA & F
NA & FALSE

sum(c(1,2,NA))
sum(c(1,2,NA), na.rm = TRUE)

d <- data.frame(x=c(1,2,3), y=c(3,NA,5), z=c(2,6,NA))
d
na.omit(d)
na.fail(d)
na.pass(d)

c <- data.frame(x=c(1,2,3), y=c(3,5), z=c(2,6))
c <- na.pass(data.frame(x=c(1,2,3), y=c(3,5), z=c(2,6)))

a <- NULL
a

sum(c(1,2,NULL))

gender <- factor("m", c("m", "f"))
gender
nlevels(gender)
levels(gender)
levels(gender) <- c('남자','여자')

quality <- factor("okay", c("worst","bad","okay","good","perfect"), ordered = T)
quality

x <- seq_along(c(1,4,5))
x
x[-2]
?"seq_along"
x <- seq_along(5)
x

y <- c('a','b','c')
y
y[1:3]

c(1,2,3,c(1,2,3,4))

x <- 1:10
x

seq(3,10,2)
seq_along(c(1,2,3,4,5,1,2))
seq_len(2)

x <- c(1,2,3)
names(x) <- c("일","이","삼")
x

x[2]
x[-2]
x[1:3]

names(x)
y <- c(1,3,4)
names(y) <- c('a','b')
y
names(y)[1:3]


c(T,T,T) & c(T,F,T)
c(T,T,T) && c(T,F,T)

x <- c(1,2,3,4,5,6,7,8)
sum(x)
mean(x)
median(x)
max(x)
min(x)




y <- sample(1:8,10,replace = T)
y1 <- sort(y)
n <- length(y)
if (n%%2 == 0) {
  a <- n/2
  b <- n/2 + 1
  answer <- (y1[a] + y1[b])/2
}else
{
  a <- (n+1)/2
  answer <- y1[a]
}
answer

a <- data.frame(x=c(1,2,3,4,5),y=c(2,4,6,8,10))
a
a$y
a[,2]
a[2,]
a[2,2]
a

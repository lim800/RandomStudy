# 주석
help('summary')
?'for'
help.search('anova')

localeToCharset()
a <- "안녕"
a
Encoding(a)
a <- iconv(a, to = "cp949")
a
Encoding(a)
a <- iconv(a , to ="UTF-8")
a
a <- "안연여"
a
iconv(a, to = "CP949")
a <- "안녕"
Encoding(a)
1:10
seq(1, 10, .5)
rep(10,5)
rep(1:3,5)
LETTERS[1:26]
letters[1:27]
month.name
LETTERS[month.name]
upper.tri(month.name)
?"LETTERS"
localeToCharset()
Encoding(a)
a <- "하이"
Encoding(a)
Sys.getlocale()
summary(a)
length(a)
?"for"

for(i in 1:5) print(1:i)
for(n in c(2,5,10,20,50)) {
  x <- stats::rnorm(n)
  cat(n, ": ", sum(x^2), "\n", sep = "")
}
?"rnorm"
R.version
Sys.getenv()

(20+3*2)/3
options(digits = 3)

Sys.info()[1:5]
getOption("encoding")
Sys.getlocale("LC_ALL")
l10n_info()[1]
l10n_info()[1:3][3]
a <- "Maurício"
Encoding(a)
?"c"
c(1,7:9)
c("a","b",5+3)
?"names"
names(islands)
names(x) <- c("aaaaa" , "bbbb")
x
names(x)

install.packages("ggplot2")
install.packages("dplyr")

# <- : 데이터 할당
# = : 옵션 할당

x = 1
x
x <- 2

rm(list = ls())
x <-"gg"
rm(x)
x = y= 1
x <- y <- 4
x = y <- 2

#나머지 반환
3 %% 2

#멤버쉽 테스트
3%in%3

2%*%3
2%/%3
10%*%10
matrix(c(1:3))%*%matrix(c(1:3))
matrix(c(1:3))
matrix(c(1:2))*matrix(c(1:2),ncol = 2)
matrix(c(1:2))
matrix(c(1:2),ncol = 2)
matrix(c(1:2))%*%matrix(c(1:2),ncol = 2)

matrix(c(1:2))%/%matrix(c(1:2))
matrix(c(1:2))/matrix(c(1:2))

matrix(c(1:4),ncol = 2)%*%matrix(c(1:4),ncol = 2)
matrix(c(1:4),ncol = 2)*matrix(c(1:4),ncol = 2)


ls()
x <- 1
y <- 1 
z <- 2

rm('x')
rm(list = c('y','z'))

gc()

#객체의 자료
a <- c(1,2,3,2,1)
a
class(a)
a<-a+2
levels(a)
a <- factor(a)
class(a)
levels(a)

a <- 3
b <- 4.5
c <- a+b
print(c)
c
cat(a, "는", c)

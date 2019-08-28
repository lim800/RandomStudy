if(TRUE){
  print("hello")
}
x <- 2
if (x %% 2 == 0) print("짝수")

if (FALSE) {
  print("hello")
} else{
  print("안녕")
}

x <- 2 
if (x==1) {
  print(1)
} else if(x==2){
  print(2)
} else{
  print("non value")
} 

x <- c(1,2,3,-1,2)
y <- ifelse(x>0,"positive","negative")
y

for (i in 1:10) {
  print(i)
}

i <- 0
while (i < 10) {
  print(i)
  i <- i + 1
}

f <- function(n) {
  return(1)
}
f(5)


f <- function(x,y){
  print(x)
  print(y)
}
f(1,2)

f(y=1, x=2)

g <- function(x,...){
  print(x)
  f(...)
}
g(1,2,3)

f <- function(x,y){
  print(x)
  g<-function(y){
    print(y)
  }
  g(y)
}
f(1,2)

x <- 1
f <- function(){
  print(x)
}
f()
x <-2 
f()

x <- 100
f <- function(x){
  print(x)
}
f(1)

rm(list = ls())
f <- function(){
  x <- 2
}
x

a<- 100
f <- function(x) {
  g <- function(y){
    print(y+a)
  }
  g(x)
}
f(1)

getwd()
list.files(all.files =T)

a<- read.table("test1.txt", sep = ",")
a

b <- readLines("test1.txt")
b

reportcard <- data.frame(group = c(1,1,2,2), english = c(90,80,60,70), math = c(50,60,100,20))
reportcard
write.table(reportcard,"testcard1.txt")
c <- read.table("testcard1.txt")
c

install.packages("readxl")
library("readxl")

a<- read_excel("./rrrr/grade.xlsx")
a
list(a)
dim(a)
mean(a$science)
b<- read_excel("./rrrr/grade.xlsx", sheet = 2)
b

install.packages("xlsx")
library("xlsx")
library("rJava")
Sys.setenv(JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/bin")
Sys.setenv
reportcard <- data.frame(group = c(1,1,2,2), english = c(90,80,60,70), math = c(50,60,100,20))
reportcard


a < - read.csv('./rrrr/grade_csv.csv')
a
dim(a)
str(a)
summary(a)
boxplot(a)
head(a)
library(dplyr)
rename(a,"id" = "ID")
head(a)
a$total <- a$math + a$english + a$science
head(a)
dim(a)[2]
dim(a["math":"science"])
dim(a[3:5])

# 파이프 라인
a<- 1:5
a
sum(a)
1:5 %>% sum(.)
sum(length(1:5))
filter(a)
a %>% filter(a > 0)
a
length((1:5))
sum(5)
sum(1:5)
5 %>% sum(1:.)
5 %>% {sum(1:.)}
1:5 %>% sum({length(.)})
1:5 %>% {sum(length(.))}
sum(length(1:5))
?"range"
1:5
1:5 %>% sum() %>% 1:.

df <- read.csv('./rrrr/grade_csv.csv')
head(df)
summary(df)
df %>% head() %>% summary()
?'subset'

df
df %>% filter(class == 5) %>% .[3:5] %>% summary()

select(df)
select(df, 'math')
filter(df, class == 5)
df
df %>% filter(., class == 5) %>% .[3:5] %>% summary()
1:5 %>% length() %>% sum()
?"mutate"

head(df)
b = group_by(df,math)
?"group_by"
arrange(df,math)
desc(df,math)
desc(df)
1:5 %>% {length(sum(.))}
1:5 %>% sum(., length(.))
df %>% arrange(desc(math)) %>% head()

df1 <- mutate(df, total = math + english + science) %>% head(8)
df1
summarise(df,mean_math=mean(math))
df %>% group_by(class) %>% summarise(mean_math = mean(math))

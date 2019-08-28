install.packages("foreign")
install.packages("sas7bdat")

welfare <- read.spss(file = './rrrr/Koweps_hpc10_2015_beta1.sav', to.data.frame = TRUE)
str(welfare)
summary(welfare)
welfare <- rename(welfare, gender = h10_g3, birth = h10_g4, marriage = h10_g10, religion = h10_g11, code_job = h10_eco9, income = p1002_8aq1, code_region = h10_reg7)
class(welfare$gender)
table(welfare$gender)
welfare$gender <- ifelse(welfare$gender ==1, "male", "female")
table(welfare$gender)
qplot(welfare$gender)
class(welfare$income)
summary(welfare$income)
library("ggplot2")
qplot(welfare$income)
qplot(welfare$income) + xlim(0,1000)

summary(welfare$income)
welfare$income <- ifelse(welfare$income %in% c(0,9999), NA, welfare$income)
table(is.na(welfare$income))
gender_income <- welfare %>% filter(!is.na(income)) %>% group_by(gender) %>% summarise(mean_income = mean(income))
gender_income
ggplot(data = gender_income, aes(x=gender, y=mean_income)) + geom_col()

class(welfare$birth)
summary(welfare$birth)
qplot(welfare$birth)
table(is.na(welfare$birth))

welfare$age <- 2019 - welfare$birth + 1
summary(welfare$age)
qplot(welfare$age, bins=20)

aga_income <- welfare %>% filter(!is.na(income)) %>% group_by(age) %>% summarise(mean_income = mean(income))
aga_income
ggplot(data = aga_income, aes(x= age, y= mean_income)) + geom_line()

welfare <- welfare %>% mutate(ageg = ifelse(age < 30, "young", ifelse(age <= 59, "middle", "old")))
table(welfare$ageg)
qplot(welfare$ageg)
ageg_income <- welfare %>% filter(!is.na(income)) %>% group_by(ageg) %>% summarise(mean_income = mean(income))
ageg_income
ggplot(data=ageg_income, aes(x=ageg, y=mean_income)) + geom_col() + scale_x_discrete(limits = c("young","middle","old"))

welfare$age <- 2019 - welfare$birth + 1
welfare <- welfare %>% mutate(ageg = ifelse(age < 30, "young", ifelse(age <=59, "middle", "old")))
gender_income <- welfare %>% filter(!is.na(income)) %>% group_by(ageg, gender) %>% summarise(mean_income = mean(income))
class(gender_income)
ggplot(data = gender_income , aes(x = ageg, y = mean_income, fill = gender)) + geom_col( ) + scale_x_discrete(limits = c("young","middle","old"))
ggplot(data = gender_income , aes(x = ageg, y = mean_income, fill = gender)) + geom_col(position = "dodge" ) + scale_x_discrete(limits = c("young","middle","old"))

gender_age <- welfare %>% filter(!is.na(income)) %>% group_by(age, gender) %>% summarise(mean_income = mean(income))
ggplot(data = gender_age, aes(x=age, y=mean_income,col=gender)) + geom_line()


install.packages("rJava")
install.packages("memoise")
install.packages("KoNLP")
install.packages("devtools")
install.packages("stringr")
library("KoNLP")
useNIADic()

txt1 <- readLines("./rrrr/apology.txt")
head(txt1)
txt2 <- str_replace_all(txt1, "  ", " ")
txt2
txt3 <- sapply(txt2, extractNoun, USE.NAMES = F)
txt3
str(txt3)
txt4 <- unlist(txt3)
str(txt4)
txt5 <- Filter(function(x){nchar(x)>=2}, txt4)
txt5
txt5 <- gsub("박근혜", "", txt4)
txt5
txt5 <- gsub("대통령", "", txt5)
txt5
txt5 <- Filter(function(x){nchar(x)>=2}, txt5)
txt5
write(txt5, "aa.txt")
txt6 <- readLines("aa.txt")
str(txt6)
txt6

install.packages("wordcloud")
library("wordcloud")
word1 <- read.table("aa.txt")
word1
word2 <- table(word1)
word2

wordcolor <- brewer.pal(8, "Dark2")
wordcolor
wordcloud(names(word2), freq = word2, min.freq = 1, max.words = 30, random.order = F, rot.per = .1, scale = c(3,0.5), colors = wordcolor, family="AppleGothic")

word1 <- read.table("./rrrr/new_word.txt", fileEncoding = "UTF-8")
word2 <- table(word1)
top10 <- head(sort(word2, decreasing = T), 10)
pct <- round(top10/sum(top10) * 100, 1)
pct
lab <- paste(names(top10), "\n", pct, '%')
lab
names(top10)
pie(top10, col = rainbow(10), cex = 0.8, labels = lab, family = "AppleGothic")

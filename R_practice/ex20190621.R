install.packages("plotly")
mpg <- ggplot2::mpg
p <- ggplot(data = mpg, aes(x= displ, y =hwy, col = drv)) + geom_point()
ggplotly(p)
install.packages("dygraphs")
econ <- ggplot2::economics
eco <- xts(econ$unemploy, order.by = econ$date)
class(eco)
dygraph(eco) %>% dyRangeSelector()
eco_a <- xts(econ$psavert, order.by = econ$date)
eco_b <- xts(econ$unemploy/1000, order.by = econ$date)
eco2 <- cbind(eco_a,eco_b)
colnames(eco2) <-c("psavert","unemploy")
head(eco2,2)
dygraph(eco2)

d <- ggplot(data = diamonds, aes(x = cut, fill = clarity)) + geom_bar(position = "dodge")
ggplotly(d)

kospi <- read.csv("/Users/lesson6_mac/AtomData/rdata/Begin/rrrr/kospi.csv",check.names = F,encoding = 'utf8')
iconv(names(kospi), to = "utf8", sub = "")

head(kospi)
class(kospi)
str(kospi)

mpg <- as.data.frame(ggplot2::mpg)
class(mpg)
head(mpg)
mpg_diff <- mpg %>% select(class, cty) %>% filter(class %in% c("compact","suv"))
head(mpg_diff)
table(mpg_diff$class)
t.test(data=mpg_diff, cty ~ class, var.equal = T)

mpg_diff2 <- mpg %>% select(fl,cty) %>% filter(fl %in% c("r","p"))
table(mpg_diff2$fl)
t.test(data=mpg_diff2, cty ~ fl, var.equal = T)

econ <- as.data.frame(ggplot2::economics)
cor.test(econ$uempmed, econ$pce)

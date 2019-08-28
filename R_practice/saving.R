economics <- ggplot2::economics
library("dygraphs")
library("zoo")
library("xts")
eco_a <- xts(economics$psavert, order.by = economics$date)
eco_b <- xts(economics$unemploy/1000, order.by = economics$date)
eco2 <- cbind(eco_a, eco_b)
colnames(eco2) <- c("psavert","unemploy")
dygraph(eco2) %>% dyRangeSelector( )

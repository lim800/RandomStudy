econ <- ggplot2::economics
library("dygraphs")
library("zoo")
library("xts")
eco_a <- xts(econ$psavert, order.by = econ$date)
eco_b <- xts(econ$unemploy/1000, order.by = econ$date)
eco2 <- cbind(eco_a, eco_b)
colnames(eco2) <- c("psavert", "unemploy")
dygraph(eco2) %>% dyRangeSelector()
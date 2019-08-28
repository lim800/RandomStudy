library("ggplot2")
library("plotly")
p <- ggplot(data = diamonds, aes(x=cut, fill=clarity)) + geom_bar(position = "dodge")
ggplotly(p)
library("foreign")
welfare <- read.spss(file = "/Users/lesson6_mac/AtomData/rdata/Begin/rrrr/Koweps_hpc10_2015_beta1.sav", to.data.frame = T)

library("dplyr")
welfare <- rename(welfare, 
                  gender = h10_g3, 
                  birth = h10_g4, 
                  marriage = h10_g10, 
                  religion = h10_g11, 
                  code_job = h10_eco9, 
                  income = p1002_8aq1, 
                  code_region = h10_reg7)
names(welfare)
str(welfare)
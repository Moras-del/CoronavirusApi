# CoronavirusApi
Coronavirus api for filtering  and sorting covid cases  
```/cases```  fetch all, from 22-01-2020 to yesterday, sorted (default sorting) by countries  
query options:  
```country``` -> filter specific country  
```from``` -> filter from specific date  
```to``` -> filter to specific date  
```sortBy``` -> sort by value  
values available to sort by:  
```cases``` -> sort by total cases  
```recovered``` -> sort by recovered cases  
```deaths``` -> sort by deaths   
```date``` -> sort by date  
You can add D to every value to set it as descending  

example usage:
```localhost:8080/cases?country=Poland&&from=01-01-2021&&to=10-02-2021``` get daily data from Poland from 01-01-2021 to 10-02-2021  
```localhost:8080/cases?from=10-02-2021&&to=15-02-2021&&sortBy=deathsD``` get daily data from every country from 10-02-2021 to 15-02-2021, sort it by deaths, descending  

source of data: https://raw.githubusercontent.com/datasets/covid-19/master/data/time-series-19-covid-combined.csv

# RESTful API

This project is a demo of Spring framework RESTful API. The whole purpose of this application is to show:
1. how to build an application with accessible endpoint.
2. how services should be implemented for readability and maintainable purpose.

## Run the application

This is a Spring framework application, simply run the application from ```RestServiceApplication```

## API Requests
You can find the default port in ```application.properties```
```java
server.port = 18080
```
To add a new trading data: ```POST``` request via```/api/addexchangedata```
```json
{
  "userId": "134256",
  "currencyFrom": "EUR",
  "currencyTo": "GBP",
  "amountSell": 1000,
  "amountBuy": 747.20,
  "rate": 0.747,
  "timePlaced": "24-Jan-18 01:02:03",
  "originatingCountry": "FR"
}
```

Response
```json
{
  "userId": 134256,
  "currencyFrom": "EUR",
  "currencyTo": "GBP",
  "amountSell": 1000,
  "amountBuy": 747.20,
  "rate": 0.747,
  "timePlaced": "24-Jan-18 01:02:03",
  "originatingCountry": "FR"
}
```

To retrieve full list of added records: ```GET``` request via ```/api/getexchangehistory```

```json
//no params
```
Note: This method may changed to POST method and add params to limit the result size for performance purpose when dealing with large data size in DB.

Response for two added data sets
```json
{
  "historyRecords": [
    {
      "userId": 134256,
      "currencyFrom": "EUR",
      "currencyTo": "GBP",
      "amountSell": 1000,
      "amountBuy": 747.20,
      "rate": 0.747,
      "timePlaced": "24-Jan-18 01:02:03",
      "originatingCountry": "FR"
    },
    {
      "userId": 134256,
      "currencyFrom": "EUR",
      "currencyTo": "GBP",
      "amountSell": 3000,
      "amountBuy": 747.20,
      "rate": 0.747,
      "timePlaced": "24-Jan-18 01:02:03",
      "originatingCountry": "FR"
    }
  ],
  "resultSize": 2,
  "currentTime": "2021-09-14T11:50:38.041"
}
```

## Test case
Currently, there is only one test case
```AddRandomData2List()``` in ```ExchangeControllerTests``` to test the basic functionality to add data and retrieve past records.

More test cases should be added to the project, for example:
1. Validity of input data (ex. rate and amount should always larger than 0)
2. Missing fields when adding data via endpoint
3. (Stress test) Large data size testing, especially when using DB. We want to make sure the DB can handle large data without a problem.

## Improvement
There are many ways we can improve this application for actual PROD environment :
1. DB should be used as we don't want to lose data when the server restarts
2. Server side should validate any data passed to the endpoint
3. Add try catch for exception handlings
4. Add debug log for important functions to help debugging when problems occurs  (SLF4J, Log4j)
5. ```DB related``` Proper DB table settings to handle data in the shortest time

## Development Environment
Project was tested and developed in the below environment:
```
IntelliJ IDEA 2020.3.4 (Ultimate Edition)
Build #IU-203.8084.24, built on April 27, 2021
```
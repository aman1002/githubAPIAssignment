Implemented solution for following problem:
2. Find the oldest user accounts with zero followers
Use the GitHub API to expose an endpoint in this microservice that will find the oldest accounts with zero followers.
The endpoint should accept a parameter that sets the number of accounts to return.
The following fields should be returned:
  id
  login
  html_url

Exercice Solution includes Swagger and following is the link for swagger
http://localhost:8080/swagger-ui.html

Solution has api to get accounts with zero followers in microservice folder and package is :
com.telstra.codechallenge.accounts

Test cases is in mocroservice/test folder in package com.telstra.codechallenge
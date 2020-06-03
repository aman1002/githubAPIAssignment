# See
# https://github.com/intuit/karate#syntax-guide
# for how to write feature scenarios
Feature: As an api user I want to retrieve some user accounts

  Scenario: Get user accounts
    Given url microserviceUrl
    And path '/accounts'
    When method GET
    Then status 200
    And match param numOfAccounts contains 1
    # see https://github.com/intuit/karate#schema-validation
    And match response ==
    """
    [
      {
          "id": 13064110,
          "login": "mercuryphp",
          "html_url": "https://github.com/mercuryphp"
      }
    ]
    """


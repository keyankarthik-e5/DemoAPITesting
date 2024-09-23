Feature: This feature is a sample for API Testing

  Scenario: API Testing using RestAssured Get method
    Given user creates get request
    When user hits the get method
    Then user Asserts the response

  Scenario: API Testing using RestAssured post method
    Given user creates post request
    When user hits the post request
    Then user Asserts the post response

  Scenario: API Testing using RestAssured Put method
    Given user creates put request
    When user hits put request
    Then user Asserts the put response

  Scenario: API Testing using RestAssured Delete method
      Given user creates the delete request
      When user hits the delete request
      Then user Asserts the delete response



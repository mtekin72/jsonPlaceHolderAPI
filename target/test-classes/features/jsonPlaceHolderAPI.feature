@Smoke
Feature: User Verification

  Scenario: Verify userName Information
    Given send get request with parameter "username", "Delphine", "baseURL" and "/users"
    When The status code should be 200 and the information is correct
    Then Get the respond Id Information of the user

  Scenario: Get the valid Id or Ids of the User after get posts request
    Given I have sent the get posts request of API with "baseURL" and "/posts"
    When The status code should be 200 and the posts information is correct
    When I entered the query parameter of  "id"
    And The related posts belong to correct user_Id is listed

  Scenario: Validate the emails
    Given I have sent the get comments request of API with "baseURL" and "/comments"
    When The status code should be 200 and comments the information is correct
    When I entered the query parameter of  "id" of Comments
    And The email belongs to comments user Id is validated

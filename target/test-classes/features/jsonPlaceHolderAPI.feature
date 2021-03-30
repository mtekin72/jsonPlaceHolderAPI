@Smoke
Features: User Verification

  Scenario: Verify userName Information
    Given I have sent the get request of API with valid "BaseURL"  and "/users"
    And I entered the query parameter of userName as "Delphine "
    When I get the response userName information from API
    Then The status code should be 200 and the information about userName is correct
    And Get the respond Id Information of the user

  Scenario: Get the valid Id or Ids of the User after get posts request
    Given I have sent the get request of API with "BaseURL" and "/posts"
    And I entered the query parameter of  "user_Id value"
    When I get the response userName information from API
    Then The status code should be 200
    And The information about userName is correct
    And The related posts belong to correct  user_Id is listed

  Scenario: Validate the emails
    Given I have sent the get request of API with valid "BaseURL"  and "/comments"
    And I entered the query parameter of  "Id value" of Comments
    When I get the response of comments Id information from API as a list
    And  I get response of comments email information from API as a list
    Then The status code should be 200
    And The information about comments Id is correct
    And The email belongs to comments user Id is validated
$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/NegativeTestScenarios.feature");
formatter.feature({
  "name": "Check given title with invalid parameters",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.scenario({
  "name": "Searching posts by title",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "name": "send get request with parameter \"baseURL\" and \"/posts\"",
  "keyword": "Given "
});
formatter.match({
  "location": "Api_Test.send_get_request_with_parameter_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search with the \"Sincere@april.biz\" as a title",
  "keyword": "When "
});
formatter.match({
  "location": "Api_Test.i_search_with_the_as_a_title(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The \"title\" should not not contains the given parameter",
  "keyword": "Then "
});
formatter.match({
  "location": "Api_Test.the_should_not_not_contains_the_given_parameter(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/jsonPlaceHolderAPI.feature");
formatter.feature({
  "name": "User Verification",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.scenario({
  "name": "Verify userName Information",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "name": "send get request with parameter \"username\", \"Delphine\", \"baseURL\" and \"/users\"",
  "keyword": "Given "
});
formatter.match({
  "location": "Api_Test.send_get_request_with_parameter_and(String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The status code should be 200 and the information is correct",
  "keyword": "When "
});
formatter.match({
  "location": "Api_Test.the_status_code_should_be_and_the_information_is_correct(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the respond Id Information of the user",
  "keyword": "Then "
});
formatter.match({
  "location": "Api_Test.get_the_respond_Id_Information_of_the_user()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Get the valid Id or Ids of the User after get posts request",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "name": "I have sent the get posts request of API with \"baseURL\" and \"/posts\"",
  "keyword": "Given "
});
formatter.match({
  "location": "Api_Test.i_have_sent_the_get_posts_request_of_API_with_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The status code should be 200 and the posts information is correct",
  "keyword": "When "
});
formatter.match({
  "location": "Api_Test.the_status_code_should_be_and_the_posts_information_is_correct(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I entered the query parameter of  \"id\"",
  "keyword": "When "
});
formatter.match({
  "location": "Api_Test.i_entered_the_query_parameter_of(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The related posts belong to correct user_Id is listed",
  "keyword": "And "
});
formatter.match({
  "location": "Api_Test.the_related_posts_belong_to_correct_user_Id_is_listed()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Validate the emails",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "name": "I have sent the get comments request of API with \"baseURL\" and \"/comments\"",
  "keyword": "Given "
});
formatter.match({
  "location": "Api_Test.i_have_sent_the_get_comments_request_of_API_with_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The status code should be 200 and comments the information is correct",
  "keyword": "When "
});
formatter.match({
  "location": "Api_Test.the_status_code_should_be_and_comments_the_information_is_correct(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I entered the query parameter of  \"id\" of Comments",
  "keyword": "When "
});
formatter.match({
  "location": "Api_Test.i_entered_the_query_parameter_of_of_Comments(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The email belongs to comments user Id is validated",
  "keyword": "And "
});
formatter.match({
  "location": "Api_Test.the_email_belongs_to_comments_user_Id_is_validated()"
});
formatter.result({
  "status": "passed"
});
});
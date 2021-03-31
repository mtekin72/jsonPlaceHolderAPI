package com.API_Project.step_definitions;

import com.API_Project.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Api_Test {

    Response responseUserName;
    Response responsePosts;
    Response responseComments;
    Map<String, Object> queryMap = new HashMap<>();
    Map<String, Object> queryMap1 = new HashMap<>();
    Map<String, Object> queryMap2 = new HashMap<>();
    List<Integer> idList;
    List<Integer> postIdlist;


    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }



    @Given("send get request with parameter {string}, {string}, {string} and {string}")
    public void send_get_request_with_parameter_and(String username, String name, String URL, String command) {

        queryMap.put(username, name);
        responseUserName = given().accept(ContentType.JSON)
                .and().queryParams(queryMap).log().all()
                .when().get(ConfigurationReader.get(URL) + command);
    }

    @When("The status code should be {int} and the information is correct")
    public void the_status_code_should_be_and_the_information_is_correct(Integer int1) {
        Assert.assertEquals(responseUserName.statusCode(), 200);
        Assert.assertEquals(responseUserName.contentType(), "application/json; charset=utf-8");
        Assert.assertTrue(queryMap.get("username").toString().equals("Delphine"));
        responseUserName.prettyPrint();
    }

    @Then("Get the respond Id Information of the user")
    public void get_the_respond_Id_Information_of_the_user() {
        idList=responseUserName.path("id");

        //Map format of Posts query for User Id (Id-9)
        queryMap1.put("userId", idList.get(0));
    }

    @When("I entered the query parameter of  {string}")
    public void i_entered_the_query_parameter_of(String user_ID) {
        idList=responseUserName.path(user_ID);
    }

    @When("The related posts belong to correct user_Id is listed")
    public void the_related_posts_belong_to_correct_user_Id_is_listed() {
        queryMap1.put("userId", idList.get(0));
    }

    @When("I entered the query parameter of  {string} of Comments")
    public void i_entered_the_query_parameter_of_of_Comments(String id) {

        List<Integer> postIdlist = responsePosts.path("id");

        // Iterating posts Id to get every single comment Id
        for (int i = 0; i < postIdlist.size(); i++) {

            queryMap2.put(id, postIdlist.get(i));


            // Assert that posts Id matches with Map query
            String commentsId = queryMap2.get("id").toString();
            Assert.assertEquals(responseComments.statusCode(), 200);
            Assert.assertTrue(postIdlist.get(i).toString().equals(commentsId));
        }


    }

    @When("The email belongs to comments user Id is validated")
    public void the_email_belongs_to_comments_user_Id_is_validated() {

        // According to comments Id, email for comments are listed individually
        List<String> emailAddressList = responseComments.path("email");

        for (String EmailAdd:emailAddressList ) {

            //Email Validation by isValidEmailAddress Method
            Assert.assertTrue(isValidEmailAddress(EmailAdd));
        }


    }

    @When("The status code should be {int} and the posts information is correct")
    public void the_status_code_should_be_and_the_posts_information_is_correct(int statusCode) {
        queryMap.put("username", "Delphine");
        responseUserName = given().accept(ContentType.JSON)
                .and().queryParams(queryMap).log().all()
                .when().get(ConfigurationReader.get("baseURL") + "/users");
        idList=responseUserName.path("id");
        Assert.assertEquals(responsePosts.statusCode(), statusCode);
        Assert.assertEquals(responsePosts.contentType(), "application/json; charset=utf-8");
        queryMap1.put("userId", idList.get(0));
        Assert.assertTrue(queryMap1.get("userId").equals(idList.get(0)));
    }

    @When("The status code should be {int} and comments the information is correct")
    public void the_status_code_should_be_and_comments_the_information_is_correct(int status_Code) {
        responsePosts = given().accept(ContentType.JSON)
                .and().queryParams(queryMap1).log().all()
                .when().get(ConfigurationReader.get("baseURL") + "/posts");
        Assert.assertEquals(responsePosts.statusCode(), status_Code);
        Assert.assertEquals(responsePosts.contentType(), "application/json; charset=utf-8");
//        Assert.assertTrue(queryMap1.get("userId").equals(idList.get(0)));
    }

    @Given("I have sent the get posts request of API with {string} and {string}")
    public void i_have_sent_the_get_posts_request_of_API_with_and(String URL, String command) {
        responsePosts = given().accept(ContentType.JSON)
                .and().queryParams(queryMap1).log().all()
                .when().get(ConfigurationReader.get(URL) + command);
    }

    @Given("I have sent the get comments request of API with {string} and {string}")
    public void i_have_sent_the_get_comments_request_of_API_with_and(String URL, String command) {
        responseComments = given().accept(ContentType.JSON)
                .and().queryParams(queryMap2)
                .when().get(ConfigurationReader.get(URL) + command);

    }

    }


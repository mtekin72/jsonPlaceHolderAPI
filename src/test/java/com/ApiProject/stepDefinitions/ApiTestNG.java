package com.ApiProject.stepDefinitions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ApiTestNG {
    public static String baseURL = "https://jsonplaceholder.typicode.com";

@Test
    public void getUserName() {
        //-UserName query(Map format)
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("username", "Delphine");
        Response responseUserName = given().accept(ContentType.JSON)
                .and().queryParams(queryMap).log().all()
                .when().get(baseURL + "/users");

        // Assert that Delphine is a username
        Assert.assertEquals(responseUserName.statusCode(), 200);
        Assert.assertEquals(responseUserName.contentType(), "application/json; charset=utf-8");
        Assert.assertTrue(queryMap.get("username").toString().equals("Delphine"));
        responseUserName.prettyPrint();

        List<Integer> idList=responseUserName.path("id");



        //Map format of Posts query for User Id
        Map<String, Object> queryMap1 = new HashMap<>();
        queryMap1.put("userId", idList.get(0));

        Response responsePosts = given().accept(ContentType.JSON)
                .and().queryParams(queryMap1).log().all()
                .when().get(baseURL + "/posts");


        // Assert that userId query for userId  is true
        Assert.assertEquals(responsePosts.statusCode(), 200);
        Assert.assertEquals(responsePosts.contentType(), "application/json; charset=utf-8");
        Assert.assertTrue(queryMap1.get("userId").equals(idList.get(0)));


        // List of posts for userId
        List<Integer> postIdlist = responsePosts.path("id");


        // Iterating posts Id to get every single comment Id
        for (int i = 0; i < postIdlist.size(); i++) {
            Map<String, Object> queryMap2 = new HashMap<>();
            queryMap2.put("id", postIdlist.get(i));
            Response responseComments = given().accept(ContentType.JSON)
                    .and().queryParams(queryMap2)
                    .when().get(baseURL + "/comments");

            // Assert that posts Id matches with Map query
            String commentsId = queryMap2.get("id").toString();
            Assert.assertEquals(responseComments.statusCode(), 200);
            Assert.assertTrue(postIdlist.get(i).toString().equals(commentsId));


            // According to comments Id, email for comments are listed individually
            List<String> emailAddressList = responseComments.path("email");

            for (String EmailAdd:emailAddressList ) {

                //Email Validation by isValidEmailAddress Method
                Assert.assertTrue(isValidEmailAddress(EmailAdd));
            }


        }

    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
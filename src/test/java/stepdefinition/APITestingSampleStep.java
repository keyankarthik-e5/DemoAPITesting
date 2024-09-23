package stepdefinition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import util.APIHelper;


import java.util.HashMap;
import java.util.Map;

public class APITestingSampleStep {

     Map<String,String> header = new HashMap<>();

     Response response;
     String petID = "60";
     String updatedname = "peggy";


    @Given("user creates get request")
    public void user_creates_get_request() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        header.put("Content-Type","application/json");
        System.out.println("Create Request method completed");
    }

    @When("user hits the get method")
    public  void user_hits_the_get_method() {
        // Write code here that turns the phrase above into concrete actions
        //response =  APIHelper.sendGetRequest("https://petstore.swagger.io/v2/store/inventory",header);
        System.out.println("get method started"+header);
       //response =  APIHelper.sendGetRequest("https://petstore.swagger.io/v2/store/inventory",header);
        response = APIHelper.sendGetRequest("https://petstore.swagger.io/v2/pet/5",header);
        System.out.println("Response is:"+response.asPrettyString());
    }

    @Then("user Asserts the response")
    public void user_asserts_the_response() {
        // Write code here that turns the phrase above into concrete acti
       int id = response.jsonPath().getInt("id");
        System.out.println("Actual:"+Integer.toString(id)+",Expected:5");
        System.out.println("Status code for get request is:"+response.getStatusCode());
        Assert.assertEquals("5",Integer.toString(id));

    }
    @Given("user creates post request")
    public void user_creates_post_request() throws JsonProcessingException {
        // Write code here that turns the phrase above into concrete actions
        header.put("Content-Type","application/json");

        String postbody = "{\n" +
                "    \"id\":" +petID+",\n" +
                "    \"category\": {\n" +
                "        \"id\": 33,\n" +
                "        \"name\": \"string\"\n" +
                "    },\n" +
                "    \"name\": \"doggie\",\n" +
                "    \"photoUrls\": [\n" +
                "        \"string\"\n" +
                "    ],\n" +
                "    \"tags\": [\n" +
                "        {\n" +
                "            \"id\": 84,\n" +
                "            \"name\": \"string\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"string\"\n" +
                "}";


       response = APIHelper.sendPostRequest("https://petstore.swagger.io/v2/pet",header,postbody);
    }
    @When("user hits the post request")
    public void user_hits_the_post_request() {

        System.out.println("response:"+response.asPrettyString());
    }
    @Then("user Asserts the post response")
    public void user_asserts_the_post_response() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        Assert.assertEquals(petID,response.jsonPath().get("id").toString());
    }

    @Given("user creates put request")
    public void user_creates_put_request() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        header.put("Content-Type","application/json");

    }
    @When("user hits put request")
    public void user_hits_put_request() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        //Map<String,Object> body = new HashMap<>();
        String body = "{\n" +
                "  \"id\":" +petID+",\n" +
                "  \"category\": {\n" +
                "    \"id\": 33,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\":\""+updatedname+"\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 84,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"string\"\n" +
                "}";
        System.out.println("put request:"+body);
        response = APIHelper.sendPutRequest("https://petstore.swagger.io/v2/pet",header,body);
        System.out.println("response:"+response.asPrettyString());
    }
    @Then("user Asserts the put response")
    public void user_asserts_the_put_response() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        Assert.assertEquals(updatedname,response.jsonPath().get("name"));
    }

    @Given("user creates the delete request")
    public void user_creates_the_delete_request() {
        // Write code here that turns the phrase above into concrete actions
        header.put("Content-Type","application/json");
    }
    @When("user hits the delete request")
    public void user_hits_the_delete_request() {
        // Write code here that turns the phrase above into concrete actions
        response = APIHelper.sendDeleteRequest("https://petstore.swagger.io/v2/pet/"+petID,header);
        System.out.println("response:"+response.asPrettyString());

    }
    @Then("user Asserts the delete response")
    public void user_asserts_the_delete_response() {
        // Write code here that turns the phrase above into concrete actions
      Assert.assertEquals(petID,response.jsonPath().get("message"));
    }

}

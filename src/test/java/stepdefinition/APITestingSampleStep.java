package stepdefinition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import payloads.PetPayload;
import util.APIHelper;
import util.AssertionUtil;
import util.HeaderUtil;
import util.JsonUtil;
import services.PetService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APITestingSampleStep {

    Response response;

    Map<String, Object> petData;
    private PetPayload pet;


    private static final Logger log =
            LogManager.getLogger(APITestingSampleStep.class);


    @Given("user creates get request")
    public void user_creates_get_request() {
        log.info("Get Request created");
    }

    @When("user hits the get method")
    public  void user_hits_the_get_method() {

        Map<String, Object> getPetData =
                (Map<String, Object>) Hooks.petData.get("getPet");
        int petId = ((Number) getPetData.get("id")).intValue();
        log.info("Executing GET pet request for petId: {}", petId);
        response = PetService.getPetById(Hooks.headers, petId);
        log.debug("GET Response: {}", response.asPrettyString());
    }

    @Then("user Asserts the response")
    public void user_asserts_the_response() {
        log.info("Get Response:"+response.asPrettyString());
        Map<String, Object> getPetData =
                (Map<String, Object>) Hooks.petData.get("getPet");
        AssertionUtil.assertIntField(
                response,
                "id",
                ((Number) getPetData.get("id")).intValue());
        AssertionUtil.assertStatusCode(
                response,
                ((Number) getPetData.get("statusCode")).intValue());

    }

    @Given("user creates post request")
    public void user_creates_post_request() throws JsonProcessingException {
        Map<String, Object> createPetData =
                (Map<String, Object>) Hooks.petData.get("createPet");

        pet = new PetPayload();
        pet.id = ((Number) createPetData.get("id")).intValue();
        pet.name = createPetData.get("name").toString();
        pet.status = createPetData.get("status").toString();
        pet.photoUrls = (List<String>) createPetData.get("photoUrls");

        log.info("Preparing POST request for pet creation with id: {}", pet.id);

        response = PetService.createPet(Hooks.headers, pet); }

    @When("user hits the post request")
    public void user_hits_the_post_request() {

        log.info("POST request executed successfully");

        AssertionUtil.assertNotNull(
                response,
                "POST response should not be null");
    }

    @Then("user Asserts the post response")
    public void user_asserts_the_post_response() {
        log.info("Post response:"+response.asPrettyString());
        AssertionUtil.assertIntField(
                response,
                "id",
                pet.id);
        AssertionUtil.assertStringField(response,"name",pet.name);
    }

    @Given("user creates put request")
    public void user_creates_put_request() {
        log.info("creating put request");
   }
    @When("user hits put request")
    public void user_hits_put_request() {

        Map<String, Object> updatePetData =
                (Map<String, Object>) Hooks.petData.get("updatePet");

        // Reuse the same pet object created earlier
        pet = new PetPayload();
        pet.name = updatePetData.get("name").toString();
        pet.id =((Number) updatePetData.get("id")).intValue();
        log.info("Preparing PUT request to update pet with id: {}", pet.id);
        log.debug("Updated pet details -> name: {}", pet.name);

        response = PetService.updatePet(Hooks.headers, pet);
    }
    @Then("user Asserts the put response")
    public void user_asserts_the_put_response() {
        log.info("Put Response:"+response.asPrettyString());
        AssertionUtil.assertStringField(
                response,
                "name",
                pet.name
        );
    }

    @Given("user creates the delete request")
    public void user_creates_the_delete_request() {
        log.info("Delete request headers set successfully");
    }
    @When("user hits the delete request")
    public void user_hits_the_delete_request() {
        Map<String, Object> createPetData =
                (Map<String, Object>) Hooks.petData.get("createPet");
        pet = new PetPayload();
        pet.id = ((Number) createPetData.get("id")).intValue();

        log.info("Executing DELETE request for pet id: {}", pet.id);

        response = PetService.deletePet(Hooks.headers, pet.id);
    }
    @Then("user Asserts the delete response")
    public void user_asserts_the_delete_response() {
        log.info("Delete response:"+response.asPrettyString());
        AssertionUtil.assertStringField(
                response,
                "message",
                String.valueOf(pet.id)
        );
    }

}

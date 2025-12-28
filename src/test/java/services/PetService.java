package services;

import constants.EndPoints;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import util.APIHelper;
import util.LoggerUtil;

import java.util.Map;

public class PetService {

    private static final Logger log =
            LoggerUtil.getLogger(PetService.class);

    public static Response getPetById(Map<String, String> headers, int id) {
        log.info("GET Pet by id: {}", id);
        return APIHelper.sendGetRequest(
                EndPoints.PET + "/" + id, headers);
    }

    public static Response createPet(Map<String, String> headers, Object body) {
        log.info("POST Create Pet");
        return APIHelper.sendPostRequest(
                EndPoints.PET, headers, body);
    }

    public static Response updatePet(Map<String, String> headers, Object body) {
        log.info("PUT Update Pet");
        return APIHelper.sendPutRequest(
                EndPoints.PET, headers, body);
    }

    public static Response deletePet(Map<String, String> headers, int id) {
        log.info("DELETE Pet id: {}", id);
        return APIHelper.sendDeleteRequest(
                EndPoints.PET + "/" + id, headers);
    }
}

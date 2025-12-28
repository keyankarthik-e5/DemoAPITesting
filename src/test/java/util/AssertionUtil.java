package util;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import stepdefinition.APITestingSampleStep;

public class AssertionUtil {

    private static final Logger log =
            LogManager.getLogger(AssertionUtil.class);

    public static void assertStatusCode(Response response, int expected) {
        Assert.assertEquals(
                "Status code mismatch",
                expected,
                response.getStatusCode());
    }

    public static void assertIntField(
            Response response, String jsonPath, int expected) {

        int actual = response.jsonPath().getInt(jsonPath);
        Assert.assertEquals(
                jsonPath + " mismatch",
                expected,
                actual);
        log.info("Expected value:"+expected+" Actual value:"+actual);
    }

    public static void assertNotNull(Object object, String message) {
        Assert.assertNotNull(message, object);
    }

    public static void assertStringField(
            Response response, String jsonPath, String expected) {

        String actual = response.jsonPath().getString(jsonPath);
        Assert.assertEquals(
                jsonPath + " mismatch",
                expected,
                actual
        );
        log.info("Expected value:"+expected+" Actual value:"+actual);
    }

}

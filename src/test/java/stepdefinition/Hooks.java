package stepdefinition;

import io.cucumber.java.Before;
import util.HeaderUtil;
import util.JsonUtil;
import java.util.Map;

public class Hooks {

    public static Map<String, Object> petData;
    public static Map<String, String> headers;

    @Before
    public void beforeScenario() throws Exception {
        // Initialize test data
        headers = HeaderUtil.defaultHeaders();
        petData = JsonUtil.readJson("testdata/petData.json");
        System.out.println("Before hook executed: petData initialized");
    }
}

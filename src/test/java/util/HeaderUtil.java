package util;

import java.util.HashMap;
import java.util.Map;

public class HeaderUtil {

    public static Map<String, String> defaultHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }
}

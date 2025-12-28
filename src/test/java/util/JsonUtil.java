package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.Map;

public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    public static Map<String, Object> readJson(String filePath) {
        try {
            InputStream input = JsonUtil.class
                    .getClassLoader()
                    .getResourceAsStream(filePath);
            return mapper.readValue(input, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read json: " + filePath);
        }
    }
}

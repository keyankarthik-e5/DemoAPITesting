package constants;

import config.ConfigManager;

public class EndPoints {

    public static final String BASE_URL = ConfigManager.get("base.url");
    public static final String PET = BASE_URL + "/pet";
    public static final String PET_BY_ID = PET + "/{id}";
}

package codacy.api.request;

public class Endpoints {

    public static final String API = "/2.0";

    public static final String API_TOKEN = "api-token";
    // This is deprecated and is kept for backward compatibility. It will be
    // removed in the context of CY-1272
    public static final String LEGACY_API_TOKEN = "api_token";

    public static String commit(String username, String projectName, String commitUUID) {
        return API + "/" + username + "/" + projectName + "/commit/" + commitUUID;
    }

    public static String commitDelta(String username, String projectName, String commitUUID) {
        return API + "/" + username + "/" + projectName + "/commit/" + commitUUID + "/delta";
    }

    public static String projectCheckForUpdates(String username, String projectName) {
        return API + "/" + username + "/" + projectName + "/update";
    }
}

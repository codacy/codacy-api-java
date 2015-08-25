package codacy.api.request;

public class Endpoints {

    public final static String API = "/2.0";

    public final static String API_TOKEN = "api_token";

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

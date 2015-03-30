package codacy.api;

import codacy.api.error.CodacyError;
import codacy.api.error.CodacyGenericException;
import codacy.api.request.ApiRequest;
import codacy.api.request.Endpoints;
import codacy.api.util.SSLHelper;
import com.google.gson.Gson;

import java.util.HashMap;

public class CodacyClient {

    private ApiRequest client = null;
    private String apiToken = null;

    static {
        try {
            SSLHelper.loadCerts();
        } catch (Exception e) {
        }
    }

    public CodacyClient(String apiToken) {
        this(apiToken, "https", "www.codacy.com", 443);
    }

    public CodacyClient(String apiToken, String scheme, String url, int port) {
        this.apiToken = apiToken;
        this.client = new ApiRequest(scheme, url, port);
    }


    public <T> T getRequest(String endpoint, Class<T> responseType) throws CodacyGenericException {
        return this.getRequest(endpoint, responseType, new HashMap<>());
    }

    public <T> T getRequest(String endpoint, Class<T> responseType,
                            HashMap<String, String> parameters) throws CodacyGenericException {
        return this.genericRequest("GET", endpoint, responseType, parameters);
    }

    public <T> T postRequest(String endpoint, Class<T> responseType) throws CodacyGenericException {
        return this.postRequest(endpoint, responseType, new HashMap<>());
    }

    public <T> T postRequest(String endpoint, Class<T> responseType,
                             HashMap<String, String> parameters) throws CodacyGenericException {
        return this.genericRequest("POST", endpoint, responseType, parameters);
    }

    public <T> T genericRequest(String requestType, String endpoint,
                                Class<T> responseType, HashMap<String, String> parameters) throws CodacyGenericException {
        parameters.put(Endpoints.API_TOKEN, this.apiToken);
        String response = null;

        try {
            response = this.client.request(requestType, endpoint, parameters);
        } catch (Exception e) {
            throw new CodacyGenericException(e);
        }

        Gson gson = new Gson();

        try {
            return gson.fromJson(response, responseType);
        } catch (Exception e) {
            try {
                CodacyError errorMsg = gson.fromJson(response, CodacyError.class);
                throw new CodacyGenericException(errorMsg.getError());
            } catch(Exception innerEx) {
                throw new CodacyGenericException(e);
            }
        }
    }
}

package codacy.api.services;

import codacy.api.CodacyClient;
import codacy.api.error.CodacyGenericException;
import codacy.api.error.CodacySuccess;
import codacy.api.request.Endpoints;

public class ProjectService {

    private CodacyClient client = null;

    public ProjectService(CodacyClient client) {
        this.client = client;
    }

    public void checkForUpdates(String username, String projectName) throws CodacyGenericException {
        this.client.postRequest(Endpoints.projectCheckForUpdates(username, projectName), CodacySuccess.class);
    }
}

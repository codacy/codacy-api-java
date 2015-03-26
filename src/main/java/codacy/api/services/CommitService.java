package codacy.api.services;

import codacy.api.CodacyClient;
import codacy.api.error.CodacyGenericException;
import codacy.api.model.Commit;
import codacy.api.request.Endpoints;

public class CommitService {

    private CodacyClient client = null;

    public CommitService(CodacyClient client) {
        this.client = client;
    }

    public Commit getCommit(String username, String projectName, String commitUUID) throws CodacyGenericException {
        return this.client.getRequest(Endpoints.commit(username, projectName, commitUUID), Commit.class);
    }
}

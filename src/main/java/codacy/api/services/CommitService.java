package codacy.api.services;

import codacy.api.CodacyClient;
import codacy.api.error.CodacyGenericException;
import codacy.api.error.CommitNotFoundException;
import codacy.api.model.CommitDelta;
import codacy.api.model.CommitOverview;
import codacy.api.request.Endpoints;

public class CommitService {

    private CodacyClient client = null;

    public CommitService(CodacyClient client) {
        this.client = client;
    }

    public CommitOverview getCommit(String username, String projectName, String commitUUID) throws CodacyGenericException, CommitNotFoundException {
        try {
            return this.client.getRequest(Endpoints.commit(username, projectName, commitUUID), CommitOverview.class);
        } catch (CodacyGenericException e) {
            if (e.getMessage().contains("could not retrieve commit data")) {
                throw new CommitNotFoundException(e);
            }
            throw e;
        }
    }

    public CommitDelta getCommitDelta(String username, String projectName, String commitUUID) throws CodacyGenericException, CommitNotFoundException {
        try {
            return this.client.getRequest(Endpoints.commitDelta(username, projectName, commitUUID), CommitDelta.class);
        } catch (CodacyGenericException e) {
            if (e.getMessage().contains("could not retrieve commit data")) {
                throw new CommitNotFoundException(e);
            }
            throw e;
        }
    }
}

package codacy.api.services;

import codacy.api.CodacyClient;
import codacy.api.model.CommitDelta;
import codacy.api.model.CommitOverview;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CommitServiceTest {

    String apiToken = System.getenv("CODACY_API_TOKEN");
    String username = "Codacy";
    String projectName = "JS-Tests";
    String commitUUID = "010a382bb436a089659d351aff061cc66205ead7";

    @Test
    public void testGetCommit() throws Exception {
        CodacyClient client = new CodacyClient(this.apiToken);
        CommitService service = new CommitService(client);

        CommitOverview commit = service.getCommit(username, projectName, commitUUID);

        assertNotNull(commit);
        assertNotNull(commit.getCommit());
        assertEquals(commit.getCommit().getGrade(), "D");
    }

    @Test
    public void testGetCommitDelta() throws Exception {
        CodacyClient client = new CodacyClient(this.apiToken);
        CommitService service = new CommitService(client);

        CommitDelta delta = service.getCommitDelta(username, projectName, commitUUID);

        assertNotNull(delta);
        assertNotNull(delta.getDelta());
        assertNotNull(delta.getDelta().getFiles());
        assertTrue(delta.getDelta().getFiles().size() > 0);
    }
}

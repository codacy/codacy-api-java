package codacy.api.services;

import codacy.api.CodacyClient;
import codacy.api.model.Commit;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CommitServiceTest {

    String apiToken = "";
    String username = "Codacy";
    String projectName = "JS-Tests";
    String commitUUID = "010a382bb436a089659d351aff061cc66205ead7";

    @Test
    public void testGetCommit() throws Exception {
        CodacyClient client = new CodacyClient(this.apiToken);
        CommitService service = new CommitService(client);

        Commit commit = service.getCommit(username, projectName, commitUUID);

        assertNotNull(commit);
        assertNotNull(commit.getDelta());
        assertNotNull(commit.getDelta().getFiles());
        assertTrue(commit.getDelta().getFiles().size() > 0);
    }
}

package codacy.api.services;

import codacy.api.CodacyClient;
import codacy.api.model.CommitDelta;
import codacy.api.model.CommitOverview;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CommitServiceTest {

    @Test
    public void testGetCommit() throws Exception {
        CodacyClient client = new CodacyClient(TestData.API_TOKEN);
        CommitService service = new CommitService(client);

        CommitOverview commit = service.getCommit(TestData.USERNAME, TestData.PROJECT_NAME, TestData.COMMIT_UUID);

        assertNotNull(commit);
        assertNotNull(commit.getCommit());
        assertEquals(commit.getCommit().getGrade(), "D");
    }

    @Test
    public void testGetCommitDelta() throws Exception {
        CodacyClient client = new CodacyClient(TestData.API_TOKEN);
        CommitService service = new CommitService(client);

        CommitDelta delta = service.getCommitDelta(TestData.USERNAME, TestData.PROJECT_NAME, TestData.COMMIT_UUID);

        assertNotNull(delta);
        assertNotNull(delta.getDelta());
        assertNotNull(delta.getDelta().getFiles());
        assertTrue(delta.getDelta().getFiles().size() > 0);
    }
}

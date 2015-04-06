package codacy.api.services;

import codacy.api.CodacyClient;
import codacy.api.error.CodacySuccess;
import codacy.api.model.CommitDelta;
import codacy.api.model.CommitOverview;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectServiceTest {

    @Test
    public void testCheckForUpdates() throws Exception {
        CodacyClient client = new CodacyClient(TestData.API_TOKEN);
        ProjectService service = new ProjectService(client);

        service.checkForUpdates(TestData.USERNAME, TestData.PROJECT_NAME);
    }

}

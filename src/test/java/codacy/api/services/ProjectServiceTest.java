package codacy.api.services;

import codacy.api.CodacyClient;
import org.junit.Test;

public class ProjectServiceTest {

    @Test
    public void testCheckForUpdates() throws Exception {
        CodacyClient client = new CodacyClient(TestData.API_TOKEN);
        ProjectService service = new ProjectService(client);

        service.checkForUpdates(TestData.USERNAME, TestData.PROJECT_NAME);
    }

}

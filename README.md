# Codacy API wrapper

[![Build Status](https://circleci.com/gh/codacy/codacy-api-java.png?style=shield&circle-token=:circle-token)](https://circleci.com/gh/codacy/codacy-api-java)

Java wrapper for the Codacy API. 

Example usage:


        CodacyClient client = new CodacyClient(apiToken);
        CommitService service = new CommitService(client);

        Commit commit = service.getCommit(username, projectName, commitUUID);

The API Token can be found under your [account settings](https://www.codacy.com/account/apiTokens).

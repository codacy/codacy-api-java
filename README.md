# Codacy API wrapper

[![Build Status](https://circleci.com/gh/codacy/codacy-api-java.png?style=shield&circle-token=:circle-token)](https://circleci.com/gh/codacy/codacy-api-java)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/82432b7685cc4d0e8f53109dff10a3a2)](https://www.codacy.com/app/Codacy/codacy-api-java)
[![Codacy Badge](https://api.codacy.com/project/badge/coverage/82432b7685cc4d0e8f53109dff10a3a2)](https://www.codacy.com/app/Codacy/codacy-api-java)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.codacy/codacy-api-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.codacy/codacy-api-java)

Java wrapper for the Codacy API.

### Usage

If you use Maven you can declare the dependency:

```
<dependency>
    <groupId>com.codacy</groupId>
    <artifactId>codacy-api-java</artifactId>
    <version>1.10</version>
</dependency>
```

Example usage:

```
CodacyClient client = new CodacyClient(apiToken);
CommitService service = new CommitService(client);

Commit commit = service.getCommit(username, projectName, commitUUID);
```

The API Token can be found under your [account settings](https://www.codacy.com/account/apiTokens).

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

## What is Codacy?

[Codacy](https://www.codacy.com/) is an Automated Code Review Tool that monitors your technical debt, helps you improve your code quality, teaches best practices to your developers, and helps you save time in Code Reviews.

### Among Codacy’s features:

 - Identify new Static Analysis issues
 - Commit and Pull Request Analysis with GitHub, BitBucket/Stash, GitLab (and also direct git repositories)
 - Auto-comments on Commits and Pull Requests
 - Integrations with Slack, HipChat, Jira, YouTrack
 - Track issues in Code Style, Security, Error Proneness, Performance, Unused Code and other categories

Codacy also helps keep track of Code Coverage, Code Duplication, and Code Complexity.

Codacy supports PHP, Python, Ruby, Java, JavaScript, and Scala, among others.

### Free for Open Source

Codacy is free for Open Source projects.

package codacy.api.model;

import java.util.List;

abstract class Commit {

    private String sha;
    private String state;
    private List<CommitUrl> urls;

    public String getSha() {
        return sha;
    }

    public String getState() {
        return state;
    }

    public List<CommitUrl> getUrls() {
        return urls;
    }
}

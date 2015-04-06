package codacy.api.model;

import java.util.List;

abstract class Commit {

    private String uuid;
    private String state;
    private List<CommitUrl> urls;

    public String getUuid() {
        return uuid;
    }

    public String getState() {
        return state;
    }

    public List<CommitUrl> getUrls() {
        return urls;
    }
}

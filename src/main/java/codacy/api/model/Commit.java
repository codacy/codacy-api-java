package codacy.api.model;

public class Commit {

    private String uuid;
    private String state;
    private CommitDelta delta;

    public String getUuid() {
        return uuid;
    }

    public String getState() {
        return state;
    }

    public CommitDelta getDelta() {
        return delta;
    }

}

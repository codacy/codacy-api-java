package codacy.api.model;


import java.util.ArrayList;

public class CommitDelta {

    private String newIssues;
    private String fixedIssues;
    private String complexity;
    private String nrClones;
    private ArrayList<FileDelta> files;

    public String getNewIssues() {
        return newIssues;
    }

    public String getFixedIssues() {
        return fixedIssues;
    }
    public String getComplexity() {
        return complexity;
    }

    public String getNrClones() {
        return nrClones;
    }

    public ArrayList<FileDelta> getFiles() {
        return files;
    }
}

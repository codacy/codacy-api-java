package codacy.api.model;


public class FileDelta {

    private String path;
    private String newIssues;
    private String fixedIssues;
    private String complexity;
    private String nrClones;

    public String getPath() {
        return path;
    }

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
}

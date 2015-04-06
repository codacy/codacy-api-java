package codacy.api.model;


public class FileDelta {

    private String path;
    private Integer newIssues;
    private Integer fixedIssues;
    private Integer complexity;
    private Integer coverage;
    private Integer nrClones;

    public String getPath() {
        return path;
    }

    public Integer getNewIssues() {
        return newIssues;
    }

    public Integer getFixedIssues() {
        return fixedIssues;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public Integer getNrClones() {
        return nrClones;
    }

    public Integer getCoverage() {
        return coverage;
    }
}

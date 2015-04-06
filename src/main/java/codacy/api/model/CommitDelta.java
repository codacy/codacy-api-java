package codacy.api.model;


import java.util.ArrayList;

public class CommitDelta extends Commit {

    private CommitDeltaData delta;

    public CommitDeltaData getDelta() {
        return delta;
    }

    public class CommitDeltaData {


        private Integer newIssues;
        private Integer fixedIssues;
        private Integer complexity;
        private Integer nrClones;
        private ArrayList<FileDelta> files;

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

        public ArrayList<FileDelta> getFiles() {
            return files;
        }
    }
}

package codacy.api.model;


import java.util.ArrayList;

public class CommitDelta extends Commit {

    private CommitDeltaData delta;

    public CommitDeltaData getDelta() {
        return delta;
    }

    public class CommitDeltaData {


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
}

package codacy.api.model;

public class CommitOverview extends Commit {

    private CommitOverviewData commit;

    public CommitOverviewData getCommit() {
        return commit;
    }


    public class CommitOverviewData {

        private Integer nrIssues;
        private String grade;
        private Integer complexity;
        private Integer nrDuplicateLines;
        private Integer coverage;

        public Integer getNrIssues() {
            return nrIssues;
        }

        public String getGrade() {
            return grade;
        }

        public Integer getComplexity() {
            return complexity;
        }
        public Integer getCoverage() {
            return coverage;
        }

        public Integer getDuplicateLines() {
            return nrDuplicateLines;
        }


    }
}

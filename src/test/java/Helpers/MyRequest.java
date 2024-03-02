package Helpers;

public class MyRequest {
        private String title;
        private boolean verified;
        private Addition addition;
        private int[] importantNumbers;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isVerified() {
            return verified;
        }

        public void setVerified(boolean verified) {
            this.verified = verified;
        }

        public Addition getAddition() {
            return addition;
        }

        public void setAddition(Addition addition) {
            this.addition = addition;
        }

        public int[] getImportantNumbers() {
            return importantNumbers;
        }

        public void setImportantNumbers(int[] importantNumbers) {
            this.importantNumbers = importantNumbers;
        }

        public static class Addition {
            private String additionalInfo;
            private int additionalNumber;

            public String getAdditionalInfo() {
                return additionalInfo;
            }

            public void setAdditionalInfo(String additionalInfo) {
                this.additionalInfo = additionalInfo;
            }

            public int getAdditionalNumber() {
                return additionalNumber;
            }

            public void setAdditionalNumber(int additionalNumber) {
                this.additionalNumber = additionalNumber;
            }
        }
}

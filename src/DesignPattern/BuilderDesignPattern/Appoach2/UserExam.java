package DesignPattern.BuilderDesignPattern.Appoach2;

import java.security.InvalidParameterException;

public class UserExam {
    private int englishMarks;
    private int mathsMarks;
    private int scienceMarks;
    private String name;

    private UserExam() {}

    public static UserExamBuilder getBuilder() {
        return new UserExamBuilder();
    }
    public static class UserExamBuilder {
        private int englishMarks;
        private int mathsMarks;
        private int scienceMarks;
        private String name;

        public void setEnglishMarks(int englishMarks) {
            this.englishMarks = englishMarks;
        }

        public void setMathsMarks(int mathsMarks) {
            this.mathsMarks = mathsMarks;
        }

        public void setScienceMarks(int scienceMarks) {
            this.scienceMarks = scienceMarks;
        }

        public void setName(String name) {
            this.name = name;
        }

        public UserExam build() {

            // 1. Validate the attributes
            if(englishMarks > 100 || scienceMarks > 100 || mathsMarks > 100) {
                throw  new InvalidParameterException("Marks cannot be greater than 100");
            }

            if(englishMarks + scienceMarks > 150) {
                throw  new InvalidParameterException("English plus Science marks cannot be greater than 150");
            }
            if(name.startsWith("0")) {
                throw  new InvalidParameterException("Name can't start with zero");
            }

            //2. create Parent
            UserExam userExam = new UserExam();
            userExam.englishMarks = this.englishMarks;
            userExam.scienceMarks = this.scienceMarks;
            userExam.mathsMarks = this.mathsMarks;
            userExam.name = this.name;

            return userExam;
        }
    }
}

// A static class means that you can access it without creating an object of it

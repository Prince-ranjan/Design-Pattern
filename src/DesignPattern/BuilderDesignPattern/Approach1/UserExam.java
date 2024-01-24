package DesignPattern.BuilderDesignPattern.Approach1;

import java.security.InvalidParameterException;

public class UserExam {
    private int englishMarks;
    private int mathsMarks;
    private int scienceMarks;
    private String name;

    public UserExam(UserExamParameter userExamParameter)
    {
        if(userExamParameter.englishMarks > 100 || userExamParameter.scienceMarks > 100 || userExamParameter.mathsMarks > 100) {
            throw  new InvalidParameterException("Marks cannot be greater than 100");
        }

        if(userExamParameter.name.startsWith("0")) {
            throw  new InvalidParameterException("Name can't start with zero");
        }

        this.englishMarks = userExamParameter.englishMarks;
        this.mathsMarks = userExamParameter.mathsMarks;;
        this.scienceMarks = userExamParameter.mathsMarks;
        this.name = userExamParameter.name;
    }
}

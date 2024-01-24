package DesignPattern.BuilderDesignPattern.Approach1;

public class Client {
    public static void main(String[] args) {
        UserExamParameter parameter =  new UserExamParameter();
        parameter.englishMarks =   120;
        parameter.name = "prince";

        UserExam userExam;

        try {
            userExam  = new UserExam(parameter);
        }
        catch (Exception exception) {
            System.out.println("Some parameters are wrong");
        }
    }
}
/*

Builder DP:-
lot of parameter,
validation on parameters,
immutable object

 */
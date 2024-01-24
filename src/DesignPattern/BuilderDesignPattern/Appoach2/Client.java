package DesignPattern.BuilderDesignPattern.Appoach2;

import DesignPattern.BuilderDesignPattern.Approach1.UserExamParameter;

public class Client {
    public static void main(String[] args) {

        DesignPattern.BuilderDesignPattern.Appoach2.UserExam userExam;

        try {
            userExam  = UserExam.getBuilder().build();
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
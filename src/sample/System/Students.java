package sample.System;

public class Students {
    private int Number;
    private String Course;

    public Students(int n , String c){
        Number = n;
        Course = c;
    }

    Students(Students stu){
        Number = stu.Number;
        Course = stu.Course;
    }

    public int getNumber() {
        return Number;
    }

    public String getCourse() {
        return Course;
    }

    public void setNumber(int num){
        Number = num;
    }
}

package sample.System;

public class Students {
    private int Number;
    private String Course;

    public Students(int n , String c){
        Number = n;
        Course = c;
    }

    public int getNumber() {
        return Number;
    }

    public String getCourse() {
        return Course;
    }
}

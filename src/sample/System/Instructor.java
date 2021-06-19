package sample.System;

import sample.Factory;

public class Instructor extends Factory {
    private String instructorName;
    private int instructorID;
    private String primaryCourse;
    private String secondaryCourse;
    private String preferredDay;
    private int preferredTime;

    public Instructor(){

    }

    public Instructor(int ID, String name, String priCourse, String secCourse, String day, int time){
        instructorID = ID;
        instructorName = name;
        primaryCourse = priCourse;
        secondaryCourse = secCourse;
        preferredDay = day;
        preferredTime = time;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public String getPrimaryCourse() {
        return primaryCourse;
    }

    public String getSecondaryCourse() {
        return secondaryCourse;
    }

    public String getPreferredDay() {
        return preferredDay;
    }

    public int getPreferredTime() {
        return preferredTime;
    }

    public String getInstructorName(){
        return instructorName;
    }

}

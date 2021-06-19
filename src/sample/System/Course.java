package sample.System;

public class Course {
    private String courseName;
    private int courseID;

    public Course(){

    }

    public Course(String Name, int ID){
        courseName = Name;
        courseID = ID;
    }

    //copy constructor
    Course(Course course){

    }

    public int getCourseID(){
        return courseID;
    }

    public String getCourseName(){
        return courseName;
    }

    public void printCourseInfo(){
        System.out.print("Course ID:    "+ courseID+ "  Course Name:    "+ courseName);
    }

}

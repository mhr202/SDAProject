package sample.System;

public class Instructor extends Factory {
    private String instructorName;
    private int instructorID;
    private String primaryCourse;
    private String secondaryCourse;
    private String preferredDay;
    private int preferredTime;
    private int maxPerDay;
    private boolean isFill;
    private boolean isPrefferedTime;

    public Instructor(){

    }

    //copy constructor
    Instructor(Instructor inst){
        instructorID = inst.instructorID;
        instructorName = inst.instructorName;
        primaryCourse =  inst.primaryCourse;
        secondaryCourse =  inst.secondaryCourse;
        preferredDay =  inst.preferredDay;
        preferredTime = inst.preferredTime;
        maxPerDay = inst.maxPerDay;
        isFill = inst.isFill;
    }
    public Instructor(int ID, String name, String priCourse, String secCourse, String day, int time){
        instructorID = ID;
        instructorName = name;
        primaryCourse = priCourse;
        secondaryCourse = secCourse;
        preferredDay = day;
        preferredTime = time;
        maxPerDay = 2;
        isFill = false;
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

    public boolean getisFill(){ return isFill; }

    public void ToogleIsFill(){ isFill = !isFill; }
    public void ToogleIsTime(){ isPrefferedTime = !isPrefferedTime; }

    public boolean getIsTime(){ return isPrefferedTime; }

    public String getInstructorName(){
        return instructorName;
    }

    public void print(){
        System.out.print(instructorID+ instructorName+ primaryCourse+ secondaryCourse+ preferredDay+ preferredTime);
    }


}

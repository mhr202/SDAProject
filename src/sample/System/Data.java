package sample.System;

public class Data {
    Instructor[] InstructorArray;
    Room[] RoomsArray;
    Course[] CoursesArray;
    Section[] SectionArray;
    int totalStudents;

    public Data(){

    }

    public Data(Instructor inst, Room rom, Course cours, int stu){

    }

    //getters
    public Course[] getCoursesArray() {
        return CoursesArray;
    }

    public Instructor[] getInstructorArray() {
        return InstructorArray;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public Room[] getRoomsArray() {
        return RoomsArray;
    }

    public Section[] getSectionArray() {
        return SectionArray;
    }

    //setters
    public void setInstructorArray(Instructor[] instructorArray) {
        InstructorArray = instructorArray;
    }

    public void setRoomsArray(Room[] roomsArray) {
        RoomsArray = roomsArray;
    }

    public void setCoursesArray(Course[] coursesArray) {
        CoursesArray = coursesArray;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public void setSectionArray(Section[] sectionArray) {
        SectionArray = sectionArray;
    }
}

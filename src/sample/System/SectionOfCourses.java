package sample.System;

public class SectionOfCourses {
    Section[] section = new Section[5];
    Course course;
    int sectionCount = 0;

    public SectionOfCourses(){

    }

    public SectionOfCourses(Section sec, Course cour){

    }

    public SectionOfCourses(Course coursew) {
        course = coursew;
    }

    public String getCourse() {
        return course.getCourseName();
    }

    public void addSection(Instructor inst, String sec, int room, int students , int time){
        section[sectionCount] = new Section(inst, sec, room, students , time);
        sectionCount++;
    }
}

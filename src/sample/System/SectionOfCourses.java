package sample.System;

public class SectionOfCourses {
    Section[] section = new Section[5];
    Course course;
    int sectionCount = 0;

    public SectionOfCourses(){

    }

    public SectionOfCourses(Section sec, Course cour){

    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void addSection(Instructor inst, String sec, int room, int students){
        section[sectionCount] = new Section(inst, sec, room, students);
        sectionCount++;
    }
}

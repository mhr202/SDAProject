package sample.System;

public class Section {
    Instructor instructor;
    String section;
    int room;
    int students = 0;

    public Section(){

    }
    public Section(Instructor inst, String sec, int r, int stu){
        instructor = inst;
        section = sec;
        room = r;
        students = stu;
    }
    public void getSectionInfo(){
        System.out.print("Instructor: "+ instructor+ " Section: "+section+ " Room: "+room+ " Students: "+students);
    }
}

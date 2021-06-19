package sample.System;

public class Section {
    Instructor instructor;
    String section;
    int room;
    int students;

    public Section(){

    }
    public Section(Instructor inst, String sec, int r, int stu){

    }
    public void getSectionInfo(){
        System.out.print("Instructor: "+ instructor+ " Section: "+section+ " Room: "+room+ " Students: "+students);
    }
}

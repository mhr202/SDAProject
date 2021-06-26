package sample.System;

public class Section {
    Instructor instructor;
    String section;
    int room;
    int students = 0;
    int time = 0;
    boolean is_preffered_taken = false;

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

    public void setTime(int t){
        time = t;
    }

    public int getTime(){
        return time;
    }

    public void setInstructor(Instructor x){
        instructor = x;
    }
    public void setSection(String sec){
        section = sec;
    }
    public void setRoom(int room){
        this.room = room;
    }
    public void setStudents(int std){
        students = std;
    }

    public String getInstructorName(){
        return instructor.getInstructorName();
    }

    public String getSection(){
        return section;
    }

    public int getRoom(){
        return room;
    }

    public int getStudets(){
        return students;
    }
}

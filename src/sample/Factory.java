package sample;

import sample.System.*;

import java.io.*;
import java.util.*;

public class Factory {

    Instructor[] instructorArray = new Instructor[100];
    Course[] courseArray = new Course[100];
    Room[] roomArray = new Room[100];
    Students[] studentArray = new Students[100];
    SectionOfCourses[] section =  new SectionOfCourses[10];
    int sectionOfCoursesCount = 0;
    int instructorCount = 0;
    int courseCount = 0;
    int roomCount = 0;
    int studentCount = 0;

    public static void main(String[] args) {
        read();
    }

    public static void read(){
        Factory x = new Factory();
        x.readInstructors();
        x.readCourses();
        x.writeStudents(123 , "AI");
        x.readRooms();
        x.readStudents();

        setSections(x);
    }

    public void readInstructors(){
        FileReader fr;
        String line = "";
        int count;
        try{
            fr = new FileReader("C:\\Users\\ahmad\\IdeaProjects\\SDAProject\\src\\sample\\Instructor.csv");
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) != null){
                String [] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[5]);
                instructorArray[instructorCount] = new Instructor(id , values[1] , values[2] , values[3] , values[4] , y);
                instructorCount++;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void readCourses(){
        FileReader fr;
        String line = "";
        int count;
        try{
            fr = new FileReader("C:\\Users\\ahmad\\IdeaProjects\\SDAProject\\src\\sample\\Courses.csv");
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) != null){
                String [] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                courseArray[courseCount] = new Course(values[1] , id);
                courseCount++;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readRooms(){
        FileReader fr;
        String line = "";
        int count;
        try{
            fr = new FileReader("C:\\Users\\ahmad\\IdeaProjects\\SDAProject\\src\\sample\\Rooms.csv");
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) != null){
                String [] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                int cap = Integer.parseInt(values[1]);
                roomArray[roomCount] = new Room(id , cap);
                roomCount++;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readStudents(){
        FileReader fr;
        String line = "";
        int count;
        try{
            fr = new FileReader("C:\\Users\\ahmad\\IdeaProjects\\SDAProject\\src\\sample\\Students.csv");
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) != null){
                String [] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                studentArray[studentCount] = new Students(id , values[1]);
                studentCount++;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeInstructors(String name , String primaryCourse , String secondaryCourse , String prefferedDay , int prefferenedTime){
        try {
            FileWriter fw = new FileWriter("C:\\Users\\ahmad\\IdeaProjects\\SDAProject\\src\\sample\\Instructor.csv" , true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);


            String line="";
            FileReader fr;
            fr = new FileReader("C:\\Users\\ahmad\\IdeaProjects\\SDAProject\\src\\sample\\Instructor.csv");
            BufferedReader br = new BufferedReader(fr);
            String [] values = null;
            while((line = br.readLine()) != null){
                values = line.split(",");
                int l = instructorArray.length;
                int id = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[5]);
            }
            int id = Integer.parseInt(values[0]) + 1;

            pw.println("\n"+id+","+name+","+primaryCourse+","+secondaryCourse+","+prefferedDay+","+prefferenedTime);
            pw.close();


        }
        catch (Exception e){}
    }

    public void writeCourses(String name){
        try {
            FileWriter fw = new FileWriter("C:\\Users\\ahmad\\IdeaProjects\\SDAProject\\src\\sampleCourses.csv" , true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);


            String line="";
            FileReader fr;
            fr = new FileReader("C:\\Users\\ahmad\\IdeaProjects\\SDAProject\\src\\sampleCourses.csv");
            BufferedReader br = new BufferedReader(fr);
            String [] values = null;
            while((line = br.readLine()) != null){
                values = line.split(",");
                int l = instructorArray.length;
                int id = Integer.parseInt(values[0]);
            }
            int id = Integer.parseInt(values[0]) + 1;

            pw.println("\n"+id+","+name);
            pw.close();


        }
        catch (Exception e){}
    }

    public void writeRooms(int number){
        try {
            FileWriter fw = new FileWriter("C:\\Users\\ahmad\\IdeaProjects\\SDAProject\\src\\sampleRooms.csv" , true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);


            String line="";
            FileReader fr;
            fr = new FileReader("C:\\Users\\ahmad\\IdeaProjects\\SDAProject\\src\\sampleRooms.csv");
            BufferedReader br = new BufferedReader(fr);
            String [] values = null;
            while((line = br.readLine()) != null){
                values = line.split(",");
                int l = instructorArray.length;
                int id = Integer.parseInt(values[0]);
            }
            int id = Integer.parseInt(values[0]) + 1;

            pw.println("\n"+id+","+number);
            pw.close();


        }
        catch (Exception e){}
    }

    public void writeStudents(int num , String course){
        try {
            FileWriter fw = new FileWriter("C:\\Users\\ahmad\\IdeaProjects\\SDAProject\\src\\sampleStudents.csv" , true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);


            pw.println("\n"+num+","+course);
            pw.close();


        }
        catch (Exception e){}
    }

    private static void setSections(Factory x){
        String Pricourse;
        for(int i = 0;i<x.instructorCount;i++){
            Pricourse =  x.instructorArray[i].getPrimaryCourse();
            int courseIndex = -1;
            for(int j=0;j<x.courseCount;j++){
                if(x.courseArray[j].getCourseName().equals(Pricourse)){
                    courseIndex = j;
                    break;
                }
            }
            if(courseIndex != -1) {
                int secOfCIndex = -1;
                for(int j=0;j<x.sectionOfCoursesCount;j++){
                    if(x.section[j].getCourse().equals(Pricourse)){
                        secOfCIndex = j;
                        break;
                    }
                }
                if(secOfCIndex == -1) {
                    Course temp = new Course(x.courseArray[courseIndex].getCourseName(), x.courseArray[courseIndex].getCourseID());
                    x.section[x.sectionOfCoursesCount] = new SectionOfCourses(temp);
                }
                for(int j=0;j<x.sectionOfCoursesCount;j++){
                    if(x.section[j].getCourse().equals(Pricourse)){
                        secOfCIndex = j;
                        break;
                    }
                }
                int roomEmptyIndex = -1;
                for(int j=0;j<x.roomCount;j++){
                    if(x.roomArray[j].inUse == false){
                        roomEmptyIndex = j;
                        break;
                    }
                }

                int studentsNo = 0;
                for(int j=0;j<x.studentCount;j++){
                    if(x.studentArray[j].getCourse().equals(Pricourse)){
                        if(x.studentArray[j].getNumber() > 0){
                            x.section[secOfCIndex].addSection(x.instructorArray[i], "A", roomEmptyIndex, 0);
                        }
                    }
                }

            }

        }
    }

    public void createSchedule(){

    }
}

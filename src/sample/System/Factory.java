package sample.System;

import java.io.*;
import java.util.Arrays;

public class Factory {

    Instructor[] instructorArray = new Instructor[100];
    Course[] courseArray = new Course[100];
    Room[] roomArray = new Room[100];
    Students[] studentArray = new Students[100];
    SectionOfCourses[] section =  new SectionOfCourses[10];
    Section[] sectionArray = new Section[100];
    int sectionOfCoursesCount = 0;
    int instructorCount = 0;
    int courseCount = 0;
    int roomCount = 0;
    int studentCount = 0;
    int TotalStudets = 0;
    int sectionCount = 0;
    int isSchedule = 0;
    String ScheduleText = "";

    public static void main(String[] args) {
        read();
    }

    public static void read(){
        Factory x = new Factory();
        x.readInstructors();
        x.readCourses();
        x.readRooms();
        x.readStudents();
        x.calculateTotalStudents();
        x.createSections();
    }

    public void readInstructors(){
        Arrays.fill(instructorArray, null);
        instructorCount = 0;
        FileReader fr;
        String line = "";
        int count;
        try{
            fr = new FileReader("C:\\Users\\Dell\\IdeaProjects\\SDAProjectnew\\src\\sample\\Instructor.csv");
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
        Arrays.fill(courseArray, null);
        courseCount = 0;
        FileReader fr;
        String line = "";
        int count;
        try{
            fr = new FileReader("C:\\Users\\Dell\\IdeaProjects\\SDAProjectnew\\src\\sample\\Courses.csv");
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

    public void readSections(){
        Arrays.fill(sectionArray, null);
        sectionCount = 0;
        FileReader fr;
        String line = "";
        int count;
        try{
            fr = new FileReader("C:\\Users\\Dell\\IdeaProjects\\SDAProjectnew\\src\\sample\\Sections.csv");
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) != null){
                String [] values = line.split(",");
                String sec = values[1];
                String instructor = values[0];
                int room = Integer.parseInt(values[2]);
                int std = Integer.parseInt(values[3]);
                int time = Integer.parseInt(values[4]);

                Instructor i = null;

                for(int j = 0 ; instructorArray[j] != null ; j++){
                    if(instructor.equals(instructorArray[j].getInstructorName())){
                       i = instructorArray[j];
                    }
                }

                sectionArray[sectionCount] = new Section(i , sec , room , std , time);
                sectionCount++;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readRooms(){
        Arrays.fill(roomArray, null);
        roomCount = 0;
        FileReader fr;
        String line = "";
        int count;
        try{
            fr = new FileReader("C:\\Users\\Dell\\IdeaProjects\\SDAProjectnew\\src\\sample\\Rooms.csv");
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
        Arrays.fill(studentArray, null);
        studentCount = 0;
        FileReader fr;
        String line = "";
        int count;
        try{
            fr = new FileReader("C:\\Users\\Dell\\IdeaProjects\\SDAProjectnew\\src\\sample\\Students.csv");
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
            FileWriter fw = new FileWriter("C:\\Users\\Dell\\IdeaProjects\\SDAProjectnew\\src\\sample\\Instructor.csv" , true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);


            String line="";
            FileReader fr;
            fr = new FileReader("C:\\Users\\Dell\\IdeaProjects\\SDAProjectnew\\src\\sample\\Instructor.csv");
            BufferedReader br = new BufferedReader(fr);
            String [] values = null;
            while((line = br.readLine()) != null){
                values = line.split(",");
                int l = instructorArray.length;
                int id = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[5]);
            }
            int id = Integer.parseInt(values[0]) + 1;

            pw.println(id+","+name+","+primaryCourse+","+secondaryCourse+","+prefferedDay+","+prefferenedTime);
            pw.close();


        }
        catch (Exception e){}
    }

    public void writeCourses(String name){
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Dell\\IdeaProjects\\SDAProjectnew\\src\\sample\\Courses.csv" , true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);


            String line="";
            FileReader fr;
            fr = new FileReader("C:\\Users\\Dell\\IdeaProjects\\SDAProjectnew\\src\\sample\\Courses.csv");
            BufferedReader br = new BufferedReader(fr);
            String [] values = null;
            while((line = br.readLine()) != null){
                values = line.split(",");
                int l = instructorArray.length;
                int id = Integer.parseInt(values[0]);
            }
            int id = Integer.parseInt(values[0]) + 1;

            pw.println(id+","+name);
            pw.close();


        }
        catch (Exception e){}
    }

    public void writeRooms(int number){
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Dell\\IdeaProjects\\SDAProjectnew\\src\\sample\\Rooms.csv" , true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);


            String line="";
            FileReader fr;
            fr = new FileReader("C:\\Users\\Dell\\IdeaProjects\\SDAProjectnew\\src\\sample\\Rooms.csv");
            BufferedReader br = new BufferedReader(fr);
            String [] values = null;
            while((line = br.readLine()) != null){
                values = line.split(",");
                int l = instructorArray.length;
                int id = Integer.parseInt(values[0]);
            }
            int id = Integer.parseInt(values[0]) + 1;

            pw.println(id+","+number);
            pw.close();


        }
        catch (Exception e){}
    }

    public void writeStudents(int num , String course){
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Dell\\IdeaProjects\\SDAProjectnew\\src\\sample\\Students.csv" , true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);


            pw.println(num+","+course);
            pw.close();


        }
        catch (Exception e){}
    }

    public void writeSections(String instructor , String sect , int room , int std , int time){
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Dell\\IdeaProjects\\SDAProjectnew\\src\\sample\\Sections.csv" , true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);


            pw.println(instructor+","+sect+","+room+","+std+","+time);
            pw.close();
        }
        catch (Exception e){}
    }

    public void writeSchedule(int time , Section sec , int room){
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Dell\\IdeaProjects\\SDAProjectnew\\src\\sample\\Schedule.csv" , true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);


            pw.println(time+","+sec.getSection()+","+sec.getInstructorName()+","+sec.getStudets()+","+room);
            pw.close();
        }
        catch (Exception e){}
    }


    public void calculateTotalStudents(){
        int tot = 0;
        for(int i =0 ; studentArray[i] != null; i++){
            tot += studentArray[i].getNumber();
        }
        TotalStudets = tot;
    }

    public void createSections() {
        int[][] TimeRoom = new int[100][100];
        for(int v = 0 ; v < roomCount ; v++){
            TimeRoom[v][0] = roomArray[v].getRoomID();
        }
        int timeroomCount = 1;

        String[][] TimeInst = new String [100][100];
        for(int v = 0 ; v < instructorCount ; v++){
            TimeInst[v][0] = instructorArray[v].getInstructorName();
        }
        int timeinstCount = 1;

        int ic = instructorCount;
        int cc = courseCount;
        int rc = roomCount;
        int stc = studentCount;
        int i = 0;
        int room = 0;
        int max = 0;
        String[][] secNames = new String[100][100];
        //SETTING SECTION NAMES
        for(int j = 0 ; courseArray[j] != null ; j++){
            secNames[j][0] = courseArray[j].getCourseName();
        }

        String[][] stdCourseCount = new String[100][100];
        //COURSE STUDENT COUNT
        for(int j = 0 ; studentArray[j] != null ; j++ ){
            stdCourseCount[j][0] = studentArray[j].getCourse();
            stdCourseCount[j][1] = String.valueOf(studentArray[j].getNumber());
        }

        while (true) {
            //CHECK IF DATA IS AVAILABLE
            if (TotalStudets <= 0) {
                ScheduleText = "No More Students";
                break;
            }
            if (roomCount <= room) {
                ScheduleText = "No More Rooms Left";
                break;
            }
            if (courseCount <= 0) {
                ScheduleText = "No More Courses Left";
                break;
            }
            if (ic <= 0) {
                ScheduleText = "No More Instructors Left";
                break;
            }
            Section [] sect = new Section[100];
            //GETTING PREFERED COURSE FROM INSTRUCTOR AND CREATING SECTION
            String preffered = instructorArray[i].getPrimaryCourse();
            Room currRoom;



            int i1 = -1;
            int ccount = 0;
            for(int k = 0; stdCourseCount[k][0] != null ; k++ ){
                if(stdCourseCount[k][0].equals(preffered)){
                    i1 = k;
                    ccount = Integer.parseInt(stdCourseCount[k][1]);
                }
            }

            if(ccount > 0) {
                int ti = 0;
                int o = 0;
                int flag = 0;
                Section sec = new Section();
                String sn = "";
                for (int j = 0; j < courseCount; j++) {
                    if (studentArray[j].getCourse().equals(preffered)) {
                        currRoom = roomArray[room];
                        flag = 1;
                        //CREATING A SECTION
                        sec.setInstructor(instructorArray[i]);
                        sec.setRoom(currRoom.getRoomID());
                        sec.setSection(studentArray[i].getCourse());
                        int cap = currRoom.getRoomCapacity();
                        if (studentArray[j].getNumber() > cap) {
                            studentArray[j].setNumber(studentArray[j].getNumber() - cap);
                            sec.setStudents(cap);
                            ccount = ccount - cap;
                        } else {
                            sec.setStudents(studentArray[j].getNumber());
                            studentArray[j].setNumber(0);
                            ccount = ccount - cap;
                        }
                        stdCourseCount[i1][1] = String.valueOf(ccount);
                        //FINDING AND ASSIGNING SECTION NAMES
                        int index = -1;
                        for (int k = 0; secNames[k][0] != null; k++) {
                            if (secNames[k][0].equals(studentArray[j].getCourse())) {
                                int count = 0;
                                for (int l = 0; secNames[k][l] != null; l++) {
                                    count++;
                                }
                                secNames[k][count] = String.valueOf(count);
                                String aa = String.valueOf((char) (count + 64));
                                sn = secNames[k][0] + "-" + aa;
                            }
                        }
                        sec.setSection(sn);
                        ti = instructorArray[i].getPreferredTime();
                        int roomno = 1;
                        while(true) {
                            readSections();
                            if(!instructorArray[i].getIsTime()) {
                                int gg = 0;
                                while(roomno <= roomCount) {
                                    if (!SearchSection(sectionArray, ti, currRoom.getRoomID())) {
                                        if(!SearchInTImeRoom(TimeRoom , roomno , ti)) {
                                            if(!SearchInTImeInst(TimeInst , instructorArray[i].getInstructorName() , ti)) {
                                                sec.setTime(ti);
                                                instructorArray[i].ToogleIsTime();
                                                gg = 1;
                                                TimeRoom[currRoom.getRoomID()][timeroomCount] = ti;
                                                timeroomCount++;
                                                TimeInst[currRoom.getRoomID()][timeroomCount] = String.valueOf(ti);
                                                timeinstCount++;
                                                sec.setRoom(roomno);
                                                break;
                                            }
                                        }
                                        else {
                                            roomno++;
                                        }
                                    }
                                    else {
                                        roomno++;
                                    }
                                }
                                if(gg == 1){
                                    break;
                                }
                                else {
                                    if (!SearchSection(sectionArray, ti, currRoom.getRoomID())) {
                                        if(!SearchInTImeRoom(TimeRoom , currRoom.getRoomID() , ti)) {
                                            if(!SearchInTImeInst(TimeInst , instructorArray[i].getInstructorName() , ti)) {
                                                sec.setTime(ti);
                                                TimeRoom[currRoom.getRoomID()][timeroomCount] = ti;
                                                timeroomCount++;
                                                TimeInst[currRoom.getRoomID()][timeroomCount] = String.valueOf(ti);
                                                timeinstCount++;
                                                break;
                                            }
                                        }
                                    }
                                }

                            }
                            else {
                                if(ti != instructorArray[i].getPreferredTime()){
                                    if (!SearchSection(sectionArray, ti, currRoom.getRoomID())) {
                                        if(!SearchInTImeInst(TimeInst , instructorArray[i].getInstructorName() , ti)) {
                                            while (true){
                                                if(!SearchInTImeRoom(TimeRoom , currRoom.getRoomID() , ti))
                                                    break;
                                                ti++;
                                            }
                                            sec.setTime(ti);

                                            TimeRoom[currRoom.getRoomID()][timeroomCount] = ti;
                                            timeroomCount++;
                                            TimeInst[currRoom.getRoomID()][timeroomCount] = String.valueOf(ti);
                                            timeinstCount++;
                                            break;
                                        }
                                    }
                                }
                            }
                            if(ti==6)
                                ti = 8;
                            else ti++;
                        }

                        sect[i] = sec;
                        writeSections(sec.getInstructorName(), sec.getSection(), sec.getRoom(), sec.getStudets() , sec.getTime());
                        o = 1;
                        break;
                    }
                }
                if(ti >= 18) {
                    room++;
                    max++;
                    o = 0;
                }
                else {
                    ti++;
                    max++;
                    o = 0;
                }
            }
            else {i++;}
            if(max >= 2 ){
                i++;
                max = 0;
                ic--;
            }
        }

        if(TotalStudets > 0){
            i = 0;
            while (instructorArray[i] != null) {
                //CHECK IF DATA IS AVAILABLE
                if (TotalStudets <= 0) {
                    ScheduleText = "No More Students";
                    break;
                }
                if (roomCount <= room) {
                    ScheduleText = "No More Rooms Left";
                    break;
                }
                if (courseCount <= 0) {
                    ScheduleText = "No More Courses Left";
                    break;
                }
                if (instructorCount <= 0) {
                    ScheduleText = "No More Instructors Left";
                    break;
                }
                Section [] sect = new Section[100];
                //GETTING PREFERED COURSE FROM INSTRUCTOR AND CREATING SECTION

                String preffered = instructorArray[i].getSecondaryCourse();
                Room currRoom;

                int i1 = -1;
                int ccount = 0;
                for(int k = 0; stdCourseCount[k][0] != null ; k++ ){
                    if(stdCourseCount[k][0].equals(preffered)){
                        i1 = k;
                        ccount = Integer.parseInt(stdCourseCount[k][1]);
                    }
                }

                if(ccount > 0) {
                    int o = 0;
                    int flag = 0;
                    Section sec = new Section();
                    String sn = "";
                    for (int j = 0; j < courseCount; j++) {
                        if (studentArray[j].getCourse().equals(preffered)) {
                            currRoom = roomArray[room];
                            flag = 1;
                            //CREATING A SECTION
                            sec.setInstructor(instructorArray[i]);
                            sec.setRoom(currRoom.getRoomID());
                            int cap = currRoom.getRoomCapacity();
                            if (studentArray[i].getNumber() > cap) {
                                studentArray[i].setNumber(studentArray[i].getNumber() - cap);
                                sec.setStudents(cap);
                                ccount = ccount - cap;
                            } else {
                                sec.setStudents(studentArray[j].getNumber());
                                studentArray[j].setNumber(0);
                                ccount = ccount - cap;
                            }
                            stdCourseCount[i1][1] = String.valueOf(ccount);
                            //FINDING AND ASSIGNING SECTION NAMES
                            int index = -1;
                            for (int k = 0; secNames[k][0] != null; k++) {
                                if (secNames[k][0].equals(studentArray[j].getCourse())) {
                                    int count = 0;
                                    for (int l = 0; secNames[k][l] != null; l++) {
                                        count++;
                                    }
                                    secNames[k][count] = String.valueOf(count);
                                    String aa = String.valueOf((char) (count + 64));
                                    sn = secNames[k][0] + "-" + aa;
                                }
                            }
                            sec.setSection(sn);

                            int ti = instructorArray[i].getPreferredTime();
                            int roomno = 1;
                            while(true) {
                                readSections();
                                if(!instructorArray[i].getIsTime()) {
                                    int gg = 0;
                                    while(roomno <= roomCount) {
                                        if (!SearchSection(sectionArray, ti, currRoom.getRoomID())) {
                                            if(!SearchInTImeRoom(TimeRoom , roomno , ti)) {
                                                if(!SearchInTImeInst(TimeInst , instructorArray[i].getInstructorName() , ti)) {
                                                    sec.setTime(ti);
                                                    instructorArray[i].ToogleIsTime();
                                                    gg = 1;
                                                    TimeRoom[currRoom.getRoomID()][timeroomCount] = ti;
                                                    timeroomCount++;
                                                    TimeInst[currRoom.getRoomID()][timeroomCount] = String.valueOf(ti);
                                                    timeinstCount++;
                                                    sec.setRoom(roomno);
                                                    break;
                                                }
                                            }
                                        }
                                        else {
                                            roomno++;
                                        }
                                    }
                                    if(gg == 1){
                                        break;
                                    }
                                    else {
                                        if (!SearchSection(sectionArray, ti, currRoom.getRoomID())) {
                                            if(!SearchInTImeRoom(TimeRoom , currRoom.getRoomID() , ti)) {
                                                if(!SearchInTImeInst(TimeInst , instructorArray[i].getInstructorName() , ti)) {
                                                    sec.setTime(ti);
                                                    TimeRoom[currRoom.getRoomID()][timeroomCount] = ti;
                                                    timeroomCount++;
                                                    TimeInst[currRoom.getRoomID()][timeroomCount] = String.valueOf(ti);
                                                    timeinstCount++;
                                                    break;
                                                }
                                            }
                                        }
                                    }

                                }
                                else {
                                    if(ti != instructorArray[i].getPreferredTime()){
                                        if (!SearchSection(sectionArray, ti, currRoom.getRoomID())) {
                                            if(!SearchInTImeInst(TimeInst , instructorArray[i].getInstructorName() , ti)) {
                                                ti++;
                                                while (true){
                                                    if(!SearchInTImeRoom(TimeRoom , currRoom.getRoomID() , ti))
                                                        break;
                                                    ti++;
                                                }
                                                sec.setTime(ti);

                                                TimeRoom[currRoom.getRoomID()][timeroomCount] = ti;
                                                timeroomCount++;
                                                TimeInst[currRoom.getRoomID()][timeroomCount] = String.valueOf(ti);
                                                timeinstCount++;
                                                break;
                                            }
                                        }
                                    }
                                }
                                if(ti==6)
                                    ti = 8;
                                else ti++;
                            }


                            sect[i] = sec;
                            writeSections(sec.getInstructorName(), sec.getSection(), sec.getRoom(), sec.getStudets() , sec.getTime());
                            o = 1;
                            break;
                        }
                    }
                    room++;
                    max++;
                    o = 0;
                }
                else {i++;}
                if(max >= 2 ){
                    i++;
                    max = 0;
                    instructorCount--;
                }
            }
        }
    }

    public void setTimeSections(Section a){
        readSections();
        int i = 0;
        while(instructorArray[i] != null){
            Instructor ins = instructorArray[i];
            int time = ins.getPreferredTime();
            Section [] insSec = new Section[100];
            int insSecCount = 0;
            for(int k = 0 ; sectionArray[k] != null ; k++){
                if(ins.getInstructorName().equals(sectionArray[k].getInstructorName())){
                    insSec[insSecCount] = sectionArray[k];
                    insSecCount++;
                }
            }
            Allocation [] alls = new Allocation[100];

            int o = 0;
            while(o < insSecCount){
                int k = 0;
                int t = ins.getPreferredTime();
                while(true) {

                    if(!SearchAllo(alls , t)) {
                        alls[o] = new Allocation(t, insSec[k], insSec[k].getRoom());
                        writeSchedule(t, insSec[o], insSec[o].getRoom());
                        break;
                    }
                    if(t==6)
                        t = 8;
                    else t++;
                }
                o++;
            }
            i++;
        }
    }

    public boolean SearchAllo(Allocation[] Allo, int key){
        for (int i = 0 ; Allo[i] != null ; i++){
            if(Allo[i].getTime() == key) {
                return true;
            }
        }
        return false;
    }

    public boolean SearchSection(Section[] Allo, int key , int room){
        for (int i = 0 ; Allo[i] != null ; i++){
            if(Allo[i].getTime() == key && Allo[i].getRoom() == room) {
                return true;
            }
        }
        return false;
    }

    public boolean SearchInTImeRoom(int [][] time , int room , int ti){
        int i = 0;
        while(true){
            if(time[i][0] == room){
                break;
            }
            i++;
        }
        for(int x = 0; x <= 10 ; x++){
            if(time[i][x] == ti)
                return true;
        }
        return false;
    }

    public boolean SearchInTImeInst(String [][] time , String inst , int ti){
        int i = 0;
        while(true){
            if(time[i][0].equals(inst)){
                break;
            }
            i++;
        }
        for(int x = 0; x <= 10 ; x++){
            if(time[i][x] != null && time[i][x].equals(String.valueOf(ti)))
                return true;
        }
        return false;
    }
}

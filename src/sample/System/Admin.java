package sample.System;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Admin extends Application  {

    Stage window;
    Scene AdminPage, InstructorInfo, CourseInfo, RoomsInfo, StudentsInfo, ScheduleInfo;
    Scene AddInstructor, AddCourse, AddRoom, AddStudents;
    Factory fc = new Factory();
    private TableView table = new TableView<Instructor>();
    private TableView tableC = new TableView<Course>();
    private TableView tableR = new TableView<Room>();
    private TableView tableS = new TableView<Students>();
    private TableView tableSch = new TableView<Section>();

    private final ObservableList<Instructor> data = FXCollections.observableArrayList();
    private final ObservableList<Course> dataC = FXCollections.observableArrayList();
    private final ObservableList<Room> dataR = FXCollections.observableArrayList();
    private final ObservableList<Students> dataS = FXCollections.observableArrayList();
    private final ObservableList<Section> dataSch = FXCollections.observableArrayList();


    @Override
    public void start(Stage primaryStage) {

        fc.readInstructors();
        fc.readCourses();
        fc.readStudents();
        fc.readRooms();

        window = primaryStage;

        //Create Admin Page Buttons
        Label AdminLabel = new Label("Admin Page");
        Button AddInstructor = new Button("Instructor");
        AddInstructor.setOnAction(e -> window.setScene(InstructorInfo));
        Button AddCourse = new Button("Course");
        AddCourse.setOnAction(e -> window.setScene(CourseInfo));
        Button AddRoom = new Button("Room");
        AddRoom.setOnAction(e -> window.setScene(RoomsInfo));
        Button AddStudents = new Button("Students");
        AddStudents.setOnAction(e -> window.setScene(StudentsInfo));
        Button CreateSchedule = new Button("Create Schedule");
        CreateSchedule.setOnAction(e -> window.setScene(ScheduleInfo));

        //set Admin Page Scene Layout
        VBox layoutAdminPage = new VBox(20);
        layoutAdminPage.getChildren().addAll(AdminLabel, AddInstructor, AddCourse, AddRoom, AddStudents, CreateSchedule);
        AdminPage = new Scene(layoutAdminPage, 600, 400);

        //CreateALl Other Scenes
        CreateTableScenes();

        window.setScene(AdminPage);
        window.setTitle("Admin");
        window.show();
    }

    private void CreateTableScenes() {
        //InstructorInfo Scene
        extractedInstructorInfo();

        //CourseInfo Scene
        extractedCourseInfo();

        //room
        extractedRoomsInfo();

        //student
        extractedStudentInfo();

        //Schedule
        extractedCreateSchedule();
    }

    private void extractedCreateSchedule() {
        Button BackToAdminSch = new Button("Back To Admin");
        BackToAdminSch.setOnAction(e -> window.setScene(AdminPage));

        VBox layoutInfoSch = new VBox();
        tableSch.setEditable(true);

        dataSch.clear();

        int secCount = 0;
        fc.readSections();
        for(int i = 0 ; fc.sectionArray[i] != null ; i++){
            secCount++;
        }

        System.out.print(secCount);
        for(int i=0; i<fc.sectionCount; i++){
            dataSch.addAll(FXCollections.observableArrayList(
                    new Section(fc.sectionArray[i])));
        }



        TableColumn NameCol = new TableColumn("Name");
        NameCol.setCellValueFactory(new PropertyValueFactory<Section,String>("instructorName"));
        TableColumn SecSectionCol = new TableColumn("Section");
        SecSectionCol.setCellValueFactory(new PropertyValueFactory<Section,String>("section"));
        TableColumn PreferredStudentsCol = new TableColumn("Students");
        PreferredStudentsCol.setCellValueFactory(new PropertyValueFactory<Section,String>("students"));
        TableColumn PreferredRoomCol = new TableColumn("Room");
        PreferredRoomCol.setCellValueFactory(new PropertyValueFactory<Section,String>("room"));
        TableColumn PreferredTimeCol = new TableColumn("Time");
        PreferredTimeCol.setCellValueFactory(new PropertyValueFactory<Section,String>("time"));

        tableSch.setItems(dataSch);
        tableSch.getColumns().addAll(NameCol, SecSectionCol, PreferredStudentsCol, PreferredRoomCol, PreferredTimeCol);

        layoutInfoSch.getChildren().addAll(tableSch, BackToAdminSch);
        ScheduleInfo = new Scene(layoutInfoSch, 600, 400);
    }

    private void extractedInstructorInfo() {

        Button BackToAdminI = new Button("Back To Admin");
        BackToAdminI.setOnAction(e -> window.setScene(AdminPage));
        Button AddI = new Button("Add Instructor");
        AddI.setOnAction(e -> window.setScene(AddInstructor));
        VBox layoutInfo = new VBox();
        table.setEditable(true);

        data.clear();
        for(int i=0; i<fc.instructorCount; i++){
            data.addAll(FXCollections.observableArrayList(
                    new Instructor(fc.instructorArray[i])));
        }

        TableColumn IDCol = new TableColumn("ID");
        IDCol.setCellValueFactory(new PropertyValueFactory<Instructor,String>("instructorID"));
        TableColumn NameCol = new TableColumn("Name");
        NameCol.setCellValueFactory(new PropertyValueFactory<Instructor,String>("instructorName"));
        TableColumn PriCourseCol = new TableColumn("Primary Course");
        PriCourseCol.setCellValueFactory(new PropertyValueFactory<Instructor,String>("primaryCourse"));
        TableColumn SecCourseCol = new TableColumn("Secondary Course");
        SecCourseCol.setCellValueFactory(new PropertyValueFactory<Instructor,String>("secondaryCourse"));
        TableColumn PreferredDayCol = new TableColumn("Preferred Day");
        PreferredDayCol.setCellValueFactory(new PropertyValueFactory<Instructor,String>("preferredDay"));
        TableColumn PreferredTimeCol = new TableColumn("Preferred Time");
        PreferredTimeCol.setCellValueFactory(new PropertyValueFactory<Instructor,String>("preferredTime"));

        table.setItems(data);
        table.getColumns().addAll(IDCol, NameCol, PriCourseCol, SecCourseCol, PreferredDayCol, PreferredTimeCol);

        layoutInfo.getChildren().addAll(table, BackToAdminI, AddI);
        InstructorInfo = new Scene(layoutInfo, 600, 400);

        //Add Instructor Scene
        AddInstructor();
    }

    private void AddInstructor() {
        TextField IName = new TextField();
        TextField IPriC = new TextField();
        TextField ISecC = new TextField();
        TextField IDay = new TextField();
        TextField ITime = new TextField();
        Button BackToIInfo = new Button("Back To Instructor");
        BackToIInfo.setOnAction(e -> window.setScene(InstructorInfo));
        Button AddB = new Button("Add");
        AddB.setOnAction(e ->
                {
                    String Name = IName.getText();
                    String PriC = IPriC.getText();
                    String SecC = ISecC.getText();
                    String Day = IDay.getText();
                    int Time = Integer.parseInt(ITime.getText());

                    System.out.print(Name+PriC+SecC+Day+Time);
                    fc.writeInstructors(Name, PriC, SecC, Day, Time);
                    fc.readInstructors();
                    CreateTableScenes();
                }
        );

        VBox layoutAddI = new VBox();
        layoutAddI.getChildren().addAll(BackToIInfo,
                new Label("Instructor Name"),
                IName,
                new Label("Primary Course"),
                IPriC,
                new Label("Secondary Course"),
                ISecC,
                new Label("Preferred Day"),
                IDay,
                new Label("Preferred Time"),
                ITime,
                AddB);
        AddInstructor = new Scene(layoutAddI, 600, 400);
    }

    private void extractedCourseInfo() {
        Button BackToAdminC = new Button("Back To Admin");
        BackToAdminC.setOnAction(e -> window.setScene(AdminPage));
        Button AddC = new Button("Add Course");
        AddC.setOnAction(e -> window.setScene(AddCourse));
        VBox layoutInfoC = new VBox();
        tableC.setEditable(true);

        dataC.clear();
        for(int i=0; i<fc.courseCount; i++){
            dataC.addAll(FXCollections.observableArrayList(
                    new Course(fc.courseArray[i])));
        }

        TableColumn IDCol = new TableColumn("ID");
        IDCol.setCellValueFactory(new PropertyValueFactory<Course,String>("courseID"));
        TableColumn NameCol = new TableColumn("Name");
        NameCol.setCellValueFactory(new PropertyValueFactory<Course,String>("courseName"));

        tableC.setItems(dataC);
        tableC.getColumns().addAll(IDCol, NameCol);

        layoutInfoC.getChildren().addAll(tableC, BackToAdminC, AddC);
        CourseInfo = new Scene(layoutInfoC, 600, 400);

        //Add Course
        AddCourse();
    }

    private void AddCourse() {
        TextField IName = new TextField();
        Button BackToCInfo = new Button("Back To Course");
        BackToCInfo.setOnAction(e -> window.setScene(CourseInfo));
        Button AddC = new Button("Add");
        AddC.setOnAction(e ->
                {
                    String Name = IName.getText();

                    System.out.print(Name);
                    fc.writeCourses(Name);
                    fc.readCourses();
                    CreateTableScenes();
                }
        );

        VBox layoutAddC = new VBox();
        layoutAddC.getChildren().addAll(BackToCInfo,
                new Label("Course Name"),
                IName,
                AddC);
        AddCourse = new Scene(layoutAddC, 600, 400);
    }

    private void extractedRoomsInfo() {
        Button BackToAdminR = new Button("Back To Admin");
        BackToAdminR.setOnAction(e -> window.setScene(AdminPage));
        Button AddR = new Button("Add Room");
        AddR.setOnAction(e -> window.setScene(AddRoom));
        VBox layoutInfoR = new VBox();
        tableR.setEditable(true);

        dataR.clear();
        for(int i=0; i<fc.roomCount; i++){
            dataR.addAll(FXCollections.observableArrayList(
                    new Room(fc.roomArray[i])));
        }

        TableColumn IDCol = new TableColumn("ID");
        IDCol.setCellValueFactory(new PropertyValueFactory<Room,String>("roomID"));
        TableColumn NameCol = new TableColumn("Capacity");
        NameCol.setCellValueFactory(new PropertyValueFactory<Room,String>("roomCapacity"));
        TableColumn inUseCol = new TableColumn("In Use");
        NameCol.setCellValueFactory(new PropertyValueFactory<Room,Boolean>("inUse"));

        tableR.setItems(dataR);
        tableR.getColumns().addAll(IDCol, NameCol, inUseCol);

        layoutInfoR.getChildren().addAll(tableR, BackToAdminR, AddR);
        RoomsInfo = new Scene(layoutInfoR, 600, 400);

        //AddRoom
        AddRoom();
    }

    private void AddRoom() {
        TextField ICap = new TextField();
        Button BackToRInfo = new Button("Back To Rooms");
        BackToRInfo.setOnAction(e -> window.setScene(RoomsInfo));
        Button AddR = new Button("Add");
        AddR.setOnAction(e ->
                {
                    int cap = Integer.parseInt(ICap.getText());

                    System.out.print(cap);
                    fc.writeRooms(cap);
                    fc.readRooms();
                    CreateTableScenes();
                }
        );

        VBox layoutAddR = new VBox();
        layoutAddR.getChildren().addAll(BackToRInfo,
                new Label("Room Capacity"),
                ICap,
                AddR);
        AddRoom = new Scene(layoutAddR, 600, 400);
    }

    private void extractedStudentInfo() {
        Button BackToAdminS = new Button("Back To Admin");
        BackToAdminS.setOnAction(e -> window.setScene(AdminPage));
        Button AddS = new Button("Add Students");
        AddS.setOnAction(e -> window.setScene(AddStudents));
        VBox layoutInfoS = new VBox();
        tableS.setEditable(true);

        dataS.clear();
        for(int i=0; i<fc.studentCount; i++){
            dataS.addAll(FXCollections.observableArrayList(
                    new Students(fc.studentArray[i])));
        }

        TableColumn IDCol = new TableColumn("Course");
        IDCol.setCellValueFactory(new PropertyValueFactory<Room,String>("Course"));
        TableColumn NameCol = new TableColumn("Number");
        NameCol.setCellValueFactory(new PropertyValueFactory<Room,String>("Number"));

        tableS.setItems(dataS);
        tableS.getColumns().addAll(IDCol, NameCol);

        layoutInfoS.getChildren().addAll(tableS, BackToAdminS, AddS);
        StudentsInfo = new Scene(layoutInfoS, 600, 400);

        //Add Students
        AddStudents();
    }

    private void AddStudents() {
        TextField INum = new TextField();
        TextField ICourse = new TextField();
        Button BackToSInfo = new Button("Back To Students");
        BackToSInfo.setOnAction(e -> window.setScene(StudentsInfo));
        Button AddS = new Button("Add");
        AddS.setOnAction(e ->
                {
                    int num = Integer.parseInt(INum.getText());
                    String course = ICourse.getText();

                    System.out.print(num+course);
                    fc.writeStudents(num, course);
                    fc.readStudents();
                    CreateTableScenes();
                }
        );

        VBox layoutAddS = new VBox();
        layoutAddS.getChildren().addAll(BackToSInfo,
                new Label("Number"),
                INum,
                new Label("Course"),
                ICourse,
                AddS);
        AddStudents= new Scene(layoutAddS, 600, 400);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
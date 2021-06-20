package sample.System;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Admin extends Application  {

    Stage window;
    Scene AdminPage, InstructorInfo, CourseInfo, RoomsInfo, StudentsInfo, ScheduleInfo;
    Scene AddInstructor, AddCourse;
    Factory fc = new Factory();
    private TableView table = new TableView<Instructor>();
    private TableView tableC = new TableView<Course>();
    private TableView tableR = new TableView<Room>();
    private TableView tableS = new TableView<Students>();

    private final ObservableList<Instructor> data = FXCollections.observableArrayList();
    private final ObservableList<Course> dataC = FXCollections.observableArrayList();
    private final ObservableList<Room> dataR = FXCollections.observableArrayList();
    private final ObservableList<Students> dataS = FXCollections.observableArrayList();


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
        StackPane layoutInfoSch = new StackPane();
        layoutInfoSch.getChildren().add(BackToAdminSch);
        ScheduleInfo = new Scene(layoutInfoSch, 600, 400);
    }

    private void extractedInstructorInfo() {
        Button BackToAdminI = new Button("Back To Admin");
        BackToAdminI.setOnAction(e -> window.setScene(AdminPage));
        Button AddI = new Button("Add Instructor");
        AddI.setOnAction(e -> window.setScene(AddInstructor));
        VBox layoutInfo = new VBox();
        table.setEditable(true);

        for(int i=0; i<fc.instructorCount; i++){
            fc.instructorArray[i].print();
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
    }

    private void extractedCourseInfo() {
        Button BackToAdminC = new Button("Back To Admin");
        BackToAdminC.setOnAction(e -> window.setScene(AdminPage));
        Button AddC = new Button("Add Course");
        AddC.setOnAction(e -> window.setScene(AdminPage));
        VBox layoutInfoC = new VBox();
        tableC.setEditable(true);

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
    }

    private void extractedRoomsInfo() {
        Button BackToAdminR = new Button("Back To Admin");
        BackToAdminR.setOnAction(e -> window.setScene(AdminPage));
        Button AddR = new Button("Add Room");
        AddR.setOnAction(e -> window.setScene(AdminPage));
        VBox layoutInfoR = new VBox();
        tableR.setEditable(true);

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
    }

    private void extractedStudentInfo() {
        Button BackToAdminS = new Button("Back To Admin");
        BackToAdminS.setOnAction(e -> window.setScene(AdminPage));
        Button AddS = new Button("Add Students");
        AddS.setOnAction(e -> window.setScene(AdminPage));
        VBox layoutInfoS = new VBox();
        tableS.setEditable(true);

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
    }

    public static void main(String[] args) {
        launch(args);
    }
}
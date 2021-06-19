package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Login.StudentLogin;


public class Main extends Application {
    Button b1;
    Button b2;
    StudentLogin sl = new StudentLogin();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Automated Scheduling System");
        Label label = new Label("Automated Scheduling System");
        label.setFont(new Font("Arial", 44));
        Button b1= new Button();
        b1.setText("Student");
        Button b2= new Button();
        b2.setText("Teacher");

        b1.setOnAction(e -> {
            primaryStage.setScene(sl.getScene());
            primaryStage.show();
        });

        BorderPane layout = new BorderPane();
        layout.setTop(label);
        layout.setLeft(b1);
        layout.setRight(b2);
        Scene scene = new Scene(layout, 1000, 500);
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

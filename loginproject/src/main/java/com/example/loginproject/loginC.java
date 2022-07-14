package com.example.loginproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class loginC {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button btnbutton;
    @FXML
    private Button btnregisterspage;
    @FXML
    private TextField txtpassword;

    @FXML
    private TextField txtusername;

    @FXML
    void gotoregisters(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("registeruser.fxml"));
        stage = (Stage)btnregisterspage.getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void login(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        String name = txtusername.getText();
        String email = txtpassword.getText();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "");
        System.out.print("Database is connected !");
        Statement statement = conn.createStatement();
        String verifylogin = "SELECT count(1) FROM `login_t` WHERE username = '" + txtusername.getText() + "'and password = '" + txtpassword.getText() + "' ";
        ResultSet Query = statement.executeQuery(verifylogin);

        if((txtusername.getText().isBlank() == false ) && (txtpassword.getText().isBlank() == false) )
        {

            while (Query.next()) {
                if (Query.getInt(1) == 1) {

                    Parent root = FXMLLoader.load(getClass().getResource("new.fxml"));
                    stage = (Stage) btnbutton.getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();


                }
                if (Query.getInt(1) == 0) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Either name or password is wrong Please Try Again");
                    a.showAndWait();
                }

            }
        }
         else
        {
            Alert b = new Alert(Alert.AlertType.INFORMATION, "Please enter the UserName and the Password");
            b.showAndWait();


        }



    }

}



















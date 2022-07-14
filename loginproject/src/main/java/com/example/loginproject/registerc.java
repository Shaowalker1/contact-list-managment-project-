package com.example.loginproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;

public class registerc {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button btnregister;

    @FXML
    private TextField txtepassword;

    @FXML
    private TextField txtuserame;

    @FXML
    void register(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        String name = txtuserame.getText();
        String email = txtepassword.getText();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "");
        System.out.print("Database is connected !");
        String sql = "SELECT * FROM login_t where username = ? and password = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, email);
        ResultSet result = statement.executeQuery();
        if(!result.next()){

            sql = "INSERT INTO login_t (username,password) VALUES (?,?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {

                Alert a = new Alert(Alert.AlertType.INFORMATION,"Successfully registered go to login page");
               // a.showAndWait();
                Optional<ButtonType> option = a.showAndWait();
                if (option.get() == ButtonType.OK){
                    Parent root = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
                    stage = (Stage)btnregister.getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }

        }
        else{
            Alert a = new Alert(Alert.AlertType.INFORMATION,"You are already registered go to login page");
            //a.showAndWait();
            Optional<ButtonType> option = a.showAndWait();
            if (option.get() == ButtonType.OK){
                Parent root = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
                stage = (Stage)btnregister.getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
        }


    }

}

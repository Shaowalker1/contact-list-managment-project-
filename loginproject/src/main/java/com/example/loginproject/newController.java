package com.example.loginproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class newController {

    @FXML
    private Button butdelate;

    @FXML
    private Button butdispaly;

    @FXML
    private Button butinsert;

    @FXML
    private Button butupdate;

    @FXML
    void delate(ActionEvent event) {

    }

    @FXML
    void display(ActionEvent event) {

    }

    @FXML
    void insert(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }
// insert data
//
//    @FXML
//    public void insert (ActionEvent event) throws ClassNotFoundException, SQLException {
////        System.out.println("Full Name = " + txtfullname.getText());
////        System.out.println("Age = " + txtage.getText());
//        lblvalue.setText("Full Name = " + txtfullname.getText());
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","");
//        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO user_table(full_name,age) VALUES (?,?)");
//        preparedStatement.setString(1, txtfullname.getText());
//        preparedStatement.setInt(2, Integer.parseInt(txtage.getText()));
//        preparedStatement.executeUpdate();
//        con.close();
//    }

}

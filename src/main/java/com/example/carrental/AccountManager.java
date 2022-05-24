package com.example.carrental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AccountManager implements Initializable {

    @FXML
    private Button exitButton;

    @FXML
    private Label addressLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Label companyLabel;

    private String username = LoginController.saveUsername;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        try {
            ResultSet rs = connectDB.createStatement().executeQuery("SELECT * FROM company WHERE username = '"+ username +"'");

            while(rs.next()) {
                companyLabel.setText(rs.getString("name"));
                firstNameLabel.setText(rs.getString("first_name_manager"));
                lastNameLabel.setText(rs.getString("last_name_manager"));
                addressLabel.setText(rs.getString("address"));
                phoneNumberLabel.setText(rs.getString("phone_number"));
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }


    public void logoutOnAction (ActionEvent event){
        Stage stage;
        Scene scene;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void ExitButtonOnAction(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}

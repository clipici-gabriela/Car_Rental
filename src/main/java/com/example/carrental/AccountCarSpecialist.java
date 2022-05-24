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
import java.util.ResourceBundle;

public class AccountCarSpecialist implements Initializable {

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

    private String first_name, last_name, address, phone_number;
    private String username = LoginController.saveUsername;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        try {
            ResultSet rs = connectDB.createStatement().executeQuery("SELECT * FROM car_specialist WHERE username = '"+ username +"'");

            while(rs.next()) {
                firstNameLabel.setText(rs.getString("first_name"));
                lastNameLabel.setText(rs.getString("last_name"));
                addressLabel.setText(rs.getString("address"));
                phoneNumberLabel.setText(rs.getString("phone_number"));
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    public void listCompaniesOnAcction(ActionEvent event){
        Stage stage;
        Scene scene;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("listCompanies.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e){
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

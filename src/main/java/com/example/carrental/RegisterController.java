package com.example.carrental;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.security.PrivateKey;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private ImageView shieldImageView;

    @FXML
    private ImageView nameImageView;

    @FXML
    private Button closeButton;

    @FXML
    private Label registrationMessageLabel;

    @FXML
    private PasswordField setPasswordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label confirmPasswordLabel;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private ChoiceBox<String> roleChoiceBox;

    private String[] choses ={"customer", "manager"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File shieldFile = new File("background/register.jpg");
        Image shieldImage = new Image(shieldFile.toURI().toString());
        shieldImageView.setImage(shieldImage);

        File nameFile = new File("background/name.png");
        Image nameImage = new Image(nameFile.toURI().toString());
        nameImageView.setImage(nameImage);

        roleChoiceBox.getItems().addAll(choses);
    }


    public void closeButtonOnAction(ActionEvent event){

        Stage stage =(Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerButtonOnAction(ActionEvent event){
        if(setPasswordField.getText().equals(confirmPasswordField.getText())){
            registrationUser();
            //confirmPasswordLabel.setText("You are set.");
        }else {
            confirmPasswordLabel.setText("Password does not match.");
        }
    }

    public void registrationUser(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String first_name = firstnameTextField.getText();
        String last_name = lastnameTextField.getText();
        String username = usernameTextField.getText();
        String address = addressTextField.getText();
        String phone_number = phoneNumberTextField.getText();
        String password = setPasswordField.getText();
        String role = roleChoiceBox.getValue();

        String insertFields = "INSERT INTO users_account (first_name, last_name,username,address,phone_number,password,role) VALUES ('";
        String insertValues = first_name + "','" + last_name + "','" + username + "','" + address + "','" + phone_number + "','" + password + "','" + role +"')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            registrationMessageLabel.setText("User has been registered successfully");


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    public void openLogin(){
        try{
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 600, 481));
            registerStage.show();

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}

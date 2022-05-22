package com.example.carrental;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ManagerRegisterController implements Initializable {

    @FXML
    private ImageView shImageView, nmImageView;

    @FXML
    private Button clloseButton;

    @FXML
    private TextField companyNameTextField, firstnameTextField, lastnameTextField, usernameTextField, addressTextField, phoneNumberTextField;

    @FXML
    private PasswordField setPasswordField, confirmPasswordField;

    @FXML
    private Label confirmPasswordLabel, usernameLabel, registrationMessageLabel;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File shieldFile = new File("background/register.jpg");
        Image shieldImage = new Image(shieldFile.toURI().toString());
        shImageView.setImage(shieldImage);

        File nameFile = new File("background/name.png");
        Image nameImage = new Image(nameFile.toURI().toString());
        nmImageView.setImage(nameImage);

    }

    private static MessageDigest getMessageDigest(){
        MessageDigest md;
        try{
            md = MessageDigest.getInstance("SHA-512");
        }catch (NoSuchAlgorithmException e){
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

    private static String encodePassword(String salt, String password){
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        return new String(hashedPassword, StandardCharsets.UTF_8).replace("\"","");
    }

    public void registerManagerButtonOnAction(ActionEvent event){
        if(setPasswordField.getText().equals(confirmPasswordField.getText())){
            signUpUser();
        }else{
            confirmPasswordLabel.setText("Password does not match!");
        }
    }

    public void signUpUser(){
        int ok1 = 0, ok2 = 0; ;
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionDB =connection.getConnection();

        String companyName = companyNameTextField.getText();
        String firstName = firstnameTextField.getText();
        String lastName = lastnameTextField.getText();
        String username = usernameTextField.getText();
        String address = addressTextField.getText();
        String phone_number = phoneNumberTextField.getText();
        String password = encodePassword(username,setPasswordField.getText());

        String insertFields = "INSERT INTO company (name, first_name_manager, last_name_manager, username, address, phone_number, password) VALUES ('";
        String insertValues = companyName + "', '"+ firstName +"', '"+ lastName +"', '"+ username +"', '"+ address +"', '"+ phone_number +"', '"+ password +"')";
        String insertToRegister = insertFields + insertValues;

        String verifyUser1 = "SELECT COUNT(1) FROM company where username = '"+ username +"'";
        String verifyUser2 = "SELECT COUNT(1) FROM customers where username = '"+ username +"'";

        try{
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult2 = statement.executeQuery(verifyUser2);

            while (queryResult2.next()){
                if(queryResult2.getInt(1) == 1)
                    ok1 = 1;
            }

            ResultSet queryResult1 = statement.executeQuery(verifyUser1);
            while (queryResult1.next()){
                if (queryResult1.getInt(1) == 1 )
                 ok2 = 1;
            }

            if( ok1 == 1 || ok2 == 1){
                usernameLabel.setText("Username already exist");
            } else {
                statement.executeUpdate(insertToRegister);
                registrationMessageLabel.setText("User has been registered successfully");
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void clloseButtonOnAction(ActionEvent event){

        Stage stage =(Stage) clloseButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void backToLogin(ActionEvent event){
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


}

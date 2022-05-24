package com.example.carrental;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.io.File;

import java.net.URL;


public class LoginController implements Initializable {

    @FXML
    private Button cancelButton, loginButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private ImageView brandingImageView;

    @FXML
    private ImageView lockImageView;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField enterPasswordField;

<<<<<<< Updated upstream
    private String saveUsername;
=======
    public static String saveUsername;
>>>>>>> Stashed changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("background/logo.jpeg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile = new File("background/lock.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }

    public void loginButtonOnAction(ActionEvent event){

        if(usernameTextField.getText().isBlank()==false &&enterPasswordField.getText().isBlank()==false){
            validateLogin();
        }else {
            loginMessageLabel.setText("Please enter username and password");
        }

    }

    public void CancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", "");
    }


    public void validateLogin(){

        int ok1 = 0, ok2 = 0, ok3 = 0;
<<<<<<< Updated upstream
=======
        String user = usernameTextField.getText();
>>>>>>> Stashed changes

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String encodePassword = encodePassword(usernameTextField.getText(), enterPasswordField.getText());
        String verifyLogin1 ="select count(1) from customers where username = '" + usernameTextField.getText() +"' and password = '"+ encodePassword +"'";
        String verifyLogin2 ="select count(1) from company where username = '" + usernameTextField.getText() +"' and password = '"+ encodePassword +"'";
        String verifyLogin3 ="select count(1) from car_specialist where username = '" + usernameTextField.getText() +"' and password = '"+ encodePassword +"'";


        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult1 = statement.executeQuery(verifyLogin1);

            while (queryResult1.next()){
                if (queryResult1.getInt(1) == 1)
                    ok1 = 1;
            }

            ResultSet queryResult2 = statement.executeQuery(verifyLogin2);

            while (queryResult2.next()){
                if (queryResult2.getInt(1) == 1)
                    ok2 = 1;
            }

            ResultSet queryResult3 = statement.executeQuery(verifyLogin3);

            while (queryResult3.next()){
                if (queryResult3.getInt(1) == 1)
                    ok3 = 1;
            }

            if (ok1 == 1){
<<<<<<< Updated upstream
                saveUsername = usernameTextField.getText();
=======
                saveUsername = user;
>>>>>>> Stashed changes
                loginButton.setOnAction(actionEvent -> {
                    loginButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();

                    loader.setLocation(getClass().getResource("startCustomerPage.fxml"));

                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                        e.getCause();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                });
            }
            if(ok2 == 1){
<<<<<<< Updated upstream
                saveUsername = usernameTextField.getText();
=======
                saveUsername = user;
>>>>>>> Stashed changes
                loginButton.setOnAction(actionEvent -> {
                    loginButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();

                    loader.setLocation(getClass().getResource("startManagerPage.fxml"));

                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                });
            }
            if(ok3 == 1){
<<<<<<< Updated upstream
                saveUsername = usernameTextField.getText();
=======
                saveUsername = user;
>>>>>>> Stashed changes
                loginButton.setOnAction(actionEvent -> {
                    loginButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();

                    loader.setLocation(getClass().getResource("startCarSpecialistPage.fxml"));
<<<<<<< Updated upstream

                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                });
            }

=======

                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                });
            }

>>>>>>> Stashed changes
            if(ok1 == 0 && ok2 == 0 && ok3 == 0){
             loginMessageLabel.setText("Invalid login. Please try again!");
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public String getUser(){
        return saveUsername;
    }



    public void createAccountForm(ActionEvent event){
        Stage stage;
        Scene scene;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("chooseRole.fxml"));
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
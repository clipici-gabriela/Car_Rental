package com.example.carrental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;



public class AddCarPage implements Initializable {

    @FXML
    private TextField brandTextField;

    @FXML
    private TextField dateTextField;

    @FXML
    private TextField detaliesTextField;

    @FXML
    private TextField modelTextField;

    @FXML
    private TextField priceTextFiedl;

    private String username =LoginController.saveUsername;
    private String company;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        try {
            ResultSet rs = connectDB.createStatement().executeQuery("SELECT name FROM company WHERE username = '" + username + "'");

            while (rs.next()) {
                company = rs.getString("name");
                    }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    public void addCarButtonOnAction(ActionEvent event){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String brand = brandTextField.getText();
        String model = modelTextField.getText();
        String date = dateTextField.getText();
        String price = priceTextFiedl.getText();
        String detalies = detaliesTextField.getText();

        String insertFields = "INSERT INTO cars (company, marca, model, an_fabricatie, pret, detalii) VALUES ('";
        String insertValues = company + "','" + brand + "','" + model + "','" + date + "','" + price + "','" + detalies + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

        public void backOnAcction(ActionEvent event){
        Stage stage;
        Scene scene;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("listCarsManager.fxml"));
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

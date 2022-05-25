package com.example.carrental;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ListCarsManager implements Initializable {
    private String username = LoginController.saveUsername;
    private String company;
    ObservableList<Cars> list = FXCollections.observableArrayList();


    @FXML
    private ListView<Cars> listCarsManager;

    @FXML
    private Button exitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        try {
            ResultSet rs = connectDB.createStatement().executeQuery("SELECT name FROM company WHERE username = '" + username + "'");

            while (rs.next()) {
                company = rs.getString("name");
            }

            ResultSet rs2 = connectDB.createStatement().executeQuery("SELECT marca, model FROM cars WHERE company = '" + company + "'");
             while (rs2.next()){
                 String marca = rs2.getString("marca");
                 String model = rs2.getString("model");

                 list.add(new Cars(marca, model));
             }

            listCarsManager.setItems(list);


        } catch (Exception e) {
            e.printStackTrace();


        }

    }

    public void addButtonOnAcction(ActionEvent event){
        Stage stage;
        Scene scene;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("addCarPage.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    public void accountOnAcction(ActionEvent event){
        Stage stage;
        Scene scene;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("accountManager.fxml"));
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

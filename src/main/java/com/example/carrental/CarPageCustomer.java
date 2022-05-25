package com.example.carrental;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CarPageCustomer implements Initializable {

    @FXML
    private ListView<Cars> listCars;

    private String company = ListCompany.company;
    public static String company1  ;
    public static Cars car;
    ObservableList<Cars> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String query = "SELECT marca, model FROM cars WHERE company = '"+ company +"'";
        company1 = company;
        try{

            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                String marca = resultSet.getString("marca");
                String model = resultSet.getString("model");

                list.add(new Cars(marca, model));
            }
            listCars.setItems(list);

            listCars.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cars>() {
                @Override
                public void changed(ObservableValue<? extends Cars> observable, Cars oldValue, Cars newValue) {
                    car = listCars.getSelectionModel().getSelectedItem();
                }

            });
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
    public void dateliesButtonOnAction(ActionEvent event){

        Stage stage;
        Scene scene;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("detaliesCarCustomer.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void backOnAcction(ActionEvent event){
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
}

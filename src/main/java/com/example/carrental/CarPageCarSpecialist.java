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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CarPageCarSpecialist implements Initializable {
    @FXML
    private Button backButton;

    @FXML
    private ListView<Cars2> listCars;

    ObservableList<Cars2> list = FXCollections.observableArrayList();
    public static Cars2 car;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String query = "SELECT company, marca, model FROM cars";
        try{

            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                String company = resultSet.getString("company");
                String marca = resultSet.getString("marca");
                String model = resultSet.getString("model");

                list.add(new Cars2(company,marca, model));
            }
            listCars.setItems(list);

            listCars.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cars2>() {
                @Override
                public void changed(ObservableValue<? extends Cars2> observable, Cars2 oldValue, Cars2 newValue) {
                    car = listCars.getSelectionModel().getSelectedItem();
                }

            });
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void backOnAcction(ActionEvent event){
        Stage stage;
        Scene scene;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("startCarSpecialistPage.fxml"));
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

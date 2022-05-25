package com.example.carrental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class DetaliesCarCustomer implements Initializable {

    @FXML
    private Label brandLabel;

    @FXML
    private Label compLabel;

    @FXML
    private Label dataliesLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label modelLabel;

    @FXML
    private Label priceLabel;


    private String model = CarPageCustomer.car.getModel();
    private String marca = CarPageCustomer.car.getMarca();
    private String company = CarPageCustomer.company1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        try {
            ResultSet rs = connectDB.createStatement().executeQuery("SELECT * FROM cars WHERE company = '"+ company +"' AND marca = '"+ marca +"' AND model = '"+ model +"'");

            while(rs.next()) {
                brandLabel.setText(rs.getString("marca"));
                modelLabel.setText(rs.getString("model"));
                compLabel.setText(rs.getString("company"));
                dateLabel.setText(rs.getString("an_fabricatie"));
                priceLabel.setText(rs.getString("pret"));
                dataliesLabel.setText(rs.getString("detalii"));
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }


    public void backOnAcction(ActionEvent event){
        Stage stage;
        Scene scene;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("carPageCustomer.fxml"));
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

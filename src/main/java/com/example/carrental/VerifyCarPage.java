package com.example.carrental;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VerifyCarPage {



    public void backOnAcction(ActionEvent event){
        Stage stage;
        Scene scene;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("carPageCarSpecialist.fxml"));
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

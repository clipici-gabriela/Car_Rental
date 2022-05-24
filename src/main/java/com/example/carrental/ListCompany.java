package com.example.carrental;

<<<<<<< Updated upstream
=======
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
>>>>>>> Stashed changes
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
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class ListCompany implements Initializable {
    @FXML
    private Button exitButton;

<<<<<<< Updated upstream
    @FXML
    private TableColumn <Companies, String> Company;
=======
>>>>>>> Stashed changes

    @FXML
    private ListView<String> listCompanies;

    ObservableList<String> list = FXCollections.observableArrayList();

<<<<<<< Updated upstream
=======
    public static String company;

>>>>>>> Stashed changes
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String query = "SELECT name FROM company";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                String nameC = resultSet.getString("name");

<<<<<<< Updated upstream
                list.add(new String(nameC));
            }

            listCompanies.setItems(list);
=======
                list.add(nameC);
            }

            listCompanies.setItems(list);
            listCompanies.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                    company = listCompanies.getSelectionModel().getSelectedItem();
                }
            });
>>>>>>> Stashed changes


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

<<<<<<< Updated upstream
=======
    public void goToOnAcction(ActionEvent event){

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
    public void accountOnAcction(ActionEvent event){
        Stage stage;
        Scene scene;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("accountCustomer.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

>>>>>>> Stashed changes
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

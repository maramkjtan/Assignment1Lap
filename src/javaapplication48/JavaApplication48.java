/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication48;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Maram Tanani
 */
public class JavaApplication48 extends Application{

    /**
     * @param args the command line arguments
     */
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = FXMLLoader.load(getClass().getResource("employee.fxml"));
        Map<String,Pane>map=new TreeMap<>(); 
        map.put("employee", pane);
       
        
        Scene scene = new Scene(map.get("employee"));
        
        primaryStage.setTitle("company App");
        primaryStage.setScene(scene);
        primaryStage.show();

    
    }
    public static void main(String[] args) {
        launch(args);

    }
}

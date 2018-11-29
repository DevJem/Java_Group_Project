/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1_finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import team1_finalproject.supporting_classes.*;

/**
 *
 * @author jay
 */
public class Team1_FinalProject extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int PW_RUNS = 10;  // Number of passwords generated
        
        // PW Generator code. Needs it's own method.
        PWGenerator pwGenerate = new PWGenerator();
        for (int i = 0; i < PW_RUNS; i++) {
            pwGenerate.generate();
        }
        launch(args);
    }
}

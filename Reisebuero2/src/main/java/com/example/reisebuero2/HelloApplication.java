package com.example.reisebuero2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
//    public void start(Stage stage1) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(),1024,720);
//        stage1.setTitle("EarthQuake_ReiseBuero");
//        stage1.setScene(scene);
//        stage1.show();
//    }
    public void start(Stage primaryStage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setTitle("EarthQuake-Reisebuero");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        SecondController.getConnection();
    //    sorgu = "SELECT * from kategorie";
   //     ResultSet rs = SecondController.listele(sorgu);
     //   while(true){
    //        try {
    //            if (!rs.next()) break;
   //         } catch (SQLException e) {
    //            throw new RuntimeException(e);
      //      }
        //    try {
          //      System.out.println(rs.getString("id"));
            //    System.out.println(rs.getString("kurse_name"));
              //  System.out.println(rs.getString("price"));
         //   } catch (SQLException e) {
           //     throw new RuntimeException(e);
           // }
      //  }
    }

    public static void main(String[] args) {
        launch();
    }
}
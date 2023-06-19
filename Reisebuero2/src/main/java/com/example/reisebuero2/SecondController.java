package com.example.reisebuero2;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Reise;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;

public class SecondController{
    @FXML
    private Button sendButton;
    @FXML
    private TextField vornameField;
    @FXML
    private TextField nachnameField;
    @FXML
    private TextField nummerField;
    @FXML
    private TextField mailField;

    static String url = "jdbc:postgresql://localhost:5432/postgres";
    static Connection conn = null;
    static Statement st;
    private HelloController reise;
    public static String lct;
    public static String dtm;
    public static void getConnection(){
        try {
            conn = DriverManager.getConnection(url, "postgres", "tau019");
            System.out.println("Connection Established");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    static ResultSet listele(String sorgu){
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sorgu);
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void cagir(MouseEvent mouseEvent){
        String sorgu = "SELECT * from kategorie";
        ResultSet rs = SecondController.listele(sorgu);
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.print(rs.getString("id"));
                System.out.print(" ");
                System.out.print(rs.getString("kurse_name"));
                System.out.print(" ");
                System.out.println(rs.getString("price"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    static void ekle(String insertQuery){
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(insertQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
     public void actions(MouseEvent mouseEvent){
                 String name = vornameField.getText();
                 String nachname = nachnameField.getText();
                 String mail = mailField.getText();
                 String nummer = nummerField.getText();
                 String location = lct;
                 String datum = dtm;
                 String insertQuery = "INSERT INTO customer (vorname,nachname,email,nummer,location,datum) VALUES ('"+ name + "','" + nachname + "','" + mail + "','" + nummer + "','" + location + "','" + datum + "')";
                 System.out.println(insertQuery);
                 ekle(insertQuery);
     }

    @FXML
    public  void handleMouseEntered(MouseEvent event){
        Node node = (Node) event.getSource();
        node.setScaleX(1.1); //mouseyi butonun üzerine getirince büyüyor
        node.setScaleY(1.1);
    }
    @FXML
    public  void handleMouseExited(MouseEvent event){
        Node node = (Node) event.getSource();
        node.setScaleX(1); //mouseyi üzerinden çekince buton geri küçülüyor
        node.setScaleY(1);
    }
}

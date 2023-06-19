package com.example.reisebuero2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Reise;

public class ItemController {
    @FXML
    private Label datumLabel;

    @FXML
    private ImageView img;

    @FXML
    private Label locationLabel;

    @FXML
    private Label priceLabel;
    @FXML

    private void click(MouseEvent mouseEvent){
        myListener.onClickListener(reise);
    }
    private Reise reise;

    private MyListener myListener;
    public void setData(Reise reise, MyListener myListener){
        this.reise = reise;
        this.myListener = myListener;
        datumLabel.setText((reise.getDatum()));
        locationLabel.setText(reise.getLocation());
        priceLabel.setText(reise.getPrice());
        Image image = new Image(getClass().getResourceAsStream(reise.getBild()));
        img.setImage(image);
    }
}

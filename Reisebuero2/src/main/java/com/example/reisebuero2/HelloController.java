package com.example.reisebuero2;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.Reise;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HelloController  implements Initializable{
    @FXML
    private Button Anmelden;
    @FXML
    private TextField searchBar;

    @FXML
    private ImageView imgCherry;
    @FXML
    private Label reiseLocationLabel;
    @FXML
    private Label reiseDatumLabel;
    @FXML
    private Label reisePriceLabel;

    @FXML
    private Label dateiLabel;

    @FXML
    private AnchorPane mainMenuContentAnchorPane;

    @FXML
    private AnchorPane mainMenuInfoAnchorPane;
    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scroll;
    @FXML
    private ScrollPane scroll2;

    private List<Reise> reises = new ArrayList<>();
    private MyListener myListener;
    private Image image;
    String denemek;

    @FXML

    private List<Reise> getData(){
        List<Reise> reises= new ArrayList<>();
        Reise reise;

            reise = new Reise();
            reise.setLocation("Paris");
            reise.setPrice("649€");
            reise.setDatum("29.11.2023");
            reise.setBild("/frankreichfranceparis.png");
            reise.setDatei("Ein Ausflug nach Paris bietet zahlreiche Möglichkeiten, um die Stadt der Liebe zu erleben. Beginnen Sie Ihren Tag mit einem Spaziergang entlang der Seine und bewundern Sie die berühmten Sehenswürdigkeiten wie den Eiffelturm, die Notre-Dame-Kathedrale und das Louvre Museum. Machen Sie eine Pause in einem der charmanten Cafés und genießen Sie ein typisch französisches Frühstück mit Croissants und Café au lait. Besuchen Sie danach die berühmten Einkaufsstraßen wie die Champs-Élysées oder die Rue Saint-Honoré und lassen Sie sich von den neuesten Modetrends inspirieren.");
            reises.add(reise);

            reise = new Reise();
            reise.setLocation("Ankara");
            reise.setPrice("220€");
            reise.setDatum("12.05.2023");
            reise.setBild("/türkeitürkiyeankara.png");
            reise.setDatei("Ein Ausflug nach Ankara, der Hauptstadt der Türkei, bietet eine faszinierende Kombination aus historischen Sehenswürdigkeiten und modernem Stadtleben. Beginnen Sie Ihren Tag mit einem Besuch der Zitadelle von Ankara, die auf einem Hügel über der Stadt thront und einen atemberaubenden Blick auf die Umgebung bietet.\n" +
                    "Anschließend können Sie das Anıtkabir-Mausoleum besuchen, das dem Gründervater der modernen Türkei, Mustafa Kemal Atatürk, gewidmet ist. Hier können Sie mehr über die Geschichte und Kultur des Landes erfahren.");
            reises.add(reise);

            reise = new Reise();
            reise.setLocation("Rome");
            reise.setPrice("380€");
            reise.setDatum("09.09.2023");
            reise.setBild("/italyitalienrome.png");
            reise.setDatei("Ein Ausflug nach Rom, der ewigen Stadt, ist ein unvergessliches Erlebnis, das Ihnen die Möglichkeit gibt, einige der erstaunlichsten historischen Sehenswürdigkeiten der Welt zu entdecken. Beginnen Sie Ihren Tag mit einem Besuch des Kolosseums, einem der berühmtesten Wahrzeichen der Stadt, und erfahren Sie mehr über die antike römische Kultur. Besuchen Sie dann den Vatikan, wo Sie den Petersdom und die Sixtinische Kapelle bewundern können. Hier können Sie einige der erstaunlichsten Kunstwerke der Welt bestaunen, die von Künstlern wie Michelangelo und Raffael geschaffen wurden.");
            reises.add(reise);

            reise = new Reise();
            reise.setLocation("Münschen");
            reise.setPrice("699€");
            reise.setDatum("22.10.2023");
            reise.setBild("/deutschlandgermanymünschen.png");
            reise.setDatei("Ein Ausflug nach München, der bayerischen Hauptstadt, bietet Ihnen eine reiche Kultur und Geschichte, sowie eine lebendige Szene für Kunst, Kultur und Gastronomie. Beginnen Sie Ihren Tag mit einem Besuch des Marienplatzes, dem historischen Zentrum der Stadt, wo Sie das Neue Rathaus und die berühmte Mariensäule bewundern können.\n" +
                    "Besuchen Sie dann das weltberühmte Hofbräuhaus, ein traditionelles bayerisches Bierhaus, wo Sie das typische Oktoberfestbier genießen und die lokale Küche probieren können.");
            reises.add(reise);

            reise = new Reise();
            reise.setLocation("Antalya");
            reise.setPrice("499€");
            reise.setDatum("09.08.2023");
            reise.setBild("/türkeitürkiyeantalya.png");
            reise.setDatei("Ein Ausflug nach Antalya, der malerischen Küstenstadt an der türkischen Riviera, bietet eine einzigartige Kombination aus historischen Sehenswürdigkeiten und atemberaubender Natur. Beginnen Sie Ihren Tag mit einem Spaziergang durch die Altstadt von Antalya, Kaleici genannt, wo Sie auf enge Gassen, osmanische Architektur und eine Vielzahl von Geschäften und Restaurants stoßen werden. Besuchen Sie dann den antiken Hafen von Antalya, wo Sie historische Sehenswürdigkeiten wie den Hadrianstor und den Yivli Minarett finden. Anschließend können Sie eine Bootstour entlang der Küste machen und die wunderschöne Natur und die türkisfarbenen Buchten entdecken.");
            reises.add(reise);

            reise = new Reise();
            reise.setLocation("Berlin");
            reise.setPrice("359€");
            reise.setDatum("13.10.2023");
            reise.setBild("/deutschlandgermanyberlin.png");
            reise.setDatei("Ein Ausflug nach Berlin, der pulsierenden Hauptstadt Deutschlands, ist eine Reise durch Geschichte, Kultur und moderne Kunst. Beginnen Sie Ihren Tag mit einem Besuch des Brandenburger Tors, dem bekanntesten Wahrzeichen der Stadt, und spazieren Sie durch den nahe gelegenen Tiergarten, einen der größten Stadtparks Europas.Besuchen Sie dann das Holocaust-Mahnmal, eine bewegende Gedenkstätte für die Opfer des Nationalsozialismus, und erfahren Sie mehr über die Geschichte der Stadt im Zweiten Weltkrieg. Anschließend können Sie den berühmten Checkpoint Charlie besuchen, den ehemaligen Grenzübergang zwischen Ost und West, und mehr über die Teilung Berlins und den Kalten Krieg erfahren.");
            reises.add(reise);

            reise = new Reise();
            reise.setLocation("İstanbul");
            reise.setPrice("319€");
            reise.setDatum("15.07.2023");
            reise.setBild("/türkeitürkiyeistanbul.png");
            reise.setDatei("Ein Ausflug nach Istanbul, der größten Stadt der Türkei, ist eine Reise durch die jahrtausendealte Geschichte und die Kultur des Landes. Beginnen Sie Ihren Tag mit einem Besuch der Hagia Sophia, einer ehemaligen Kirche und Moschee, die heute als Museum dient und als eines der bedeutendsten Bauwerke der Welt gilt.Besuchen Sie dann den Topkapi-Palast, eine prächtige Residenz der osmanischen Sultane, die eine beeindruckende Sammlung von historischen Schätzen und Kunstwerken beherbergt. Anschließend können Sie den Großen Basar besuchen, ein Labyrinth von engen Gassen und überdachten Marktständen, wo Sie lokale Handwerkskunst und Souvenirs kaufen können.Für eine kulinarische Erfahrung sollten Sie eine typische türkische Mahlzeit wie Kebab, Lahmacun und Baklava in einem der vielen Restaurants genießen, die die Stadt zu bieten hat. Verpassen Sie auch nicht die Gelegenheit, den Bosporus zu überqueren, der die Stadt in zwei Kontinente teilt, und eine Bootstour entlang des Ufers zu machen, um die Schönheit der Stadt aus einer anderen Perspektive zu sehen.");
            reises.add(reise);

            reise = new Reise();
            reise.setLocation("Hamburg");
            reise.setPrice("1259€");
            reise.setDatum("24.01.2023");
            reise.setBild("/deutschlandgermanyhamburg.png");
            reise.setDatei("Ein Ausflug nach Hamburg, der zweitgrößten Stadt Deutschlands, bietet eine einzigartige Mischung aus historischer Architektur, moderner Kunst und der lebhaften Atmosphäre des Hafens. Beginnen Sie Ihren Tag mit einem Besuch des Hamburger Rathauses, einem der prächtigsten Gebäude der Stadt und ein Beispiel für die neogotische Architektur des späten 19. Jahrhunderts. Besuchen Sie dann die Elbphilharmonie, ein spektakuläres Konzerthaus, das auf einem alten Kaispeicher am Ufer der Elbe gebaut wurde. Von der Aussichtsplattform aus haben Sie einen atemberaubenden Blick auf den Hafen und die Stadt.");
            reises.add(reise);

            reise = new Reise();
            reise.setLocation("Milano");
            reise.setPrice("249€");
            reise.setDatum("19.08.2023");
            reise.setBild("/italyitalienmilano.png");
            reise.setDatei("Ein Ausflug nach Mailand, der Modehauptstadt Italiens, bietet eine Fülle von kulturellen Sehenswürdigkeiten und kulinarischen Erlebnissen. Beginnen Sie Ihren Tag mit einem Besuch des beeindruckenden Mailänder Doms, einer der größten gotischen Kathedralen der Welt und ein Wahrzeichen der Stadt.Danach können Sie den berühmten Quadrilatero della Moda, das Modeviertel von Mailand, erkunden und die vielen exklusiven Boutiquen und Designerläden besuchen. Alternativ dazu können Sie auch das beeindruckende Opernhaus Teatro alla Scala besuchen, das zu den bekanntesten der Welt zählt.Für eine kulinarische Erfahrung sollten Sie unbedingt die lokale Küche probieren und eine echte Mailänder Risotto oder eine leckere Pizza in einem der vielen authentischen Restaurants genießen. Anschließend können Sie einen Spaziergang durch den Sforza-Park machen, einer grünen Oase in der Stadt, der eine Vielzahl von Kunstwerken und Skulpturen beherbergt.\n");
            reises.add(reise);

        return reises;
    }


    @FXML
  //  private void searchRecord(KeyEvent ke){
  //      FilteredList<Reise> filterData = new FilteredList<>(Reise,p->true);
  //      searchBar.textProperty().addListener();
  //  }

    public void setChosenReise(Reise reise){
        reiseDatumLabel.setText(reise.getDatum());
        reiseLocationLabel.setText(reise.getLocation());
        reisePriceLabel.setText(reise.getPrice());
        dateiLabel.setText(reise.getDatei());
        image = new Image(getClass().getResourceAsStream(reise.getBild()));
        imgCherry.setImage(image);
    }


    @FXML
    public  void handleMouseEntered(MouseEvent event){
        Node node = (Node) event.getSource();
        node.setScaleX(1.05); //mouseyi butonun üzerine getirince büyüyor
        node.setScaleY(1.05);
    }
    @FXML
    public  void handleMouseExited(MouseEvent event){
        Node node = (Node) event.getSource();
        node.setScaleX(1); //mouseyi üzerinden çekince buton geri küçülüyor
        node.setScaleY(1);
    }
    @FXML

    private  void startHomeWindow(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Second_Window.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
  //          stage.setMaximized(true);
            stage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        scroll.setStyle("-fx-background:  #aaaedd; -fx-border-color:  #aaaedd;");
        scroll2.setStyle("-fx-background:  #385698; -fx-border-color:  #385698;");
       // linear-gradient(to right top, #365687, #385698, #4454a7, #574fb3, #7047bc)

        Anmelden.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
               // System.out.println(reiseLocationLabel.getText());
                SecondController.lct = reiseLocationLabel.getText();
                SecondController.dtm = reiseDatumLabel.getText();
                startHomeWindow();
            }
        });

        reises.addAll(getData());
        if(reises.size() > 0){
            setChosenReise(reises.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Reise reise) {
                    setChosenReise(reise);
                }
            };
        }
        int row = 1;
        int column = 0;
        try{
            for(int i = 0; i < reises.size();i++) {
                FXMLLoader fxmlLoader2 = new FXMLLoader();
                fxmlLoader2.setLocation(getClass().getResource("Item.fxml"));
                AnchorPane anchorPane2 = fxmlLoader2.load();

                ItemController itemController2 = fxmlLoader2.getController();
                itemController2.setData(reises.get(i),myListener);
                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane2, column++, row);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);

                GridPane.setMargin(anchorPane2, new Insets(10)); //rowlar arasi bosluk
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            int column1 = 0;
            int row1 = 1;
            //  reises.addAll(getData());
            // Get the entered text from the search bar

            String searchText = newValue.trim().toLowerCase();
            //System.out.println(searchText.length());
            if(searchText.length()>2 || searchText.length()==0) {


                // Filter the data based on the entered text
                List<Reise> filteredData = getData().stream()
                        .filter(reise -> reise.getBild().toLowerCase().contains(searchText))
                        .collect(Collectors.toList());

                // Clear the grid
                grid.getChildren().clear();

                try {
                    for (int i = 0; i < filteredData.size(); i++) {

                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("Item.fxml"));
                        AnchorPane anchorPane = fxmlLoader.load();

                        ItemController itemController2 = fxmlLoader.getController();
                        itemController2.setData(filteredData.get(i), myListener);
                        if (column1 == 1) {
                            column1 = 0;
                            row1++;
                        }
                        grid.add(anchorPane, column1++, row1);
                        grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                        grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                        grid.setMaxWidth(Region.USE_COMPUTED_SIZE);

                        grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                        grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                        grid.setMaxHeight(Region.USE_COMPUTED_SIZE);

                        GridPane.setMargin(anchorPane, new Insets(10)); //rowlar arasi bosluk
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            });


        }
    }
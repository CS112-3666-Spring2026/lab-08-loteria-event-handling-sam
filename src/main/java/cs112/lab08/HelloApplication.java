package cs112.lab08;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    //CONSTANTS
    private Label title;
    private ImageView imageView;
    private Label message;
    private Button drawCard;

    //array of LoteriaCards to use for game:
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };


    @Override
    public void start(Stage stage) throws IOException {
        //removed FXML code, fill this in with components, scene, stage, etc.
        LoteriaCard cardLogo = new LoteriaCard();
        //SETUP COMPONENTS
        title = new Label("Welcome to EChALE STEM Loteria");
        imageView = new ImageView(cardLogo.getImage());
        message = new Label("Click the button below to randomly draw a card.");
        drawCard = new Button("Draw Random Card");

        //ADD COMPONENTS
        VBox layout = new VBox();
        layout.getChildren().addAll(title,imageView,message,drawCard);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(5);
        //SETUP SCENE AND SHOW
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(300);
        //imageView.set
        title.setFont(new Font(20));
        //anonymous class
        drawCard.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent){
                        //random card
                        int rand = (int) (Math.random()* LOTERIA_CARDS.length);
                        LoteriaCard randCard = LOTERIA_CARDS[rand];
                        //setting image to the card
                        imageView.setImage(randCard.getImage());
                        //setting text to card
                        message.setText(randCard.getCardName());
//                        System.out.println("fff");
                    }
                }


        );

        Scene scene = new Scene(layout,350,500);
        stage.setScene(scene);
        stage.setTitle("EChALE STEM Loteria");
        stage.show();
    }
    //HANDLE METHOD

    public static void main(String[] args) {
        launch();
    }
}

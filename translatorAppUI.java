import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
//import jdk.nashorn.internal.codegen.Label;

import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.TextField; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos;
import java.util.ArrayList;
import javafx.scene.shape.*;
import java.util.Random;

public class translatorAppUI extends Application {
    @Override public void start(Stage primaryStage) {

        /*public HBox addHBox() {
            HBox hbox = new HBox();
            hbox.setPadding(new Insets(15, 12, 15, 12));
            hbox.setSpacing(10);
            hbox.setStyle("-fx-background-color: #336699;");
        
            Button buttonCurrent = new Button("Current");
            buttonCurrent.setPrefSize(100, 20);
        
            Button buttonProjected = new Button("Projected");
            buttonProjected.setPrefSize(100, 20);
            hbox.getChildren().addAll(buttonCurrent, buttonProjected);
        
            return hbox;
        } */

        primaryStage.setTitle("Translator");

        Label t = new Label("This translator will translate from English into Vietnamese");
        t.setFont(new Font(60));

        //BorderPane border = new BorderPane();
        
              //Instantiating the BorderPane class  
         
        GridPane pane1 = new GridPane();

        Button button1 = new Button("translate 1");
        Button button2 = new Button("translate 2"); 

        TextArea textArea1 = new TextArea();
        TextArea textArea2 = new TextArea();

        textArea1.setPrefHeight(400);
        textArea1.setPrefWidth(500);

        textArea2.setPrefHeight(400);
        textArea2.setPrefWidth(500);

        pane1.setMinSize(400, 200);
        pane1.setPadding(new Insets(10, 10, 10, 10));
        pane1.setVgap(5); 
        pane1.setHgap(5);  
        pane1.setAlignment(Pos.CENTER); 

        GridPane pane2 = new GridPane();

        pane2.setMinSize(400, 100);
        pane2.setPadding(new Insets(10, 10, 10, 10));
        pane2.setVgap(5); 
        pane2.setHgap(5);  
        pane2.setAlignment(Pos.CENTER); 
       
        pane2.add(textArea1, 0, 0);
        pane2.add(textArea2, 1, 0); 
        
        pane1.add(t, 0,0);

        pane1.add(pane2, 0, 1);

        pane1.add(button1, 0, 2);
        pane1.add(button2, 1, 2);

        Group root = new Group(pane1);

        Scene scene = new Scene(root, 2000, 1500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
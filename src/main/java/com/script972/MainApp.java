package com.script972;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;


public class MainApp extends Application {

public static void main(String[]args)throws Exception{
        launch(args);
}

@Override
public void start(Stage stage)throws Exception{
        String fxmlFile="/fxml/start.fxml";
        FXMLLoader loader=new FXMLLoader();
        Parent root=(Parent)loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("Каталог расписок");
        stage.setScene(new Scene(root));
        Manipulate manipulate = new Manipulate();
        try {
                manipulate.task();
        } catch (ParserConfigurationException e) {
                e.printStackTrace();
        } catch (SAXException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
        stage.show();

        }
}


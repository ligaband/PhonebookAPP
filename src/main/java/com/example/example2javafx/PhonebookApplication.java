package com.example.example2javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import phonebook.PhonebookController;

import java.io.IOException;

public class PhonebookApplication extends Application {
    PhonebookController controller = new PhonebookController();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PhonebookApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Phonebook");

        stage.setScene(scene);
        stage.show();
        controller.createTableContacts();
    }

    public static void main(String[] args) {
        launch();
    }
}
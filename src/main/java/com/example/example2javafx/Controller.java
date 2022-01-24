package com.example.example2javafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import phonebook.Contact;
import phonebook.PhonebookController;



public class Controller {


    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldSurname;
    @FXML
    private TextField textFieldNameDelete;
    @FXML
    private TextField textFieldSurnameDelete;
    @FXML
    private TextField textFieldPhone;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldFindByName;
    @FXML
    private TextField textFieldFindBySurname;
    @FXML
    private ListView listView;
    @FXML
    private ListView listViewFindContact;
    @FXML
    private TextArea viewAllContacts;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Pane myPane;
    @FXML
    private ColorPicker myColorPicker;



    PhonebookController phonebookController = new PhonebookController();



    public String name;
    public String surname;
    public String phoneNumber;
    public String email;


    public void changePaneColor(ActionEvent event){
        Color myColor = myColorPicker.getValue();
        myPane.setBackground(new Background(new BackgroundFill(myColor, null, null)));

    }

    public void createTable() {
        phonebookController.createTableContacts();
    }

    public void addContact() {

        name = textFieldName.getText();
        surname = textFieldSurname.getText();
        phoneNumber = textFieldPhone.getText();
        email = textFieldEmail.getText();
        if(name.isEmpty() || surname.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter name and surname");
            alert.showAndWait();
            return;
        }
        Contact contact = new Contact(name, surname, phoneNumber, email);
        phonebookController.addContact(contact);
        viewAllContacts();


        textFieldEmail.clear();
        textFieldName.clear();
        textFieldPhone.clear();
        textFieldSurname.clear();



    }

    public void findContact() {
        name = textFieldFindByName.getText();
        surname = textFieldFindBySurname.getText();
        if(name.isEmpty() || surname.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter name and surname");
            alert.showAndWait();
            return;
        }
        Contact contact = new Contact(name, surname);
        listViewFindContact.getItems().addAll(phonebookController.findContact(contact));

        textFieldFindByName.clear();
        textFieldFindBySurname.clear();
    }

    public void deleteContact() {

        name = textFieldNameDelete.getText();
        surname = textFieldSurnameDelete.getText();
        if(name.isEmpty() || surname.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter name and surname");
            alert.showAndWait();
            return;
        }
        Contact contact = new Contact(name, surname);
        phonebookController.removeContact(contact);
        textFieldNameDelete.clear();
        textFieldSurnameDelete.clear();
        viewAllContacts();

    }

    public void viewAllContacts(){
        listView.getItems().clear();

       listView.getItems().addAll(phonebookController.viewAllContacts());

    }
//
//    public void selectFromAllContactsButton(){
//        String textAreaString = "";
//        ObservableList listOfContacts = listView.getSelectionModel().getSelectedItems();
//        for(Object contact : listOfContacts){
//            textAreaString += contact;
//
//        }
//        this.viewAllContacts.setText(textAreaString);
//    }



}


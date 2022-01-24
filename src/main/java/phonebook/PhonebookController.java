package phonebook;

import java.sql.SQLException;
import java.util.ArrayList;

public class PhonebookController {

    PhonebookRepository phonebookRepository = new PhonebookRepository();

    public String createTableContacts(){
        try {
            phonebookRepository.createTableContacts();
            return "Table \"Contacts\" created successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating table \"Contacts\"";
        }
    }

    public String addContact(Contact contact){
        try {
            phonebookRepository.addContact(contact);
            return "Contact added successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error adding contact";
        }
    }

    public ArrayList<Contact> viewAllContacts(){
        try {
            return phonebookRepository.viewAllContacts();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Contact> findContact(Contact contact){
        try {
            return phonebookRepository.findContact(contact);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void removeContact(Contact contact){
        try {
            phonebookRepository.removeContact(contact);
            System.out.println("Contact removed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

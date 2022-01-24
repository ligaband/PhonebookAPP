package phonebook;

import database.DBHandler;

import java.sql.*;
import java.util.ArrayList;

public class PhonebookRepository {

    DBHandler dbHandler = new DBHandler();

    public void createTableContacts() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS contacts (id int primary key not null auto_increment, name VARCHAR (255) not null, surname VARCHAR (255) not null, phone_number VARCHAR (255), email VARCHAR (255))";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.execute();
        preparedStatement.close();

    }

    public void addContact(Contact contact) throws SQLException{
        String query = "INSERT INTO contacts (name, surname, phone_number, email) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1, contact.getName());
        preparedStatement.setString(2, contact.getSurname());
        preparedStatement.setString(3, contact.getPhoneNumber());
        preparedStatement.setString(4, contact.getEmail());

        preparedStatement.execute();
        preparedStatement.close();

    }

    public ArrayList<Contact> viewAllContacts() throws SQLException{
        String query = "SELECT * FROM contacts ORDER BY name ASC";
        Statement statement = dbHandler.getConnection().createStatement();
        ResultSet result =statement.executeQuery(query);

        ArrayList<Contact> contacts = new ArrayList<>();

        while (result.next()){
            int id = result.getInt("id");
            String name = result.getString("name");
            String surname = result.getString("surname");
            String phoneNumber = result.getString("phone_number");
            String email = result.getString("email");


           Contact contact = new Contact(id, name, surname, phoneNumber, email);


            contacts.add(contact);

        }
        return contacts;
    }

    public ArrayList<Contact> findContact(Contact contact) throws SQLException {
        String query = "SELECT * FROM contacts WHERE name=? AND surname=?";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1, contact.name);
        preparedStatement.setString(2, contact.surname);
        preparedStatement.execute();

        ResultSet result = preparedStatement.getResultSet();
        ArrayList<Contact> contacts = new ArrayList<>();

        while (result.next()) {
            int id = result.getInt("id");
            String contactName = result.getString("name");
            String surname = result.getString("surname");
            String phoneNumber = result.getString("phone_number");
            String email = result.getString("email");

            contact = (new Contact(id, contactName, surname, phoneNumber, email));
            contacts.add(contact);
        }
        preparedStatement.close();
        return contacts;

    }

    public void removeContact(Contact contact) throws SQLException{
        String query = "DELETE FROM contacts WHERE name=? AND surname=?";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1, contact.name);
        preparedStatement.setString(2, contact.surname);
        preparedStatement.execute();
        preparedStatement.close();

    }



}

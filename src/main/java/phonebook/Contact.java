package phonebook;

public class Contact {
    public int id;
    public String name;
    public String surname;
    public String phoneNumber;
    public String email;

    public Contact(String name, String surname, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Contact(int id, String name, String surname, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Contact() {
    }

    public Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return

                         name + " " +
                        surname +
                        "\nphone number: " + phoneNumber +
                        "\nemail: " + email;

    }

//    //@Override
//    public String toString2() {
//        return name + surname;
//    }
}

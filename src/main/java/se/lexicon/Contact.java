package se.lexicon;
public class Contact {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;

    public Contact(String firstName, String lastName,
                   String phone, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName
                + " | Phone: " + phone
                + " | Email: " + email
                + " | Address: " + address;
    }
}

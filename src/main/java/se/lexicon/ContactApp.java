package se.lexicon;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactApp {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    void main() {
        System.out.println("Welcome to Contact Management App");

        boolean running = true;

        while (running) {
            System.out.println("\n==================================");
            System.out.println("  CONTACT MANAGEMENT APP");
            System.out.println("==================================");
            System.out.println("1. Add New Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact by Email");
            System.out.println("4. Delete Contact by Phone");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = getValidChoice();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContactByEmail();
                    break;
                case 4:
                    deleteContactByPhone();
                    break;
                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1-5.");
            }
        }

        scanner.close();
    }

    static int getValidChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine();
            System.out.print("Choose an option (1-5): ");
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    static void addContact() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter address: ");
        String address = scanner.nextLine().trim();

        if (firstName.isEmpty() || lastName.isEmpty()
                || phone.isEmpty() || email.isEmpty()
                || address.isEmpty()) {
            System.out.println("Error: All fields are required.");
            return;
        }

        if (isEmailDuplicate(email)) {
            System.out.println("Error: This email already exists.");
            return;
        }

        Contact contact = new Contact(
                firstName, lastName, phone, email, address
        );

        contacts.add(contact);

        System.out.println("Contact added successfully!");
    }

    static boolean isEmailDuplicate(String email) {
        for (Contact contact : contacts) {
            if (contact.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }

        return false;
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Your contact list is empty.");
            return;
        }

        System.out.println("\n--- All Contacts ---");

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    static void searchContactByEmail() {
        System.out.print("Enter email to search: ");
        String email = scanner.nextLine().trim();

        for (Contact contact : contacts) {
            if (contact.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Contact found:");
                System.out.println(contact);
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    static void deleteContactByPhone() {
        System.out.print("Enter phone number to delete: ");
        String phone = scanner.nextLine().trim();

        Contact contactToRemove = null;

        for (Contact contact : contacts) {
            if (contact.getPhone().equals(phone)) {
                contactToRemove = contact;
                break;
            }
        }

        if (contactToRemove != null) {
            contacts.remove(contactToRemove);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found. Nothing was deleted.");
        }
    }
}

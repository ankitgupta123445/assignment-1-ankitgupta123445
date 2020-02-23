package implementation;

import definition.ContactList;
import definition.Person;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                ContactList<Person> contact = new ContactList<>();
                Scanner sc = new Scanner(System.in);
                System.out.println("Welcome to Ankit's Contact List App");
                int k = sc.nextInt();
                while (k != 5) {
                        System.out.println("<----------x------x---------->");
                        System.out.println("Press 1 to add a new contact");
                        System.out.println("Press 2 to view all contacts");
                        System.out.println("Press 3 to search for a contact");
                        System.out.println("Press 4 to delete a contact");
                        System.out.println("Press 5 to exit program ");
                        System.out.println("<-----------x------x---------->");
                        String choice = sc.nextLine();
                        switch (choice) {
                                case "1":

                                        break;
                                case "2":
                                        break;
                                case "3":
                                        break;
                                case "4":
                                        break;
                                case "5":

                                default:
                                        System.out.println("Invalid choice!! Please select a valid choice.");
                        }
                }

        }
}

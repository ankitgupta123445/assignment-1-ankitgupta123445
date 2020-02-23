package definition;

import java.util.ArrayList;
import java.util.Scanner;

public class Operational {
        Scanner sc = new Scanner(System.in);

        public void addContact(ContactList<Person> link) {
                ArrayList<String> list1 = new ArrayList<>();
                System.out.println("PLease fill the contact detail");
                System.out.println("Please enter the name of the Person");
                System.out.print("FirstName :");
                String First = sc.next();
                System.out.print("LastName:");
                String Last = sc.next();
                System.out.println("Contact Number");
                list1.add(sc.next());
                System.out.println("Would you like to add another number :y/n");
                String input = sc.next();
                if (input.equals("y")) {
                        list1.add(sc.next());
                } else if (input.equals("n")) {
                        int p = 1;
                } else {
                        System.out.println("Hey ! please enter valid command");
                }
                System.out.println("Would you want to add email Id :y/n");
                String order1 = sc.next();
                String email = "";
                if (order1.equals("y")) {
                        email = sc.nextLine();
                } else if (order1.equals("n")) {
                        int p = 1;
                } else {
                        System.out.println("Hey ! please enter valid command");
                }
                link.addContact(new Person(First, Last, list1, email));
        }

        public void viewContact(ContactList<Person> link) {

        }

}

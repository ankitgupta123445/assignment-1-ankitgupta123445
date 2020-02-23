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
                sc.nextLine();
                String order1 = sc.nextLine();
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
                ContactList<Person> cont = new ContactList<>();
                cont = link.sort(link);
                cont.print();
        }

        public void searchContact(String name, ContactList lis) {
                int c = lis.search(name);
                if (c == 0) {
                        System.out.println("NO RESULTS FOUND!");
                } else if (c >= 1) {
                        System.out.println(c + " " + "match found!");
                        lis.printSearchitem(name);
                }
        }

        public void deleteContact(ContactList list) {
                String store = "";
                System.out.println("Here are all your contacts:");
                list.show();
                System.out.println("Press the number against the contact to delete it:");
                int ch = sc.nextInt();
                store = list.getNode(ch - 1).getData().getFirstName() + list.getNode(ch - 1).getData().getLastName();
                boolean c = list.deleteContact(ch - 1);
                System.out.println(c == true ? store + "s" + "contact deleted from list!" : "");
        }


}

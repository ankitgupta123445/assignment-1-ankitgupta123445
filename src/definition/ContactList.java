package definition;

import adt.ContactAdt;

public class ContactList<E> implements ContactAdt<E> {
        private Node<E> head = null;
        private int size = 0;

        public Node<E> getNode(int index) {
                Node<E> response = head;
                for (int i = 0; i < index; i++) {
                        response = response.getNext();
                }
                return response;
        }

        // add method
        private void addFirst(Person item) {
                Node<E> temp = new Node<>(item, head);
                head = temp;
                size++;
        }

        private void addAfter(Node<E> node, Person item) {
                Node<E> newNode = new Node<E>(item, node.getNext());
                node.next = newNode;
                size++;
        }

        public void addContact(Person item, int index) {
                if (index == 0) {
                        addFirst(item);
                } else {
                        addAfter(getNode(index - 1), item);
                }

        }

        @Override
        public void addContact(Person person) {
                addContact(person, size);
        }

        // get list of all contact
        private Person viewAContact(Node<E> node) {
                Person response = null;
                response = node.getData();
                return response;
        }

        @Override
        public void viewContact() {
                for (int i = 0; i < size; i++) {
                        Node<E> temp = this.getNode(i);
                        System.out.println(temp.getData());
                }
        }


        // search contact
        @Override
        public int search(String item) {
                Node check = head;
                int c = 0;
                while (check != null) {
                        if (check.data.getFirstName().equals(item)) {
                                c++;
                        } else if (check == null) {
                                int d = 0;

                        }
                        check = check.next;

                }
                return c;
        }

        public void printSearchitem(String name) {
                Node check = head;
                while (check != null) {
                        System.out.println("........*.......*.......*.......*");
                        if (check.data.getFirstName().equals(name)) {
                                System.out.print("FirstName :" + check.data.getFirstName() + "\n");
                                System.out.println("LastName :" + check.data.getLastName());
                                if (check.data.getContactNo().size() > 1) {
                                        System.out.println("Contacts :" + check.data.getContactNo());

                                } else if (check.data.getContactNo().size() == 1) {
                                        System.out.println("Contact :" + check.data.getContactNo());
                                }
                                System.out.println("email iD :" + check.data.getEmailAddress());
                                System.out.println("........*.......*.......*.......*");

                        }
                        check = check.next;
                }
        }


        //delete Method
        private Person removeAfter(Node node) {
                Person response = null;
                Node temp = node.getNext();
                if (temp != null) {
                        node.next = temp.getNext();
                        size--;

                        response = temp.getData();
                }
                return response;
        }

        private Person removeFirst() {
                Person response = null;
                Node temp = head;
                if (head != null) {
                        head = head.getNext();
                }
                if (temp != null) {
                        size--;
                        response = temp.getData();
                }
                return response;
        }

        @Override
        public boolean deleteContact(int index) {
                Person response = null;
                boolean re = false;
                if (index < 0 || index > size) {
                        throw new IndexOutOfBoundsException(Integer.toString(index));
                } else if (index == 0) {
                        response = removeFirst();

                        re = true;
                } else {
                        Node pr = getNode(index - 1);
                        response = removeAfter(pr);
                        re = true;
                }
                return re;
        }

        public void print() {
                Node reference = head;
                System.out.println("........*.......*.......*.......*");
                while (reference != null) {
                        System.out.print("FirstName :" + reference.data.getFirstName() + "\n");
                        System.out.println("LastName :" + reference.data.getLastName());
                        if (reference.data.getContactNo().size() > 1) {
                                System.out.println("Contacts :" + reference.data.getContactNo());

                        } else if (reference.data.getContactNo().size() == 1) {
                                System.out.println("Contact :" + reference.data.getContactNo());
                        }
                        System.out.println("email iD :" + reference.data.getEmailAddress());
                        System.out.println("........*.......*.......*.......*");
                        System.out.println("........*.......*.......*.......*");
                        reference = reference.next;
                }
        }

        public void show() {
                Node temp = head;
                for (int i = 0; i < size; i++) {
                        if (temp != null) {
                                String name = temp.data.getFirstName() + " " + temp.data.getLastName();
                                System.out.println(i + 1 + " . " + name);
                        } else {
                                System.out.println(" No contact found");
                        }
                        temp = temp.next;
                }
        }

        public ContactList<Person> sort(ContactList<Person> lis) {
                Node check = head;
                Node index = null;
                int status;
                if (head == null) {
                        return lis;
                } else {
                        while (check != null) {
                                index = check.next;
                                while (index != null) {
                                        status = check.data.getFirstName().compareToIgnoreCase(index.data.getFirstName());
                                        if (status > 0) {
                                                Person temp = check.data;
                                                check.data = index.data;
                                                index.data = temp;
                                                index = index.next;
                                        } else {
                                                index = index.next;
                                        }
                                }
                                check = check.next;
                        }
                }
                return lis;
        }


        //Node class

        static class Node<E> {

                private Person data;
                private Node<E> next;

                public Node(Person data, Node<E> next) {
                        this.data = data;
                        this.next = next;
                }

                public Person getData() {
                        return data;
                }

                public Node<E> getNext() {
                        return next;
                }
        }
}

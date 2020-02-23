package definition;

import adt.ContactAdt;

public class ContactList<E> implements ContactAdt<E> {
        private Node<E> head = null;
        private int size = 0;

        private Node<E> getNode(int index) {
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
        public void searchContact(Person person) {

                for (int i = 0; i < size; i++) {
                        if (person.getFirstName().equals(this.getNode(i).getData().getFirstName())) {
                                Node<E> temp = this.getNode(i);
                                System.out.println(temp.getData());
                        } else {
                                System.out.println("NO RESULTS FOUND!");
                        }
                }
        }


        //delete Method
        private Person removeFirst() {
                Person response = null;

                Node<E> temp = head;
                if (head != null) {
                        head = head.getNext();
                        response = temp.getData();
                        size--;
                }
                return response;
        }

        private Person removeAfter(Node<E> node) {
                Person response = null;
                if (node.next != null) {
                        node.next = node.getNext().getNext();
                        size--;
                        response = node.getNext().getData();
                }
                return response;
        }

        @Override
        public Person deleteContact(int index) {
                Person response = null;
                if (index < 0 || index > size) {
                        throw new IndexOutOfBoundsException(Integer.toString(index));
                } else if (index == 0) {
                        response = removeFirst();
                } else {
                        response = removeAfter(getNode(index - 1));
                }
                return response;
        }


        //Node class

        private static class Node<E> {

                private Person data;
                private Node<E> next;

                private Node(Person data, Node<E> next) {
                        this.data = data;
                        this.next = next;
                }

                private Person getData() {
                        return data;
                }

                private Node<E> getNext() {
                        return next;
                }
        }
}

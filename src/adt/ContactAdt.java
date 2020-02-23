package adt;

import definition.Person;

public interface ContactAdt<E> {
        void addContact(Person person);


        void viewContact();

        int search(String item);

        boolean deleteContact(int index);
}

package adt;

import definition.Person;

public interface ContactAdt<E> {
        void addContact(Person person);


        void viewContact();

        void searchContact(Person person);

        Person deleteContact(int index);
}

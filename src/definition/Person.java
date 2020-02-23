package definition;

import java.util.ArrayList;


public class Person<E> {
        private String firstName;
        private String lastName;
        private ArrayList<String> contactNo;
        private String emailAddress;

        public Person(String firstName, String lastName, ArrayList<String> contactNo, String emailAddress) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.contactNo = contactNo;
                this.emailAddress = emailAddress;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public ArrayList<String> getContactNo() {
                return contactNo;
        }

        public void setContactNo(ArrayList contactNo) {
                this.contactNo = contactNo;
        }

        public String getEmailAddress() {
                return emailAddress;
        }

        public void setEmailNo(String emailNo) {
                this.emailAddress = emailAddress;
        }


}

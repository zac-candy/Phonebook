/* 
Data Structures Assignment - 1
Starting Date : 1/12/21
Submission date : 5/12/21

A Phone directory application created by Chandan M. S and Suman S.
Created using circular singly linked list.
Contains the following operations -
1. Add a contact to the phonebook
2. Delete contact/s from a phonebook
3. display all the contacts in that phonebook
4. filter the contacts of the phonebook
5. search for a contact in the phonebook
6. Save all the contacts in a text file
*/


import java.util.*;

class Phonebook {
    class Contact {
        String fname;
        String lname;
        String number;
        Boolean favorite;
        Contact next;

        //constructor for contact

        Contact(String fname, String lname, String number) {
            this.fname = fname;
            this.lname = lname;
            this.number = number;
            this.next = null;
        }
    }

    Contact last = null;


    //method to display the contacts in the phonebook
    void display() {
        System.out.println("\t\tPhone Directory\n\t-------------------------------");
        if(last == null) {
            System.out.println("No records Found!!");
        } else {
            Contact temp = last.next;
            do {
                System.out.println("\t " + temp.fname + " " + temp.lname + "\t" + temp.number);
                temp = temp.next;
            } while (temp != last.next);
        }
    }

    //method to add contacts to the phonebook
    void addContact(String fname, String lname, String number) {
        Contact newct = new Contact(fname,lname,number);
        if(last == null) {
            last = newct;
            newct.next = last;
        } else {
            newct.next= last.next;
            last.next = newct;
        }
    }

    //method to delete contact

    
}
















public class PhoneDirectory {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        Phonebook chandan = new Phonebook();
        chandan.addContact("chandan", "M S", "6363224034");
        chandan.display();




    }
}

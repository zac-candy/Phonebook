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
6. Change the first name of the given contact
7. Change the last name of the given contact
8. Change the number of the given contact

*/


import java.util.*;

class Phonebook {
    class Contact {
        String fname;
        String lname;
        String number;
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
        System.out.println("First Name         Last Name         Number");
        System.out.println("-------------------------------------------");
        if(last == null) {
            System.out.println("No records Found!!");
        } else {
            Contact temp = last.next;
            do {
                System.out.println(temp.fname + "\t           " + temp.lname + "\t         " + temp.number);
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

    //method to delete contact/s from the phonebook
    void deleteContact(String key) {
        if(last == null) {
            System.out.println("Directory empty");
        } else {
            Contact cur = last.next;
            String space = " ";
            do {
                if(key.equals(cur.next.fname.concat(space.concat(cur.next.lname)))) {
                    cur.next = cur.next.next;
                    break;
                }
                cur = cur.next;
            } while(cur != last.next);
        }
    }


    //method to search for a contact in a phonebook
    void searchContact(String key) {
        if(last == null) {
            System.out.println("Directory empty");
        } else {
            Contact cur = last.next;
            String space = " ";
            do {
                if(key.equals(cur.fname.concat(space.concat(cur.lname)))) {
                    System.out.println("Contact : " + cur.number);
                    break;
                }
                cur = cur.next;
            } while(cur != last.next);
        }
    }



    //method to filter contacts in a phonebook
    void filter(String key) {
        if (last == null) {
            System.out.println("Empty Directory");
        } else {
            Contact temp = last.next;
            do {
                if(temp.fname.contains(key) || temp.lname.contains(key)) {
                    System.out.println(temp.fname + " " + temp.lname + " " + temp.number);
                    break;
                }
                temp = temp.next;
            } while (temp != last.next);
        }
    }

    //method to change first name
    void changeFname(String fullname, String name) {
        if(last == null) {
            System.out.println("Directory empty");
        } else {
            Contact cur = last.next;
            String space = " ";
            do {
                if(fullname.equals(cur.fname.concat(space.concat(cur.lname)))) {
                    cur.fname = name;
                    break;
                }
                cur = cur.next;
            } while(cur != last.next);
        }
    }

    //method to change last name
    void changeLname(String fullname, String name) {
        if(last == null) {
            System.out.println("Directory empty");
        } else {
            Contact cur = last.next;
            String space = " ";
            do {
                if(fullname.equals(cur.fname.concat(space.concat(cur.lname)))) {
                    cur.lname = name;
                    break;
                }
                cur = cur.next;
            } while(cur != last.next);
        }
    }


    //method to change number
    void changeNum(String fullname, String number) {
        if(last == null) {
            System.out.println("Directory empty");
        } else {
            Contact cur = last.next;
            String space = " ";
            do {
                if(fullname.equals(cur.fname.concat(space.concat(cur.lname)))) {
                    cur.number = number;
                    break;
                }
                cur = cur.next;
            } while(cur != last.next);
        }
    }
}

//This class represents the user interface of the application


public class PhoneDirectory {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        Phonebook chandan = new Phonebook();
        Boolean flag = true;
        System.out.println("Welcome to the Phone Directory!!!");
        while(flag) {
            int choice;
            System.out.println("Please select the operation/s to perform");
            System.out.println("1.View the directory\n2.Add contact\n3.Delete contact\n4.search contact\n5.Change first name\n6.Change last name\n7.Change contact number\n8.filter contacts\n9.Exit");
            System.out.println("Enter your choice");
            choice = read.nextInt();
            read.nextLine();

            switch(choice) {
                case 1: 
                    chandan.display();
                    break;
                
                case 2:
                    System.out.println("Enter first name:");
                    String fn = read.nextLine();
                    System.out.println("Enter last name");
                    String ln = read.nextLine();
                    System.out.println("Enter the number");
                    String num = read.nextLine();
                    chandan.addContact(fn, ln, num);
                    System.out.println("Number Added Successfully!");
                    break;
                
                case 3:
                    System.out.println("Enter the full name of the contact");
                    String dl = read.nextLine();
                    chandan.deleteContact(dl);
                    System.out.println("Contact Deleted successfully!");
                    break;

                case 4:
                    System.out.println("Enter full name of the contact");
                    String src = read.nextLine();
                    chandan.searchContact(src);
                    break;

                case 5:
                    System.out.println("Enter full name of the contact");
                    String rep = read.nextLine();
                    System.out.println("Enter the new first name");
                    String ne = read.nextLine();
                    chandan.changeFname(rep, ne);
                    break;

                case 6:
                    System.out.println("Enter full name of the contact");
                    String re = read.nextLine();
                    System.out.println("Enter the new last name");
                    String neww = read.nextLine();
                    chandan.changeLname(re, neww);
                    break;

                case 7:
                    System.out.println("Enter full name of the contact");
                    String r = read.nextLine();
                    System.out.println("Enter the new number");
                    String n= read.nextLine();
                    chandan.changeNum(r, n);
                    break;

                case 8:
                    System.out.println("Enter the prompt");
                    String pmt = read.nextLine();
                    chandan.filter(pmt);
                    break;
                    
                case 9:
                    System.out.println("Thank You for using the directory!");
                    flag = false;
                    break;

                default :System.out.println("Invalid choice. Please Enter valid choice");
            };
        }
        read.close();
    }
}

/*
Problem 1: 25 Points
Design a Singly Linked List from scratch using Node class. Insert [use insertion method
discussed in class] integers as data values between 1 to 100 in the Singly Linked List. Rotate the
Linked List for K= N, where N is the number of elements in the Linked List.
Example of Linked List Rotation:

Your Program should contain the following:
1. Insertion based on user input.
2. Number of Rotations based on user input.
3. Handle condition if try to rotate an empty Singly Linked List
4. If the user wants to stop entering values in a Linked List, then the user needs to enter -1.
5. Once the user enters -1, your program should print the rotated Singly Linked List on the
console.
6. Use Pointers to do the rotation Process. The program will be evaluated based on
Space Complexity. */
import java.util.Scanner;

public class Kaleb_Duchesneau_ProblemOne {
    // class implementation of Linked List
    static class LinkedList {
        Node head;

        static class Node {
            public int data;
            public Node next;
        
            Node(int d) {
                this.data = d;
                this.next = null;
            }
        
            Node(int d, Node n) {
                this.data = d;
                this.next = n;
            }
        }

        // insert method to add Nodes onto the linked list 
        public void insert(Node n) {
            // checking if list is empty
            if (this.head == null) {
                this.head = n;
            }
            else {
                Node last = this.head;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = n;
            }
        }
        
        // placing the tail in front of the head
        public void rotateList() {
            if (this.head == null) {
                return;
            }
            else {
                Node last = this.head;
                Node previous = last;
                while (last.next != null) {
                    previous = last;
                    last = last.next;
                }

                previous.next = null;
                last.next = this.head;
                this.head = last;
                return;
            }
        }

        public void printList(){
            if (this.head == null) {
                System.out.println("[]");
                return;
            }

            Node last = this.head;
            System.out.print("[");
            while (last.next != null) {
                System.out.print(last.data + " -> ");
                last = last.next;
            }
            System.out.println(last.data + " -> null]"); 
        }
        
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            
            // taking in the number of rotations first so the operation can be performed immediately
            System.out.print("Enter the number of rotations to perform on the list: ");
            int k = in.nextInt();

            // taking user input for the values in the linked list, with -1 as terminating value
            System.out.print("Enter the values in the Linked List seperated by a space (-1 to terminate): ");
            LinkedList list = new LinkedList();
            while (in.hasNextInt()) {
                int data = in.nextInt();
                if (data == -1) {
                    break;
                }
                else {
                    Node newNode = new Node(data);
                    list.insert(newNode);
                }
            }

            // printing the original list and showing the roatations
            System.out.print("list: ");
            list.printList();
            for (int i = 1; i <= k; i++) {
                System.out.print("Rotation " + i + ": ");
                list.rotateList(); 
                list.printList();
            }
            
            in.close();
        }
    }
}
/*
Problem 2: [10+15] 25 Points
Design a Singly Linked List from scratch using Node class. Initialize the head and tail pointer
as null. Insert [use insertion method discussed in class] integers as data values between 1 to 100
in the Singly Linked List. Reverse the Linked List.
Example of Linked List Reversal:
Tail
Head

Null

Null

Null

2

1

1

2

Null

Null??????

Null??????

Head
Tail

Your Program should contain the following:
1. Insertion based on user input.
2. Handle condition if try to reverse an empty Singly Linked List
3. If the user wants to stop entering values in a Linked List, then the user needs to enter -1.
4. Once the user enters -1, your program should print the reversed Singly Linked List on the console.
5. Use Pointers to do the reversal Process. The program will be evaluated based on Space
Complexity. 
Implement the same for a Doubly Linked List.
 */
import java.util.Scanner;

public class Kaleb_Duchesneau_ProblemTwo_A {
    static class LinkedList {
        Node head;
        Node tail;

        static class Node {
            int data;
            Node next;

            Node(int d) {
                this.data = d;
                this.next = null;
            }

            Node(int d, Node n) {
                this.data = d;
                this.next = n;
            }
        }

        public void insert(Node n) {
            if (this.head == null) {
                this.head = n;
            }
            else {
                Node last = this.head;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = n;
                this.tail = n;
            }
        }

        public void reverseList() {
            if (this.head == null) {
                return;
            }
            else {
                Node temp = this.head;
                this.head = this.tail;
                this.tail = temp;

                Node current = this.tail;
                Node previous = null;
                while (current.next != null) {
                    temp = current.next;
                    current.next = previous;
                    previous = current;
                    current = temp;
                }
                current.next = previous;
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

            System.out.print("List: ");
            list.printList();
            list.reverseList();
            System.out.print("Reversed List: ");
            list.printList();

            in.close();
        }
    }
}
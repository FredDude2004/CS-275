/*
Problem 4: [10 Points]

Write a different static method that performs the same operation as the one in question 3, but
it does so constructively instead of destructively.

Write a complete java program showing the operation.

Note: Please refer to this documentation under the section titled Methods which take ArrayList arguments for
understanding the concept of constructive and destructive methods.
 */

 import java.util.ArrayList;

 public class Problem_4 {
     public static ArrayList<String> EliminateElements(ArrayList<String> strings, int n) {
         ArrayList<String> result = new ArrayList<>();
         // using a for each loop and checking if it should go in our new list that we constructed
         for (String string : strings) {
             if (string.length() >= n) {
                 result.add(string);
             }
         }
         return result;
     }
     public static void main(String[] args) {
         ArrayList<String> list = new ArrayList<>();
         // initializing an ArrayList and printing it to show the list before the operation
         list.add("tomato");
         list.add("cheese");
         list.add("chips");
         list.add("Fruit");
         list.add("Pie");
         list.add("butter");
         list.add("tea");
         list.add("buns");
         System.out.println("Original array before operation: " + list.toString());
        // performing the operation and printing the modified list and the original list again to show the constructive aspect of the method
         ArrayList<String> result = EliminateElements(list, 4);
         System.out.println("Modified array after operation: " + result.toString());
         System.out.println("Original array after operation: " + list.toString());
     }
 }

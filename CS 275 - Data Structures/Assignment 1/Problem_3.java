/*
Problem 3: [15 Points]

Write a static method that takes an ArrayList of Strings and an integer and modifies the
ArrayList destructively to eliminate all Strings whose length is less than the integer argument.
So, if the integer argument is 4 and the ArrayList is the following:

    Tomato       cheese       chips       Fruit       Pie          butter       tea       buns

After performing the operation, we will have the following output:

    Tomato       cheese       chips       Fruit       butter       buns

Write a complete java program showing the operation.
 */
import java.util.ArrayList;

public class Problem_3 {
    public static ArrayList<String> EliminateElements(ArrayList<String> strings, int n) {
        // iterating through the loop backwards so there are no problems with removing elements while iterating
        for (int i = strings.size() - 1; i > -1; i--) {
            if (strings.get(i).length() < n) {
                strings.remove(i);
            }
        }
        return strings;
    }
    public static void main(String[] args) {
        // initializing an ArrayList and printing it to show how it was before the operation
        ArrayList<String> list = new ArrayList<>();
        list.add("tomato");
        list.add("cheese");
        list.add("chips");
        list.add("Fruit");
        list.add("Pie");
        list.add("butter");
        list.add("tea");
        list.add("buns");
        System.out.println("Original array before operation: " + list.toString());
        // performing the operation and printing the modified array and the original again to show the destructive aspect of the method
        ArrayList<String> result = EliminateElements(list, 4);
        System.out.println("Modified array after operation: " + result.toString());
        System.out.println("Original array after operation: " + list.toString());
    }
}

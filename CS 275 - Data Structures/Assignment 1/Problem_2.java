/*
Problem 2: [10 Points]

Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1
and 2, the first 10 terms will be:1, 2, 3, 5, 8, 13, 21, 34, 55, 89, …

By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of
the even-valued terms. */

public class Problem_2 {
    public static void main(String[] args) {
        int previous = 1;
        int current = 2;
        int sum = 0;
        int next;

        while (current < 4_000_000) {
            if (current % 2 == 0) {
                sum += current;
            }
            next = previous + current;
            previous = current;
            current = next;
        }

        System.out.println("The sum of the even-valued terms in the Fibonacci sequence that don't exceed 4,000,000 is: " + sum);
    }
}
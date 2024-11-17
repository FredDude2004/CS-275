/*1.  Given the root of a binary tree and an integer targetSum, return true if the tree has
    a root-to-leaf path such that adding up all the values along the path equals targetSum.

    A leaf is a node with no children.

    Example 1:

              5
             /\
            4  8
           /   /\
          11  13 4
         / \      \
        7   2      1

    User Input [using Java Scanner]: root = [5,4,8,11, null,13,4,7,2,null,null,null,1], targetSum = 22
    Output: true
    Explanation: The root-to-leaf path with the target sum is shown.

    Example 2:

         1
        / \
       2   3

    User Input [using Java Scanner]: root = [1,2,3], targetSum = 5
    Output: false
    Explanation: There are two root-to-leaf paths in the tree:

    (1 --> 2): The sum is 3.
    (1 --> 3): The sum is 4.

    There is no root-to-leaf path with sum = 5.

    Example 3:

    Input: root = [], targetSum = 0
    Output: false
    Explanation: Since the tree is empty, there are no root-to-leaf paths.



    Constraints:
        •   The number of nodes in the tree is in the range [0, 5000].
        •   -1000 <= Node.val <= 1000
        •   -1000 <= targetSum <= 1000 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kaleb_Duchesneau_ProblemOne {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        public BinaryTree() {
            root = null;
        }

        // Method to create a binary tree from a level-order array
        public void createTreeFromLevelOrder(ArrayList<Integer> nodeList) {
            if (nodeList.isEmpty()) {
                root = null;
                return;
            }

            // Initialize root with the first element in the nodeListay
            root = new Node(nodeList.get(0));
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            int i = 1;
            while (!queue.isEmpty() && i < nodeList.size()) {
                Node current = queue.poll();

                // Assign left child
                if (nodeList.get(i) != null) {
                    current.left = new Node(nodeList.get(i));
                    queue.add(current.left);
                }
                i++;

                // Assign right child
                if (i < nodeList.size() && nodeList.get(i) != null) {
                    current.right = new Node(nodeList.get(i));
                    queue.add(current.right);
                }
                i++;
            }
        }

        public void printLevelOrder() {
            if (root == null) return;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                System.out.print((node != null ? node.key : "null") + " ");

                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
        
        public static boolean hasPathSum(Node root, int targetSum) {
            // Base case
            if (root == null) {
                return false;
            }
            
            // Check if we've reached a leaf node with the exact target sum
            if (root.left == null && root.right == null) {
                return root.key == targetSum;
            }
            
            // Reduce the target sum by the current node's key
            targetSum -= root.key;
            
            // Recur on left and right children
            return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
        }
        
        // Helper method for initializing tree
        public static boolean isInteger(String str) {
            try {
                Integer.parseInt(str);
                return true;
            }
            catch (NumberFormatException e) {
                return false;
            }        
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            
            // initializing a Binary-Tree
            BinaryTree tree = new BinaryTree();
            System.out.print("Enter the values of the tree in level-order seperated by a space (negative number to terminate): ");
            ArrayList<Integer> nodeList = new ArrayList<>();
            while (true) {
                String str = in.next();
                if (str.equals("null") || str.isEmpty()) {
                    nodeList.add(null);
                }
                else if (isInteger(str)) {
                    int n = Integer.parseInt(str);
                    if (n < 0) { break; }
                    nodeList.add(n);
                }
            }
            tree.createTreeFromLevelOrder(nodeList);
            // Printing to ensure correct inputs
            tree.printLevelOrder();

            int targetSum;
            System.out.print("Enter the target sum: ");
            while (true) {
                String str = in.next();
                if (isInteger(str)) {
                    targetSum = Integer.parseInt(str);
                    break;
                }   
                System.out.print("Invalid input -Enter an integer: ");
            }

            // checking root to leaf paths to see if they add up to the target sum
            System.out.println(hasPathSum(tree.root, targetSum));

            in.close();
        }
    }
}
/*2.
    There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n (inclusive).
    The edges in the graph are represented as a 2D integer array edge, where
    each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex
    pair is connected by at most one edge, and no vertex has an edge to itself.

    You want to determine if there is a valid path that exists from vertex source to vertex destination.
    Given edges and the integers n, source, and destination, return true if there is a valid
    path from source to destination, or false otherwise.

    Example 1:

       0---1
        \ /
         2

    User Input [using Java Scanner]: n = 3, edges = [[0,1], [1,2],[2,0]], source = 0, destination = 2
    Output: true
    Explanation: There are two paths from vertex 0 to vertex 2:

    -0→1→2
    -0→2

    Example 2:

         1   3
        /    | \
       0     |  5
        \    | /
         2   4

    User Input [using Java Scanner]: n = 6, edges = [0,1], [0,2], [3,5],[5,4],[4,3]], source = 0, destination = 5
    Output: false

    Explanation: There is no path from vertex 0 to vertex 5.

    Constraints:

    1 <= n <= 2 * 105
    0 <= edges.length <= 2 * 105
    edges[i].length == 2
    0 <= ui, vi <= n - 1
    ui! = vi
    0 <= source, destination <= n - 1
    There are no duplicate edges.
    There are no self-edges. */
    
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kaleb_Duchesneau_ProblemTwo {

    public static boolean validPath(int numOfVertices, List<int[]> edges, int source, int destination) {
        if (source == destination) return true;
        
        // Build Graph with ArrayList: With the index of the list being the Vertex, The List at each index holding all of its neighbors
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numOfVertices; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int vertexOne = edge[0];
            int vertexTwo = edge[1];
            graph.get(vertexOne).add(vertexTwo); // Add each vertex to the Neighbor list for both verticies because list is undirected
            graph.get(vertexTwo).add(vertexOne);
        }
        
        // Search if there is a valid path from the source to the destination
        Queue<Integer> queue = new LinkedList<>(); // Initialize a Queue the store the verticies to search
        boolean[] visited = new boolean[numOfVertices]; // Boolean Array to store if a vertex has been visited
        
        queue.add(source); 
        visited[source] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            // If we reach the destination, return true
            if (current == destination) return true;
            
            // Explore neighbors
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        // If the search completes without finding destination, return false
        return false;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // Read input
        System.out.print("Enter number of Verticies n: ");
        int numOfVertices = in.nextInt();
        
        System.out.print("Enter the number of edges: ");
        int numOfEdges = in.nextInt();
        
        List<int[]> edges = new ArrayList<>();
        System.out.println("Enter each edge in format 'fromVertex toVertex':");
        for (int i = 0; i < numOfEdges; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            edges.add(new int[]{u, v});
        }
        
        System.out.print("Enter the source vertex: ");
        int source = in.nextInt();
        
        System.out.print("Enter the destination vertex: ");
        int destination = in.nextInt();
        
        in.close();
        
        // Check if path exists
        System.out.println(validPath(numOfVertices, edges, source, destination));
    }
}

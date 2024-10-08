// Java program to demonstrate use of circular 
// array using extra memory space 
import java.util.*; 
import java.lang.*; 

public class GfG{ 
 
 public static void print(char a[], int n, int ind) { 
 
  // Create an auxiliary array 
  // of twice size. 
  char[] b = new char[(2 * n)]; 

  // Copy a[] to b[] two times 
  for (int i = 0; i < n; i++) 
   b[i] = b[n + i] = a[i]; 

  // print from ind-th index to 
  // (n+i)th index. 
  for (int i = ind; i < n + ind; i++) 
   System.out.print(b[i]+" "); 
 } 
 
 // Driver code 
 public static void main(String args[]){ 
  char[] a = new char[]{ 'A', 'B', 'C', 
       'D', 'E', 'F' }; 
  int n = 6; 
  print(a, n, 3); 
 } 
} 



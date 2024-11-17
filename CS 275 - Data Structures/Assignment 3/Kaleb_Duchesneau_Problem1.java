/* Design a Hashtable using positive integers [K < 1000] with
hash function = K mod Hashtable[size] without using
built-in Java functions, where K is key. Use a load factor of
0.60 and implement rehashing, where every time the
rehashed table will be twice the size of the previous hash
table. [final table size no larger than 1000 slots].
Please refer to this documentation for definitions of
terms such as load factor.

Use Scanner to get the following user inputs:
1. Initial Hash Tablesize
2. Insert keys one by one
a. Remember the user can insert keys even after
the hash table is rehashed

Output :
1. After each key insertion print the key and its
corresponding value[index], the current hashtable
and the current load factor.
2. Once load factor > 0.60 print the rehashed table and
prompt the user to enter more keys.
3. The final rehashed table will not grow beyond 1000
slots. */

import java.util.Scanner;
import java.util.Arrays;

class Kaleb_Duchesneau_Problem1 {
    public static class HashTable {
        private int[] table;
        private int size;
        private int count;
        private double loadFactor;

        public HashTable(int initialSize) {
            this.size = initialSize;
            this.table = new int[initialSize];
            Arrays.fill(table, -1);
            this.count = 0;
            this.loadFactor = 0.0;
        }

        
        public void rehash() {
            // restricting table size to 1000
            int newSize = (size * 2) < 1000 ? size * 2 : 1000;
            
            int[] newTable = new int[newSize];
            Arrays.fill(newTable, -1);
            // put elements back into new table
            for (int i = 0; i < size; i++) {
                if (table[i] != -1) {
                    int newHash = table[i] % newSize;
                    newTable[newHash] = table[i];
                }
            }

            this.table = newTable;
            this.size = newSize;
            this.loadFactor = count / size;
            
            // print rehashed table
            System.out.println("Rehashed Table: " + Arrays.toString(newTable));
        }
        
        public int hash(int key) {
            return key % size;
        }

        public void insert(int key) {
            if (count >= size * 0.6) {
                rehash();
            }

            int index = hash(key);
            table[index] = key;
            count++;
            loadFactor = count / size;

            // Print details after insertion
            System.out.println("Key: " + key);
            System.out.println("Index: " + index);
            System.out.println("Hashtable: " + Arrays.toString(table));
            System.out.println("Load Factor: " + loadFactor);
        }



        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            System.out.print("Enter the size of the Hash Table: ");
            int initialSize = in.nextInt();

            HashTable hashTable = new HashTable(initialSize);
            System.out.print("Enter a key into the HashTable (negative number to terminate): ");

            boolean done = false;
            while (!done) {
                int key = in.nextInt();
                if (key < 0) {
                    done = true;
                }
                else {
                    hashTable.insert(key);
                }
            }

            System.out.println("Final Table: " + Arrays.toString(hashTable.table));

            in.close();
        }
    }
}
////////////////////////////////////////////////////
//
// Christian Chavez / 002
//
/////////////////////////////////////////////////////

import java.util.*;

/*
 *  Utility Methods Class
 * 
 *  This class contains utility methods that are used throughout 
 *  the program.
 */

class UtilMethods {

    /*
     * Hash Table Programming Exercise
     * 
     * Write a method that takes two arrays A and B, and returns
     * whether array B is a subset of array A. 
     *
     * USE a HashMap ADT to solve this problem.
     */
  
    public boolean isSubset(int list1[], int list2[]) {
      HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        // ADD YOUR CODE HERE, DO NOT FORGET TO ADD YOUR
        // NAME / SECTION NUMBER AT TOP OF FILE
      // insert elements for first array into the hashmap 
      for(int i : list1) {
        hm.put(i, 0);
      }

      // check if elements in the second array are in the hashmap
      // if one element isn't in the hashmap, return false
      for (int k : list2) {
        if (!hm.containsKey(k)) {
          return false;
        }
      }
  
      return true;
    }


   /*
    * Priority Queue 1 Programming Exercise
    *
    * Given an array A and integer k, return the k-th maximum
    * element in the array.
    *
    * USE a Priority Queue ADT to solve this problem.
    */
  
   public int findKthLargest(int[] array, int k) {
      Queue<Integer> pq = new PriorityQueue<>();
     // ADD YOUR CODE HERE

     // insert elements of array into the Priority queue, already sorted
     // with this queue
     for (int i : array) {
       pq.add(i);

      // if the size of the queue is greater than k, remove the head
      if (pq.size() > k) {
        pq.poll();
      }
    }
     
    // return the head of the queue
    return pq.peek();
    }


   /*
    * Priority Queue 2 Programming Exercise
    *
    * Given two arrays A and B with n and m integers respectively, 
    * return a singe sorted array of elements from both arrays.
    *
    * USE a Priority Queue ADT to solve this problem.
    */
  
    public int[] sort2Arrays(int[] array1, int[] array2) {
      Queue<Integer> pq = new PriorityQueue<>();

      // ADD YOUR CODE HERE
      // iterate through each array, adding to the priority queue
      for (int i : array1) {
        pq.add(i);
      }

      // repeat for the second array
      for (int k : array2) {
        pq.add(k);
      }

      // create a new array with size of both arrays combined
      int array3[] = new int[array1.length + array2.length];// remove this line in your code 

      // while the queue isn't empty, add to the new array, increasing the index for 
      // each iteration
      int index = 0;
      while (!pq.isEmpty()) {
        array3[index] = pq.poll();
        index++;
      }

      return array3;

    }
}


/*
 * Main Routine - Unit Testing 
 */

public class Main {

    public static void main(String[] args) {

      UtilMethods u = new UtilMethods();

      int list1[] = {10, 50, 35, 82, 13, 25};
      int list2[] = {10, 35, 13};
      int list3[] = {10, 35, 13, 8};

      // Sample HashTable isSubset() tests
      System.out.println("HashTable test, shoudl be true : "  
                         + u.isSubset(list1, list2));
      System.out.println("HashTable test, should be false: " 
                        + u.isSubset(list1, list3));

      
      // Sample PriorityQueue findKthLargest() tests
      int list4[] = {1,7,3,10,34,5,8};
      int k = 4;
      System.out.println("The " + k + " largest should be 7      : " 
                          + u.findKthLargest(list4, k));

      // Sample PriorityQueue sort2Arrays() tests
      int list5[] = {4,1,5};
      int list6[] = {3,2};
      int sorted[];
      
      sorted = u.sort2Arrays(list5, list6);

      System.out.print("Printing the combined sorted array: ");
      for (int i=0; i < sorted.length ; i++)
         System.out.print(sorted[i] + " ");
      System.out.println();
    }
}
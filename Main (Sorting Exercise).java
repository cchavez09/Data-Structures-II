////////////////////////////////////////////////////////////////
//
//   Christian Chavez  / 002
//
////////////////////////////////////////////////////////////////

import java.util.*;

public class Main {

  /**
  * Method showDuplicates
  *
  * This method identifies duplicate strings in am arrary list. The list
  * is passed as ab ArrayList<String> and the method returns an ArrayList<String>
  * containing only unique strings that appear more than once in the input list. 
  *
  * For example, if the input list was: "Dog", "Cat", "Dog", "Horse", "Lion"
  * the method would return an ArrayList<String> containing: "Dog"
  *
  * @param  list  an ArrayList<String>
  * @return       an ArrayList<String> containing only unique 
  *               strings that appear more than once in the input list
  */
  
  public static ArrayList<String> showDuplicates(ArrayList<String> input) {

      //
      //  YOUR CODE GOES HERE (ADD YOUR NAME AT TOP OF FILE)
      // 

    // create a new ArrayList to return
    ArrayList<String> duplicate = new ArrayList<String>();
    
    // sort the list alphabetically
    Collections.sort(input);

    // iterate through the list, all the way through second to last
    for (int i = 0; i < input.size() - 1; i++) {
      // check if current element is the same as element after it
      if (input.get(i).equals(input.get(i + 1))) {
        // check duplicate array list to see if dupe word is already
        // in the list, if no then add
        if (!duplicate.contains(input.get(i))) {
          duplicate.add(input.get(i));
        }
      }
    }
    
    return duplicate;
  }


    /**
     * Finds pairs in the input array that add up to k.
     * 
     * @param input   Array of integers
     * @param k       The sum to find pairs for
     
     * @return an ArrayList<String> containing a list of strings. The ArrayList
     *        of strings needs to be ordered both within a pair, and 
     *        between pairs. E.g.,
     *
     *         - Ordering within a pair:
     *            A string is a pair in the format "(a, b)", where a and b are 
     *            ordered lowest to highest, e.g., if a pair was the numbers 
     *            6 and 3, then the string would be "(3, 6)", and NOT "(6, 3)".
     *         - Ordering between pairs:
     *            The ordering of strings of pairs should be sorted in lowest to 
     *            highest pairs. E.g., if the following two string pairs within
     *            the returned ArraryList, "(3, 6)" and "(2, 7), they shoiuld be
     *            ordered in the ArrayList returned as "(2, 7)" and "(3, 6 )".
     * 
     *         Example output:
     *         If the input array list was {2, 3, 3, 4, 5, 6, 7}, then the 
     *         returned ArrayList<String> would be {"(2, 7", "(3, 6)", "(4, 5)"}
     */
  
  public static ArrayList<String> pair(int[] input, int k) {

    //
    //  YOUR CODE GOES HERE
    //
    // initialize an ArrayList to return
    ArrayList<String> pairs = new ArrayList<String>();
    
    // sort the input array
    Arrays.sort(input);

    // iterate throught the array 
    for (int i = 0; i < input.length; i++) {
      for (int j = i + 1; j < input.length; j++)
        // check if both elements add up to k and to avoid duplicate pairs
        // check if the arrayList pairs doesn't already contain the pair
        if (input[i] + input[j] == k && !pairs.contains("(" + input[i] + ", " + input[j] + ")")) {
          pairs.add("(" + input[i] + ", " + input[j] + ")");
        }
    }
    

    return pairs;
  }

  
 /*
  * Main Routine -- Add any additional unit testing here as needed
  */
  
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>(Arrays.asList("apple", "apple", 
                                                      "banana", "banana", "banana", 
                                                      "cherry", "cherry", "cherry", 
                                                      "cherry"));
    int[] input = new int[]{2, 3, 3, 4, 5, 6, 7};
    int k = 9;

    
    /*
     * Sample Test of Sort #1
     */
    
    System.out.println(showDuplicates(list));  // Expected: [apple, banana, cherry]

    
    /*
     * Sample Test of Sort #2
     */

    System.out.println(pair(input, k));       // Expected: [(2, 7), (3, 6), (4, 5)]
  }
}
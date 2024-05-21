///////////////////////////////////////////////////////////
//
//         Christian Chavez / 002
//
////////////////////////////////////////////////////////////
import java.util.Arrays;

public class Main {

  public static int numRescueCanoes(int[] people, int limit) {

      // YOUR CODE GOES HERE
    // create an int variable and sort array from least to greatest
    int boat = 0;
    Arrays.sort(people);
    // iterate through array 
    for (int i = 0; i < people.length; i++) {
      // check if current element is less than the second to last element
      // so comparisons are not out of bounds
      // check if current element and following element is less than
      // or equal to weight limit
      if (i < people.length - 1 && people[i] + people[i + 1] <= limit) {
        // if yes, increment the index by 1 since 2 people are in 1 boat
        i++;
      }
      // increment boat sice
      boat++;
    }

    return boat;
  }

  /*
   *  Main - Add any additional unit testsing you need below
   */
  
  public static void main(String[] args) {
 
      int people1[] = {1,2};
      int people2[] = {3,2,2,1};
      int people3[] = {3,5,3,4};
      System.out.println("Output: " + numRescueCanoes(people1,3));
      System.out.println("Output: " + numRescueCanoes(people2,3));
      System.out.println("Output: " + numRescueCanoes(people3,5));

  }
}
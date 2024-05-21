/////////////////////////////////////////////
//
//  Christian Chavez / 002
//
/////////////////////////////////////////////

import java.util.HashMap;
import java.util.ArrayList;

class HashingExercise {

  public double getAverage(HashMap<Integer, Integer> map, 
                           int[] array) 
  {
    /*
     *  YOUR CODE GOES HERE 
     *
     *  DO NOT FORGET TO PLACE YOUR NAME ABOVE, ALSO 
     *  RECALL IF NO VALUES FOUND, RETURNING 0.0 IS NOT 
     *  CORRECT. MAKE SURE YOU ARE RETURNING 0.0/0.0 
     *  (WHICH RETURNS NOT A NUMBER, or 'NaN').
     */

    // initialize two double variables to calculate average
    double sum = 0.0;
    double count = 0;
    // loop through the array
    for (int i = 0; i < array.length; i++) {
      // check if integer in array is in the hashmap
      // if map has key and has a value, add to sum and increase count
      if (map.get(array[i]) != null) {
        sum += map.get(array[i]);
        count++;
      }
    }
    

    return sum / count;
  

  }

  
  public ArrayList<String> odd(HashMap<Integer, String> map) {
    
    ArrayList<String> result = new ArrayList<>();

      /*
       *  YOUR CODE GOES HERE 
       */
    // iterate through keySet with variable key
    // check if each key is odd, if odd add value of 
    // key to result
    for (int key : map.keySet()) {
      if (key % 2 != 0) {
        result.add(map.get(key));
      }
    }
    
    return result;
  }
  

}

////////////////////////////////////////////////////////
//
//       Christian Chavez / 002
//
/////////////////////////////////////////////////////////

public class LUCSorter {

  private final int[] intArray;

  public LUCSorter(int[] intArray) {
    this.intArray = intArray;
  }

  public void sort() {
    
    // ADD LOOP BOUNDS
    // iterate through the array length
    for (int i = 0; i < intArray.length; i++) {
      int max = maximumPosition(i);
      swap(max, i);
    }
  }

  private int maximumPosition(int from) {
    // start the loop from the following position of from
    for (int i = from + 1; i < intArray.length; i++) {
      // if the current value is greater than the from value, assign the current value to the from value
      if (intArray[i] > intArray[from]) {
        from = i;
      }
    }
    
    return from;

  }

  private void swap(int i, int j) {
    int temp = intArray[i];
    intArray[i] = intArray[j];
    intArray[j] = temp;
  }

  /*
   * Check your code using this method for Exercise 1
   */
  public static int[] checkExercise(int[] values) {
    LUCSorter sorter = new LUCSorter(values);
    sorter.sort();
    return values;
  }

}


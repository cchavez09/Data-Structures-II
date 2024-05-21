import java.util.*;

public class LUCSorter {
  private int[] a;

  public LUCSorter(int[] anArray) {
    a = anArray;
  }

  public void divisibleByKFirst(int k) {
    if (k == 0)
      return;

    if (a.length <= 1)
      return;
    int[] first = new int[a.length / 2];
    int[] second = new int[a.length - first.length];
    System.arraycopy(a, 0, first, 0, first.length);
    System.arraycopy(a, first.length, second, 0, second.length);
    LUCSorter firstSorter = new LUCSorter(first);
    LUCSorter secondSorter = new LUCSorter(second);
    firstSorter.divisibleByKFirst(k);
    secondSorter.divisibleByKFirst(k);
    merge(first, second, k);
  }

  private void merge(int[] first, int[] second, int k) {
  
    // YOUR CODE HERE
    // create a temp array of the original array size before being split
    int temp[] = new int[a.length];
    // create two pointers to keep track of the first and second array
    // create a pointer to keep track of the temp array
    int i = 0;
    int j = 0;
    int index = 0;
    // iterate through the first and second array until one of the pointers is greater 
    // their array size
    while (i < first.length && j < second.length) {
      // check if element is divisible by k
      if (first[i] % k == 0) {
        temp[index++] = first[i++];
      } else {
        temp[index++] = second[j++];
      }
      
    }
    // copy the remaining elements from the first array to the temp array
    while (i < first.length) {
      temp[index++] = first[i++];
      
    }

    // copy the remaining elements from the second array to the temp array
    while (j < second.length) {
      temp[index++] = second[j++];
      
    }

    // copy the temp array to the original array
    System.arraycopy(temp, 0, a, 0, temp.length);

  }

  /*
   * Do not modify this routine, it is used for testing your code.
   */ 

  public static void checkExercise(int[] a, int k) {
    LUCSorter sorter = new LUCSorter(a);
    sorter.divisibleByKFirst(k);
  }
}


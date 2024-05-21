/////////////////////////////////////////////////////////////
//
//        Christian Chavez / 002
//
/////////////////////////////////////////////////////////////
import java.util.Arrays;

public class Main {

  public static boolean asteroidsDestroyed(int mass, int[] asteroids) {

      // YOUR CODE GOES HERE
    // sort array from least to greatest for their mass
    Arrays.sort(asteroids);

    // iterate through the array
    for (int i = 0; i < asteroids.length; i++) {
      // if the current mass is greater than the mass of the current asteroid
      // incremement the mass with current asteroid
      if (mass >= asteroids[i]) {
        mass += asteroids[i];
      } else {
        // if mass is less the asteroid mass, return false
        return false;
      }
    }

    return true;
  }

  
  /*
   * Main - Add any additional unit testing below
   */

  public static void main(String[] args) {
    int mass = 10;
    int[] asteroids = new int[] {3,9,19,5,21};

    System.out.println("Test 1 - Asteroids destroyed? : " +
            asteroidsDestroyed(mass, asteroids));

    mass = 5;
    asteroids = new int[] {4,9,23,4};
    System.out.println("Test 2 - Asteroids destroyed? : " +
            asteroidsDestroyed(mass, asteroids));

  }

}
  
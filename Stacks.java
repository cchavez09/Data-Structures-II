import java.util.Stack;

////////////////////////////////////////////
// Christian Chavez / 272-002   //
////////////////////////////////////////////


/*
 * Class: Stacks
 * 
 * You are to wrote the code for both methods. Please see the
 * instructions on the supplied PDF for assignment # 1. It provides
 * the specifications for each method.
 */

public class Stacks {
    public static boolean isPalindrome(String input) {
      // create a boolean variable set as true
      boolean status = true;
      // make all String input to lowercase so case sensitivity doesn't
      // matter, as well as replace spaces with no spaces
      input = input.toLowerCase().replaceAll(" ", "");
      // create a stack meant for characters and push each character
      // in the string into the stack
      Stack<Character> stack = new Stack<Character>();
      for (int i = 0; i < input.length(); i++) {
        stack.push(input.charAt(i));
      }
      // go through stack and compare first character of input
      // to the last in the stack and keep going until the input ends
      // or the stack is empty
      // if there is a mismatch, status is then false
      for (int i = 0; i < input.length(); i++) {
        if (input.charAt(i) != stack.pop()) {
          status = false;
        }
      }
      return status;
    }

    public static int findLargestK(Stack<Integer> stack, int k) {
      // set current index to -1 if there isn't an index
      // that matches with k
      int index = -1;
      // for loop through whole stack, but decrement since pop gets 
      // top of the stack and update index with i if k matches with
      // pop and i is greater than current index
      for (int i = stack.size() - 1; i >= 0; i--) {
        if (stack.pop() == k  && i > index) {
          index = i;
        }
      }
      return index;

    }
}

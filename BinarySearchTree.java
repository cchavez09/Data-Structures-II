import java.util.*;
//////////////////////////////////////////////////////
//
//  Christian Chavez / 002
//
//////////////////////////////////////////////////////


public class BinarySearchTree {

  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  Node root;

  public BinarySearchTree()   { root = null;}

  /**
   * Method insertAll
   * 
   * This methiod takes an array of integers and inserts them into 
   * the binary search tree. Duplicate values are allowed in this BST. 
   *
   * This method SHOULD utilize the 'insert' method below.
   */
  
  public void insertAll(int[] data) {
    
      // INSERT CODE HERE - THIS METHOD SHOULD USE THE 
      // INSERT METHOD BELOW.
      for (int i = 0; i < data.length; i++) {
        insert(data[i]);
      }
      

      return;
  }


  /**
   * Method Insert
   *
   * This method inserts a new node into the binary search tree. The 
   * tree *DOES ALLOW* duplicates. Duplicates values are to the right. 
   * E.g., if inserting a value '6' and '6' already exists in the tree,
   * the newly inserted value '6' will be to the right child [subtree] 
   * of the existing node with value '6'.
   *
   * Use the helper private method provided below which is called by 
   * the public method.
   */
  
  public void insert(int data) {
    // INSERT CODE HERE 
    // check if current tree is empty
    if (root == null) {
      // if empty, create first node and set it as root
      root = new Node(data);
      return;
    }

    // if not empty, current node is set at root to traverse
    Node current = root;

    while (current != null) {
      // traverse whether data wanting to be inputted is less than current
      if (data < current.data) {
        // if left child is empty, set new Node
        if (current.left == null) {
          current.left = new Node(data);
          return;
        } else {
          // if not empty, keep traversing
          current = current.left;
        }
      } else { 
        // check if right child is empty, set new Node
        if (current.right == null) {
          current.right = new Node(data);
          return;
        } else {
          // keep traversing if not empty
          current = current.right;
        }
        
      }
      
    }

    
    
    
  }


  
  /**
   * Method increaseAll
   *
   * This method inserts the value of ever node in the tree by  
   * a supplied value. 
   *
   * Use the helper private method provided below which is called by 
   * the public method.  
   */

  public void increaseAll(int value) {
    // INSERT CODE HERE
    // check if current tree is empty
    if (root == null) {
      return;
    }

    // create a queue to store nodes
    Queue<Node> queue = new LinkedList<Node>();
    // start queue with top of tree, Breath first search
    queue.add(root);

    while (!queue.isEmpty()) {
      // remove node from queue and set to current, and increase it with value
      Node current = queue.remove();
      current.data += value;
      // both if statements check if node has children, if yes add to queue 
      // and traverse until tree is empty
      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }
    }
    return;
  }

  
  
  /**
   * Do NOT change below, the methid toString() is used by
   * in creating a string reprensentation of the tree. It can 
   * be used by System.out.println(tree) to print the tree, and
   * it is also used by the JUnit tests.
   */
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    toStringHelper(root, sb);
    if (sb.length() != 1) {
      sb.setLength(sb.length() - 2);
    }
    sb.append("]");
    return sb.toString();
  }

  private void toStringHelper(Node node, StringBuilder sb) {
    if (node == null) {
      return;
    }
    toStringHelper(node.left, sb);
    sb.append(node.data);
    sb.append(", ");
    toStringHelper(node.right, sb);
  }
}
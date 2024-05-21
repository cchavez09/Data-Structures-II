
/////////////////////////////////////////////////
//
// Christian Chavez / 002
//
//////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {

  public Tree() {
    root = null;
  }

  public Tree(int val) {
    root = new Node(val);
  }

  /*
   * Class Node. 
   *
   * This is the main iterface you will be using. The 
   * this tree handlkes n-ary children! So, do not just 
   * assume it is a binary tree (only 2 children). 
   * 
   * The children are stored in an arrary list. So, when
   * you do your traversal by level, you have the children
   * nodes in the array list (in the proper order from left
   * to right).
   */
  
  static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
    Node parent = null;

    public Node(int d) {
      data = d;
    }

    public Node addChild(int d) {
      Node n = new Node(d);
      n.setParent(this);
      children.add(n);
      return n;
    }

    // This method returns an array of a node's children
    public ArrayList<Node> getChildren() {
      return children;
    }

    public void setParent(Node p) {
      parent = p;
    }

    public Node getParent() {
      return parent;
    }
  }

  Node root = null;

  //
  // DO NOT MODIFIY CODE ABOVE THIS LINE
  //
  
  /**
   *  Method traverseByLevel
   *
   * The method will return a String of the tree's
   * data values using a breadth first traversal. In 
   * otherword, it prints the node value level by level
   * starting at the root node and working down one
   * level at a time printing the values from left to right. 
   *
   * Returns 
   * A string with the tree's data values separated by spaces.
   * If tree is empty, return an empty string.
   */

  public String traverseByLevel() {
    String result = "";
    

    /*
    * YOUR CODE GOES HERE - DO NOT FORGET TO 
    * ADD YOUR NAME / SECTION ABOVE
    */
    // check if tree is empty
    if (root == null) {
      return result;
    }

    // create a queue with the tree
    Queue<Node> queue = new LinkedList<Node>();

    // add root to queue and start a while loop to traverse through
    // tree
    queue.add(root);
    while (!queue.isEmpty()) {
      // create a node to store the current node
      // and add the value of node to result
      Node current = queue.remove();
      result += current.data + " ";
      // checks if current node has children, if it has children
      // see how many children it has and add them to the queue
      if (!current.getChildren().isEmpty()) {
        for (int i = 0; i < current.getChildren().size(); i++) {
          queue.add(current.getChildren().get(i));
        }
      }
    
    
      
    }
    
    
    // Return the result after trimming any trailing spaces
    return result.trim();
  }
}

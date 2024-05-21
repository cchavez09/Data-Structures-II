////////////////////////////////////////////
// Christian Chavez / 002    //
////////////////////////////////////////////


/*
 * Class BinaryTree
 *
 * Simple Binary Search Tree. 
 */

public class BinaryTree {

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node node) {
        root = node;
    }


    /*
     * Class Node
     *
     * This class represents a node in a binary tree. Each node has a 
     * data value alonge with left and right children pointers. 
     */
  
    public class Node {

        Node( int d) {
          data = d;
          left = null;
          right = null;
        }
      
        Node(int d, Node l, Node r) {
            data = d;
            left = l;
            right = r;
        }

        public int data;
        public Node left;
        public Node right;
    }

    public  Node root;

    public  void deleteTree()                 { root = null; }
    public  Node insert(int data)             { return insert(root, data); }

    /*
     * Method Insert
     *
     * This method inserts a new node into the binary search tree. It
     * returns a pointer to the node that was added in the tree.
     */
  
    private Node insert(Node node, int value) {

        // Empty tree scenario; create it's first node. 
        if ( root == null ) {
            return root = new Node(value, null, null);
        }

        // If 'node' is null, we found the location to insert the new node, 
        // else recursively traverse tree to identify location to insert. 
      
        if ( node == null ) {
            node = new Node(value, null, null);
        } else  if (value > node.data) {
            node.right = insert(node.right, value);  // recursively traverse right
        }
        else if (value < node.data) {
            node.left = insert(node.left, value);    // recursively travser left
        }
      
        return node;
  }

  // Below can be used by println, e.g., System.out.println(tree);
  // where tree is a BinaryTree object. The JUnit tests also use these 
  // methods, so do not modify.
  
  public String toString() {
      return toStringHelper(root);
  }

  private String toStringHelper(Node n) {
      if (n == null) {
          return "";
      }
      return n.data + " " + toStringHelper(n.left) + toStringHelper(n.right);
  }


  
  /***********************************************************
   *
   * YOUR CODE GOES BELOW
   *
   * THERE IS NO NEED TO CHANGE THE CODE ABOVE. DO NOT FORGET TO PLACE
   * YOUR NAME AND SECTION NUMBER ABOVE. ANY UNIT TESTING YOU DO
   * SHOULD BE DONE IN MAIN().
   *
   *
   * YOU ARE TO WRITE THE METHODS:
   *    - preOrder
   *    - findMin
   *    - NodesGT
   *    - average
   *    - balanceHeight
   *
   ***********************************************************/
     private String preOrderHelper(Node node) {
       if (node == null)  {
         return "";
       }
       String order = "" + node.data + " ";
       /* for pre-order, you do any node processing here */
       order += preOrderHelper(node.left);
  
       order += preOrderHelper(node.right);
  
       return order;

     }
  
    public String preOrder() {
        return preOrderHelper(root);
    }


    public int findMin() {
      // set min to data in the root, then traverse to leftmost leaf
      int min = root.data;
      Node current = root;
      // traverse left until you reach last leaf, all while updating
      // minimum
      while (current.left != null) {
        current = current.left;
        min = current.data;
      }
      return min;
    }


    private int nodesGTHelper(Node node, int value) {
      // checks if current node is null, if so, return 0
      if (node == null) {
        return 0;
      }
      // initialize counter to 0
      int count = 0;
      // start recursive, checks left side of the tree 
      // and checks if each value is greater than target value
      count += nodesGTHelper(node.left, value);
      // if a node has a value greater than target, increment counter
      if (node.data > value) {
        count++;
      }
      // check right side of the node, and recalls this method and checks if 
      // value is greater than target
      count += nodesGTHelper(node.right, value);
      // after recursed back to root, goes right side of the tree, and checks
      // each leaf, if greater than target, increment counter and return
      // the incremented counter to overall

      return count;
  
    }

    public int NodesGT(int val) {
      return nodesGTHelper(root, val);
    }

    private double[] averageHelper(Node node, double[] values) {
      // check if current node is null, if so, return double array
      // no change
      if (node == null) {
        return values;
      }
      // first index of the array is for sum
      values[0] += node.data;
      // second index of the array is for count
      values[1]++;
      // goes through all left side nodes, adding their data to sum
      // and increment count, once left is null, array is unchanged
      // and checks right branch, keeps going until back to root and 
      // checks right side of the tree
      averageHelper(node.left, values);
      averageHelper(node.right, values);
      return values;
    }
  
    public double average() {
      double[] values = {0, 0};
      averageHelper(root, values);
      return values[0] / values[1];
    }


    public int balanceHeight() {
      return balanceHeightHelper(root);
    }
  
    private int balanceHeightHelper(Node node) {
      // check if current node is null
      if (node == null) {
        return 0;
      }
      // assign value to left and right heights
      int lHeight = balanceHeightHelper(node.left);
      int rHeight = balanceHeightHelper(node.right);

      
      if (lHeight == -1 || rHeight == -1 || Math.abs(lHeight - rHeight) > 1) {
        return -1;
      } else {
        return 1 + Math.max(lHeight, rHeight);
      }
      
    }

}

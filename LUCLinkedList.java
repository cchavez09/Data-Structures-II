  ////////////////////////////////////////////
// Christian Chavez / 272-002    //
////////////////////////////////////////////


/*
 * Class: LUCLinkedList
 *
 * The class implments a Singly linked-list. For this class, you are to   
 * complete the 'removeElementsLT' menthod (below), which is to remove 
 * all elements from the linked-list with values that are less than the
 * input paramter passed to the method. 
 */

public class LUCLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int d)           
        {
            data = d;
            next = null;
        }
    }
    Node head;                 

    /*
     * Method inserting an elment (new node) into the linked-list
     */
  
    public void insert(int data) {
        Node new_node = new Node(data); 
        new_node.next = null;
        if (this.head == null) { 
            this.head = new_node;
        }
        else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node; // Insert the new_node at last node
        }
    }

    /* 
     * Method to convert linked-list to a string, this method 
     * is used by println()
     */
  
     public String toString() {   
        String output="[";
        Node currNode = this.head;

        while (currNode != null) { 
          output+=currNode.data + " ";
          currNode = currNode.next; 
        }
        return output.trim()+"]";
    }

    /*
     * Method to remove all the nodes that store a given value less
     * than the passed value "ltValue". E.g., the invocation of the
     * method removeElementsLT(8) would remove all nodes from the 
     * linked-list that store a value less than 8.
     */
  
    public void removeElementsLT(int ltValue) {
      // assign current node to head
      Node current = this.head;
      // check if head isn't null and the current node's value is less 
      // than the ltValue
      while (current != null && current.data < ltValue) {
        // update current node to the next node
        current = current.next;
      }
      // assign the head of the linked list to current
      this.head = current;
    }

}

/////////////////////////////////////
//
// Christian Chavez / 002
//
/////////////////////////////////////

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

/*
 * Graph - a class that represents a directed graph 
 * of nodes and edges.
 */

public class Graph {
  int numVertices;                  // vertices in graph
  LinkedList<Integer>[] adjListArr; // Adjacency list
  List<Integer> vertexValues;       // vertex values

  // Constructor 
  public Graph(int numV) {
    numVertices = numV;
    adjListArr = new LinkedList[numVertices];
    vertexValues = new ArrayList<>(numVertices);

    for (int i = 0; i < numVertices; i++) {
      adjListArr[i] = new LinkedList<>();
      vertexValues.add(0);
    }
  }

  /*
   * method setValue
   * 
   * Sets a vertex's (node's) value.
   */ 
  
  public void setValue(int vertexIndex, int value) {
    if (vertexIndex >= 0 && vertexIndex < numVertices) {
      vertexValues.set(vertexIndex, value);
    } else {
      throw new IllegalArgumentException(
             "Invalid vertex index: " + vertexIndex);
    }
  }

  /*
   * method addEdge
   * 
   * Insert a directed edge.
   */ 

  public void addEdge(int src, int dest) {
    adjListArr[src].add(dest);
  }

  /*
   * method printGraph
   * 
   * Prints the graph as an adjenceny matrix
   */ 
  
  public void printGraph() {
    System.out.println(
         "\nAdjacency Matrix Representation:\n");
    int[][] matrix = new int[numVertices][numVertices];

    for (int i = 0; i < numVertices; i++) {
      for (Integer dest : adjListArr[i]) {
        matrix[i][dest] = 1;
      }
    }

    System.out.print("  ");
    for (int i = 0; i < numVertices; i++) {
      System.out.print(i + " ");
    }
    System.out.println();

    for (int i = 0; i < numVertices; i++) {
      System.out.print(i + " ");
      for (int j = 0; j < numVertices; j++) {
        if (matrix[i][j] == 1) {
          System.out.print("| ");
        } else {
          System.out.print(". ");
        }
      }
      System.out.println();
    }
  }

  /*
   * method findRoot
   *
   * Returns the vertex's (node's) value of the root 
   * vertex, where root is defined in this case
   * as a node that has no incoming edges. If no root
   * vertex is found and/or more than one root vertex,
   * then return -1. 
   * 
   */
  
  public int findRoot() {

    // ADD YOUR CODE HERE

    // create an array same size as the number of vertices
    int[] incomingEdges = new int[numVertices];

    // loop through the adjacency list
    for (int i = 0; i < numVertices; i++) {
      // increment number of edges for each vertex in the adjList
      for (int j : adjListArr[i]) {
        incomingEdges[j]++;
      }
    }

    // initialize two variables, one to keep track of number of roots
    // and second to get the value of the root
    int count = 0;
    int value = 0;
    for (int i = 0; i < numVertices; i++) {
      // if the number of incoming edges is 0, then it is a root
      if (incomingEdges[i] == 0) {
        // increase count and get the value of the root
        count++;
        value = vertexValues.get(i);
      }
    }

    // check if there is only 1 root, if more than one return -1
    if (count != 1) {
        return -1;
    } else {
        return value;
    }
    
    

    
  } 
}

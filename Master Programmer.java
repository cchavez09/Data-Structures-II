////////////////////////////////////////
//
//  Christian Chavez / 002
//
////////////////////////////////////////

import java.util.*;

class Solution {

    /*
    To reach your goal of 'master programmer', you 
    need to complete 'n' certification exams, each 
    being specific to a topic. Some exams have 
    prerequisites of needing to take and pass earlier
    certificate exams.

    You can represent these 'n' exams as nodes in a 
    graph, numbered from 0 to n-1. And represent the 
    prerequisite between taking exams as directed edges
    between two nodes which represent those two exams. 

    You are given a 2-dimensional array of exam 
    prerequisites where prerequisites[i] = [ai, bi] 
    indicating that you must take exam bi first if you 
    want to take exam ai. For example, the pair [0, 1], 
    indicates that to take exam certification 0, you 
    have to first have the certification for exam 1. 

    Return true if you can finish all certification 
    exams. Otherwise, return false (e.g., meaning it is 
    a cyclic or cycle graph). 

    Example 1:
    Input: numExams = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 exams to take.
    To take exam 1 you should have completed the 
    certification of exam 0. So, it is possible (no 
    cyclic or cycle graph of prereqs).


    Example 2:
    Input: numExams = 2, prerequisites = [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 exams to take. 
    To take exam 1 you should have completed the 
    certification of exam 0, and to take exams 0 you 
    should also have completed the certification of exam 
    1. So, it is impossible (it is a cycle graph).

    */

    public boolean canFinish(int numExams, 
                             int[][] prerequisites) {
      
      int numNodes = numExams;  // # of nodes in graph

        // Build directed graph's adjancy list
      ArrayList<Integer>[] adj = getAdjList(numExams, 
                                        prerequisites); 

        // ADD YOUR CODE HERE - IF CYCLE
        // DETECTED, RETURN FALSE, ELSE TRUE.
      // create a boolean array to keep track of visited nodes
      // and mark as not visited
      boolean visited[] = new boolean[numNodes];

      // create a queue for BFS
      LinkedList<Integer> queue = new LinkedList<Integer>();

      // initialize the starting node and mark it as visited
      int index = 0;
      visited[index] = true;

      // add the starting node to the queue
      queue.add(0);

      // loop through the queue until it is empty
      while(!queue.isEmpty()) {
        index = queue.poll();

        // get the adjacent vertices of the first vertex
        Iterator<Integer> itr = adj[index].iterator();

        // check if there are any adjacent vertices
        while (itr.hasNext()) {
          // add to queue if not visited
          int num = itr.next();
          if (!visited[num]) {
            visited[num] = true;
            queue.add(num);
          } else {
            return false;
          }
        }
      }

      return true;
      

      
    }

    /*
     * Building an Adjacency List for the directed 
     * graph based on number of nodes and passed in 
     * directed edged.
     */

    private ArrayList<Integer>[] getAdjList(
            int numNodes, int[][] edges) {
      
        ArrayList<Integer>[] adj 
                    = new ArrayList[numNodes];

        for (int node = 0; node < numNodes; node++){
            adj[node] = new ArrayList<Integer>();
        }
        for (int[] edge : edges){
            adj[edge[0]].add(edge[1]);
        }
        return adj;
    }
}


/*
 * Main Driver
 */

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        /*
         * Driver Code for method canFinish(), the 
         * driver builds simple directed graphs,
         * where edges represent prerequisites. 
         * Your code should build more complex
         * directed graphs.
         */

        // Prereq edges for graph g1 of 2 /examsnodes
        int[][] g1 = new int[][] { {0,1} };    
      
        // Prereq edges for graph g2 of 2 exams/nodes
        int[][] g2 = new int[][] { {1,0}, {0,1} };  
      
        // Prereq edges for graph g3 of 4 exams/nodes
        int[][] g3 = new int[][] { {1,0}, {3,1} };   
      

        System.out.println("\nStartng tests ...");
      
        if ( ! s.canFinish(2, g1) )
          System.out.println("Test 1 error");

        if ( s.canFinish(2, g2) )
          System.out.println("Test 2 error");
      
        if ( ! s.canFinish(4, g3) )
          System.out.println("Test 3 error");

        // Add more testing with and without cycles 
        // in directed graphs. Include larger directed
        // graphs, as the JUnit tests will.

        int[][] g4 = new int[][] { };
        int[][] g5 = new int[][] { {1,0}, {3,1}, {3,0} };
        int[][] g6 = new int[][] { {1,0}, {3,1}, {0,3} };

        if ( ! s.canFinish(2, g4) )
          System.out.println("Test 4 error");
      
        if ( ! s.canFinish(4, g5) )
          System.out.println("Test 5 error");

        if ( s.canFinish(4, g6) )
          System.out.println("Test 6 error");

        System.out.println("Testing complete");
    }
}
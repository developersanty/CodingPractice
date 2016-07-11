package graphs;

/**
 * Created by sj034021 on 6/16/16.
 */

//Graph Implementation using Adjacency Matrix
public class MatrixGraph {
  int numberOfVertices = 0;
  int matrix[][];
  boolean visited[];

  public MatrixGraph(int numberOfVertices) {
    numberOfVertices++;
    this.numberOfVertices = numberOfVertices;
    matrix = new int[numberOfVertices][numberOfVertices];

    for(int i = 0; i < numberOfVertices; i++) {

      for(int j = 0; j< numberOfVertices; j++) {
        if(i == 0) {
          matrix[i][j] = j;
        }

        else if(j == 0) {
          matrix[i][j] = i;
        }

        else {
          matrix[i][j] = 0;
        }

      }
    }

    visited = new boolean[numberOfVertices];
  }

  // Using a recursive approach, the stack memory increases, so it is wise to use iterative approach(uses heap memory)
  public void depthFirstTraversal(int fromVertex) {
    if(visited[fromVertex] == true) {
      return;
    }

    System.out.println(fromVertex);
    visited[fromVertex] = true;

    for(int i = 1; i<numberOfVertices; i++) {
      if (matrix[fromVertex][i] == 1) {
        depthFirstTraversal(i);
      }
    }
  }

  public void breadthFirstTraversal(int fromVertex) {

  }

  public void addEdge(int vertex1, int vertex2) {
    matrix[vertex1][vertex2] = 1;
    matrix[vertex2][vertex1] = 1;
  }

  public void removeEdge(int vertex1, int vertex2) {
    matrix[vertex1][vertex2] = 0;
    matrix[vertex2][vertex1] = 0;
  }

  public void printMatrix() {
    for(int i = 0; i < numberOfVertices; i++) {
      System.out.println();
      for(int j = 0; j< numberOfVertices; j++) {
        System.out.print("  "+matrix[i][j]);
      }
    }
  }

  public static void main(String args[]) {
    MatrixGraph graph = new MatrixGraph(8);
    graph.addEdge(1,4);
    graph.addEdge(1,2);
    graph.addEdge(2,5);
    graph.addEdge(1,7);
    graph.addEdge(2,6);
    graph.addEdge(4,6);
    graph.addEdge(5,7);
    graph.addEdge(6,3);
    graph.addEdge(3,8);

    graph.depthFirstTraversal(1);
    //graph.printMatrix();
  }
}

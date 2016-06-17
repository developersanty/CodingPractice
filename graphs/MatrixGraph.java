package graphs;

/**
 * Created by sj034021 on 6/16/16.
 */

//Graph Implementation using Adjacency Matrix
public class MatrixGraph {
  int numberOfVertices = 0;
  int matrix[][];

  public MatrixGraph(int numberOfVertices) {
    this.numberOfVertices = numberOfVertices;
    matrix = new int[numberOfVertices][numberOfVertices];

    for(int i = 0; i < numberOfVertices; i++) {
      for(int j = 0; j< numberOfVertices; j++) {
        matrix[i][j] = -1;
      }
    }
  }

  public void addEdge(int vertex1, int vertex2) {
    matrix[vertex1][vertex2] = 1;
  }

  public void removeEdge(int vertex1, int vertex2) {
    matrix[vertex1][vertex2] = -1;
  }

  public void printMatrix() {
    for(int i = 0; i < numberOfVertices; i++) {
      System.out.println();
      for(int j = 0; j< numberOfVertices; j++) {
        System.out.print(" "+matrix[i][j]);
      }
    }
  }

  public static void main(String args[]) {
    MatrixGraph graph = new MatrixGraph(3);
    graph.addEdge(0,1);
    graph.addEdge(2,2);
    graph.removeEdge(0,1);
    graph.printMatrix();
  }
}

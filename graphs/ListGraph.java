package graphs;

import lists.LinkedList;

/**
 * Created by sj034021 on 6/16/16.
 */

// Graph Implementation using adjacency list
public class ListGraph {
  int numberOfVertices = 0;
  LinkedList list[];
  public ListGraph(int numberOfVertices) {
    this.numberOfVertices = numberOfVertices;

    list = new LinkedList[numberOfVertices];

    for(int i = 0; i< list.length; i++) {
      list[i] = new LinkedList();
    }
  }

  public int size() {
    return list.length;
  }

  void add(int vertex1, int vertex2) {
    list[vertex1].add(vertex2);
    list[vertex2].add(vertex1);
  }

  void remove(int vertex1, int vertex2) {
    list[vertex1].remove(vertex2);
    list[vertex2].remove(vertex1);
  }

  void printGraph() {
    for(int i = 0; i< list.length; i++) {
      System.out.print("Node "+i+ ": ");
      list[i].printList();
      System.out.println("");
    }
  }

  public static void main(String args[]) {
    ListGraph lg = new ListGraph(5);

    lg.add(0, 4);
    lg.add(0, 1);
    lg.add(0, 2);
    lg.add(0, 3);
    lg.remove(2, 0);
    lg.printGraph();
  }
}

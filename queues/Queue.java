package queues;

/**
 * Created by sj034021 on 6/2/16.
 */
import trees.*;
public class Queue {
  int size = 100;
  Node container[] = new Node[size];
  int last = -1;
  int first = 0;

  public void enqueue(Node node) {
    last++;
    container[last] = node;
  }

  public boolean dequeue() {
    if (size() > 0) {
      container[first] = null;
      first++;

      return true;
    }

    return false;
  }

  public int size() {
    return (last - first) + 1;
  }

  public void print() {
    for(int i=first; i<=last; i++) {
      System.out.println(container[i]);
    }
  }

  public Node peek() {
    return container[first];
  }
}

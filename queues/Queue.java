package queues;

/**
 * Created by sj034021 on 6/2/16.
 */
import trees.*;
public class Queue<T> {
  int size = 100;

  T[] container;
  int last = -1;
  int first = 0;

  public Queue(int size) {
     container = (T[]) new Object[size];
  }

  public void enqueue(T node) {
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

  public T peek() {
    return container[first];
  }

  public static void main(String args[]) {
     Queue<Integer> queue= new Queue<Integer>(10);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    queue.dequeue();
    queue.print();
  }

}

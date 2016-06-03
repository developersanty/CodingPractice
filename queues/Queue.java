package queues;

/**
 * Created by sj034021 on 6/2/16.
 */
public class Queue {
  int size = 100;
  int container[] = new int[size];
  int last = -1;
  int first = 0;

  void enqueue(int data) {
    last++;
    container[last] = data;
  }

  boolean dequeue() {
    if (size() > 0) {
      container[first] = -1;
      first++;

      return true;
    }

    return false;
  }

  int size() {
    return (last - first) + 1;
  }

  void print() {
    for(int i=first; i<=last; i++) {
      System.out.println(container[i]);
    }
  }

  int peek() {
    return container[first];
  }

  public static void main(String args[]) {
    Queue q = new Queue();
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.dequeue();
    q.print();
    System.out.print(q.peek());
    System.out.print(q.size());
  }
}

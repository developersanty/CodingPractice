package stacks;

/**
 * Created by sj034021 on 6/23/16.
 */
public class Stack<T> {
  T elements[];
  int top = -1;

  public Stack(int size) {
    elements = (T[]) new Object [size];
  }

  public int size() {
    return top+1;
  }

  public void push(T data) {
    top++;

    elements[top] = data;
  }

  public T peek() {
    return elements[top];
  }

  public void pop() {
    elements[top] = null;
    top--;
  }

  public void print() {
    for(int i=0; i< size(); i++) {
      System.out.println(elements[i]);
    }
  }

  public static void main(String args[]) {
    Stack<String> s= new Stack<String>(10);

    s.push("Hi");
    s.push("Hello");
    s.push("Cool");
    s.pop();

    // System.out.print(s.peek());
    s.print();
  }
}

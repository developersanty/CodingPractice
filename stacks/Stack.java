package stacks;

/**
 * Created by sj034021 on 6/23/16.
 */
public class Stack<T> {
  T elements[];
  int top = -1;

  int capacity = 5;

  public Stack() {
    elements = (T[]) new Object [capacity];
  }

  public int size() {
    return top+1;
  }

  public void push(T data) {

    if(size() == capacity) {
      expandStack();
    }

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

  public void expandStack() {
    capacity = capacity*2;
    T newArray[] = (T[]) new Object[capacity];

    for(int i=0; i<elements.length; i++) {
      newArray[i] = elements[i];
    }

    elements = newArray;
  }

  public void print() {
    for(int i=0; i< size(); i++) {
      System.out.println(elements[i]);
    }
  }
  
  // reversing a stack using recursion
  public void reverse(Stack<T> stack) {

    if(stack.size() == 0) {
      return;
    }

    T topElement = stack.peek();
    stack.pop();
    reverse(stack);

    pushToLast(topElement, stack);
  }

  public void pushToLast(T topElement, Stack<T> stack) {
    if(stack.size() == 0) {
      stack.push(topElement);
      return;
    }

    T currentElement = stack.peek();
    stack.pop();
    pushToLast(topElement, stack);
    stack.push(currentElement);
  }

  public static void main(String args[]) {
    Stack<Integer> s= new Stack<Integer>();

    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    s.reverse(s);
    // System.out.print(s.peek());
    s.print();
  }
}

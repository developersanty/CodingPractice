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

  // sort a stack using recursion
  public void sort(Stack<T> stack) {
    if(stack.size() == 0) {
      return;
    }

    T topElement = stack.peek();
    stack.pop();
    sort(stack);

    rearrange(topElement, stack);
  }

  public void rearrange(T topElement, Stack<T> stack) {
    if(stack.size() == 0) {
      stack.push(topElement);
      return;
    }

    if((Integer)stack.peek() > (Integer)topElement) {
      T greaterElement = stack.peek();
      stack.pop();
      rearrange(topElement, stack);
      stack.push(greaterElement);
    } else {
      stack.push(topElement);
    }
  }

  public boolean checkForBalancedParenthesis(Stack<T> stack) {
    boolean status = true;

    if(stack.size() == 0) {
      return status;
    }

    T topElement = stack.peek();
    stack.pop();

    status = checkForBalancedParenthesis(stack);

    if (status == false) {
      return status;
    }

    if(topElement.equals("]") || topElement.equals("}") || topElement.equals(")") ) {
      stack.push(topElement);
      return true;
    } else {
      if(stack.size() == 0) {
        // open braces as the last element
        return false;
      }

      T poppedElement = stack.peek();

      if(isMirror((String)poppedElement, (String)topElement)) {
        stack.pop();
        return true;
      } else {
        return false;
      }
    }
  }

  public boolean isMirror(String closedElement, String openElement) {
    if((closedElement.equals("]") && openElement.equals("[")) || (closedElement.equals("}") && openElement.equals("{")) || (closedElement.equals(")") && openElement.equals("("))) {
      return true;
    }

    return false;
  }

  public static void main(String args[]) {
    Stack<String> s= new Stack<String>();

    s.push("}");
    s.push(")");
    s.push("(");
    s.push("]");
    s.push(")");
    s.push("(");
    s.push(")");
    s.push("(");
    s.push("[");
    s.push("{");
    s.push("}");
    s.push("{");
    s.push("]");
    s.push(")");
    s.push("(");
    s.push("[");
    System.out.print(s.checkForBalancedParenthesis(s));
    //s.reverse(s);
    //s.sort(s);
    // System.out.print(s.peek());
    //s.print();
  }
}

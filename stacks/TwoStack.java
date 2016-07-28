package stacks;

/**
 * Created by sj034021 on 7/27/16.
 */
public class TwoStack<T> {
  T elements[] = (T[])new Object[10];
  int top1 = -1;
  int top2 = 10;
  int capacity = 0;

  public int size1() {
    return top1+1;
  }

  public int size2() {
    return (10 - top2) + 1;
  }

  void push1(T data) {
    if(capacity==10) {
      System.out.print("HOUSEFULL!!");
      return;
    }
      top1++;
      elements[top1] = data;
      capacity++;
  }

  void push2(T data) {
      if(capacity==10) {
          System.out.print("HOUSEFULL!!");
        return;
      }
    top2--;
    elements[top2] = data;
    capacity++;
  }

  public T peek1() {
    if(size1()==0) {
      System.out.print("Nothing to see here!");
       return null;
    }

    return elements[top1];
  }

    public T peek2() {
        if(size2()==0) {
            System.out.print("Nothing to see here!");
            return null;
        }

        return elements[top2];
    }

    void pop1() {
      if(size1()==0) {
        System.out.print("Nothing to pop here!");
      } else {
        top1--;
        capacity--;
      }
    }

    void pop2() {
        if(size2()==0) {
            System.out.print("Nothing to pop here!");
        } else {
            top2++;
            capacity--;
        }
    }

    void printStack1() {
        System.out.println("ELEMENTS OF STACK1");
        for(int i=0; i< size1(); i++) {
          System.out.println(elements[i]);
        }
        System.out.println("------------------");
    }

    void printStack2() {
      System.out.println("ELEMENTS OF STACK2");
      for(int i=9; i>= top2; i--) {
        System.out.println(elements[i]);
      }
        System.out.println("------------------");
    }

  public static void main(String args[]) {
    TwoStack<Integer> stack = new TwoStack<Integer>();

    stack.push2(1);
    stack.push2(2);
    stack.push2(3);
    stack.push2(4);
    stack.push2(5);
      stack.push1(6);
      stack.push1(7);
      stack.push1(8);
      stack.push1(9);
      stack.push1(10);
      //stack.push1(11);
      stack.pop1();
      stack.pop2();
      System.out.println(stack.peek1());
      System.out.println(stack.peek2());
    //stack.printStack2();
      //stack.printStack1();
  }
}

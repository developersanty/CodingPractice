package problems;

import stacks.Stack;

/**
 * Created by sj034021 on 7/14/16.
 */
public class StringManipulation {

  public static String reverseStringUsingStack(String input) {

    Stack<String> stack = new Stack<String>();

    for(int i=0; i<input.length(); i++) {
      stack.push(input.substring(i, i+1));
    }

    String output = "";
    while (stack.size()!= 0) {
      output = output + stack.peek();
      stack.pop();
    }

    return output;
  }

  public static void main(String args[]) {
    System.out.println(reverseStringUsingStack("Hola"));
  }
}

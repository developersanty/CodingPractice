package trees;
/**
 * Created by sj034021 on 5/31/16.
 */

import queues.*;
public class BinarySearchTree {
  /*
   *  Property:
   *  Elements to the left of a node are lesser than that node
   *  and elements to the right of a node are greater than that node
   *
   *  Operations: Add, Remove, Search
   *  Access point: root node
   *
   *  Info: Just use data to across all operations
  */

  /*
  * Implementation type: Recursive
  * */
  Node add(Node newNode, int data) {
    if (newNode == null) {
       newNode = new Node(data);
    } else if(data <= newNode.data) {
        newNode.left = add(newNode.left, data);
    } else {
      newNode.right = add(newNode.right, data);
    }

    return newNode;
  }

  Node search(Node node, int data) {
    Node response = null;
    if(node.data == data) {
      return node;
    }

    if(node.left!=null) {
      response = search(node.left, data);
    }

    if(node.right!=null & response == null) {
      response = search(node.right, data);
    }

    return response;
  }

  void printInOrder(Node node) {
    if(node == null) {
      return;
    }

    printInOrder(node.left);
    System.out.println(node.data);
    printInOrder(node.right);
  }

  void printPreOrder(Node node) {
    if(node == null) {
      return;
    }

    System.out.println(node.data);
    printPreOrder(node.left);
    printPreOrder(node.right);
  }

  void printPostOrder(Node node) {
    if(node == null) {
      return;
    }
    printPostOrder(node.left);
    printPostOrder(node.right);
    System.out.println(node.data);
  }

  void levelOrder(Node node, Queue q) {
    if (node == null) {
      System.out.print("No donuts for you!");
    }

    if(q.size()!=0) {
      q.dequeue();
    }

    System.out.println(node.data);
    if(node.left!=null) {
      q.enqueue(node.left);
    }
    if(node.right!=null){
      q.enqueue(node.right);
    }

    if(q.size()!=0) {
      levelOrder(q.peek(), q);
    }
  }

  public int height(Node node) {
    int height = -1;

    if(node == null) {
      return height;
    }

    return Math.max(height(node.left), height(node.right)) + 1;
  }

  public static void main(String args[]) {
    BinarySearchTree tree = new BinarySearchTree();

    Node root = tree.add(null, 7);
    root = tree.add(root, 4);
    root = tree.add(root, 9);
    root = tree.add(root, 3);
    root = tree.add(root, 6);
    root = tree.add(root, 8);
    root = tree.add(root, 12);
    root = tree.add(root, 12);
    System.out.println("IN ORDER TRAVERSAL RESULT");
    System.out.println("-------------------------");
    tree.printInOrder(root);
    System.out.println("\n");
    System.out.println("PRE ORDER TRAVERSAL RESULT");
    System.out.println("--------------------------");
    tree.printPreOrder(root);
    System.out.println("\n");
    System.out.println("POST ORDER TRAVERSAL RESULT");
    System.out.println("---------------------------");
    tree.printPostOrder(root);
    System.out.println("\n");
    System.out.println("LEVEL ORDER TRAVERSAL RESULT");
    System.out.println("----------------------------");
    Queue x = new Queue();
    tree.levelOrder(root, x);
    System.out.println("\n");
    System.out.println("HEIGHT OF A TREE:" + tree.height(root));
    System.out.println("\n");
    System.out.println("\n");
    System.out.println("SEARCH NODE IN A TREE: " + tree.search(root, 6).data);
    System.out.println("SEARCH NODE IN A TREE: " + tree.search(root, 7).data);
    System.out.println("SEARCH NODE IN A TREE: " + tree.search(root, 12).data);
    System.out.println("\n");
  }
}

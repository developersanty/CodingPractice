package trees;

/**
 * Created by sj034021 on 5/31/16.
 */
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
    tree.printInOrder(root);
    System.out.println("---");
    tree.printPreOrder(root);
    System.out.println("---");
    tree.printPostOrder(root);
  }
}

package trees;

/**
 * Created by sj034021 on 5/31/16.
 */
public class BinaryTree {

   static Node root = null;

  public Node insert(Node node, int data) {
    Node newNode = new Node(data);
    if(node == null) {
      node = newNode;
      if(root == null) {
        root = node;
      }
    }
     else if (data <= node.data) {
       node.left = insert(node.left, data);
    } else {
       node.right = insert(node.right, data);
    }

    return node;
  }

  public void inOrderTraversal(Node node) {
    if(node == null)  {
      return;
    }

    inOrderTraversal(node.left);
    System.out.println(node.data);
    inOrderTraversal(node.right);
  }

  public int size(Node node) {
     if(node == null) {
       return 0;
     }

     return 1 + size(node.left) + size(node.right);
  }

  public int height(Node node) {
      if(node == null) {
        return -1;
      }

    return 1+ Math.max(height(node.left), height(node.right));
  }

  public boolean search(Node node, int data) {
    if(node == null) {
      return false;
    }

    if(node.data == data) {
       return true;
    }

    return search(node.left, data) || search(node.right, data);
  }

  public static void main(String args[]) {
    BinaryTree tree = new BinaryTree();

    tree.insert(null, 70);
    tree.insert(root, 40);
    tree.insert(root, 90);
    tree.insert(root, 30);
    tree.insert(root, 60);
      tree.insert(root, 65);

    //tree.inOrderTraversal(root);
    //System.out.print(tree.size(root));
    //System.out.print(tree.height(root));
      System.out.print(tree.search(root, 11));
  }
}

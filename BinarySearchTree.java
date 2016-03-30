class BinarySearchTree{
   BinaryNode add(BinaryNode node, int data){
    if(node == null) {
      return new BinaryNode(data, null, null);
    }

    if(data <= node.data) {
      node.left = add(node.left, data);
    } else {
      node.right = add(node.right, data);
    }
    return node;
  }

  BinaryNode findMin(BinaryNode node){
    while(node.left!=null) {
      node = node.left;
    }

    return node;
  }

  BinaryNode findMax(BinaryNode node){
    while(node.right!=null) {
      node = node.right;
    }

    return node;
  }

  BinaryNode delete(BinaryNode node, int data) {

    if(node == null) {
      return null;
    }

    if(data < node.data) {
      node.left = delete(node.left, data);
    } else if(data > node.data) {
      node.right = delete(node.right, data);
    } else {
        if(node.left == null && node.right == null) {
          return null;
        }
       else if(node.left!=null && node.right== null) {
         return node.left;
       }
       else if(node.left==null && node.right!= null) {
         return node.right;
       } else{
         BinaryNode minNode = findMin(node.right);
         int temp = minNode.data;
         minNode.data = node.data;
         node.data = temp;

         node.right = delete(node.right, minNode.data);
       }
     }
    return node;
  }

  boolean search(BinaryNode node, int data) {
    boolean found = false;

    if(node == null) {
      return found;
    }

    if(data == node.data) {
      return true;
    }
    else if(data < node.data) {
      found = search(node.left, data);
    } else {
      found = search(node.right, data);
    }

    return found;
  }

  void printInOrder(BinaryNode node){
    if(node.left!=null) {
      printInOrder(node.left);
    }
    System.out.println(node.data);

    if(node.right!=null) {
      printInOrder(node.right);
    }
  }

  void printPreOrder(BinaryNode node){
    System.out.println(node.data);

    if(node.left!=null) {
      printPreOrder(node.left);
    }

    if(node.right!=null) {
      printPreOrder(node.right);
    }
  }

  void printPostOrder(BinaryNode node){
    if(node.left!=null) {
      printPostOrder(node.left);
    }

    if(node.right!=null) {
      printPostOrder(node.right);
    }

    System.out.println(node.data);
  }

  BinaryNode findClosestElement(BinaryNode node, int data) {

    if( node == null) {
      return node;
    }

    BinaryNode closest = node;
    BinaryNode returnedResult = null;
    if(data < node.data) {
      returnedResult = findClosestElement(node.left, data);// go left and search
    } else if(data > node.data){
      returnedResult = findClosestElement(node.right, data);// go left and search
    }

    if(returnedResult!=null && (Math.abs(closest.data - data)) > (Math.abs(returnedResult.data))){
      closest = returnedResult;
    }

    return closest;
    // the point is to keep track of the distance and the element
  }

  public static void main(String args[]) {
    BinarySearchTree bst = new BinarySearchTree();
    BinaryNode root = null;
    root = bst.add(root, 3);
    root = bst.add(root, 1);
    //root = bst.add(root, 1);
    //root = bst.add(root, 2);
    root = bst.add(root, 2);
    root = bst.add(root, 4);
    root = bst.findClosestElement(root, 5);
    System.out.print(root.data);
    //root = bst.delete(root, 2);
    //bst.printInOrder(root);
    //System.out.println(bst.search(root, 1));
  }
}
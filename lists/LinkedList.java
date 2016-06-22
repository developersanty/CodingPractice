package lists;

/**
 * Created by sj034021 on 6/22/16.
 */
public class LinkedList {
  Node root = null;

  /* add iteratively */
  void add(int data) {
    Node newNode = new Node(data);
    if (root == null) {
      root = newNode;
    } else {
      Node tempNode = root;

      while(tempNode.next!=null) {

        tempNode = tempNode.next;
      }
      tempNode.next = newNode;
    }
  }

  /* remove iteratively */
  void remove(int data) {
    Node tempNode = root;
    Node previousNode = null;


    while (tempNode!=null) {
     if(tempNode.data == data) {
       if(tempNode == root) {
         root = tempNode.next;
       } else {
         previousNode.next = tempNode.next;
       }
     }

     previousNode = tempNode;
     tempNode = tempNode.next;
   }
  }

  Node search(int data) {
    Node tempNode = root;

    while(tempNode!=null) {
      if(tempNode.data == data) {
        return tempNode;
      }

      tempNode = tempNode.next;
    }

    return null;
  }

  void printList() {
    Node tempNode = root;

    while(tempNode!=null) {
      System.out.println(tempNode.data);
      tempNode = tempNode.next;
    }
  }

  public static void main(String args[]) {
    LinkedList list = new LinkedList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.remove(1);
    list.add(5);
    //list.printList();
    System.out.println(list.search(6));
  }
}

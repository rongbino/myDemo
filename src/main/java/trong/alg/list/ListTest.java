package trong.alg.list;

import java.util.LinkedList;

public class ListTest {
  public static void main(String[] args) {
    ListTest test = new ListTest();
    test.testLinkedList();
    test.testCircularList();
    test.testDoublyList();
  }


  public void testDoublyList() {
    System.out.println("======= Doubly list test ======");
    CustomerDoublyLinkedList<Integer> customerDoublyLinkedList = new CustomerDoublyLinkedList<>();
    customerDoublyLinkedList.link(0);
    customerDoublyLinkedList.link(1);
    customerDoublyLinkedList.link(2);
    customerDoublyLinkedList.link(3);
    // print init doubly list
    printList(customerDoublyLinkedList);
    System.out.printf("Delete first %d, the size change to %d\n", customerDoublyLinkedList.remove(), customerDoublyLinkedList.size());
    System.out.printf("Delete first %d, the size change to %d\n", customerDoublyLinkedList.remove(), customerDoublyLinkedList.size());
    System.out.printf("Delete first %d, the size change to %d\n", customerDoublyLinkedList.remove(), customerDoublyLinkedList.size());
    System.out.printf("Delete first %d, the size change to %d\n", customerDoublyLinkedList.remove(), customerDoublyLinkedList.size());

    printList(customerDoublyLinkedList);
  }

  public void testCircularList() {
    System.out.println("======= Circular list test ======");
    CustomerCircularLinedList<Integer> customerCircularLinedList = new CustomerCircularLinedList<>();
    customerCircularLinedList.link(0);
    customerCircularLinedList.link(1);
    customerCircularLinedList.link(2);
    customerCircularLinedList.link(3);

    printList(customerCircularLinedList);

    customerCircularLinedList.delete(3);
//    System.out.println(customerCircularLinedList.getSize());
    printList(customerCircularLinedList);
  }

  /**
   * make test for linked list
   */
  public void testLinkedList() {
    System.out.println("======= Linked list test ======");
    CustomerLinkedList<Integer> customerLinkedList = new CustomerLinkedList<>();
    customerLinkedList.linkLast(0);
    customerLinkedList.linkLast(1);
    customerLinkedList.linkLast(2);
    customerLinkedList.linkLast(3);
    customerLinkedList.linkLast(4);

    // print the init list
    printList(customerLinkedList);

    // remove one
    customerLinkedList.remove(1);
    // print the new list
    printList(customerLinkedList);

    //reserve the list
    customerLinkedList.reserve();
    printList(customerLinkedList);
  }

  public void printList(CustomerLinkedList l) {
    for (int i = 0; i < l.size; i++) {
      System.out.print(" " + l.node(i));
    }
    System.out.println();
  }

  public void printList(CustomerCircularLinedList l) {
    for (int i = 0; i < l.size; i++) {
      System.out.print(" " + l.node(i));
    }
    System.out.println();
  }

  public void printList(CustomerDoublyLinkedList l) {
    for (int i = 0; i < l.size; i++) {
      System.out.print(" " + l.node(i));
    }
    System.out.println();
  }
}

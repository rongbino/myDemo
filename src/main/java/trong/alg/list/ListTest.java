package trong.alg.list;

import java.util.LinkedList;

public class ListTest {
  public static void main(String[] args) {
    ListTest test = new ListTest();
    test.testLinkedList();
  }

  public void testLinkedList() {
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
}

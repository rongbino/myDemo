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

    // print the init list
    for (int i = 0; i < customerLinkedList.size; i++) {
      System.out.print(" " + customerLinkedList.node(i));
    }
    // remove one
    customerLinkedList.remove(1);
    System.out.println();
    // print the new list
    for (int i = 0; i < customerLinkedList.size; i++) {
      System.out.print(" " + customerLinkedList.node(i));
    }
  }
}

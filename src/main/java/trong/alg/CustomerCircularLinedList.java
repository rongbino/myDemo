package trong.alg;

public class CustomerCircularLinedList<E> {
  // init list size
  transient int size = 0;
  // the first;
  transient Node<E> first;

  public CustomerCircularLinedList() {}

  /**
   * the node class for circular linked list
   * @param <E>
   */
  private static class Node<E> {
    Node<E> next;
    E element;

    Node(E element, Node<E> next) {
      this.element = element;
      this.next = next;
    }
  }
}

package trong.alg;

public class CustomerDoublyLinkedList<E> {
  // size of Doubly linked
  transient int size = 0;
  // the first node
  transient Node<E> first;
  // the last node
  transient Node<E> last;

  public CustomerDoublyLinkedList() {}

  /**
   * Node class
   * @param <E>
   */
  private static class Node<E> {
    E       element;
    Node<E> next;
    Node<E> pre;

    Node(Node<E> pre, E element, Node<E> next) {
      this.pre = pre;
      this.element = element;
      this.next = next;
    }
  }
}

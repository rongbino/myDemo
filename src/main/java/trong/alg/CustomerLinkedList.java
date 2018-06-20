package trong.alg;

/**
 * Linked list
 */
public class CustomerLinkedList<E> {
  // init the linked list, first is null
  transient Node<E> first;
  // last node
  transient Node<E> last;
  // init the linked list, the size is 0
  transient int size = 0;

  public CustomerLinkedList() {
  }

  public Node<E> getFirst() {
    return first;
  }

  public Node<E> getLast() {
    return last;
  }

  /**
   * Add the node in the last position
   * @param e
   */
  public void linkLast(E e) {
    if (first == null) {
      final Node<E> node = new Node(e, null);
      first = node;
      last = node;
      size++;
    } else {
      final Node<E> l = last;
      final Node<E> node = new Node(e, null);
      last = node;
      l.next = node;
      size++;
    }
  }

  /**
   * Remove the node from index
   * @param index
   */
  public void remove(int index) {
    // invalidate index, do nothing
    if (size == 0 || index < 0 || index >= size) {
      return;
    }
  }
  /**
   * Node class
   * @param <E>
   */
  private static class Node<E> {
    E element;
    Node<E> next;

    Node(E element, Node<E> next) {
      this.element = element;
      this.next = next;
    }
  }
}

package trong.alg.list;

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

  public E getFirst() {
    return first.element;
  }

  public E getLast() {
    return last.element;
  }

  public E node(int index) {
    Node<E> node = first;
    for (int i = 0; i < size; i++) {
      if (i < index) {
        node = node.next;
      } else {
        break;
      }
    }
    return node.element;
  }

  /**
   * Add the node in the first position
   * @param e
   */
  public void linkFirt(E e) {
    if (first == null) {
      final Node<E> node = new Node<>(e, null);
      first = node;
      last = node;
      size++;
    } else {
      final Node<E> f = first;
      final Node<E> node = new Node<>(e, f);
      first = node;
      size++;
    }
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

    // clear the first one
    if (index == 0) {
      Node<E> f = first;
      first = first.next;
      size--;
      f = null; // clear the memory
    }

    // clear the index position
    Node<E> f = first;
    Node<E> del = first.next;
    for (int i = 1; i <= index; i++) {
      if (i == index) {
        f.next = del.next;
        del = null;
        size--;
        break;
      }
      // move next
      f = f.next;
      del = del.next;
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

package trong.alg.list;

public class CustomerCircularLinedList<E> {
  // init list size
  transient int size = 0;
  // the first;
  transient Node<E> start;

  public CustomerCircularLinedList() {}

  public int getSize() {
    return size;
  }

  public E node(int index) {
    if (index < 0 || index >= size) {
      return null;
    }

    // first
    if (index == 0) {
      return start.element;
    }
    // the rest in the array
    Node<E> eNode = start;
    for (int i = 1; i < size; i++) {
      eNode = eNode.next;
      if (i == index) {
        break;
      }
    }
    return eNode.element;
  }

  public void link(E element) {
    if (start == null) {
      final Node<E> f = new Node<>(element, null);
      f.next = f;
      start = f;
      size++;
    } else {
      final Node<E> f = new Node<>(element, null);
      Node<E> next = start.next;
      start.next = f;
      f.next = next;
      size++;
    }
  }

  public void delete(E element) {
    Node<E> current = start;
    Node<E> pre = null;
    while (!current.element.equals(element)) {
      if (current.next == start) {
        System.out.println("The gaven element not found");
        return;
      }
      // move to the next
      pre = current;
      current = current.next;
    }

    // if there is only one node
    if (current.next == start && start.next == current) {
      start = null;
      size--;
      return;
    }

    // if we want to delete start
    if (current == start) {
      pre = start;
      while (pre.next != start) {
        pre = pre.next;
      }
      start = current.next;
      pre.next = start;
      current = null;
      size--;
    } else {
      pre.next = current.next;
      current = null;
      size--;
    }
  }

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

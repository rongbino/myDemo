package trong.alg.list;

import java.util.LinkedList;

public class CustomerDoublyLinkedList<E> {
  // size of Doubly linked
  transient int size = 0;
  // the first node
  transient Node<E> first;
  // the last node
  transient Node<E> last;

  public CustomerDoublyLinkedList() {}

  /**
   * Link the node after last one
   * @param element
   */
  public void link(E element) {
    if (first == null) {
      final Node<E> e = new Node<>(null, element, null);
      first = e;
      last = e;
      size++;
    } else {
      final Node<E> e = new Node<>(null, element, null);
      last.next = e;
      e.pre = last;
      // last move next
      last = e;
      size++;
    }
  }

  public int size() {
    return size;
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
   * remove the first one
   */
  public E remove() {
    if (first == null) {
      return null;
    }

    if (first == last) {
      size--;
      E val = first.element;
      first = null;
      last = null;
      return val;
    }

    // more than one
    Node<E> eNode = first;
    final E element  = eNode.element;
    first = first.next;
    eNode = null; // help GC
    size--;
    return element;
  }

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

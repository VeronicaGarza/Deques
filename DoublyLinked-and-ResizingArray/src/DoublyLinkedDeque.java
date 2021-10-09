// file: DoublyLinkedDeque.java
// author: Bob Muller
//
// This is an implementation of the Deque ADT specified in the Deque.java API.
//

import java.util.NoSuchElementException;

public class DoublyLinkedDeque<T> implements Deque<T> {

  // YOUR CODE HERE
  private Node left, right;
  private int n;

  public DoublyLinkedDeque() {
    this.n = 0;
    this.left = null;
    this.right = null;
  }

  private class Node {
    Node previous, next;
    T info;

    private Node(Node previous, T info, Node next) {
      this.previous = previous;
      this.info = info;
      this.next = next;
    }
  }

  public void pushLeft(T item) {
    Node newLeft = this.left;
    left = new Node(null, item, newLeft);
    if (isEmpty())
      right = newLeft;
    left.next = newLeft;
    this.n++;
    left = newLeft;
  }

  public T popLeft() {

    if (isEmpty()) {
      throw new NoSuchElementException(("Queue Underflow"));
    }
    T item = left.info;
    left = left.previous;
    if (left == null) {
      right = null;
    }
    this.n--;
    return item;
  }

  public void pushRight(T item) {
    Node newRight = this.right;
    right = new Node(newRight, item, null);
    if (isEmpty()) {
      left = newRight;
    }
    right.next = newRight;
    this.n++;
    right = newRight;
  }

  public T popRight() {
    if (isEmpty()) {
      throw new NoSuchElementException(("Empty Deque"));
    }
    this.n--;
    T item = this.right.info;
    if (this.isEmpty()) {
      this.right = null;
      this.left = null;
      return item;
    }
    Node newRight = this.right.previous;
    newRight.next = null;
    this.right = newRight;
    return item;
  }

  public int size() {
    return this.n;
  }

  public boolean isEmpty() {
    return this.n == 0;
  }

  @Override
  public String toString() {
    Node item = this.left;
    String result = "[ ";
    while (item != null) {
      result = result + item.info + " ";
      item = item.next;
    }
    return result + "]";
  }

  // The function hashCode should remain unchanged, it is here to support
  // extra credit work.
  @Override
  public int hashCode() {
    return 343;
  }

  // The function equals is extra credit work.
  @Override
  public boolean equals(Object obj) {
    return false;
  }

  public static void main(String[] args) {

    // Unit testing for deque.
    Deque<Integer> deque = new DoublyLinkedDeque<Integer>();

    // Test 1
    deque.pushLeft(6);
    deque.pushRight(8);
    if (deque.toString().equals("[ 6 8 ]"))
      System.out.format("Test 1 dq = %s passed.\n", deque.toString());
    else
      System.out.format("Test 1 dq = %s failed. dq should be [ 6 8 ].\n",
                        deque.toString());

    // Test 2
    deque.popRight();
    deque.popRight();
    if (deque.toString().equals("[ ]"))
      System.out.format("Test 2 dq = %s passed.\n", deque.toString());
    else
      System.out.format("Test 2 dq = %s failed. dq should be [].\n",
                        deque.toString());

    // Test 3
    deque.pushRight(6);
    deque.pushRight(8);
    deque.pushLeft(1);
    deque.pushRight(4);
    if (deque.toString().equals("[ 1 6 8 4 ]"))
      System.out.format("Test 3 dq = %s passed.\n", deque.toString());
    else
      System.out.format("Test 3 dq = %s failed. dq should be [ 1 6 8 4 ].\n",
                        deque.toString());

    // Test 4
    deque.popRight();
    deque.popLeft();
    if (deque.toString().equals("[ 6 8 ]"))
      System.out.format("Test 4 dq = %s passed.\n", deque.toString());
    else
      System.out.format("Test 4 dq = %s failed. dq should be [ 6 8 ].\n",
                        deque.toString());

    // Extra credit
    if (deque.equals(deque) && deque.toString().equals("[ 6 8 ]"))
      System.out.format("Extra Credit test1 passed.\n");
    else
      System.out.format("Extra Credit test1 failed, dq = %s.\n", deque.toString());
  }
}

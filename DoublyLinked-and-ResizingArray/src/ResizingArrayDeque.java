// file: ResizingArrayDeque.java
// author: Bob Muller
//
// This is an implementation of the Deque ADT specified in the Deque.java API.
// The present implementation uses an array that is resized according to
// capacity.
//

import java.util.NoSuchElementException;

public class ResizingArrayDeque<T> implements Deque<T> {

  // YOUR CODE HERE
  private int size;
  private T[] values;
  private int front, back;

  public ResizingArrayDeque(int n) {
    T[] temp = (T[]) new Object[n];
    values = temp;
    front = 0;
    back = 0;
    size = 0;
  }

  private void resize(int newSize) {
    @SuppressWarnings("unchecked")
    T[] fresh = (T[]) new Object[newSize];
    for (int i = 0; i < size; i++)
      fresh[i] = values[(front + i) % values.length];
    front = 0;
    back = size;
    values = fresh;
  }

  public void pushLeft(T item) {
    if (size == values.length)
      resize(values.length * 2);
    int newBack = back;
    while (newBack > 0) {
      values[newBack] = values[newBack - 1];
      newBack--;
    }
    values[front] = item;
    if (back == values.length)
      back = 0;    // wrap
    back++;
    size++;

  }

  public T popLeft() {
    if (isEmpty())
      throw new NoSuchElementException("Empty Deque");
    else {
      T item;
      item = values[front];
      size++;
      front++;
      if (front == values.length) {
        front = 0;
      }
      if (size > 0 && size == values.length / 4) {
        resize(values.length / 2);
      }
      return item;
    }
  }

  public void pushRight(T item) {
    if (size == values.length)
      resize(values.length * 2);
    values[back++] = item;
    if (back == values.length)
      back = 0;    // wrap
    size++;

  }

  public T popRight() {
    if (isEmpty())
      throw new NoSuchElementException("Empty Deque");

    T item;
    if (back != 0) {
      item = values[back - 1];
      values[back - 1] = null;
      back--;
    }
    else {
      item = values[values.length - 1];
      values[values.length - 1] = null;
      back = values.length - 1;
      back--;
    }
    size--;
    return item;
  }


  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public String toString() {
    String result = "[";
    for (int i = 0; i < size; i++) {
      result = result + " " + values[i];
    }
    result = result + " ]";
    return result;
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

    // Unit testing for this ResizingArrayDeque implementation of the
    // Deque<T> ADT.
    Deque<Integer> deque = new ResizingArrayDeque<Integer>(4);

    // Test 1
    deque.pushLeft(6);
    deque.pushLeft(7);
    deque.pushRight(8);
    deque.pushRight(9);
    deque.pushRight(10);
    if (deque.toString().equals("[ 7 6 8 9 10 ]"))
      System.out.format("Test 1 dq = %s passed.\n", deque.toString());
    else
      System.out.format("Test 1 dq = %s failed. dq should be [ 7 6 8 9 10 ].\n",
                        deque.toString());

    // Test 2
    for (int i = 0; i < 5; i++) deque.popRight();
    if (deque.toString().equals("[ ]"))
      System.out.format("Test 2 dq = %s passed.\n", deque.toString());
    else
      System.out.format("Test 2 dq = %s failed. dq should be [ ].\n",
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

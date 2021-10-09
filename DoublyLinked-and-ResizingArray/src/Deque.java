/* file: Deque.java
  author: Bob Muller

  CSCI 1102 Computer Science 2

  An API for generic double-ended queues.
*/
public interface Deque<T> {
  void pushLeft(T item);

  T popLeft();

  void pushRight(T item);

  T popRight();

  int size();

  boolean isEmpty();

  @Override
  String toString();

  @Override
  boolean equals(Object other);
}

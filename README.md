## Problem Set 4 : Deques

### 13 Points

### Due Wednesday March 3, 2021 Midnight

This is a pair problem set, find one partner to work with. You can work with a partner in either section 04 or 05 of the course. If you don't know anyone to work with, you can use the partner finding tool of Piazza and/or you can ask for an assist from a course staffer, we'd be happy to help.

---

This is a variation of problem 1.3.33 of SW. Develop two implementations of the generic `Deque<T>` ADT.

```java
public interface Deque<T> {

  void pushLeft(T item);
  void pushRight(T item);
  T popLeft();
  T popRight();
  int size();
  boolean isEmpty();
  @Override
  String toString();
}
```

In this problem set, you are to design and implement two classes implementing the above `Deque<T>` API. 

+ One class should be called `DoublyLinkedDeque<T>`. It should be contained in the file `DoublyLinkedDeque.java` and should use a doubly-linked list to implement the API. 
+ The other class should be called `ResizingArrayDeque<T>`. It should be contained in the file `ResizingArrayDeque.java`. and it should implement the API using a circular resizing array.

The harness code files `DoublyLinkedDeque.java` and `ResizingArrayDeque.java` both come with predefined `main` functions that include  a few unit tests of your implementation. Your code should pass at least these tests, you may want to considering writing a few more.

Your code should throw a `java.util.NoSuchElementException` in case a client attempts to remove an item from an empty deque.

#### The `toString` Function

Your `toString` function is required to return a string with enclosing square brackets and string representations of deque entries separated by spaces. For example, a call of `toString` on an empty deque must return the exact string `"[ ]"` (NB: the space!) while a call of the `toString` function for a deque containing `A`, `B` and `C` should return the string `"[ A B C ]"` (NB: the spacing). The reason for this requirement is that it is assumed in the provided unit testing.

> Suggestion: We recommend that you and your partner confer to decide on implementation. Pencil and paper or chalk and chalkboard are very helpful. But we suggest that each of you implement *both* classes. It's a very formative experience so it's best if each member of the team does both.

#### Extra Credit (3 Points)

Extend the API (i.e., interface) with an `equals` operation and implement the `equals` operation in both `DoublyLinkedDeque<T>` and `ResizingArrayDeque<T>`.

```java
@Override
boolean equals(Object other);
```

> Note that the `@Override` annotation is present because the `equals` operation is inherited from class `Object`. 

For example, with `d1` and `d2` defined as follows:

```java
Deque<Integer> d1 = new ResizingArrayDeque<Integer>();
Deque<Integer> d2 = new ResizingArrayDeque<Integer>();
d1.pushLeft(8);
d2.pushRight(8);
```

The call `d1.equals(d2)` should return `true`.

Note that `d1.equals(d2)` should return `false` if `d2` is `null`.

---

When you're all done, git add, commit and push **one copy** of your work to one of your repo areas on the course GitHub site. Your final commit message should include both partners names.

```
Final: Ben Franklin, Rosa Parks
```

Good luck!

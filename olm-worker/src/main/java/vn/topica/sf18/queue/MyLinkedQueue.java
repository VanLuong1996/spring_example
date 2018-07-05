package vn.topica.sf18.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyLinkedQueue<E> {

  private Queue<E> queue = new LinkedList<>();

  public Queue<E> get() {
    return queue;
  }

  public void add(E value) {
    synchronized (queue) {
      queue.add(value);
    }
  }

  public void addAll(List<E> value) {
    synchronized (queue) {
      queue.addAll(value);
    }
  }

  public void remove(E value) {
    synchronized (queue) {
      queue.remove(value);
    }
  }

  // Retrieves and removes the head of this queue, or returns null if this
  // queue is empty.
  public E poll() {
    synchronized (queue){
      E data = queue.poll();
      return data;
    }
  }

  // Returns true if this collection contains no elements
  public boolean isEmpty() {
    synchronized (queue){
      return queue.isEmpty();
    }
  }

  // Returns the number of elements in this collection. If this collection
  // contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE
  public int getSize() {
    synchronized (queue){
      return queue.size();
    }
  }
}

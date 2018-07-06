package vn.topica.sf18.queue;

import java.util.List;

public interface MyQueue<T> {

  void push(T message);

  void push(List<T> messages);
}

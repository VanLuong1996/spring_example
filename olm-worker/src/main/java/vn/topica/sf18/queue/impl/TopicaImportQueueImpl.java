package vn.topica.sf18.queue.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import vn.topica.sf18.model.topica.TopicaImport;
import vn.topica.sf18.queue.MyLinkedQueue;
import vn.topica.sf18.queue.TopicaImportQueue;

@Service
public class TopicaImportQueueImpl implements TopicaImportQueue {

  private MyLinkedQueue<TopicaImport> queue = new MyLinkedQueue<>();

  @Override
  public void add(TopicaImport topicaImport) {
    queue.add(topicaImport);
  }

  @Override
  public void addAll(List<TopicaImport> topicaImports) {
    queue.addAll(topicaImports);
  }

  @Override
  public void remove(TopicaImport topicaImport) {
    queue.remove(topicaImport);
  }

  @Override
  public TopicaImport poll() {
    return queue.poll();
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override
  public int getSize() {
    return queue.getSize();
  }
}

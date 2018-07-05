package vn.topica.sf18.queue;

import java.util.List;
import vn.topica.sf18.model.topica.TopicaImport;

public interface TopicaImportQueue {

  void add(TopicaImport topicaImport);

  void addAll(List<TopicaImport> topicaImports);

  void remove(TopicaImport topicaImport);

  TopicaImport poll();

  boolean isEmpty();

  int getSize();
}

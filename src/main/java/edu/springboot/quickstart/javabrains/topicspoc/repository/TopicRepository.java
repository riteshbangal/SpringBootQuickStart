package edu.springboot.quickstart.javabrains.topicspoc.repository;

import org.springframework.data.repository.CrudRepository;

import edu.springboot.quickstart.javabrains.topicspoc.bean.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}

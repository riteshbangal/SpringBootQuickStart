package edu.springboot.quickstart.javabrains.topic.repository;

import org.springframework.data.repository.CrudRepository;

import edu.springboot.quickstart.javabrains.topic.bean.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}

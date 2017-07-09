package edu.springboot.quickstart.javabrains.topic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.springboot.quickstart.javabrains.topic.bean.Topic;
import edu.springboot.quickstart.javabrains.topic.repository.TopicRepository;

@Service
public class TopicPersistentService {
	
	@Autowired
	TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		
		// Here if we return findAll directly with type casting, it also work.
		// i.e. ---> return (List<Topic>) topicRepository.findAll()
		
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
			.forEach(topics::add);
		return topics;
	}
	
	public Topic getTopicById(String id) {
		return topicRepository.findOne(id);
	}
	
	public List<Topic> getTopicsByIds(List<String> ids) {
		return (List<Topic>) topicRepository.findAll(ids);
	}

	public boolean addTopic(Topic topic) {
		return null != topicRepository.save(topic);
	}

	public boolean deleteTopic(String id) {
		int countBeforeDelete = getAllTopics().size();
		topicRepository.delete(id);
		int countAfterDelete = getAllTopics().size();
		return countAfterDelete < countBeforeDelete;
	}
	
	public boolean updateTopic(String id, Topic topic) {
		if (topicRepository.exists(id)) {
			topicRepository.save(topic);
			return true;
		} else {
			return false;
		}
	}
}

package edu.springboot.quickstart.javabrains.topicspoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.springboot.quickstart.javabrains.topicspoc.bean.Topic;
import edu.springboot.quickstart.javabrains.topicspoc.service.TopicPersistentService;

@RestController
public class TopicTransientController {

	@Autowired
	//private TopicTransientService topicService;
	private TopicPersistentService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topic/{id}")
	public Topic getTopicById(@PathVariable String id) {
		return topicService.getTopicById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addTopic")
	public boolean addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteTopic/{id}")
	public boolean deleteTopic(@PathVariable String id) {
		return topicService.deleteTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateTopic/{id}")
	public boolean updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		return topicService.updateTopic(id, topic);
	}
}

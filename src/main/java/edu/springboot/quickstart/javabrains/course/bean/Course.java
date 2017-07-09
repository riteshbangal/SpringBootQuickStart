package edu.springboot.quickstart.javabrains.course.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import edu.springboot.quickstart.javabrains.topic.bean.Topic;

@Entity
public class Course {

	@Id
	private String id;
	private String name;
	private String description;
	
	// It's a many to one relationship. There could be many courses which are associated with a topic.
	@ManyToOne
	private Topic topic; 
	
	public Course() {
		// Default constructor stub
	}
	
	public Course(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic();
	}
	
	public Course(String id, String name, String description, Topic topic) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = topic;
	}
	
	@Override
	public String toString() {
		StringBuilder topic = new StringBuilder();
		topic.append("Course: [")
			.append("id: ").append(id)
			.append(", name: ").append(name)
			.append(", description: ").append(description)
			.append(", topic: ").append(topic)
			.append("]");
		return topic.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}

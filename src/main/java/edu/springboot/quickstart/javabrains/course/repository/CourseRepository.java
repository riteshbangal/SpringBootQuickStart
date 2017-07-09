package edu.springboot.quickstart.javabrains.course.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.springboot.quickstart.javabrains.course.bean.Course;

public interface CourseRepository extends CrudRepository<Course, String> {

	public List<Course> findByName(String courseName);
	
	// Parameter type (Topic/TopicId) should match domain class property definition (Topic/String).
	public List<Course> findByTopicId(String topicId);
}

package edu.springboot.quickstart.javabrains.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.springboot.quickstart.javabrains.course.bean.Course;
import edu.springboot.quickstart.javabrains.course.service.CoursePersistentService;
import edu.springboot.quickstart.javabrains.topic.bean.Topic;
import edu.springboot.quickstart.javabrains.topic.service.TopicPersistentService;

@RestController
public class CourseController {

	@Autowired
	private CoursePersistentService courseService;
	
	@Autowired
	private TopicPersistentService topicService;
	
	@RequestMapping("topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/course/{courseId}")
	public Course getCourseById(@PathVariable String courseId) {
		return courseService.getCourseById(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/addCourse")
	public boolean addCourse(@RequestBody Course course, @PathVariable String topicId) {
		Topic topic = topicService.getTopicById(topicId);
		if (null != topic) {
			course.setTopic(topic);
		} else {
			course.setTopic(new Topic(topicId, "", ""));
		}
		return courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteCourse/{id}")
	public boolean deleteCourse(@PathVariable String id) {
		return courseService.deleteCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateCourse/{id}")
	public boolean updateCourse(@PathVariable String id, @RequestBody Course course) {
		return courseService.updateCourse(id, course);
	}
}

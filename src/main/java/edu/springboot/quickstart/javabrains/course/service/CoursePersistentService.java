package edu.springboot.quickstart.javabrains.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.springboot.quickstart.javabrains.course.bean.Course;
import edu.springboot.quickstart.javabrains.course.repository.CourseRepository;

@Service
public class CoursePersistentService {
	
	@Autowired
	CourseRepository courseRepository;

	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll()
			.forEach(courses::add);
		return courses;
	}
	
	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
			.forEach(courses::add);
		return courses;
	}
	
	public Course getCourseById(String id) {
		return courseRepository.findOne(id);
	}
	
	public List<Course> getCoursesByIds(List<String> ids) {
		return (List<Course>) courseRepository.findAll(ids);
	}

	public boolean addCourse(Course course) {
		return null != courseRepository.save(course);
	}

	public boolean deleteCourse(String id) {
		int countBeforeDelete = getAllCourses().size();
		courseRepository.delete(id);
		int countAfterDelete = getAllCourses().size();
		return countAfterDelete < countBeforeDelete;
	}
	
	public boolean updateCourse(String id, Course course) {
		if (courseRepository.exists(id)) {
			courseRepository.save(course);
			return true;
		} else {
			return false;
		}
	}
}

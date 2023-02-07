package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	
	public CourseServiceImpl()
	{
		list = new ArrayList<>();
		list.add(new Course(101,"Java Course","Best Course"));
		list.add(new Course(102,"Spring Boot","Very Usefull course"));
	}

	@Override
	public List<Course> getCourses() {
	
		return list;
	}

	@Override
	public Course getCourse(Long courseId) {
		
		Course c = null;
		
		for(Course course:list)
		{
			if(course.getId() == courseId)
			{
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		
		Course c = null;
		for(Course course1:list)
		{
			if(course1.getId() == course.getId())
			{
				course1.setDescription(course.getDescription());
				course1.setTitle(course.getTitle());
				c = course1;
				break;
			}
		}
		return c;
	}

}

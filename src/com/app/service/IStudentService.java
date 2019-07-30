package com.app.service;

import java.util.List;

import pojos.Content;
import pojos.Course;
import pojos.Modules;
import pojos.Student;
import pojos.Topic;

public interface IStudentService {

	Student validateStudent(String prn, String password);
	List<Course> getCourseList(int studentId);
	List<Modules> getModulesList(int id);
	List<Topic> getTopicList(int id);
	Topic getTopicDetails(int id);
	List<Content> getContentList(int id);
	Content getContentDetails(int id);
	String updateStudent(int id, String oldpassword);

}

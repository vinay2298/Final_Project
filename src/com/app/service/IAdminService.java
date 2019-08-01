package com.app.service;

import java.util.List;

import pojos.Coordinator;
import pojos.Course;
import pojos.Faculty;
import pojos.Modules;
import pojos.Student;
import pojos.Topic;

public interface IAdminService {

	Coordinator validateAdmin(String email, String password);
	String registerCourse(int coordinatorid,Course c);
	String registerModule(int id,int fid, Modules m);
	String registerFaculty(int id, Faculty f);
	String registerStudent(int id, Student s);
	Course getCourseDetails(int coordinatorid,int id);
	String updateCourse(int id,Course c);
	String removeCourse(int id, Course c);
	List<Modules> getModuleList(int id);
	Modules getModuleDetails(int id);
	List<Faculty> getFacultyList(int courseId);
	List<Modules> getFacultyDetails(int facultyId);
	String registerCoordinator(Coordinator c);
	List<Student> getStudentList(int id);
	List<Course> getCourseList(int id);
	String registerTopic(int id, Topic t);
	String updateAdmin(int id, String newpassword);
	List<Topic> getTopicList(int id);
	Course getCourseDetails(int id);
	
}

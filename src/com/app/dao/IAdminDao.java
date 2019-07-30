package com.app.dao;



import java.util.List;

import pojos.Coordinator;
import pojos.Course;
import pojos.Faculty;
import pojos.Modules;
import pojos.Student;
import pojos.Topic;

public interface IAdminDao {
	Coordinator validateAdmin(String email, String password);
	String registerCourse(int coordinatorid,Course c);
	String registerModule(int courseId,int facultyId, Modules m);
	String registerFaculty(int courseId, Faculty f);
	String registerStudent(int courseId, Student s);
	Course getCourseDetails(int coordinatorid,int courseId);
	String updateCourse(int id,Course c);
	String removeCourse(int id, Course c);
	List<Modules> getModuleList(int courseId);
	Modules getModuleDetails(int moduleId);
	List<Faculty> getFacultyList(int courseId);
	List<Modules> getFacultyDetails(int facultyId);
	String registerCoordinator(Coordinator c);
	List<Student> getStudentList(int id);
	List<Course> getCourseDetails(int id);
	String registerTopic(int id, Topic t);
	List<Course> getCourseList(int id);
	String updateAdmin(int id, String newpassword);
	List<Topic> getTopicList(int id);	
}

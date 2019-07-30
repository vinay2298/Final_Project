package com.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;

import pojos.Coordinator;
import pojos.Course;
import pojos.Faculty;
import pojos.Modules;
import pojos.Student;
import pojos.Topic;

@Service
@Transactional
public class IAdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao dao;
	@Override
	public Coordinator validateAdmin(String email, String password) {
		System.out.println("In Coordinator Validation Form");
		return dao.validateAdmin(email,password);
	}
	
	@Override
	public String registerCourse(int coordinatorid,Course c) {
		System.out.println("In Course Registration Form");
		return dao.registerCourse(coordinatorid,c);
	}

	

	@Override
	public String registerModule(int id,int fid, Modules m) {
		System.out.println("In Module Registration Form");
		return dao.registerModule(id,fid,m);
	}

	@Override
	public String registerFaculty(int courseId, Faculty f) {
		System.out.println("In Faculty Registration Form");
		return dao.registerFaculty(courseId,f);
	}

	@Override
	public String registerStudent(int courseId, Student s) {
		System.out.println("In Student Registration Form");
		return dao.registerStudent(courseId,s);
	}

	@Override
	public Course getCourseDetails(int coordinatorid,int id) {
		System.out.println("In Get Course Details Service ");
		return dao.getCourseDetails(coordinatorid,id);
	}

	@Override
	public String updateCourse(int id,Course c) {
		System.out.println("In Update Course Service");
		return dao.updateCourse(id,c);
	}

	@Override
	public String removeCourse(int id, Course c) {
		System.out.println("In Remove Course Servive");
		return dao.removeCourse(id,c);
	}

	@Override
	public List<Modules> getModuleList(int courseId) {
		System.out.println("In Get Module list");
		return dao.getModuleList(courseId);
	}

	@Override
	public Modules getModuleDetails(int id) {
		System.out.println("In Get Module Details");
		return dao.getModuleDetails(id);
	}

	@Override
	public List<Faculty> getFacultyList(int courseId) {
		System.out.println("In Get Faculty List");
		return dao.getFacultyList(courseId);
	}

	@Override
	public List<Modules> getFacultyDetails(int facultyId) {
		System.out.println("In Get Faculty details");
		return dao.getFacultyDetails(facultyId);
	}

	@Override
	public String registerCoordinator(Coordinator c) {
		System.out.println("In COordinator Registration form");
		return dao.registerCoordinator(c);
	}

	@Override
	public List<Student> getStudentList(int id) {
		System.out.println("In Get Student List Service");
		return dao.getStudentList(id);
	}

	@Override
	public List<Course> getCourseList(int id) {
		System.out.println("In Student Course List Service");
		return dao.getCourseList(id);
	}

	@Override
	public String registerTopic(int id, Topic t) {
		System.out.println("In Topic Registration Form");
		return dao.registerTopic(id,t);
	}

	@Override
	public String updateAdmin(int id, String newpassword) {
		System.out.println("In Admin Updation Form");
		return dao.updateAdmin(id,newpassword);
	}
}

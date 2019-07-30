package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStudentDao;

import pojos.Content;
import pojos.Course;
import pojos.Modules;
import pojos.Student;
import pojos.Topic;

@Service
@Transactional
public class IStudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao dao;
	@Override
	public Student validateStudent(String prn, String password) {
		System.out.println("In Student Validation Service Layer");
		return dao.validateStudent(prn,password);
	}
	@Override
	public List<Course> getCourseList(int studentId) {
		System.out.println("In Student Course List");
		return dao.getCourseList(studentId);
	}
	@Override
	public List<Modules> getModulesList(int id) {
		System.out.println("In Modules List Service");
		return dao.getModulesList(id);
	}
	@Override
	public List<Topic> getTopicList(int id) {
		System.out.println("In Topic List Service");
		return dao.getTopicList(id);
	}
	@Override
	public Topic getTopicDetails(int id) {
		System.out.println("In Topic Details Service");
		return dao.getTopicDetails(id);
	}
	@Override
	public List<Content> getContentList(int id) {
		System.out.println("In Topic Content List Service");
		return dao.getContentList(id);
	}
	@Override
	public Content getContentDetails(int id) {
		System.out.println("In Content Details");
		return dao.getContentDetails(id);
	}
	@Override
	public String updateStudent(int id,String password) {
		System.out.println("In Student Details");
		return dao.updateStudent(id,password);
	}
}

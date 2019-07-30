package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IFacultyDao;

import pojos.Content;
import pojos.Faculty;
import pojos.Topic;

@Service
@Transactional
public class IFacultyServiceImpl implements IFacultyService {

	@Autowired
	private IFacultyDao dao;
	@Override
	public Faculty validateFaculty(String email, String password) {
		System.out.println("In Faculty Validation Service Impl");
		return dao.validateFaculty(email,password);
	}
	@Override
	public List<Topic> getTopicList(int id) {
		System.out.println("In Topic List Service Impl");
		return dao.getTopicList(id);
	}
	@Override
	public Topic getTopicPath(int topicId) {
		System.out.println("In Topic Path service Impl");
		return dao.getTopicPath(topicId);
	}
	
	@Override
	public String updateTopic(Topic t, Content c) {
		System.out.println("In Topic update Impl");
		return dao.updateTopic(t,c);
	}
	@Override
	public String updateFaculty(int id, String newpassword) {
		System.out.println("In Update Faculty");
		return dao.updateFaculty(id,newpassword);
	}
	
}

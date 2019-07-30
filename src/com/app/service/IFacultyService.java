package com.app.service;

import java.util.List;

import pojos.Content;
import pojos.Faculty;
import pojos.Topic;

public interface IFacultyService {

	Faculty validateFaculty(String email, String password);
	List<Topic> getTopicList(int id);
	Topic getTopicPath(int topicId);
	String updateTopic(Topic t, Content c);
	String updateFaculty(int id, String newpassword);

}

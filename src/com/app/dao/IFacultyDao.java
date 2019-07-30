package com.app.dao;

import java.util.List;

import pojos.Content;
import pojos.Faculty;
import pojos.Topic;

public interface IFacultyDao {
	Faculty validateFaculty(String email, String password);
	List<Topic> getTopicList(int id);
	Topic getTopicPath(int topicId);
	String updateTopic(Topic t, Content c);
	String updateFaculty(int id, String newpassword);

}

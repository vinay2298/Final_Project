package com.app.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.Content;
import pojos.Faculty;
import pojos.Modules;
import pojos.Topic;

@Repository
public class IFacultyDaoImpl implements IFacultyDao {

	@Autowired
	private SessionFactory sf;
	@Override
	public Faculty validateFaculty(String email, String password) {
		System.out.println("In validate Faculty Dao Impl");
		String jpql = "select f from Faculty f where f.facultyEmail =:email and f.facultyPassword =:password";
		Faculty f = sf.getCurrentSession().createQuery(jpql, Faculty.class).setParameter("email", email).setParameter("password", password).getSingleResult();
		return f;
	}
	@Override
	public List<Topic> getTopicList(int moduleId) {
		System.out.println("In Topic List");
		//Modules m = sf.getCurrentSession().get(Modules.class,moduleId);
		String jpql = "select t from Topic t JOIN t.module m where m.moduleId =:moduleId";
		List<Topic> list = sf.getCurrentSession().createQuery(jpql,Topic.class).setParameter("moduleId", moduleId).getResultList();
		list.forEach(System.out::println);
		return list;
	}
	@Override
	public Topic getTopicPath(int topicId) {
		System.out.println("In Topic PAth Dao");
		Topic t = sf.getCurrentSession().get(Topic.class,topicId);
		return t;
	}

	/*
	 * @Override public String updateTopic(Topic t) {
	 * System.out.println("In Topic Update Dao"); try {
	 * sf.getCurrentSession().merge(t); String msg = "Topic Updated"; return msg; }
	 * catch(HibernateException e) { e.printStackTrace(); } return null; }
	 */
	@Override
	public String updateTopic(Topic t, Content c) {
		System.out.println("In Topic Update Dao");
		try {
			sf.getCurrentSession().persist(c);
			t.addContent(c);
			String msg = "Content Created";
			return msg;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String updateFaculty(int facultyId, String newpassword) {
		String msg = null;
		System.out.println("In Faculty Update");
		Faculty f = sf.getCurrentSession().get(Faculty.class,facultyId);
		try {
			f.setFacultyPassword(newpassword);
			sf.getCurrentSession().merge(f);
			msg="Password Updated Successfully";
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		return msg;
	}

}

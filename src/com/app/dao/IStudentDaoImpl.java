package com.app.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.Content;
import pojos.Course;
import pojos.Modules;
import pojos.Student;
import pojos.Topic;

@Repository
public class IStudentDaoImpl implements IStudentDao {

	@Autowired
	private SessionFactory sf;
	@Override
	public Student validateStudent(String prn, String password) {
		String jpql = "select s from Student s where s.studentPrn =:prn and s.password=:password";
		return sf.getCurrentSession()
				.createQuery(jpql, Student.class)
				.setParameter("prn", prn)
				.setParameter("password", password)
				.getSingleResult();
	}
	@Override
	public List<Course> getCourseList(int studentId) {
		String jpql = "select c from Course c JOIN c.students s where s.studentId =:studentId";
		List<Course> list = sf.getCurrentSession().createQuery(jpql, Course.class).setParameter("studentId", studentId).getResultList();
		return list;
	}
	@Override
	public List<Modules> getModulesList(int courseId) {
		String jpql = "select m from Modules m JOIN m.course c where c.courseId =:courseId";
		List<Modules> list = sf.getCurrentSession().createQuery(jpql, Modules.class).setParameter("courseId", courseId).getResultList();
		return list;
	}
	@Override
	public List<Topic> getTopicList(int moduleId) {
		String jpql = "select t from Topic t JOIN t.module m where m.moduleId =:moduleId";
		List<Topic> list = sf.getCurrentSession().createQuery(jpql,Topic.class).setParameter("moduleId", moduleId).getResultList();
		return list;
	}
	@Override
	public Topic getTopicDetails(int topicId) {
		String jpql = "select t from Topic t where t.topicId =:topicId";
		Topic t = sf.getCurrentSession().createQuery(jpql, Topic.class).setParameter("topicId", topicId).getSingleResult();
		return t;
	}
	@Override
	public List<Content> getContentList(int topicId) {
		String jpql = "select c from Content c JOIN c.topic t where t.topicId =:topicId";
		List<Content> list = sf.getCurrentSession().createQuery(jpql,Content.class).setParameter("topicId", topicId).getResultList();
		return list;
	}
	@Override
	public Content getContentDetails(int contentId) {
		String jqpl = "select c from Content c where c.contentId =:contentId";
		Content c = sf.getCurrentSession().createQuery(jqpl, Content.class).setParameter("contentId", contentId).getSingleResult();
		return c;
	}
	@Override
	public String updateStudent(int studentId,String password) {
		System.out.println("In Student Details Update");
		String msg=null;
		Student s = sf.getCurrentSession().get(Student.class,studentId);
		try {
		s.setPassword(password);
		sf.getCurrentSession().merge(s);
		msg = "Password Updated Successfully";
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		return msg;
	}
}

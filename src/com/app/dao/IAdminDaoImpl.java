package com.app.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.Coordinator;
import pojos.Course;
import pojos.Course_Modules;
import pojos.Faculty;
import pojos.Modules;
import pojos.Student;
import pojos.Topic;

@Repository
public class IAdminDaoImpl implements IAdminDao {

	@Autowired
	private SessionFactory sf;
	@Override
	public Coordinator validateAdmin(String email, String password) {
		String jpql = "select c from Coordinator c where c.coordinatorEmail =:email and c.password =:password";
		System.out.println("In Admin Dao Validate Coordinator");
		return sf.getCurrentSession()
				.createQuery(jpql, Coordinator.class)
				.setParameter("email",email)
				.setParameter("password",password)
				.getSingleResult();
	}
	@Override
	public String registerCourse(int coordinatorid,Course c) {
		String msg=null;
		System.out.println("In Course Registration Dao");
		Session hs = sf.getCurrentSession();
		try {
			Coordinator cd = hs.get(Coordinator.class, coordinatorid);
			int id = cd.getCoordinatorid();
			System.out.println(id);
			c.setCoordinator(cd);
			sf.getCurrentSession().persist(c);
			msg= "Course Added Successfully";
			 
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		return msg;		
	}
	
	@Override
	public String registerModule(int courseId,int facultyId, Modules m) {
		String msg = null;
		Session hs = sf.getCurrentSession();
		System.out.println("In Module Registration Dao");
		try {
			Course c = hs.get(Course.class, courseId);
			Faculty f = hs.get(Faculty.class,facultyId);
			int id = c.getCourseId();
			System.out.println(id);
			m.setFaculty(f);
			List<Course> list = m.getCourse();
			List<Modules> lst = c.getModules();
			lst.add(m);
			list.add(c);
			m.setCourse(list);
			sf.getCurrentSession().persist(m);
			/*
			 * String jpql =
			 * "select cm from Course_Modules cm JOIN cm.course c where c.courseId =:courseId"
			 * ; Course_Modules cm= hs.createQuery(jpql,
			 * Course_Modules.class).setParameter("courseId", courseId).getSingleResult();
			 * cm.setStartDate(m.getStartDate()); cm.setEndDate(m.getEndDate());
			 * cm.setStatus(m.getStatus()); sf.getCurrentSession().merge(cm);
			 */
			msg = "Module Added Successfully";
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String registerFaculty(int courseId, Faculty f) {
		String msg=null;
		System.out.println("In Course Registration Dao");
		Session hs = sf.getCurrentSession();
		try {
			Course c = hs.get(Course.class, courseId);
			int id = c.getCourseId();
			System.out.println(id);
			f.setCourse(c);
			sf.getCurrentSession().persist(f);
			msg= "Faculty Added Successfully";
			 
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		return msg;
		}
	@Override
	public String registerTopic(int moduleId, Topic t) {
		String msg = null;
		System.out.println("In Faculy Registration Dao");
		Session hs = sf.getCurrentSession();
		try {
			Modules m = hs.get(Modules.class, moduleId);
			t.setModule(m);
			sf.getCurrentSession().persist(t);
			msg = "Topic Added Successfully";
			return msg;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String registerStudent(int courseId, Student s) {
		String msg = null;
		Session hs = sf.getCurrentSession();
		System.out.println("In Student Registration Dao");
		try {
			Course c = hs.get(Course.class, courseId);
			List<Course> list = s.getCourse();
			list.add(c);
			System.out.println(c);
			s.setCourse(list);
			List<Student> lst = c.getStudents();
			lst.add(s);
			c.setStudents(lst);
			sf.getCurrentSession().persist(s);
			msg = "Student Added Successfully";
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Course getCourseDetails(int coordinatorid,int courseId) {
		System.out.println("In Get Course Details dao");
		String jpql = "select c from Course c JOIN c.coordinator cd where cd.coordinatorid =:coordinatorid and c.courseId =:courseId";
		Course c = sf.getCurrentSession().createQuery(jpql, Course.class).setParameter("coordinatorid",coordinatorid).setParameter("courseId", courseId).getSingleResult();
		System.out.println(c);
		return c;
	}
	@Override
	public String updateCourse(int coordinatorid,Course c) {	
		System.out.println("In Update Course Details dao");
		Session hs = sf.getCurrentSession();
		Coordinator cd = hs.get(Coordinator.class, coordinatorid);
		int id = cd.getCoordinatorid();
		System.out.println(id);
		c.setCoordinator(cd);
		System.out.println("Coordinator Set");
		sf.getCurrentSession().merge(c);
		c.setCoordinator(cd);
		return "Course Updated Successfully";
	}
	@Override
	public String removeCourse(int coordinatorid, Course c) {
		System.out.println("In Remove Course Details dao");
		Session hs = sf.getCurrentSession();
		Coordinator cd = hs.get(Coordinator.class, coordinatorid);
		List<Course> list = cd.getCourse();	
		list.remove(c);
		cd.setCourse(list);
		list.forEach(System.out::println);
		hs.clear();
		sf.getCurrentSession().remove(c);
		return "Course Removed Successfully";
	}
	@Override
	public List<Modules> getModuleList(int courseId) {
		String jpql = "select m from Modules m JOIN m.course c where c.courseId =:courseId";
		List<Modules> list = sf.getCurrentSession().createQuery(jpql, Modules.class).setParameter("courseId", courseId).getResultList();
		return list;
	}
	@Override
	public List<Student> getStudentList(int courseId) {
		String jpql = "select s from Student s JOIN s.course c where c.courseId =:courseId";
		return sf.getCurrentSession().createQuery(jpql, Student.class).setParameter("courseId", courseId).getResultList();
	}
	@Override
	public Modules getModuleDetails(int moduleId) {
		System.out.println("In Get Module Details dao");
		Modules m = sf.getCurrentSession().get(Modules.class, moduleId);
		return m;
	}
	@Override
	public List<Faculty> getFacultyList(int courseId) {
		String jpql = "select f from Faculy f JOIN f.course c where c.courseId =:courseId";
		return sf.getCurrentSession().createQuery(jpql,Faculty.class).setParameter("courseId", courseId).getResultList();
	}
	@Override
	public List<Modules> getFacultyDetails(int facultyId) {
		System.out.println("In Faculty Details");	
		String jpql = "select m from Modules m JOIN m.faculty f where f.facultyId =:facultyId";
		List<Modules> list = sf.getCurrentSession().createQuery(jpql, Modules.class).setParameter("facultyId", facultyId).getResultList();
		return list;
	}
	@Override
	public String registerCoordinator(Coordinator c) {
		System.out.println("In Coordinator Registration");
		sf.getCurrentSession().persist(c);
		String msg = "Registration Successful";
		return msg ;
	}
	@Override
	public List<Course> getCourseDetails(int studentId) {
		String jpql = "select c from Course c JOIN c.students s where s.studentId =:studentId";
		return sf.getCurrentSession().createQuery(jpql, Course.class).setParameter("studentId",studentId).getResultList();
	}
	@Override
	public List<Course> getCourseList(int coordinatorid) {
		String jpql = "select c from Course c JOIN c.coordinator cd where cd.coordinatorid =:coordinatorid";
		return sf.getCurrentSession().createQuery(jpql, Course.class).setParameter("coordinatorid", coordinatorid).getResultList();
				
	}
	@Override
	public String updateAdmin(int coordinatorid, String newpassword) {
		System.out.println("In Admin Updation Problem");
		Coordinator c = sf.getCurrentSession().get(Coordinator.class, coordinatorid);
		String msg = null;
		System.out.println(c);
		try {
			c.setPassword(newpassword);
			sf.getCurrentSession().merge(c);
			msg = "Password Updated Successfully";
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		return msg;
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
		
}
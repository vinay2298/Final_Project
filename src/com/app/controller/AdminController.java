package com.app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.IAdminService;

import pojos.Coordinator;
import pojos.Course;
import pojos.Faculty;
import pojos.Modules;
import pojos.Student;
import pojos.Topic;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private IAdminService service;

	public AdminController() {
		System.out.println("In Admin Controller Constructor");
	}

	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("In Show Login Form");
		return "admin/login";
	}

	@PostMapping("/login")
	public String validateLogin(@RequestParam String email, @RequestParam String password, Model map, HttpSession hs) {
		System.out.println("This is Validate Login in Admin with email " + email + " and password " + password);
		try {
			Coordinator c = service.validateAdmin(email, password);
			map.addAttribute("status", "Successful Login");
			hs.setAttribute("admin_dtls", c);
			return "redirect:/admin/home";

		} catch (NoResultException e) {
			hs.setAttribute("status", "Invalid Login or Password");
			return "admin/login";
		}
	}

	@GetMapping("/home")
	public String showHomePage(HttpSession hs) {
		System.out.println("In show Home Page");
		hs.getAttribute("admin_dtls");
		return "admin/home";
	}

	@GetMapping("/updatePassword")
	public String adminUpdate(HttpSession hs, Coordinator c) {
		c = (Coordinator) hs.getAttribute("admin_dtls");
		hs.setAttribute("admin_details", c);
		System.out.println(c);
		return "admin/updatePassword";
	}

	@PostMapping("/updatePassword")
	public String adminPostUpdate(@RequestParam String oldpassword, @RequestParam String newpassword, HttpSession hs,
			Model map) {
		Coordinator s = (Coordinator) hs.getAttribute("admin_details");
		System.out.println("Admin details " + s);
		String msg = null;
		int id = s.getCoordinatorid();
		String pass = s.getPassword();

		if (pass.equals(oldpassword)) {
			System.out.println("HHHHH");
			msg = service.updateAdmin(id, newpassword);
		}
		map.addAttribute("passmsg", msg);
		System.out.println(s);
		if (msg != null) {
			return "redirect:home";// replace forward by redirect
		} else {
			return "admin/updatePassword";
		}
	}

	@GetMapping("/register")
	public String showRegForm(Coordinator c) {
		System.out.println("in show reg form " + c);
		// map.addAttribute(new Course());
		return "admin/register";
	}

	@PostMapping("/register")
	public String processRegForm(Coordinator c, Model map, HttpSession hs) {
		System.out.println("in process reg form");
		System.out.println("Course details " + c);
		// invoke service layer method
		String s = service.registerCoordinator(c);
		System.out.println(s);
		// hs.setAttribute("addCoordinator", s);
		map.addAttribute("status", s);
		return "redirect:login";// replace forward by redirect
	}

	@GetMapping("/addCourse")
	public String showAddForm(Course c) {
		System.out.println("in show reg form " + c);
		// map.addAttribute(new Course());
		return "admin/addCourse";
	}

	@PostMapping("/addCourse")
	public String processRegForm(@RequestParam int id, Course c, Model map, HttpSession hs) {
		System.out.println("in process reg form");
		System.out.println("Course details " + c + "With Coordinator ID" + id);
		// invoke service layer method
		String s = service.registerCourse(id, c);
		System.out.println(s);
		hs.setAttribute("addCourse", s);
		map.addAttribute("status", "Course Added Successfully");
		return "redirect:home";// replace forward by redirect
	}

	@GetMapping("/clist")
	public String showCourseList(Model map, HttpSession hs) {

		Coordinator c = (Coordinator) hs.getAttribute("admin_dtls");
		int id = c.getCoordinatorid();
		System.out.println(id);
		List<Course> list = service.getCourseList(id);
		list.forEach(System.out::println);
		map.addAttribute("course_list", list);
		return "admin/list";
	}

	@GetMapping("/addModule")
	public String showAddModule(Modules m) {
		System.out.println("In show Reg Form" + m);
		return "admin/addModule";
	}

	@PostMapping("/addModule")
	public String processRegForm(@RequestParam int id, @RequestParam int fid, Modules m, Model map, HttpSession hs) {
		System.out.println("In Modules Registration Form");
		System.out.println("Module Details");

		String s = service.registerModule(id, fid, m);
		hs.setAttribute("addModule", m);
		if (s != null) {
			map.addAttribute("status", "Module Added Successfully");
			return "redirect:home";
		} else {
			map.addAttribute("status", "Module Cannot be Added");
			return "addModule";
		}
	}

	@GetMapping("/addFaculty")
	public String showAddFaculty(Faculty f) {
		System.out.println("in show reg form " + f);
		// map.addAttribute(new Course());
		return "admin/addFaculty";
	}

	@PostMapping("/addFaculty")
	public String processRegForm(@RequestParam int id, Faculty f, HttpSession hs, Model map) {
		System.out.println("in process reg form");
		System.out.println("Course details " + f + "With Coordinator ID" + id);
		// invoke service layer method
		String s = service.registerFaculty(id, f);
		System.out.println(s);
		hs.setAttribute("addFaculty", s);
		map.addAttribute("status", "Faculty Added Successfully");
		return "redirect:home";// replace forward by redirect
	}

	@GetMapping("/addStudent")
	public String showAddStudent(Student s) {
		System.out.println("In show Reg Form" + s);
		return "admin/addStudent";
	}

	@PostMapping("/addStudent")
	public String processRegForm(@RequestParam int id, Student s, HttpSession hs, Model map) {
		System.out.println("In Student Registration Form");
		System.out.println("Student Details" + s);

		String msg = service.registerStudent(id, s);
		// hs.setAttribute("addStudent", msg);
		if (msg != null) {
			map.addAttribute("status", "Student Added Successfully");
			return "redirect:home";
		} else {
			map.addAttribute("status", "Student Cannot be Added");
			return "addStudent";
		}
	}

	@GetMapping("/topic")
	public String addTopicForm(@RequestParam int id, Topic t, Model map) {
		System.out.println("In Topic Registration Form");
		Modules m = service.getModuleDetails(id);
		map.addAttribute("module_dtls", m);
		return "admin/addTopic";
	}

	@PostMapping("/topic")
	public String processTopicForm(@RequestParam int id, Topic t, HttpSession hs, Model map) {
		System.out.println("In Topic Registration Form");
		System.out.println("Topic Details " + t);
		String msg = service.registerTopic(id, t);
		if (msg != null) {
			map.addAttribute("status", "Topic Added Successfully");
			return "redirect:home";
		} else {
			map.addAttribute("status", "Topic Cannot be Added");
			return "admin/topic";
		}
	}

	@GetMapping("/update")
	public String showUpateForm(@RequestParam int id, Course c, HttpSession hs) {
		System.out.println("In Course Update Form");
		Coordinator cd = (Coordinator) hs.getAttribute("admin_dtls");
		int coordinatorid = cd.getCoordinatorid();
		c = service.getCourseDetails(coordinatorid, id);
		System.out.println(c);
		hs.setAttribute("course_dtls", c);
		return "admin/update";
	}

	@PostMapping("/update")
	public String processUpdateForm(Course c, HttpSession hs, Model map) {
		System.out.println("in process reg form");
		Coordinator cd = (Coordinator) hs.getAttribute("admin_dtls");
		int id = cd.getCoordinatorid();
		System.out.println("Course details " + c + "With Coordinator ID" + id);
		// invoke service layer method
		// hs.removeAttribute("course_dtls");
		String s = service.updateCourse(id, c);
		map.addAttribute("msg", s);
		System.out.println(s);
		return "redirect:home";// replace forward by redirect
	}

	/*
	 * @GetMapping("/remove") public String deleteForm(@RequestParam int id, Course
	 * c, HttpSession hs, Model map) { System.out.println("In Course Update Form");
	 * Coordinator cd = (Coordinator) hs.getAttribute("admin_dtls"); int
	 * coordinatorid = cd.getCoordinatorid(); c =
	 * service.getCourseDetails(coordinatorid, id); System.out.println(c); String s
	 * = service.removeCourse(coordinatorid, c); map.addAttribute("msg", s); return
	 * "redirect:home"; }
	 */

	@GetMapping("/module")
	public String showCourseList(@RequestParam int id, Model map, HttpSession hs) {

		/*
		 * Coordinator cd = (Coordinator) hs.getAttribute("admin_dtls"); int
		 * coordinatorid = cd.getCoordinatorid(); Course c =
		 * service.getCourseDetails(coordinatorid,id); System.out.println(c);
		 */
		Set<Modules> list = new HashSet<Modules>(service.getModuleList(id));
		list.forEach(System.out::println);
		map.addAttribute("module_list", list);
		return "admin/mlist";
	}

	@GetMapping("/student")
	public String showStudentList(@RequestParam int id, Model map, HttpSession hs) {

		/*
		 * Coordinator cd = (Coordinator) hs.getAttribute("admin_dtls"); int
		 * coordinatorid = cd.getCoordinatorid(); Course c =
		 * service.getCourseDetails(coordinatorid,id); System.out.println(c);
		 */
		Set<Student> list = new HashSet<Student>(service.getStudentList(id));
		list.forEach(System.out::println);
		map.addAttribute("student_list", list);
		return "admin/slist";
	}

	@GetMapping("/faculty")
	public String facultyAssignForm(@RequestParam int id, Modules m, Model map, HttpSession hs) {
		/*
		 * System.out.println("In faculty Assign Form"); Coordinator cd = (Coordinator)
		 * hs.getAttribute("admin_dtls"); int courseId = c.getCourseId(); m =
		 * service.getModuleDetails(id); hs.setAttribute("module_dtls", m);
		 */
		Coordinator cd = (Coordinator) hs.getAttribute("admin_dtls");
		int coordinatorid = cd.getCoordinatorid();
		Course c = service.getCourseDetails(coordinatorid, id);
		hs.setAttribute("course_dtls", c);
		Set<Faculty> list = new HashSet<Faculty>(c.getFaculty());
		map.addAttribute("faculty_list", list);
		return "admin/flist";
	}

	@GetMapping("/assignModule")
	public String assignFacultyModule(@RequestParam int id, HttpSession hs, Model map) {
		List<Modules> list = service.getFacultyDetails(id);
		// hs.setAttribute("msg", "Faculty Assigned Successfully");
		map.addAttribute("module_list", list);
		return "admin/mlist";
	}

	/*
	 * @GetMapping("/courselist") public String showStudentCourseList(@RequestParam
	 * int id,Model map,HttpSession hs) {
	 * 
	 * 
	 * Coordinator cd = (Coordinator) hs.getAttribute("admin_dtls"); int
	 * coordinatorid = cd.getCoordinatorid(); Course c =
	 * service.getCourseDetails(coordinatorid,id); System.out.println(c);
	 * 
	 * Set<Course> list = new HashSet<Course>(service.getCourseList(id));
	 * list.forEach(System.out::println); map.addAttribute("course_list", list);
	 * return "admin/list"; }
	 */
	@GetMapping("/logout")
	public String logoutAdmin(Model map, HttpSession hs, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in logout");
		// copy user_dtls from session scope----->request scope(model map)
		// map.addAttribute("user_info", hs.getAttribute("admin_dtls"));
		// discard session
		hs.invalidate();
		// auto redirect clnt after a delay to index page
		response.setHeader("refresh", "5;url=" + request.getContextPath());
		return "student/logout";
	}
}
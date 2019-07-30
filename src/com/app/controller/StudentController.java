package com.app.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
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
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.IStudentService;

import pojos.Content;
import pojos.Coordinator;
import pojos.Course;
import pojos.Modules;
import pojos.Student;
import pojos.Topic;

@Controller 
@RequestMapping("student")
public class StudentController {

	@Autowired
	private IStudentService service;
	public StudentController()
	{
		System.out.println("In Constructor of StudentController");
	}
	
	@GetMapping("/login")
	public String showLoginForm()
	{
		System.out.println("In Show Login Form");
		return "student/login";
	}
	
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String prn,@RequestParam String password,Model map,HttpSession hs)
	{
		System.out.println("In process login Form "+prn+""+password);
		try {
			Student s = service.validateStudent(prn,password);
			hs.setAttribute("Status", "Successful Login");
			hs.setAttribute("student_dtls", s);
			return "redirect:/student/home";
		}
		catch(NoResultException e)
		{
			
			System.out.println("Invalid Login :"+e);
			map.addAttribute("status","Invalid Login , Please Retry");
			return "student/login";
		}
	}
	
	@GetMapping("/home")
	public String studentHome(HttpSession hs)
	{
		System.out.println("This is Student Home ");
		hs.getAttribute("student_dtls");
		return "student/home";
	}
	@GetMapping("/update")
	public String studentUpdate(HttpSession hs,Student s)
	{
		s = (Student)hs.getAttribute("student_dtls");
		hs.setAttribute("student_details",s);
		System.out.println(s);
		return "student/update";
	}
	@PostMapping("/update")
	public String studentPostUpdate(@RequestParam String oldpassword,@RequestParam String newpassword,HttpSession hs)
	{
		Student s = (Student)hs.getAttribute("student_details");
		System.out.println("Student details " + s);
		String msg = null;
		int id = s.getStudentId();
		String pass = s.getPassword();
		
		if(pass.equals(oldpassword))
		{
		System.out.println("HHHHH");
		msg = service.updateStudent(id,newpassword);
		}
		hs.setAttribute("msg", msg);
		System.out.println(s);
		if(msg != null)
		{
		return "redirect:home";// replace forward by redirect
		}
		else
		{
			return "update";
		}
	}
	@GetMapping("/course")
	public String studentCourse(HttpSession hs,Model map)
	{
		System.out.println("This is Show Course Details");
		Student s = (Student) hs.getAttribute("student_dtls");
		int studentId = s.getStudentId(); 
		Set<Course> list = new HashSet<Course>(service.getCourseList(studentId));
		list.forEach(System.out::println);
		map.addAttribute("course_list",list);
		return "student/clist";
	}
	@GetMapping("/module")
	public String studentCourseModule(@RequestParam int id,Model map)
	{
		System.out.println("This is Student Module Details");
		Set<Modules> list =new HashSet<Modules>(service.getModulesList(id));
		list.forEach(System.out::println);
		map.addAttribute("module_list",list);
		return "student/mlist";
	}
	@GetMapping("/topic")
	public String moduleTopicList(@RequestParam int id,Model map)
	{
		System.out.println("This is Module Topic List");
		List<Topic> list = service.getTopicList(id);
		list.forEach(System.out::println);
		map.addAttribute("topic_list",list);
		return "student/tlist";
	}
	@GetMapping("/content")
	public String topicContentList(@RequestParam int id,Model map)
	{
		System.out.println("This is Topic Content List");
		List<Content> list = service.getContentList(id);
		list.forEach(System.out::println);
		map.addAttribute("content_list",list);
		return "student/ctlist";
	}
	@GetMapping("/download")
	public void getDownloadFile(@RequestParam int id,HttpServletResponse response) throws IOException
	{
		Content c = service.getContentDetails(id);
		String path = c.getContentPath();
		File file = null;
		file = new File(path);
		/*
		 * ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		 * file = new File(classloader.getResource(path).getFile()); if(!file.exists()){
		 * String errorMessage = "Sorry. The file you are looking for does not exist";
		 * System.out.println(errorMessage); OutputStream outputStream =
		 * response.getOutputStream();
		 * outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
		 * outputStream.close(); return; }
		 */         
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }
        System.out.println("mimetype : "+mimeType); 
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
        response.setContentLength((int)file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
	@GetMapping("/logout")
	public String logoutStudent(Model map, HttpSession hs, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in logout");
		// copy user_dtls from session scope----->request scope(model map)
		map.addAttribute("user_info", hs.getAttribute("student_dtls"));
		// discard session
		hs.invalidate();
		// auto redirect clnt after a delay to index page
		response.setHeader("refresh", "5;url=" + request.getContextPath());
		return "student/logout";
	}
	
}

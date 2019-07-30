package com.app.controller;
import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.app.service.IFacultyService;

import pojos.Content;
import pojos.Faculty;
import pojos.Modules;
import pojos.Topic;

@Controller
@RequestMapping("faculty")
public class FacultyController {

	@Autowired
	private IFacultyService service;
	String folderPath = null;
	public FacultyController() {
		System.out.println("In Faculty Controller Constructor");
	}
	@GetMapping("/login")
	public String showLoginForm()
	{
		System.out.println("In show Login Form Faculty");
		return "faculty/login";
	}
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email,@RequestParam String password,HttpSession hs,Model map)
	{
		System.out.println("This is Faculty Login Validation is "+email+" "+password);
		try
		{
			Faculty f = service.validateFaculty(email,password);
			if(f!=null)
			{
				hs.setAttribute("faculty_details", f);
				map.addAttribute("status"," Successfull Login");
				return "redirect:home";
			}
		}
		catch(NoResultException e)
		{
			e.printStackTrace();
			map.addAttribute("status","InValid Email or Password");
			return "faculty/login";
		}
		return "faculty/login";
	}
	@GetMapping("/home")
	public String processHomeForm(HttpSession hs)
	{
		System.out.println("In Faculty Home");
		hs.getAttribute("faculty_details");
		return "faculty/home";
	}
	@GetMapping("/update")
	public String facultyUpdate(HttpSession hs,Faculty f)
	{
		System.out.println("In Update Form");
		f = (Faculty)hs.getAttribute("faculty_details");
		hs.setAttribute("faculty_dtls",f);
		System.out.println(f);
		return "faculty/update";
	}
	@PostMapping("/update")
	public String facultyPostUpdate(@RequestParam String oldpassword,@RequestParam String newpassword,HttpSession hs)
	{
		Faculty f = (Faculty)hs.getAttribute("faculty_dtls");
		System.out.println("Student details " + f);
		String msg = null;
		int id = f.getFacultyId();
		String pass = f.getFacultyPassword();
		
		if(pass.equals(oldpassword))
		{
		System.out.println("HHHHH");
		msg = service.updateFaculty(id,newpassword);
		}
		hs.setAttribute("msg", msg);
		System.out.println(f);
		if(msg != null)
		{
		return "redirect:home";// replace forward by redirect
		}
		else
		{
			return "faculty/update";
		}
	}
	@GetMapping("/moduleList")
	public String showModuleList(Model map,HttpSession hs)
	{
		
		Faculty f = (Faculty) hs.getAttribute("faculty_details");
		int id = f.getFacultyId();
		System.out.println(id);
		List<Modules> list = f.getModules();
		list.forEach(System.out::println);
		map.addAttribute("module_list", list);
		return "faculty/list";
	}
	@GetMapping("/topic")
	public String showTopicList(@RequestParam int id,Topic t,Model map)
	{
		System.out.println("In Show Topic List");
		Set<Topic> list = new HashSet<Topic>(service.getTopicList(id));
		map.addAttribute("topic_list", list);
		return "faculty/tlist";
	}
	@GetMapping("/showUploadForm")
	public String uploadForm(@RequestParam int topicId,Model map) {
	
		Topic t=service.getTopicPath(topicId);
		folderPath=t.getPath();
		return "faculty/uploadForm";
	}

	@PostMapping("/showUploadForm")
	//@RequestMapping(value = "/showUploadForm", method = RequestMethod.POST)
	public String uploadDocument(@RequestParam("contents") MultipartFile file,@RequestParam int topicId,HttpSession hs) {
		Topic t=service.getTopicPath(topicId);
		folderPath=t.getPath();
		String uploadLocation = folderPath;
		System.out.println("upload form"+folderPath);
		Content c = new Content();
		String append = file.getOriginalFilename();
		c.setContentName(file.getOriginalFilename());
		System.out.println(file.getOriginalFilename());
		File dest = new File(uploadLocation, file.getOriginalFilename());
		// file transferred to server side folder
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = uploadLocation + "\\" + append ; 
		System.out.println(path);
		c.setContentPath(path);
		String s = service.updateTopic(t,c);
		return "redirect:home";
	}
	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}
	@GetMapping("/logout")
	public String logoutAdmin(Model map, HttpSession hs, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in logout");
		// copy user_dtls from session scope----->request scope(model map)
		map.addAttribute("user_info", hs.getAttribute("faculty_dtls"));
		// discard session
		hs.invalidate();
		// auto redirect clnt after a delay to index page
		response.setHeader("refresh", "1;url=" + request.getContextPath());
		return "student/logout";
	}
}

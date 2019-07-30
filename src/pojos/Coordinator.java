package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="coordinator")
public class Coordinator {

	private Integer coordinatorid;
	private String coordinatorName;
	private String coordinatorEmail;
	private String coordinatorMobile;
	private String password;
	private List<Course> course = new ArrayList<>();
	public Coordinator()
	{
		System.out.println("In Coordinator Constructor");
	}
	public Coordinator(Integer coordinatorid, String coordinatorName, String coordinatorEmail, String coordinatorMobile,
			String password) {
		super();
		this.coordinatorid = coordinatorid;
		this.coordinatorName = coordinatorName;
		this.coordinatorEmail = coordinatorEmail;
		this.coordinatorMobile = coordinatorMobile;
		this.password = password;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCoordinatorid() {
		return coordinatorid;
	}
	public void setCoordinatorid(Integer coordinatorid) {
		this.coordinatorid = coordinatorid;
	}
	public String getCoordinatorName() {
		return coordinatorName;
	}
	public void setCoordinatorName(String coordinatorName) {
		this.coordinatorName = coordinatorName;
	}
	public String getCoordinatorEmail() {
		return coordinatorEmail;
	}
	public void setCoordinatorEmail(String coordinatorEmail) {
		this.coordinatorEmail = coordinatorEmail;
	}
	public String getCoordinatorMobile() {
		return coordinatorMobile;
	}
	public void setCoordinatorMobile(String coordinatorMobile) {
		this.coordinatorMobile = coordinatorMobile;
	}
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(targetEntity=Course.class,mappedBy="coordinator",fetch=FetchType.EAGER)
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	public Coordinator(List<Course> course) {
		super();
		this.course = course;
	}
	
	public void addCourse(Course c)
	{
		course.add(c);
		c.setCoordinator(this);
	}
	
	public void removeCourse(Course c)
	{
		course.remove(c);
		c.setCoordinator(null);
	}
	@Override
	public String toString() {
		return "Coordinator [coordinatorid=" + coordinatorid + ", coordinatorName=" + coordinatorName
				+ ", coordinatorEmail=" + coordinatorEmail + ", coordinatorMobile=" + coordinatorMobile + ", password="
				+ password + "]";
	}	
}

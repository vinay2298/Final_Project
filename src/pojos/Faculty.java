package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="faculty")
public class Faculty {

	private Integer facultyId;
	private String facultyName;
	private String facultyEmail;
	private String facultyPhone;
	private String facultyPassword;
	private List<Modules> modules = new ArrayList<>();
	private Course course;
	public Faculty() {
		System.out.println("In Faculty Constructor");
	}
	public Faculty(Integer facultyId, String facultyName, String facultyEmail, String facultyPhone,
			String facultyPassword) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.facultyEmail = facultyEmail;
		this.facultyPhone = facultyPhone;
		this.facultyPassword = facultyPassword;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	@Column(unique=true)
	public String getFacultyEmail() {
		return facultyEmail;
	}
	public void setFacultyEmail(String facultyEmail) {
		this.facultyEmail = facultyEmail;
	}
	
	@Column(unique=true)
	public String getFacultyPhone() {
		return facultyPhone;
	}
	public void setFacultyPhone(String facultyPhone) {
		this.facultyPhone = facultyPhone;
	}
	public String getFacultyPassword() {
		return facultyPassword;
	}
	public void setFacultyPassword(String facultyPassword) {
		this.facultyPassword = facultyPassword;
	}
	@OneToMany(targetEntity=Modules.class,mappedBy="faculty",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	public List<Modules> getModules() {
		return modules;
	}
	public void setModules(List<Modules> modules) {
		this.modules = modules;
	}
	@ManyToOne
	@JoinColumn(name="courseId")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public void addModule(Modules c)
	{
		modules.add(c);
		c.setFaculty(this);
	}
	
	public void removeModule(Modules c)
	{
		modules.remove(c);
		c.setFaculty(null);
	}
	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", facultyEmail=" + facultyEmail
				+ ", facultyPhone=" + facultyPhone + ", facultyPassword=" + facultyPassword + "]";
	}
}

package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	private Integer studentId;
	private String StudentPrn;
	private String studentName;
	private String studentEmail;
	private String dob;
	private String studentMobile;
	private String studentAddress;
	private String password;
	private List<Course> course = new ArrayList<>();
	public Student() {
		System.out.println("In the Student Constructor ");
	}

	public Student(Integer studentId, String studentPrn, String studentName, String studentEmail, String dob,
			String studentMobile, String studentAddress, String password) {
		super();
		this.studentId = studentId;
		StudentPrn = studentPrn;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.dob = dob;
		this.studentMobile = studentMobile;
		this.studentAddress = studentAddress;
		this.password = password;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	@Column(unique=true)
	public String getStudentPrn() {
		return StudentPrn;
	}

	public void setStudentPrn(String studentPrn) {
		StudentPrn = studentPrn;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(unique=true)
	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Column(unique=true)
	public String getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name="Student_Course",
	joinColumns= {@JoinColumn(name="studentId")},
	inverseJoinColumns= {@JoinColumn(name="courseId")})  
	public List<Course> getCourse() {
		return course;
	}
	
	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public void addCourse(Course c)
	{
		course.add(c);
		List<Student> list = c.getStudents();
		list.add(this);
		c.setStudents(list);
	}
	public void removeCourse(Course c)
	{
		course.remove(c);
		List<Student> list = c.getStudents();
		list.remove(this);
		c.setStudents(list);
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", StudentPrn=" + StudentPrn + ", studentName=" + studentName
				+ ", studentEmail=" + studentEmail + ", dob=" + dob + ", studentMobile=" + studentMobile
				+ ", studentAddress=" + studentAddress + ", password=" + password + "]";
	}
}

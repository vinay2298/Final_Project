package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="course")
public class Course {

	private Integer courseId;
	private String courseName;
	private String duration;
	private int courseStrength;
	private List<Student> students = new ArrayList<>();
	private List<Modules> modules = new ArrayList<>();
	private List<Faculty> faculty = new ArrayList<>();
	private Coordinator coordinator;
	/*
	 * private Coordinator coordinator; private List<Modules> modules = new
	 * ArrayList<>(); private List<Faculty> faculty = new ArrayList<>();
	 */
	public Course() {
		System.out.println("In Course Constructor");
	}

	public Course(Integer courseId, String courseName, String duration, int courseStrength) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.courseStrength = courseStrength;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	@Column(unique=true)
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getCourseStrength() {
		return courseStrength;
	}

	public void setCourseStrength(int courseStrength) {
		this.courseStrength = courseStrength;
	}
	
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name="Student_Course",
	joinColumns= {@JoinColumn(name="courseId")},
	inverseJoinColumns= {@JoinColumn(name="studentId")})  
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	 @ManyToMany(cascade=CascadeType.MERGE)
	 @JoinTable(name="Course_Modules",joinColumns=
	 {@JoinColumn(referencedColumnName="courseId")},
	 inverseJoinColumns={@JoinColumn(referencedColumnName="moduleId")}) 
	 public List<Modules> getModules()
	 { 
		 return modules;
	 }
	  
	public void setModules(List<Modules> modules) 
	{
		 this.modules = modules; 
	}

	@OneToMany(targetEntity=Faculty.class,mappedBy="course",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	public List<Faculty> getFaculty() {
		return faculty;
	}

	public void setFaculty(List<Faculty> faculty) {
		this.faculty = faculty;
	}

	@ManyToOne
	@JoinColumn(name="coordinatorId")
	public Coordinator getCoordinator() {
		return coordinator;
	}
	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}

	public void addModule(Modules m)
	{
		modules.add(m);
		List<Course> list = m.getCourse();
		list.add(this);
		m.setCourse(list);
	}	
	public void removeCourse(Modules m)
	{
		modules.remove(m);
		List<Course> list = m.getCourse();
		list.remove(this);
		m.setCourse(list);
	}
	public void addStudent(Student s)
	{
		students.add(s);
		List<Course> list = s.getCourse();
		list.add(this);
		s.setCourse(list);
	}
	public void removeStudent(Student s)
	{
		students.remove(s);
		List<Course> list = s.getCourse();
		list.remove(this);
		s.setCourse(list);
	}
	public void addFaculty(Faculty c)
	{
		faculty.add(c);
		c.setCourse(this);
	}
	
	public void removeCourse(Faculty c)
	{
		faculty.remove(c);
		c.setCourse(null);
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration
				+ ", courseStrength=" + courseStrength + "]";
	}
	
}

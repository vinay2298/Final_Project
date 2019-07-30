package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="modules")
public class Modules {

	private Integer moduleId;
	private String moduleName;
	private String startDate;
	private String endDate;
	private String status;
	private List<Course> course = new ArrayList<>();
	private Faculty faculty;
	private List<Topic> topics = new ArrayList<>();
	/*
	 * private List<Topic> topic = new ArrayList<>(); private Faculty faculty;
	 */public Modules() {
		System.out.println("In Module Constructor");
	}
	public Modules(Integer moduleId, String moduleName, String startDate, String endDate, String status) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name="Course_Modules",joinColumns=
	{@JoinColumn(referencedColumnName="moduleId")},
	inverseJoinColumns={@JoinColumn(referencedColumnName="courseId")})
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	@ManyToOne
	@JoinColumn(name="facultyId")
	public Faculty getFaculty() {
		return faculty;
	}
	
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	@OneToMany(targetEntity=Topic.class,mappedBy="module",fetch = FetchType.EAGER)
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	public void addCourse(Course c)
	{
		course.add(c);
		List<Modules> list = c.getModules();
		list.add(this);
		c.setModules(list);
	}
	public void removeCourse(Course c)
	{
		course.remove(c);
		List<Modules> list = c.getModules();
		list.remove(this);
		c.setModules(list);
	}
	public void addTopic(Topic c)
	{
		topics.add(c);
		c.setModule(this);
	}
	
	public void removeTopic(Topic c)
	{
		topics.remove(c);
		c.setModule(null);
	}

	@Override
	public String toString() {
		return "Modules [moduleId=" + moduleId + ", moduleName=" + moduleName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", status=" + status + "]";
	}	
}

package pojos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_modules")
public class Course_Modules {

	private Integer id;
	private String startDate;
	private String endDate;
	private String status;
	public Course_Modules() {
		System.out.println("In Course_Module Constructor");
	}
	public Course_Modules(String startDate, String endDate, String status) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id=id;
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
	
	@Override
	public String toString() {
		return "Course_Modules [startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}
}

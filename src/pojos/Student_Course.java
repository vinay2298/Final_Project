package pojos;

import javax.persistence.*;

@Entity
@Table(name="student_course")
public class Student_Course {

	private Integer id;
	private String startDate;
	private String endDate;
	private String status;
	public Student_Course() {
		System.out.println("In Student_Course Constructor");
	}
	public Student_Course(Integer id,String startDate, String endDate, String status) {
		super();
		this.id=id;
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
		return "Student_Course [startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}
	
}

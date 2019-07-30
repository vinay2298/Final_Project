package pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="content")
public class Content {

	private int contentId;
	private String contentName;
	private String contentPath;
	private Topic topic;
	public Content() {
		System.out.println("In Content Constructor");
	}
	public Content(int contentId, String contentName, String contentPath) {
		super();
		this.contentId = contentId;
		this.contentName = contentName;
		this.contentPath = contentPath;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getContentName() {
		return contentName;
	}
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	public String getContentPath() {
		return contentPath;
	}
	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}
	@ManyToOne
	@JoinColumn(name="topicId")
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}

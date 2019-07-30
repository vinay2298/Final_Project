package pojos;

import java.util.List;

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
@Table(name="topic")
public class Topic {

	private Integer topicId;
	private String topicName;
	private String path;
	private Modules module;
	private List<Content> content;
	
	public Topic() {
		System.out.println("In Topic Constructor");
	}
	public Topic(Integer topicId, String topicName,String path) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.path = path;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@ManyToOne
	@JoinColumn(name="moduleId")
	public Modules getModule() {
		return module;
	}
	public void setModule(Modules module) {
		this.module = module;
	}
	public void addContent(Content c)
	{
		content.add(c);
		c.setTopic(this);
	}
	
	public void removeContent(Content c)
	{
		content.remove(c);
		c.setTopic(null);
	}
	@OneToMany(targetEntity=Topic.class,mappedBy="module",fetch = FetchType.EAGER)
	public List<Content> getContent() {
		return content;
	}
	public void setContent(List<Content> content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicName=" + topicName + "]";
	}
	
}

package forum.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "article")
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	public Article() {}
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "article",cascade = CascadeType.ALL)
	private List<Message> message=new ArrayList<Message>();
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "article",cascade = CascadeType.ALL)
	private List<Img> img=new ArrayList<Img>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "articleId")
	private Integer articleId;

	@Column(name="memberId_fk")
	private String authorId;
	
	@Column(name = "updateTime")
	private Timestamp updateTime;

	@Column(name = "topicName")
	private String topicName;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "[like]")
	private Integer like;

	@Column(name = "dislike")
	private Integer dislike;

	@Column(name = "[status]")
	private String status;
	
	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	public List<Img> getImg() {
		return img;
	}

	public void setImg(List<Img> img) {
		this.img = img;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLike() {
		return like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	public Integer getDislike() {
		return dislike;
	}

	public void setDislike(Integer dislike) {
		this.dislike = dislike;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}

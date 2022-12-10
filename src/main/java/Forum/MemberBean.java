package Forum;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer articleId;
	Integer authorId;
	Timestamp postTime;
	String topicName;
	String title;
	String content;
	String imgName;
	Blob img;

	public MemberBean(Integer articleId,Integer authorId,Timestamp postTime,String topicName,String title,String content,String imgName,Blob img) {		
		this.articleId = articleId;
		this.authorId = authorId;
		this.postTime = postTime;
		this.topicName = topicName;
		this.title = title;
		this.content = content;
		this.imgName = imgName;
		this.img = img;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public String getImgName() {
		return imgName;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public Timestamp getPostTime() {
		return postTime;
	}

	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
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

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

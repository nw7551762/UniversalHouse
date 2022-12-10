package Message;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;

public class MessageBean implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer articleId;
	Integer messageId;
	Integer authorId;
	Timestamp postTime;
	String content;


	public MessageBean(Integer articleId, Integer messageId, Integer authorId, Timestamp postTime, String content) {
		this.articleId = articleId;
		this.messageId = messageId;
		this.authorId = authorId;
		this.postTime = postTime;
		this.content = content;
	}


	public Integer getArticleId() {
		return articleId;
	}


	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}


	public Integer getMessageId() {
		return messageId;
	}


	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}


	public Integer getAuthorId() {
		return authorId;
	}


	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}


	public Timestamp getPostTime() {
		return postTime;
	}


	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
}

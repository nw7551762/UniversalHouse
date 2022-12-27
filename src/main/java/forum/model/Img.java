package forum.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import forum.model.Article;


@Entity
@Table(name = "img")
public class Img implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "articleId_fk")
	private Article article;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imgNo")
	private Integer imgNo;
	
	@Column(name = "imgName")
	private String imgName;

	@Column(name = "img")
	private Blob img;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getImgNo() {
		return imgNo;
	}

	public void setImgNo(Integer imgNo) {
		this.imgNo = imgNo;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
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

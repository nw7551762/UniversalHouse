package model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

public class galleryBean {
	private String imageNumber;
	private Blob testImg;
	
	public galleryBean() {
		this.imageNumber = "";
		Blob blob = null;
		this.testImg = blob;
	}
	
	public Blob partToBlob(Part part) throws IOException, SerialException, SQLException{
		//partImage轉inputstream
		InputStream is = part.getInputStream();
		long len = part.getSize();
		
		byte[] b = new byte[(int) len];
		//is資料寫入byte矩陣
		is.read(b);
		Blob blob = null;
		//SerialBlob建構子 new一個Blob物件
		blob = new SerialBlob(b);
		
		return blob;
		
	}


	public galleryBean(String imageNumber, Blob testImg) {
		super();
		this.imageNumber = imageNumber;
		this.testImg = testImg;
	}


	public String getImageNumber() {
		return imageNumber;
	}

	public void setImageNumber(String imageNumber) {
		this.imageNumber = imageNumber;
	}

	public Blob getTestImg() {
		return testImg;
	}

	public void setTestImg(Blob testImg) {
		this.testImg = testImg;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("galleryBean [imageNumber=");
		builder.append(imageNumber);
		builder.append(", testImg=");
		builder.append(testImg);
		builder.append("]");
		return builder.toString();
	}
}

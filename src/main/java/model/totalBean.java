package model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.sql.Blob;

public class totalBean {

	private String memberId;
	private String inputRadio;
	private String inputRadio2;
	private String fraction;
	private Blob testImg;
	public totalBean() {
		this.memberId = "";
		this.inputRadio = "";
		this.inputRadio2 = "";
		this.fraction = "";
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
	
	public totalBean(String memberId, String inputRadio, String inputRadio2, String fraction, Blob testImg) {
		super();
		this.memberId = memberId;
		this.inputRadio = inputRadio;
		this.inputRadio2 = inputRadio2;
		this.fraction = fraction;
		this.testImg = testImg;
	}

	public String getMemberId() {
		return memberId;
	}
	public Blob getTestImg() {
		return testImg;
	}

	public void setTestImg(Blob testImg) {
		this.testImg = testImg;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getInputRadio() {
		return inputRadio;
	}
	public void setInputRadio(String inputRadio) {
		this.inputRadio = inputRadio;
	}
	public String getInputRadio2() {
		return inputRadio2;
	}
	public void setInputRadio2(String inputRadio2) {
		this.inputRadio2 = inputRadio2;
	}
	public String getFraction() {
		return fraction;
	}
	public void setFraction(String fraction) {
		this.fraction = fraction;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("totalBean [memberId=");
		builder.append(memberId);
		builder.append(", inputRadio=");
		builder.append(inputRadio);
		builder.append(", inputRadio2=");
		builder.append(inputRadio2);
		builder.append(", fraction=");
		builder.append(fraction);
		builder.append(", testImg=");
		builder.append(testImg);
		builder.append("]");
		return builder.toString();
	}
	
	
}

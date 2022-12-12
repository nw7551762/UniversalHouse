package model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

public class TestBean {
	private Integer testPK;
	private String testId;
	private String examinationQuestion;
	private String answer;
	private String questionBank;
	private String field;
	private String options;
	private String options2;
	private String options3;
	private String options4;
	private String fraction;
	private Blob testImage;
	
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
	public TestBean() {
		this.testId = "";
		this.examinationQuestion = "";
		this.answer = "";
		this.questionBank = "";
		this.field = "";
		this.options = "";
		this.options2 = "";
		this.options3 = "";
		this.options4 = "";
		this.fraction = "";
		Blob blob = null;
		this.testImage = blob;
	}
	public TestBean(Integer testPK, String testId, String examinationQuestion, String answer, String questionBank,
			String field, String options, String options2, String options3, String options4, String fraction,
			Blob testImage) {
		super();
		this.testPK = testPK;
		this.testId = testId;
		this.examinationQuestion = examinationQuestion;
		this.answer = answer;
		this.questionBank = questionBank;
		this.field = field;
		this.options = options;
		this.options2 = options2;
		this.options3 = options3;
		this.options4 = options4;
		this.fraction = fraction;
		this.testImage = testImage;
	}

	
	public Blob getTestImage() {
		return testImage;
	}

	public void setTestImage(Blob testImage) {
		this.testImage = testImage;
	}

	public Integer getTestPK() {
		return testPK;
	}
	public void setTestPK(Integer testPK) {
		this.testPK = testPK;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getExaminationQuestion() {
		return examinationQuestion;
	}
	public void setExaminationQuestion(String examinationQuestion) {
		this.examinationQuestion = examinationQuestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestionBank() {
		return questionBank;
	}
	public void setQuestionBank(String questionBank) {
		this.questionBank = questionBank;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getOptions2() {
		return options2;
	}
	public void setOptions2(String options2) {
		this.options2 = options2;
	}
	public String getOptions3() {
		return options3;
	}
	public void setOptions3(String options3) {
		this.options3 = options3;
	}
	public String getOptions4() {
		return options4;
	}
	public void setOptions4(String options4) {
		this.options4 = options4;
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
		builder.append("TestBean [testPK=");
		builder.append(testPK);
		builder.append(", testId=");
		builder.append(testId);
		builder.append(", examinationQuestion=");
		builder.append(examinationQuestion);
		builder.append(", answer=");
		builder.append(answer);
		builder.append(", questionBank=");
		builder.append(questionBank);
		builder.append(", field=");
		builder.append(field);
		builder.append(", options=");
		builder.append(options);
		builder.append(", options2=");
		builder.append(options2);
		builder.append(", options3=");
		builder.append(options3);
		builder.append(", options4=");
		builder.append(options4);
		builder.append(", fraction=");
		builder.append(fraction);
		builder.append(", testImage=");
		builder.append(testImage);
		builder.append("]");
		return builder.toString();
	}


}

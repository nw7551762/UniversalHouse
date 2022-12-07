package model;



public class TestBean  {
	
	
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
	}
	
	public TestBean(Integer testPK, String testId, String examinationQuestion, String answer, String questionBank,
			String field, String options, String options2, String options3, String options4, String fraction) {
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
		builder.append("MemberBean [testPK=");
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
		builder.append("]");
		return builder.toString();
	}




}

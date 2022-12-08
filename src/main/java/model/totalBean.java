package model;

public class totalBean {

	private String memberId;
	private String inputRadio;
	private String inputRadio2;
	private String fraction;
	
	public totalBean() {
		this.memberId = "";
		this.inputRadio = "";
		this.inputRadio2 = "";
		this.fraction = "";
	}
	
	public totalBean(String memberId, String inputRadio, String inputRadio2, String fraction) {
		super();
		this.memberId = memberId;
		this.inputRadio = inputRadio;
		this.inputRadio2 = inputRadio2;
		this.fraction = fraction;
	}
	public String getMemberId() {
		return memberId;
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
		builder.append("]");
		return builder.toString();
	}
	
	
}

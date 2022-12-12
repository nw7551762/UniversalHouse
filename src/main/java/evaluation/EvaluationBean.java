package evaluation;

import java.sql.Timestamp;
import java.util.Date;

public class EvaluationBean {
	
	private int evID;
	private int pjID;
	private String memberID;
	private String pjMemberID;
	private int evDealPrice;
	private Date evCompletionDate;
	private int evClientEV;
	private String evClientComment;
	
	public EvaluationBean() {
	}

	public EvaluationBean(int evID, int pjID, String memberID, String pjMemberID, int evDealPrice, Date evCompletionDate, int evClientEV,
			String evClientComment) {
		super();
		this.evID = evID;
		this.pjID = pjID;
		this.memberID = memberID;
		this.pjMemberID = pjMemberID;
		this.evDealPrice = evDealPrice;
		this.evClientEV = evClientEV;
		this.evClientComment = evClientComment;
	}

	public int getEvID() {
		return evID;
	}

	public void setEvID(int evID) {
		this.evID = evID;
	}

	public int getPjID() {
		return pjID;
	}

	public void setPjID(int pjID) {
		this.pjID = pjID;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
	public String getPjMemberID() {
		return pjMemberID;
	}

	public void setPjMemberID(String pjMemberID) {
		this.pjMemberID = pjMemberID;
	}

	public int getEvDealPrice() {
		return evDealPrice;
	}

	public void setEvDealPrice(int evDealPrice) {
		this.evDealPrice = evDealPrice;
	}

	public Date getEvCompletionDate() {
		return evCompletionDate;
	}

	public void setEvCompletionDate(Date evCompletionDate) {
		Timestamp ts = new Timestamp(evCompletionDate.getTime());
		this.evCompletionDate = ts;
	}

	public int getEvClientEV() {
		return evClientEV;
	}

	public void setEvClientEV(int evClientEV) {
		this.evClientEV = evClientEV;
	}

	public String getEvClientComment() {
		return evClientComment;
	}

	public void setEvClientComment(String evClientComment) {
		this.evClientComment = evClientComment;
	}

	@Override
	public String toString() {
		return "EvaluationBean [evID=" + evID + "pjID=" + pjID + ", memberID=" + memberID + ", pjMemberID=" + pjMemberID + ", evDealPrice=" + evDealPrice
				+ ", evCompletionDate=" + evCompletionDate + ", evClientEV=" + evClientEV + ", evClientComment="
				+ evClientComment + "]";
	}
}

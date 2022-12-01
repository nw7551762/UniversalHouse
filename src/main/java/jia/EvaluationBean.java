package jia;

import java.sql.Date;

public class EvaluationBean {
	
	private int pjID;
	private int memberID;
	private int evDealPrice;
	private Date evCompletionDate;
	private int evClientEV;
	private String evClientComment;
	
	public EvaluationBean() {
	}

	public EvaluationBean(int pjID, int memberID, int evDealPrice, Date evCompletionDate, int evClientEV,
			String evClientComment) {
		super();
		this.pjID = pjID;
		this.memberID = memberID;
		this.evDealPrice = evDealPrice;
		this.evCompletionDate = evCompletionDate;
		this.evClientEV = evClientEV;
		this.evClientComment = evClientComment;
	}

	public int getPjID() {
		return pjID;
	}

	public void setPjID(int pjID) {
		this.pjID = pjID;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
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
		this.evCompletionDate = evCompletionDate;
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
		return "EvaluationBean [pjID=" + pjID + ", memberID=" + memberID + ", evDealPrice=" + evDealPrice
				+ ", evCompletionDate=" + evCompletionDate + ", evClientEV=" + evClientEV + ", evClientComment="
				+ evClientComment + "]";
	}
}

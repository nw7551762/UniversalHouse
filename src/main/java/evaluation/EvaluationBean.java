package evaluation;

import java.sql.Date;

public class EvaluationBean {
	
	private int pjID;
	private int memberPk;
	private int evDealPrice;
	private Date evCompletionDate;
	private int evClientEV;
	private String evClientComment;
	
	public EvaluationBean() {
	}

	public EvaluationBean(int pjID, int memberPk, int evDealPrice, Date evCompletionDate, int evClientEV,
			String evClientComment) {
		super();
		this.pjID = pjID;
		this.memberPk = memberPk;
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

	public int getMemberPk() {
		return memberPk;
	}

	public void setMemberPk(int memberPk) {
		this.memberPk = memberPk;
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
		return "EvaluationBean [pjID=" + pjID + ", memberPk=" + memberPk + ", evDealPrice=" + evDealPrice
				+ ", evCompletionDate=" + evCompletionDate + ", evClientEV=" + evClientEV + ", evClientComment="
				+ evClientComment + "]";
	}
}

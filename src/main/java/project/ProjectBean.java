package project;

import java.sql.Date;

public class ProjectBean {
	
	private int pjID;
	private String pjClass;
	private String fieldName;
	private String pjName;
	private int memberPK;
	private String pjInstruction;
	private String pjServerLocation;
	private int pjPrice;
	private Date pjExCompletionDate;
	private Date pjUploadDate;
	private Date pjLastUpdate;
	private String pjStatus;
	
	public ProjectBean() {
	}

	public ProjectBean(int pjID, String pjClass, String fieldName, String pjName, int memberPK, String pjInstruction,
			String pjServerLocation, int pjPrice, Date pjExCompletionDate, Date pjUploadDate, Date pjLastUpdate,
			String pjStatus) {
		super();
		this.pjID = pjID;
		this.pjClass = pjClass;
		this.fieldName = fieldName;
		this.pjName = pjName;
		this.memberPK = memberPK;
		this.pjInstruction = pjInstruction;
		this.pjServerLocation = pjServerLocation;
		this.pjPrice = pjPrice;
		this.pjExCompletionDate = pjExCompletionDate;
		this.pjUploadDate = pjUploadDate;
		this.pjLastUpdate = pjLastUpdate;
		this.pjStatus = pjStatus;
	}



	public int getPjID() {
		return pjID;
	}
	
	public int setPjID(Integer PjID) {
		return pjID;
	}

	public String getPjClass() {
		return pjClass;
	}

	public void setPjClass(String pjClass) {
		this.pjClass = pjClass;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getPjName() {
		return pjName;
	}

	public void setPjName(String pjName) {
		this.pjName = pjName;
	}

	public int getMemberPK() {
		return memberPK;
	}

	public void setMemberPK(int memberPK) {
		this.memberPK = memberPK;
	}

	public String getPjInstruction() {
		return pjInstruction;
	}

	public void setPjInstruction(String pjInstruction) {
		this.pjInstruction = pjInstruction;
	}

	public String getPjServerLocation() {
		return pjServerLocation;
	}

	public void setPjServerLocation(String pjServerLocation) {
		this.pjServerLocation = pjServerLocation;
	}

	public int getPjPrice() {
		return pjPrice;
	}

	public void setPjPrice(int pjPrice) {
		this.pjPrice = pjPrice;
	}

	public Date getPjExCompletionDate() {
		return pjExCompletionDate;
	}

	public void setPjExCompletionDate(Date pjExCompletionDate) {
		this.pjExCompletionDate = pjExCompletionDate;
	}

	public Date getPjUploadDate() {
		return pjUploadDate;
	}

	public void setPjUploadDate(Date pjUploadDate) {
		this.pjUploadDate = pjUploadDate;
	}

	public Date getPjLastUpdate() {
		return pjLastUpdate;
	}

	public void setPjLastUpdate(Date pjLastUpdate) {
		this.pjLastUpdate = pjLastUpdate;
	}

	public String getPjStatus() {
		return pjStatus;
	}

	public void setPjStatus(String pjStatus) {
		this.pjStatus = pjStatus;
	}

	@Override
	public String toString() {
		return "ProjectBean [pjID=" + pjID + ", pjClass=" + pjClass + ", fieldName=" + fieldName + ", pjName=" + pjName
				+ ", memberPK=" + memberPK + ", pjInstruction=" + pjInstruction + ", pjServerLocation="
				+ pjServerLocation + ", pjPrice=" + pjPrice + ", pjExCompletionDate=" + pjExCompletionDate
				+ ", pjUploadDate=" + pjUploadDate + ", pjLastUpdate=" + pjLastUpdate + ", pjStatus=" + pjStatus + "]";
	}
}

package project;

import java.sql.Timestamp;
import java.util.Date;

public class ProjectBean {

	private int pjID;
	private String pjClass;
	private String fieldName;
	private String pjName;
	private String memberID;
	private String pjInstruction;
	private String pjServerLocation;
	private int pjPrice;
	private Date pjExCompletionDate;
	private String pjExecutionTime;
	private Date pjUploadDate;
	private Date pjLastUpdate;
	private String pjStatus;

	public ProjectBean() {
	}

	public ProjectBean(int pjID, String pjClass, String fieldName, String pjName, String memberID, String pjInstruction,
			String pjServerLocation, int pjPrice, Date pjExCompletionDate, String pjExecutionTime, Date pjUploadDate,
			Date pjLastUpdate, String pjStatus) {
		super();
		this.pjID = pjID;
		this.pjClass = pjClass;
		this.fieldName = fieldName;
		this.pjName = pjName;
		this.memberID = memberID;
		this.pjInstruction = pjInstruction;
		this.pjServerLocation = pjServerLocation;
		this.pjPrice = pjPrice;
		this.pjExCompletionDate = pjExCompletionDate;
		this.pjExecutionTime = pjExecutionTime;
		this.pjUploadDate = pjUploadDate;
		this.pjLastUpdate = pjLastUpdate;
		this.pjStatus = pjStatus;
	}

	public int getPjID() {
		return pjID;
	}

	public void setPjID(Integer pjID) {
		this.pjID = pjID;
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

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
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
		Timestamp ts = new Timestamp(pjExCompletionDate.getTime());
		this.pjExCompletionDate = ts;
	}

	public String getPjExecutionTime() {
		return pjExecutionTime;
	}

	public void setPjExecutionTime(String pjExecutionTime) {
		this.pjExecutionTime = pjExecutionTime;
	}

	public Date getPjUploadDate() {
		return pjUploadDate;
	}

	public void setPjUploadDate(Date pjUploadDate) {
		Timestamp ts = new Timestamp(pjUploadDate.getTime());
		this.pjUploadDate = ts;
	}

	public Date getPjLastUpdate() {
		return pjLastUpdate;
	}

	public void setPjLastUpdate(Date pjLastUpdate) {
		Timestamp ts = new Timestamp(pjLastUpdate.getTime());
		this.pjLastUpdate = ts;
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
				+ ", memberID=" + memberID + ", pjInstruction=" + pjInstruction + ", pjServerLocation="
				+ pjServerLocation + ", pjPrice=" + pjPrice + ", pjExCompletionDate=" + pjExCompletionDate
				+ ", pjExecutionTime=" + pjExecutionTime + ", pjUploadDate=" + pjUploadDate + ", pjLastUpdate="
				+ pjLastUpdate + ", pjStatus=" + pjStatus + "]";
	}
}

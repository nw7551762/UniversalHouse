package spaceRental;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

public class spaceRentalBEAN {
	private int spaceNo;
	private String spaceName;
	private String city;
	private String address;
	private int accommodate;
	private String spaceType;
	private int price;
	private String unit;
	private String period1;
	private String period2;
	private String facility_1;
	private String facility_2;
	private String facility_3;
	private String facility_4;
	private String facility_5;
	private String intro;
	private Blob pic;
	private String comm;

	public Blob partToBlob(Part part) throws IOException, SerialException, SQLException {
		//partImage轉inputstream
		InputStream is = part.getInputStream();
		long len = part.getSize();
		
		byte[] b = new byte[(int) len];
		is.read(b);
		Blob blob = null;
		//SerialBlob建構子 new一個Blob物件
		blob = new SerialBlob(b);
		
		return blob;
		
	}
	
//	設定預設值
	public spaceRentalBEAN() {
		this.spaceName = "";
		this.city = "";
		this.address = "";
		this.accommodate = 0;
		this.spaceType = "";
		this.price = 0;
		this.unit = "";
		this.period1 = "";
		this.period2 = "";
		this.facility_1 = "";
		this.facility_2 = "";
		this.facility_3 = "";
		this.facility_4 = "";
		this.facility_5 = "";
		this.intro = "";
		this.pic = null;
		this.comm = "";
	}
	
	public spaceRentalBEAN(int spaceNo, String spaceName, String city, String address, int accommodate,
			String spaceType, int price, String unit, String period1, String period2, String facility_1,
			String facility_2, String facility_3, String facility_4, String facility_5, String intro, Blob pic,
			String comm) {
		super();
		this.spaceNo = spaceNo;
		this.spaceName = spaceName;
		this.city = city;
		this.address = address;
		this.accommodate = accommodate;
		this.spaceType = spaceType;
		this.price = price;
		this.unit = unit;
		this.period1 = period1;
		this.period2 = period2;
		this.facility_1 = facility_1;
		this.facility_2 = facility_2;
		this.facility_3 = facility_3;
		this.facility_4 = facility_4;
		this.facility_5 = facility_5;
		this.intro = intro;
		this.pic = pic;
		this.comm = comm;
	}

	public int getSpaceNo() {
		return spaceNo;
	}

	public void setSpaceNo(int spaceNo) {
		this.spaceNo = spaceNo;
	}

	public String getSpaceName() {
		return spaceName;
	}

	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAccommodate() {
		return accommodate;
	}

	public void setAccommodate(int accommodate) {
		this.accommodate = accommodate;
	}

	public String getSpaceType() {
		return spaceType;
	}

	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPeriod1() {
		return period1;
	}

	public void setPeriod1(String period1) {
		this.period1 = period1;
	}

	public String getPeriod2() {
		return period2;
	}

	public void setPeriod2(String period2) {
		this.period2 = period2;
	}

	public String getFacility_1() {
		return facility_1;
	}

	public void setFacility_1(String facility_1) {
		this.facility_1 = facility_1;
	}

	public String getFacility_2() {
		return facility_2;
	}

	public void setFacility_2(String facility_2) {
		this.facility_2 = facility_2;
	}

	public String getFacility_3() {
		return facility_3;
	}

	public void setFacility_3(String facility_3) {
		this.facility_3 = facility_3;
	}

	public String getFacility_4() {
		return facility_4;
	}

	public void setFacility_4(String facility_4) {
		this.facility_4 = facility_4;
	}

	public String getFacility_5() {
		return facility_5;
	}

	public void setFacility_5(String facility_5) {
		this.facility_5 = facility_5;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Blob getPic() {
		return pic;
	}

	public void setPic(Blob pic) {
		this.pic = pic;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}


	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("spaceRentalBEAN [spaceNo=");
		builder.append(spaceNo);
		builder.append(", spaceName=");
		builder.append(spaceName);
		builder.append(", city=");
		builder.append(city);
		builder.append(", address=");
		builder.append(address);
		builder.append(", accommodate=");
		builder.append(accommodate);
		builder.append(", spaceType=");
		builder.append(spaceType);
		builder.append(", price=");
		builder.append(price);
		builder.append(", unit=");
		builder.append(unit);
		builder.append(", period1=");
		builder.append(period1);
		builder.append(", period2=");
		builder.append(period2);
		builder.append(", facility_1=");
		builder.append(facility_1);
		builder.append(", facility_2=");
		builder.append(facility_2);
		builder.append(", facility_3=");
		builder.append(facility_3);
		builder.append(", facility_4=");
		builder.append(facility_4);
		builder.append(", facility_5=");
		builder.append(facility_5);
		builder.append(", intro=");
		builder.append(intro);
		builder.append(", pic=");
		builder.append(pic);
		builder.append(", comm=");
		builder.append(comm);
		builder.append("]");
		return builder.toString();
	}
	
	
}

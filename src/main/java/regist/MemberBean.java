package regist;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;


public class MemberBean {
	private Integer memberPK;
	private String memberId;
	private String name;
	private String password;
	private String location;
	private String email;
	private String phone;
	private Timestamp registerTime;
	private Blob memberImage;
	private Timestamp lastLogin;
	private int verification;
	private int permission;
	
	public Blob partToBlob(Part part ) throws IOException, SerialException, SQLException {
		//partImage轉inputstream
		InputStream is =  part.getInputStream();
		long len = part.getSize();
		
		byte[] b = new byte[(int) len];
		//is資料寫入byte矩陣
		is.read(b);
		Blob blob = null;
		//SerialBlob建構子 new一個Blob物件
		blob = new SerialBlob(b);
		is.close();
		
		return blob;
	}
	
	
	
	public MemberBean() {
		this.memberId = "";
		this.name = "";
		this.password = "";
		this.location = "";
		this.email = "";
		this.phone = "";
		Blob blob =null;
		this.memberImage = blob;
		Timestamp time = null;
		this.registerTime = time;
		this.lastLogin = time;
		this.verification = 0;
		this.permission = 0;
	}
	
	public MemberBean(String memberId, String name, String password, String location, String email, String phone,
			 Timestamp registerdate, Blob memberImage, Timestamp registerTime, Timestamp lastLogin, int verification , int permission  ) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.password = password;
		this.location = location;
		this.email = email;
		this.phone = phone;
		this.memberImage = memberImage;
		this.registerTime = registerTime;
		this.lastLogin = lastLogin;
		this.verification = verification;
		this.permission = permission;
	}
	
	
	public Integer getMemberPK() {
		return memberPK;
	}
	public void setMemberPK(Integer memberPK) {
		this.memberPK = memberPK;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Blob getMemberImage() {
		return memberImage;
	}
	public void setMemberImage(Blob memberImage) {
		this.memberImage = memberImage;
	}
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime( Date date) {
		Timestamp ts = new Timestamp( date.getTime() ); 
		this.registerTime = ts;
	}
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	public void setVerification(int verification) {
		this.verification = verification;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public int getVerification() {
		return verification;
	}
	public int getPermission() {
		return permission;
	}
	
	
	
	@Override
	public String toString() {
		return "MemberBean [memberPK=" + memberPK + ", memberId=" + memberId + ", name=" + name + ", password=" + password
				+ ", location=" + location + ", email=" + email + ", phone=" + phone 
				+ ", memberImage=" + memberImage + ", registerTime=" + registerTime
				+ ", lastLogin=" + lastLogin +  ", verification="  + verification +  ", permission="  + permission + "]";
	}

	






}

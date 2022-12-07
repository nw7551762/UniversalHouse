package regist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class MemberDao {
	DataSource ds = null;
	private static Logger log = LoggerFactory.getLogger(MemberDao.class);
	
	public MemberDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	
	
	public void modify(MemberBean mb) {
		String sql = "UPDATE Member " 
				+ "SET name= ? , 	"
				+ "password= ? , "
				+ "location= ? , "
				+ "email= ? , "
				+ " phone = ? , "
				+ "registerTime= ? , "
				+ "memberImage= ? , "
				+ "lastLogin= ? ";
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, mb.getName());
			ps.setString(2, mb.getPassword());
			ps.setString(3, mb.getLocation());
			ps.setString(4, mb.getEmail());
			ps.setString(5, mb.getPhone());
			ps.setTimestamp(6, mb.getRegisterTime());
			ps.setBlob(7, mb.getMemberImage());
			ps.setTimestamp(8, mb.getLastLogin());
			ps.executeUpdate();
			log.info("modify(), 修改成功：MemberBean=" + mb);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Class: MemberDaoc#modify()發生例外: " 
										+ ex.getMessage());
		}
		
	}
	
//	private static final String SELECT_BY_ID = "SELECT * FROM member";

	public void save(MemberBean mb) {
		log.info("會員註冊功能之Dao: 儲存會員資料");
 		String sql = "insert into Member " 
				+ " (memberId, name, password, location, email, "
				+ " phone, registerTime, memberImage, lastLogin) "
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, mb.getMemberId());
			ps.setString(2, mb.getName());
			ps.setString(3, mb.getPassword());
			ps.setString(4, mb.getLocation());
			ps.setString(5, mb.getEmail());
			ps.setString(6, mb.getPhone());
			ps.setTimestamp(7, mb.getRegisterTime());
			ps.setBlob(8, mb.getMemberImage());
			ps.setTimestamp(9, mb.getLastLogin());
			ps.executeUpdate();
			log.info("saveMember(), 新增成功：MemberBean=" + mb);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Class: MemberDaoc#save()發生例外: " 
										+ ex.getMessage());
		}
	}
	
	public void deleteMember( String memberId ) throws SQLException {
		String sql = "delete from member where memberId  = ?";
		
		try (
				Connection con = ds.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql);
			) {
				ps.setString(1, memberId);
				ps.executeLargeUpdate();
				
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Class: MemberDaoc#deleteMember()發生例外: " 
											+ ex.getMessage());
			}
	}
	
	
	
	// 判斷參數id(會員帳號)是否已經被現有客戶使用，如果是，傳回true，表示此id不能使用，
		// 否則傳回false，表示此id可使用。
	public boolean existsById(String id) {
//			log.info("會員註冊功能之Dao: 檢查會員輸入的編號是否已被使用");
			boolean exist = false;
			String sql = "SELECT * FROM Member WHERE memberId = ?";
			try (
				Connection connection = ds.getConnection(); 
				PreparedStatement ps = connection.prepareStatement(sql);
			) {
				ps.setString(1, id);
				try (ResultSet rs = ps.executeQuery();) {
					if (rs.next()) {
						exist = true;
					}
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				throw new RuntimeException("MemberDaoImpl_Jdbc類別#idExists()發生例外: " 
						+ ex.getMessage());
			}
			log.info("會員註冊功能之 Dao: 檢查會員輸入的編號是否已被使用, exist=" + exist);
			return exist;
		}
	
	
		// 由參數 id (會員帳號) 到Member表格中 取得某個會員的所有資料，傳回值為一個MemberBean物件，
		// 如果找不到對應的會員資料，傳回值為null。
	public MemberBean findByMemberPK(int pk) {
//			log.info("會員登入功能之Dao: 檢查帳號/密碼"); 
			MemberBean mb = new MemberBean();
			String sql = "SELECT * FROM Member WHERE memberPK = ?";
			try (
				Connection connection = ds.getConnection(); 
				PreparedStatement ps = connection.prepareStatement(sql);
			) {
				ps.setInt(1, pk);
				try (ResultSet rs = ps.executeQuery();) {
					if (rs.next()) {
						mb = new MemberBean();
						mb.setMemberPK(rs.getInt("memberPK"));
						mb.setMemberId(rs.getString("memberId"));
						mb.setName(rs.getString("name"));
						mb.setPassword(rs.getString("password"));
						mb.setLocation(rs.getString("location"));
						mb.setEmail(rs.getString("email"));
						mb.setPhone(rs.getString("phone"));
						if(rs.getTimestamp("registerTime")!=null) {
							mb.setRegisterTime(rs.getTimestamp("registerTime"));
						}
						mb.setLastLogin(rs.getTimestamp("lastLogin"));
						mb.setMemberImage(rs.getBlob("MemberImage"));
					}
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				throw new RuntimeException("MemberDaoImpl_Jdbc類別#queryMember()發生例外: " 
						+ ex.getMessage());
			}
			log.info("會員登入功能之Dao: 取得某個會員的資料, mb=" + mb);
			return mb;
		}
	
	public MemberBean findByMemberId(String memberId) {
		MemberBean mb = null;
		String sql = "SELECT * FROM Member m WHERE m.memberId = ?";
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, memberId);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					mb = new MemberBean();
					mb.setMemberPK(rs.getInt("memberPK"));
					mb.setMemberId(rs.getString("memberId"));
					mb.setName(rs.getString("name"));
					mb.setPassword(rs.getString("password"));
					mb.setLocation(rs.getString("location"));
					mb.setEmail(rs.getString("email"));
					mb.setPhone(rs.getString("phone"));
					mb.setRegisterTime(rs.getTimestamp("registerTime"));
					
					mb.setLastLogin(rs.getTimestamp("lastLogin"));
					mb.setMemberImage(rs.getBlob("MemberImage"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#findByMemberIdAndPassword()發生SQL例外: " 
					+ ex.getMessage());
		}
		return mb;
	}
	
	public MemberBean findByMemberIdAndPassword(String memberId, String password) {
		MemberBean mb = null;
		String sql = "SELECT * FROM Member m WHERE m.memberId = ? and m.password = ?";
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, memberId);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					mb = new MemberBean();
					mb.setMemberPK(rs.getInt("memberPK"));
					mb.setMemberId(rs.getString("memberId"));
					mb.setName(rs.getString("name"));
					mb.setPassword(rs.getString("password"));
					mb.setLocation(rs.getString("location"));
					mb.setEmail(rs.getString("email"));
					mb.setPhone(rs.getString("phone"));
					mb.setRegisterTime(rs.getTimestamp("registerTime"));
					
					mb.setLastLogin(rs.getTimestamp("lastLogin"));
					mb.setMemberImage(rs.getBlob("MemberImage"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#findByMemberIdAndPassword()發生SQL例外: " 
					+ ex.getMessage());
		}
		log.info("會員登入功能之Dao: 檢查帳號/密碼結果:" 
				+ (mb == null ? "帳號/密碼正確" : "帳號/密碼錯誤"));
		return mb;
	}
	
	public List<MemberBean> findAllMember() {
//		log.info("會員登入功能之Dao: 檢查帳號/密碼"); 
		List<MemberBean> members = new ArrayList<MemberBean>();
		String sql = "SELECT * FROM Member";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			
			
			try (ResultSet rs = ps.executeQuery();) {
				while( rs.next() ) {
					MemberBean mb = new MemberBean();
					mb = new MemberBean();
					mb.setMemberPK(rs.getInt("memberPK"));
					mb.setMemberId(rs.getString("memberId"));
					mb.setName(rs.getString("name"));
					mb.setPassword(rs.getString("password"));
					mb.setLocation(rs.getString("location"));
					mb.setEmail(rs.getString("email"));
					mb.setPhone(rs.getString("phone"));
					if(rs.getTimestamp("registerTime")!=null) {
						mb.setRegisterTime(rs.getTimestamp("registerTime"));
					}
					mb.setLastLogin(rs.getTimestamp("lastLogin"));
					mb.setMemberImage(rs.getBlob("MemberImage"));
					members.add(mb);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDao類別#findAllMember()發生例外: " 
					+ ex.getMessage());
		}
		return members;
	}
	
}

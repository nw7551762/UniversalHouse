package spaceRental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
//import java.util.LinkedList;
//import java.util.List;
//import java.sql.Blob;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class spaceRentalDAO {
	DataSource ds = null;
	Connection connection = null;
	
	//Connection
	public spaceRentalDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// insert data (新增資料)OK!
	public int insert(spaceRentalBEAN sb) {
		int row = 0;
		String sql = "insert into SpaceRental"
				+ "(spaceName, city,  address,  accommodate,  spaceType,  price,  unit,  period1,  period2, "
				+ " facility_1,  facility_2,  facility_3,  facility_4,  facility_5,  intro,  pic,  comm) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, sb.getSpaceName());
			ps.setString(2, sb.getCity());
			ps.setString(3, sb.getAddress());
			ps.setInt(4, sb.getAccommodate());
			ps.setString(5, sb.getSpaceType());
			ps.setInt(6, sb.getPrice());
			ps.setString(7, sb.getUnit());
			ps.setString(8, sb.getPeriod1());
			ps.setString(9, sb.getPeriod2());
			ps.setString(10, sb.getFacility_1());
			ps.setString(11, sb.getFacility_2());
			ps.setString(12, sb.getFacility_3());
			ps.setString(13, sb.getFacility_4());
			ps.setString(14, sb.getFacility_5());
			ps.setString(15, sb.getIntro());
			ps.setBlob(16, sb.getPic());
			ps.setString(17, sb.getComm());
			row = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Class:DAO insert()發生例外: " + e.getMessage());
		}
		return row;
	}

	// Read ALL (showAllData) OK!
	public List<spaceRentalBEAN> readAll() {
		List<spaceRentalBEAN> list = new ArrayList<spaceRentalBEAN>();
		String sql = "select * from SpaceRental";
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					spaceRentalBEAN sr = new spaceRentalBEAN();
					sr.setSpaceNo(rs.getInt("spaceNO"));
					sr.setSpaceName(rs.getString("spaceName"));
					sr.setCity(rs.getString("city"));
					sr.setAddress(rs.getString("address"));
					sr.setAccommodate(rs.getInt("accommodate"));
					sr.setSpaceType(rs.getString("spaceType"));
					sr.setPrice(rs.getInt("price"));
					sr.setUnit(rs.getString("unit"));
					sr.setPeriod1(rs.getString("period1"));
					sr.setPeriod2(rs.getString("period2"));
					sr.setFacility_1(rs.getString("facility_1"));
					sr.setFacility_2(rs.getString("facility_2"));
					sr.setFacility_3(rs.getString("facility_3"));
					sr.setFacility_4(rs.getString("facility_4"));
					sr.setFacility_5(rs.getString("facility_5"));
					sr.setIntro(rs.getString("intro"));
					sr.setPic(rs.getBlob("pic"));
					sr.setComm(rs.getString("comm"));
					list.add(sr);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Class: spaceDAO #readALL()發生例外: " + e.getMessage());
		}
		return list;
	}

	// Read By Like City (搜尋)OK!
	public List<spaceRentalBEAN> readByCity(String city) throws SQLException {
		String sql = "select * from SpaceRental where city like ?";
		Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + city + "%");
		ResultSet rs = ps.executeQuery();

		LinkedList<spaceRentalBEAN> list = new LinkedList<>();
		while (rs.next()) {
			spaceRentalBEAN sr = new spaceRentalBEAN();
			sr.setSpaceNo(rs.getInt("spaceNO"));
			sr.setSpaceName(rs.getString("spaceName"));
			sr.setCity(rs.getString("city"));
			sr.setAddress(rs.getString("address"));
			sr.setAccommodate(rs.getInt("accommodate"));
			sr.setSpaceType(rs.getString("spaceType"));
			sr.setPrice(rs.getInt("price"));
			sr.setUnit(rs.getString("unit"));
			sr.setPeriod1(rs.getString("period1"));
			sr.setPeriod2(rs.getString("period2"));
			sr.setFacility_1(rs.getString("facility_1"));
			sr.setFacility_2(rs.getString("facility_2"));
			sr.setFacility_3(rs.getString("facility_3"));
			sr.setFacility_4(rs.getString("facility_4"));
			sr.setFacility_5(rs.getString("facility_5"));
			sr.setIntro(rs.getString("intro"));
			sr.setPic(rs.getBlob("pic"));
			sr.setComm(rs.getString("comm"));
			list.add(sr);

		}
		rs.close();
		ps.close();
		con.close();

		return list;
	}

	// Delete By spaceNO (刪除) OK!
	public int deleteBySpaceNO(int spaceNo) throws SQLException {
		int row = 0;
		String sql = "delete from SpaceRental where spaceNo=?";
		Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, spaceNo);
		row = ps.executeUpdate();
		ps.close();
		con.close();

		return row;
	}

	// Read By spaceNO
	public spaceRentalBEAN readBySpaceNO(int NO) {
		spaceRentalBEAN sr = null;
		String sql = "select * from SpaceRental where spaceNo=?";
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, NO);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				sr = new spaceRentalBEAN();
				sr.setSpaceNo(rs.getInt("spaceNO"));
				sr.setSpaceName(rs.getString("spaceName"));
				sr.setCity(rs.getString("city"));
				sr.setAddress(rs.getString("address"));
				sr.setAccommodate(rs.getInt("accommodate"));
				sr.setSpaceType(rs.getString("spaceType"));
				sr.setPrice(rs.getInt("price"));
				sr.setUnit(rs.getString("unit"));
				sr.setPeriod1(rs.getString("period1"));
				sr.setPeriod2(rs.getString("period2"));
				sr.setFacility_1(rs.getString("facility_1"));
				sr.setFacility_2(rs.getString("facility_2"));
				sr.setFacility_3(rs.getString("facility_3"));
				sr.setFacility_4(rs.getString("facility_4"));
				sr.setFacility_5(rs.getString("facility_5"));
				sr.setIntro(rs.getString("intro"));
				sr.setPic(rs.getBlob("pic"));
				sr.setComm(rs.getString("comm"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Class: spaceDAO #readALL()發生例外: " + e.getMessage());
		}
		return sr;
	}

	// Update
	public void update(spaceRentalBEAN sb) {
		String sql = "update SpaceRental set spaceName=?, city=?,  address=?,  accommodate=?,  spaceType=?, price=?,  unit=?,"
				+ "period1=?,  period2=?, facility_1=?,  facility_2=?,  facility_3=?,  facility_4=?,  facility_5=?, intro=?,  pic=?,  comm=?"
				+ " WHERE spaceNo=?";

		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, sb.getSpaceName());
			ps.setString(2, sb.getCity());
			ps.setString(3, sb.getAddress());
			ps.setInt(4, sb.getAccommodate());
			ps.setString(5, sb.getSpaceType());
			ps.setInt(6, sb.getPrice());
			ps.setString(7, sb.getUnit());
			ps.setString(8, sb.getPeriod1());
			ps.setString(9, sb.getPeriod2());
			ps.setString(10, sb.getFacility_1());
			ps.setString(11, sb.getFacility_2());
			ps.setString(12, sb.getFacility_3());
			ps.setString(13, sb.getFacility_4());
			ps.setString(14, sb.getFacility_5());
			ps.setString(15, sb.getIntro());
			ps.setBlob(16, sb.getPic());
			ps.setString(17, sb.getComm());
			ps.setInt(18, sb.getSpaceNo());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Class: Dao#Updtae()發生例外: " + e.getMessage());
		}

	}

}

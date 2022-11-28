package zshe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class MemberDao {
	DataSource ds = null;
	
	public MemberDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	
	
	
	
	private static final String SELECT_BY_ID = "SELECT * FROM test";

	public MemberBean findByMemberNo(int no) {
		MemberBean member = new MemberBean();
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
		    
		) {
			try (
				ResultSet rset = stmt.executeQuery();					
			){
				if (rset.next()) {
					member.setNo(    ( rset.getInt(1))   );
				}
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return member;
	}
	
	
	
	
	
	
	
}

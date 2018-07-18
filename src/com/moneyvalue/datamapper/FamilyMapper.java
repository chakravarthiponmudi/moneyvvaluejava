package com.moneyvalue.datamapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.moneyvalue.database.utils.PostgreSQLJDBCConnection;
import com.moneyvalue.domain.Family;
import com.moneyvalue.lazyloaders.virtualproxy.PersonListProxy;

public class FamilyMapper {
	public static Family find(int id) {
		return null;
	}
	
	public static Family getFamily() {
		String sql = "SELECT * from FAMILY";
		Family familyObj = null;
		ResultSet rs = getDomainObjectUsingSQL(sql);
		try {
			while ( rs.next() ) {
			    int id = rs.getInt("id");
			    String  name = rs.getString("name");
			    familyObj = new Family(id, name);
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		familyObj.setMemberList(new PersonListProxy(familyObj));
		return familyObj;

	}

	
	public static int update(Family family) {
		return 0;
	}
	
	public static int delete(Family family) {
		return 0;
	}
	
	public static Family create(Family family) {
		return null;
	}
	
	private static ResultSet getDomainObjectUsingSQL(String stmt) {
		PostgreSQLJDBCConnection connection = null;
		try {
			connection = new PostgreSQLJDBCConnection();
			return connection.executeQuery(stmt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
	}
	
	
}

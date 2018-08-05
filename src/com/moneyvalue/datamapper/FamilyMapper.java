package com.moneyvalue.datamapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.moneyvalue.domain.Family;
import com.moneyvalue.lazyloaders.virtualproxy.PersonListProxy;

public class FamilyMapper extends AbstractMapper {
	public static Family find(int id) {
		return null;
	}
	public Family getMyFamily() {
		Family myFamily = (Family) this.abstractFind(null);
		return myFamily;
		
	}
	
	public static Family getFamily() {
		String sql = "SELECT * from FAMILY";
		Family familyObj = null;
		ResultSet rs = getResultSet(sql);
		try {
			while ( rs.next() ) {
			    String  name = rs.getString("name");
			    familyObj = new Family(name);
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

	@Override
	protected String findByStatement(Object o) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected String findStatement(Object o) {
		// TODO Auto-generated method stub
		return  "SELECT * from FAMILY";
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Family doLoad(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
	    String  name = rs.getString("name");
	    Family familyObj = new Family(name);
	    return familyObj;
	}


}

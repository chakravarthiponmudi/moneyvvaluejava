package com.moneyvalue.datamapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.moneyvalue.database.utils.PostgreSQLJDBCConnection;
import com.moneyvalue.domain.Account;
import com.moneyvalue.domain.DomainObject;
import com.moneyvalue.lazyloaders.virtualproxy.TransactionListProxy;

public abstract class AbstractMaper {
	protected static ResultSet getResultSet(String stmt) {
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
	abstract protected String findByStatement(Object o);
	abstract protected String findStatement(Object o);
	abstract protected <T> T doLoad(ResultSet rs)  throws SQLException ;
	
	protected DomainObject abstractFind(Object o) {
		ResultSet rs = getResultSet(this.findStatement(o));
		DomainObject dObj =null;
		try {
			while( rs.next()) {
				dObj = doLoad(rs);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dObj;
	}
	
	protected <T> ArrayList<T> abstractFindBy(Object o) {
		String sql = this.findByStatement(o); 
		ArrayList<T> dObjList = new ArrayList<T>();
		ResultSet rs = getResultSet(sql);
		try {
			while ( rs.next() ) {
				dObjList.add(doLoad(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dObjList;
	}

}

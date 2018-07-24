package com.moneyvalue.datamapper;

import java.sql.ResultSet;

import com.moneyvalue.database.utils.PostgreSQLJDBCConnection;

public class AbstractMaper {
	protected static ResultSet getDomainObjectUsingSQL(String stmt) {
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

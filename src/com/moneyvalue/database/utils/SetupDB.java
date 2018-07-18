package com.moneyvalue.database.utils;

public class SetupDB {
	public static void main(String args[]) {
		PostgreSQLJDBCConnection connection = null;
		try {
			connection = new PostgreSQLJDBCConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(0);
		}
		String sql;

		
		sql = "drop table Transaction";
		executeSql(connection, sql);
		
		sql = "drop table Accountmap";
		executeSql(connection, sql);
		
		sql = "drop table person";
		executeSql(connection, sql);
		
		sql = "drop table Account";
		executeSql(connection, sql);


		
		sql = "drop table family";
		executeSql(connection, sql);
		
		sql = "CREATE TABLE FAMILY " +
	            "(ID INT PRIMARY KEY     NOT NULL," +
	            " NAME           TEXT    NOT NULL)" ;
		executeSql(connection, sql);
		
		sql = "CREATE TABLE PERSON " +
	            "(ID INT PRIMARY KEY     NOT NULL," +
	            "FIRSTNAME           TEXT    NOT NULL," +
	            "LASTNAME            TEXT    NOT NULL," +
	            "FAMILY				 INT     NOT NULL," +
	            "FOREIGN KEY(FAMILY) REFERENCES family(id) " +
	            ")";
		executeSql(connection, sql);
		
		sql = "CREATE TABLE Account " +
	            "(ID INT PRIMARY KEY     NOT NULL," +
	            "NAME           TEXT    NOT NULL," +
	            "TYPE            TEXT    NOT NULL," +
	            "BALANCE			NUMERIC(9,2) DEFAULT 0.0" +
	            ")";
		executeSql(connection, sql);
		
		sql = "CREATE TABLE Accountmap " +
	            "(ID INT PRIMARY KEY     NOT NULL," +
	            "PERSON          INT    NOT NULL," +
	            "ACCOUNT          INT    NOT NULL," +
	            "FOREIGN KEY(PERSON) REFERENCES PERSON(id), " +
	            "FOREIGN KEY(ACCOUNT) REFERENCES ACCOUNT(id) " +
	            ")";
		executeSql(connection, sql);
		
		sql = "CREATE TABLE transaction " +
	            "(ID INT PRIMARY KEY     NOT NULL," +
	            "TYPE          TEXT    NOT NULL," +
	            "transaction_date   DATE NOT NULL," +
	            "AMOUNT NUMERIC(9,2) DEFAULT 0.0," +
	            "ACCOUNT INT NOT NULL," +
	            "FOREIGN KEY(ACCOUNT) REFERENCES ACCOUNT(id) " +
	            ")";
		executeSql(connection, sql);
		
		try {
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void executeSql(PostgreSQLJDBCConnection connection, String sql) {
		try {
			connection.executeSql(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

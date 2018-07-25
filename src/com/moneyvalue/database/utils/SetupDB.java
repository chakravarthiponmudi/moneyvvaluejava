package com.moneyvalue.database.utils;

import java.sql.SQLException;

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
		
		sql = "drop table identitykey";
		executeSql(connection, sql);
		
		sql = "CREATE TABLE IDENTITYKEY" +
				"(TABLENAME TEXT NOT NULL," +
				"NEXTKEY INTEGER NOT NULL)" ;
		executeSql(connection, sql);
		
		sql = "INSERT INTO IDENTITYKEY(TABLENAME, NEXTKEY) VALUES" +
				"('FAMILY',2)," +
				"('PERSON',5)," +
				"('ACCOUNT',8)," +
				"('TRANSACTION',9)";
		executeSql(connection, sql);
				
		
		sql = "CREATE TABLE FAMILY " +
	            "(ID  			INTEGER PRIMARY KEY," +
	            " NAME          TEXT    NOT NULL)" ;
		executeSql(connection, sql);
		
		sql = "INSERT INTO FAMILY(ID, NAME) values(1,'PONMUDI ILLAM')";
		executeSql(connection, sql);

		sql = "CREATE TABLE PERSON " +
	            "(ID INTEGER PRIMARY KEY," +
	            "FIRSTNAME           TEXT    NOT NULL," +
	            "LASTNAME            TEXT    NOT NULL," +
	            "FAMILYID			 INT     NOT NULL," +
	            "FOREIGN KEY(FAMILYID) REFERENCES family(id) " +
	            ")";
		executeSql(connection, sql);
		
		sql = "INSERT INTO PERSON (ID, FIRSTNAME, LASTNAME,FAMILYID) VALUES" +
				"(1,'CHAKRAVARTHI', 'PONMUDI', 1)," +
				"(2,'PONMUDI','ADIGAL',1)," +
				"(3,'SUSEELA','PONMUDI',1)," +
				"(4,'SARANYA','CHAKRAVARTHI',1)" ;
		
		executeSql(connection, sql);
		
		sql = "CREATE TABLE Account " +
	            "(ID INTEGER PRIMARY KEY," +
	            "NAME           TEXT    NOT NULL," +
	            "TYPE            TEXT    NOT NULL," +
	            "BALANCE			NUMERIC(9,2) DEFAULT 0.0" +
	            ")";
		executeSql(connection, sql);
		
		sql = "INSERT INTO ACCOUNT(ID, NAME, TYPE,BALANCE) VALUES" +
				"(1,'ICICIBANK','SAVINGS',500.00)," +
				"(2,'HDFCBANK','SAVINGS',500.00)," +
				"(3,'VIJAYABANK','SAVINGS',500.00)," +
				"(4,'SBIBANK','SAVINGS',500.00)," +
				"(5,'VIJAYABANK','SAVINGS',500.00)," +
				"(6,'VIJAYABANK','SAVINGS',500.00)," +
				"(7,'AXISBANK','SAVINGS',500.00)";
		executeSql(connection, sql);
		
		sql = "CREATE TABLE Accountmap " +
	            "(ID SERIAL PRIMARY KEY," +
	            "PERSONID          INT    NOT NULL," +
	            "ACCOUNTID          INT    NOT NULL," +
	            "FOREIGN KEY(PERSONID) REFERENCES PERSON(id), " +
	            "FOREIGN KEY(ACCOUNTID) REFERENCES ACCOUNT(id) " +
	            ")";
		executeSql(connection, sql);
		
		sql = "INSERT INTO ACCOUNTMAP(PERSONID, ACCOUNTID) VALUES" +
				"(1,1)," +
				"(1,2)," +
				"(1,3)," +
				"(2,4)," +
				"(2,5)," +
				"(3,6)," +
				"(4,7)";
		
		executeSql(connection, sql);
		
		sql = "CREATE TABLE transaction " +
	            "(ID INTEGER PRIMARY KEY," +
	            "TYPE          TEXT    NOT NULL," +
	            "DESCRIPTION TEXT NOT NULL," +
	            "TRANSACTION_DATE   DATE NOT NULL," +
	            "AMOUNT NUMERIC(9,2) DEFAULT 0.0," +
	            "ACCOUNTID INT NOT NULL," +
	            "FOREIGN KEY(ACCOUNTID) REFERENCES ACCOUNT(id) " +
	            ")";
		executeSql(connection, sql);
		
		
		sql = "INSERT INTO TRANSACTION(ID, TYPE,DESCRIPTION,TRANSACTION_DATE,AMOUNT,ACCOUNTID) VALUES" +
				"(1,'CR','OPENING ACCOUNT','2018-02-20',1000.00,1)," +
				"(2,'DR','OPENING ACCOUNT','2018-02-20',500.00,1)," +
				"(3,'CR','OPENING ACCOUNT','2018-02-20',500.00,2)," +
				"(4,'CR','OPENING ACCOUNT','2018-02-20',500.00,3)," +
				"(5,'CR','OPENING ACCOUNT','2018-02-20',500.00,4)," +
				"(6,'CR','OPENING ACCOUNT','2018-02-20',500.00,5)," +
				"(7,'CR','OPENING ACCOUNT','2018-02-20',500.00,6)," +
				"(8,'CR','OPENING ACCOUNT','2018-02-20',500.00,7)";
		
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

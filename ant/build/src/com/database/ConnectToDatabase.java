package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConnectToDatabase extends Assert {
	
	private static final String url = "jdbc:sqlserver://localhost:1433;database=AppDatabase;SelectMethod=cursor;SendStringParametersAsUnicode=false";
	private static final String user = "sa";
	private static final String password = "admin1234#";
	
	public static Connection con = null;
	public static Statement smt = null;
	public static ResultSet rs = null;
	public static Object[][] dbData = null;
	
	@BeforeClass
	public void setUp() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //step -1 is to load the driver
			con = DriverManager.getConnection(url, user, password); // step - 2 get the connection
			smt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); // step - 3 get the statement
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void dropTable() {
		String query = "drop table datatable";
		try {
			assertEquals(0, smt.executeUpdate(query));
		} catch (SQLException e) {
			//Ignor
		}
		
	}
	
	@Test(dependsOnMethods={"dropTable"},alwaysRun=true)
	public void createTable() {
		String query = "create table datatable (" +
					"isocode varchar(255)," +
					"numcode varchar(255)," +
					"fdigit int," +
					"name varchar(255)" +
					")";
		try {
			assertEquals(0 ,smt.executeUpdate(query));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(dependsOnMethods={"createTable"})
	public void insertData() {
		String data[][] = {

				{ "AOA", "973", "2", "Kwanza" },
				{ "XOF", "952", "0", "CFA Franc BCEAO" },
				{ "XDR", "960", "-1", "SDR (Special Drawing Right)" },
				{ "KWD", "414", "3", "Kuwaiti Dinar" },
				{ "CLF", "990", "0", "Unidad de Fomento" },
				{ "CHW", "948", "2", "WIR Franc" },
				{ "SSP", "728", "2", "South Sudanese Pound" },
				{ "CLF", "990", "0", "Unidad de Fomento" },
				{ "CHW", "948", "2", "WIR Franc" },
				{ "UYI", "940", "0",
						"Uruguay Peso en Unidades Indexadas (URUIURUI)" },
				{ "XBB", "956", "-1",
						"Bond Markets Unit European Monetary Unit (E.M.U.-6)" },
				{ "XBC", "957", "-1",
						"Bond Markets Unit European Unit of Account 9 (E.U.A.-9)" } };
		
		String query = "";
		for(int i = 0; i < data.length; i++){
			query = "INSERT INTO DATATABLE" + " VALUES ( '"
						+ data[i][0] + "','" + data[i][1]
						+ "'," + Integer.parseInt(data[i][2]) + ",'"
						+ data[i][3] + "')";
			try {
				assertEquals(1, smt.executeUpdate(query));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Test(dependsOnMethods={"insertData"})
	public void fetchData() {
		String query = "select * from datatable";
		try {
			
			rs = smt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(dependsOnMethods={"fetchData"})
	public void getData() throws SQLException {
		rs.last();
		int row = rs.getRow();
		dbData = new Object[row][4];
		rs.beforeFirst();
		int i = 0;
		while(rs.next()){
			 dbData[i][0] = rs.getString("isocode");
			 dbData[i][1] = rs.getString("numcode");
			 dbData[i][2] =  rs.getString("fdigit");
			 dbData[i][3] = rs.getString("name");
			 i++;
		}
	}
	
	@DataProvider(name="getProviderData")
	public static Object[][] getProviderData() {
		return dbData;
	}
	
	
	@AfterClass
	public void tearDown() throws SQLException {
		if(con != null){
			con.close();
			con = null;
		}
		if(smt != null){
			smt.close();
			smt = null;
		}
	}
}

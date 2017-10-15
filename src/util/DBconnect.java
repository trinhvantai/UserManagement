package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DBconnect {
	private static Connection dbconnect;
	public DBconnect() {
		// TODO Auto-generated constructor stub
	}
	public static Connection getConnection(){
		if(DBconnect.dbconnect!=null)
			return DBconnect.dbconnect;
		else{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				dbconnect=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3308/user","root","trinhvantai");
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dbconnect;  
		}
	}
	
	public static void main(String args[]) throws SQLException{
		Connection con= DBconnect.getConnection();
		PreparedStatement preparedStatement =  con.prepareStatement(
				"insert into us(name,address,birthday,marital,job) values ('1','1','1','2001/1/1','1','1')");
		preparedStatement.executeUpdate();
	}

}

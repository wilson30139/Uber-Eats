package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteSQL {
	private Connection conn;
	private Statement stmt;
	private String sql;
	private ResultSet rs;
	private int FoodNumber;
	public DeleteSQL(int FoodNumber) {
		this.FoodNumber = FoodNumber;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection("jdbc:mysql://localhost/db_java?"
					+ "user=root&password=jacket020739&serverTimezone=UTC&useSSL=false");
			stmt = conn.createStatement();
			sql = "DELETE FROM db_java.food_table WHERE FoodNumber = "+this.FoodNumber;
			stmt.executeUpdate(sql);
			rs = stmt.executeQuery("SELECT * FROM db_java.food_table");
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4) + "\t" + rs.getString(5));
			}
			System.out.println("delete number"+this.FoodNumber+" successful!");
			System.out.println();
			
		} catch (SQLException ex ) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
	}
}

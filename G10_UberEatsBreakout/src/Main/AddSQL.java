package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddSQL {
	private int SQLNumber;
	private String chFoodSize;
	private int tfFoodCount;
	private int FoodMoney;
	private String FoodName;
	
//	private int intFoodMoney;
	private Connection conn;
	private Statement stmt;
	private PreparedStatement sql;
	private ResultSet rs;
	public AddSQL(int SQLNumber,String chFoodSize,int tfFoodCount,int FoodMoney,String FoodName) {
		this.SQLNumber = SQLNumber;
		this.chFoodSize = chFoodSize;
		this.tfFoodCount = tfFoodCount;
		this.FoodMoney = FoodMoney;
		this.FoodName = FoodName;	
//		if(this.FoodMoney.length()==11) {
//			this.FoodMoney = this.FoodMoney.substring(0, 2);
//		}else {
//			this.FoodMoney = this.FoodMoney.substring(0, 3);
//		}
//		if(this.chFoodSize=="small") {
//			intFoodMoney = Integer.parseInt(this.FoodMoney) - 20;
//		}else if(this.chFoodSize == "medium"){
//			intFoodMoney = Integer.parseInt(this.FoodMoney);
//		}else if(this.chFoodSize == "large") {
//			intFoodMoney = Integer.parseInt(this.FoodMoney) + 20;
//		}
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
			sql = conn.prepareStatement
					("INSERT INTO db_java.food_table(FoodNumber,FoodSize,FoodShare,FoodMoney,FoodName) VALUES (?,?,?,?,?)");
			sql.setInt(1, this.SQLNumber);
			sql.setString(2, this.chFoodSize);
			sql.setInt(3, this.tfFoodCount);
			sql.setInt(4, this.FoodMoney);
			sql.setString(5, this.FoodName);
			sql.executeUpdate();
			rs = stmt.executeQuery("SELECT * FROM db_java.food_table");

			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4) + "\t" + rs.getString(5));
			}
			System.out.println("add number"+this.SQLNumber+" successful!");
			System.out.println();
			
		} catch (SQLException ex ) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
	}
}

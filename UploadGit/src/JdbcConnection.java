import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnection {

	public static ResultSet mysqlConnection() {
		Connection con = null;
		Statement statement;
		ResultSet resultSet = null;

		String mysql = "jdbc:mysql://localhost:3306/akash";
		String User = "root";
		String Pass = "root";

		try {
			con = DriverManager.getConnection(mysql, User, Pass);
			statement = con.createStatement();
			resultSet = statement.executeQuery("Select * from bank ");
			System.out.println("hi");

		} catch (Exception e) {
			System.out.println(e);
		}
		// ResultSet resultSet = null;
		return resultSet;
	}
	
	public static void updateConnection(int id,int deposit) {
		try {
			ResultSet rs=mysqlConnection();
			int balance=0;
			int accountBalance =0;
			
			mysqlConnection().getRow();
			while (rs.next()) {
			 balance=+rs.getInt(5);}
			mysqlConnection().getStatement().executeUpdate("UPDATE account_details SET deposit = '"+deposit+"', `balance` = '"+balance+"' WHERE id_account_details = '"+id+"'");
			
			int totalBalance=deposit+balance;
			mysqlConnection().getStatement().executeUpdate("UPDATE bank SET currentBalance = '"+totalBalance +"' WHERE bank_id = '"+id+"'");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnection {

	Connection con = null;
	Statement statement;
	ResultSet resultSet;
	ResultSet resultSet1;
	String mysql = "jdbc:mysql://localhost:3306/akash";
	String User = "root";
	String Pass = "root";
	public void getAccountDetails(int id) {

		try {
			con=DriverManager.getConnection(mysql, User, Pass);
			statement = con.createStatement();
			resultSet = statement.executeQuery("Select * from bank ");

			while (resultSet.next()) {
				if (resultSet.getInt(1) == id) {
					System.out.println(resultSet.getString(1)+ resultSet.getString(2)+ resultSet.getString(3));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void updateConnection(int id,int deposit) {
		try {
			
			int balance=0;
			int accountBalance =0;
			con=DriverManager.getConnection(mysql, User, Pass);
			statement = con.createStatement();
			resultSet1 = statement.executeQuery("Select * from bank where bank_id= "+id);
			while (resultSet1.next()) {
			 balance=+resultSet1.getInt(5);}
			statement.executeUpdate("UPDATE account_details SET deposit = '"+deposit+"', `balance` = '"+balance+"' WHERE id_account_details = '"+id+"'");
			
			int totalBalance=deposit+balance;
			statement.executeUpdate("UPDATE bank SET currentBalance = '"+totalBalance +"' WHERE bank_id = '"+id+"'");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}

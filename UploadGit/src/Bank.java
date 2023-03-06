import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Bank {

	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) throws Exception {

		//System.out.println("Input ID");
		//int id=input.nextInt();
	//	JdbcConnection jc = new JdbcConnection();
		//jc.getAccountDetails(id);
		int id=0;
		
		ResultSet rs=JdbcConnection.mysqlConnection();
		while(rs.next()) {
			id=	rs.getInt(1);
			System.out.println(id);
		}
		JdbcConnection.mysqlConnection().getStatement().executeUpdate("UPDATE bank SET currentBalance = '"+50 +"' WHERE bank_id = '"+id+"'");
		
		JdbcConnection.mysqlConnection().getStatement().execute("INSERT INTO bank (`userName`, `password`, `customerId`, "
				+ "`currentBalance`) VALUES ('Manoj', 'mj', '9', '100')");
		creatUser();

		
		
	//	jdbcConnection.updateConnection();
		
	}
	public static void creatUser() throws SQLException {
		ResultSet rs=JdbcConnection.mysqlConnection();
		String userName =null;
		boolean create = true;
		
		System.out.println("Enter the Name; ");
		String uName=input.next();
		System.out.println("Enter the Password ");
		while(rs.next()) {
			userName=	rs.getString(2);
		
			if(uName.equals(userName))
			System.out.println("already Username is Taken");
			create=false;
		}
		if(create) {
		JdbcConnection.mysqlConnection().getStatement().execute("INSERT INTO bank (`userName`, `password`, `customerId`, "
				+ "`currentBalance`) VALUES ('"+uName+"', 'mj', '9', '100')");
		}
		
	}

}

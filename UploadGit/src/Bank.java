import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);
		System.out.println("Input ID");
		int id=input.nextInt();
		JdbcConnection jc = new JdbcConnection();
		//jc.getAccountDetails(id);
		
		System.out.println("Input ID");
		int deposit=input.nextInt();
		
		jc.updateConnection(id,deposit);
		
	}

}

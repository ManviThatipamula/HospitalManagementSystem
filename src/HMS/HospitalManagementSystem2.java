package HMS;
import java.sql.SQLException;
import java.util.Scanner;

import ADMIN.Admin;
import DBCONNECT.DbConnect;
import DOCTOR.Doctorn;
import PATIENT.Patientn;

public class HospitalManagementSystem2 {

	public static void main(String[] args) throws SQLException {
		int option;
		String choice;
		boolean connection = DbConnect.getConnection();
		if(connection==true)
		{
			System.out.println("Connected");
		}
		String choice1="y";
		while(choice1.equalsIgnoreCase("y"))
		{
			System.out.println("\t"+" 😉 Welcome To Care Hospital 😉"+"\t" );
			System.out.println("————————————————————————————————————————————");
			System.out.println("\t"+"1. Admin Login"+"\t");
			System.out.println("\t"+"2. Patient Register"+"\t");
			System.out.println("\t"+"3. Doctor Login"+"\t");
			System.out.println("\t"+"4. Exit"+"\t");
			System.out.println("————————————————————————————————————————————");
			System.out.println("Enter Your Option");
			Scanner din = new Scanner(System.in);
			option = din.nextInt();
			switch(option)
			{
			case 1:Admin a = new Admin();
				   a.adminLogin();
				break;
			case 2: Patientn pat = new Patientn();
					pat.patientprocess();
				break;
			case 3:
					Doctorn dn=new Doctorn();
					dn.login();
					
			case 4:
				System.exit(1);
			}
			System.out.println("Do You want to Continue Press y or exit Press N");
			choice= din.next();
		}
	}


	}



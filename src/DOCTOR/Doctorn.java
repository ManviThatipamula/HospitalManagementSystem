package DOCTOR;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import APPOINTMENT.Appointment;

public class Doctorn {
	Scanner din;
	public void login()
	{
		System.out.println("Doctor Login Here..");
		din = new Scanner(System.in);
		String name,password,prsc;
		int Patient_id = 0;
		System.out.println("Enter Doctor Name");
		name = din.next();
		System.out.println("Enter Doctor Password");
		password = din.next(); 
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "4577");
			String sql="select * from  doctors";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				if(name.equalsIgnoreCase(rs.getString(2)) && password.equalsIgnoreCase(rs.getString(6)))	
				{
					int id=rs.getInt(1);
					System.out.println("*** Your Appointments *******");
					Appointment app=new Appointment();
					app.ViewAppointments(id);
					
					System.out.println("******Enter Your Presciption");
					System.out.println("Enter Doctor Name");
					//Patient_id=din.nextInt();
					String Doctor_Name = din.next();
					System.out.println("Enter Doctor Specialization ");
					//String Patient_Name = din.next();
					String Specialization = din.next();
					System.out.println("Enter Patient Name");
					//String Doctor_Name = din.next();
					String Patient_Name = din.next();
					//System.out.println("Enter Patient Name");
					//String Specialization = din.next();
					//String Patient_Name = din.next();
					System.out.println("Enter Patient Disease");
					String Disease = din.next();
					//String Patient_Name = din.next();
					System.out.println("Enter your Presciption");
					String Presciption = din.next();
					Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "4577");
					String sql1 = "insert into Presciption  (Doctor_Name,Specialization,Patient_Name,Disease,Presciption)values(?,?,?,?,?)";
					 PreparedStatement ps=con.prepareStatement(sql1);
					 ps.setString(1, Doctor_Name);
					 
					ps.setString(2, Specialization);
					
					ps.setString(3, Patient_Name);
					ps.setString(4, Disease);
					ps.setString(5, Presciption);
					 int i=ps.executeUpdate();
					 if(i>0)
					 {
						 System.out.println("Presciption is Completed");
						 
						 din.next();
					 }
					
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void viewDoctors()
	{
		 try
		   {
			   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "4577");
			   String sql1="select * from doctors";
			   Statement st=con.createStatement();
			   ResultSet rs=st.executeQuery(sql1);
			   System.out.println("Doctor id\tname\tSpecialization\tAvailableFrom\tAvailableTo");
			   while(rs.next())
			   {
				   System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			   }
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	}
	public void addDoctors()
	{
		 try
		   {
			   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "4577");
			   String dname,dspec;
			   String password;
			   String avto,avfrom;
			   Scanner din = new Scanner(System.in);
			   System.out.println("Enter Doctor Name");
			   dname = din.next();
			   System.out.println("Enter Doctor Specalization");
			   dspec = din.next();
			   System.out.println("Enter Availability From Time");
			   avfrom=din.next();
			   System.out.println("Enter Availability To Time");
			   avto = din.next();
			   System.out.println("Enter Doctor Password");
			   password=din.next();
			   String sql="insert into doctors(doctor_name,Specialization,availableFrom, availableTo,password) values(?,?,?,?,?)";
			   PreparedStatement ps = con.prepareStatement(sql);
			   ps.setString(1, dname);
			   ps.setString(2, dspec);
			   ps.setString(3,avfrom );
			   ps.setString(4,avto);
			   ps.setString(5, password);
			   int i = ps.executeUpdate();
			  if(i>0)
			  {
				  System.out.println("Doctor Added Success");
			  }
			  else
			  {
				  System.out.println("Doctor Adding Failed");
			  }
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	}
}

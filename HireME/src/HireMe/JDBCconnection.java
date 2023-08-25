package HireMe;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCconnection {

	public static String DB_URL = "jdbc:mysql://localhost/firstTry";
	public static String USER = "root";
	public static String PASS = "root";
	public static ArrayList<ArrayList<Object>> userData=new ArrayList<ArrayList<Object>>();
	public static boolean applicantLogin(ArrayList<Object>givenData, String typeConn) {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
			if(typeConn.equals("applicantLogin")) {
				Statement stmt = conn.createStatement();
				String QUERY = "SELECT applicantID FROM applicantInfo";
				ResultSet rs = stmt.executeQuery(QUERY);
				String sqlaa = "SELECT * FROM applicantInfo" +" WHERE (applicantID = "+givenData.get(0)+" and applicantPassword = '"+givenData.get(1)+"');";
				System.out.println("sqlaa"+sqlaa);
				rs = stmt.executeQuery(sqlaa);
				if(rs.next())
				{
					rs = stmt.executeQuery(sqlaa);
					while(rs.next()){
						System.out.println("rs.next(");
						applicantHomePage hp=new applicantHomePage();
		           		hp.setuserID(rs.getInt("applicantID"),rs.getString("applicantName"));
		           		hp.main(null);
		           		System.out.println("applicantEMail "+rs.getString("applicantEMail"));
		           		}
					return true;
		           }
		           else
		        	   return false;
			}
			else if(typeConn.equals("companyLogin")) {
				Statement stmt = conn.createStatement();
				String QUERY = "SELECT companyID FROM companyInfo";
	            ResultSet rs = stmt.executeQuery(QUERY);
	            String sqlaa = "SELECT * FROM companyInfo" +" WHERE (companyID = "+givenData.get(0)+" and companyPassword = '"+givenData.get(1)+"');";
	            System.out.println("sqlaa"+sqlaa);
	            rs = stmt.executeQuery(sqlaa);
	            if(rs.next())
	            {
	            	rs = stmt.executeQuery(sqlaa);
	            	while(rs.next()){
	            		System.out.println("ID: " + rs.getInt("companyID"));
	            		System.out.println(rs.getString("companyEMail"));
	                 }
	            	return true;
	            }
	            else
	            {
	            	System.out.println("Empty");
					return false;
	            }
			}
			else if(typeConn.equals("adminLogin")) {
				Statement stmt = conn.createStatement();
	            String QUERY = "SELECT adminID FROM adminInfo";
	            ResultSet rs = stmt.executeQuery(QUERY);
	            String sqlaa = "SELECT * FROM adminInfo" +" WHERE (adminID = "+givenData.get(0)+" and adminPassword = '"+givenData.get(1)+"');";
	            System.out.println("sqlaa"+sqlaa);
	            rs = stmt.executeQuery(sqlaa);
	            if(rs.next())
	            {
	            	rs = stmt.executeQuery(sqlaa);
	            	while(rs.next()){
	            		System.out.println("ID: " + rs.getInt("adminID"));
	            		System.out.println(rs.getString("adminEMail"));
	                 }
	            	
					Statement stmt1 = conn.createStatement();
		            String QUERY1 = "SELECT * FROM companyInfo;";
		            ResultSet rs1 = stmt1.executeQuery(QUERY1);
		            String sqlaa1 = "SELECT * FROM companyInfo;";
		            System.out.println("sqlaa"+sqlaa1);
		            rs1 = stmt1.executeQuery(sqlaa1);
		            if(rs1.next())
		            {
		            	rs1 = stmt1.executeQuery(sqlaa1);
		            	while(rs1.next()){
		            		ArrayList<Object> temp=new ArrayList<Object>();
		            		System.out.println("ID: " + rs1.getInt(1)+"  "+rs1.getString(2)+"  "+rs1.getString(3)+"  Type: Applicant");
		            		temp.add(rs1.getInt(1));
		            		temp.add(rs1.getString(2));
		            		temp.add(rs1.getString(4));
		            		temp.add(rs1.getString(3));
		            		temp.add("Company");
		            		temp.add(rs1.getString(5));
		            		userData.add(temp);
		            		System.out.println("temp"+temp);
		                 }
		            }
		            sqlaa1 = "SELECT * FROM applicantInfo;";
		            System.out.println("sqlaa"+sqlaa1);
		            rs1 = stmt1.executeQuery(sqlaa1);
		            if(rs1.next())
		            {
		            	rs1 = stmt1.executeQuery(sqlaa1);
		            	while(rs1.next()){
		            		System.out.println("ID: " + rs1.getInt(1)+"  "+rs1.getString(2)+"  "+rs1.getString(3)+"  Type: Company");
		            		ArrayList<Object> temp=new ArrayList<Object>();
		            		temp.add(rs1.getInt(1));
		            		temp.add(rs1.getString(2));
		            		temp.add(rs1.getString(4));
		            		temp.add(rs1.getString(3));
		            		temp.add("Applicant");
		            		temp.add("NA");
		            		userData.add(temp);
		            		System.out.println("temp"+temp);
		                 }
		            }
	            	
	            	adminHomePage adminHome=new adminHomePage();
	            	adminHomePage.setUserData(userData);
	            	adminHomePage.main(null);
	            	return true;
	            }
	            else
	            {
	            	System.out.println("Empty");
					return false;
	            }
			}
			else if(typeConn.equals("jobPostedDetails")) {
				ArrayList<ArrayList<Object>> jobVacancy=new ArrayList<ArrayList<Object>>();
					Statement stmt = conn.createStatement();
					String QUERY = "SELECT * FROM availableVacancy;";
					ResultSet rs = stmt.executeQuery(QUERY);
					String sqlaa = "SELECT * FROM availableVacancy where companyID="+givenData.get(0)+";";
					System.out.println("sqlaa"+sqlaa);
					rs = stmt.executeQuery(sqlaa);
					if(rs.next())
					{
						rs = stmt.executeQuery(sqlaa);
						while(rs.next()){
							ArrayList<Object> temp=new ArrayList<Object>();
							temp.add(rs.getInt(1));
							temp.add(rs.getString(2));
							temp.add(rs.getInt(3));
							temp.add(rs.getString(4));
							temp.add(rs.getString(5));
							temp.add(rs.getInt(6));
							System.out.println("temp "+temp);
							jobVacancy.add(temp);
		                }
						CompanyHomePage comp=new CompanyHomePage();
						comp.jobVacancy=jobVacancy;
		           }
			}

			else if(typeConn.equals("companyDetails")) {
				System.out.println("akjhd");
					Statement stmt = conn.createStatement();
					String QUERY = "SELECT * FROM companyInfo;";
					ResultSet rs = stmt.executeQuery(QUERY);
					String sqlaa = "select * from companyInfo where companyID="+givenData.get(0)+";";
					System.out.println("sqlaa"+sqlaa);
					rs = stmt.executeQuery(sqlaa);
					if(rs.next())
					{
						rs = stmt.executeQuery(sqlaa);
						while(rs.next()){
							System.out.println("akjhd");
							ArrayList<Object> temp=new ArrayList<Object>();
							temp.add(rs.getInt(1));
							temp.add(rs.getString(2));
							temp.add(rs.getString(3));
							temp.add(rs.getString(4));
							temp.add(rs.getString(5));
//							temp.add(rs.getInt(6));
							System.out.println("tempaa "+temp);
							CompanyHomePage comp=new CompanyHomePage();
							comp.companyInfo=temp;
//							companyInfo.add(temp);
		                }
		           }
			}
			
			else if(typeConn.equals("addNewJobVacancy")) {
				
				System.out.println("Inserting records into the table...");
	            String sql= "INSERT INTO availableVacancy (jobTitle, companyID, vacancyType, dateOfJoining,noOfApplications) VALUES (?,?,?,?,?);";	            
	            System.out.println("sql..."+sql);
	    		PreparedStatement st= conn.prepareStatement(sql);
	            st.setString(1, givenData.get(0)+"");
	            st.setString(2,givenData.get(1)+"");
	            st.setString(3,givenData.get(2)+"");
	            st.setString(4,givenData.get(3)+"");
	            st.setString(5,givenData.get(4)+"");
	            st.executeUpdate();
}
			
			else if(typeConn.equals("deleteJobVacancy")) {
				
				System.out.println("deleteJobVacancy records into the table...");
	            String sql= "delete from  availableVacancy where ID=?;";	            
	            System.out.println("sql..."+sql);
	    		PreparedStatement st= conn.prepareStatement(sql);
	            st.setString(1, givenData.get(0)+"");
	            st.executeUpdate();
}
			else if(typeConn.equals("applyJobCount")) {
				int countCurr=-1;
				Statement stmt = conn.createStatement();
				String QUERY = "SELECT * FROM availableVacancy;";
				ResultSet rs = stmt.executeQuery(QUERY);
				String sqlaa = "select * from availableVacancy where ID="+givenData.get(0)+";";
				System.out.println("sqlaa"+sqlaa);
				rs = stmt.executeQuery(sqlaa);
				if(rs.next())
				{
					rs = stmt.executeQuery(sqlaa);
					while(rs.next()){
						System.out.println("akjhd");
						countCurr=rs.getInt(6);
	                }
	           }
				
				System.out.println("applyJobCount records into the table...");
	            String sql= "update availableVacancy set noOfApplications = ? where ID = ?;";	            
	            System.out.println("sql..."+sql);
	    		PreparedStatement st= conn.prepareStatement(sql);
	    		System.out.println("countCurr+1"+countCurr+1);
	    		System.out.println("givenData.get(0)"+givenData.get(0));
	            st.setInt(1, countCurr+1);
	            st.setString(2, givenData.get(0)+"");
	            st.executeUpdate();
}
			
			conn.close();
	} catch (SQLException errorSQL) {
	}
		return false;
//    	errorSQL.printStackTrace();
//    	}
//           	System.out.println("Empty");
//				contentPane.remove(errorMessage_2);
//				contentPane.add(errorMessage_1);
//				errorMessage_1.setForeground(Color.RED);
//				errorMessage_2.setForeground(Color.WHITE);
//           conn.close();
	}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

	}

}

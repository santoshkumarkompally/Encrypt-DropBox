package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;



public class SecurityApp {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs=null;
	public SecurityApp(){
/*
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username for database = ");
		String username = sc.nextLine();
		System.out.println("Enter password for database = ");
		String password = sc.nextLine();
*/
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			if(conn!=null)
			System.out.println("Connected to database");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

public void insert(String userName, String fileName , byte[] encFileKey, byte[] encHashKey,String hashValue,String doubleHashPass) throws SQLException{
//	String query=new String("select * from keystore"); 
//rs=stmt.executeQuery(query);
//while(rs.next()){
//	System.out.println("ID: "+rs.getString(1)+" NAME "+rs.getString(2));
//}
	PreparedStatement p = conn.prepareStatement("insert into keystore values(?,?,?,?,?,?)");
//	Scanner sc=new Scanner(System.in);
//	System.out.println("Enter user= ");
//	String user = sc.nextLine();
//	System.out.println("Enter fileName= ");
//	String filename = sc.nextLine();
//	System.out.println("Enter encfilekey= ");
//	String encfilekey = sc.nextLine();
//	System.out.println("Enter enchashkey= ");
//	String enchashkey = sc.nextLine();
//	System.out.println("Enter hashvalue= ");
//	String hashvalue = sc.nextLine();
//	System.out.println("Enter doublehashpass= ");
//	String doublehashpass = sc.nextLine();
	
	
	p.setString(1, userName);
	p.setString(2, fileName);
	p.setBytes(3, encFileKey);
	p.setBytes(4, encHashKey);
	p.setString(5, hashValue);
	p.setString(6, doubleHashPass);
    
	p.executeUpdate();

//    query=new String("select * from keystore"); 
//    rs=stmt.executeQuery(query);
//    while(rs.next()){
//    
//    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
//    }

}//end method

public DbReturns getData(String userName,String fileName){
	
	ResultSet rs=null;
	String input = "select * from keystore where user= '" + userName + "' and filename = '" +fileName + "'"; 
	DbReturns obj1 =new DbReturns();
	try {
		rs= stmt.executeQuery(input);
		while(rs.next()){
	    //System.out.println(Arrays.toString(b1) + "\n"+ rs.getString(5)+"\n"+rs.getString(6));
			obj1.setUserName(rs.getString(1));
			obj1.setFileName(rs.getString(2));
			obj1.setFileEncKey(rs.getBytes(3));
			obj1.setHashEncKey(rs.getBytes(4));
			obj1.setHashValue(rs.getString(5));
			obj1.setHhkey(rs.getString(6));
		
		}  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	

return obj1;

	
}



}//end class

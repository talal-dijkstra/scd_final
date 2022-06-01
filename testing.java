package jdbc;

import java.sql.*;
import java.util.Scanner;

public class testing {
	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		final String url= "jdbc:mysql:///mariadb";
		final String user= "root";
		final String pwd="fast123";
		
		Connection con= DriverManager.getConnection(url, user, pwd);
		
		
		
		if(con==null) {
			System.out.println("JDBC connection failed to establish");
			return;
		}
		else {
			System.out.println("JDBC connection was successful");
		
		}
		
		//Statement st=con.createStatement();
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter id");
		int id=sc.nextInt();
		System.out.println("Enter name");
		String name= sc.next();		
		
		String query="insert into student values (?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, id);
		st.setString(2, name);
		
		
		//ResultSet rs= st.executeQuery(query);
		
		int count=st.executeUpdate();
		
		System.out.println("Rows updated are "+ count);
		
		//while(rs.next()) {
			//System.out.println(rs.getInt(1) + " "  + rs.getString(2));
			
		//}
		//rs.close();
		st.close();
		con.close();
		
	}

}

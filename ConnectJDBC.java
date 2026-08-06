import java.sql.Connection;
import java.sql.*;

public class Demo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//step 1 load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loading... and loaded");
				// 2nd step establish the connection
				Connection con;
				con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/febbatch","root","Venki@757");
				System.out.println("Connection Established");
				//3rd step create the statement medium
				Statement stmt=con.createStatement();
				System.out.println("Stament created");
				//4th step Excute the Query
				String sql="select * from student";
				ResultSet rs=stmt.executeQuery(sql);
				System.out.println("Query Executed Finally");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
				}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
}

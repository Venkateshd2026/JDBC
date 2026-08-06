import java.sql.*;
import java.util.Scanner;
public class InsertRecordEmp {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="insert into Employee_table values(?,?,?,?)";
		String dpath="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/febbatch";
		String user="root";
		String password="Venki@3747";
		try {
			Class.forName(dpath);
			con=DriverManager.getConnection(url, user, password);
			ps=con.prepareStatement(sql);
			Scanner sc=new Scanner(System.in);
			System.out.println("Id , Name, Gender, Salary");
			int id=sc.nextInt();
			String name=sc.next();
			String gender=sc.next();
			int salary=sc.nextInt();
			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setString(3,gender);
			ps.setInt(4, salary);
			int nora=ps.executeUpdate();//ps.executeUpdate() it tells the number of nor of rows affected.
			System.out.println("Number of rows affected:"+nora);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				if(con!=null)
					con.close();
Object sc = null;
					if(sc!=null)((Scanner) sc).close();
					if(ps!=null)ps.close();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}	
	}
}

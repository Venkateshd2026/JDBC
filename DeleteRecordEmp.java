import java.sql.*;
import java.util.Scanner;
public class DeleteRecordEmp {
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		String dpath="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/febbatch?user=root&password=Venki@357";
		String sql="delete from employee_table where id=?";
		try {
			Class.forName(dpath);
			con=DriverManager.getConnection(url);
			ps=con.prepareStatement(sql);
			 sc=new Scanner(System.in);
			System.out.println("Enter the id  to delete thefrom the database:");
			int id=sc.nextInt();
			ps.setInt(1,id);
			int nor =ps.executeUpdate();
			System.out.println(nor+"row(s) affected");
		}catch(Exception e){
			e.printStackTrace();
			
		}
		finally {
			try {
				if(con!=null)con.close();
				if(ps!=null)ps.close();
				if(sc!=null)ps.close();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}

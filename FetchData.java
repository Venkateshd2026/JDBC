import java.sql.*;
import java.util.*;
public class Fetch {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
String dpath="com.mysql.cj.jdbc.Driver";
String url="jdbc:mysql://127.0.0.1:3306/febbatch";
String user="root";
String password="Venki@3747";
String sql="select * from student where sid=?";
try {
	Class.forName(dpath);
	con=DriverManager.getConnection(url,user,password);
	ps=con.prepareStatement(sql);
	System.out.println("eneter the id to fetch the data:");
	int uid=sc.nextInt();
	ps.setInt(1,uid);
	rs=ps.executeQuery();
	if(rs.next()) {
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
	}else {
		System.out.println("Invalid uid"+uid);
	}
}catch(Exception e) {
	e.printStackTrace();
}
finally {
		try {
			if(con!=null)
			con.close();
			if(rs!=null)rs.close();
			if(sc!=null)sc.close();
			if(ps!=null)ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
}

import java.sql.*;
import java.util.*;
public class StoredProcedure {
	public static void main(String[] args) {
		Connection con=null;
		ResultSet rs=null;
		Scanner sc=null;
		CallableStatement cs=null;
		 String dpath = "com.mysql.cj.jdbc.Driver";
	      String url = "jdbc:mysql://127.0.0.1:3306/febbatch?user=root&password=Venki@kjbakjfka";
	      String sql="Call getStudent(?)";
	        
		try {
			Class.forName(dpath);
			con=DriverManager.getConnection(url);
			cs=con.prepareCall(sql);
			System.out.println("enter the marks to get the student list");
			sc=new Scanner(System.in);
			int marks=sc.nextInt();
			cs.setInt(1, marks);
			boolean res=cs.execute();
			if(res==true) {
				
				rs=cs.getResultSet();
				while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+""+rs.getInt(3)+" "+rs.getInt(4));
				}
				
			}else {
				int nora=cs.getUpdateCount();
				System.out.println(nora);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				 if (rs != null)
	                    rs.close();
				 if (cs != null)
	                    cs.close();

	                if (con != null)
	                    con.close();

	                if (sc != null)
	                    sc.close();
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		

	}

}

package com.venki.jdbcbatchupdate;
import java.sql.*;
import java.util.*;
class App 
{  
  //m means maven project 
	public static void main( String[] args )
    {
    	Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		String dpath="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/febbatch?user=root&password=Venki@374757";
		String sql="insert into department values(?,?,?,?)";
		try {
			Class.forName(dpath);
			con=DriverManager.getConnection(url);
			ps=con.prepareStatement(sql);
			venki:while(true) {
				sc=new Scanner(System.in);
				System.out.println("Enter 1 to insert OR 2 to exit");
				int choice=sc.nextInt();
				switch(choice) {
				case 1: {
					System.out.println("Enter the did,dname,dloc,dnoe");
					int id=sc.nextInt();
					String name=sc.next();
					String loc=sc.next();
					int noe=sc.nextInt();
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setString(3, loc);
					ps.setInt(4,noe);
					
					ps.addBatch();
					break;
				}
				case 2 : {
					break venki;
				}
				default:System.out.println("INVAlID ");
						break;
				
				}
				int res[]=ps.executeBatch();
				for(int i:res) {
					System.out.println(i+" ");
				}
			}
			
		}catch(Exception e) {
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

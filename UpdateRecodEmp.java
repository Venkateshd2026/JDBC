import java.sql.*;
import java.util.*;

public class UpdateRecEmp {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement ps = null;
        Scanner sc = null;

        String dpath = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/febbatch?user=root&password=dghdfajjf";
        String sql = "update employee_table set name=? where id=?";

        try {

            Class.forName(dpath);
            con = DriverManager.getConnection(url);

            sc = new Scanner(System.in);

            System.out.print("Enter new name: ");
            String name = sc.next();

            System.out.print("Enter employee id: ");
            int id = sc.nextInt();

            ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, id);

            int nor = ps.executeUpdate();

            System.out.println(nor + " row(s) affected");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (ps != null)
                    ps.close();

                if (con != null)
                    con.close();

                if (sc != null)
                    sc.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

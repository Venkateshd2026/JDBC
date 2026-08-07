import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class HandleTransaction {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        Scanner scan = new Scanner(System.in);
        String dpath = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://127.0.0.1:3306/febbatch?user=root&password=Venki@374757";
        String sql1 = "update bank set bal = bal-? where Acno = ? and pw = ?";
        String sql2 = "update bank set bal = bal+? where Acno = ?";
        try {
            Class.forName(dpath);
            con = DriverManager.getConnection(url);
            ps1 = con.prepareStatement(sql1);
            ps2 = con.prepareStatement(sql2);
            System.out.println("Enter fromAccNum and password : ");
            int facno = scan.nextInt();
            String pwd = scan.next();
            System.out.println("Enter toAccnum :");
            int toAccno = scan.nextInt();
            System.out.println("Enter the amountto transfer :");
            int amount = scan.nextInt();
            ps1.setInt(1, amount);
            ps1.setInt(2, facno);
            ps1.setString(3, pwd);
            ps2.setInt(1, amount);
            ps2.setInt(2, toAccno);
            int nora1 = ps1.executeUpdate();
            System.out.println(nora1 + " row(s) Affected");
            int nora2 = ps2.executeUpdate();
            System.out.println(nora2 + " row(s) Affected");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();
                if (con != null) con.close();
                if (scan != null) scan.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

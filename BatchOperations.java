import java.sql.*;
import java.util.*;

public class BatchOperations{

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement ps = null;
        Scanner sc = null;

        String dpath = "com.mysql.cj.jdbc.Driver";

        String url = "jdbc:mysql://127.0.0.1:3306/febbatch?user=root&password=Venki@374757";

        String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";

        try {

            // 1. Load Driver
            Class.forName(dpath);

            // 2. Establish Connection
            con = DriverManager.getConnection(url);

            // 3. Create PreparedStatement
            ps = con.prepareStatement(sql);

            sc = new Scanner(System.in);

            System.out.println("Enter number of students:");
            int n = sc.nextInt();

            // 4. Get student details
            for (int i = 1; i <= n; i++) {

                System.out.println("Enter student id:");
                int id = sc.nextInt();

                System.out.println("Enter student name:");
                String name = sc.next();

                System.out.println("Enter marks:");
                int marks = sc.nextInt();

                System.out.println("Enter age:");
                int age = sc.nextInt();

                // 5. Set values
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, marks);
                ps.setInt(4, age);

                // 6. Add to batch
                ps.addBatch();
            }

            // 7. Execute all operations
            int[] result = ps.executeBatch();

            System.out.println("Batch operation completed!");

            System.out.println("Number of records processed: " + result.length);

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

            } catch (Exception e1) {

                e1.printStackTrace();
            }
        }
    }
}

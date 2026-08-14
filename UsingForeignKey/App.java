package com.venki.UsingForiegnKey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println(
                "Enter id, houseno, streetname, city, state, country, pincode"
        );

        address addr = new address(
                scan.nextInt(),
                scan.nextInt(),
                scan.next(),
                scan.next(),
                scan.next(),
                scan.next(),
                scan.nextInt()
        );

        System.out.println(
                "Enter student id, name, gender, age, collage, university, 10thmarks, 12thmarks, degree"
        );

        student stu = new student(
                scan.nextInt(),
                scan.next(),
                scan.next(),
                scan.nextInt(),
                scan.next(),
                scan.next(),
                scan.nextInt(),
                scan.nextInt(),
                scan.nextInt(),
                addr
        );

        System.out.println(stu);

        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        String dpath = "com.mysql.cj.jdbc.Driver";

        String url =
                "jdbc:mysql://127.0.0.1:3306/newdatabse?user=root&password=Venki@374757";

//        String sql1 =
//                "INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?)";
        String sql1 = "INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?,?)";

        String sql2 =
                "INSERT INTO address VALUES(?,?,?,?,?,?,?)";

        try {

            // Load Driver
            Class.forName(dpath);

            // Establish Connection
            con = DriverManager.getConnection(url);

            // Create PreparedStatements
            ps1 = con.prepareStatement(sql1);
            ps2 = con.prepareStatement(sql2);

            // -----------------------------
            // ADDRESS TABLE
            // -----------------------------

            ps2.setInt(1, addr.getId());
            ps2.setInt(2, addr.getHouseno());
            ps2.setString(3, addr.getStreetname());
            ps2.setString(4, addr.getCity());
            ps2.setString(5, addr.getState());
            ps2.setString(6, addr.getCountry());
            ps2.setInt(7, addr.getPincode());

            // -----------------------------
            // STUDENT TABLE
            // -----------------------------

            ps1.setInt(1, stu.getId());
            ps1.setString(2, stu.getName());
            ps1.setString(3, stu.getGender());
            ps1.setInt(4, stu.getAge());
            ps1.setString(5, stu.getCollage());
            ps1.setString(6, stu.getUniversity());
            ps1.setInt(7, stu.getTenthmarks());
            ps1.setInt(8, stu.getTwelfthmarks());
            ps1.setInt(9, stu.getDegreemarks());
            ps1.setInt(10, stu.addr.getId());

            // Address inserted first
            int nora1 = ps2.executeUpdate();

            // Student inserted second
            int nora2 = ps1.executeUpdate();

            System.out.println(
                    nora1 + nora2 + " ROW(S) affected"
            );

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (ps1 != null) {
                    ps1.close();
                }

                if (ps2 != null) {
                    ps2.close();
                }

                if (con != null) {
                    con.close();
                }

                if (scan != null) {
                    scan.close();
                }

            } catch (Exception e2) {

                e2.printStackTrace();
            }
        }
    }
}

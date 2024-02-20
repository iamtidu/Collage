/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * use XAMP to data base connection
 */
package Lab1;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class EmpSelectStatement {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/employee4";
            String user = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url, user, password);

          //  conn = DriverManager.getConnection(url, user, password);
            Statement s = conn.createStatement();
            Scanner sc = new Scanner(System.in);
            System.out.println("enter id: ");
            int id=sc.nextInt();
            ResultSet rs = s.executeQuery("select * from emp where EmpID="+id+"");
            while (rs.next()) {
                System.out.println("---------------------------------");
                System.out.println("Employee ID:" + rs.getInt(1));
                System.out.println("Employee Name:" + rs.getString(2));
                System.out.println("Employee City:" + rs.getString(3));
              int age= Integer.parseInt(rs.getString(4));
                System.out.println("Employee Age:" + rs.getInt(4));

            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            // System.out.println("db is not connected");

        }

    }

}

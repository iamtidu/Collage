/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class EmpPreparedStatement {

    public static void main(String args[]) {
        // TODO code application logic here
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/employee4";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = conn.prepareStatement("insert into Emp values(?,?,?,?)");
            ps.setInt(1, 50);//1 specifies the first parameter in the query  
            ps.setString(2, "Ziya");
            ps.setString(3, "Rajkot");//1 specifies the first parameter in the query  
            ps.setInt(4, 25);
            int i = ps.executeUpdate();
            System.out.println(i + " Inserted Sucesssfully");

        } catch (Exception e) {
            System.out.println("Not Connected to the database");
            e.printStackTrace();
        }
    }
}

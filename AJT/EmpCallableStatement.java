/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class EmpCallableStatement {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, username, password;
            url = "jdbc:mysql://localhost:3306/employee";
            username = "root";
            password = "";
            Connection conn = DriverManager.getConnection(url, username, password);
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Employee ID: ");
            int id = sc.nextInt();
            
            CallableStatement cs = conn.prepareCall("{call getEmpCity(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.execute();
            System.out.println("Employee city: " + cs.getString(2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

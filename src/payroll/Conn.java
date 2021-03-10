/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

/**
 *
 * @author natto
 */
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;  */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;  


public class Conn {
     Connection connect;
    Statement state;
    public Conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect =DriverManager.getConnection("jdbc:mysql:///payrolldb","root","");;
            state =connect.createStatement();  
            
           
        }catch(ClassNotFoundException | SQLException e){ 
            System.out.println(e);
        }  
    }  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author yunie
 */
public class ConnectionManage {
     private static Connection co;
    private static Statement stm;
     private static String url = "jdbc:mysql://localhost:3306/efebytec_efevet_gmistral?user=root&password=";

    public  ConnectionManage() {
        
         try {
            Class.forName("com.mysql.jdbc.Driver");            
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println(ex.getException());
        }  
        
        try {           
            Connection co = (Connection) DriverManager.getConnection(url);
            Statement stm = co.createStatement();
        } catch (SQLException ex) {
            // log an exception. for example:
            System.out.println(ex.getErrorCode());
        } 
        
         System.out.println("Coneccion exitosa con MySql");
    }

    public static Statement getStm() {
        return stm;
    }
    
    
    
    
}

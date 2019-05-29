/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yunie
 */
public class conectorDB {
    private static Connection co;
     private static Statement stm;
     private static final String url = "jdbc:mysql://localhost:3306/mapa?user=root&password=";

    public  conectorDB() {
        
         try {
            Class.forName("com.mysql.jdbc.Driver");            
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println(ex.getException());
        }  
        
        try {           
            Connection co = (Connection) DriverManager.getConnection(url);
           // Statement stm = co.createStatement();
           this.stm = co.createStatement();
        } catch (SQLException ex) {
            // log an exception. for example:
            System.out.println(ex.getErrorCode());
        } 
        
       //  System.out.println("Coneccion exitosa con MySql");
    }

    public static Statement getStm() {
        return stm;
    }
    
    
    public void getColores() throws SQLException{
        
        ResultSet rs = conectorDB.stm.executeQuery("select * from color");        
        while (rs.next())
        {
            System.out.println (rs.getInt (1) + " " + rs.getString (2));
        }
    }
    
    
    public List<Color> getColoresList() throws SQLException{
        
        List<Color> colores = new ArrayList<Color>(); 
        ResultSet rs = conectorDB.stm.executeQuery("select * from color"); 
        
            while (rs.next())
            {                            
               Color color_tmp = new Color();
               color_tmp.setId(rs.getInt(1));
               color_tmp.setColores(rs.getString(2));
               colores.add(color_tmp); 
            } 
        return colores;
       
       
    }
    
    
}

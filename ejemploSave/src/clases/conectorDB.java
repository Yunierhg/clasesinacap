/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    
    
    
    public void insertarBandera(Bandera bandera) throws SQLException{        
        int idBandera = 0;
        Connection co = (Connection) DriverManager.getConnection(this.url);
        String insertTableSQL = "INSERT INTO bandera(forma, escudo) VALUES (?,?)";
        PreparedStatement preparedStatement = co.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, bandera.getForma());
        preparedStatement.setBoolean(2, bandera.getEscudo()); 
        
        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows != 0) {
            
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                     idBandera = generatedKeys.getInt(1);
            }
            
            System.out.println ("El id de la bandera creada es:");
            System.out.println (idBandera);
            
            //aca se relaciona con los colores
           /* List<Color> colores = bandera.getColores();
            
            String insertRel_C_B = "INSERT INTO bandera_color(bandera_id, color_id) VALUES (?,?)";
            for(Color temp_colores : colores){
                
                PreparedStatement preparedStatementColor = co.prepareStatement(insertRel_C_B);
                preparedStatementColor.setInt(1, idBandera);
                preparedStatementColor.setInt(2, temp_colores.getId());
                preparedStatementColor.executeUpdate();
                
                System.out.println ("Relacion con el color id:");
                System.out.println (temp_colores.getId());
            }
            
             System.out.println ("La bandera y susrelacion con colores esta lista!!!");*/
             
        }else{
            throw new SQLException("No se pudo guardar"); 
        }
        
        
        
        
        
        
        
        
        
        
        
        
         
    }
    
    
}

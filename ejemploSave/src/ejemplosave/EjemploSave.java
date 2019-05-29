/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosave;

import clases.Bandera;
import clases.conectorDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.pkcs11.Secmod;

/**
 *
 * @author yunie
 */
public class EjemploSave {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            // TODO code application logic here
            Bandera bandera = new Bandera("triangular");
            bandera.setEscudo(true);
            
            conectorDB bd = new conectorDB();
            //descomentar para ejemplo de colores
            //bandera.setColores(bd.getColoresList());
            bd.insertarBandera(bandera);
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EjemploSave.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
    }
    
}

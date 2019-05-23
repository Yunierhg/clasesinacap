/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.conectorDB;
import java.sql.SQLException;
/**
 *
 * @author yunie
 */
public class Bandera {
    
    private String forma;
    private String colores[];
    private Boolean escudo = false;

    public Bandera(String forma, String[] colores) {
        this.forma = forma;
        this.colores = colores;
    }
    
    public Bandera(String forma) throws SQLException{
        this.forma = forma;
        
        conectorDB conector = new conectorDB();
        conector.getColores();          
        
       // this.colores = colores;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String[] getColores() {
        return colores;
    }

    public void setColores(String[] colores) {
        this.colores = colores;
    }

    public Boolean getEscudo() {
        return escudo;
    }

    public void setEscudo(Boolean escudo) {
        this.escudo = escudo;
    }
    
    
    
}

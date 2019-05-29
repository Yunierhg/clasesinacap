/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author yunie
 */
public class Bandera {
    
    private String forma;
    private List<Color> colores;
    private Boolean escudo = false;

    public Bandera(String forma, List<Color> colores) {
        this.forma = forma;
        this.colores = colores;
    }
    
    public Bandera(String forma) throws SQLException{
        this.forma = forma;
        
        conectorDB conector = new conectorDB();
        conector.getColoresList();          
        
       // this.colores = colores;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }   

    public Boolean getEscudo() {
        return escudo;
    }

    public void setEscudo(Boolean escudo) {
        this.escudo = escudo;
    }

    public List<Color> getColores() {
        return colores;
    }

    public void setColores(List<Color> colores) {
        this.colores = colores;
    }
    
    
    
}

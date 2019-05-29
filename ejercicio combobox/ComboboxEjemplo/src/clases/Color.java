/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author yunie
 */
public class Color {
    
    private String colores;
    private int id;
    
    public Color() {
        
    }

    public Color(String colores, int id) {
        this.colores = colores;
        this.id = id;
    }

    public String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        return this.colores;
    }
    
    
    
    
    
}

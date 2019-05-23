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
public class Mapa {
    
    private Pais paises[];
    private String nombre;
    private String titulo;
    private String escala = "1:200";
    private String tipo; 

    public Mapa(Pais[] paises, String Nombre, String Titulo) {
        //el uso de this es para hacer referencia al scope
        this.paises = paises;
        this.nombre = Nombre;
        this.titulo = Titulo;
    }

    public Pais[] getPaises() {
        return paises;
    }
    
    /*
    * Esta funcion devuelve un pais segun su posicion
    */
     public Pais getPaisDeArray(int pos) {
        return this.paises[pos];
    }

    public void setPaises(Pais[] paises) {
        this.paises = paises;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}

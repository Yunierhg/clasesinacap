/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paises;

import clases.Bandera;
import clases.Bandera;
import clases.Desarrollador;
import clases.Desarrollador;
import clases.Mapa;
import clases.Mapa;
import clases.Pais;
import clases.Pais;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author yunie
 */
public class Paises {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException{
        // declaramos los colores de las bandera
        String[] colores = new String[3];
        colores[0] = "rojo";
        colores[1] = "azul";
        colores[2] = "blanco";
        
        //Creamos la bandera
        Bandera tmp_bandera = new Bandera("rectangulo",colores);        
       
       //ejemplo 2
      // Bandera tmp_bandera = new Bandera("rectangulo");        
       
        //declaramos los paises
        Pais[] paises = new Pais[2];
        //Declaramos el pais 1
        Pais tmp_pais_chile = new Pais();
        tmp_pais_chile.setSuperficie(756950);
        tmp_pais_chile.setSuperficie(18000000);
        tmp_pais_chile.setNombre("Chile");
        tmp_pais_chile.setBandera(tmp_bandera);
        
        paises[0] = tmp_pais_chile;
        
        Pais tmp_pais_cuba = new Pais();
        tmp_pais_cuba.setSuperficie(756950);
        tmp_pais_cuba.setSuperficie(109884);
        tmp_pais_cuba.setNombre("Cuba");
        tmp_pais_cuba.setBandera(tmp_bandera);
        
        paises[1] = tmp_pais_cuba;         
        //Generamos el mapa
        Mapa map = new Mapa(paises, "Mapa de clases Inacap","Mapa de Chile y Cuba");
                
        try{            
          System.out.println(map.getPaisDeArray(55).getNombre());           
        }catch(Exception e){
           System.out.println(e.toString());
          // Desarrollador des = new Desarrollador(e.toString().replaceAll(" ","%"));
          Desarrollador des = new Desarrollador("Algo fue mal codigo:445");
          des.avisarSms();
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
//JAJAAJAJAJ XD
/**
 *
 * @author Carlos Riveros
 */
import java.util.ArrayList;
import java.io.File;
public class Directorio {
    private ArrayList<File> imagenes;
    public Directorio (){
        this.imagenes = new ArrayList();
    }
    public void llenarDirectorio(ArrayList<File> archivos){
        if(archivos != null){
            for(File archivo: archivos){
               imagenes.add(archivo);
            }
        }
    }
}

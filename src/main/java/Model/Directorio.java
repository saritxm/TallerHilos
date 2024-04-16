/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Carlos Riveros
 */
import java.util.ArrayList;
import java.io.File;

public class Directorio {
    private ArrayList<File> imagenes;

    public Directorio() {
        this.imagenes = new ArrayList<>();
    }
    //llena el directorio con las imagenes que vienen desde el FChooser que esta en el control
    public void llenarDirectorio(ArrayList<File> archivos) {
        if (archivos != null) {
            for (File archivo : archivos) {
                imagenes.add(archivo);
            }
        }
    }
    //Devuelve las imagenes del directorio
    public ArrayList<File> getImagenes() {
        return imagenes;
    }
    //modifica las imagenes que se guardan en el directorio
    public void setImagenes(ArrayList<File> imagenes) {
        this.imagenes = imagenes;
    }
}

package Controller;

import Model.Directorio;
import View.FChooser;
import java.util.ArrayList;
import java.io.File;

public class Control {
    private Directorio directorio;
    private FChooser fileChooser;
    
    public Control(){
        this.directorio = new Directorio();
        this.fileChooser = new FChooser();
        iniciar();
    }
    public ArrayList <File> vistaImagenes(String path){
        File dir = new File(path);
        File [] archivos = dir.listFiles();
        ArrayList<File> imagenes = new ArrayList<>();
        System.out.println(path); 
        for(File archivo: archivos){
            imagenes.add(archivo);
            System.out.println(archivo.getName());
        }
        return imagenes;
    }
    public void iniciar(){
        directorio.llenarDirectorio(vistaImagenes(fileChooser.seleccionarDirectorio()));
    }

}

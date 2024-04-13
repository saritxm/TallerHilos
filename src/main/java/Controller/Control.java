package Controller;

import Model.Directorio;
import View.FChooser;
import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;


public class Control {
    private Directorio directorio;
    private FChooser fileChooser;
    
    public Control(){
        this.directorio = new Directorio();
        this.fileChooser = new FChooser();
        iniciar();
    }
    public ArrayList <File> vistaImagenes(){
        ArrayList<File> imagenes = new ArrayList();
        for(File archivo: Arrays.asList(fileChooser.seleccionarCarpeta().listFiles())){
            imagenes.add(archivo);
        }
        return imagenes;
    }
    public void iniciar(){
        directorio.llenarDirectorio(vistaImagenes());
    }
}

package Controller;

import Model.Directorio;
import Model.HiloCarrete;
import View.FChooser;
import View.VentanaCatalogo;
import View.VentanaVisor;

import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;

import javax.swing.ImageIcon;


public class Control {
    private Directorio directorio;
    private FChooser fileChooser;
    private VentanaCatalogo vCatalogo;
    
    public Control(){
        this.directorio = new Directorio();
        this.fileChooser = new FChooser();
        this.vCatalogo = new VentanaCatalogo();
        iniciar();
    }

    private ArrayList <File> vistaImagenes(){
        ArrayList<File> imagenes = new ArrayList<>();
        for(File archivo: Arrays.asList(fileChooser.seleccionarCarpeta().listFiles())){
            imagenes.add(archivo);
            System.out.println(archivo.getPath());
        }
        return imagenes;
    }

    public void iniciar(){
        directorio.llenarDirectorio(vistaImagenes());
        vCatalogo.setVisible(true);
    }

}

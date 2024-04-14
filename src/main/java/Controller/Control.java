package Controller;

import Model.Directorio;
import View.FChooser;
import View.VentanaCatalogo;

import java.util.ArrayList;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener {
    private Directorio directorio;
    private FChooser fileChooser;
    private VentanaCatalogo vCatalogo;
    
    public Control(){
        this.directorio = new Directorio();
        this.fileChooser = new FChooser();
        this.vCatalogo = new VentanaCatalogo();
        this.vCatalogo.btnBuscarDir.addActionListener(this);
        iniciar();
    }
    public ArrayList <File> vistaImagenes(String path){
        File dir = new File(path);
        File [] archivos = dir.listFiles();
        ArrayList<File> imagenes = new ArrayList<>();
        System.out.println(path); 
        for(File archivo: archivos){
            if (archivo.isFile() && (archivo.getName().toLowerCase().endsWith(".jpg") || archivo.getName().toLowerCase().endsWith(".png") )){
                imagenes.add(archivo);
                System.out.println(archivo.getName());
            }
        }
        return imagenes;
    }
    public void iniciar(){
        this.vCatalogo.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.vCatalogo.btnBuscarDir){
            directorio.llenarDirectorio(vistaImagenes(fileChooser.seleccionarDirectorio()));
            vCatalogo.mostrarBotones(directorio);
        }
    }

}

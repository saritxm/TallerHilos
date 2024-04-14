package Controller;

import Model.Directorio;
import Model.HiloCarrete;
import View.Avisos;
import View.FChooser;
import View.VentanaCatalogo;
import View.VentanaVisor;

import java.util.ArrayList;

import javax.swing.JButton;

import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener {
    private Directorio directorio;
    private FChooser fileChooser;
    private VentanaCatalogo vCatalogo;
    public Avisos avisos;

    public Control() {
        this.directorio = new Directorio();
        this.fileChooser = new FChooser();
        this.vCatalogo = new VentanaCatalogo();
        this.avisos     = new Avisos();
        this.vCatalogo.btnBuscarDir.addActionListener(this);
        iniciar();
    }

    public ArrayList<File> vistaImagenes(String path) {
        File dir = new File(path);
        File[] archivos = dir.listFiles();
        ArrayList<File> imagenes = new ArrayList<>();
        avisos.consola(path);
        for (File archivo : archivos) {
            if (archivo.isFile() && (archivo.getName().toLowerCase().endsWith(".jpg")
                    || archivo.getName().toLowerCase().endsWith(".png"))) {
                imagenes.add(archivo);
                avisos.consola(archivo.getPath());
            }
        }
        return imagenes;
    }

    public void iniciar() {
        this.vCatalogo.setVisible(true);
    }

    private void actulizarEscucha(){
        for (JButton i : vCatalogo.botones) {
            i.addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vCatalogo.btnBuscarDir) {
            // directorio.llenarDirectorio(vistaImagenes(fileChooser.seleccionarDirectorio()));
            String directorioSeleccionado = fileChooser.seleccionarDirectorio();
            if (directorioSeleccionado != null) {
                ArrayList<File> imagenes = vistaImagenes(directorioSeleccionado);
                directorio.llenarDirectorio(imagenes);
                vCatalogo.mostrarBotones(directorio.getImagenes());
            }
            actulizarEscucha();
        }
        // Abrir Visor
        else if (vCatalogo.botones.contains(e.getSource())) {
            int y = vCatalogo.botones.indexOf(e.getSource());
            new HiloYVentana(directorio.getImagenes(),this,e.getActionCommand(),y);
        }
        else  if (e.getSource() == vCatalogo.btnSalirVC){
            vCatalogo.dispose();
        }
        
    }
}

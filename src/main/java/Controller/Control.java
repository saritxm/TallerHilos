package Controller;

//Librerias
import Model.Directorio;
import View.Avisos;
import View.FChooser;
import View.VentanaCatalogo;

import java.util.ArrayList;
import javax.swing.JButton;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase gestor principal
 */
public class Control implements ActionListener {
    private Directorio directorio;
    private FChooser fileChooser;
    private VentanaCatalogo vCatalogo;
    public Avisos avisos;

    /**
     * Contructor donde se instancia todo lo necesario
     */
    public Control() {
        // Directorio (Modelo)
        this.directorio = new Directorio();
        // FileChooser (Vista)
        this.fileChooser = new FChooser();
        // Ventana catalogo
        this.vCatalogo = new VentanaCatalogo();
        this.vCatalogo.btnBuscarDir.addActionListener(this);
        this.vCatalogo.btnSalirVC.addActionListener(this);
        // Avisos
        this.avisos = new Avisos();
        iniciar();
    }

    /**
     * Metodo para obtener las imagenes de la carpeta seleccionada
     * 
     * @param path
     * @return
     */
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

    // Ponerle escucha a todos los botones en la ventana
    private void actulizarEscucha() {
        for (JButton i : vCatalogo.botones) {
            i.addActionListener(this);
        }
    }

    /**
     * Inicializacion del programa
     */
    public void iniciar() {
        this.vCatalogo.setVisible(true);
    }

    /**
     * Metodo escucha de los botones
     */
    public void actionPerformed(ActionEvent e) {
        // Boton seleccionar directorio
        if (e.getSource() == this.vCatalogo.btnBuscarDir) {
            vCatalogo.botones.clear();
            String directorioSeleccionado = fileChooser.seleccionarDirectorio();
            if (directorioSeleccionado != null) {
                ArrayList<File> imagenes = vistaImagenes(directorioSeleccionado);
                directorio.llenarDirectorio(imagenes);
                vCatalogo.mostrarBotones(directorio.getImagenes());
            }
            // Cada que se presione el boton se le deben poner el respectivo ActionListener
            actulizarEscucha();
        }
        // Abrir Visor si el boton presionado esta en la lista que contiene los botones
        // de las imagenes
        else if (vCatalogo.botones.contains(e.getSource())) {
            // Obtener el index de la imagen seleccionada
            int y = vCatalogo.botones.indexOf(e.getSource());
            System.out.println(y);
            // Creacion de un controlador (Hilo y ventana) (Ver clase HiloYVentana)
            new HiloYVentana(directorio.getImagenes(), this, e.getActionCommand(), y);
        }
        // Salir
        else if (e.getSource() == vCatalogo.btnSalirVC) {
            vCatalogo.dispose();
        }

    }
}

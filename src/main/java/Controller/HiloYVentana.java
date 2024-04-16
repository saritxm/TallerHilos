package Controller;

//Librerias y clases externas
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import View.VentanaVisor;

/**
 * Clase encargada del manejo del visor, la ventana y su respectivo hilo/
 */
public class HiloYVentana implements ActionListener {
    private Control principal; // Gestor principal
    private VentanaVisor v; // Ventana
    private HiloCarrete h; // Hilo

    // Getters and setters
    public VentanaVisor getV() {
        return v;
    }

    public void setV(VentanaVisor v) {
        this.v = v;
    }

    public HiloCarrete getH() {
        return h;
    }

    public void setH(HiloCarrete h) {
        this.h = h;
    }

    /**
     * Metodo encargado de la actualizacion de la barra de progreso
     * 
     * @param a
     */
    private void barraProgreso(int a) {
        int porcentaje = (a * 100) / v.jProgressBar1.getMaximum(); // Calcular el porcentaje
        v.jProgressBar1.setValue(a);
        v.jProgressBar1.setString(porcentaje + "%"); // Establecer el porcentaje como texto en el progress bar
        v.jProgressBar1.setStringPainted(true); // Habilitar la visualización del texto en el progress bar
    }

    /**
     * Constructor donde se instancia el hilo y la respectiva ventana
     * 
     * @param aux
     * @param p
     * @param imagenSelectFile
     * @param inicio
     */
    public HiloYVentana(ArrayList<File> aux, Control p, String imagenSelectFile, int inicio) {
        this.principal = p; // Controlador principal
        this.v = new VentanaVisor(); // Ventana visor
        this.h = new HiloCarrete(aux, v::mostrarImagen, v::aviso, inicio, this::barraProgreso); // Creacion del hilo

        // ActionListeners
        this.v.btnContinuar.addActionListener(this);
        this.v.btnDetener.addActionListener(this);
        this.v.btnSalirVisor.addActionListener(this);

        // Avisos
        this.principal.avisos.consola("HILO # " + h.threadId() + " Imagen seleccionada: " + imagenSelectFile);
        this.principal.avisos.inicioHilo(imagenSelectFile, (int) h.threadId());
        // Inicio del hilo y de la ventana
        v.jProgressBar1.setMaximum(aux.size());
        v.jProgressBar1.setValue(inicio);
        // Inicio de la ventana y del hilo
        h.start();
        v.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Pausar hilo
        if (e.getSource() == v.btnDetener) {
            principal.avisos.pauseHilo((int) h.threadId());
            h.pause();
        }
        // Continuar hilo
        else if (e.getSource() == v.btnContinuar) {
            principal.avisos.continuarHilo((int) h.threadId(), h.isAlive());
            h.res();
        }
        // Salir del hilo
        else if (e.getSource() == v.btnSalirVisor) {
            principal.avisos.muerteHilo((int) h.threadId());
            v.dispose();
            h.kill();
            try {
                h.join(); // Espera que hilo se muera realmente para poder mostrar la confirmacion de que
                          // se murio
            } catch (InterruptedException e1) {
                principal.avisos.consola(e1.getMessage());
            }
            principal.avisos.consola("El hilo # " + h.threadId() + " Esta vivo? " + h.isAlive());
        }
    }

}

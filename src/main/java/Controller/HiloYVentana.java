package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import Model.HiloCarrete;
import View.VentanaVisor;

public class HiloYVentana implements ActionListener{
    private VentanaVisor v;
    private Control principal;
    private HiloCarrete h; 
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public HiloYVentana(ArrayList<File> aux, Control p){
        this.principal = p;                                    //Controlador principal 
        this.v = new VentanaVisor();                           //Ventana visor
        this.h = new HiloCarrete(aux, v::mostrarImagen, v::aviso);       //Creacion del hilo
        this.v.btnContinuar.addActionListener(this);           //ActionListeners
        this.v.btnDetener.addActionListener(this);
        this.v.btnSalirVisor.addActionListener(this);
        this.principal.avisos.consola("HILO # "+h.threadId() + "Imagen seleccionada: ");
        this.principal.avisos.inicioHilo(null, (int) h.threadId()); //Aviso
        h.run();
        v.setVisible(true);
    }   

    public void actionPerformed(ActionEvent e){
        //Pausar hilo
        if(e.getSource()==v.btnDetener){ 
            principal.avisos.pauseHilo((int) h.threadId());
            h.pause();
        }
        //Continuar hilo
        else if(e.getSource()==v.btnContinuar){
            principal.avisos.continuarHilo((int) h.threadId(), h.isAlive());
            h.resm();
        }
        //Salir del hilo
        else if(e.getSource()==v.btnSalirVisor){
            principal.avisos.muerteHilo((int)h.threadId());
            v.dispose();
            h.kill();
            principal.visores.remove(this);
        }
    }
    
}

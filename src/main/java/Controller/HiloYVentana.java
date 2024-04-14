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
        this.principal = p;

        this.v = new VentanaVisor();
        this.h = new HiloCarrete(aux, v::mostrarImagen);
        this.v.btnContinuar.addActionListener(this);
        this.v.btnDetener.addActionListener(this);
        this.v.btnSalirVisor.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        //Pausar hilo
        if(e.getSource()==v.btnDetener){
            h.pause();
        }
        //Continuar hilo
        else if(e.getSource()==v.btnContinuar){
            h.resm();
        }
        else if(e.getSource()==v.btnSalirVisor){
            v.dispose();
            h.kill();
            principal.visores.remove(this);
        }
    }
    
}
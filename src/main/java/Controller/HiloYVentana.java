package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import Model.HiloCarrete;
import View.VentanaVisor;

public class HiloYVentana implements ActionListener{
    private VentanaVisor v;
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

    public HiloYVentana(ArrayList<File> aux){
        this.v = new VentanaVisor();
        this.h = new HiloCarrete(aux, v::mostrarImagen);
    }

    public void actionPerformed(ActionEvent e){
        
    }
    
}

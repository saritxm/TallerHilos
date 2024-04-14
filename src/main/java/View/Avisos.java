package View;

import javax.swing.JOptionPane;

public class Avisos {

    public Avisos(){
    }

    public void inicioHilo(String ruta, int id){
        JOptionPane.showMessageDialog(null, "Imagen seleccionada: "+ruta+"\nID del hilo a crear: "+id, "INICIO DE HILO", JOptionPane.INFORMATION_MESSAGE);
    }
    public void pauseHilo(int id){
        JOptionPane.showMessageDialog(null,"El hilo ID: "+id+" se va a detener.", "PAUSA DE HILO", JOptionPane.INFORMATION_MESSAGE);
    }
    public void continuarHilo(int id, boolean alive){
        JOptionPane.showMessageDialog(null, "El hilo #"+id+" Esta vivo? "+alive+"\nContinua funcionando el hilo #"+id, "CONTINUACION DEL HILO", JOptionPane.INFORMATION_MESSAGE);
    }
    public void muerteHilo(int id){
        JOptionPane.showMessageDialog(null, "El hilo #"+id+" deja de funcionar ", "MUERTE", JOptionPane.INFORMATION_MESSAGE);
    }
    public void consola(String x){
        System.out.println(x);
    }
}

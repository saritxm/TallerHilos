package View;

import javax.swing.JOptionPane;

public class Avisos {

    public Avisos(){
    }

    public void inicioHilo(){
        JOptionPane.showMessageDialog(null, "Llene todos lo campos por favor", "CAMPOS VACIOS", JOptionPane.ERROR_MESSAGE);
    }
    
}

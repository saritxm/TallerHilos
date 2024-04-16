package View;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
public class FChooser {
    //Obtiene la direccion de la carpeta que contiene las imagenes
    public String seleccionarDirectorio() {
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de imagen", "jpg", "png");
        jf.setFileFilter(filtro);

        int resultado = jf.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            return jf.getSelectedFile().getAbsolutePath();
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado una carpeta.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
}

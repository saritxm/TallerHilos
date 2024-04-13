package View;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FChooser { 

    public FChooser() {
        // Constructor vacío
    }

    public String seleccionarDirectorio() {
        String[] opcionesDir = {"Cargar Directorio"};
        int opc2 = JOptionPane.showOptionDialog(null, "Seleccione una carpeta con imagenes:", "Subir Directorio", 0, JOptionPane.QUESTION_MESSAGE, null, opcionesDir, "");
        if (opc2 == 0) {
            JFileChooser jf = new JFileChooser();
            jf.setMultiSelectionEnabled(false);
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de imagen", "jpg", "png");
            jf.setFileFilter(filtro);

            int resultado = jf.showOpenDialog(null);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                return jf.getSelectedFile().getAbsolutePath();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado una carpeta.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
        return null;
    }
}

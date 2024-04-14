/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 *
 * @author Sara
 */
public class VentanaCatalogo extends javax.swing.JFrame {
    
    public ArrayList<JButton> botones; 
    
    /**
     * Creates new form ventanaCatalogo
     */
    public VentanaCatalogo() {
        botones = new ArrayList<>();
        setResizable(false);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnBuscarDir = new javax.swing.JButton();
        btnSalirVC = new javax.swing.JButton();
        barraImagenes = new javax.swing.JScrollPane();
        panelImagenes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscarDir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/buscar.jpg"))); // NOI18N
        jPanel1.add(btnBuscarDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 260, 70));

        btnSalirVC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/salir.jpg"))); // NOI18N
        btnSalirVC.setText("jButton2");
        jPanel1.add(btnSalirVC, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 210, 70));

        javax.swing.GroupLayout panelImagenesLayout = new javax.swing.GroupLayout(panelImagenes);
        panelImagenes.setLayout(panelImagenesLayout);
        panelImagenesLayout.setHorizontalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        panelImagenesLayout.setVerticalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );

        barraImagenes.setViewportView(panelImagenes);

        jPanel1.add(barraImagenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 750, 220));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/fondo.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        barraImagenes.setVisible(false);
        pack();

    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelImagenes ;
    public javax.swing.JButton btnBuscarDir;
    public javax.swing.JButton btnSalirVC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane barraImagenes;
    // End of variables declaration//GEN-END:variables

public void mostrarBotones(ArrayList<File> imagenes) {
    // Limpiamos el panel de botones antes de agregar nuevos
    panelImagenes.removeAll();
    // Creamos un nuevo FlowLayout con alineación izquierda y espacios entre componentes
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 10);
    panelImagenes.setLayout(layout);

    // Recorremos la lista de imágenes y creamos un botón para cada una
    for (File imagenFile : imagenes) {
        try {
            // Cargamos la imagen y la ajustamos al tamaño deseado
            ImageIcon icono = new ImageIcon(imagenFile.getAbsolutePath());
            Image imagen = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);

            // Creamos un nuevo botón con la imagen
            JButton boton = new JButton(new ImageIcon(imagen));

            // Establecemos un tooltip con el nombre del archivo de imagen
            boton.setActionCommand(imagenFile.getPath());

            // Agregamos el botón al panel de botones
            botones.add(boton);
            panelImagenes.add(boton);
            //barraImagenes.setVisible(true);
        } catch (Exception ex) {
            System.err.println("Error al cargar la imagen: " + ex.getMessage());
        }
         barraImagenes.setPreferredSize(new Dimension(800, 200));


    // Revalidamos y repintamos el panel para que los cambios sean visibles
    panelImagenes.revalidate();
    panelImagenes.repaint();
    barraImagenes.setVisible(true);
    }
}
}


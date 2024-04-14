/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Directorio;
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

    /**
     * Creates new form ventanaCatalogo
     */
    public VentanaCatalogo() {
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

        jPanel1 = new javax.swing.JPanel();
        btnBuscarDir = new javax.swing.JButton();
        btnSalirVC = new javax.swing.JButton();
        panelBotones = new javax.swing.JPanel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscarDir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/buscar.jpg"))); // NOI18N
        jPanel1.add(btnBuscarDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 260, 70));

        btnSalirVC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/salir.jpg"))); // NOI18N
        btnSalirVC.setText("jButton2");
        jPanel1.add(btnSalirVC, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 210, 70));

        panelBotones.setBackground(new java.awt.Color(0, 0, 0, 0));

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addGap(0, 352, Short.MAX_VALUE)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 850, 380));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 500));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarDir;
    public javax.swing.JButton btnSalirVC;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JPanel panelBotones;
    // End of variables declaration//GEN-END:variables
    

       public void mostrarBotones(Directorio directorio) {
        panelBotones.removeAll(); 
        ArrayList<File> imagenes = directorio.getImagenes();
        for (File imagen : imagenes) {
            ImageIcon icono = new ImageIcon(imagen.getAbsolutePath());
            Image img = icono.getImage();
            Image nuevaImg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            icono = new ImageIcon(nuevaImg);
            JButton boton = new JButton(icono);
            panelBotones.add(boton); 
        }
        panelBotones.revalidate(); 
        panelBotones.repaint();
        
    }
    
    }



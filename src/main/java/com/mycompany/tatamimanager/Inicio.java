/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tatamimanager;

import com.mycompany.tatamimanager.Alumnos.*;
import com.mycompany.tatamimanager.Profesores.*;
import com.mycompany.tatamimanager.colegios.*;
import com.mycompany.tatamimanager.Calendario.VerCalendario;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 *
 * @author diana
 */
public class Inicio extends javax.swing.JFrame {

    AddAlumnos panel_AddAlumnos;
    ListaAlumnos panel_listaAlumnos;
    AddColegios panel_AddColegios;
    ListaColegios panel_listaColegios;
    AddProfesores panel_AddProfesores;
    ListaProfesores panel_ListaProfesores;
    VerCalendario panel_Calendar;
    
    /**
     * Creates new form Inicio
     */ 
    public Inicio() {
        initComponents();
         
        setIconImage(new ImageIcon(getClass().getResource("/images/Logo_1.png")).getImage());
        //setIconImage(new ImageIcon(getClass().getResource("/images/16 x16.png")).getImage());
        
        panel_AddAlumnos = new AddAlumnos();
        panel_listaAlumnos = new ListaAlumnos();
        panel_AddColegios = new AddColegios();
        panel_listaColegios = new ListaColegios();
        panel_AddProfesores = new AddProfesores();
        panel_ListaProfesores = new ListaProfesores();
        
        
    }
    
    // Método para cambiar panel
    public void cambiarPanel(JPanel nuevoPanel) {
        this.getContentPane().removeAll();
        this.getContentPane().add(nuevoPanel);
        nuevoPanel.setBounds(0, 0, 890, 550);
        this.revalidate();
        this.repaint();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_icono = new javax.swing.JMenu();
        jMenuColegios = new javax.swing.JMenu();
        jMenuItem_VerColes = new javax.swing.JMenuItem();
        jMenuItem_AddCole = new javax.swing.JMenuItem();
        jMenuProfesores = new javax.swing.JMenu();
        jMenuItem_VerProfes = new javax.swing.JMenuItem();
        jMenuItem_AddProfes = new javax.swing.JMenuItem();
        jMenuAlumnos = new javax.swing.JMenu();
        jMenuItem_VerAlumnos = new javax.swing.JMenuItem();
        jMenuItem_AddAlumno = new javax.swing.JMenuItem();
        jMenuClases = new javax.swing.JMenu();
        jMenuItem_VerClases = new javax.swing.JMenuItem();
        jMenuItem_AddClase = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem_AsignarAlumnos = new javax.swing.JMenuItem();
        jMenuEventos = new javax.swing.JMenu();
        jMenuItem_AddEvento = new javax.swing.JMenuItem();
        jMenuCalendario = new javax.swing.JMenu();
        jMenuItem_VerCalendario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tatami Manager");
        setLocation(new java.awt.Point(500, 500));
        setPreferredSize(new java.awt.Dimension(905, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo_1.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clase2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)))
                .addGap(149, 149, 149)
                .addComponent(jLabel3)
                .addContainerGap(232, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(655, 655, 655))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 102, 255));

        jMenu_icono.setBackground(new java.awt.Color(0, 102, 255));
        jMenu_icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/retrato.png"))); // NOI18N
        jMenuBar1.add(jMenu_icono);

        jMenuColegios.setBackground(new java.awt.Color(0, 102, 255));
        jMenuColegios.setText("Colegios");

        jMenuItem_VerColes.setText("Ver colegios");
        jMenuItem_VerColes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_VerColesActionPerformed(evt);
            }
        });
        jMenuColegios.add(jMenuItem_VerColes);

        jMenuItem_AddCole.setText("añadir colegios");
        jMenuItem_AddCole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AddColeActionPerformed(evt);
            }
        });
        jMenuColegios.add(jMenuItem_AddCole);

        jMenuBar1.add(jMenuColegios);

        jMenuProfesores.setBackground(new java.awt.Color(0, 102, 255));
        jMenuProfesores.setText("Profesores");

        jMenuItem_VerProfes.setText("Ver profesores");
        jMenuItem_VerProfes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_VerProfesActionPerformed(evt);
            }
        });
        jMenuProfesores.add(jMenuItem_VerProfes);

        jMenuItem_AddProfes.setText("Añadir profesores");
        jMenuItem_AddProfes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AddProfesActionPerformed(evt);
            }
        });
        jMenuProfesores.add(jMenuItem_AddProfes);

        jMenuBar1.add(jMenuProfesores);

        jMenuAlumnos.setBackground(new java.awt.Color(0, 102, 255));
        jMenuAlumnos.setText("Alumnos");

        jMenuItem_VerAlumnos.setText("Ver alumnos");
        jMenuItem_VerAlumnos.setToolTipText("");
        jMenuItem_VerAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_VerAlumnosActionPerformed(evt);
            }
        });
        jMenuAlumnos.add(jMenuItem_VerAlumnos);

        jMenuItem_AddAlumno.setText("Añadir alumno");
        jMenuItem_AddAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AddAlumnoActionPerformed(evt);
            }
        });
        jMenuAlumnos.add(jMenuItem_AddAlumno);

        jMenuBar1.add(jMenuAlumnos);

        jMenuClases.setBackground(new java.awt.Color(0, 102, 255));
        jMenuClases.setText("Clases");

        jMenuItem_VerClases.setText("Ver clases");
        jMenuClases.add(jMenuItem_VerClases);

        jMenuItem_AddClase.setText("Añadir clase");
        jMenuClases.add(jMenuItem_AddClase);
        jMenuClases.add(jSeparator1);

        jMenuItem_AsignarAlumnos.setText("Asignar Alumnos");
        jMenuClases.add(jMenuItem_AsignarAlumnos);

        jMenuBar1.add(jMenuClases);

        jMenuEventos.setBackground(new java.awt.Color(0, 102, 255));
        jMenuEventos.setText("Eventos");

        jMenuItem_AddEvento.setText("Añadir evento");
        jMenuEventos.add(jMenuItem_AddEvento);

        jMenuBar1.add(jMenuEventos);

        jMenuCalendario.setBackground(new java.awt.Color(0, 102, 255));
        jMenuCalendario.setText("Calendario");

        jMenuItem_VerCalendario.setText("Ver calendario");
        jMenuItem_VerCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_VerCalendarioActionPerformed(evt);
            }
        });
        jMenuCalendario.add(jMenuItem_VerCalendario);

        jMenuBar1.add(jMenuCalendario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_AddAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AddAlumnoActionPerformed
        cambiarPanel(panel_AddAlumnos);
    }//GEN-LAST:event_jMenuItem_AddAlumnoActionPerformed

    private void jMenuItem_VerAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_VerAlumnosActionPerformed
        cambiarPanel(panel_listaAlumnos);
    }//GEN-LAST:event_jMenuItem_VerAlumnosActionPerformed

    private void jMenuItem_VerColesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_VerColesActionPerformed
        panel_listaColegios.iniTabla();
        cambiarPanel(panel_listaColegios);
    }//GEN-LAST:event_jMenuItem_VerColesActionPerformed

    private void jMenuItem_AddColeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AddColeActionPerformed
        panel_AddColegios.vaciarCampos();
        cambiarPanel(panel_AddColegios);
    }//GEN-LAST:event_jMenuItem_AddColeActionPerformed

    private void jMenuItem_AddProfesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AddProfesActionPerformed
        panel_AddProfesores.vaciarCampos();
        cambiarPanel(panel_AddProfesores);
    }//GEN-LAST:event_jMenuItem_AddProfesActionPerformed

    private void jMenuItem_VerProfesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_VerProfesActionPerformed
        panel_ListaProfesores.iniTabla();
        cambiarPanel(panel_ListaProfesores);
    }//GEN-LAST:event_jMenuItem_VerProfesActionPerformed

    private void jMenuItem_VerCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_VerCalendarioActionPerformed
        cambiarPanel(panel_Calendar);
    }//GEN-LAST:event_jMenuItem_VerCalendarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenuAlumnos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCalendario;
    private javax.swing.JMenu jMenuClases;
    private javax.swing.JMenu jMenuColegios;
    private javax.swing.JMenu jMenuEventos;
    private javax.swing.JMenuItem jMenuItem_AddAlumno;
    private javax.swing.JMenuItem jMenuItem_AddClase;
    private javax.swing.JMenuItem jMenuItem_AddCole;
    private javax.swing.JMenuItem jMenuItem_AddEvento;
    private javax.swing.JMenuItem jMenuItem_AddProfes;
    private javax.swing.JMenuItem jMenuItem_AsignarAlumnos;
    private javax.swing.JMenuItem jMenuItem_VerAlumnos;
    private javax.swing.JMenuItem jMenuItem_VerCalendario;
    private javax.swing.JMenuItem jMenuItem_VerClases;
    private javax.swing.JMenuItem jMenuItem_VerColes;
    private javax.swing.JMenuItem jMenuItem_VerProfes;
    private javax.swing.JMenu jMenuProfesores;
    private javax.swing.JMenu jMenu_icono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

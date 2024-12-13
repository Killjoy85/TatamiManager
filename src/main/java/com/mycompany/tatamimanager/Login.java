/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tatamimanager;

import com.mycompany.tatamimanager.BBDD.DatabaseControlLogin;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author diana
 */
public class Login extends javax.swing.JFrame {

    String usuario;
    String contrasenya;
    
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/images/dibujo_cinturon.png")).getImage());
    }
    
    //Método para cifrar la contraseña
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
            }
            return hashtext;
            
        }catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
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
        jLabel2 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        btn_Acceso = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 700));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Contraseña:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));
        jPanel1.add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 240, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Introduzca su usuario:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));
        jPanel1.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 240, -1));

        btn_Acceso.setBackground(new java.awt.Color(0, 102, 153));
        btn_Acceso.setForeground(new java.awt.Color(255, 255, 255));
        btn_Acceso.setText("Acceder");
        btn_Acceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AccesoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Acceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 180, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo_1.png"))); // NOI18N
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cinturon2.jpg"))); // NOI18N
        jPanel1.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AccesoActionPerformed
        //inicializar variables
        usuario = txt_user.getText();
        contrasenya = new String(txt_pass.getPassword());
        
        getMD5(contrasenya); //El password le pasamos en texto plano
        System.out.println(getMD5(contrasenya));
        
        if (DatabaseControlLogin.validarCredenciales(usuario, getMD5(contrasenya))) { 
            new Inicio().setVisible(true);
            dispose(); // Cierra el frame de login 
        } else { JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE); }
    }//GEN-LAST:event_btn_AccesoActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Acceso;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
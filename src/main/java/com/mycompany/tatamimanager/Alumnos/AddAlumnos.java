                                                                                                                                                                                          /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tatamimanager.Alumnos;

import com.mycompany.tatamimanager.BBDD.DatabaseControlAlumnos;
import com.mycompany.tatamimanager.BBDD.DatabaseManager;
import com.mycompany.tatamimanager.Inicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author diana
 */
public class AddAlumnos extends javax.swing.JPanel {

    private String nombreAlumno;
    private String apellidos;
    private String curso; 
    private int anyo; 
    private String colegio;
    private JComboBox<ColegioItem> comboBox_colegios;
    private String nombreTutor;
    private int telf;
    private String correo;
    private String cinturon;
    private int id; 
    public boolean isUpdate = false;

     /**
     * Creates new form Panel_AddAlumnos
     */
    public JButton getBtn_GuardarAlumno() {
        return btn_GuardarAlumno;
    }

    public JComboBox<ColegioItem> getComboBox_colegios() {
        return comboBox_colegios;
    }

    public JTextField getTxt_anyo() {
        return txt_anyo;
    }

    public JTextField getTxt_apell() {
        return txt_apell;
    }

    public JTextField getTxt_correo() {
        return txt_correo;
    }

    public JTextField getTxt_curso() {
        return txt_curso;
    }

    public JTextField getTxt_nombre() {
        return txt_nombre;
    }

    public JTextField getTxt_telf() {
        return txt_telf;
    }

    public JTextField getTxt_tutor() {
        return txt_tutor;
    }

    
    /**
     * Creates new form Panel_AddAlumnos
     */
    public AddAlumnos() {
        initComponents();
        comboBox_colegios = new JComboBox<>();
        this.add(comboBox_colegios);
        comboBox_colegios.setBounds(348, 233, 210, 25);
        mostrarColegios(comboBox_colegios);
    }

    public void vaciarCampos(){
        txt_nombre.setText("");
        txt_apell.setText("");
        txt_anyo.setText("");
        txt_curso.setText("");
        txt_tutor.setText("");
        txt_telf.setText("");
        txt_correo.setText("");
        txt_cinturon.setText("");
    }
    
    public static void mostrarColegios(JComboBox comboBox_colegios){
        comboBox_colegios.removeAllItems();
        // Agregar un elemento especial como primer texto
        comboBox_colegios.addItem(new ColegioItem(-1, "Selecciona un colegio"));
        String query = "SELECT id_colegio, nombre FROM colegios";
        
         try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
             
            while (rs.next()) {
                int id = rs.getInt("id_colegio");
                String nombre = rs.getString("nombre");

                // Crear un objeto de ColegioItem y añadirlo al combo box
                ColegioItem item = new ColegioItem(id, nombre);
                comboBox_colegios.addItem(item);
            }
             
         } catch (SQLException ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar los colegios en el comboBox: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(AddAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int obtenerIdColegioSeleccionado(JComboBox<ColegioItem> comboBox_colegios) {
        ColegioItem seleccionado = (ColegioItem) comboBox_colegios.getSelectedItem();
        if (seleccionado != null) {
            return seleccionado.getId();
        } else {
            throw new IllegalStateException("No hay colegio seleccionado.");
        }
    }

    public boolean validarDatos(){
            // Verificar si los campos están vacíos
        if (txt_nombre.getText().trim().isEmpty() || txt_apell.getText().trim().isEmpty() 
                || txt_curso.getText().trim().isEmpty() || 
            txt_anyo.getText().trim().isEmpty() || txt_tutor.getText().trim().isEmpty() 
                || txt_telf.getText().trim().isEmpty() || 
            txt_correo.getText().trim().isEmpty() || txt_cinturon.getText().trim().isEmpty()) {

            // Mostrar mensaje de advertencia
            JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(comboBox_colegios.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un colegio.", "Colegio sin seleccionar", JOptionPane.WARNING_MESSAGE);
            return false;        
        } else {
            // Validar y asignar los valores
            nombreAlumno = txt_nombre.getText().trim();
            apellidos = txt_apell.getText().trim();
            curso = txt_curso.getText().trim();
            nombreTutor = txt_tutor.getText().trim();
            cinturon = txt_cinturon.getText().trim();
            
            // Validar que el año sea un número y tenga 4 dígitos
            String anyoTexto = txt_anyo.getText().trim(); 
            if ( !anyoTexto.matches("\\d{4}")) { 
                JOptionPane.showMessageDialog(null, "El año de nacimiento debe ser un número de 4 dígitos.", "Error en el Año", JOptionPane.ERROR_MESSAGE);
                return false; // Salir del método si la validación falla
            }
            anyo = Integer.parseInt(anyoTexto); // asignar cp
            // Validar que el año esté en el rango permitido (entre 2010 y 2017)
            if (anyo < 2010 || anyo > 2021) {
                JOptionPane.showMessageDialog(null, "El año es incorrecto, asegurese de introducir el año bien.", "Error en el Año", JOptionPane.ERROR_MESSAGE);
                return false; // Salir del método si la validación falla
            }
            // Validar que el telefono sea un número y tenga 9 dígitos
            String telefono = txt_telf.getText().trim();
            if (!telefono.matches("\\d{9}")) {
                JOptionPane.showMessageDialog(null, "El teléfono debe ser un número de 9 dígitos", "Error en el Teléfono", JOptionPane.ERROR_MESSAGE);
                return false; // Salir del método si la validación falla
            } 
            telf = Integer.parseInt(txt_telf.getText().trim()); //asignat telf

            correo = txt_correo.getText().trim();        //-------------------------  COMPROBAR CORREO
            if(!isUpdate){
                // Mensaje de éxito
                JOptionPane.showMessageDialog(null, "Todos los datos han sido ingresados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return true;
    }
    
    public void actualizarDatos(int idAlumno, String nombreAlumno, String apellAlumno, String cursoAlumno, int anyoAlumno, String tutorAlumno,
                                int telefonoAlumno, String correoAlumno, String cinturonAlumno, int coleAlumno){
        isUpdate = true;
        id = idAlumno;
        txt_nombre.setText(nombreAlumno);
        txt_apell.setText(apellAlumno);
        txt_curso.setText(cursoAlumno);
        txt_anyo.setText(Integer.toString(anyoAlumno));
        txt_tutor.setText(tutorAlumno);
        txt_telf.setText(Integer.toString(telefonoAlumno));
        txt_correo.setText(correoAlumno);
        txt_cinturon.setText(cinturonAlumno);
        
         // Buscar el ColegioItem por ID y seleccionarlo en el JComboBox
        for (int i = 0; i < comboBox_colegios.getItemCount(); i++) {
            ColegioItem item = (ColegioItem) comboBox_colegios.getItemAt(i);
            if (item.getId() == coleAlumno) {
                comboBox_colegios.setSelectedItem(item);
                break;
            }
        }
        
        lb_titulo.setText("Modificar Alumno");
        btn_GuardarAlumno.setText("Modificar Alumno");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_titulo = new javax.swing.JLabel();
        lb_nombre = new javax.swing.JLabel();
        lb_apell = new javax.swing.JLabel();
        lb_tutor = new javax.swing.JLabel();
        txt_apell = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_tutor = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_anyo = new javax.swing.JTextField();
        lb_telf = new javax.swing.JLabel();
        lb_anyo = new javax.swing.JLabel();
        lb_cole = new javax.swing.JLabel();
        txt_curso = new javax.swing.JTextField();
        lb_curso = new javax.swing.JLabel();
        btn_GuardarAlumno = new javax.swing.JButton();
        lb_correo = new javax.swing.JLabel();
        txt_telf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_cinturon = new javax.swing.JTextField();
        lb_cinturon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(750, 550));

        lb_titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_titulo.setText("Añadir Alumno");

        lb_nombre.setText("Nombre:");

        lb_apell.setText("Apellidos:");

        lb_tutor.setText("Nombre padre/madre/tutor:");

        lb_telf.setText("Teléfono de contacto:");

        lb_anyo.setText("Año de nacimiento:");

        lb_cole.setText("Colegio:");

        lb_curso.setText("Curso:");

        btn_GuardarAlumno.setBackground(new java.awt.Color(0, 102, 204));
        btn_GuardarAlumno.setForeground(new java.awt.Color(255, 255, 255));
        btn_GuardarAlumno.setText("Guardar Alumno");
        btn_GuardarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarAlumnoActionPerformed(evt);
            }
        });

        lb_correo.setText("Correo electrónico:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo_1.png"))); // NOI18N

        lb_cinturon.setText("Cinturón:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(lb_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lb_anyo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_anyo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_apell, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_nombre)
                                    .addComponent(txt_apell)
                                    .addComponent(txt_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_cole)
                                    .addComponent(lb_tutor)
                                    .addComponent(lb_telf)
                                    .addComponent(lb_correo)
                                    .addComponent(lb_cinturon))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_cinturon)
                                    .addComponent(txt_tutor)
                                    .addComponent(txt_telf)
                                    .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(btn_GuardarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lb_titulo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_nombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_apell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_apell))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_curso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_anyo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_anyo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_cole)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_tutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_telf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_telf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_correo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cinturon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_cinturon))
                .addGap(18, 18, 18)
                .addComponent(btn_GuardarAlumno)
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GuardarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarAlumnoActionPerformed
        if (!validarDatos()) {
            return; // Si alguna validación falla, detener la ejecución
        }
        
        int idColegio = obtenerIdColegioSeleccionado(comboBox_colegios);
        
        if(!isUpdate){ 
            //si estoy añadiendo colegio
            DatabaseControlAlumnos.guardarAlumno(nombreAlumno, apellidos, curso, anyo, nombreTutor, telf, correo, cinturon, idColegio);
            
        }else{  
            //si estoy modificando
            DatabaseControlAlumnos.editarAlumno(nombreAlumno, apellidos, curso, anyo, nombreTutor, telf, correo, cinturon, idColegio, id);
        }
        
        isUpdate = false; //volvemoa a establecer isUpdate como false
        
        //cambiar panel a listaColegios
        JFrame frameInicio = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frameInicio instanceof Inicio) {
            ListaAlumnos nuevoPanel = new ListaAlumnos(); // Nueva instancia
            nuevoPanel.iniTabla();
            ((Inicio) frameInicio).cambiarPanel(nuevoPanel);
            //((Inicio) frameInicio).cambiarPanel(new ListaAlumnos());
        }
        
    }//GEN-LAST:event_btn_GuardarAlumnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_GuardarAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_anyo;
    private javax.swing.JLabel lb_apell;
    private javax.swing.JLabel lb_cinturon;
    private javax.swing.JLabel lb_cole;
    private javax.swing.JLabel lb_correo;
    private javax.swing.JLabel lb_curso;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JLabel lb_telf;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JLabel lb_tutor;
    private javax.swing.JTextField txt_anyo;
    private javax.swing.JTextField txt_apell;
    private javax.swing.JTextField txt_cinturon;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_curso;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telf;
    private javax.swing.JTextField txt_tutor;
    // End of variables declaration//GEN-END:variables
}

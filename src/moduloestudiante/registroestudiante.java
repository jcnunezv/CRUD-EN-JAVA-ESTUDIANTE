package moduloestudiante;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import moduloestudiante.Conexion;
import java.sql.CallableStatement;

/**
 *
 * @author Hp
 */
public class registroestudiante extends javax.swing.JInternalFrame {

    private ArrayList<estudiantes> list;
    estudiantes a;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps;
    //String url = ("jdbc:sqlite:C:\\Estudiantes.db");
    //String driver= "jdbc.sqlite.Driver";

    /**
     * Creates new form registroestudiante
     */
    public registroestudiante() throws ClassNotFoundException {
        list = new ArrayList<>();
        initComponents();
        cargaDatos();
        con = Conexion.ConectarBD();
        //guardarBD();
        //EliminarData();
        //UpdateTabla();

    }

    public void guardarBD() {
        try {
            Eliminar();

            //Conexion.ConectarBD();
            //rs.getMetaData();
            for (int i = 0; i < jtreg.getRowCount(); i++) {

                ps = con.prepareStatement("INSERT INTO Estudiante VALUES (?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, jtreg.getValueAt(i, 0).toString());
                ps.setString(2, jtreg.getValueAt(i, 1).toString());
                ps.setString(3, jtreg.getValueAt(i, 2).toString());
                ps.setString(4, jtreg.getValueAt(i, 3).toString());
                ps.setString(5, jtreg.getValueAt(i, 4).toString());
                //ps.setInt(6, jtreg.);
                ps.setString(6, jtreg.getValueAt(i, 5).toString());
                ps.setString(7, jtreg.getValueAt(i, 6).toString());
                ps.setString(8, jtreg.getValueAt(i, 7).toString());
                ps.setString(9, jtreg.getValueAt(i, 8).toString());
                ps.setString(10, jtreg.getValueAt(i, 9).toString());
                ps.executeUpdate();
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.print(e.getMessage());
        }
    }

    private void UpdateTabla() {
        try {
            for (int i = 0; i < jtreg.getRowCount(); i++) {

                ps = con.prepareStatement("UPDATE FROM Estudiante SET Codigo,Nombre,Apellido,Fecha de Nacimiento,Cedula,Telefono,Nacionalidad,Tipo,Carrera,Fecha de Registro VALUES(?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, jtreg.getValueAt(i, 0).toString());
                ps.setString(2, jtreg.getValueAt(i, 1).toString());
                ps.setString(3, jtreg.getValueAt(i, 2).toString());
                ps.setString(4, jtreg.getValueAt(i, 3).toString());
                ps.setString(5, jtreg.getValueAt(i, 4).toString());
                ps.setString(6, jtreg.getValueAt(i, 5).toString());
                ps.setString(7, jtreg.getValueAt(i, 6).toString());
                ps.setString(8, jtreg.getValueAt(i, 7).toString());
                ps.setString(9, jtreg.getValueAt(i, 8).toString());
                ps.setString(10, jtreg.getValueAt(i, 9).toString());
                ps.executeUpdate();
                guardarBD();
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private void EliminarData() {
        try {
            int column = 0;
            int row = jtreg.getSelectedRow();
            

            
            
            String value = jtreg.getModel().getValueAt(row, column).toString();
            ps = con.prepareStatement("DELETE FROM Estudiante WHERE Codigo =?");
            JOptionPane.showMessageDialog(null, jtreg.getValueAt(row, 0).toString());
            ps.setString(1, jtreg.getValueAt(row, 0).toString());
            ps.executeUpdate();
            list.remove(row);
            jtreg.remove(jtreg.getSelectedRow());
            grabar();
            
            
        } catch (Exception e) {
            //System.out.print(e.getMessage());
             //JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    private void Eliminar() {
        try {
           
            
       
            ps = con.prepareStatement("DELETE FROM Estudiante");
            
            ps.executeUpdate();

            
        } catch (Exception e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void limpiar() {
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
        txt7.setText("");
        txt8.setText("");
        txt9.setText("");
        txt10.setText("");
    }

    private void top5() {
        estudiantes arre[];
        String listing = "";
        if (!list.isEmpty()) {
            for (int i = 0; i <= 4; i++) {

                listing += (i + 1) + "º- " + " REGISTRO:       " + list.get(i).getCodrg()
                        + "\n" + "       NOMBRE:    " + list.get(i).getNombre()
                        + "\n" + "       PROMEDIO:       " + list.get(i).getTipo() + "\n\n";
            }
            JOptionPane.showMessageDialog(null, listing);

        } else {
            JOptionPane.showMessageDialog(null, "           LISTA DE TOP 5 ", "", JOptionPane.WARNING_MESSAGE);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        txt3 = new javax.swing.JTextField();
        txt4 = new javax.swing.JTextField();
        txt6 = new javax.swing.JTextField();
        txt5 = new javax.swing.JTextField();
        txt8 = new javax.swing.JTextField();
        txt7 = new javax.swing.JTextField();
        txt10 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt9 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtreg = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        registrar = new javax.swing.JButton();
        savesqlite = new javax.swing.JButton();
        top5 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE ESTUDIANTES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("# REGISTRO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRE");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("APELLIDOS");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("FECHA DE NAC");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("#.CEDULA");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("NACIONALIDAD");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TELEFONO");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PROMEDIO");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CARRERA");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("FECHA DE REG");

        jtreg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtreg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#REG", "NOMBRE", "APELLIDOS", "FECHA NAC", "#.CEDULA", "TLF", "NACIONALIDAD", "TIPO DE ESTUD", "CARRERA", "FECHA REG"
            }
        ));
        jScrollPane1.setViewportView(jtreg);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("UNIVERSIDA TECNOLOGICA BRAZER");

        save.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        save.setText("GUARDAR BIN");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buscar.setText("BUSCAR");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eliminar.setText("ELIMINAR");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        modificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        modificar.setText("MODIFICAR");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        registrar.setText("REGISTRAR");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        savesqlite.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        savesqlite.setText("GUARDAR SQLITE");
        savesqlite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savesqliteActionPerformed(evt);
            }
        });

        top5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        top5.setText("TOP 5");
        top5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                top5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(232, 232, 232)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(registrar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(savesqlite)
                        .addGap(12, 12, 12)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificar)
                        .addGap(18, 18, 18)
                        .addComponent(top5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(395, 395, 395))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscar)
                            .addComponent(save)
                            .addComponent(eliminar)
                            .addComponent(modificar)
                            .addComponent(savesqlite)
                            .addComponent(top5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(registrar)))
                .addGap(51, 51, 51)
                .addComponent(jLabel5)
                .addContainerGap(588, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        int c, tlf;

        estudiantes aux;
        try {
            c = jtreg.getSelectedRow();
            aux = list.get(c);
            String codrg = JOptionPane.showInputDialog("ingrese nuevo codigo:");
            String nombre = JOptionPane.showInputDialog("Ingrese nuevo nombre:");
            String apellido = JOptionPane.showInputDialog("Ingrese nuevo apellido:");
            String fechanaci = JOptionPane.showInputDialog("Ingrese nueva fecha de nacimiento:");
            String ced = JOptionPane.showInputDialog("Ingrese nuevo numero de cedula:");
            tlf = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo numero de telefono:"));
            String nacionalidad = JOptionPane.showInputDialog("Ingrese nueva nacionalidad:");
            String tipo = JOptionPane.showInputDialog("Ingrese nuevo promedio de estudiante:");
            String carrera = JOptionPane.showInputDialog("Ingrese nueva carrera:");
            String fechareg = JOptionPane.showInputDialog("Ingrese nueva fecha de registro:");
            aux.setCodrg(codrg);
            aux.setNombre(nombre);
            aux.setApeliido(apellido);
            aux.setFechanaci(fechanaci);
            aux.setCed(ced);
            aux.setTlf(tlf);
            aux.setNacionalidad(nacionalidad);
            aux.setTipo(tipo);
            aux.setCarrera(carrera);
            aux.setFechareg(fechareg);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "porfavor escoja la fila");
        }
        verdatos();

    }//GEN-LAST:event_modificarActionPerformed
    public void grabar() {
        JOptionPane.showMessageDialog(null, "Grabado correctamente");
        try {
            FileOutputStream fos = new FileOutputStream("estudiante.dat");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            //JOptionPane.showMessageDialog(null, "ingresando1");
            if (out != null) {
                out.writeObject(list);
                out.close();
            }
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "ingresando2");
            System.out.println(ex.getMessage());
        }
    }

    public void cargaDatos() {
        try {
            FileInputStream fis = new FileInputStream("estudiante.dat");
            ObjectInputStream in = new ObjectInputStream(fis);
            if (in != null) {
                list = (ArrayList<estudiantes>) in.readObject();
                String matriz[][] = new String[list.size()][10];

                if (list != null && list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {

                        estudiantes aux = list.get(i);
                        matriz[i][0] = aux.getCodrg();
                        matriz[i][1] = aux.getNombre();
                        matriz[i][2] = aux.getApeliido();
                        matriz[i][3] = aux.getFechanaci();
                        matriz[i][4] = aux.getCed();
                        matriz[i][5] = Integer.toString(aux.getTlf());
                        matriz[i][6] = aux.getNacionalidad();
                        matriz[i][7] = aux.getTipo();
                        matriz[i][8] = aux.getCarrera();
                        matriz[i][9] = aux.getFechareg();
                    }
                    jtreg.setModel(new javax.swing.table.DefaultTableModel(
                            matriz,
                            new String[]{
                                "#REG", "NOMBRE", "APELLIDOS", "FECHA NAC", "#.CEDULA", "TLF", "NACIONALIDAD", "PROMEDIO", "CARRERA", "FECHA REG"
                            }
                    ));

                }

            }
            in.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "aa" + ex.getLocalizedMessage());
        }
    }


    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int c;
       EliminarData();
        verdatos();
       
        UpdateTabla();

        //EliminarData();
    }//GEN-LAST:event_eliminarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String search_result = "Registro no encontrado vuelva intentarlo";

        String searched_name = JOptionPane.showInputDialog("Ingrese el registro a buscar");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCodrg().equals(searched_name)) {
                search_result = "";

                search_result += "\n" + "NOMBRE: " + list.get(i).getNombre() + "\n"
                        + "\n" + "APELLIDO: " + list.get(i).getApeliido() + "\n"
                        + "\n" + "FECHA NACIMIENTO: " + list.get(i).getFechanaci() + "\n"
                        + "\n" + "CEDULA: " + list.get(i).getCed() + "\n"
                        + "\n" + "NACIONALIDAD: " + list.get(i).getNacionalidad() + "\n"
                        + "\n" + "TIPO DE ESTUDIANTE: " + list.get(i).getTipo() + "\n"
                        + "\n" + "CARRERA: " + list.get(i).getCarrera() + "\n"
                        + "\n" + "TELEDONO: " + list.get(i).getTlf() + "\n"
                        + "\n" + "FECHA DE REGISTRO: " + list.get(i).getFechareg() + "\n";
            }
        }

        JOptionPane.showMessageDialog(null, search_result);
    }//GEN-LAST:event_buscarActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String b[] = {"si", "no"};
        int n = JOptionPane.showOptionDialog(null, "Desea Guardar La informacion", "Desea salir", 0, 0, null, b, null);
        if (n == 0) {
            grabar();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        String codrg;
        String nombre;
        String apeliido;
        String fechanaci;
        String ced;
        int tlf;
        String nacionalidad;
        String tipo;
        String carrera;
        String fechareg;
        try {
            codrg = txt1.getText();
            nombre = txt2.getText();
            apeliido = txt3.getText();
            fechanaci = txt4.getText();
            ced = txt5.getText();
            tlf = Integer.parseInt(txt6.getText());
            nacionalidad = txt7.getText();
            tipo = txt8.getText();
            carrera = txt9.getText();
            fechareg = txt10.getText();
            list.add(new estudiantes(codrg, nombre, apeliido, fechanaci, ced, tlf, nacionalidad, tipo, carrera, fechareg));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro Guardado Exitosamente");
        }
        limpiar();
        verdatos();
    }//GEN-LAST:event_registrarActionPerformed

    private void savesqliteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savesqliteActionPerformed
 String b[] = {"si", "no"};
        int n = JOptionPane.showOptionDialog(null, "Desea Guardar La informacion", "Desea salir", 0, 0, null, b, null);
        if (n == 0) {
        guardarBD();
        UpdateTabla();
        }
      

        //UpdateTabla();
        /*try
     {
         con.getMetaData();
         for (int i=0; i<jtreg.getRowCount();i++)
         {
             ps= con.prepareStatement("INSERT INTO Estudiantes VALUES (?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, jtreg.getValueAt(i, 0).toString());
             ps.setString(2, jtreg.getValueAt(i, 1).toString());
             ps.setString(3, jtreg.getValueAt(i, 2).toString());
             ps.setString(4, jtreg.getValueAt(i, 3).toString());
             ps.setString(5, jtreg.getValueAt(i, 4).toString());
             //ps.setInt(6, jtreg.);
             ps.setString(6, jtreg.getValueAt(i, 5).toString());
             ps.setString(7, jtreg.getValueAt(i, 6).toString());
             ps.setString(8, jtreg.getValueAt(i, 7).toString());
             ps.setString(9, jtreg.getValueAt(i, 8).toString());
             ps.setString(10, jtreg.getValueAt(i, 9).toString());
             ps.executeUpdate();
         }
     }catch(Exception e)
     {
         System.out.print(e.getMessage());
     }*/

    }//GEN-LAST:event_savesqliteActionPerformed

    private void top5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_top5ActionPerformed
        top5();

        // TODO add your handling code here:
    }//GEN-LAST:event_top5ActionPerformed
    private void verdatos() {
        String matriz[][] = new String[list.size()][10];
        estudiantes aux;
        for (int i = 0; i < list.size(); i++) {
            aux = list.get(i);
            matriz[i][0] = aux.getCodrg();
            matriz[i][1] = aux.getNombre();
            matriz[i][2] = aux.getApeliido();
            matriz[i][3] = aux.getFechanaci();
            matriz[i][4] = aux.getCed();
            matriz[i][5] = Integer.toString(aux.getTlf());
            matriz[i][6] = aux.getNacionalidad();
            matriz[i][7] = aux.getTipo();
            matriz[i][8] = aux.getCarrera();
            matriz[i][9] = aux.getFechareg();
        }
        jtreg.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "#REG", "NOMBRE", "APELLIDOS", "FECHA NAC", "#.CEDULA", "TLF", "NACIONALIDAD", "PROMEDIO", "CARRERA", "FECHA REG"
                }
        ));

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtreg;
    private javax.swing.JButton modificar;
    private javax.swing.JButton registrar;
    private javax.swing.JButton save;
    private javax.swing.JButton savesqlite;
    private javax.swing.JButton top5;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt10;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt7;
    private javax.swing.JTextField txt8;
    private javax.swing.JTextField txt9;
    // End of variables declaration//GEN-END:variables
}

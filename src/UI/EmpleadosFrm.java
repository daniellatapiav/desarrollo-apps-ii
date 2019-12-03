package UI;

import BEAN.Empleado;
import DAO.EmpleadoDAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import util.Util;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import util.dbBean;

public class EmpleadosFrm extends javax.swing.JFrame {
    DefaultTableModel dtm;
    EmpleadoDAO empdao;
    int id, wd, hd, slx, sly;
    Empleado emp;
    
    public Empleado devProd() {
        return this.emp;
    }

    public EmpleadosFrm() {
        initComponents();
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        wd = dim.width;
        hd = dim.height;
        this.setSize(1000, 700);
        slx = (wd/2) - (1000/2);
        sly = (hd/2) - (400);
        this.setLocation(slx, sly);
        this.setResizable(false);
        this.setTitle("Proyecto Integrador - Anampa & Tapia");  

        dtm = (DefaultTableModel) tblPersonal.getModel();
        empdao = new EmpleadoDAO();
        llenaTabla(false, "");
    }

     private void llenaTabla(boolean swr, String cadr) {
         Vector<Empleado> empDao = empdao.listarEmpleados(swr, cadr);

         for(int j = 0; j < empDao.size(); j++) {
            Vector vect = new Vector();
            vect.addElement(empDao.get(j).getId_empleado());
            vect.addElement(empDao.get(j).getApellidos());
            vect.addElement(empDao.get(j).getNombres());
            vect.addElement(empDao.get(j).getTipo());
            vect.addElement(empDao.get(j).getArea());
            vect.addElement(empDao.get(j).getEstado());
            dtm.addRow(vect);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonal = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtBusq = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtApellidos = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox();
        btnLimpiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();
        rbTipo1 = new javax.swing.JRadioButton();
        rbTipo0 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        tiMenu = new javax.swing.JMenu();
        ordenesMenu = new javax.swing.JMenuItem();
        equiposMenu = new javax.swing.JMenuItem();
        repuestosMenu = new javax.swing.JMenuItem();
        fallasMenu = new javax.swing.JMenuItem();
        diagnosticosMenu = new javax.swing.JMenuItem();
        rrhhMenu = new javax.swing.JMenu();
        empleadosMenu = new javax.swing.JMenuItem();
        reportesMenu = new javax.swing.JMenu();
        rPersonalMenu = new javax.swing.JMenuItem();
        rOrdenesMenu = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenu();
        salirMenu = new javax.swing.JMenuItem();

        getContentPane().setLayout(null);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel3.setLayout(null);

        tblPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Apellidos", "Nombres", "Tipo", "Área", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPersonalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPersonal);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(25, 100, 900, 310);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEditar);
        btnEditar.setBounds(400, 430, 150, 50);

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setText("Búsqueda por nombres o apellidos");
        jLabel8.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel8AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel3.add(jLabel8);
        jLabel8.setBounds(25, 30, 300, 30);

        txtBusq.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtBusq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusqActionPerformed(evt);
            }
        });
        txtBusq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusqKeyReleased(evt);
            }
        });
        jPanel3.add(txtBusq);
        txtBusq.setBounds(340, 30, 200, 30);

        jTabbedPane1.addTab("Consulta", jPanel3);

        jPanel4.setLayout(null);

        jLabel3.setText("Apellidos");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(25, 30, 100, 30);

        jLabel4.setText("Nombres");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(25, 80, 100, 30);

        jLabel5.setText("Estado");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(25, 230, 100, 30);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel4.add(btnRegistrar);
        btnRegistrar.setBounds(500, 430, 150, 50);

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosKeyPressed(evt);
            }
        });
        jPanel4.add(txtApellidos);
        txtApellidos.setBounds(160, 30, 250, 30);
        jPanel4.add(txtNombres);
        txtNombres.setBounds(160, 80, 250, 30);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No activo", "Activo" }));
        jPanel4.add(cmbEstado);
        cmbEstado.setBounds(160, 230, 250, 30);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel4.add(btnLimpiar);
        btnLimpiar.setBounds(330, 430, 150, 50);

        jLabel6.setText("Tipo");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(25, 130, 100, 30);

        jLabel7.setText("Área");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(25, 180, 100, 30);
        jPanel4.add(txtArea);
        txtArea.setBounds(160, 180, 250, 30);

        buttonGroup1.add(rbTipo1);
        rbTipo1.setText("Docente");
        jPanel4.add(rbTipo1);
        rbTipo1.setBounds(300, 130, 150, 30);

        buttonGroup1.add(rbTipo0);
        rbTipo0.setText("Administrativo");
        rbTipo0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTipo0ActionPerformed(evt);
            }
        });
        jPanel4.add(rbTipo0);
        rbTipo0.setBounds(160, 130, 150, 30);

        jTabbedPane1.addTab("Nuevo", jPanel4);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 110, 960, 530);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Empleados");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 40, 1000, 50);

        tiMenu.setText("TI");

        ordenesMenu.setText("Órdenes");
        ordenesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenesMenuActionPerformed(evt);
            }
        });
        tiMenu.add(ordenesMenu);

        equiposMenu.setText("Equipos");
        equiposMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equiposMenuMouseClicked(evt);
            }
        });
        equiposMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equiposMenuActionPerformed(evt);
            }
        });
        tiMenu.add(equiposMenu);

        repuestosMenu.setText("Repuestos");
        repuestosMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repuestosMenuActionPerformed(evt);
            }
        });
        tiMenu.add(repuestosMenu);

        fallasMenu.setText("Fallas");
        fallasMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fallasMenuActionPerformed(evt);
            }
        });
        tiMenu.add(fallasMenu);

        diagnosticosMenu.setText("Diagnósticos");
        diagnosticosMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnosticosMenuActionPerformed(evt);
            }
        });
        tiMenu.add(diagnosticosMenu);

        jMenuBar1.add(tiMenu);

        rrhhMenu.setText("RRHH");
        rrhhMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rrhhMenuActionPerformed(evt);
            }
        });

        empleadosMenu.setText("Empleados");
        empleadosMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empleadosMenuActionPerformed(evt);
            }
        });
        rrhhMenu.add(empleadosMenu);

        jMenuBar1.add(rrhhMenu);

        reportesMenu.setText("Reportes");

        rPersonalMenu.setText("Personal");
        rPersonalMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rPersonalMenuActionPerformed(evt);
            }
        });
        reportesMenu.add(rPersonalMenu);

        rOrdenesMenu.setText("Órdenes");
        rOrdenesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rOrdenesMenuActionPerformed(evt);
            }
        });
        reportesMenu.add(rOrdenesMenu);

        jMenuBar1.add(reportesMenu);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        salirMenu.setText("Cerrar sesión");
        salirMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuActionPerformed(evt);
            }
        });
        salir.add(salirMenu);

        jMenuBar1.add(salir);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged

    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        limpiaControl();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
            getFocusOwner().transferFocus();
        }

    }//GEN-LAST:event_txtApellidosKeyPressed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String proc = btnRegistrar.getText();
        int est;
        String pr= "";
        
        if(valida() == true) {
            Util u = new Util();
            
            Empleado p = new Empleado();
            p.setApellidos(txtApellidos.getText());
            p.setNombres(this.txtNombres.getText());
            
            if(this.rbTipo0.isSelected()) {
                p.setTipo(0);
            } else if(this.rbTipo1.isSelected()) {
                p.setTipo(1);
            }
            
            p.setArea(txtArea.getText());
            
            est = u.estados(this.cmbEstado.getSelectedItem().toString()); 
            p.setEstado(est);
            
            if (proc.equals("Registrar")) {
                id = u.idNext("Empleados", "id_empleado");
                pr = "insert";
            }
            if(proc.equals("Actualizar")) {
                id = this.id;
                pr = "update";
            }
            
            p.setId_empleado(id);
            empdao.registrarEmpleado(p, pr);
            limpiaControles();
            LimpiaTabla();
            llenaTabla(false, "");
            jTabbedPane1.setSelectedIndex(0);
            JOptionPane.showMessageDialog(this, "Empleado registrado exitosamente.");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tblPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonalMouseClicked
        if(evt.getClickCount()==1){
            llenaModifica();
        }
    }//GEN-LAST:event_tblPersonalMouseClicked

    private void jLabel8AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel8AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8AncestorAdded

    private void txtBusqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusqActionPerformed

    }//GEN-LAST:event_txtBusqActionPerformed

    private void txtBusqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusqKeyReleased
        dtm.setRowCount(0);

        String filtro = txtBusq.getText();
        if(filtro.isEmpty()) {
            llenaTabla(false, "");
        } else {
            llenaTabla(true, filtro);
        }
    }//GEN-LAST:event_txtBusqKeyReleased

    private void rbTipo0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTipo0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbTipo0ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void ordenesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenesMenuActionPerformed
        OrdenesFrm ordenesFrm = new OrdenesFrm();
        ordenesFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ordenesMenuActionPerformed

    private void equiposMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equiposMenuMouseClicked

    }//GEN-LAST:event_equiposMenuMouseClicked

    private void equiposMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equiposMenuActionPerformed
        EquiposFrm equiposFrm = new EquiposFrm();
        equiposFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_equiposMenuActionPerformed

    private void repuestosMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repuestosMenuActionPerformed
        RepuestosFrm repuestosFrm = new RepuestosFrm();
        repuestosFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_repuestosMenuActionPerformed

    private void fallasMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fallasMenuActionPerformed
        FallasFrm fallasFrm = new FallasFrm();
        fallasFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_fallasMenuActionPerformed

    private void diagnosticosMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagnosticosMenuActionPerformed
        DiagnosticosFrm diagnosticosFrm = new DiagnosticosFrm();
        diagnosticosFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_diagnosticosMenuActionPerformed

    private void empleadosMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empleadosMenuActionPerformed
        EmpleadosFrm empleadosFrm = new EmpleadosFrm();
        empleadosFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_empleadosMenuActionPerformed

    private void rrhhMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rrhhMenuActionPerformed

    }//GEN-LAST:event_rrhhMenuActionPerformed

    private void rPersonalMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rPersonalMenuActionPerformed
        try {
            String r = "src/REPORTES/repEmpleadosSimp.jasper";
            dbBean db = new dbBean();
            db.connectRep(r, null, false);
        } catch(JRException e) {
            e.printStackTrace();
            Logger.getLogger(OrdenesFrm.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(OrdenesFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rPersonalMenuActionPerformed

    private void rOrdenesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rOrdenesMenuActionPerformed
        try {
            String r = "src/REPORTES/repOrdenesSimple.jasper";
            dbBean db = new dbBean();
            db.connectRep(r, null, false);
        } catch(JRException e) {
            e.printStackTrace();
            Logger.getLogger(OrdenesFrm.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(OrdenesFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rOrdenesMenuActionPerformed

    private void salirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirMenuActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed

    }//GEN-LAST:event_salirActionPerformed
    
    private void limpiaControl(){
        txtApellidos.setText("");
        txtNombres.setText("");
        rbTipo0.setSelected(false);
        rbTipo1.setSelected(false);
        txtArea.setText("");
        cmbEstado.setSelectedIndex(0);
        btnRegistrar.setText("Registrar");
        txtApellidos.requestFocus();
    }
    private boolean valida(){
        boolean sw = false;
        if(txtApellidos.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe registrar APELLIDOS del empleado","Módulo de aplicación EMPLEADO",JOptionPane.ERROR_MESSAGE);
            txtApellidos.requestFocusInWindow();
        } else if(txtNombres.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe registrar NOMBRES del personal","Módulo de aplicación PERSONAL",JOptionPane.ERROR_MESSAGE);
            txtNombres.requestFocusInWindow();
        } else if(!this.rbTipo0.isSelected() && !this.rbTipo1.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debe registrar el TIPO del personal","Módulo de aplicación PERSONAL",JOptionPane.ERROR_MESSAGE);
        } else if(this.txtArea.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe registrar ÁREA del personal","Módulo de aplicación PERSONAL",JOptionPane.ERROR_MESSAGE);
            txtArea.requestFocusInWindow();
        } else {
            sw = true;
        }
        
        return sw;
    }

    private void limpiaControles(){
        txtApellidos.setText("");
        txtNombres.setText("");
        txtArea.setText("");
        txtBusq.setText("");
        cmbEstado.setSelectedIndex(0);
        btnRegistrar.setText("Registrar");
        txtApellidos.requestFocus(true);
    }

    private void llenaModifica(){
        int fila = tblPersonal.getSelectedRow();
        id = Integer.parseInt((dtm.getValueAt(fila, 0)).toString().trim());
        txtApellidos.setText(((String)dtm.getValueAt(fila, 1)).trim());
        txtNombres.setText(((String)dtm.getValueAt(fila, 2)).trim());
        if(Integer.parseInt(dtm.getValueAt(fila, 3).toString().trim()) == 0) {
            this.rbTipo0.setSelected(true);
        } else if(Integer.parseInt(dtm.getValueAt(fila, 3).toString().trim()) == 1) {
            this.rbTipo1.setSelected(true);
        }
        txtArea.setText((dtm.getValueAt(fila, 4)).toString().trim());
        this.cmbEstado.setSelectedIndex(Integer.parseInt((dtm.getValueAt(fila, 5)).toString().trim()));
        
        
        btnRegistrar.setText("Actualizar");
    }

    public void LimpiaTabla(){
    DefaultTableModel dm=(DefaultTableModel)tblPersonal.getModel();
    if(dm.getRowCount()>0){
        while(dm.getRowCount()>0){
            dm.removeRow(dm.getRowCount()-1);
        }
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JMenuItem diagnosticosMenu;
    private javax.swing.JMenuItem empleadosMenu;
    private javax.swing.JMenuItem equiposMenu;
    private javax.swing.JMenuItem fallasMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem ordenesMenu;
    private javax.swing.JMenuItem rOrdenesMenu;
    private javax.swing.JMenuItem rPersonalMenu;
    private javax.swing.JRadioButton rbTipo0;
    private javax.swing.JRadioButton rbTipo1;
    private javax.swing.JMenu reportesMenu;
    private javax.swing.JMenuItem repuestosMenu;
    private javax.swing.JMenu rrhhMenu;
    private javax.swing.JMenu salir;
    private javax.swing.JMenuItem salirMenu;
    private javax.swing.JTable tblPersonal;
    private javax.swing.JMenu tiMenu;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtBusq;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables

}

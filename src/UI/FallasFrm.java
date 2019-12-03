package UI;

import BEAN.Falla;
import DAO.EmpleadoDAO;
import DAO.FallaDAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import util.Util;
import util.dbBean;

public class FallasFrm extends javax.swing.JFrame {
    DefaultTableModel dtm;
    FallaDAO falDAO;
    int id, wd, hd, slx, sly;
    
  public FallasFrm() {
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
        falDAO = new FallaDAO();
        llenaTabla(false, "");
    }
    private void llenaTabla(boolean swr, String cadr) {
         Vector<Falla> fallDao = falDAO.listarFallas(swr, cadr);

         for(int j = 0; j < fallDao.size(); j++){
            Vector vect = new Vector();
            vect.addElement(fallDao.get(j).getId_falla());
            vect.addElement(fallDao.get(j).getTipo_falla());
            vect.addElement(fallDao.get(j).getFalla_desc());
            dtm.addRow(vect);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        tiMenu = new javax.swing.JMenu();
        ordenesMenu = new javax.swing.JMenuItem();
        equiposMenu = new javax.swing.JMenuItem();
        repuestosMenu = new javax.swing.JMenuItem();
        fallasMenu = new javax.swing.JMenuItem();
        diagnosticosMenu = new javax.swing.JMenuItem();
        rrhhMenu = new javax.swing.JMenu();
        empleadosMenu = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenu();
        salirMenu = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonal = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtBusq = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtTipo = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxaDescripcion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar3 = new javax.swing.JMenuBar();
        tiMenu2 = new javax.swing.JMenu();
        ordenesMenu2 = new javax.swing.JMenuItem();
        equiposMenu2 = new javax.swing.JMenuItem();
        repuestosMenu2 = new javax.swing.JMenuItem();
        fallasMenu2 = new javax.swing.JMenuItem();
        diagnosticosMenu2 = new javax.swing.JMenuItem();
        rrhhMenu2 = new javax.swing.JMenu();
        empleadosMenu2 = new javax.swing.JMenuItem();
        reportesMenu = new javax.swing.JMenu();
        rPersonalMenu = new javax.swing.JMenuItem();
        rOrdenesMenu = new javax.swing.JMenuItem();
        salir2 = new javax.swing.JMenu();
        salirMenu2 = new javax.swing.JMenuItem();

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
                "ID", "Tipo", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setText("Búsqueda por tipo o descripción");
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
        jLabel8.setBounds(25, 30, 270, 30);

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
        txtBusq.setBounds(305, 30, 200, 30);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEditar);
        btnEditar.setBounds(400, 430, 150, 50);

        jTabbedPane1.addTab("Consulta", jPanel3);

        jPanel4.setLayout(null);
        jPanel4.add(txtTipo);
        txtTipo.setBounds(160, 30, 250, 30);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel4.add(btnRegistrar);
        btnRegistrar.setBounds(500, 430, 150, 50);

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
        jLabel6.setBounds(25, 30, 100, 30);

        jLabel7.setText("Área");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(25, 80, 100, 30);

        TxaDescripcion.setColumns(20);
        TxaDescripcion.setRows(5);
        jScrollPane2.setViewportView(TxaDescripcion);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(160, 80, 250, 100);

        jTabbedPane1.addTab("Nueva", jPanel4);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 110, 960, 530);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fallas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 40, 1000, 50);

        tiMenu2.setText("TI");

        ordenesMenu2.setText("Órdenes");
        ordenesMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenesMenu2ActionPerformed(evt);
            }
        });
        tiMenu2.add(ordenesMenu2);

        equiposMenu2.setText("Equipos");
        equiposMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equiposMenu2MouseClicked(evt);
            }
        });
        equiposMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equiposMenu2ActionPerformed(evt);
            }
        });
        tiMenu2.add(equiposMenu2);

        repuestosMenu2.setText("Repuestos");
        repuestosMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repuestosMenu2ActionPerformed(evt);
            }
        });
        tiMenu2.add(repuestosMenu2);

        fallasMenu2.setText("Fallas");
        fallasMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fallasMenu2ActionPerformed(evt);
            }
        });
        tiMenu2.add(fallasMenu2);

        diagnosticosMenu2.setText("Diagnósticos");
        diagnosticosMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnosticosMenu2ActionPerformed(evt);
            }
        });
        tiMenu2.add(diagnosticosMenu2);

        jMenuBar3.add(tiMenu2);

        rrhhMenu2.setText("RRHH");
        rrhhMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rrhhMenu2ActionPerformed(evt);
            }
        });

        empleadosMenu2.setText("Empleados");
        empleadosMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empleadosMenu2ActionPerformed(evt);
            }
        });
        rrhhMenu2.add(empleadosMenu2);

        jMenuBar3.add(rrhhMenu2);

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

        jMenuBar3.add(reportesMenu);

        salir2.setText("Salir");
        salir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir2ActionPerformed(evt);
            }
        });

        salirMenu2.setText("Cerrar sesión");
        salirMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenu2ActionPerformed(evt);
            }
        });
        salir2.add(salirMenu2);

        jMenuBar3.add(salir2);

        setJMenuBar(jMenuBar3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonalMouseClicked
        if(evt.getClickCount()==1){
            llenaModifica();
        }
    }//GEN-LAST:event_tblPersonalMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String proc = btnRegistrar.getText();
        String pr= "";
        
        if(valida() == true) {
            Util u = new Util();
            Falla p = new Falla();
            p.setTipo_falla(txtTipo.getText());
            p.setFalla_desc(this.TxaDescripcion.getText());

            if (proc.equals("Registrar")) {
                id = u.idNext("Fallas", "id_falla");
                pr = "insert";
            }
            if(proc.equals("Actualizar")) {
                id = this.id;
                pr = "update";
            }
            
            p.setId_falla(id);
            falDAO.registrarEquipo(p, pr);
            limpiaControl();
            LimpiaTabla();
            llenaTabla(false, "");
            jTabbedPane1.setSelectedIndex(0);
            JOptionPane.showMessageDialog(this, "Falla registrada exitosamente.");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiaControl();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged

    }//GEN-LAST:event_jTabbedPane1StateChanged

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

    private void salirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirMenuActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed

    }//GEN-LAST:event_salirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void ordenesMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenesMenu2ActionPerformed
        OrdenesFrm ordenesFrm = new OrdenesFrm();
        ordenesFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ordenesMenu2ActionPerformed

    private void equiposMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equiposMenu2MouseClicked

    }//GEN-LAST:event_equiposMenu2MouseClicked

    private void equiposMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equiposMenu2ActionPerformed
        EquiposFrm equiposFrm = new EquiposFrm();
        equiposFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_equiposMenu2ActionPerformed

    private void repuestosMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repuestosMenu2ActionPerformed
        RepuestosFrm repuestosFrm = new RepuestosFrm();
        repuestosFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_repuestosMenu2ActionPerformed

    private void fallasMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fallasMenu2ActionPerformed
        FallasFrm fallasFrm = new FallasFrm();
        fallasFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_fallasMenu2ActionPerformed

    private void diagnosticosMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagnosticosMenu2ActionPerformed
        DiagnosticosFrm diagnosticosFrm = new DiagnosticosFrm();
        diagnosticosFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_diagnosticosMenu2ActionPerformed

    private void empleadosMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empleadosMenu2ActionPerformed
        EmpleadosFrm empleadosFrm = new EmpleadosFrm();
        empleadosFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_empleadosMenu2ActionPerformed

    private void rrhhMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rrhhMenu2ActionPerformed

    }//GEN-LAST:event_rrhhMenu2ActionPerformed

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

    private void salirMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenu2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirMenu2ActionPerformed

    private void salir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir2ActionPerformed

    }//GEN-LAST:event_salir2ActionPerformed

    private void limpiaControl(){
        txtTipo.setText("");
        TxaDescripcion.setText("");
        btnRegistrar.setText("Registrar");
        txtTipo.requestFocus();
    }
    
    private boolean valida(){
        boolean sw = false;
        if(txtTipo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe registrar TIPO de FALLA","Módulo de aplicación FALLAS",JOptionPane.ERROR_MESSAGE);
            txtTipo.requestFocusInWindow();
        }else if(TxaDescripcion.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe registrar DESCRIPCIÓN de la falla ","Módulo de aplicación FALLA",JOptionPane.ERROR_MESSAGE);
            TxaDescripcion.requestFocusInWindow();
        } else {
            sw = true;
        }
        
        return sw;
    }


    private void llenaModifica(){
        int fila = tblPersonal.getSelectedRow();
        txtTipo.setText(((String)dtm.getValueAt(fila, 1)).trim());
        TxaDescripcion.setText(((String)dtm.getValueAt(fila, 2)).trim());
        id = Integer.parseInt((dtm.getValueAt(fila, 0)).toString().trim());
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
    private javax.swing.JTextArea TxaDescripcion;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JMenuItem diagnosticosMenu;
    private javax.swing.JMenuItem diagnosticosMenu2;
    private javax.swing.JMenuItem empleadosMenu;
    private javax.swing.JMenuItem empleadosMenu2;
    private javax.swing.JMenuItem equiposMenu;
    private javax.swing.JMenuItem equiposMenu2;
    private javax.swing.JMenuItem fallasMenu;
    private javax.swing.JMenuItem fallasMenu2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem ordenesMenu;
    private javax.swing.JMenuItem ordenesMenu2;
    private javax.swing.JMenuItem rOrdenesMenu;
    private javax.swing.JMenuItem rPersonalMenu;
    private javax.swing.JMenu reportesMenu;
    private javax.swing.JMenuItem repuestosMenu;
    private javax.swing.JMenuItem repuestosMenu2;
    private javax.swing.JMenu rrhhMenu;
    private javax.swing.JMenu rrhhMenu2;
    private javax.swing.JMenu salir;
    private javax.swing.JMenu salir2;
    private javax.swing.JMenuItem salirMenu;
    private javax.swing.JMenuItem salirMenu2;
    private javax.swing.JTable tblPersonal;
    private javax.swing.JMenu tiMenu;
    private javax.swing.JMenu tiMenu2;
    private javax.swing.JTextField txtBusq;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}

package UI;

import BEAN.Diagnostico;
import DAO.DiagnosticoDAO;
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

public class DiagnosticosFrm extends javax.swing.JFrame {
    DefaultTableModel dtm;
    DiagnosticoDAO diaDAO;
    int id, wd, hd, slx, sly;
    
    public DiagnosticosFrm() {
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

        dtm = (DefaultTableModel) tblDiagnostico.getModel();
        diaDAO = new DiagnosticoDAO();
        llenaTabla(false, "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDiagnostico = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtBusq = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxaDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar3 = new javax.swing.JMenuBar();
        tiMenu2 = new javax.swing.JMenu();
        ordenesMenu2 = new javax.swing.JMenuItem();
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

        tblDiagnostico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDiagnostico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDiagnosticoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDiagnostico);

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
        jLabel8.setText("Búsqueda por descripción");
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
        jLabel8.setBounds(25, 30, 209, 30);

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

        jTabbedPane1.addTab("Consulta", jPanel3);

        jPanel4.setLayout(null);

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

        jLabel7.setText("Descripción");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(25, 30, 100, 30);

        TxaDescripcion.setColumns(20);
        TxaDescripcion.setRows(5);
        jScrollPane2.setViewportView(TxaDescripcion);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(160, 30, 250, 100);

        jTabbedPane1.addTab("Nuevo", jPanel4);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 110, 960, 530);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Diagnósticos");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 40, 1000, 50);

        tiMenu2.setText("TI");

        ordenesMenu2.setText("Órdenes");
        ordenesMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenesMenu2ActionPerformed(evt);
            }
        });
        tiMenu2.add(ordenesMenu2);

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
        tiMenu2.add(equiposMenu);

        repuestosMenu.setText("Repuestos");
        repuestosMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repuestosMenuActionPerformed(evt);
            }
        });
        tiMenu2.add(repuestosMenu);

        fallasMenu.setText("Fallas");
        fallasMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fallasMenuActionPerformed(evt);
            }
        });
        tiMenu2.add(fallasMenu);

        diagnosticosMenu.setText("Diagnósticos");
        diagnosticosMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnosticosMenuActionPerformed(evt);
            }
        });
        tiMenu2.add(diagnosticosMenu);

        jMenuBar3.add(tiMenu2);

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

        jMenuBar3.add(rrhhMenu);

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

        jMenuBar3.add(salir);

        setJMenuBar(jMenuBar3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDiagnosticoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDiagnosticoMouseClicked
        if(evt.getClickCount()==1){
            llenaModifica();
        }
    }//GEN-LAST:event_tblDiagnosticoMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String proc = btnRegistrar.getText();
        String pr= "";
        if(valida() == true) {
            Util u = new Util();
            Diagnostico p = new Diagnostico();
            p.setDiag_desc(this.TxaDescripcion.getText());
            if (proc.equals("Registrar")){
                id = u.idNext("Diagnosticos", "id_diagnostico");
                pr = "insert";
            }
            if(proc.equals("Actualizar")){
                id = this.id;
                pr = "update";
            }
            
            p.setId_diagnostico(id);
            diaDAO.registrarDiagnostico(p, pr);
            limpiaControl();
            LimpiaTabla();
            llenaTabla(false, "");
            jTabbedPane1.setSelectedIndex(0);
            JOptionPane.showMessageDialog(this, "Diagnóstico registrado exitosamente.");
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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void ordenesMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenesMenu2ActionPerformed
        OrdenesFrm ordenesFrm = new OrdenesFrm();
        ordenesFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ordenesMenu2ActionPerformed

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

private void llenaTabla(boolean swr, String cadr) {
         Vector<Diagnostico> diagDao = diaDAO.listarDiagnosticos(swr, cadr);
         int i =  diagDao.size();

         for(int j = 0; j<diagDao.size();j++){
            Vector vect = new Vector();
            vect.addElement(diagDao.get(j).getId_diagnostico());
            vect.addElement(diagDao.get(j).getDiag_desc());
            
            dtm.addRow(vect);
        }
    }
private void limpiaControl(){
        
        TxaDescripcion.setText("");
        btnRegistrar.setText("Registrar");
        TxaDescripcion.requestFocus();
    }
    private boolean valida(){
        boolean sw = false;
            if(TxaDescripcion.getText().equals("")){
                sw = false;
                JOptionPane.showMessageDialog(this, "Debe registrar Descripcion de la Diagnotico ","Módulo de aplicación Diagnotico",JOptionPane.ERROR_MESSAGE);
                TxaDescripcion.requestFocusInWindow();
            }else{
                sw = true;
            }
        return sw;
    }



    private void llenaModifica(){
        int fila = tblDiagnostico.getSelectedRow();
        id = Integer.parseInt((dtm.getValueAt(fila, 0)).toString().trim());
        TxaDescripcion.setText(((String)dtm.getValueAt(fila, 1)).trim());
        
        
        btnRegistrar.setText("Actualizar");
    }

    public void LimpiaTabla(){
    DefaultTableModel dm=(DefaultTableModel)tblDiagnostico.getModel();
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
    private javax.swing.JMenuItem empleadosMenu;
    private javax.swing.JMenuItem equiposMenu;
    private javax.swing.JMenuItem fallasMenu;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem ordenesMenu;
    private javax.swing.JMenuItem ordenesMenu1;
    private javax.swing.JMenuItem ordenesMenu2;
    private javax.swing.JMenuItem rOrdenesMenu;
    private javax.swing.JMenuItem rPersonalMenu;
    private javax.swing.JMenu reportesMenu;
    private javax.swing.JMenuItem repuestosMenu;
    private javax.swing.JMenu rrhhMenu;
    private javax.swing.JMenu salir;
    private javax.swing.JMenuItem salirMenu;
    private javax.swing.JTable tblDiagnostico;
    private javax.swing.JMenu tiMenu;
    private javax.swing.JMenu tiMenu1;
    private javax.swing.JMenu tiMenu2;
    private javax.swing.JTextField txtBusq;
    // End of variables declaration//GEN-END:variables
}

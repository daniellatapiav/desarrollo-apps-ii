package UI;

import BEAN.Empleado;
import BEAN.Equipo;
import DAO.EquipoDAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Util;

public class EquiposFrm extends javax.swing.JFrame {
    DefaultTableModel dtm;
    EquipoDAO equiDAO;
    int id, wd, hd, slx, sly;
    Equipo equipo;
    Empleado empleado;
    boolean seleccionUsuario = false;

    public EquiposFrm() {
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
        
        dtm = (DefaultTableModel) this.tblEquipos.getModel();
        equiDAO = new EquipoDAO();
        llenaEquipo(false, "");
    }
    
    public void llenaEquipo(boolean swr, String cadr) {
        Vector<Equipo> listEqui = equiDAO.listarEquipos(swr, cadr);
      
        dtm.setRowCount(0);
        
        for(int i = 0; i < listEqui.size(); i++) {
            Vector vProd = new Vector();
            vProd.addElement(listEqui.get(i).getId_equipo());
            vProd.addElement(listEqui.get(i).getUsuario().getNombreCompleto());
            vProd.addElement(listEqui.get(i).getMarca());
            vProd.addElement(listEqui.get(i).getModelo());
            vProd.addElement(listEqui.get(i).getNum_serie());
            vProd.addElement(listEqui.get(i).getEstado());
            dtm.addRow(vProd);
        }
    }
    
    private boolean valida() {
        boolean sw = false;
        
        if(this.txtMarca.getText().equals("")) {
            sw = false;
            JOptionPane.showMessageDialog(this, "Debe registrar MARCA del equipo","Módulo de aplicación EQUIPO",JOptionPane.ERROR_MESSAGE);
            txtMarca.requestFocusInWindow();
        } else if(this.txtModelo.getText().equals("")) {
            sw = false;
            JOptionPane.showMessageDialog(this, "Debe registrar MODELO del equipo","Módulo de aplicación EQUIPO",JOptionPane.ERROR_MESSAGE);
            this.txtModelo.requestFocusInWindow();
        } else if(this.txtModelo.getText().equals("")) {
            sw = false;
            JOptionPane.showMessageDialog(this, "Debe registrar NRO SERIE del equipo","Módulo de aplicación EQUIPO",JOptionPane.ERROR_MESSAGE);
            this.txtModelo.requestFocusInWindow();
        } else {
            sw = true;
        }
        
        return sw;
    }
    
    private void limpiaControles() {
        empleado = null;
        txtUsuario.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtNroSerie.setText("");
        txtBusq.setText("");
        cmbEstado.setSelectedIndex(0);
        btnRegistrar.setText("Registrar");
        txtMarca.requestFocus(true);
        seleccionUsuario=false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEquipos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtBusq = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox();
        btnLimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNroSerie = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
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
        salir = new javax.swing.JMenu();
        salirMenu = new javax.swing.JMenuItem();

        getContentPane().setLayout(null);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(955, 458));
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel3.setLayout(null);

        tblEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuario", "Marca", "Modelo", "Nro. de serie", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEquiposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEquipos);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(25, 100, 900, 310);

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setText("Búsqueda por marca o modelo");
        jLabel8.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel8AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel3.add(jLabel8);
        jLabel8.setBounds(25, 30, 246, 30);

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

        jLabel3.setText("Marca");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(25, 80, 100, 30);

        jLabel4.setText("Modelo");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(25, 130, 100, 30);

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

        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMarcaKeyPressed(evt);
            }
        });
        jPanel4.add(txtMarca);
        txtMarca.setBounds(160, 80, 250, 30);
        jPanel4.add(txtModelo);
        txtModelo.setBounds(160, 130, 250, 30);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Activo", "Activo", "Anulado" }));
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

        jLabel7.setText("Nro. de serie");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(25, 180, 100, 30);
        jPanel4.add(txtNroSerie);
        txtNroSerie.setBounds(160, 180, 250, 30);

        txtUsuario.setEnabled(false);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel4.add(txtUsuario);
        txtUsuario.setBounds(160, 30, 250, 30);

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(420, 30, 200, 30);

        jLabel6.setText("Usuario");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(25, 30, 100, 30);

        jTabbedPane1.addTab("Nuevo", jPanel4);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 110, 960, 530);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Equipos");
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

    private void tblEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquiposMouseClicked
        if(evt.getClickCount()==1){
            llenaModifica();
        }
    }//GEN-LAST:event_tblEquiposMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String proc = btnRegistrar.getText();
        int est;
        String pr = "";
        
        if(valida() == true) {
            Util u = new Util();
            
            Equipo eq = new Equipo();
            Empleado p = empleado;
            eq.setUsuario(p);
            est = u.estados(this.cmbEstado.getSelectedItem().toString());
            eq.setMarca(txtMarca.getText());
            eq.setModelo(this.txtModelo.getText());
            eq.setNum_serie(txtNroSerie.getText());
            eq.setEstado(est);
            
            if(proc.equals("Registrar")) {
                id = u.idNext("Equipos", "id_equipo");
                pr = "insert";
            } else if(proc.equals("Actualizar")) {
                id = this.id;
                if (!seleccionUsuario) {
                    Equipo equipo = equiDAO.buscarEquipo(id);
                    eq.setUsuario(equipo.getUsuario());
                }
                pr = "update";
            }
            
            eq.setId_equipo(id);
            equiDAO.registrarEquipo(eq, pr);
            limpiaControles();
            dtm.setRowCount(0);
            llenaTabla(false, "");
            jTabbedPane1.setSelectedIndex(0);
            JOptionPane.showMessageDialog(this, "Equipo registrado exitosamente.");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
            getFocusOwner().transferFocus();
        }

    }//GEN-LAST:event_txtMarcaKeyPressed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiaControles();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged

    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EmpleadosDlg transemp = new EmpleadosDlg(new javax.swing.JFrame(),true, hd, wd);
        transemp.setVisible(true);
        Empleado c = transemp.getEmpleado();
        this.txtUsuario.setText(c.getNombreCompleto());
        this.empleado = c;
        this.seleccionUsuario = true;
 
    }//GEN-LAST:event_jButton1ActionPerformed

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
    
    private void llenaTabla(boolean swr, String cadr) {
         Vector<Equipo> equDao =equiDAO.listarEquipos(swr, cadr);
         int i =  equDao.size();

         for(int j = 0; j<equDao.size();j++){
            Vector vect = new Vector();
            vect.addElement(equDao.get(j).getId_equipo());
            vect.addElement(equDao.get(j).getUsuario().getNombreCompleto());
            vect.addElement(equDao.get(j).getMarca());
            vect.addElement(equDao.get(j).getModelo());
            vect.addElement(equDao.get(j).getNum_serie());
            vect.addElement(equDao.get(j).getEstado());
            dtm.addRow(vect);
        }
    }
    
    private void llenaModifica(){
        int fila = tblEquipos.getSelectedRow();
        id = Integer.parseInt((dtm.getValueAt(fila, 0)).toString().trim());
       
        txtUsuario.setText(((String)dtm.getValueAt(fila, 1)).trim());
        txtMarca.setText((dtm.getValueAt(fila, 2)).toString().trim());
        txtModelo.setText((dtm.getValueAt(fila, 3)).toString().trim());
        txtNroSerie.setText((dtm.getValueAt(fila, 4)).toString().trim());
        this.cmbEstado.setSelectedIndex(Integer.parseInt((dtm.getValueAt(fila, 5)).toString().trim()));
        seleccionUsuario = false;
        btnRegistrar.setText("Actualizar");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JMenuItem diagnosticosMenu;
    private javax.swing.JMenuItem empleadosMenu;
    private javax.swing.JMenuItem equiposMenu;
    private javax.swing.JMenuItem fallasMenu;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JMenuItem repuestosMenu;
    private javax.swing.JMenu rrhhMenu;
    private javax.swing.JMenu salir;
    private javax.swing.JMenuItem salirMenu;
    private javax.swing.JTable tblEquipos;
    private javax.swing.JMenu tiMenu;
    private javax.swing.JTextField txtBusq;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNroSerie;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}

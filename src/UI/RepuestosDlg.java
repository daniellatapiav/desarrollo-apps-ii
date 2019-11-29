package UI;

import BEAN.Repuesto;
import DAO.RepuestoDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class RepuestosDlg extends javax.swing.JDialog {
    Vector vector = new Vector();
    Repuesto repuesto;
    RepuestoDAO repuestoDAO;
    DefaultTableModel dtm;

    public RepuestosDlg(java.awt.Frame parent, boolean modal, int mdiH, int mdiW) {
        super(parent, modal);
        initComponents();
        
        int slx, sly;
        slx = (mdiW / 2) - (250);
        sly = (mdiH / 2) - (250);
        this.setSize(500, 500);
        this.setLocation(slx, sly);
        this.setAlwaysOnTop(true);
        
        repuestoDAO = new RepuestoDAO();
        dtm = (DefaultTableModel) this.tblRepuestos.getModel();
        poblarTabla(false, "");
    }
    
    public void poblarTabla(Boolean siFiltrar, String filtro) {
        Vector<Repuesto> repuestos = repuestoDAO.listarRepuestos(siFiltrar, filtro);
        
        if(dtm.getRowCount() > 0) {
            dtm.setRowCount(0);
        }
        
        for (int i = 0; i < repuestos.size(); i++) {
            Vector vector = new Vector();
            vector.add(repuestos.get(i).getId_repuesto());
            vector.add(repuestos.get(i).getRep_desc());
            vector.add(repuestos.get(i).getCosto_unitario());
            dtm.addRow(vector);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        inputBusqueda = new javax.swing.JTextField();
        labelBusqueda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRepuestos = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelBusqueda1 = new javax.swing.JLabel();
        inputCantidad = new javax.swing.JTextField();
        labelBusqueda2 = new javax.swing.JLabel();
        rbProporcionado = new javax.swing.JRadioButton();
        rbSolicitar = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        inputBusqueda.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        inputBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputBusquedaKeyReleased(evt);
            }
        });

        labelBusqueda.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelBusqueda.setText("Búsqueda");

        tblRepuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripción", "Costo unitario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
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
        tblRepuestos.getTableHeader().setReorderingAllowed(false);
        tblRepuestos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRepuestosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRepuestos);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Repuestos");

        labelBusqueda1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelBusqueda1.setText("Tipo");

        inputCantidad.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        inputCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputCantidadKeyReleased(evt);
            }
        });

        labelBusqueda2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelBusqueda2.setText("Cantidad");

        buttonGroup1.add(rbProporcionado);
        rbProporcionado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbProporcionado.setText("Proporcionado");
        rbProporcionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProporcionadoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbSolicitar);
        rbSolicitar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbSolicitar.setText("Socilitar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelBusqueda2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(inputCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rbProporcionado)
                                    .addGap(50, 50, 50)
                                    .addComponent(rbSolicitar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBusqueda2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbProporcionado)
                    .addComponent(rbSolicitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputBusquedaKeyReleased
        if(this.inputBusqueda.getText().isEmpty()) {
            this.poblarTabla(false, "");
        } else {
            this.poblarTabla(true, this.inputBusqueda.getText());
        }
    }//GEN-LAST:event_inputBusquedaKeyReleased

    private void tblRepuestosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRepuestosMouseClicked
        int fila;
        fila = this.tblRepuestos.getSelectedRow();

        repuesto = new Repuesto();
        repuesto.setId_repuesto(Integer.parseInt(dtm.getValueAt(fila, 0).toString()));
        repuesto.setRep_desc(dtm.getValueAt(fila, 1).toString());
        repuesto.setCosto_unitario(Float.parseFloat(dtm.getValueAt(fila, 2).toString()));
        }

        public Vector getRepuesto() {
            vector.add(repuesto);
            vector.add(this.inputCantidad.getText());
            
            if(this.rbProporcionado.isSelected()) {
                vector.add("Solicitado");
            } else if(this.rbSolicitar.isSelected()) {
                vector.add("Solicitar");
            }
            
            return vector;
    }//GEN-LAST:event_tblRepuestosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void inputCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputCantidadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCantidadKeyReleased

    private void rbProporcionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProporcionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbProporcionadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField inputBusqueda;
    private javax.swing.JTextField inputCantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBusqueda;
    private javax.swing.JLabel labelBusqueda1;
    private javax.swing.JLabel labelBusqueda2;
    private javax.swing.JRadioButton rbProporcionado;
    private javax.swing.JRadioButton rbSolicitar;
    private javax.swing.JTable tblRepuestos;
    // End of variables declaration//GEN-END:variables
}

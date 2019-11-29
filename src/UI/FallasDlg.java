package UI;

import BEAN.Falla;
import DAO.FallaDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class FallasDlg extends javax.swing.JDialog {
    Falla falla;
    FallaDAO fallaDAO;
    DefaultTableModel dtm;
    
    public FallasDlg(java.awt.Frame parent, boolean modal, int mdiH, int mdiW) {
        super(parent, modal);
        initComponents();
        
        int slx, sly;
        slx = (mdiW / 2) - (250);
        sly = (mdiH / 2) - (200);
        this.setSize(500, 400);
        this.setLocation(slx, sly);
        this.setAlwaysOnTop(true);
        
        fallaDAO = new FallaDAO();
        dtm = (DefaultTableModel)this.tblFallas.getModel();
        poblarTabla(false, "");
    }
    
    public void poblarTabla(Boolean siFiltrar, String filtro) {
        Vector<Falla> fallas = fallaDAO.listarFallas(siFiltrar, filtro);
        
        if(dtm.getRowCount() > 0) {
            dtm.setRowCount(0);
        }
        
        for (int i = 0; i < fallas.size(); i++) {
            Vector vector = new Vector();
            vector.add(fallas.get(i).getId_falla());
            vector.add(fallas.get(i).getTipo_falla());
            vector.add(fallas.get(i).getFalla_desc());
            dtm.addRow(vector);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputBusqueda = new javax.swing.JTextField();
        labelBusqueda = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFallas = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        inputBusqueda.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        inputBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputBusquedaKeyReleased(evt);
            }
        });

        labelBusqueda.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelBusqueda.setText("Búsqueda");

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fallas");

        tblFallas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFallas.getTableHeader().setReorderingAllowed(false);
        tblFallas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFallasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFallas);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
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

    private void tblFallasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFallasMouseClicked

        int fila;
        fila = this.tblFallas.getSelectedRow();

        falla = new Falla();
        falla.setId_falla(Integer.parseInt(dtm.getValueAt(fila, 0).toString()));
        falla.setTipo_falla(dtm.getValueAt(fila, 1).toString());
        falla.setFalla_desc(dtm.getValueAt(fila, 2).toString());
        dispose();
        }

        public Falla getFalla() {
            return this.falla;
    }//GEN-LAST:event_tblFallasMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.dispose();

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField inputBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBusqueda;
    private javax.swing.JTable tblFallas;
    // End of variables declaration//GEN-END:variables
}

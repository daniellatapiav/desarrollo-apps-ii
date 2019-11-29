package UI;

import BEAN.Empleado;
import BEAN.Equipo;
import DAO.EmpleadoDAO;
import DAO.EquipoDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class EquiposDlg extends javax.swing.JDialog {
    Equipo equipo;
    EquipoDAO equipoDAO;
    EmpleadoDAO empleadoDAO;
    DefaultTableModel dtm;
    Vector<Equipo> equipos;
    
    public EquiposDlg(java.awt.Frame parent, boolean modal, int mdiH, int mdiW) {
        super(parent, modal);
        initComponents();
        
        int slx, sly;
        slx = (mdiW / 2) - (250);
        sly = (mdiH / 2) - (200);
        this.setSize(500, 400);
        this.setLocation(slx, sly);
        this.setAlwaysOnTop(true);
        
        equipoDAO = new EquipoDAO();
        dtm = (DefaultTableModel) this.tblEquipos.getModel();
        poblarTabla(false, "");
    }
    
    public void poblarTabla(Boolean siFiltrar, String filtro) {
        equipos = equipoDAO.listarEquipos(siFiltrar, filtro);
        
        if(dtm.getRowCount() > 0) {
            dtm.setRowCount(0);
        }
        
        for (int i = 0; i < equipos.size(); i++) {
            Vector vector = new Vector();
            vector.add(equipos.get(i).getId_equipo());
            vector.add(equipos.get(i).getUsuario().getNombreCompleto());
            vector.add(equipos.get(i).getMarca());
            vector.add(equipos.get(i).getModelo());
            vector.add(equipos.get(i).getNum_serie());
            vector.add(equipos.get(i).getEstado());
            dtm.addRow(vector);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelBusqueda = new javax.swing.JLabel();
        inputBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEquipos = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Equipos");

        labelBusqueda.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelBusqueda.setText("Búsqueda");

        inputBusqueda.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        inputBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputBusquedaKeyReleased(evt);
            }
        });

        tblEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuario", "Marca", "Modelo", "Nro. Serie", "Estado"
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
        tblEquipos.getTableHeader().setReorderingAllowed(false);
        tblEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEquiposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEquipos);

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

    private void tblEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquiposMouseClicked
        int fila;
        fila = this.tblEquipos.getSelectedRow();
     
        equipo = new Equipo();
        equipo.setId_equipo(Integer.parseInt(dtm.getValueAt(fila, 0).toString()));
        //equipo.setUsuario(equipos.get(fila).getUsuario());
        equipo.setMarca(dtm.getValueAt(fila, 2).toString());
        equipo.setModelo(dtm.getValueAt(fila, 3).toString());
        equipo.setNum_serie(dtm.getValueAt(fila, 4).toString());
        equipo.setEstado(Integer.parseInt(dtm.getValueAt(fila, 5).toString()));
        dispose();
    }

    public Equipo getEquipo() {
        return this.equipo;
    }//GEN-LAST:event_tblEquiposMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField inputBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBusqueda;
    private javax.swing.JTable tblEquipos;
    // End of variables declaration//GEN-END:variables
}

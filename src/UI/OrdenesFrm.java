package UI;

import BEAN.*;
import DAO.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import util.Util;

public class OrdenesFrm extends javax.swing.JFrame {
    DefaultTableModel dtmOrdenes, dtmFallas, dtmRepuestos, dtmDiagnosticos;
    OrdenesDAO ordenesDAO;
    int id, wd, hd, slx, sly;
    Orden_Servicio orden;
    Empleado usuario, empRec, empDev;
    Equipo equipo;
    Vector<Orden_Servicio> ordenes;
    Vector<Falla> fallas;
    Vector<Repuesto> repuestos;
    Vector<Diagnostico> diagnosticos;
    Vector<Detalle_Repuesto> detalle_repuestos;
    DetalleFallaDAO detalleFallaDAO;
    DetalleRepuestoDAO detalleRepuestoDAO;
    DetalleDiagnosticoDAO detalleDiagnosticoDAO;

    public OrdenesFrm() {
        initComponents();
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        wd = dim.width;
        hd = dim.height;
        this.setSize(1000, 700);
        slx = (wd/2) - (1000/2);
        sly = (hd/2) - (400);
        this.setLocation(slx,sly);
        this.setResizable(false);
        this.setTitle("Proyecto Integrador - Anampa & Tapia");
        
        fallas = new Vector<Falla>();
        repuestos = new Vector<Repuesto>();
        diagnosticos = new Vector<Diagnostico>();
        detalle_repuestos = new Vector<Detalle_Repuesto>();
        dtmOrdenes = (DefaultTableModel) this.tblOrdenes.getModel();
        dtmFallas = (DefaultTableModel) this.tblFallas.getModel();
        dtmRepuestos = (DefaultTableModel) this.tblRepuestos.getModel();
        dtmDiagnosticos = (DefaultTableModel) this.tblDiagnosticos.getModel();
        ordenesDAO = new OrdenesDAO();
        detalleFallaDAO = new DetalleFallaDAO();
        detalleRepuestoDAO = new DetalleRepuestoDAO();
        detalleDiagnosticoDAO = new DetalleDiagnosticoDAO();
        poblarTabla(false, "");
        this.tabbedPane.setSelectedIndex(0);
    }
    
    public void poblarTabla(Boolean siFiltrar, String filtro) {
        ordenes = ordenesDAO.listarOrdenes(siFiltrar, filtro);
        
        dtmOrdenes.setRowCount(0);
        
        for (int i = 0; i < ordenes.size(); i++) {
            Vector vector = new Vector();
            vector.add(ordenes.get(i).getId_ordenServicio());
            vector.add(ordenes.get(i).getFecha_mant());
            vector.add(ordenes.get(i).getPlantel());
            vector.add(ordenes.get(i).getUsuario().getNombreCompleto());
            vector.add(ordenes.get(i).getEquipo().getDescCompleta());
            vector.add(ordenes.get(i).getTipoMant().getTipoMant_desc());
            if(ordenes.get(i).getEstado() == 0) {
                vector.add("Pendiente");
            } else {
                vector.add("Finalizada");
            }
            dtmOrdenes.addRow(vector);
        }
    }
    
    public boolean validar() {
        boolean sw = false;
        
        if(this.inputPlantel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes ingresar un plantel.");
        } else if(this.inputNombreUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un usuario.");
        } else if(this.inputModelo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un equipo.");
        } else if(this.tblFallas.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar por lo menos una falla.");
        } else if(this.tblDiagnosticos.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un usuario.");
        } else if(!this.rbTipoMant1.isSelected() && !this.rbTipoMant2.isSelected() && !this.rbTipoMant3.isSelected() && !this.rbTipoMant4.isSelected() && !this.rbTipoMant5.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un tipo de mantenimiento.");
        } else if(this.inputEmpRec.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar al empleado que recibió el equipo.");
        } else {
            sw = true;
        }
        
        return sw;
    }
    
    public void limpiar() {
        this.inputPlantel.setText("");
        this.inputNombreUsuario.setText("");
        this.rbTipoUsuario0.setSelected(false);
        this.rbTipoUsuario1.setSelected(false);
        this.inputAreaUsuario.setText("");
        this.rbEstadoUsuario0.setSelected(false);
        this.rbEstadoUsuario1.setSelected(false);
        this.inputMarca.setText("");
        this.inputModelo.setText("");
        this.inputNroSerie.setText("");
        this.rbEstadoEquipo0.setSelected(false);
        this.rbEstadoEquipo1.setSelected(false);
        this.dtmFallas.setRowCount(0);
        this.dtmRepuestos.setRowCount(0);
        this.dtmDiagnosticos.setRowCount(0);
        this.rbTipoMant1.setSelected(false);
        this.rbTipoMant2.setSelected(false);
        this.rbTipoMant3.setSelected(false);
        this.rbTipoMant4.setSelected(false);
        this.rbTipoMant5.setSelected(false);
        this.inputObsRec.setText("");
        this.inputObsDev.setText("");    
        this.inputEmpRec.setText("");
        this.inputEmpDev.setText("");
        this.rbEstadoOrden0.setSelected(false);
        this.rbEstadoOrden1.setSelected(false);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrdenesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdenesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdenesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdenesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdenesFrm().setVisible(true);
            }
            });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupTipoUsuario = new javax.swing.ButtonGroup();
        btnGroupEstadoUsuario = new javax.swing.ButtonGroup();
        btnGroupEstadoEquipo = new javax.swing.ButtonGroup();
        btnGroupTipoMant = new javax.swing.ButtonGroup();
        btnGroupEstadoOrden = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        inputBusqueda = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblOrdenes = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        inputPlantel = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        inputNombreUsuario = new javax.swing.JTextField();
        btnBuscarUsuarios = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        rbTipoUsuario1 = new javax.swing.JRadioButton();
        rbTipoUsuario0 = new javax.swing.JRadioButton();
        inputAreaUsuario = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        rbEstadoUsuario1 = new javax.swing.JRadioButton();
        rbEstadoUsuario0 = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        inputModelo = new javax.swing.JTextField();
        btnBuscarEquipos = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        inputNroSerie = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        inputMarca = new javax.swing.JTextField();
        rbEstadoEquipo0 = new javax.swing.JRadioButton();
        rbEstadoEquipo1 = new javax.swing.JRadioButton();
        jLabel58 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        btnBuscarFallas = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFallas = new javax.swing.JTable();
        jLabel79 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblRepuestos = new javax.swing.JTable();
        jLabel80 = new javax.swing.JLabel();
        btnBuscarRepuestos = new javax.swing.JButton();
        jLabel84 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDiagnosticos = new javax.swing.JTable();
        btnBuscarDiagnosticos = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        rbTipoMant5 = new javax.swing.JRadioButton();
        rbTipoMant1 = new javax.swing.JRadioButton();
        rbTipoMant2 = new javax.swing.JRadioButton();
        rbTipoMant3 = new javax.swing.JRadioButton();
        rbTipoMant4 = new javax.swing.JRadioButton();
        jPanel19 = new javax.swing.JPanel();
        jRadioButton26 = new javax.swing.JRadioButton();
        jRadioButton27 = new javax.swing.JRadioButton();
        jRadioButton28 = new javax.swing.JRadioButton();
        jRadioButton29 = new javax.swing.JRadioButton();
        jRadioButton30 = new javax.swing.JRadioButton();
        jPanel20 = new javax.swing.JPanel();
        jRadioButton31 = new javax.swing.JRadioButton();
        jRadioButton32 = new javax.swing.JRadioButton();
        jRadioButton33 = new javax.swing.JRadioButton();
        jRadioButton34 = new javax.swing.JRadioButton();
        jRadioButton35 = new javax.swing.JRadioButton();
        jPanel21 = new javax.swing.JPanel();
        jRadioButton36 = new javax.swing.JRadioButton();
        jRadioButton37 = new javax.swing.JRadioButton();
        jRadioButton38 = new javax.swing.JRadioButton();
        jRadioButton39 = new javax.swing.JRadioButton();
        jRadioButton40 = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jPanel16 = new javax.swing.JPanel();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jPanel17 = new javax.swing.JPanel();
        jRadioButton16 = new javax.swing.JRadioButton();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jLabel74 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        inputObsDev = new javax.swing.JTextField();
        inputObsRec = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        inputEmpRec = new javax.swing.JTextField();
        btnEmpRec = new javax.swing.JButton();
        btnEmpDev = new javax.swing.JButton();
        inputEmpDev = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        btnCancelar1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jRadioButton23 = new javax.swing.JRadioButton();
        jRadioButton24 = new javax.swing.JRadioButton();
        jRadioButton25 = new javax.swing.JRadioButton();
        jPanel24 = new javax.swing.JPanel();
        jRadioButton41 = new javax.swing.JRadioButton();
        jRadioButton42 = new javax.swing.JRadioButton();
        jRadioButton43 = new javax.swing.JRadioButton();
        jRadioButton44 = new javax.swing.JRadioButton();
        jRadioButton45 = new javax.swing.JRadioButton();
        jPanel25 = new javax.swing.JPanel();
        jRadioButton46 = new javax.swing.JRadioButton();
        jRadioButton47 = new javax.swing.JRadioButton();
        jRadioButton48 = new javax.swing.JRadioButton();
        jRadioButton49 = new javax.swing.JRadioButton();
        jRadioButton50 = new javax.swing.JRadioButton();
        rbEstadoOrden1 = new javax.swing.JRadioButton();
        rbEstadoOrden0 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        tiMenu = new javax.swing.JMenu();
        ordenesMenu = new javax.swing.JMenuItem();
        equiposMenu = new javax.swing.JMenuItem();
        repuestosMenu = new javax.swing.JMenuItem();
        fallasMenu = new javax.swing.JMenuItem();
        diagnosticosMenu = new javax.swing.JMenuItem();
        rrhhMenu = new javax.swing.JMenu();
        salir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Órdenes de Servicio");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 40, 1000, 50);

        tabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPaneStateChanged(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setText("Búsqueda por número de orden");
        jLabel4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel4AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(25, 30, 253, 30);

        inputBusqueda.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        inputBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputBusquedaActionPerformed(evt);
            }
        });
        inputBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputBusquedaKeyTyped(evt);
            }
        });
        jPanel1.add(inputBusqueda);
        inputBusqueda.setBounds(305, 30, 200, 30);

        tblOrdenes.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tblOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Plantel", "Usuario", "Equipo", "Tipo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrdenes.getTableHeader().setReorderingAllowed(false);
        tblOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdenesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblOrdenes);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(25, 100, 900, 310);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar);
        btnEditar.setBounds(400, 430, 150, 50);

        tabbedPane.addTab("Consulta", jPanel1);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        jLabel59.setText("Plantel");

        inputPlantel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPlantelActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel9.setLayout(null);

        inputNombreUsuario.setToolTipText("");
        inputNombreUsuario.setEnabled(false);
        inputNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombreUsuarioActionPerformed(evt);
            }
        });
        jPanel9.add(inputNombreUsuario);
        inputNombreUsuario.setBounds(120, 80, 250, 30);

        btnBuscarUsuarios.setText("Buscar usuarios");
        btnBuscarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuariosActionPerformed(evt);
            }
        });
        jPanel9.add(btnBuscarUsuarios);
        btnBuscarUsuarios.setBounds(120, 40, 250, 30);

        jLabel48.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel48.setText("Tipo");
        jPanel9.add(jLabel48);
        jLabel48.setBounds(20, 120, 70, 30);

        jLabel50.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel50.setText("Agregar");
        jPanel9.add(jLabel50);
        jLabel50.setBounds(20, 40, 70, 30);

        jLabel51.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel51.setText("Nombre");
        jPanel9.add(jLabel51);
        jLabel51.setBounds(20, 80, 70, 30);

        btnGroupTipoUsuario.add(rbTipoUsuario1);
        rbTipoUsuario1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        rbTipoUsuario1.setText("Docente");
        rbTipoUsuario1.setEnabled(false);
        rbTipoUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTipoUsuario1ActionPerformed(evt);
            }
        });
        jPanel9.add(rbTipoUsuario1);
        rbTipoUsuario1.setBounds(260, 120, 110, 30);

        btnGroupTipoUsuario.add(rbTipoUsuario0);
        rbTipoUsuario0.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        rbTipoUsuario0.setText("Administrativo");
        rbTipoUsuario0.setEnabled(false);
        rbTipoUsuario0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTipoUsuario0ActionPerformed(evt);
            }
        });
        jPanel9.add(rbTipoUsuario0);
        rbTipoUsuario0.setBounds(120, 120, 130, 30);

        inputAreaUsuario.setToolTipText("");
        inputAreaUsuario.setEnabled(false);
        inputAreaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputAreaUsuarioActionPerformed(evt);
            }
        });
        jPanel9.add(inputAreaUsuario);
        inputAreaUsuario.setBounds(120, 160, 250, 30);

        jLabel52.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel52.setText("Área");
        jPanel9.add(jLabel52);
        jLabel52.setBounds(20, 160, 70, 30);

        jLabel57.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel57.setText("Estado");
        jPanel9.add(jLabel57);
        jLabel57.setBounds(20, 200, 70, 30);

        btnGroupEstadoUsuario.add(rbEstadoUsuario1);
        rbEstadoUsuario1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        rbEstadoUsuario1.setText("Activo");
        rbEstadoUsuario1.setEnabled(false);
        rbEstadoUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEstadoUsuario1ActionPerformed(evt);
            }
        });
        jPanel9.add(rbEstadoUsuario1);
        rbEstadoUsuario1.setBounds(120, 200, 110, 30);

        btnGroupEstadoUsuario.add(rbEstadoUsuario0);
        rbEstadoUsuario0.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        rbEstadoUsuario0.setText("Inactivo");
        rbEstadoUsuario0.setEnabled(false);
        rbEstadoUsuario0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEstadoUsuario0ActionPerformed(evt);
            }
        });
        jPanel9.add(rbEstadoUsuario0);
        rbEstadoUsuario0.setBounds(260, 200, 110, 30);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Equipo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel10.setLayout(null);

        inputModelo.setToolTipText("");
        inputModelo.setEnabled(false);
        inputModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputModeloActionPerformed(evt);
            }
        });
        jPanel10.add(inputModelo);
        inputModelo.setBounds(120, 120, 250, 30);

        btnBuscarEquipos.setText("Buscar equipos");
        btnBuscarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEquiposActionPerformed(evt);
            }
        });
        jPanel10.add(btnBuscarEquipos);
        btnBuscarEquipos.setBounds(120, 40, 250, 30);

        jLabel53.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel53.setText("Modelo");
        jPanel10.add(jLabel53);
        jLabel53.setBounds(20, 120, 70, 30);

        jLabel54.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel54.setText("Agregar");
        jPanel10.add(jLabel54);
        jLabel54.setBounds(20, 40, 70, 30);

        jLabel55.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel55.setText("Marca");
        jPanel10.add(jLabel55);
        jLabel55.setBounds(20, 80, 70, 30);

        inputNroSerie.setToolTipText("");
        inputNroSerie.setEnabled(false);
        inputNroSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNroSerieActionPerformed(evt);
            }
        });
        jPanel10.add(inputNroSerie);
        inputNroSerie.setBounds(120, 160, 250, 30);

        jLabel56.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel56.setText("N° de serie");
        jPanel10.add(jLabel56);
        jLabel56.setBounds(20, 160, 70, 30);

        inputMarca.setToolTipText("");
        inputMarca.setEnabled(false);
        inputMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMarcaActionPerformed(evt);
            }
        });
        jPanel10.add(inputMarca);
        inputMarca.setBounds(120, 80, 250, 30);

        btnGroupEstadoEquipo.add(rbEstadoEquipo0);
        rbEstadoEquipo0.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        rbEstadoEquipo0.setText("Inactivo");
        rbEstadoEquipo0.setEnabled(false);
        rbEstadoEquipo0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEstadoEquipo0ActionPerformed(evt);
            }
        });
        jPanel10.add(rbEstadoEquipo0);
        rbEstadoEquipo0.setBounds(260, 200, 110, 30);

        btnGroupEstadoEquipo.add(rbEstadoEquipo1);
        rbEstadoEquipo1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        rbEstadoEquipo1.setText("Activo");
        rbEstadoEquipo1.setEnabled(false);
        rbEstadoEquipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEstadoEquipo1ActionPerformed(evt);
            }
        });
        jPanel10.add(rbEstadoEquipo1);
        rbEstadoEquipo1.setBounds(120, 200, 110, 30);

        jLabel58.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel58.setText("Estado");
        jPanel10.add(jLabel58);
        jLabel58.setBounds(20, 200, 70, 30);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fallas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel14.setLayout(null);

        btnBuscarFallas.setText("Buscar fallas");
        btnBuscarFallas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFallasActionPerformed(evt);
            }
        });
        jPanel14.add(btnBuscarFallas);
        btnBuscarFallas.setBounds(120, 40, 250, 30);

        jLabel78.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel78.setText("Fallas agregadas");
        jPanel14.add(jLabel78);
        jLabel78.setBounds(20, 90, 140, 30);

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
        tblFallas.setSize(new java.awt.Dimension(450, 100));
        jScrollPane3.setViewportView(tblFallas);

        jPanel14.add(jScrollPane3);
        jScrollPane3.setBounds(20, 130, 850, 150);

        jLabel79.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel79.setText("Agregar");
        jPanel14.add(jLabel79);
        jLabel79.setBounds(20, 40, 70, 30);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Repuestos (opcional)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel12.setLayout(null);

        tblRepuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripción", "Cantidad", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRepuestos.setSize(new java.awt.Dimension(450, 100));
        jScrollPane5.setViewportView(tblRepuestos);

        jPanel12.add(jScrollPane5);
        jScrollPane5.setBounds(20, 130, 850, 150);

        jLabel80.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel80.setText("Repuestos agregados");
        jPanel12.add(jLabel80);
        jLabel80.setBounds(20, 90, 140, 30);

        btnBuscarRepuestos.setText("Buscar repuestos");
        btnBuscarRepuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRepuestosActionPerformed(evt);
            }
        });
        jPanel12.add(btnBuscarRepuestos);
        btnBuscarRepuestos.setBounds(120, 40, 250, 30);

        jLabel84.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel84.setText("Agregar");
        jPanel12.add(jLabel84);
        jLabel84.setBounds(20, 40, 70, 30);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Diagnósticos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel13.setLayout(null);

        tblDiagnosticos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDiagnosticos.setSize(new java.awt.Dimension(450, 100));
        jScrollPane6.setViewportView(tblDiagnosticos);

        jPanel13.add(jScrollPane6);
        jScrollPane6.setBounds(20, 130, 850, 150);

        btnBuscarDiagnosticos.setText("Buscar diagnósticos");
        btnBuscarDiagnosticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDiagnosticosActionPerformed(evt);
            }
        });
        jPanel13.add(btnBuscarDiagnosticos);
        btnBuscarDiagnosticos.setBounds(120, 40, 250, 30);

        jLabel85.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel85.setText("Diagnósticos agregados");
        jPanel13.add(jLabel85);
        jLabel85.setBounds(20, 90, 190, 30);

        jLabel86.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel86.setText("Agregar");
        jPanel13.add(jLabel86);
        jLabel86.setBounds(20, 40, 70, 30);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de mantenimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel18.setLayout(null);

        btnGroupTipoMant.add(rbTipoMant5);
        rbTipoMant5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        rbTipoMant5.setText("Revisión");
        jPanel18.add(rbTipoMant5);
        rbTipoMant5.setBounds(770, 40, 100, 25);

        btnGroupTipoMant.add(rbTipoMant1);
        rbTipoMant1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        rbTipoMant1.setText("Preventivo programado");
        jPanel18.add(rbTipoMant1);
        rbTipoMant1.setBounds(20, 40, 200, 25);

        btnGroupTipoMant.add(rbTipoMant2);
        rbTipoMant2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        rbTipoMant2.setText("Preventivo no programado");
        jPanel18.add(rbTipoMant2);
        rbTipoMant2.setBounds(240, 40, 220, 25);

        btnGroupTipoMant.add(rbTipoMant3);
        rbTipoMant3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        rbTipoMant3.setText("Correctivo");
        jPanel18.add(rbTipoMant3);
        rbTipoMant3.setBounds(490, 40, 120, 25);

        btnGroupTipoMant.add(rbTipoMant4);
        rbTipoMant4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        rbTipoMant4.setText("Limpieza");
        jPanel18.add(rbTipoMant4);
        rbTipoMant4.setBounds(630, 40, 100, 25);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de mantenimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel19.setLayout(null);

        jRadioButton26.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton26.setText("Revisión");
        jPanel19.add(jRadioButton26);
        jRadioButton26.setBounds(730, 40, 100, 25);

        jRadioButton27.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton27.setText("Preventivo programado");
        jPanel19.add(jRadioButton27);
        jRadioButton27.setBounds(20, 40, 180, 25);

        jRadioButton28.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton28.setText("Preventivo no programado");
        jPanel19.add(jRadioButton28);
        jRadioButton28.setBounds(230, 40, 180, 25);

        jRadioButton29.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton29.setText("Correctivo");
        jPanel19.add(jRadioButton29);
        jRadioButton29.setBounds(450, 40, 100, 25);

        jRadioButton30.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton30.setText("Limpieza");
        jPanel19.add(jRadioButton30);
        jRadioButton30.setBounds(590, 40, 100, 25);

        jPanel18.add(jPanel19);
        jPanel19.setBounds(20, 980, 930, 90);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de mantenimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel20.setLayout(null);

        jRadioButton31.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton31.setText("Revisión");
        jPanel20.add(jRadioButton31);
        jRadioButton31.setBounds(730, 40, 100, 25);

        jRadioButton32.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton32.setText("Preventivo programado");
        jPanel20.add(jRadioButton32);
        jRadioButton32.setBounds(20, 40, 180, 25);

        jRadioButton33.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton33.setText("Preventivo no programado");
        jPanel20.add(jRadioButton33);
        jRadioButton33.setBounds(230, 40, 180, 25);

        jRadioButton34.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton34.setText("Correctivo");
        jPanel20.add(jRadioButton34);
        jRadioButton34.setBounds(450, 40, 100, 25);

        jRadioButton35.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton35.setText("Limpieza");
        jPanel20.add(jRadioButton35);
        jRadioButton35.setBounds(590, 40, 100, 25);

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de mantenimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel21.setLayout(null);

        jRadioButton36.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton36.setText("Revisión");
        jPanel21.add(jRadioButton36);
        jRadioButton36.setBounds(730, 40, 100, 25);

        jRadioButton37.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton37.setText("Preventivo programado");
        jPanel21.add(jRadioButton37);
        jRadioButton37.setBounds(20, 40, 180, 25);

        jRadioButton38.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton38.setText("Preventivo no programado");
        jPanel21.add(jRadioButton38);
        jRadioButton38.setBounds(230, 40, 180, 25);

        jRadioButton39.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton39.setText("Correctivo");
        jPanel21.add(jRadioButton39);
        jRadioButton39.setBounds(450, 40, 100, 25);

        jRadioButton40.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton40.setText("Limpieza");
        jPanel21.add(jRadioButton40);
        jRadioButton40.setBounds(590, 40, 100, 25);

        jPanel20.add(jPanel21);
        jPanel21.setBounds(20, 980, 930, 90);

        jPanel18.add(jPanel20);
        jPanel20.setBounds(20, 980, 930, 90);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel11.setLayout(null);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de mantenimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel15.setLayout(null);

        jRadioButton6.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton6.setText("Revisión");
        jPanel15.add(jRadioButton6);
        jRadioButton6.setBounds(730, 40, 100, 25);

        jRadioButton7.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton7.setText("Preventivo programado");
        jPanel15.add(jRadioButton7);
        jRadioButton7.setBounds(20, 40, 180, 25);

        jRadioButton8.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton8.setText("Preventivo no programado");
        jPanel15.add(jRadioButton8);
        jRadioButton8.setBounds(230, 40, 180, 25);

        jRadioButton9.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton9.setText("Correctivo");
        jPanel15.add(jRadioButton9);
        jRadioButton9.setBounds(450, 40, 100, 25);

        jRadioButton10.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton10.setText("Limpieza");
        jPanel15.add(jRadioButton10);
        jRadioButton10.setBounds(590, 40, 100, 25);

        jPanel11.add(jPanel15);
        jPanel15.setBounds(20, 980, 930, 90);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de mantenimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel16.setLayout(null);

        jRadioButton11.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton11.setText("Revisión");
        jPanel16.add(jRadioButton11);
        jRadioButton11.setBounds(730, 40, 100, 25);

        jRadioButton12.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton12.setText("Preventivo programado");
        jPanel16.add(jRadioButton12);
        jRadioButton12.setBounds(20, 40, 180, 25);

        jRadioButton13.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton13.setText("Preventivo no programado");
        jPanel16.add(jRadioButton13);
        jRadioButton13.setBounds(230, 40, 180, 25);

        jRadioButton14.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton14.setText("Correctivo");
        jPanel16.add(jRadioButton14);
        jRadioButton14.setBounds(450, 40, 100, 25);

        jRadioButton15.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton15.setText("Limpieza");
        jPanel16.add(jRadioButton15);
        jRadioButton15.setBounds(590, 40, 100, 25);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de mantenimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel17.setLayout(null);

        jRadioButton16.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton16.setText("Revisión");
        jPanel17.add(jRadioButton16);
        jRadioButton16.setBounds(730, 40, 100, 25);

        jRadioButton17.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton17.setText("Preventivo programado");
        jPanel17.add(jRadioButton17);
        jRadioButton17.setBounds(20, 40, 180, 25);

        jRadioButton18.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton18.setText("Preventivo no programado");
        jPanel17.add(jRadioButton18);
        jRadioButton18.setBounds(230, 40, 180, 25);

        jRadioButton19.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton19.setText("Correctivo");
        jPanel17.add(jRadioButton19);
        jRadioButton19.setBounds(450, 40, 100, 25);

        jRadioButton20.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton20.setText("Limpieza");
        jPanel17.add(jRadioButton20);
        jRadioButton20.setBounds(590, 40, 100, 25);

        jPanel16.add(jPanel17);
        jPanel17.setBounds(20, 980, 930, 90);

        jPanel11.add(jPanel16);
        jPanel16.setBounds(20, 980, 930, 90);

        jLabel74.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14)); // NOI18N
        jLabel74.setText("DEVOLUCIÓN");
        jPanel11.add(jLabel74);
        jLabel74.setBounds(540, 50, 140, 14);

        jLabel81.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14)); // NOI18N
        jLabel81.setText("RECEPCIÓN");
        jPanel11.add(jLabel81);
        jLabel81.setBounds(140, 50, 140, 14);
        jPanel11.add(inputObsDev);
        inputObsDev.setBounds(540, 80, 300, 120);
        jPanel11.add(inputObsRec);
        inputObsRec.setBounds(140, 80, 300, 120);

        jLabel82.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel82.setText("Recibe");
        jPanel11.add(jLabel82);
        jLabel82.setBounds(20, 230, 90, 30);

        jLabel83.setFont(new java.awt.Font("Franklin Gothic Book", 2, 12)); // NOI18N
        jLabel83.setText("(opcional)");
        jPanel11.add(jLabel83);
        jLabel83.setBounds(20, 100, 90, 15);

        inputEmpRec.setToolTipText("");
        inputEmpRec.setEnabled(false);
        inputEmpRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEmpRecActionPerformed(evt);
            }
        });
        jPanel11.add(inputEmpRec);
        inputEmpRec.setBounds(140, 230, 140, 30);

        btnEmpRec.setText("Buscar");
        btnEmpRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpRecActionPerformed(evt);
            }
        });
        jPanel11.add(btnEmpRec);
        btnEmpRec.setBounds(290, 230, 150, 30);

        btnEmpDev.setText("Buscar");
        btnEmpDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpDevActionPerformed(evt);
            }
        });
        jPanel11.add(btnEmpDev);
        btnEmpDev.setBounds(690, 220, 150, 30);

        inputEmpDev.setToolTipText("");
        inputEmpDev.setEnabled(false);
        inputEmpDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEmpDevActionPerformed(evt);
            }
        });
        jPanel11.add(inputEmpDev);
        inputEmpDev.setBounds(540, 220, 140, 30);

        jLabel87.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel87.setText("Comentarios");
        jPanel11.add(jLabel87);
        jLabel87.setBounds(20, 80, 90, 15);

        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel22.setLayout(null);

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de mantenimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel23.setLayout(null);

        jRadioButton21.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton21.setText("Revisión");
        jPanel23.add(jRadioButton21);
        jRadioButton21.setBounds(730, 40, 100, 25);

        jRadioButton22.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton22.setText("Preventivo programado");
        jPanel23.add(jRadioButton22);
        jRadioButton22.setBounds(20, 40, 180, 25);

        jRadioButton23.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton23.setText("Preventivo no programado");
        jPanel23.add(jRadioButton23);
        jRadioButton23.setBounds(230, 40, 180, 25);

        jRadioButton24.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton24.setText("Correctivo");
        jPanel23.add(jRadioButton24);
        jRadioButton24.setBounds(450, 40, 100, 25);

        jRadioButton25.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton25.setText("Limpieza");
        jPanel23.add(jRadioButton25);
        jRadioButton25.setBounds(590, 40, 100, 25);

        jPanel22.add(jPanel23);
        jPanel23.setBounds(20, 980, 930, 90);

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de mantenimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel24.setLayout(null);

        jRadioButton41.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton41.setText("Revisión");
        jPanel24.add(jRadioButton41);
        jRadioButton41.setBounds(730, 40, 100, 25);

        jRadioButton42.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton42.setText("Preventivo programado");
        jPanel24.add(jRadioButton42);
        jRadioButton42.setBounds(20, 40, 180, 25);

        jRadioButton43.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton43.setText("Preventivo no programado");
        jPanel24.add(jRadioButton43);
        jRadioButton43.setBounds(230, 40, 180, 25);

        jRadioButton44.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton44.setText("Correctivo");
        jPanel24.add(jRadioButton44);
        jRadioButton44.setBounds(450, 40, 100, 25);

        jRadioButton45.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton45.setText("Limpieza");
        jPanel24.add(jRadioButton45);
        jRadioButton45.setBounds(590, 40, 100, 25);

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de mantenimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Franklin Gothic Book", 1, 18))); // NOI18N
        jPanel25.setLayout(null);

        jRadioButton46.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton46.setText("Revisión");
        jPanel25.add(jRadioButton46);
        jRadioButton46.setBounds(730, 40, 100, 25);

        jRadioButton47.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton47.setText("Preventivo programado");
        jPanel25.add(jRadioButton47);
        jRadioButton47.setBounds(20, 40, 180, 25);

        jRadioButton48.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton48.setText("Preventivo no programado");
        jPanel25.add(jRadioButton48);
        jRadioButton48.setBounds(230, 40, 180, 25);

        jRadioButton49.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton49.setText("Correctivo");
        jPanel25.add(jRadioButton49);
        jRadioButton49.setBounds(450, 40, 100, 25);

        jRadioButton50.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButton50.setText("Limpieza");
        jPanel25.add(jRadioButton50);
        jRadioButton50.setBounds(590, 40, 100, 25);

        jPanel24.add(jPanel25);
        jPanel25.setBounds(20, 980, 930, 90);

        jPanel22.add(jPanel24);
        jPanel24.setBounds(20, 980, 930, 90);

        btnGroupEstadoOrden.add(rbEstadoOrden1);
        rbEstadoOrden1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        rbEstadoOrden1.setText("Finalizada");
        jPanel22.add(rbEstadoOrden1);
        rbEstadoOrden1.setBounds(240, 40, 220, 25);

        btnGroupEstadoOrden.add(rbEstadoOrden0);
        rbEstadoOrden0.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        rbEstadoOrden0.setSelected(true);
        rbEstadoOrden0.setText("Pendiente");
        jPanel22.add(rbEstadoOrden0);
        rbEstadoOrden0.setBounds(20, 40, 200, 25);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(inputPlantel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(15, 15, 15)
                                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(301, 301, 301))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(inputPlantel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jScrollPane2.setViewportView(jPanel2);

        tabbedPane.addTab("Nueva", jScrollPane2);

        getContentPane().add(tabbedPane);
        tabbedPane.setBounds(20, 110, 960, 530);

        tiMenu.setText("TI");

        ordenesMenu.setText("Órdenes");
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
        tiMenu.add(repuestosMenu);

        fallasMenu.setText("Fallas");
        tiMenu.add(fallasMenu);

        diagnosticosMenu.setText("Diagnósticos");
        tiMenu.add(diagnosticosMenu);

        jMenuBar1.add(tiMenu);

        rrhhMenu.setText("RRHH");
        jMenuBar1.add(rrhhMenu);

        salir.setText("Salir");
        jMenuBar1.add(salir);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown

    }//GEN-LAST:event_jPanel2ComponentShown

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        OrdenesDAO ordenDAO = new OrdenesDAO();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        EquipoDAO equipoDAO = new EquipoDAO();
        TipoDAO tipoDAO = new TipoDAO();
        Detalle_Falla detalle_falla;
        Detalle_Diagnostico detalle_diagnostico;
        Vector<Detalle_Falla> detalle_fallas = new Vector<Detalle_Falla>();
        Vector<Detalle_Diagnostico> detalle_diagnosticos = new Vector<Detalle_Diagnostico>();
        
        Util u = new Util();
        
        if(orden == null) {
            orden = new Orden_Servicio();
        }

        if(validar()) {
            if(this.btnGuardar.getText().equals("Guardar")) {
                id = u.idNext("Ordenes_Servicio", "id_ordenServicio");
            } 
            
            orden.setPlantel(this.inputPlantel.getText());
            orden.setUsuario(usuario);
            orden.setEquipo(equipo);
            orden.setObserRec(this.inputObsRec.getText());
            orden.setEmplRec(this.empRec);
            orden.setObserDev(this.inputObsDev.getText());
            orden.setEmplDev(empDev);
            
            for(int i = 0; i < fallas.size(); i++) {
                detalle_falla = new Detalle_Falla();
                detalle_falla.setOrden_servicio(id);
                detalle_falla.setId_falla(fallas.get(i).getId_falla());
                detalle_fallas.add(detalle_falla);
            }
            
            for(int i = 0; i < detalle_repuestos.size(); i++) {
                detalle_repuestos.get(i).setOrden_servicio(id);
            }
            
            for(int i = 0; i < diagnosticos.size(); i++) {
                detalle_diagnostico = new Detalle_Diagnostico();
                detalle_diagnostico.setId_diagnostico(diagnosticos.get(i).getId_diagnostico());
                detalle_diagnostico.setOrden_servicio(id);
                detalle_diagnosticos.add(detalle_diagnostico);
            }
            
            if(this.rbTipoMant1.isSelected()) {
                orden.setTipoMant(tipoDAO.buscarTipo(1));
            } else if(this.rbTipoMant2.isSelected()) {
                orden.setTipoMant(tipoDAO.buscarTipo(2));
            } else if(this.rbTipoMant3.isSelected()) {
                orden.setTipoMant(tipoDAO.buscarTipo(3));
            } else if(this.rbTipoMant4.isSelected()) {
                orden.setTipoMant(tipoDAO.buscarTipo(4));
            } else if(this.rbTipoMant5.isSelected()) {
                orden.setTipoMant(tipoDAO.buscarTipo(5));
            }           
            
            if(this.rbEstadoOrden0.isSelected()) {
                orden.setEstado(0);
            } else if (this.rbEstadoOrden1.isSelected()) {
                orden.setEstado(1);
            }
 
            if(this.btnGuardar.getText().equals("Guardar")) {
                orden.setId_ordenServicio(id);
                ordenDAO.registrarOrden(orden, "i");
                detalleFallaDAO.registrarDetalle(detalle_fallas, "i");
                detalleRepuestoDAO.registrarDetalle(detalle_repuestos, "i");
                detalleDiagnosticoDAO.registrarDetalle(detalle_diagnosticos, "i");
                
            } else {
                ordenDAO.registrarOrden(orden, "u");
                detalleFallaDAO.registrarDetalle(detalle_fallas, "u");
                detalleRepuestoDAO.registrarDetalle(detalle_repuestos, "u");
                detalleDiagnosticoDAO.registrarDetalle(detalle_diagnosticos, "u");
            }
            
            limpiar();
            this.poblarTabla(false, "");
            this.tabbedPane.setSelectedIndex(0);
            this.tabbedPane.setTitleAt(1, "Nueva");
            JOptionPane.showMessageDialog(this, "Orden registrada exitosamente.");   
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void inputEmpDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEmpDevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEmpDevActionPerformed

    private void btnEmpDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpDevActionPerformed
        EmpleadosDlg usuariosDialog = new EmpleadosDlg(new javax.swing.JFrame(), true, hd, wd);
        usuariosDialog.setVisible(true);

        if(usuariosDialog.getEmpleado() != null) {
            empDev = usuariosDialog.getEmpleado();
            this.inputEmpDev.setText(empDev.getNombreCompleto());
        }
    }//GEN-LAST:event_btnEmpDevActionPerformed

    private void btnEmpRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpRecActionPerformed
        EmpleadosDlg usuariosDialog = new EmpleadosDlg(new javax.swing.JFrame(), true, hd, wd);
        usuariosDialog.setVisible(true);

        if(usuariosDialog.getEmpleado() != null) {
            empRec = usuariosDialog.getEmpleado();
            this.inputEmpRec.setText(empRec.getNombreCompleto());
        }
    }//GEN-LAST:event_btnEmpRecActionPerformed

    private void inputEmpRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEmpRecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEmpRecActionPerformed

    private void btnBuscarDiagnosticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDiagnosticosActionPerformed
        DiagnosticosDlg diagnosticosDlg = new DiagnosticosDlg(new javax.swing.JFrame(), true, hd, wd);
        diagnosticosDlg.setVisible(true);
        
        if(diagnosticosDlg.getDiagnostico() != null) {
            int sw = 0;
            for(int i = 0; i < diagnosticos.size(); i++) {
                if(diagnosticos.get(i).getId_diagnostico() == diagnosticosDlg.getDiagnostico().getId_diagnostico()) {
                    sw = 1;
                    JOptionPane.showMessageDialog(this, "El diagnóstico seleccionado ya fue ingresado anteriormente.");
                }
            }
            
            if(sw == 0) {
                diagnosticos.add(diagnosticosDlg.getDiagnostico());
                Vector vector = new Vector();
                vector.add(diagnosticosDlg.getDiagnostico().getId_diagnostico());
                vector.add(diagnosticosDlg.getDiagnostico().getDiag_desc());
                dtmDiagnosticos.addRow(vector);
            }
        }
    }//GEN-LAST:event_btnBuscarDiagnosticosActionPerformed

    private void btnBuscarRepuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRepuestosActionPerformed
        RepuestosDlg repuestosDlg = new RepuestosDlg(new javax.swing.JFrame(), true, hd, wd);
        repuestosDlg.setVisible(true);
        Repuesto repuesto = new Repuesto();
        int cantidad;
        String tipo;
        Detalle_Repuesto detalle_repuesto = new Detalle_Repuesto();
        
        if(repuestosDlg.getRepuesto() != null) {
            int sw = 0;
            repuesto = (Repuesto) repuestosDlg.getRepuesto().get(0);
            cantidad = Integer.parseInt(repuestosDlg.getRepuesto().get(1).toString());
            tipo = repuestosDlg.getRepuesto().get(2).toString();
            
            for(int i = 0; i < repuestos.size(); i++) {
                if(repuestos.get(i).getId_repuesto() == repuesto.getId_repuesto()) {
                    sw = 1;
                    JOptionPane.showMessageDialog(this, "El repuesto seleccionado ya fue ingresado anteriormente.");
                }
            }
            
            if(sw == 0) {
                repuestos.add(repuesto);
                Vector vector = new Vector();
                vector.add(repuesto.getId_repuesto());
                vector.add(repuesto.getRep_desc());
                vector.add(cantidad);
                vector.add(tipo);
                dtmRepuestos.addRow(vector);
                detalle_repuesto.setId_repuesto(repuesto.getId_repuesto());
                detalle_repuesto.setRep_cant(cantidad);
                detalle_repuesto.setRep_tipo(tipo);
                detalle_repuestos.add(detalle_repuesto);
            }
        }
    }//GEN-LAST:event_btnBuscarRepuestosActionPerformed

    private void btnBuscarFallasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFallasActionPerformed
        FallasDlg fallasDlg = new FallasDlg(new javax.swing.JFrame(), true, hd, wd);
        fallasDlg.setVisible(true);

        if(fallasDlg.getFalla() != null) {
            int sw = 0;
            for(int i = 0; i < fallas.size(); i++) {
                if(fallas.get(i).getId_falla() == fallasDlg.getFalla().getId_falla()) {
                    sw = 1;
                    JOptionPane.showMessageDialog(this, "La falla seleccionada ya fue ingresada anteriormente.");
                }
            }
            
            if(sw == 0) {
                fallas.add(fallasDlg.getFalla());
                Vector vector = new Vector();
                vector.add(fallasDlg.getFalla().getId_falla());
                vector.add(fallasDlg.getFalla().getTipo_falla());
                vector.add(fallasDlg.getFalla().getFalla_desc());
                dtmFallas.addRow(vector);
            }
        }
    }//GEN-LAST:event_btnBuscarFallasActionPerformed

    private void rbEstadoEquipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEstadoEquipo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbEstadoEquipo1ActionPerformed

    private void rbEstadoEquipo0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEstadoEquipo0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbEstadoEquipo0ActionPerformed

    private void inputMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputMarcaActionPerformed

    private void inputNroSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNroSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNroSerieActionPerformed

    private void btnBuscarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEquiposActionPerformed
        EquiposDlg equiposDlg = new EquiposDlg(new javax.swing.JFrame(), true, hd, wd);
        equiposDlg.setVisible(true);
        
        if(equiposDlg.getEquipo() != null) {
            equipo = equiposDlg.getEquipo();
            this.inputMarca.setText(equipo.getMarca());
            this.inputModelo.setText(equipo.getModelo());
            this.inputNroSerie.setText(equipo.getNum_serie());

            if(equipo.getEstado() == 0) {
                this.rbEstadoEquipo0.setSelected(true);
            } else {
                this.rbEstadoEquipo1.setSelected(true);
            }
        }
    }//GEN-LAST:event_btnBuscarEquiposActionPerformed

    private void inputModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputModeloActionPerformed

    private void rbEstadoUsuario0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEstadoUsuario0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbEstadoUsuario0ActionPerformed

    private void rbEstadoUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEstadoUsuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbEstadoUsuario1ActionPerformed

    private void inputAreaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputAreaUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputAreaUsuarioActionPerformed

    private void rbTipoUsuario0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTipoUsuario0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbTipoUsuario0ActionPerformed

    private void rbTipoUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTipoUsuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbTipoUsuario1ActionPerformed

    private void btnBuscarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuariosActionPerformed
        EmpleadosDlg usuariosDialog = new EmpleadosDlg(new javax.swing.JFrame(), true, hd, wd);
        usuariosDialog.setVisible(true);

        if(usuariosDialog.getEmpleado() != null) {
            usuario = usuariosDialog.getEmpleado();
            this.inputNombreUsuario.setText(usuario.getNombreCompleto());
            this.inputAreaUsuario.setText(usuario.getArea());

            if(usuario.getTipo() == 0) {
                this.rbTipoUsuario0.setSelected(true);
            } else {
                this.rbTipoUsuario1.setSelected(true);
            }

            if(usuario.getEstado() == 0) {
                this.rbEstadoUsuario0.setSelected(true);
            } else {
                this.rbEstadoUsuario1.setSelected(true);
            }
        }
    }//GEN-LAST:event_btnBuscarUsuariosActionPerformed

    private void inputNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombreUsuarioActionPerformed

    private void inputPlantelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPlantelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPlantelActionPerformed

    private void tabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPaneStateChanged

    }//GEN-LAST:event_tabbedPaneStateChanged

    private void inputBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputBusquedaActionPerformed

    }//GEN-LAST:event_inputBusquedaActionPerformed

    private void jLabel4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel4AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4AncestorAdded

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.tabbedPane.setSelectedIndex(1);
        this.tabbedPane.setTitleAt(1, "Edición");
        this.btnGuardar.setText("Actualizar");
        
        this.inputPlantel.setText(orden.getPlantel());
        this.inputNombreUsuario.setText(usuario.getNombreCompleto());
        this.inputAreaUsuario.setText(usuario.getArea());
        
        if(usuario.getTipo() == 0) {
            this.rbTipoUsuario0.setSelected(true);
        } else if (usuario.getTipo() == 1) {
            this.rbTipoUsuario1.setSelected(true);   
        }
        
        if(usuario.getEstado() == 0) {
            this.rbEstadoUsuario0.setSelected(true);
        } else if(usuario.getEstado() == 1) {
            this.rbEstadoUsuario1.setSelected(true);
        }        
        
        this.inputMarca.setText(equipo.getMarca());
        this.inputModelo.setText(equipo.getModelo());
        this.inputNroSerie.setText(equipo.getNum_serie());
        
        if(equipo.getEstado() == 0) {
            this.rbEstadoEquipo0.setSelected(true);
        } else if(equipo.getEstado() == 1) {
            this.rbEstadoEquipo1.setSelected(true);
        }
        
        dtmFallas.setRowCount(0);
        for(int i = 0; i < fallas.size(); i++) {
            Falla falla = fallas.get(i);
            Vector vector = new Vector();
            vector.add(falla.getId_falla());
            vector.add(falla.getTipo_falla());
            vector.add(falla.getFalla_desc());
            dtmFallas.addRow(vector);
        }
        
        RepuestoDAO repuestoDAO = new RepuestoDAO();
        
        dtmRepuestos.setRowCount(0);
        for(int i = 0; i < detalle_repuestos.size(); i++) {
            Detalle_Repuesto detalle_repuesto = detalle_repuestos.get(i);
            Repuesto repuesto = repuestoDAO.buscarRepuesto(detalle_repuesto.getId_repuesto());
            Vector vector = new Vector();
            vector.add(detalle_repuesto.getId_repuesto());
            vector.add(repuesto.getRep_desc());
            vector.add(detalle_repuesto.getRep_cant());
            vector.add(detalle_repuesto.getRep_tipo());
            dtmRepuestos.addRow(vector);
        }
        
        dtmDiagnosticos.setRowCount(0);
        for(int i = 0; i < diagnosticos.size(); i++) {
            Diagnostico diagnostico = diagnosticos.get(i);
            Vector vector = new Vector();
            vector.add(diagnostico.getId_diagnostico());
            vector.add(diagnostico.getDiag_desc());
            dtmDiagnosticos.addRow(vector);
        }
       
        if(orden.getTipoMant().getId_tipoMant() == 1) {
            this.rbTipoMant1.setSelected(true);
        } else if(orden.getTipoMant().getId_tipoMant() == 2) {
            this.rbTipoMant2.setSelected(true);
        } else if(orden.getTipoMant().getId_tipoMant() == 3) {
            this.rbTipoMant3.setSelected(true);
        } else if(orden.getTipoMant().getId_tipoMant() == 4) {
            this.rbTipoMant4.setSelected(true);
        } else if(orden.getTipoMant().getId_tipoMant() == 5) {
            this.rbTipoMant5.setSelected(true);
        }
        
        this.inputObsRec.setText(orden.getObserRec());
        this.inputObsDev.setText(orden.getObserDev());    
        this.inputEmpRec.setText(empRec.getNombreCompleto());
        this.inputEmpDev.setText(empDev.getNombreCompleto());
        
        if(orden.getEstado() == 0) {
            this.rbEstadoOrden0.setSelected(true);
        } else if(orden.getEstado() == 1) {
            this.rbEstadoOrden1.setSelected(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdenesMouseClicked
        int fila = this.tblOrdenes.getSelectedRow();
        orden = ordenes.get(fila);
        id = orden.getId_ordenServicio();
        usuario = orden.getUsuario();
        equipo = orden.getEquipo();
        fallas = detalleFallaDAO.buscarDetalle(id);
        repuestos = detalleRepuestoDAO.buscarRepuestos(id);
        diagnosticos = detalleDiagnosticoDAO.buscarDetalle(id);
        detalle_repuestos = detalleRepuestoDAO.buscarDetalle(id);
        empRec = orden.getEmplRec();
        empDev = orden.getEmplDev();
    }//GEN-LAST:event_tblOrdenesMouseClicked

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        limpiar();
        this.tabbedPane.setTitleAt(1, "Nueva");
        this.tabbedPane.setSelectedIndex(0);
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void equiposMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equiposMenuActionPerformed
        EquiposFrm equiposFrm = new EquiposFrm();
        equiposFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_equiposMenuActionPerformed

    private void equiposMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equiposMenuMouseClicked
        
        
    }//GEN-LAST:event_equiposMenuMouseClicked

    private void inputBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputBusquedaKeyTyped

    }//GEN-LAST:event_inputBusquedaKeyTyped

    private void inputBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputBusquedaKeyReleased
        dtmOrdenes.setRowCount(0);
        
        String filtro = inputBusqueda.getText();
        if(filtro.isEmpty()) {
            poblarTabla(false, "");
        } else {
            poblarTabla(true, filtro);
        }
    }//GEN-LAST:event_inputBusquedaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarDiagnosticos;
    private javax.swing.JButton btnBuscarEquipos;
    private javax.swing.JButton btnBuscarFallas;
    private javax.swing.JButton btnBuscarRepuestos;
    private javax.swing.JButton btnBuscarUsuarios;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEmpDev;
    private javax.swing.JButton btnEmpRec;
    private javax.swing.ButtonGroup btnGroupEstadoEquipo;
    private javax.swing.ButtonGroup btnGroupEstadoOrden;
    private javax.swing.ButtonGroup btnGroupEstadoUsuario;
    private javax.swing.ButtonGroup btnGroupTipoMant;
    private javax.swing.ButtonGroup btnGroupTipoUsuario;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JMenuItem diagnosticosMenu;
    private javax.swing.JMenuItem equiposMenu;
    private javax.swing.JMenuItem fallasMenu;
    private javax.swing.JTextField inputAreaUsuario;
    private javax.swing.JTextField inputBusqueda;
    private javax.swing.JTextField inputEmpDev;
    private javax.swing.JTextField inputEmpRec;
    private javax.swing.JTextField inputMarca;
    private javax.swing.JTextField inputModelo;
    private javax.swing.JTextField inputNombreUsuario;
    private javax.swing.JTextField inputNroSerie;
    private javax.swing.JTextField inputObsDev;
    private javax.swing.JTextField inputObsRec;
    private javax.swing.JTextField inputPlantel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JRadioButton jRadioButton24;
    private javax.swing.JRadioButton jRadioButton25;
    private javax.swing.JRadioButton jRadioButton26;
    private javax.swing.JRadioButton jRadioButton27;
    private javax.swing.JRadioButton jRadioButton28;
    private javax.swing.JRadioButton jRadioButton29;
    private javax.swing.JRadioButton jRadioButton30;
    private javax.swing.JRadioButton jRadioButton31;
    private javax.swing.JRadioButton jRadioButton32;
    private javax.swing.JRadioButton jRadioButton33;
    private javax.swing.JRadioButton jRadioButton34;
    private javax.swing.JRadioButton jRadioButton35;
    private javax.swing.JRadioButton jRadioButton36;
    private javax.swing.JRadioButton jRadioButton37;
    private javax.swing.JRadioButton jRadioButton38;
    private javax.swing.JRadioButton jRadioButton39;
    private javax.swing.JRadioButton jRadioButton40;
    private javax.swing.JRadioButton jRadioButton41;
    private javax.swing.JRadioButton jRadioButton42;
    private javax.swing.JRadioButton jRadioButton43;
    private javax.swing.JRadioButton jRadioButton44;
    private javax.swing.JRadioButton jRadioButton45;
    private javax.swing.JRadioButton jRadioButton46;
    private javax.swing.JRadioButton jRadioButton47;
    private javax.swing.JRadioButton jRadioButton48;
    private javax.swing.JRadioButton jRadioButton49;
    private javax.swing.JRadioButton jRadioButton50;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JMenuItem ordenesMenu;
    private javax.swing.JRadioButton rbEstadoEquipo0;
    private javax.swing.JRadioButton rbEstadoEquipo1;
    private javax.swing.JRadioButton rbEstadoOrden0;
    private javax.swing.JRadioButton rbEstadoOrden1;
    private javax.swing.JRadioButton rbEstadoUsuario0;
    private javax.swing.JRadioButton rbEstadoUsuario1;
    private javax.swing.JRadioButton rbTipoMant1;
    private javax.swing.JRadioButton rbTipoMant2;
    private javax.swing.JRadioButton rbTipoMant3;
    private javax.swing.JRadioButton rbTipoMant4;
    private javax.swing.JRadioButton rbTipoMant5;
    private javax.swing.JRadioButton rbTipoUsuario0;
    private javax.swing.JRadioButton rbTipoUsuario1;
    private javax.swing.JMenuItem repuestosMenu;
    private javax.swing.JMenu rrhhMenu;
    private javax.swing.JMenu salir;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tblDiagnosticos;
    private javax.swing.JTable tblFallas;
    private javax.swing.JTable tblOrdenes;
    private javax.swing.JTable tblRepuestos;
    private javax.swing.JMenu tiMenu;
    // End of variables declaration//GEN-END:variables
}

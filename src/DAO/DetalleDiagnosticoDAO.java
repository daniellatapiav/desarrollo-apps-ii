package DAO;

import BEAN.Detalle_Diagnostico;
import BEAN.Diagnostico;
import java.sql.*;
import java.util.Vector;
import util.dbBean;

public class DetalleDiagnosticoDAO {
    DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO();
    
    public Vector<Diagnostico> buscarDetalle(int id_orden) {
        Vector<Detalle_Diagnostico> detalle_diagnosticos = new Vector<Detalle_Diagnostico>();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Detalle_Diagnosticos WHERE id_ordenServicio = " + id_orden;
        ResultSet resultSet;
        Detalle_Diagnostico detalle_diagnostico;
        
        try {
            resultSet = db.execSql(sql);
            while(resultSet.next()) {
                detalle_diagnostico = new Detalle_Diagnostico();
                detalle_diagnostico.setOrden_servicio(resultSet.getInt(1));
                detalle_diagnostico.setId_diagnostico(resultSet.getInt(2));
                detalle_diagnosticos.add(detalle_diagnostico);
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        Vector<Diagnostico> diagnosticos = new Vector<Diagnostico>();
        Diagnostico diagnostico;
        
        for(int i = 0; i < detalle_diagnosticos.size(); i++) {
            diagnostico = diagnosticoDAO.buscarDiagnostico(detalle_diagnosticos.elementAt(i).getId_diagnostico());
            diagnosticos.add(diagnostico);
        }
        
        return diagnosticos;
    }
    
    public boolean registrarDetalle(Vector<Detalle_Diagnostico> detalle_diagnosticos, String procedimiento) {
        boolean sw = false;
        dbBean db = new dbBean();
        String sql = "";
       
        int id_orden, id_diagnostico;
        
        for(int i = 0; i < detalle_diagnosticos.size(); i++) {
            id_orden = detalle_diagnosticos.get(i).getOrden_servicio();
            id_diagnostico = detalle_diagnosticos.get(i).getId_diagnostico();
            
            if (procedimiento.toLowerCase().equals("i")) {
            sql = "INSERT INTO Detalle_Diagnosticos VALUES("
                    + id_orden + ", " + id_diagnostico + ")";
            } else if (procedimiento.toLowerCase().equals("u")) {
                sql = "UPDATE Detalle_Diagnosticos SET id_ordenServicio = " + id_orden + ", id_diagnostico = " + id_diagnostico
                        + " WHERE id_ordenServicio = " + id_orden + "AND id_diagnostico = " + id_diagnostico;
            }
            
            System.out.println(sql);
            
            try {
                db.insUpd(sql);
                sw = true;
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        
        try {
            db.disconnect();
            sw = true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return sw;
    }
}

package DAO;

import BEAN.Diagnostico;
import java.sql.*;
import java.util.Vector;
import util.dbBean;

public class DiagnosticoDAO {
    
    public Diagnostico buscarDiagnostico(int id) {
        Diagnostico diagnostico = new Diagnostico();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Diagnosticos WHERE id_diagnostico = " + id;
        
        try {
            ResultSet resultSet = db.execSql(sql);
            
            while(resultSet.next()) {
                diagnostico.setId_diagnostico(resultSet.getInt(1));
                diagnostico.setDiag_desc(resultSet.getString(2));
            }
                
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return diagnostico;
    }
    
    public Vector<Diagnostico> listarDiagnosticos(boolean siFiltrar, String filtro) {
        Vector<Diagnostico> diagnosticos = new Vector<Diagnostico>();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Diagnosticos";
        ResultSet resultSet;
        Diagnostico diagnostico;
        
        if(siFiltrar) {
            sql = sql + " WHERE diag_desc LIKE '%" + filtro + "%'";
        }
        
        try{
            resultSet = db.execSql(sql);
            while(resultSet.next()) {
                diagnostico = new Diagnostico();
                diagnostico.setId_diagnostico(resultSet.getInt(1));
                diagnostico.setDiag_desc(resultSet.getString(2));
                diagnosticos.add(diagnostico);
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return diagnosticos;
    }
}

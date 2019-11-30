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
    
    public boolean registrarDiagnostico(Diagnostico var, String procedimiento) {
        boolean sw = false;
        dbBean db = new dbBean();
        String sql = "";
        
        if (procedimiento.toLowerCase().equals("insert")) {
            sql = "INSERT INTO [dbo].[Diagnosticos]([id_diagnostico],[diag_desc])  "
                    + " VALUES ("+var.getId_diagnostico()+",'"+var.getDiag_desc()+"' )";
        } else if (procedimiento.toLowerCase().equals("update")) {
            sql = "UPDATE Diagnosticos SET diag_desc='"+var.getDiag_desc()+"'  "
                    + " WHERE id_diagnostico = " + var.getId_diagnostico();
        }
        
        System.out.println(sql);
        
        try {
            db.insUpd(sql);
            sw = true;
        } catch(SQLException e) {
            e.printStackTrace();
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

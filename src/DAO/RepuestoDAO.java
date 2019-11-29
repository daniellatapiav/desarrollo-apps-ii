package DAO;

import BEAN.Repuesto;
import java.sql.*;
import java.util.Vector;
import util.dbBean;

public class RepuestoDAO {
    
    public Repuesto buscarRepuesto(int id) {
        Repuesto repuesto = new Repuesto();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Repuestos WHERE id_repuesto = " + id;
        
        try {
            ResultSet resultSet = db.execSql(sql);
            
            while(resultSet.next()) {
                repuesto.setId_repuesto(resultSet.getInt(1));
                repuesto.setRep_desc(resultSet.getString(2));
                repuesto.setCosto_unitario(resultSet.getFloat(3));
            }
                
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return repuesto;
    }
    
    public Vector<Repuesto> listarRepuestos(boolean siFiltrar, String filtro) {
        Vector<Repuesto> repuestos = new Vector<Repuesto>();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Repuestos";
        ResultSet resultSet;
        Repuesto repuesto;
        
        if(siFiltrar) {
            sql = sql + " WHERE rep_desc LIKE '%" + filtro + "%'";
        }
        
        try{
            resultSet = db.execSql(sql);
            while(resultSet.next()) {
                repuesto = new Repuesto();
                repuesto.setId_repuesto(resultSet.getInt(1));
                repuesto.setRep_desc(resultSet.getString(2));
                repuesto.setCosto_unitario(resultSet.getFloat(3));
                repuestos.add(repuesto);
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return repuestos;
    }
}

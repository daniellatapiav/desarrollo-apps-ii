package DAO;

import BEAN.Falla;
import java.sql.*;
import java.util.Vector;
import util.dbBean;

public class FallaDAO {
    
    public Falla buscarFalla(int id) {
        Falla falla = new Falla();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Fallas WHERE id_falla = " + id;
        
        try {
            ResultSet resultSet = db.execSql(sql);
            
            while(resultSet.next()) {
                falla.setId_falla(resultSet.getInt(1));
                falla.setTipo_falla(resultSet.getString(2));
                falla.setFalla_desc(resultSet.getString(3));
            }
                
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return falla;
    }
    
    public Vector<Falla> listarFallas(boolean siFiltrar, String filtro) {
        Vector<Falla> fallas = new Vector<Falla>();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Fallas";
        ResultSet resultSet;
        Falla falla;
        
        if(siFiltrar) {
            sql = sql + " WHERE tipo_falla LIKE '%" + filtro + "%' OR falla_desc LIKE '%" + filtro + "%'";
        }
        
        try{
            resultSet = db.execSql(sql);
            while(resultSet.next()) {
                falla = new Falla();
                falla.setId_falla(resultSet.getInt(1));
                falla.setTipo_falla(resultSet.getString(2));
                falla.setFalla_desc(resultSet.getString(3));
                fallas.add(falla);
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return fallas;
    }
    
    public boolean registrarEquipo(Falla fall, String procedimiento) {
        boolean sw = false;
        dbBean db = new dbBean();
        String sql = "";
        if (procedimiento.toLowerCase().equals("insert")) {
            sql = "INSERT INTO [dbo].[Fallas]([id_falla],[tipo_falla],[falla_desc])  "
                    + " VALUES ("+fall.getId_falla()+",'"+fall.getTipo_falla()+"','"+fall.getFalla_desc()+"' )";
        } else if (procedimiento.toLowerCase().equals("update")) {
            sql = "UPDATE Fallas SET tipo_falla='"+fall.getTipo_falla()+"',falla_desc='"+fall.getFalla_desc()+"' "
                    + " WHERE id_falla = " + fall.getId_falla();
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

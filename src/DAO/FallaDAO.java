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
}

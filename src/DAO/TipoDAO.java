package DAO;

import BEAN.Tipo_Mantenimiento;
import java.sql.*;
import java.util.Vector;
import util.dbBean;

public class TipoDAO {
    
    public Tipo_Mantenimiento buscarTipo(int id) {
        Tipo_Mantenimiento tipo = new Tipo_Mantenimiento();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Tipos_Mantenimiento WHERE id_TipoMant = " + id;
        
        try {
            ResultSet resultSet = db.execSql(sql);
            
            while(resultSet.next()) {
                tipo.setId_tipoMant(resultSet.getInt(1));
                tipo.setTipoMant_desc(resultSet.getString(2));
            }
                
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return tipo;
    }
    
    public Vector<Tipo_Mantenimiento> listarTipos(boolean siFiltrar, String filtro) {
        Vector<Tipo_Mantenimiento> tipos = new Vector<Tipo_Mantenimiento>();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Tipos_Mantenimiento";
        ResultSet resultSet;
        Tipo_Mantenimiento tipo;
        
        if(siFiltrar) {
            sql = sql + " WHERE tipoMant_desc LIKE '%" + filtro + "%'";
        }
        
        try{
            resultSet = db.execSql(sql);
            while(resultSet.next()) {
                tipo = new Tipo_Mantenimiento();
                tipo.setId_tipoMant(resultSet.getInt(1));
                tipo.setTipoMant_desc(resultSet.getString(2));
                tipos.add(tipo);
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return tipos;
    }
}

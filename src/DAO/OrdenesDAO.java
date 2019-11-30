package DAO;

import BEAN.Empleado;
import BEAN.Equipo;
import BEAN.Orden_Servicio;
import BEAN.Tipo_Mantenimiento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.dbBean;

public class OrdenesDAO {
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    EquipoDAO equipoDAO = new EquipoDAO();
    TipoDAO tipoDAO = new TipoDAO();
    
    public Orden_Servicio buscarOrden(int id) {
        Orden_Servicio orden = new Orden_Servicio();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Ordenes_Servicio WHERE id_ordenServicio = " + id;
        
        try {
            ResultSet resultSet = db.execSql(sql);
            
            while(resultSet.next()) {
                orden.setId_ordenServicio(resultSet.getInt(1));
                orden.setFecha_mant(resultSet.getString(2));
                orden.setPlantel(resultSet.getString(3));
                Empleado empleado1 = empleadoDAO.buscarEmpleado(resultSet.getInt(4));
                orden.setUsuario(empleado1);
                Equipo equipo = equipoDAO.buscarEquipo(resultSet.getInt(5));
                orden.setEquipo(equipo);
                Tipo_Mantenimiento tipo = tipoDAO.buscarTipo(resultSet.getInt(6));
                orden.setTipoMant(tipo);
                orden.setObserRec(resultSet.getString(7));
                orden.setObserDev(resultSet.getString(8));
                Empleado empleado2 = empleadoDAO.buscarEmpleado(resultSet.getInt(9));
                orden.setEmplRec(empleado2);
                Empleado empleado3 = empleadoDAO.buscarEmpleado(resultSet.getInt(10));
                orden.setEmplDev(empleado3);
                orden.setEstado(resultSet.getInt(11));
            }
                
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return orden;
    }
    
    public Vector<Orden_Servicio> listarOrdenes(boolean siFiltrar, String filtro) {
        Vector<Orden_Servicio> ordenes = new Vector<Orden_Servicio>();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Ordenes_Servicio";
        ResultSet resultSet;
        Orden_Servicio orden;
        
        if(siFiltrar) {
            sql = sql + " WHERE id_ordenServicio LIKE '%" + filtro + "%'";
        }
        
        try{
            resultSet = db.execSql(sql);
            while(resultSet.next()) {
                orden = new Orden_Servicio();
                orden.setId_ordenServicio(resultSet.getInt(1));
                orden.setFecha_mant(resultSet.getString(2));
                orden.setPlantel(resultSet.getString(3));
                Empleado empleado1 = empleadoDAO.buscarEmpleado(resultSet.getInt(4));
                orden.setUsuario(empleado1);
                Equipo equipo = equipoDAO.buscarEquipo(resultSet.getInt(5));
                orden.setEquipo(equipo);
                Tipo_Mantenimiento tipo = tipoDAO.buscarTipo(resultSet.getInt(6));
                orden.setTipoMant(tipo);
                orden.setObserRec(resultSet.getString(7));
                orden.setObserDev(resultSet.getString(8));
                Empleado empleado2 = empleadoDAO.buscarEmpleado(resultSet.getInt(9));
                orden.setEmplRec(empleado2);
                Empleado empleado3 = empleadoDAO.buscarEmpleado(resultSet.getInt(10));
                orden.setEmplDev(empleado3);
                orden.setEstado(resultSet.getInt(11));
                ordenes.add(orden);
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return ordenes;
    }
    
    public boolean registrarOrden(Orden_Servicio orden, String procedimiento) {
        boolean sw = false;
        dbBean db = new dbBean();
        String sql = "";
        
        int id, estado, id_usuario, id_equipo, id_tipo, id_empRec, id_empDev;
        String fecha, plantel, obserRec, obserDev;
        
        id = orden.getId_ordenServicio();
        plantel = orden.getPlantel();
        id_usuario = orden.getUsuario().getId_empleado();
        id_equipo = orden.getEquipo().getId_equipo();
        id_tipo = orden.getTipoMant().getId_tipoMant();
        obserRec = orden.getObserRec();
        obserDev = orden.getObserDev();
        id_empRec = orden.getEmplRec().getId_empleado();
        id_empDev = orden.getEmplDev().getId_empleado();
        estado = orden.getEstado();
       
        
        if (procedimiento.toLowerCase().equals("i")) {
            sql = "INSERT INTO Ordenes_Servicio VALUES("
                    + id + ", CURDATE(), '" + plantel + "', " + id_usuario + ", " + id_equipo + ", "
                    + id_tipo + ", '" + obserRec + "', '" + obserDev + "', " + id_empRec + ", " + id_empDev + ", " + estado + ")";
        } else if (procedimiento.toLowerCase().equals("u")) {
            sql = "UPDATE Ordenes_Servicio SET id_ordenServicio = " + id + ", plantel = '" + plantel + "', id_usuario = " + id_usuario + ", id_equipo = " + id_equipo
                    + ", id_tipoMant = " + id_tipo + ", obserRec = '" + obserRec + "', obserDev = '" + obserDev
                    + "', id_emplRec = " + id_empRec + ", id_emplDev = " + id_empDev + ", estado = " + estado + " WHERE id_ordenServicio = " + id;
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

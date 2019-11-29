package util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {

    public Util(){

    }

    public static int idNext(String nombTbl, String nombCamp) {
        dbBean con = new dbBean();
        int countReg, IM = 0;
        try{
            String sql = "SELECT COUNT("+ nombCamp +") AS idMax FROM "+ nombTbl +"";
            ResultSet result = con.execSql(sql);
            if(result.next()){
                countReg = result.getInt(1);
                result.close();
                if(countReg > 0){
                    try{
                        sql = "SELECT MAX("+ nombCamp +") AS idMax FROM "+ nombTbl +"";
                        
                        ResultSet result1 = con.execSql(sql);
                        if(result1.next()){
                            IM = result1.getInt(1) + 1;
                        }
                        result1.close();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }else{
                    IM++;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            con.disconnect();
        }catch(SQLException e){}
        return IM;
    }
    public int estados(String whatEver){
        int x = 0;
        if(whatEver.equals("No Activo") ){
            x = 0;
        }
        if(whatEver.equals("Activo") ){
            x = 1;
        }
        if(whatEver.equals("Anulado") ){
            x = 2;
        }
        if(whatEver.equals("De Baja")){
            x = 3;
        }
        return x;
       
    }

    public String estados(int whatEver){
        String cad = "";
        switch (whatEver){
            case 0:
                cad = "No Activo";
                break;
            case 1:
                cad = "Activo";
                break;
            case 2:
                cad = "Anulado";
                break;
            case 3:
                cad = "De Baja";
                break;
        }
        return cad;
    }

    public boolean repExp(String nombTbl, String nombCamp, String cad){
        dbBean con = new dbBean();
        int countReg;
        boolean sw = false;
        try{
            String sql = "SELECT * FROM "+ nombTbl +" where "+ nombCamp +" = '"+ cad +"'";
            ResultSet result = con.execSql(sql);
            if(result.next()){
                countReg = result.getInt(1);
                result.close();
                if(countReg > 0){
                    sw = true;
                }else{
                    sw = false;
                }
            }else{
                sw = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            con.disconnect();
        }catch(SQLException e){}
        return sw;
    }
    
    public String cadExp(String nombTbl, String campID, String nomCampBusq, String cad){
        String cade = "";
        dbBean con = new dbBean();
        try{
            String sql = "select "+ nomCampBusq +" from "+ nombTbl +" where "+ campID +" = '"+ cad +"'";
            ResultSet result = con.execSql(sql);
            if(result.next()){
                cade = result.getString(1);
            }else{
                cade = "";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            con.disconnect();
        }catch(SQLException e){}
        return cade;
    }
    
    public int idExp(String nombTbl, String campID, String nomCampBusq, String cad){
        int id = 0;
        dbBean con = new dbBean();
        try{
            String sql = "select "+ campID +" from "+ nombTbl +" where "+ nomCampBusq +" = '"+ cad +"'";
            ResultSet result = con.execSql(sql);
            if(result.next()){
                id = result.getInt(1);
            }else{
                id = 0;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            con.disconnect();
        }catch(SQLException e){}
        return id;
    }

    public String obtenerFecha(){
          String fecha = "";
          dbBean con=new dbBean();
          String sql="";

          //sql = "select CONVERT(varchar,getDate(),103) as fecha";
          sql = "select getdate() as fecha";

       try{
            ResultSet resultado=con.execSql(sql);
            resultado.next();
            fecha = resultado.getString(1);
        }
        catch(java.sql.SQLException e)
        {
            e.printStackTrace();
        }

        try{
        con.disconnect();
        }
        catch(SQLException e){
        }
          return fecha;
    }
    
    public int numRows(String sql){
        String bigSQL= "";
        int nR = 0;
        dbBean con = new dbBean();
        bigSQL = "SELECT COUNT(*) AS NumReg FROM ("+ sql +") DERIVEDTBL";

        try{
            ResultSet resultado = con.execSql(sql);
            if(resultado.next()){
                nR = resultado.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();;
        }
        try{
            con.disconnect();
        }catch(SQLException e){}
        return nR;
    }
    
}

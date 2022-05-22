
package com.fcfmprograweb.luggy_paginaweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author luisa
 */
public class Nota {
    public int idNota;
    public int usuarioFK;
    public String fechaCreacion;
    public String contenido;
    public boolean activa;
    
    public void setNota(int id_,int usuario_,String fecha_,String contenido_,boolean activa_){
       if(activa_){
            this.idNota=id_;
            this.usuarioFK=usuario_;
            this.fechaCreacion=fecha_;
            this.contenido=contenido_;
        }
    }
    public void createNota(int idUsuario_,String contenido_){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/luggy?useSSL=false&allowPublicLeyRetrieval=true", "root", "4&Yi3YXQQ#nx?iHo");
        PreparedStatement stmt =con.prepareStatement("INSERT INTO nota(idUsuarioFK,contenido) VALUES(?,?)) ");
        stmt.setInt(1,idUsuario_);
        stmt.setString(2,contenido_);
        stmt.execute();
        con.close();
        }
        catch(SQLException ex){
            System.out.println("El error es =");
            System.out.println(ex);
            System.out.println("Error en la conexion con MYSQL");
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException"+ex);
        }
    }
    public static boolean isValidLength(String value) {
      int minLength=5;
      int maxLength=250;
      
      if(value == null) {
          return false;
      }
      
      int length = value.length();
      return length >= minLength && length <= maxLength;
   } 
    
}

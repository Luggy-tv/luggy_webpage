
package com.fcfmprograweb.luggy_paginaweb;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author luisa
 */
public class Usuario {
    public int id;
    public String usuario;
    public String contraseña;
    public String nombres;
    public String apellidos;
    public String mail;
    public String fechaNac;
    public Blob profilePic;
    
    public void setUsuario(int id_,String usuario_,String nombres_,String apellidos_,String mail_, String contraseña_,String fechaNac_, Blob profilePic_)
    {
        this.id=id_;
        this.usuario=usuario_;
        this.nombres=nombres_;
        this.apellidos=apellidos_;
        this.mail=mail_;
        this.fechaNac=fechaNac_;
        this.profilePic=profilePic_;
  
    }
    
    public static boolean checkIfUsuarioHasNotas(int idUsuario_)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/luggy", "root", "4&Yi3YXQQ#nx?iHo");
            Statement stmt =con.createStatement();
            ResultSet rs= stmt.executeQuery("SELECT idNota,idUsuarioFK FROM nota");
            while(rs.next())
            {
                if(idUsuario_==rs.getInt("idUsuarioFK"))
                {
                    return true;
                }
            }
            return false;
        }
        catch(Exception ex){
            System.out.println(ex);
            return false;
        }
    }
}

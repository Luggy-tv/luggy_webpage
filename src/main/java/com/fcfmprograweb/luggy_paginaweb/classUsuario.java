/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fcfmprograweb.luggy_paginaweb;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class classUsuario {
    private int idUsuario; 		
    private String usuario;	
    private String contraseña;		
    private String nombres;			
    private String apellidos;		
    private String mail;			
    private String fechaNac;		

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the fechaNac
     */
    public String getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    } 
     public static boolean checkIfUsuarioHasNotas(int idUsuario_){
        try{
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/luggy?useSSL=false&allowPublicLeyRetrieval=true&characterEncoding=UTF8", "root", "4&Yi3YXQQ#nx?iHo");
                   Statement stmt =con.createStatement();
                   ResultSet rs= stmt.executeQuery("SELECT idNota,idUsuarioFK FROM nota");
                     while(rs.next()){
                         if(idUsuario_==rs.getInt("idUsuarioFK")){
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

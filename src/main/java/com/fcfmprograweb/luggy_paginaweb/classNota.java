/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fcfmprograweb.luggy_paginaweb;

/**
 *
 * @author luisa
 */
public class classNota {

    /**
     * @return the idNota
     */
    public int getIdNota() {
        return idNota;
    }

    /**
     * @param idNota the idNota to set
     */
    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    /**
     * @return the usuarioFK
     */
    public int getUsuarioFK() {
        return usuarioFK;
    }

    /**
     * @param usuarioFK the usuarioFK to set
     */
    public void setUsuarioFK(int usuarioFK) {
        this.usuarioFK = usuarioFK;
    }

    /**
     * @return the fechaCreacion
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * @return the activa
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * @param activa the activa to set
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    private int idNota;
    private int usuarioFK;
    private String fechaCreacion;
    private String contenido;
    private boolean activa;
    
    public void setNota(int id_,int usuario_,String fecha_,String contenido_,boolean activa_){
      
        this.setIdNota(id_);
        this.setUsuarioFK(usuario_);
        this.setFechaCreacion(fecha_);
        this.setContenido(contenido_);
        this.setActiva(activa_);
    }
}

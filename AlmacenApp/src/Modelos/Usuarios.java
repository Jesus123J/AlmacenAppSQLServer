/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author gutie
 */
public class Usuarios {
    private  int id ;
    private  String idPeronal ;
    private  String usuarios;
    private  String contraseña;
    private  int tipoRol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdPeronal() {
        return idPeronal;
    }

    public void setIdPeronal(String idPeronal) {
        this.idPeronal = idPeronal;
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(int tipoRol) {
        this.tipoRol = tipoRol;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vista.Entrada.RegistroTrabajdores;
import static Interfaces.RecursosTablaEmpleados.Usuarioss1;
import Modelos.ConsultaModificacion;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Modelos.DatosMostrar.ActualizarUsuario;
import static Procesos.ProcesoAdmin.DiseñoRegistroUsuario;

/**
 *
 * @author gutie
 */
public class ContraladorRegistroTrabajadore implements ActionListener {
    RegistroTrabajdores regis ;   
    ContraladorRegistroTrabajadore(RegistroTrabajdores regis){
        this.regis = regis;
        regis.guardarRegistroUsuario.addActionListener(this);
        DiseñoRegistroUsuario(regis);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == regis.guardarRegistroUsuario){
           ConsultaModificacion.GuardadoPersonal(regis.idUsuario,regis.nombresUsario, regis.apellidosUsuario, regis.edadUsuario,
                   regis.correoUsuario, regis.direccionUsuario, regis.generoUsuario, regis.telefonoUsuario);
           ActualizarUsuario(regis.tablaUsuario);
       }
    }
    
}

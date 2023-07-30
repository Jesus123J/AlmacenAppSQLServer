/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;
import Modelos.Consultas;
import Procesos.ProcesosEntrada;
import Vista.Entrada.Adminstrador;
import Vista.Entrada.Entrada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.Entrada.AlmacenDiseño;
import Vista.Entrada.Salida;

import javax.swing.*;

import static Procesos.ProcesosEntrada.*;

//Implementamos el ActionListener para las acciones
public class ControladorEntrada implements ActionListener {
        //LLamamos al JFrame 
        private Entrada entrada;
        //Creamos un constructor para dar acciones y mostrar lo que quiero ver
        public ControladorEntrada(Entrada entrada){   
         this.entrada = entrada;
         //llamamos a acciones de los botones
            entrada.IngresoDeUsuario.addActionListener(this);
            entrada.IngresarAdmin.addActionListener(this);
         //llamamos a acciones de las etiquetas
                entrada.RegresarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(entrada.RegresarUsuario, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
                });
                entrada.OjoVisibleUsuarioPRincipal.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(entrada.OjoVisibleUsuarioPRincipal, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
               });
                 entrada.IngresoaVentanaAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(entrada.IngresoaVentanaAdmin, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
               });
                entrada.OjoNoVisibleUsuarioPRincipal.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(entrada.OjoNoVisibleUsuarioPRincipal, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
               });
                 entrada.OjoVisibleAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(entrada.OjoVisibleAdmin, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
               });
                  entrada.OjoNoVisibleAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(entrada.OjoNoVisibleAdmin, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
               });
                  entrada.ayudaUsario.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(entrada.ayudaUsario, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
               });
                  entrada.AyudaAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(entrada.AyudaAdmin, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
               });    
                entrada.regresarAlUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(entrada.regresarAlUsuario, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
               });
         //llamamos a los metodos que creamos para construir y ubicar       

            FormaImagen(this.entrada);
            IniciarForma(this.entrada);
            setPanelBackground(this.entrada.jPanel3);


        }
        
    @Override
   
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == entrada.IngresoDeUsuario){
          int rol = Consultas.IngresoUsuario(entrada.UsuarioCentral, entrada.ContraseñaPrincipal);
          if(rol == 2){
              entrada.setVisible(false);
              AlmacenDiseño aldis = new AlmacenDiseño();
              ControladorAlmacen conr = new ControladorAlmacen(aldis);
          }else if(rol == 3){
              entrada.setVisible(false);
              Salida aldis = new Salida();
              ControladorSalida conr = new ControladorSalida(aldis );
          }else{
              JOptionPane.showMessageDialog(null,"Contraseña o usuario incorrecto"  );
          }
      
        }
        if(e.getSource() == entrada.IngresarAdmin){
          int rol = Consultas.IngresoUsuario(entrada.UsuarioAdmin, entrada.ContraseñaAdmin);
           if(rol == 1){
              entrada.setVisible(false);
              Adminstrador aldis = new Adminstrador();
              ContraladorAdmin conr = new ContraladorAdmin(aldis);
           }else{
               JOptionPane.showMessageDialog(null,"Contraseña o usuario incorrecto"  );
           }
         }
        if(e.getSource() == entrada.regresarAlUsuario){
            entrada.Verificacion.setVisible(false);
            entrada.IngresoUsuario.setVisible(true);
        }
        if(e.getSource() == entrada.ayudaUsario){
            entrada.IngresoUsuario.setVisible(false);
            entrada.Verificacion.setVisible(true);
            ProcesosEntrada.Limpiesa(entrada);
        }
        if(e.getSource() == entrada.AyudaAdmin){
            entrada.IngresoAdmin.setVisible(false);
            entrada.Verificacion.setVisible(true);
               ProcesosEntrada.Limpiesa(entrada);
        }
        if(e.getSource() == entrada.RegresarUsuario){
           entrada.IngresoAdmin.setVisible(false);
           entrada.IngresoUsuario.setVisible(true);
              ProcesosEntrada.Limpiesa(entrada);
        }
         if ( e.getSource() == entrada.OjoNoVisibleAdmin) {
           entrada.OjoNoVisibleAdmin.setVisible(false);
           entrada.OjoVisibleAdmin.setVisible(true);
           entrada.ContraseñaAdmin.setEchoChar((char)0);  
        }  
        if ( e.getSource() == entrada.OjoVisibleAdmin) {
           entrada.OjoVisibleAdmin.setVisible(false);
           entrada.OjoNoVisibleAdmin.setVisible(true);
           entrada.ContraseñaAdmin.setEchoChar('❂');  
        }  
        if ( e.getSource() == entrada.OjoVisibleUsuarioPRincipal) {
           entrada.OjoVisibleUsuarioPRincipal.setVisible(false);
           entrada.OjoNoVisibleUsuarioPRincipal.setVisible(true);
           entrada.ContraseñaPrincipal.setEchoChar((char)0);  
        }  
        if ( e.getSource() == entrada.OjoNoVisibleUsuarioPRincipal) {
           entrada.OjoNoVisibleUsuarioPRincipal.setVisible(false);
           entrada.OjoVisibleUsuarioPRincipal.setVisible(true);
           entrada.ContraseñaPrincipal.setEchoChar('❂');  
        }  
        
        if ( e.getSource() == entrada.IngresoaVentanaAdmin) {
            entrada.IngresoUsuario.setVisible(false);
            entrada.IngresoAdmin.setVisible(true);
            ProcesosEntrada.Limpiesa(entrada);
             
        }
    }
 
}

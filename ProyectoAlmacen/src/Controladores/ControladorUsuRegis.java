/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.ConsultaModificacion;
import Modelos.Consultas;
import static Modelos.DatosMostrar.ActualizarUsuario2;
import Modelos.Personal;
import Procesos.ProcesoAdmin;
import Vista.Entrada.RegistrarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gutie
 */
public class ControladorUsuRegis implements ActionListener {
     RegistrarUsuario usu ;  
     ControladorUsuRegis(RegistrarUsuario usu){
         this.usu = usu;
         usu.GUA.addActionListener(this);
         usu.jButton1.addActionListener(this);
         ProcesoAdmin.DiseñoUsu(usu);
     }
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == usu.jButton1){
        ProcesoAdmin.BuscadorPersonal(usu);
      }
      if(e.getSource() == usu.GUA){
         ConsultaModificacion.GuardarRe(usu.codiTr, usu.usus, usu.contra, usu.selecPu);
       ActualizarUsuario2(usu.tabla);   
      }
    }
    
}

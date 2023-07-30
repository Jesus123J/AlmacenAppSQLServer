/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import static Modelos.ConsultaModificacion.IsertarProvedor;
import Vista.Entrada.RegistroProvedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Modelos.DatosMostrar.ActualizProvedor;
import static Procesos.ProcesosAlmacen.DiseñoPRo;
import javax.swing.JTable;

/**
 *
 * @author gutie
 */
public class ControlProvedor implements ActionListener {
    RegistroProvedores pro ;
    ControlProvedor( RegistroProvedores pro ){
        this.pro = pro;
        pro.agregarProvedores.addActionListener(this);
       DiseñoPRo(pro);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == pro.agregarProvedores){
            IsertarProvedor(pro);
            ActualizProvedor(pro.jTable1);
       }
    }
    
}

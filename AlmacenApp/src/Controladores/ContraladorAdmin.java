package Controladores;

import Procesos.ProcesoAdmin;
import Vista.Entrada.Adminstrador;
import Vista.Entrada.Entrada;
import Vista.Entrada.RegistrarUsuario;
import Vista.Entrada.RegistroTrabajdores;
import Vista.Entrada.Salida;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class ContraladorAdmin implements ActionListener {
    Adminstrador aldis;
    ContraladorAdmin(Adminstrador aldis){

        this.aldis = aldis;
        aldis.RestriccionUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(aldis.RestriccionUsuarios, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
                });
        aldis.salir.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(aldis.salir, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
                });
          aldis.jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(aldis.jMenu1, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
                });
        ProcesoAdmin.DiseñoFrome(this.aldis);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() ==  aldis.RestriccionUsuarios){
          RegistroTrabajdores ads = new RegistroTrabajdores();
          ContraladorRegistroTrabajadore sd = new ContraladorRegistroTrabajadore(ads);
          AgregarFrame(ads);
          ads.setVisible(true);
          
      }
      if(e.getSource() == aldis.salir){
             int a = JOptionPane.showConfirmDialog(null,"Desea Salir ? ","*********************",0, WARNING_MESSAGE);
             if(a == 0){  
                 aldis.setVisible(false);
                 Entrada gua = new Entrada();
                 ControladorEntrada GUA = new ControladorEntrada(gua);
             }
      }
      if(e.getSource() == aldis.jMenu1){
        RegistrarUsuario sad = new   RegistrarUsuario();
        ControladorUsuRegis usud = new ControladorUsuRegis(sad);
              AgregarFrame(sad);
          sad.setVisible(true);
          
      }
      
      
    }
      void AgregarFrame(JInternalFrame frame){
        aldis.jDesktopPane1.removeAll();
        aldis.jDesktopPane1.add(frame);
        aldis.jDesktopPane1.repaint();
    } 
}

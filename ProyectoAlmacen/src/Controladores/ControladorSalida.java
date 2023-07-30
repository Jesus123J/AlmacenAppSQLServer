package Controladores;

import Vista.Entrada.Salida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorSalida implements ActionListener {
    private Salida sali;
    public ControladorSalida(Salida sali){
     this.sali = sali;
        vista();
    }
   void vista(){
      sali.setVisible(true);
      sali.setLocationRelativeTo(null);
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

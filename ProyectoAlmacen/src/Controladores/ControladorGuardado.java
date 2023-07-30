/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;
import Modelos.Consultas;
import Modelos.DatosMostrar;
import static Modelos.DatosMostrar.ActualizarTabla;
import static Modelos.DatosMostrar.nombreAlma;
import Modelos.Provedor;
import Procesos.ProcesosAlmacen;
import Vista.Entrada.guardar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
public  class ControladorGuardado  implements ActionListener{
    int tamaño ;
    String add ;
    guardar  IngresoGuar;
    String nombreAlmacen;
                public ControladorGuardado(guardar IngresoGuar, String nombreAlmacen){
                    this.IngresoGuar = IngresoGuar;
                    this.nombreAlmacen =nombreAlmacen;
                    IngresoGuar.GuardarDatos.addActionListener(this);
                    IngresoGuar.CodigoProBucar.addActionListener(this);
                    ProcesosAlmacen.BloquearDiseñoGuardado(IngresoGuar);
                   String a =  nombreAlma(nombreAlmacen);
                  this.tamaño =  ActualizarTabla(IngresoGuar.TablaDeDatos,a);
                }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == IngresoGuar.CodigoProBucar){
        DefaultComboBoxModel <String> combo = new DefaultComboBoxModel<>();
        List<Provedor> provedorResultado = Consultas.Encontrar(IngresoGuar.codigoProvedor.getText());
        
          if (!(provedorResultado == null)) {
              if (!(provedorResultado.isEmpty())) {
                  ProcesosAlmacen.DesbloquearDiseñoGuardado(IngresoGuar);
                  for (Provedor x : provedorResultado) {
                      combo.addElement(x.getNombreProducto());
                  }
                 IngresoGuar.CodigoProducto.setText(ProcesosAlmacen.generarCodigoProducto( tamaño));
                  IngresoGuar.SeleccionNombreProducto.setModel(combo);

              }else{
                  JOptionPane.showMessageDialog(null, "Provedor no ubicado");
              }
          } else {
              JOptionPane.showMessageDialog(null, "Ocurrio un problema");
          }

      }
      if (e.getSource() == IngresoGuar.GuardarDatos){
         
          String nma  = nombreAlma(nombreAlmacen);
          add = ProcesosAlmacen.ObtenerDatosAlmacen(IngresoGuar, nma);
          DatosMostrar.ActualizarTabla(IngresoGuar.TablaDeDatos,nma);

      }
       }

}

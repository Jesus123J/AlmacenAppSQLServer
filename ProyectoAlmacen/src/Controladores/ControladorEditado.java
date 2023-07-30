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
import static Procesos.ProcesosAlmacen.DiseñodeEdicion;
import static Procesos.ProcesosAlmacen.DiseñodeEdicionMosr;
import static Procesos.ProcesosAlmacen.Selecion;
import Vista.Entrada.Editar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
public class ControladorEditado implements  ActionListener {
    private Editar edi ;
    private String nombr;
    ControladorEditado(Editar edi , String nombr ){
       this.edi = edi;
        this.nombr =nombr;
        edi.CodigoProBucar.addActionListener(this);
       edi.GuardarDatos.addActionListener(this);
       edi.jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActionEvent event = new ActionEvent(edi.jTable1, ActionEvent.ACTION_PERFORMED, "");
               actionPerformed(event); }
        });
       String a =  nombreAlma(nombr);
                   ActualizarTabla(edi.jTable1,a);
       DiseñodeEdicion(edi);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == edi.jTable1){
             DiseñodeEdicionMosr(edi);
             Selecion(edi.jTable1,edi.jTextField1,edi.codigoProvedor,edi.SeleccionNombreProducto,edi.CantidadProducto, edi.PrecioUnitario,edi.PrecioPorDocena,edi.FechaLimite);
        }
        if(e.getSource() == edi.GuardarDatos){
            String nma  = nombreAlma(nombr);
            Consultas.Actualisar(nma, edi.jTextField1,edi.codigoProvedor,edi.SeleccionNombreProducto,edi.CantidadProducto, edi.PrecioUnitario,edi.PrecioPorDocena,edi.FechaLimite);
            DatosMostrar.ActualizarTabla(edi.jTable1,nma);
        }
           if(e.getSource() == edi.CodigoProBucar){
        DefaultComboBoxModel <String> combo = new DefaultComboBoxModel<>();
        List<Provedor> provedorResultado = Consultas.Encontrar(edi.codigoProvedor.getText());
        
          if (!(provedorResultado == null)) {
              if (!(provedorResultado.isEmpty())) {
                  edi.codigoProvedor.setEnabled(false);
                  edi.CodigoProBucar.setEnabled(false);
                  for (Provedor x : provedorResultado) {
                      combo.addElement(x.getNombreProducto());
                  }
                  edi.SeleccionNombreProducto.setModel(combo);
              }else{
                  JOptionPane.showMessageDialog(null, "Provedor no ubicado");
              }
          } else {
              JOptionPane.showMessageDialog(null, "Ocurrio un problema");
          }

      }
        
    }
    
}

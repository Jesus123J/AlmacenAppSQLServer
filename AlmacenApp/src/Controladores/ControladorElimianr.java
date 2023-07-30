/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import static Modelos.ConsultaModificacion.Eliminacion;
import static Modelos.DatosMostrar.ActualizarTabla;
import static Modelos.DatosMostrar.nombreAlma;
import static Procesos.ProcesosAlmacen.DiseñodeEdicionMosr;
import static Procesos.ProcesosAlmacen.Selecion;
import Vista.Entrada.Eliminar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gutie
 */
public class ControladorElimianr implements ActionListener{
    Eliminar elimi ;
    String nombr;
     String id ; 
    ControladorElimianr(Eliminar elimi , String nombr ){
       this.elimi = elimi;
       this.nombr = nombr;
       elimi.tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActionEvent event = new ActionEvent(elimi.tabla, ActionEvent.ACTION_PERFORMED, "");
               actionPerformed(event); }
        });
       elimi.eliminarEliminar.addActionListener(this);
          this.id = nombreAlma(nombr);
            ActualizarTabla(elimi.tabla,this.id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == elimi.tabla){
              int fila = elimi.tabla.getSelectedRow();
              elimi.codProductoEliminar.setText((String) elimi.tabla.getValueAt(fila, 1));
              elimi.jTextField1.setText( String.valueOf(elimi.tabla.getValueAt(fila, 0)));
       }
       if(e.getSource() == elimi.eliminarEliminar){
            Eliminacion(elimi.jTextField1.getText() ,this.id );
            String a =  nombreAlma(nombr);
            ActualizarTabla(elimi.tabla,a);
       }
    }
    
}

package Controladores;
import Interfaces.Movimientos;
import Modelos.ConsultaModificacion;
import Modelos.Consultas;
import Modelos.MovimientosInterfas;
import Procesos.ProcesosAlmacen;
import Vista.Entrada.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static Modelos.DatosMostrar.nombreAlma;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
public  class ControladorAlmacen implements ActionListener{
    //Llamamos a la ventana AlmacenDiseño
     private  Movimientos movimi ;
   
    AlmacenDiseño almacen  = new AlmacenDiseño();
    //creamos un constructor
    public ControladorAlmacen(){}
    public ControladorAlmacen(AlmacenDiseño almacen){
     this.almacen = almacen;
     almacen.GuardarArchivo1.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(almacen.GuardarArchivo1, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
                });
     almacen.agregar.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent( almacen.agregar, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
                });
     almacen.ComunicacionAdm.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent( almacen.ComunicacionAdm, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
                });
     almacen.Provedornuevo.addActionListener(this);
     almacen.A1.addActionListener(this);
     almacen.A2.addActionListener(this);
     almacen.A3.addActionListener(this);
     almacen.A4.addActionListener(this);
     almacen.A5.addActionListener(this);
     almacen.registroProvedi.addActionListener(this);
     almacen.jButton1.addActionListener(this);
      almacen.Actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(almacen.Actualizar, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
                });
            almacen.btoGuardar.addActionListener(this);
            almacen.btoEditar.addActionListener(this);
          almacen.btoFiltrar.addActionListener(this);
          almacen.btoEliminar.addActionListener(this);

     almacen.Salida.addMouseListener(new java.awt.event.MouseAdapter() {
                   @Override
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       ActionEvent event = new ActionEvent(almacen.Salida, ActionEvent.ACTION_PERFORMED, "");
                      actionPerformed(event);
                   }
                });
     ImagenIcono(); 
        Ajustes();
    }
    //creamos metodos de ajuste de imagen
    void ImagenIcono(){
           ProcesosAlmacen.SetImageLabel(almacen.Salida, "src/ImagenIcono/salida.png");
           ProcesosAlmacen.SetImageLabel(almacen.Actualizar,"src/ImagenIcono/recargar.png");
        ProcesosAlmacen.SetImageLabel(almacen.jLabel11,"src/ImagenIcono/dato.png");
         ProcesosAlmacen.SetImageLabel(almacen.jLabel10,"src/ImagenIcono/eliminarDatos.png");
              ProcesosAlmacen.SetImageLabel(almacen.jLabel9,"src/ImagenIcono/editar.png");
             ProcesosAlmacen.SetImageLabel(almacen.jLabel8,"src/ImagenIcono/guardarDatos.png");
            ProcesosAlmacen.SetImageLabel(almacen.ComunicacionAdm,"src/ImagenIcono/Ayuda.png");
            ProcesosAlmacen.SetImageLabel(almacen.jLabel5,"src/ImagenIcono/impresora.png");
            ProcesosAlmacen.SetImageLabel(almacen.agregar,"src/ImagenIcono/agregar-documento.png");
            //ProcesosAlmacen.SetImageLabel(almacen.agregar,"src/ImagenIcono/Abrir documento.png");
            ProcesosAlmacen.SetImageLabel(almacen.GuardarArchivo1,"src/ImagenIcono/Crear documento.png");
            ProcesosAlmacen.SetImageLabel(almacen.IconoDeBuscador1,"src/ImagenIcono/lupa.png");
    }

    //creamos metodos de ajustes 
    void Ajustes(){
         almacen.registroMovimento.setEnabled(false);
         almacen.registroMovimento.append("*********comensando*********");
         almacen.AlmacebBusquedad.setEnabled(false);
         almacen.btoEditar.setEnabled(false);
         almacen.btoEliminar.setEnabled(false);
         almacen.btoFiltrar.setEnabled(false);
         almacen.btoGuardar.setEnabled(false);
         almacen.jTextField1.setOpaque(false);
         almacen.BarraDeAccionesDeIconos.setOpaque(false);
         almacen.setLocationRelativeTo(null);
         almacen.setVisible(true);      
}

    @Override
    public void actionPerformed(ActionEvent e) {
        MovimientosInterfas sd = new MovimientosInterfas();
               almacen.registroMovimento.append("\n"+ sd.MovemientosGuardado());
         if (e.getSource() == almacen.Salida){
             int a = JOptionPane.showConfirmDialog(null,"Desea Salir ? ","*********************",0, WARNING_MESSAGE);
             if(a == 0){  
                 almacen.setVisible(false);
                 Entrada gua = new Entrada();
                 ControladorEntrada GUA = new ControladorEntrada(gua);
             }
         }
       if(e.getSource() == almacen.ComunicacionAdm){
           ComunacionAdmin a = new ComunacionAdmin(this.almacen , true);
           a.setLocationRelativeTo(null);
           a.setVisible(true);
           
       }  
       if(e.getSource() == almacen.agregar){
             PreguntaExPORTACIOoiMPORTA des = new PreguntaExPORTACIOoiMPORTA(this.almacen,true);
           des.setLocationRelativeTo(null);
           des.setVisible(true);
       }
       if(e.getSource() == almacen.GuardarArchivo1){
         Documento a = new  Documento(this.almacen , true );
             a.setLocationRelativeTo(null);
           a.setVisible(true);
       }
        if(e.getSource() == almacen.jButton1){
           if( !almacen.AlmacebBusquedad.getText().isEmpty()){
               almacen.jButton1.setEnabled(false);
               almacen.btoEditar.setEnabled(true);
               almacen.btoEliminar.setEnabled(true);
               almacen.btoFiltrar.setEnabled(true);
               almacen.btoGuardar.setEnabled(true);
               almacen.nombreAlma.setText("Nombre Almacen : " + almacen.AlmacebBusquedad.getText());
               almacen.limtes.setText("Estado : " + "☑");
               almacen.totalInventario.setText("Inventario : " + String.valueOf((Consultas.Almacen(nombreAlma(almacen.AlmacebBusquedad.getText()))).size()));
               almacen.sectorAlmacen.setText("Sector Amacen" + nombreAlma(almacen.AlmacebBusquedad.getText()));
               almacen.capacidad.setText("Capacidad : " + "10 000");
           }else{
               JOptionPane.showMessageDialog(null,"Selelciones un almacen");
           }
       }
          if(e.getSource() == almacen.Actualizar){
              int a = JOptionPane.showConfirmDialog(null,"Esta seguro de Cerrar el ALmacen ? ","*********************",0, WARNING_MESSAGE);
              if(a == 0){
                  almacen.AlmacebBusquedad.setText("");
                  almacen.jButton1.setEnabled(true);
                  almacen.btoEditar.  setEnabled(false);
                  almacen.btoEliminar.setEnabled(false);
                  almacen.btoFiltrar. setEnabled(false);
                  almacen.btoGuardar. setEnabled(false);
                  almacen.nombreAlma.setText("Nombre Almacen : ");
                  almacen.limtes.setText("Estado : ");
                  almacen.totalInventario.setText("Inventario : ");
                  almacen.sectorAlmacen.setText("Sector Amacen : ");
                  almacen.capacidad.setText("Capacidad : ");
                  almacen.Escritorio.removeAll();
                  almacen.Escritorio.repaint();
              }
        }
        if(e.getSource() ==  almacen.Provedornuevo){
            fechaBuscador fec = new fechaBuscador(this.almacen, true);
            fec.setLocationRelativeTo(null);
            fec.setVisible(true);
            
        }  
        if(e.getSource() == almacen.MenuPerfil){
            
       
        }
        if(e.getSource() == almacen.registroProvedi){
            RegistroProvedores prove = new RegistroProvedores(this.almacen,true);
            ControlProvedor as = new ControlProvedor(prove);
            prove.setLocationRelativeTo(null);
            prove.setVisible(true);
        }
        if(e.getSource() == almacen.A1){
           almacen.AlmacebBusquedad.setText(almacen.A1.getText());
        }
          if(e.getSource() == almacen.A2){
          almacen.AlmacebBusquedad.setText(almacen.A2.getText());
        }
          if(e.getSource() == almacen.A3){
           almacen.AlmacebBusquedad.setText(almacen.A3.getText());
        }
          if(e.getSource() == almacen.A4){
           almacen.AlmacebBusquedad.setText(almacen.A4.getText());
        }
            if(e.getSource() == almacen.A5){
         almacen.AlmacebBusquedad.setText(almacen.A5.getText());
        }
        if(e.getSource() == almacen.btoGuardar){
           guardar gua = new guardar();
          ControladorGuardado contr = new ControladorGuardado(gua , almacen.AlmacebBusquedad.getText());
          AgregarFrame(gua);
          gua.setTitle("Guardado de Datos...");
          gua.setVisible(true);
           
        }
        if(e.getSource() == almacen.btoFiltrar){
             almacen.MenuItem.show(this.almacen, 370, 370);
             almacen.Provedornuevo.setText("buscador");
        }
        if(e.getSource() == almacen.btoEliminar){
           Eliminar elimi = new Eliminar();
           ControladorElimianr eli = new ControladorElimianr(elimi, almacen.AlmacebBusquedad.getText().toString());
            AgregarFrame(elimi);
            elimi.setTitle("Elimanacion de Datos...");
            elimi.setVisible(true);
        }
        if(e.getSource() == almacen.btoEditar){
            Editar edi = new Editar();
            ControladorEditado ediC = new ControladorEditado(edi, almacen.AlmacebBusquedad.getText().toString());
            AgregarFrame(edi);
            edi.setTitle("Edicion de Datos...");
            edi.setVisible(true);
        }
        
    }
     
     void AgregarFrame(JInternalFrame frame){
        almacen.Escritorio.removeAll();
        almacen.Escritorio.add(frame);
        almacen.Escritorio.repaint();
    } 
}

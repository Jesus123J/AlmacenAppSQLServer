package Procesos;
import Modelos.Almacen;
import Modelos.ConsultaModificacion;
import Modelos.Consultas;
import Vista.Entrada.Editar;
import Vista.Entrada.RegistroProvedores;
import Vista.Entrada.guardar;
import java.awt.HeadlessException;
import java.awt.Image;
import java.text.DecimalFormat;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import static Interfaces.RecursosTablaProvedor.Provedor;
import static Modelos.DatosMostrar.ActualizProvedor;

public class ProcesosAlmacen {
    public static void SetImageLabel(JLabel labelName , String url ){
        ImageIcon image = new ImageIcon(url);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_FAST));
         labelName.setIcon(icon);
    }
      public static String generarCodigoProducto(int codigoInicial) {
        DecimalFormat formatoCodigo = new DecimalFormat("EXEL00000");
        String codigoTrabajador = formatoCodigo.format(codigoInicial+1);
        return codigoTrabajador;
    }
    public static String  ObtenerDatosAlmacen(guardar gua , String nombreAlma){
        Almacen almacen = new Almacen();
        almacen.setCodigoProve(gua.codigoProvedor.getText());
        almacen.setCodigo(gua.CodigoProducto.getText());
        almacen.setNombre(gua.SeleccionNombreProducto.getSelectedItem().toString());
        almacen.setCantidad(Integer.parseInt(gua.CantidadProducto.getValue().toString()));
        almacen.setPrecioUnitario(Double.parseDouble(gua.PrecioUnitario.getText()));
        almacen.setPrecioporDocena(Double.parseDouble(gua.PrecioPorDocena.getText()));
        almacen.setFechaEntrada(Modelos.Consultas.FechaActual());
        almacen.setFechaLimite(gua.FechaLimite.getText());
        String a =  ConsultaModificacion.IsertarAlmacen(almacen , nombreAlma);
        return a ;
    }
    public static void BloquearDiseñoGuardado(guardar gua){
      gua.PrecioPorDocena.         setEnabled(false);
      gua.CantidadProducto.        setEnabled(false);
      gua.CodigoProducto.          setEnabled(false);
      gua.PrecioUnitario.          setEnabled(false);
      gua.SeleccionNombreProducto. setEnabled(false);
      gua.jCalendar1.              setEnabled(false);
      gua.GuardarDatos.            setEnabled(false);
    }
    public static void DesbloquearDiseñoGuardado(guardar gua){
        gua.codigoProvedor.setEnabled(false);
        gua.CodigoProBucar.setEnabled(false);
        gua.PrecioPorDocena.         setEnabled(true);
        gua.CantidadProducto.        setEnabled(true);
        gua.PrecioUnitario.          setEnabled(true);
        gua.SeleccionNombreProducto. setEnabled(true);
        gua.jCalendar1.              setEnabled(true);
        gua.GuardarDatos.            setEnabled(true);
    }
    //public static 
    public static void DiseñoPRo(RegistroProvedores a){
        a.jTextField1.setText( generarCodigoPro());
        a.jTextField1.setEnabled(false);
         ActualizProvedor(a.jTable1);
     
       
    }
     public static String generarCodigoPro(){
        int a = Consultas.VerProd().size();
        DecimalFormat forma = new DecimalFormat("PROB0000");
        String codi  = forma.format(a+1);
        return  codi;
    }
     public static String Selecion( JTable a ,JTextField aff , JTextField ab , JComboBox e,JSpinner f,JTextField g ,JTextField gf,JTextField fh){

        try{
             int fila = a.getSelectedRow();
            if(fila>=0){ 
               ab.setText((String) a.getValueAt(fila, 1));
              String valorDeseado = (String) a.getValueAt(fila, 3);
                   DefaultComboBoxModel <String> combo = new DefaultComboBoxModel<>();
                  combo.addElement(valorDeseado);
                  e.setModel(combo);
                f.setValue(a.getValueAt(fila, 4));
                 g.setText(String.valueOf((Double) a.getValueAt(fila, 5)));
               gf.setText(String.valueOf((Double) a.getValueAt(fila, 6)));
               fh.setText((String) a.getValueAt(fila, 8));
                aff.setText( String.valueOf(a.getValueAt(fila, 0)));

            }
       }catch(Exception je){
           System.out.println(je.toString());
       }     
     return String.valueOf(aff);
   }  
     public static void DiseñodeEdicion(Editar a){
         a.CantidadProducto.       setEnabled(false);
         a.CodigoProBucar.          setEnabled(false);
         a.FechaLimite.             setEnabled(false);
         a.GuardarDatos.            setEnabled(false);
         a.PrecioPorDocena.         setEnabled(false);
         a.PrecioUnitario.          setEnabled(false);
         a.SeleccionNombreProducto. setEnabled(false);
         a.codigoProvedor.          setEnabled(false);
     }
     public static void DiseñodeEdicionMosr(Editar a){
         a.CantidadProducto.       setEnabled(true);
         a.CodigoProBucar.          setEnabled(true);
         a.FechaLimite.             setEnabled(true);
         a.GuardarDatos.            setEnabled(true);
         a.PrecioPorDocena.         setEnabled(true);
         a.PrecioUnitario.          setEnabled(true);
         a.SeleccionNombreProducto. setEnabled(true);
         a.codigoProvedor.          setEnabled(true);
     }
}

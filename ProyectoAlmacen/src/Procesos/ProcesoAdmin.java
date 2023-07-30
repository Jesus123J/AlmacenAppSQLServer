package Procesos;

import ConexionServidor.Conexion;
import static Interfaces.RecursosTablaEmpleados.Usuarioss1;
import Modelos.Consultas;
import static Modelos.DatosMostrar.ActualizarUsuario;
import static Modelos.DatosMostrar.ActualizarUsuario2;
import Modelos.Personal;
import Vista.Entrada.Adminstrador;
import Vista.Entrada.RegistrarUsuario;
import Vista.Entrada.RegistroTrabajdores;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ProcesoAdmin {
    
    public static void  DiseñoFrome(Adminstrador aldis){
        aldis.setLocationRelativeTo(null);
        aldis.setVisible(true);
    }
    
    public static void DiseñoRegistroUsuario(RegistroTrabajdores su){
        su.idUsuario.setText(generarCodigoTrabajado());
        ActualizarUsuario(su.tablaUsuario);
        su.idUsuario.setEnabled(false);
    }
    
    public static void DiseñoUsu(RegistrarUsuario usu){
         usu.usus.setEnabled(false);
                  usu.codiTr.setEnabled(true);
                  usu.selecPu.setEnabled(false);
                  usu.contra.setEnabled(false);
                  usu.jButton1.setEnabled(true);
          ActualizarUsuario2(usu.tabla);                  
    }
     public static void BuscadorPersonal(RegistrarUsuario usu){
       List<Personal> per = Consultas.MostrarUsuario();
         if(!(per.isEmpty())){
                for(Personal x : per){
                  if(x.getId().equals(usu.codiTr.getText())){  
                    usu.usus.setEnabled(true);
                     usu.codiTr.setEnabled(false);
                     usu.selecPu.setEnabled(true);
                     usu.contra.setEnabled(true);
                     usu.jButton1.setEnabled(false);
                  }
                  }
                     
         }else{
          JOptionPane.showMessageDialog(null, "No se encontro Trabajor", "", 2);
         }
            
    }    
    public static String generarCodigoTrabajado(){
        int a = Consultas.MostrarUsuario().size();
        DecimalFormat forma = new DecimalFormat("PRO0000");
        String codi  = forma.format(a+1);
        return  codi;
    }
    
  
}

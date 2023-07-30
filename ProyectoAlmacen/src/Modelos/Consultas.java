/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import ConexionServidor.Conexion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.function.Supplier;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
public class Consultas {
      public static String FechaActual(){
        String fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date());
        return fecha;
    }
   public static List<Almacen> Almacen(String nombre){
            List<Almacen>  lisAlm =new ArrayList();
           try{    
               String consulta ="Select * from "+nombre+";";
               ResultSet rs  = Conexion.conexion().createStatement().executeQuery(consulta);
               lisAlm = DatosMostrar.AlmacenDatos(rs);
               Conexion.conexion().close();
       }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Error 210");
       } 
      return lisAlm;
    }
    public static  List<Provedor> Encontrar(String codigo){
       List<Provedor> provedorNames = new ArrayList<>();
       try{
            ResultSet set = Conexion.conexion().prepareStatement("SELECT nombre_Producto FROM Provedor WHERE codigo = '"+codigo+"';").executeQuery();
            while(set.next()){
                   Provedor pro = new Provedor();
                   pro.setNombreProducto(set.getString("nombre_Producto"));
                   provedorNames.add(pro);

               }
            Conexion.conexion().close();
        }catch(Exception e){
            System.out.println(""+e);
           JOptionPane.showMessageDialog(null,"Error de Conexion");
        }
        return provedorNames;
   }
    public static List<Provedor>  VerProd (){
        List<Provedor> provedorNames = new ArrayList<>();
        try{
            ResultSet set = Conexion.conexion().prepareStatement("SELECT * FROM Provedor ;").executeQuery();
             provedorNames = DatosMostrar.ProvedorDatos(set);
            Conexion.conexion().close();
        }catch(Exception e){
            System.out.println(""+e);
            JOptionPane.showMessageDialog(null,"Error de Conexion");
        }
        return provedorNames;
    }
    public static void Actualisar (String nombre ,JTextField id , JTextField ab , JComboBox e,JSpinner f,JTextField g ,JTextField gf,JTextField fh ){
           try{
                Conexion.conexion().createStatement().executeUpdate("UPDATE "+nombre+" Set CodigoProvedor = '"+ ab.getText()+"', "
                        + "nombre = '"+e.getSelectedItem().toString()+"',cantidad = "+f.getValue().hashCode()+","
                                + "precioUnitario = "+Double.parseDouble(g.getText())+","
                                + "precioporDocena = "+ Double.parseDouble(gf.getText())+",fecha_Limite ='"+fh.getText()+"' "
                                        + "WHERE   id = "+Integer.parseInt(id.getText())+";");
                 JOptionPane.showMessageDialog(null, "Se registro Correctamente"
                         + "","",3 );
                  Conexion.conexion().close();
           }catch(Exception ed){
               JOptionPane.showMessageDialog(null, "Error e" );
           System.out.print(ed);
           }
        
    }
   public static List<Personal> MostrarUsuario(){
       List<Personal> proveList = new ArrayList();
       Provedor pro = new Provedor();
      try{
         ResultSet set = Conexion.conexion().prepareStatement("SELECT * FROM Personal;").executeQuery();
         proveList = DatosMostrar.trabajadoresDatos(set);
        Conexion.conexion().close();
      }catch(Exception e){JOptionPane.showMessageDialog(null,"Error 400");
                }  
      return  proveList;
   }
   public static List<Usuarios> VerUsuar(){
       List<Usuarios> oe  = new ArrayList();
       try{
        ResultSet se = Conexion.conexion().createStatement().executeQuery("SELECT * FROM Usuarios");
        oe = DatosMostrar.UsuariosList(se);
      }catch(Exception e){
          
      }
       return oe;
   }
   public  static int IngresoUsuario(JTextField usuario , JPasswordField contraseña){
           int rol = 0 ;
          try {
              ResultSet es = Conexion.conexion().createStatement().executeQuery("SELECT * FROM Usuarios WHERE usuarios = '"+usuario.getText()+"' "
                      + "AND contraseña = '"+contraseña.getText()+"';");
              List<Usuarios> usu = DatosMostrar.UsuariosList(es);
              for(Usuarios x : usu){
                  rol = x.getTipoRol();
              }
          }catch (Exception e){System.out.println(e.toString());JOptionPane.showMessageDialog(null,"Error 400");}
           return rol;
       }
   }
   


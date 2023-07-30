/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import ConexionServidor.Conexion;
import static Interfaces.RecursoTablaAlmacen.titulos;
import static Interfaces.RecursosTablaEmpleados.Usuarioss1;
import static Interfaces.RecursosTablaProvedor.Provedor;
import static Interfaces.Usuarios.Usus;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gutie
 */
public class DatosMostrar {
    public  static  void ActualizProvedor(JTable table){
        List<Provedor> lisUs = new ArrayList<>();
        DefaultTableModel a = new DefaultTableModel(null,Provedor);
        lisUs =  Consultas.VerProd();
        for(Provedor us : lisUs){
            Object[] rowData = {us.getCodigo(),us.getNombre(),
                    us.getCategoria(),
                    us.getNombreProducto(),us.getCorre(),
                    us.getDireccion(),
                    us.getTelefono(),us.getFechaEntrada(),
                    us.getFechaLimite()};
            a.addRow(rowData);
            table.setModel(a);
        }
        table.setModel(a);
    }
      public  static  void ActualizarUsuario2(JTable table){
         List<Usuarios> lisUs = new ArrayList<>();
         DefaultTableModel a = new DefaultTableModel(null,Usus);
         lisUs =  Consultas.VerUsuar();
         for(Usuarios us : lisUs){
             Object[] rowData = {us.getId(),us.getIdPeronal(),us.getUsuarios(),us.getContraseña(),us.getTipoRol()};
             a.addRow(rowData);
             table.setModel(a);
         }
         table.setModel(a);
     }
      //
     public  static  void ActualizarUsuario(JTable table){
         List<Personal> lisUs = new ArrayList<>();
         DefaultTableModel a = new DefaultTableModel(null,Usuarioss1);
         lisUs =  Consultas.MostrarUsuario();
         for(Personal us : lisUs){
             Object[] rowData = {us.getId(),us.getNombre(),us.getApellido(),
                     us.getEdad(),us.getGenero(),
                     us.getCorreo(),us.getDireccion(),
                     us.getTelefono(),us.getFechaIngreso(),us.getFechaSalida()};
             a.addRow(rowData);
             table.setModel(a);
         }
         table.setModel(a);
     }
     public static int   ActualizarTabla(JTable tabla ,String nombreTbala){
         List<Almacen> lisAl = new ArrayList();
       DefaultTableModel a  = new DefaultTableModel(null ,titulos );
       lisAl = Consultas.Almacen(nombreTbala);
       int cu = lisAl.size();
          for (Almacen dato : lisAl) {
            Object[] rowData = {dato.getId(),dato.getCodigoProve(),dato.getCodigo(),dato.getNombre(),dato.getCantidad(),
                dato.getPrecioUnitario(),dato.getPrecioporDocena(),dato.getFechaEntrada(),dato.getFechaLimite()};
            a.addRow(rowData);
        tabla.setModel(a);
       }
         tabla.setModel(a);
          return  cu;
     }
      public static String nombreAlma(String nombreTbala){
          String name = "";
          if(nombreTbala.equals("Sector  cerial A1")) {name = "AlmacenA1";
          }else if(nombreTbala.equals("Sector  legunbres A2")) {name = "AlmacenA2";
          }else if(nombreTbala.equals("Sector fluidos A3")) {name = "AlmacenA3";
          }else if(nombreTbala.equals("Sector Detergente   A4")) {name = "AlmacenA4";
          }else if(nombreTbala.equals("Sector snack  A5")) {name = "AlmacenA";
          } else {JOptionPane.showMessageDialog(null,"Error 110");
          }
          return name;
      }
    
    ////
    public static List<Provedor> MostrarNomrbeProvedor(ResultSet resultSet){
        List<Provedor> proList = new ArrayList();
        try{
          while(resultSet.next()){
             Provedor prove = new Provedor();
             prove.setNombreProducto(resultSet.getString("nombre_Producto"));
             proList.add(prove);
               Conexion.conexion().close();
          }
          
      }catch(Exception e){ System.out.println(""+e);
            JOptionPane.showMessageDialog(null,"Error 100");
        }
      return proList;
    }
    /////
    public static List<Usuarios> UsuariosList(ResultSet resultSet){
        List<Usuarios> usuariosList = new ArrayList<>();
        try{
           while(resultSet.next()){
               Usuarios usuarios = new Usuarios();
               usuarios.setId(resultSet.getInt("id"));
               usuarios.setIdPeronal(resultSet.getString("idPersonal"));
               usuarios.setUsuarios(resultSet.getString("usuarios"));
               usuarios.setContraseña(resultSet.getString("contraseña"));
               usuarios.setTipoRol(resultSet.getInt("id_TipoRol"));
               usuariosList.add(usuarios);
                 Conexion.conexion().close();
           }
        }catch (Exception e){
            System.out.println(""+e);
            JOptionPane.showMessageDialog(null,"Error 100");
        }
        return usuariosList;
     }
    public static List<Personal> trabajadoresDatos(ResultSet resultSet){
       List<Personal> trabajadoresList = new ArrayList<>();
       try{
           while(resultSet.next()) {
               Personal trabajadores = new Personal();
               trabajadores.setId(resultSet.getString("codigo"));
               trabajadores.setNombre(resultSet.getString("nombre"));
               trabajadores.setApellido(resultSet.getString("apellido"));
               trabajadores.setEdad(resultSet.getInt("edad"));
               trabajadores.setGenero(resultSet.getString("genero" ).equals("1")? "F":"M");
               trabajadores.setCorreo(resultSet.getString("correo"));
               trabajadores.setDireccion(resultSet.getString("direccion"));
               trabajadores.setTelefono(resultSet.getInt("telefono"));
               trabajadores.setFechaIngreso(resultSet.getTimestamp("fecha_ingreso") == null ? "vacio" : resultSet.getTimestamp("fecha_ingreso").toString() );
               trabajadores.setFechaSalida(resultSet.getTimestamp("fecha_salida")== null ? "vacio" : resultSet.getTimestamp("fecha_ingreso").toString());
               trabajadoresList.add(trabajadores);
           }
              Conexion.conexion().close();
       }catch (Exception e){
           System.out.println(""+e);
           JOptionPane.showMessageDialog(null,"Error 100");
       }
       return trabajadoresList;
    }
    public static  List<Provedor> ProvedorDatos(ResultSet resultSet){
        List<Provedor>  provedorList = new ArrayList<>();
        try{
          while(resultSet.next()){
            Provedor provedor = new Provedor();
            provedor.setCodigo(resultSet.getString("codigo"));
            provedor.setNombre(resultSet.getString("nombre"));
            provedor.setCategoria(resultSet.getInt("id_categoria"));
            provedor.setNombreProducto(resultSet.getString("nombre_Producto"));
            provedor.setCorre(resultSet.getString("correo"));
            provedor.setDireccion(resultSet.getString("direccion"));
            provedor.setTelefono(resultSet.getInt("telefono"));
            provedor.setFechaEntrada(resultSet.getDate("fecha_ingreso"));
            provedor.setFechaLimite(resultSet.getDate("fecha_salida"));
            provedorList.add(provedor);
              Conexion.conexion().close();
          }
        }catch (Exception e){
            System.out.println(""+e);
            JOptionPane.showMessageDialog(null,"Error 100");
        }
        return provedorList;
    }
    public static  List<Almacen> AlmacenDatos(ResultSet resultSet){
      List<Almacen> lisAlmacen = new ArrayList<>();
        try {
           while (resultSet.next()) {
             Almacen almacen = new Almacen();
             almacen.setId(resultSet.getInt("id"));
             almacen.setCodigoProve(resultSet.getString("CodigoProvedor"));
             almacen.setCodigo(resultSet.getString("codigo"));
             almacen.setNombre(resultSet.getString("nombre"));
             almacen.setCantidad(resultSet.getInt("cantidad"));
             almacen.setPrecioUnitario(resultSet.getDouble("precioUnitario"));
             almacen.setPrecioporDocena(resultSet.getDouble("precioporDocena"));
             almacen.setFechaEntrada(resultSet.getTimestamp("fecha_Entrada").toString());
             almacen.setFechaLimite(resultSet.getTimestamp("fecha_Limite").toString());
             lisAlmacen.add(almacen);
             
               Conexion.conexion().close();
           }
       }catch (Exception e){
            System.out.println(""+e);
            JOptionPane.showMessageDialog(null,"Error 100");
       }
      return  lisAlmacen;
    }
}

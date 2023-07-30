/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import ConexionServidor.Conexion;
import Vista.Entrada.AlmacenDiseño;
import Vista.Entrada.RegistroProvedores;
import javax.swing.*;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

/**
 *
 * @author gutie
 */
public class ConsultaModificacion {
    
      public static void GuardarRe (JTextField codi ,JTextField usu 
            ,JTextField contr , JComboBox sele){
         int fila = 0;
        switch(sele.getSelectedIndex()){
            case  0 :
                fila = 1; break;
            case  1 :
                fila = 2;break;
            case  2 :    
                fila = 3;break;
        }  
        try{
            String sql = "INSERT INTO Usuarios (idPersonal, usuarios, contraseña, id_TipoRol)\n" +
         "VALUES ('"+codi.getText()+"', '"+usu.getText()+"', "
       + "'"+contr.getText()+"', "+fila+")";
            int rowsAffected = Conexion.conexion().createStatement().executeUpdate(sql);
             if (rowsAffected > 0) {
                 JOptionPane.showMessageDialog(null,"Registro insertado correctamente.","",3);
             } else {
                 JOptionPane.showMessageDialog(null,"No se pudo insertar el registro.","",3);
             }
        }catch(Exception e){
              System.out.println(""+e);
            JOptionPane.showMessageDialog(null,"Error 500");
        }
        
    }
    public static void GuardadoPersonal(JTextField codigo,JTextField nombre,
            JTextField apellido,JTextField edad, JTextField correo , 
            JTextField direccion , JComboBox genero ,JTextField telfeno  ){
      try {
                String sql = "INSERT INTO Personal (codigo, nombre, apellido, edad, genero, correo, direccion, telefono, fecha_ingreso,fecha_salida) " +
                          "VALUES ('"+codigo.getText()+"','"+nombre.getText()+"'," +
                        " '"+apellido.getText()+"',"+edad.getText()+",'"+String.valueOf(genero.getSelectedIndex())+"','"+correo.getText()+"', '"+direccion.getText()+"'," +
                        ""+telfeno.getText()+",'"+Consultas.FechaActual()+"','"+Consultas.FechaActual()+"')";

             int rowsAffected = Conexion.conexion().createStatement().executeUpdate(sql);
             if (rowsAffected > 0) {
                 JOptionPane.showMessageDialog(null,"Registro insertado correctamente.","",3);
             } else {
                 JOptionPane.showMessageDialog(null,"No se pudo insertar el registro.","",3);
             }
        } catch (Exception e) {
            System.out.println(""+e);
            JOptionPane.showMessageDialog(null,"Error 500");
        }
    }
       
    
    
    public static String  IsertarAlmacen(Almacen almacen , String NommbreAlmacen){
        Integer succes = null;
        try{
   
            succes = (Conexion.conexion().prepareStatement("insert into "+NommbreAlmacen+"(CodigoProvedor,codigo,nombre,cantidad,precioUnitario,"
                    + "precioporDocena,fecha_Entrada,fecha_Limite) values('"+almacen.getCodigoProve()+"',"
                            + "'"+almacen.getCodigo()+"','"+almacen.getNombre()+"',"+almacen.getCantidad()+","
                                    + ""+almacen.getPrecioUnitario()+","+almacen.getPrecioporDocena()+",'"+almacen.getFechaEntrada()+"','"+almacen.getFechaLimite()+"');").executeUpdate())>0 ? 1 : 0 ;
            Conexion.conexion().close();
            if(succes == 1){
                JOptionPane.showMessageDialog(null,"Se registro Correctamente");
            }else{
                JOptionPane.showMessageDialog(null,"Hubo un error de Registro");
            }
        }catch (Exception e){
            System.out.println(""+e);
            JOptionPane.showMessageDialog(null,"Error 500");
        }
        String a =  "Se registro en el almacen  : " + NommbreAlmacen + "\ncantidad de Registro : " + almacen.getCantidad() + "\nFecha de Movimiento : " + almacen.getFechaEntrada();
       return a ;
    }
    public static Integer IsertarProvedor(RegistroProvedores es){
        Integer succes = null;
        int fila = 0;
        switch(es.catProvedores.getSelectedIndex()){
            case 0 : 
                fila = 1 ; break ;
            case 1 : 
                fila = 2 ; break ;
            case 2 : 
                fila = 3 ; break ;
        }
        try{
            succes = (Conexion.conexion().createStatement().executeUpdate("insert into Provedor(codigo,nombre,id_categoria,nombre_Producto,correo,direccion,telefono,fecha_ingreso,fecha_salida)\n" +
                    "values('"+es.jTextField1.getText()+"',"
                            + "'"+es.nombreProvedores.getText()+"',"
                                    + ""+fila+",'"+es.jTextField2.getText()+"',"
                                            + "'"+es.correoProvedores.getText()+"',"
                + "'"+es.direccionProvedores.getText()+"',"+es.numeroProvedores.getText()+",'"+Consultas.FechaActual()+
                    "', '"+Consultas.FechaActual()+"');"))>0 ? 1 : 0 ;
        }catch (Exception e){
            System.out.println(""+e);
            JOptionPane.showMessageDialog(null,"Error 500");
        }
        return succes;
    }
    public static void Eliminacion(String Codigo , String almacen){
        try{
            String sql = "DELETE FROM "+almacen+" WHERE id = "+Codigo+";";
             Statement a = Conexion.conexion().createStatement();
            int rowsAffected = a.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se elemino el producto ");
        }catch(Exception e){
            System.out.println(""+e);
            JOptionPane.showMessageDialog(null,"Error 500");
        }
        
    }
    public static Integer InsertoTrabajadores(){
        Integer succes = null;
        try{
            succes = (Conexion.conexion().createStatement().executeUpdate(""))>0 ? 1 : 0 ;
        }catch (Exception e){
            System.out.println(""+e);
            JOptionPane.showMessageDialog(null,"Error 500");
        }
        return succes;
    }


}

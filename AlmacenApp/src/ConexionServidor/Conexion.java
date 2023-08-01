package ConexionServidor;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    /*-- Peticion de Dataos a--*/
    /*-----------------------*/
    /*------------------------*/
    public static  Connection conectar = null;
    public static Connection conexion(){
        try{
            String  usu = DBconstacia.usu;
            String cont = DBconstacia.cont;
            String bd =   DBconstacia.bd;
            String ip =   DBconstacia.ip;
            String puerto  = DBconstacia.puerto;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String cadena = "jdbc:sqlserver://"+ip+":"+puerto+";"+"databaseName="+bd+";"+"encrypt=true;trustServerCertificate=true";
            conectar = DriverManager.getConnection(cadena,usu,cont);
        }catch (Exception e){
            System.out.println("falla"+ e.getMessage());
        }
        return conectar;
    }
  
}

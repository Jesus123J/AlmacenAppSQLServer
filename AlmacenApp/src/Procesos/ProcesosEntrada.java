package Procesos;
import Vista.Entrada.Entrada;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class ProcesosEntrada {
    static void SetImageLabel(JLabel labelName , String url ){
        ImageIcon image = new ImageIcon(url);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_FAST));
         labelName.setIcon(icon);
    }

    public static void FormaImagen(Entrada entrada){
        //Panel 3
        ProcesosEntrada.SetImageLabel(entrada.ImagenDeIconoVerificacion, "src/ImagenIcono/inventario.png");
        ProcesosEntrada.SetImageLabel(entrada.regresarAlUsuario, "src/ImagenIcono/Regre.png" );
        //Panel 2
        ProcesosEntrada.SetImageLabel(entrada.OjoVisibleAdmin, "src/ImagenIcono/no-visible.png");
        ProcesosEntrada.SetImageLabel(entrada.OjoNoVisibleAdmin, "src/ImagenIcono/ojo1.png");
        ProcesosEntrada.SetImageLabel(entrada.RegresarUsuario, "src/ImagenIcono/Regre.png" );
        ProcesosEntrada.SetImageLabel(entrada.IconoAdmin,"src/ImagenIcono/administrador.png");
        //panel 1
        ProcesosEntrada.SetImageLabel(entrada.IconoimagendEfondoUsuario, "src/ImagenIcono/categorias.png");
        ProcesosEntrada.SetImageLabel(entrada.IngresoaVentanaAdmin, "src/ImagenIcono/usuario.png" );
        ProcesosEntrada.SetImageLabel(entrada.OjoNoVisibleUsuarioPRincipal,"src/ImagenIcono/no-visible.png");
        ProcesosEntrada.SetImageLabel(entrada.OjoVisibleUsuarioPRincipal,"src/ImagenIcono/ojo1.png");
    }
    public static void setPanelBackground(JPanel panel) {
        JPanel a =new JPanel(){
            @Override
            public void paint(Graphics g){
                try{
                    Image imagen = new ImageIcon(getClass().getResource("/ImagenFondo/fondo3.png")).getImage();
                    g.drawImage(imagen, 0, 0, getWidth(),getHeight(),this);
                    setOpaque(false);
                    super.paint(g);
                }catch(Exception e){
                    System.out.print(e.toString());
                }
            }

        };
        a.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        panel.add(a, BorderLayout.CENTER);
    }
    public  static void IniciarForma(Entrada entrada){
        //Quitamos fondos y ubicamos las clases

        entrada.ApellidoVerificacion.setOpaque(false);
        entrada.DniVerificacion.setOpaque(false);
        entrada.NombreVerificacion.setOpaque(false);
        entrada.Verificacion.setOpaque(false);
        entrada.Verificacion.setVisible(false);
        entrada.IngresoAdmin.setVisible(false);
        entrada.OjoVisibleAdmin.setVisible(false);
        entrada.IngresoAdmin.setOpaque(false);
        entrada.RegresarUsuario.setOpaque(false);
        entrada.UsuarioAdmin.setOpaque(false);
        entrada.IngresoUsuario.setOpaque(false);
        entrada.ContraseñaPrincipal.setOpaque(false);
        entrada.UsuarioCentral.setOpaque(false);
        entrada.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        entrada.ContraseñaAdmin.setEchoChar('❂');
        entrada.ContraseñaAdmin.setOpaque(false);
        entrada.ContraseñaPrincipal.setEchoChar('❂');
        entrada.setLocationRelativeTo(null);
        entrada.setResizable(false);
        entrada.setTitle("INGRESO DE DATOS DEL TRABAJADOR ********************");
        entrada.OjoNoVisibleUsuarioPRincipal.setVisible(false);
        entrada.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                this.cerrar();

            }

            private void cerrar() {
                String botones[] = {"cerrar", "Cancelar"};
                int eleccion = JOptionPane.showOptionDialog(null,
                        "¿Desea cerar el programa","perro",0,0,null,botones,this );
                if(eleccion == JOptionPane.YES_OPTION){
                    System.exit(0);
                }else if(eleccion == JOptionPane.NO_OPTION){
                    System.out.println("Se cancelo ");
                }
            }
        });

        entrada.setVisible(true);

    }
    public static void Limpiesa(Entrada ing){
          ing.UsuarioCentral.setText("");
          ing.ContraseñaPrincipal.setText("");
          ing.UsuarioAdmin.setText("");
          ing.ContraseñaAdmin.setText("");
          ing.NombreVerificacion.setText("");
          ing.ApellidoVerificacion.setText("");
          ing.DniVerificacion.setText("");
     }
   
}

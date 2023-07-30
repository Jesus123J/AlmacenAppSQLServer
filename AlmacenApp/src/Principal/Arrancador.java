package Principal;
import Controladores.ControladorEntrada;
import Vista.Entrada.Entrada;
public class Arrancador {
    public static Entrada ingre ;
    public static void main(String[] args) {
        ingre = new Entrada();
        ControladorEntrada entr = new ControladorEntrada(ingre);
    }
}

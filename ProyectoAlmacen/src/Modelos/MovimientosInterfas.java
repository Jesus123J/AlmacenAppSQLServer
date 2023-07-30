/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Controladores.ControladorGuardado;
import Interfaces.Movimientos;

import javax.swing.*;

/**
 *
 * @author gutie
 */

public class MovimientosInterfas implements Movimientos {

    public String movi = "Movimiento registrado";
    @Override
    public String MovemientosGuardado() {
        return this.movi;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Juego.Juego;

/**
 *
 * @author David Campos Rodríguez <david.campos@rai.usc.es>
 */
public class Sectoid extends Enemigo{

    public Sectoid(String nombre, int[] enePos, Juego juego) {
        super(nombre, enePos, juego);
    }
    public Sectoid(String strnombre, int saludInicial, int energiaPorTurno, int[] pos, Juego juego) {
        super(strnombre, saludInicial, energiaPorTurno, pos, juego);
    }
    
}

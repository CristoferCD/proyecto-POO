/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Excepciones.CeldaObjetivoNoValida;
import Juego.Juego;

/**
 *
 * @author David Campos Rodríguez <david.campos@rai.usc.es>
 */
public final class LightFloater extends Floater{

    public LightFloater(String nombre, int vida, int energiaPorTurno, int[] posicion, Juego juego) throws CeldaObjetivoNoValida {
        super(nombre, vida, energiaPorTurno, posicion, juego);
    }

    public LightFloater(String nombre, int[] posicion, Juego juego) throws CeldaObjetivoNoValida {
        super(nombre, posicion, juego);
    }

}

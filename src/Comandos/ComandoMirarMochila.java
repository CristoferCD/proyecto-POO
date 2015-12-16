/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import Excepciones.ComandoExcepcion;
import Personajes.Jugador;

/**
 *
 * @author David Campos Rodríguez <david.campos@rai.usc.es>
 */
public final class ComandoMirarMochila implements Comando{
    private Jugador jug;
    public ComandoMirarMochila(Jugador jug){
        this.jug = jug;
    }

    public Jugador getJugador() {
        return jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }
    
    
    
    @Override
    public void ejecutar() throws ComandoExcepcion {
        if(jug!=null)
            jug.mirarMochila();
    }
    
}
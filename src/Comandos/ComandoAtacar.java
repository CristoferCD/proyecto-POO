/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import Excepciones.ComandoExcepcion;
import Mapa.Celda;
import Mapa.Punto;
import Mapa.Transitable;
import Personajes.Jugador;

/**
 *
 * @author David Campos Rodríguez <david.campos@rai.usc.es>
 */
public final class ComandoAtacar implements Comando{
    private Jugador jug;
    private String nombre;
    private int x, y;
    
    public ComandoAtacar(Jugador jug, String nombre, int x, int y){
        //nombre puede ser null
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.jug = jug;
    }

    public Jugador getJug() {
        return jug;
    }

    public void setJug(Jugador jug) {
        this.jug = jug;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setDir(int x, int y){
        setX(x);
        setY(y);
    }
    
    @Override
    public void ejecutar() throws ComandoExcepcion {
        if(jug != null){
            Celda c = jug.getMapa().getCelda(new Punto(x, y));
            if(c instanceof Transitable){
                try{
                    if(nombre == null || nombre.isEmpty())
                        jug.atacar((Transitable) c);
                    else
                        jug.atacar(((Transitable)c).getEnemigo(nombre));
                }catch(Exception e){
                    throw new ComandoExcepcion(e.getMessage());
                }
            }else
                throw new ComandoExcepcion("La celda a atacar es no transitable...");
        }
    }
}
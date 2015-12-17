/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Excepciones.CeldaObjetivoNoValida;
import Excepciones.DireccionMoverIncorrecta;
import Excepciones.EnergiaInsuficienteException;
import Excepciones.ImposibleCogerExcepcion;
import Excepciones.ObjetoNoEquipableException;
import Excepciones.PosicionFueraDeAlcanceException;
import Excepciones.PosicionFueraDeRangoException;
import Juego.Juego;
import Mapa.Mapa;
import Mapa.Punto;
import Mapa.Transitable;
import Objetos.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author David Campos Rodríguez <david.campos@rai.usc.es>
 */
public abstract class Enemigo extends Personaje{
    final static Random r = new Random();
    
    public Enemigo(String nombre, int vida, int energiaPorTurno, int[] posicion, Juego juego) throws CeldaObjetivoNoValida {
        super(nombre, vida, energiaPorTurno, new Mochila(), null, null, 5, juego);
        mapa = null;
        if(posicion.length == 2 && posicion[0] >= 0 && posicion[1] >= 0)
            setPos(new Punto(posicion[1], posicion[0]));
    }
    public Enemigo(String nombre, int[] posicion, Juego juego) throws CeldaObjetivoNoValida {
        this(nombre, Math.abs(r.nextInt())%51+50,Math.abs(r.nextInt())%70+31,posicion, juego);
    }
    public void setMapa(Mapa mapa) throws CeldaObjetivoNoValida{
        if(mapa != null) {
            if(this.mapa == null || !this.mapa.equals(mapa)) {
                if(this.mapa != null)
                    this.mapa.remEnemigo(this);
                
                //La posición ha de ser válida.
                if(mapa.getCelda(getPos()) != null && mapa.getCelda(getPos()) instanceof Transitable && ((Transitable)mapa.getCelda(getPos())).estaDisponible()){
                    this.mapa = mapa;
                    ((Transitable)this.mapa.getCelda(getPos())).addEnemigo(this);
                }else
                    this.mapa = null;
            }
        }else
            this.mapa = null;
    }

    @Override
    public final void setPos(Punto pos) throws CeldaObjetivoNoValida{
        if(mapa != null && 
            mapa.getCelda(pos) != null &&
            mapa.getCelda(pos) instanceof Transitable &&
            ((Transitable)mapa.getCelda(pos)).estaDisponible() &&
            (this instanceof Enemigo || ((Transitable)mapa.getCelda(pos)).getEnemigos().isEmpty())
        ){
                if(mapa.getCelda(getPos()) != null)
                    ((Transitable)mapa.getCelda(getPos())).remEnemigo(this);
                ((Transitable)mapa.getCelda(pos)).addEnemigo(this);
        }
        super.setPos(pos);
    }
    @Override
    public int calculoDano(Personaje atacado, int danoBase){return danoBase;}
    
    public void morir(){
        if(this.getVida() <= 0) {
            if(getArma() != null) tirar(getArma());
            if(getArma_izq() != null) tirar(getArma_izq());
            if(getArmadura() != null) tirar(getArmadura());
            for(Objeto ob: this.getMochila().getObjetos())
                this.tirar(ob);
            try{
                this.getMapa().remEnemigo(this);
            }catch(CeldaObjetivoNoValida e){
                juego.log(e.getMessage());
            }
        }
    }
    
    protected boolean decidirCogerArma(Arma a) {
        //El enemigo cogerá un arma si es mejor que las que lleva o simplemente puede equiparla
        //no la meterá en la mochila
        if(a.getTipo() != Arma.ARMA_DOS_MANOS) {
            //Arma a una mano
            if( (this.getArma() != null && this.getArma().getTipo() == Arma.ARMA_DOS_MANOS)
                || (this.getArma() != null && this.getArma_izq() != null)){
                    //Tiene todo ocupado
                    return getEfectoArmas() < a.getDano();
                }else{
                    //Tiene algo ocupado
                    return true;
                }
        }else{
            //Arma a dos manos
            return getEfectoArmas() < a.getDano();
        }
    }
    protected void iaRecogerObjetos() throws ImposibleCogerExcepcion, ObjetoNoEquipableException, EnergiaInsuficienteException{
        ArrayList<Objeto> obs;
        Transitable c = (Transitable) mapa.getCelda(getPos());
        if( (obs = c.getObjetos()).size() > 0)
            for(Objeto o: obs){
                if(o instanceof Arma){
                    Arma arma = (Arma) o;
                    if(decidirCogerArma(arma)){
                        if(manosOcupadasConArmas() > 1)
                            desequipar(getArma());
                        coger(arma.getNombre());
                    }
                }else if(o instanceof Armadura){
                    Armadura armadura = (Armadura) o;
                    if( getArmadura() == null || armadura.getDefensa() > getArmadura().getDefensa())
                        coger(armadura.getNombre());
                }else if(o instanceof Botiquin || o instanceof ToritoRojo){
                    coger(o.getNombre());
                } //No coge binoculares
            }
    }
    protected void iaAtacar() throws PosicionFueraDeRangoException, PosicionFueraDeAlcanceException, EnergiaInsuficienteException{
        this.atacar(mapa.getJugador());
    }
    protected String iaDirJugador(){
        Punto vector = Punto.resta(mapa.getJugador().getPos(), getPos());
        if(Math.abs(vector.x) > Math.abs(vector.y))
            return vector.x>0?"E":"O";
        else
            return vector.y>0?"S":"N";
    }
    protected void iaMover() throws CeldaObjetivoNoValida, DireccionMoverIncorrecta, EnergiaInsuficienteException{
        String dir="N";
        //Se mueve aleatoriamente si no ve al jugador
        if(!enRango(mapa.getJugador().getPos()))
        {
            switch(r.nextInt(4)){
                case 0: dir = "S"; break;
                case 1: dir = "E"; break;
                case 2: dir = "O"; break;
            }
        }else if(!enAlcance(mapa.getJugador().getPos()))
            dir = iaDirJugador();
        
        mover(dir);
    }
    public void iaTurno(){
        while(getEnergia() > 0){
            boolean hizoAlgo = false;
            try {
                iaAtacar();
                hizoAlgo = true;
            } catch (PosicionFueraDeRangoException | PosicionFueraDeAlcanceException | EnergiaInsuficienteException ex){/*No hace nada*/}
            try {
                iaMover();
                hizoAlgo = true;
            } catch (CeldaObjetivoNoValida | DireccionMoverIncorrecta | EnergiaInsuficienteException ex) {/*No hace nada*/}
            
            try {
                iaRecogerObjetos();
                hizoAlgo = true;
            } catch (ImposibleCogerExcepcion | ObjetoNoEquipableException | EnergiaInsuficienteException ex) {/*No hace nada*/}
            if(!hizoAlgo)
                break;
        }
    }
}
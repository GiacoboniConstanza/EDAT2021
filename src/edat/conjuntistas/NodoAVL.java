/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edat.conjuntistas;

/**
 *
 * @author Coqui
 */
public class NodoAVL {

    /*elem:TipoElemento
    altura:int
    izquierdo:NodoAVL
    derecho:NodoAVL*/
    private Comparable elem;
    private int altura;
    private NodoAVL izquierdo;
    private NodoAVL derecho;

    //NodoAVL(TipoElemento,NodoAVL,NodoAVL)
    public NodoAVL(Comparable e, NodoAVL i, NodoAVL d) {
        this.elem = e;
        this.izquierdo = i;
        this.derecho = d;
        this.altura = 0;
    }

    //getElem():TipoElemento
    public Comparable getElem() {
        return this.elem;
    }

    //setElem(TipoElemento)
    public void setElem(Comparable e) {
        this.elem = e;
    }

    //getAltura():int
    public int getAltura() {
        return this.altura;
    }

    //recalcularAltura()
    public void recalcularAltura(){
        if(this.izquierdo != null && this.derecho != null){
            this.altura = (Math.max(this.izquierdo.altura, this.derecho.altura)) + 1;
        } else {
            if(this.derecho == null){
                this.altura = (Math.max(this.izquierdo.altura, -1)) + 1;
            } else {
                if(this.izquierdo == null){
                    this.altura = (Math.max(-1, this.derecho.altura)) + 1;
                }
            }
        }
    }
    //getIzquierdo():NodoAVL
    public NodoAVL getIzquierdo() {
        return this.izquierdo;
    }

    //setIzquierdo(NodoAVL)
    public void setIzquierdo(NodoAVL i) {
        this.izquierdo = i;
    }

    //getDerecho():NodoAVL
    public NodoAVL getDerecho() {
        return this.derecho;
    }

    //setDerecho(NodoALV)
    public void setDerecho(NodoAVL d) {
        this.derecho = d;
    }
}


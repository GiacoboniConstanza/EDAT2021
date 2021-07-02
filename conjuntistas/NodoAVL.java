/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

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

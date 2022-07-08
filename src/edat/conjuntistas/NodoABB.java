/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edat.conjuntistas;

/**
 *
 * @author Coqui
 */
public class NodoABB {

    /*elem:TipoElemento
    izquierdo:NodoABB
    derecho:NodoABB*/
    private Comparable elem;
    private NodoABB izquierdo;
    private NodoABB derecho;

    //NodoABB(TipoElemento,NodoABB,NodoABB)
    public NodoABB(Comparable e, NodoABB i, NodoABB d) {
        this.elem = e;
        this.izquierdo = i;
        this.derecho = d;
    }

    //getElem():TipoElemento
    public Comparable getElem() {
        return this.elem;
    }

    //getIzquierdo():NodoABB
    public NodoABB getIzquierdo() {
        return this.izquierdo;
    }

    //getDerecho():NodoABB
    public NodoABB getDerecho() {
        return this.derecho;
    }

    //setElem(TipoElemento)
    public void setElem(Comparable e) {
        this.elem = e;
    }

    //setIzquierdo(NodoABB)
    public void setIzquierdo(NodoABB i) {
        this.izquierdo = i;
    }

    //setDerecho(NodoABB)
    public void setDerecho(NodoABB d) {
        this.derecho = d;
    }
}


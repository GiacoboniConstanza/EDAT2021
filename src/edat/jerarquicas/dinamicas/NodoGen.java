/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edat.jerarquicas.dinamicas;

/**
 *
 * @author Coqui
 */
public class NodoGen {

    //elem:TipoElemento
    //hijoIzquierdo:NodoGen
    //hermanoDerecho:NodoGen
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;

    //NodoGen(Tipolemento,NodoGen,NodoGen)
    public NodoGen(Object elem, NodoGen hijoI, NodoGen hnoD) {
        this.elem = elem;
        this.hijoIzquierdo = hijoI;
        this.hermanoDerecho = hnoD;
    }

    //setElem(TipoElemtento)
    public void setElem(Object elem) {
        this.elem = elem;
    }

    //setHijoIzquierdo(NodoGen)
    public void setHijoIzquierdo(NodoGen hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    //serHermanoDerecho(NodoGen)
    public void setHermanoDerecho(NodoGen hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }

    //getHijoIzquierdo():NodoGen
    public NodoGen getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    //getHermanoDerecho():NodoGen
    public NodoGen getHermanoDerecho() {
        return hermanoDerecho;
    }

    //getElem():TipoElemento
    public Object getElem() {
        return elem;
    }

}


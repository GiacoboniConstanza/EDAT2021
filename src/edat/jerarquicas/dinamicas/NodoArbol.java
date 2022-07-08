/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edat.jerarquicas.dinamicas;

/**
 *
 * @author Coqui
 */
public class NodoArbol {
    //atributos
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    //NodoArbol(TipoElemento,NodoArbol,NodoArbol)
    public NodoArbol(Object elemento, NodoArbol izq, NodoArbol der){
        this.elem=elemento;
        this.izquierdo=izq;
        this.derecho=der;
    }

    //getElem():TipoElemento
    public Object getElem(){
        return this.elem;
    }
    //getIzquierdo():NodoArbol
    public NodoArbol getIzquierdo(){
        return this.izquierdo;
    }
    //getDerecho():NodoArbol
    public NodoArbol getDerecho(){
        return this.derecho;
    }
    //setElem(TipoElemento)
    public void setElem(Object elemento){
        this.elem=elemento;
    }
    //setIzquierdo(NodoArbol)
    public void setIzquierdo(NodoArbol izq){
        this.izquierdo=izq;
    }
    //setDerecho(NodoArbol)
    public void setDerecho (NodoArbol der){
        this.derecho=der;
    }
}

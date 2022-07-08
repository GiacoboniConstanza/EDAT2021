/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edat.lineales.dinamicas;

/**
 *
 * @author Coqui
 */
public class Cola {

    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    //poner(TipoElemento):boolean
    public boolean poner(Object elem) {
        Nodo nuevo = new Nodo(elem, null);
        //si la cola esta vacia
        if (esVacia()) {
            this.frente = nuevo;
            this.fin = nuevo;
        } else {
            this.fin.setEnlace(nuevo);
            this.fin = nuevo;
        }
        return true;
    }

    //sacar():boolean
    public boolean sacar() {
        boolean exito = true;
        if (esVacia()) {
            //la cola esta vacia, reporta error
            exito = false;
        } else {
            //hay al menos un elemento
            this.frente = this.frente.getEnlace();
            //actualiza fin en caso de que quede vacia
            if (this.frente == null) {
                this.fin = null;
            }
        }
        return exito;
    }

    //obtenerFrente():TipoElemento
    public Object obtenerFrente() {
        Object elem;
        if (esVacia()) {
            elem = null;
        } else {
            elem = this.frente.getElem();
        }
        return elem;
    }

    //esVacia():boolean
    public boolean esVacia() {
        boolean vacia;
        if (this.frente == null) {
            vacia = true;
        } else {
            vacia = false;
        }
        return vacia;
    }

    //vaciar()
    public void vaciar() {
        this.frente = null;
        this.fin = null;
    }

    //clone():Cola
   public Cola clone() {
        
        Cola clon = new Cola();
        
        //nodo1 puntero de la cola original
        //nodo2 puntero de la cola clonada
        Nodo nodo1, nodo2;
        Object elem;
        
        nodo1 = this.frente;
        
        if (nodo1 != null) {
            elem = nodo1.getElem();
            nodo2 = new Nodo(elem, null);
            clon.frente = nodo2;
            clon.fin = nodo2;
            
            while (nodo1.getEnlace() != null) {
                nodo1 = nodo1.getEnlace();
                elem = nodo1.getElem();
                nodo2 = new Nodo(elem, null);
                clon.fin.setEnlace(nodo2);
                clon.fin = clon.fin.getEnlace();
            }
        }
        return clon;
    }

    //toString():String
    public String toString() {
        String info = "";
        Nodo aux = this.frente;
        if (esVacia()) {
            info = "Cola vacia";
        } else {
            
            info = "[";
            while (aux != null) {
                info += "  " + aux.getElem();
                aux = aux.getEnlace();
            }
            info += "]";
        }
        return info;
    }
    
}

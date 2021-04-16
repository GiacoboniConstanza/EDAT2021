/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

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
    public Object ontenerFrente() {
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
        vacia = this.frente == this.fin;
        return vacia;
    }

    //vaciar()
    public void vaciar() {
        this.frente = null;
        this.fin = null;
    }

    //clone():Cola
    public Cola clone() {
        Cola copia = new Cola();
        //aux1 frente original, aux2 frente copia
        Nodo aux1 = this.frente;
        Nodo aux2;

        //si la cola no esta vacia
        if (aux1 != null) {
            Object elem = aux1.getElem();
            aux2 = new Nodo(elem, null);
            copia.frente = aux2;
            copia.fin = aux2;

            while (aux1.getEnlace() != null) {
                aux1.getEnlace();
                elem = aux1.getElem();
                aux2 = new Nodo(elem, null);
                copia.fin.setEnlace(aux2);
                copia.fin = copia.fin.getEnlace();
            }
        }
        return copia;
    }

    //toString():String
    public String toString() {
        String info = "";
        if (esVacia()) {
            info = "Cola vacia";
        } else {
            Nodo aux = this.frente;
            info = "[";
            while (aux != null) {
                info += aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    info += " , ";
                }
            }
            info += "]";
        }
        return info;
    }
}

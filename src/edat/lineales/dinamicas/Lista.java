/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edat.lineales.dinamicas;

/**
 *
 * @author Coqui
 */
public class Lista {

    private Nodo cabecera;
    private int longitud;

    public Lista() {
        this.cabecera = null;
        this.longitud = 0;
    }

    //insertar(TipoElemento,int):boolean
    public boolean insertar(Object nuevoElem, int pos) {
        //inserta el elemento en la posicion
        //detecta y reporta pos invalida
        boolean exito = true;
        if (pos < 1 || pos > this.longitud() + 1) {
            exito = false;
        } else {
            if (pos == 1) {
                //crea nuevo nodo y enlaza en cabecera
                this.cabecera = new Nodo(nuevoElem, this.cabecera);
            } else {
                //avanza hasta elemento en pos-1
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                //crea el nuevo nodo y enlaza
                Nodo nuevo = new Nodo(nuevoElem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        longitud++;
        return exito;
    }

    //eliminar(int):boolean
    public boolean eliminar(int pos) {
        boolean exito;
        if (pos >= 0 && pos < longitud) {
            if (pos == 0) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                Nodo aux = this.cabecera;
                for (int i = 0; i < pos - 1; i++) {
                    aux = aux.getEnlace();
                }
                Nodo sig = aux.getEnlace();
                aux.setEnlace(sig.getEnlace());
            }
            longitud--;
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    //recuperar(int):TipoElemento
    public Object recuperar(int pos) {
        Object elem;
        //verificar si la posicion se encuentra en el rango
        if (pos >= 0 && pos < this.longitud) {
            if (pos == 0) {
                elem = this.cabecera.getElem();
            } else {
                Nodo aux = this.cabecera;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getEnlace();
                }
                elem = aux.getElem();
            }
        } else {
            elem = null;
        }
        return elem;
    }

    //localizar(TipoElemento):int
    public int localizar(Object elem) {
        int pos = -1, i = 0;
        Nodo aux = this.cabecera;
        while (aux.getElem() != elem || i <= longitud) {
            if (aux.getElem() == elem) {
                pos = i;
            } else {
                aux.getEnlace();
                i++;
            }
        }
        return pos;
    }

    //longitud():int
    public int longitud() {
        return this.longitud;
    }

    //esVacia():boolean
    public boolean esVacia() {
        boolean vacia;
        vacia = this.cabecera == null;
        return vacia;
    }

    //vaciar()
    public void vaciar() {
        this.cabecera = null;
        this.longitud = 0;
    }

    //clone():Lista
    public Lista clone(){
        Lista clon = new Lista();
        if(!esVacia()){
            clon.cabecera = new Nodo(this.cabecera.getElem(), null);
            Nodo aux1 = clon.cabecera;
            Nodo aux2 = this.cabecera.getEnlace();
            while (aux2 != null){
                Nodo aux3 = new Nodo(aux2.getElem(), null);
                aux1.setEnlace(aux3);
                aux1 = aux3;
                aux2 = aux2.getEnlace();
            }
        }
        return clon;
    }
    
    //toString():String
    public String toString() {
        String info = "";
        if (!esVacia()) {
            info += "[";
            Nodo aux = this.cabecera;
            while (aux != null) {
                info += "  " + aux.getElem();
                aux.getEnlace();
            }
            info += "]";
        } else {
            info = "Lista vacia";
        }
        return info;
    }
}


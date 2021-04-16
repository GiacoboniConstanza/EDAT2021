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
public class Lista {

    private Nodo cabecera;

    public Lista() {
        this.cabecera = null;
    }

    //insertar(TipoElemento,int):boolean
    public boolean insertar(Object nuevoElem, int pos){
        //inserta el elemento en la posicion
        //detecta y reporta pos invalida
        boolean exito = true;
        if(pos < 1 || pos > this.longitud() + 1){
            exito = false;
        }else{
            if(pos == 1){
                //crea nuevo nodo y enlaza en cabecera
                this.cabecera = new Nodo(nuevoElem, this.cabecera);
            }else{
                //avanza hasta elemento en pos-1
                Nodo aux = this.cabecera;
                int i = 1;
                while(i<pos-1){
                    aux = aux.getEnlace();
                    i++;
                }
                //crea el nuevo nodo y enlaza
                Nodo nuevo = new Nodo(nuevoElem,aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        return exito;
    }
    //eliminar(int):boolean
    //recuperar(int):TipoElemento
    //localizar(TipoElemento):int
    //longitud():int
    //esVacia():boolean
    //vaciar()
    //clone():Lista
    //toString():String
}

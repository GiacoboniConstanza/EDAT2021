/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edat.lineales.dinamicas;

/**
 *
 * @author Coqui
 */
public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object nuevoElem) {
        //crea un nuevo nodo delante de la antigua cabecera
        Nodo nuevo = new Nodo(nuevoElem, this.tope);
        //actualiza el tope para que apunte al nuevo nodo
        this.tope = nuevo;
        //nunca hay error de pila llena, devuelve true
        return true;
    }

    public boolean desapilar (){
        boolean exito=false;
        if(this.tope != null){
            this.tope = this.tope.getEnlace();
            exito = true;
        }
        return exito;
    }
    
    public Object obtenerTope(){
        Object aux;
        if(!esVacia()){
            aux = this.tope.getElem();
        }else{
            aux = null;
        }
        return aux;
    }
    
    public boolean esVacia(){
        boolean vacia;
        if (this.tope != null){
            vacia = false;
        }else{
            vacia = true;
        }
        return vacia;
    }
    
    public void vaciar(){
        this.tope = null;
    }
  
    public Pila clone() {
        //creamos la pila donde guardamos los elementos clonados
        Pila pilaClone = new Pila();
        //nodo auxiliar para guardar el tope de la pila original
        Nodo aux = this.tope;
        //nodo actual, conocemos el elemento
        Nodo nuevo = new Nodo(aux.getElem(), null);
        pilaClone.tope = nuevo;
        while (aux.getEnlace() != null) {
            //nodo aux2 para guardar elemento siguiente del nodo actual
            Nodo aux2 = new Nodo(aux.getEnlace().getElem(),null);
            //enlace entre nodo actual y el siguiente
            nuevo.setEnlace(aux2);
            //reemplazamos para actualizar el nodo
            nuevo = aux2;
            aux = aux.getEnlace();
        }

        return pilaClone;
    }
    
    public String toString (){
        String s ="";
        if(this.tope == null){
            s = "Pila vacia";
        }else{
            //se ubica para recorrer la pila
            Nodo aux = this.tope;
            s="[";
            while (aux!=null){
                //agrega el texto del elem y avanza
                s += aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux != null){
                    s += " , ";
                }
            }
            s += "]";
        }
        return s;
    }
}

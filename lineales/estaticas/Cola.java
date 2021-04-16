/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author Coqui
 */
public class Cola {
    private Object [] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO = 10;
    //Cola()
    public Cola (){
        this.arreglo = new Object[this.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }
    //poner(TipoElemento):boolean
    public boolean poner(Object elemento){
        boolean exito=false;
        if(!((this.fin+1)== this.frente)){
          this.arreglo[this.fin]= elemento;
          this.fin++;
          exito = true;
        }
        return exito;
    }
    //sacar(): boolean
    public boolean sacar(){
        boolean exito = true;
        if(this.esVacia()){ //la cola esta vacia, reporta error
            exito=false;
        }else{ //hay al menos un elemento, avanza frente de manera circular
            this.arreglo[this.frente]=null;
            this.frente = (this.frente+1)%this.TAMANIO;
        }
        return exito;
    }
    //obtenerFrente():TipoElemento
    public Object obtenerFrente(){
        Object aux;
        if (!esVacia()){
            aux = this.arreglo[this.frente];
        }else{
            aux = null;
        }
        return aux;
    }
    //esVacia():boolean
    public boolean esVacia(){
        boolean vacia;
        vacia = (this.frente == this.fin);
        return vacia;
    }
    //vaciar()
    public void vaciar(){
        while(!esVacia()){
            this.arreglo[this.frente]=null;
            this.frente = (this.frente+1)%this.TAMANIO;
        }
    }
    //clone():Cola
    public Cola clone(){
        Cola copia = new Cola();
        int i=0;
        copia.frente = this.frente;
        copia.fin = this.fin;
        if(!esVacia()){
            while(i <= this.TAMANIO){
                copia.arreglo[i]=this.arreglo[i];
                i++;
            }
        }
        return copia;
    }
    //toString():String
    public String toString(){
        String info;
        int aux = this.frente;
        if(esVacia()){
            info = "Cola vacia";
        }else{
            info = "[";
            while(aux!=this.fin){
                info += this.arreglo[aux];
                aux =(aux+1)%this.TAMANIO;
                if(aux != this.fin){
                    info += ", ";
                }
            }
            info += "]";
        }
        return info;
    }
}

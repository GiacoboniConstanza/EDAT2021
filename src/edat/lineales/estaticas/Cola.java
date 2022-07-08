/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edat.lineales.estaticas;

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
    public boolean poner(Object elemento) {
        boolean exito = true;
        if ((this.fin + 1)%TAMANIO == this.frente) {
            exito = false;
        } else {
            this.arreglo[this.fin] = elemento;
            this.fin = (this.fin + 1) % TAMANIO;
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
    public Cola clone() {
        
        Cola clon = new Cola();
        int  i = 0;
        
        clon.frente = this.frente;
        clon.fin = this.fin;
        
        while (i < TAMANIO) {
            clon.arreglo[i] = this.arreglo[i];
            i++;
        }
        
        return clon;
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


package edat.lineales.estaticas;

public class Pila {

    private Object[] arreglo;
    private int tope;
    private static final int TAMANIO = 10;

    public Pila() {
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElem) {
        boolean exito;
        if (this.tope + 1 >= this.TAMANIO) //pila llena
        {
            exito = false;
        } else {
            //pone el elemento en la pila e incrementa el tope
            this.tope++;
            this.arreglo[tope] = nuevoElem;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        boolean exito;
        if (!esVacia()) {
            //exiten celdas en el arreglo
            this.arreglo[tope] = null;
            this.tope--;
            exito = true;
        } else {
            //el arreglo se encuentra vacio
            exito = false;
        }
        return exito;
    }

    public Object obtenerTope() {
        Object aux;
        if (!esVacia()) {
            aux = this.arreglo[tope];
        } else {
            aux = null;
        }
        return aux;
    }

    public boolean esVacia() {
        boolean vacio;
        if (this.tope > -1) {
            vacio = false;
        } else {
            vacio = true;
        }
        return vacio;
    }

    public void vaciar() {
        while (!esVacia()) {
            this.arreglo[tope] = null;
            this.tope--;
        }
    }

    public Pila clone() {
        Pila aux = new Pila();
        int i;
        //asigno el tope a la nueva pila
        aux.tope = this.tope;
        //si la pila no esta vacia, se copian los elementos
        if (this.tope != -1) {
            for (i = 0; i <= this.tope; i++) {
                aux.arreglo[i] = this.arreglo[i];
            }
        }
        return aux;
    }

    public String toString() {
        String info = "";
        if (this.tope != -1) {
            info = "[";
            for (int i = 0; i < this.TAMANIO; i++) {

                if (this.arreglo[i] != null) {
                    info += (this.arreglo[i]);
                } else {
                    info += ("-");
                }
                info += "  ";
            }
            info += "]";
        }else{
            info = "Pila vacia";
        }

        return info;
    }
}

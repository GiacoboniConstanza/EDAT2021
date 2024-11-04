package edat.conjuntistas;

public class ArbolHeap {

    private int tamanio = 20;
    private Comparable[] heap;
    private int ultimo = 0;

    //heap
    public ArbolHeap() {
        this.heap = new Comparable[this.tamanio];
        this.ultimo = 0;
    }

    //insertar(TipoElemento):boolean
    public boolean insertar(Comparable e){
        boolean exito;
        if(this.ultimo+1>this.tamanio){
            exito=false;
        }else{
            this.ultimo++;
            this.heap[ultimo]=e;
            if(this.ultimo!=0){
                hacerSubir(ultimo);
            }
            exito=true;
        }
        return exito;
    }
 
    private void hacerSubir(int posE) {
        int posPadre = 1;
        boolean salir = false;
        while (!salir) {
            posPadre = posE / 2;
            Comparable temp = this.heap[posPadre];
            if (posPadre > 0) {
                if (this.heap[posE].compareTo(this.heap[posPadre]) < 0) {
                    this.heap[posPadre] = this.heap[posE];
                    this.heap[posE] = temp;
                    posE = posPadre;
                } else {
                    salir = true;
                }
            } else {
                salir = true;
            }
        }
    }
    //eliminarCima():boolean
    public boolean eliminarCima() {
        boolean exito;
        if (this.ultimo == 0) {
            exito = false;
        } else {
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }

    private void hacerBajar(int posPadre) {
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;
        while (!salir) {
            posH = posPadre * 2;
            if (posH <= this.ultimo) {
                if (posH < this.ultimo) {
                    if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0) {
                        posH++;
                    }
                }
                if (this.heap[posH].compareTo(temp) < 0) {
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;
                } else {
                    salir = true;
                }
            } else {
                salir = true;
            }
        }
    }

    //recuperarCima():TipoElemento
    public Comparable recuperarCima(){
        return this.heap[1];
    }
    
    //esVacio():boolean
    public boolean esVacio() {
        return this.ultimo == 0;
    }

    //vaciar()
    public void vaciar() {
        int i;
        for (i = 0; i <= this.ultimo; i++) {
            this.heap[i] = null;
        }
        this.ultimo = 0;
    }

    //toString():String
    public String toString() {
        String info = "[ ";
        if (this.ultimo != 0) {
            int i;
            for (i = 0; i <= this.ultimo; i++) {
                if (i != this.ultimo) {
                    info += this.heap[i] + ", ";
                } else {
                    info += this.heap[i];
                }
            }
        }
        info+=" ]";
        return info;
    }
}

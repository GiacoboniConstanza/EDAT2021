package edat.jerarquicas.dinamicas;

public class NodoGen {

    //elem:TipoElemento
    //hijoIzquierdo:NodoGen
    //hermanoDerecho:NodoGen
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;

    //NodoGen(Tipolemento,NodoGen,NodoGen)
    public NodoGen(Object elem, NodoGen hijoI, NodoGen hnoD) {
        this.elem = elem;
        this.hijoIzquierdo = hijoI;
        this.hermanoDerecho = hnoD;
    }

    //setElem(TipoElemtento)
    public void setElem(Object elem) {
        this.elem = elem;
    }

    //setHijoIzquierdo(NodoGen)
    public void setHijoIzquierdo(NodoGen hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    //serHermanoDerecho(NodoGen)
    public void setHermanoDerecho(NodoGen hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }

    //getHijoIzquierdo():NodoGen
    public NodoGen getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    //getHermanoDerecho():NodoGen
    public NodoGen getHermanoDerecho() {
        return hermanoDerecho;
    }

    //getElem():TipoElemento
    public Object getElem() {
        return elem;
    }

}


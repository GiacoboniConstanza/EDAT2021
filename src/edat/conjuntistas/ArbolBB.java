/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edat.conjuntistas;

import edat.lineales.dinamicas.Lista;
/**
 *
 * @author Coqui
 */
public class ArbolBB {

    //raiz: NodoABB
    private NodoABB raiz;

    //ArbolABB
    public ArbolBB() {
        this.raiz = null;
    }

    //pertenece(TipoElemento):boolean
    public boolean pertenece(Comparable e) {
        boolean exito;
        if (this.raiz != null) {
            exito = perteneceAux(this.raiz, e);
        } else {
            exito = false;
        }
        return exito;
    }

    private boolean perteneceAux(NodoABB n, Comparable e) {
        boolean exito = false;
        if (n.getElem().compareTo(e) == 0) {
            exito = true;
        } else {
            if (n.getElem().compareTo(e) > 0) {
                if (n.getIzquierdo() != null) {
                    exito = perteneceAux(n.getIzquierdo(), e);
                }
            } else {
                if (n.getDerecho() != null) {
                    exito = perteneceAux(n.getDerecho(), e);
                }
            }
        }
        return exito;
    }
    
    //insertar(TipoElemento):boolean
    public boolean insertar(Comparable e) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoABB(e, null, null);
        } else {
            exito = insertarAux(this.raiz, e);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB n, Comparable e) {
        boolean exito = true;
        if (e.compareTo(n.getElem()) == 0) {
            exito = false;
        } else {
            if (e.compareTo(n.getElem()) < 0) {
                if (n.getIzquierdo() != null) {
                    exito = insertarAux(n.getIzquierdo(), e);
                } else {
                    n.setIzquierdo(new NodoABB(e, null, null));
                }
            } else {
                if (n.getDerecho() != null) {
                    exito = insertarAux(n.getDerecho(), e);
                } else {
                    n.setDerecho(new NodoABB(e, null, null));
                }

            }
        }
        return exito;
    }

    //eliminar(TipoElemento):boolean
    public boolean eliminar(Comparable e) {
        NodoABB aux = this.raiz;
        NodoABB p = this.raiz;
        boolean esHijoIzq = true;
        while (aux.getElem() != e) {
            p = aux;
            if (e.compareTo(aux.getElem()) < 0) {
                esHijoIzq = true;
                aux = aux.getIzquierdo();
            } else {
                esHijoIzq = false;
                aux = aux.getDerecho();
            }
            if (aux == null) {
                return false;
            }
        }
        if (aux.getIzquierdo() == null && aux.getDerecho() == null) {//caso de hoja
            if (aux == this.raiz) {
                this.raiz = null;
            } else if (esHijoIzq) {
                p.setIzquierdo(null);
            } else {
                p.setDerecho(null);
            }
        } else if (aux.getDerecho() == null) {//solo tiene un hijo a la izquierda
            if (aux == this.raiz) {
                this.raiz = aux.getIzquierdo();
            } else if (esHijoIzq) {
                p.setIzquierdo(aux.getIzquierdo());
            } else {
                p.setDerecho(aux.getIzquierdo());
            }
        } else if (aux.getIzquierdo() == null) {//solo tiene un hijo a la derecha
            if (aux == this.raiz) {
                this.raiz = aux.getDerecho();
            } else if (esHijoIzq) {
                p.setIzquierdo(aux.getDerecho());
            } else {
                p.setDerecho(aux.getIzquierdo());
            }
        } else {
            NodoABB reemplazo = obtenerNodoReemplazo(aux);
            if (aux == this.raiz) {
                raiz = reemplazo;
            } else if (esHijoIzq) {
                p.setIzquierdo(reemplazo);
            } else {
                p.setDerecho(reemplazo);
            }
            reemplazo.setIzquierdo(aux.getIzquierdo());
        }
        return true;
    }

    private NodoABB obtenerNodoReemplazo(NodoABB nodoReemp) {
        NodoABB reemplazarPadre = nodoReemp;
        NodoABB reemplazo = nodoReemp;
        NodoABB aux = nodoReemp.getDerecho();
        while (aux != null) {
            reemplazarPadre = reemplazo;
            reemplazo = aux;
            aux = aux.getIzquierdo();
        }
        if (reemplazo != nodoReemp.getDerecho()) {
            reemplazarPadre.setIzquierdo(reemplazo.getDerecho());
            reemplazo.setDerecho(nodoReemp.getDerecho());
        }
        return reemplazo;
    }

    //listar():Lista
    public Lista listar() {
        Lista lis = new Lista();
        if (this.raiz != null) {
            listarAux(this.raiz, lis);
        }
        return lis;
    }

    private void listarAux(NodoABB n, Lista lis) {
        if (n != null) {
            lis.insertar(n.getElem(), lis.longitud() + 1);
            listarAux(n.getIzquierdo(), lis);
            listarAux(n.getDerecho(), lis);
        }
    }

    //listarRango(TipoElemento,TipoElemento):Lista
    public Lista listarRango(Comparable eMin, Comparable eMax) {
        Lista lis = new Lista();
        if (this.raiz != null) {
            listarRangoAux(this.raiz, eMin, eMax, lis);
        }
        return lis;
    }

    private void listarRangoAux(NodoABB n, Comparable min, Comparable max, Lista lis) {
        if (n != null) {
            if (n.getElem().compareTo(min) > 0) {
                listarRangoAux(n.getIzquierdo(), min, max, lis);
            }
            if (n.getElem().compareTo(min) >= 0 && n.getElem().compareTo(max) <= 0) {
                lis.insertar(n.getElem(), lis.longitud() + 1);
            }
            if (n.getElem().compareTo(max) < 0) {
                listarRangoAux(n.getDerecho(), min, max, lis);
            }
        }
    }
  
    //minimoElem():TipoElemento
    public Comparable minimoElem() {
        NodoABB n = this.raiz;
        while (n.getIzquierdo() != null) {
            n = n.getIzquierdo();
        }
        return n.getElem();
    }

    //maximoElem():TipoElemento
    public Comparable maximoElem() {
        NodoABB n = this.raiz;
        while (n.getDerecho() != null) {
            n.getDerecho();
        }
        return n.getElem();
    }

    //esVacio():boolean
    public boolean esVacio() {
        return this.raiz == null;
    }

    //vaciar()
    public void vaciar() {
        this.raiz = null;
    }

    //clone():ArbolBB
    public ArbolBB clone() {
        ArbolBB copia = new ArbolBB();
        if (this.raiz != null) {
            NodoABB aux = new NodoABB(this.raiz.getElem(), null, null);
            copia.raiz = aux;
            cloneAux(aux, this.raiz);
        }
        return copia;
    }

    private void cloneAux(NodoABB aux, NodoABB nodo) {
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
                aux.setIzquierdo(new NodoABB(nodo.getIzquierdo().getElem(), null, null));
                cloneAux(aux.getIzquierdo(), nodo.getIzquierdo());
            }
            if (nodo.getDerecho() != null) {
                aux.setDerecho(new NodoABB(nodo.getDerecho().getElem(), null, null));
                cloneAux(aux.getDerecho(), nodo.getDerecho());
            }
        }
    }

    //toString():String
    public String toString() {
        String info = "";
        if (this.raiz != null) {
            info = stringAux(this.raiz, "");
        } else {
            info = "ArbolBB vacio";
        }
        return info;
    }

    private String stringAux(NodoABB n, String res) {
        if (n != null) {
            NodoABB i = n.getIzquierdo();
            NodoABB d = n.getDerecho();
            res += "Nodo: " + n.getElem();
            if (i != null && d != null) {
                res += "  Hijo Izquierdo: " + i.getElem() + " Hijo Derecho: " + d.getElem() + "\n";
            } else {
                if (i != null && d == null) {
                    res += "  Hijo Izquierdo: " + i.getElem() + " Hijo Derecho: -" + "\n";
                } else {
                    if (d != null && i == null) {
                        res += "  Hijo Izquierdo: - Hijo Derecho: " + d.getElem() + "\n";
                    } else {
                        if (i == null && d == null) {
                            res += "  Hijo Izquierdo: - Hijo Derecho: - \n";
                        }
                    }
                }
            }
            res = stringAux(n.getIzquierdo(), res);
            res = stringAux(n.getDerecho(), res);
        }
        return res;
    }
    
    //metodos agregados del parcial
    private NodoABB obtenerNodo(NodoABB n, Comparable e){
        NodoABB nodo = null;
        if(n!=null){
            if(e.compareTo(n.getElem())==0){
                nodo = n;
            }
        }else{
            if(e.compareTo(n.getElem())<0){
                nodo=obtenerNodo(n.getIzquierdo(),e);
            }else{
                nodo=obtenerNodo(n.getDerecho(),e);
            }
        }
        return nodo;
    }
    
    public int sumarInordenDesde(Comparable valor, int t){
        int suma=0;
        NodoABB raizSub=obtenerNodo(this.raiz,valor);
        if(this.raiz==null || raizSub == null){
            suma=0;
        }
        if(raizSub!=null){
            suma=sumarInorden(raizSub,t,0);
            if(suma<t){
                suma=(-suma);
            }
        }
        return suma;
    }
    
    private int sumarInorden(NodoABB raiz, int t, int s){
        if (s<t){
            if(raiz!=null){
                s=sumarInorden(raiz.getIzquierdo(),t,s);
                if(s<t){
                    s+=(int)raiz.getElem();
                }
                if(s<t){
                    s=sumarInorden(raiz.getDerecho(),t,s);
                }
            }
        }
        return s;
    }
}


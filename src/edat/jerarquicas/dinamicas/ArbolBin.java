/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edat.jerarquicas.dinamicas;

import edat.lineales.dinamicas.Lista;
import edat.lineales.dinamicas.Cola;
/**
 *
 * @author Coqui
 */
public class ArbolBin {

    //atributos
    private NodoArbol raiz;

    //constructor
    public ArbolBin() {
        this.raiz = null;
    }

    //insertar(TipoElemento,TipoElemento,char):boolean
    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoArbol(elemNuevo, null, null);
        } else {
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                } else {
                    if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                        nodoPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                    } else {
                        exito = false;
                    }
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol nodo, Object buscado) {
        NodoArbol resultado = null;
        if (nodo != null) {
            if (nodo.getElem().equals(buscado)) {
                resultado = nodo;
            } else {
                resultado = obtenerNodo(nodo.getIzquierdo(), buscado);
                if (resultado == null) {
                    resultado = obtenerNodo(nodo.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    //esVacio():boolean
    public boolean esVacio() {
        return this.raiz == null;
    }

    //padre(TipoElement):TipoElemento
    public Object padre(Object elem) {
        Object p = null;
        if (!esVacio()) {
            if (!this.raiz.getElem().equals(elem)) {
                p = padreAux(this.raiz, elem);
            }
        }
        return p;
    }

    private Object padreAux(NodoArbol nodo, Object elem) {
        Object ret = null;
        if (nodo != null) {
            NodoArbol d = nodo.getDerecho();
            NodoArbol i = nodo.getIzquierdo();
            if (i != null && d != null) {
                if ((i.getElem().equals(elem)) || (d.getElem().equals(elem))) {
                    ret = nodo.getElem();
                } else {
                    ret = padreAux(d, elem);
                    if (ret == null) {
                        ret = padreAux(i, elem);
                    }
                }
            }
        }
        return ret;
    }

    //altura():int
    public int altura() {
        int a = -1;
        if (!esVacio()) {
            a = contarNiveles(this.raiz);
        }
        return a;
    }

    private int contarNiveles(NodoArbol nodo) {
        int izq = -1, der = -1, max;
        if (nodo != null) {
            izq = contarNiveles(nodo.getIzquierdo()) + 1;
            der = contarNiveles(nodo.getDerecho()) + 1;
        }
        if (izq < der) {
            max = der;
        } else {
            max = izq;
        }
        return max;
    }

    //nivel(TipoElemento):int
    public int nivel(Object buscado) {
        int niv = -1;
        if (!esVacio()) {
            niv = buscarNivel(this.raiz, buscado, 0);
        }
        return niv;
    }

    private int buscarNivel(NodoArbol n, Object b, int niv) {
        int nivEncontrado = -1;
        if (n != null) {
            NodoArbol i = n.getIzquierdo();
            NodoArbol d = n.getDerecho();
            if (n.getElem().equals(b)) {
                nivEncontrado = niv;
            } else {
                nivEncontrado = buscarNivel(i, b, niv + 1);
                if (nivEncontrado == -1) {
                    nivEncontrado = buscarNivel(d, b, niv + 1);
                }

            }
        }
        return nivEncontrado;
    }

    //vaciar()
    public void vaciar() {
        this.raiz = null;
    }

    //clone():ArbolBin
    public ArbolBin clone() {
        ArbolBin copia = new ArbolBin();
        if (!esVacio()) {
            NodoArbol aux = new NodoArbol(this.raiz.getElem(), null, null);
            copia.raiz = aux;
            cloneAux(aux, this.raiz);
        }
        return copia;
    }

    private void cloneAux(NodoArbol aux, NodoArbol nodo) {
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
                aux.setIzquierdo(new NodoArbol(nodo.getIzquierdo().getElem(), null, null));
                cloneAux(aux.getIzquierdo(), nodo.getIzquierdo());
            }
            if (nodo.getDerecho() != null) {
                aux.setDerecho(new NodoArbol(nodo.getDerecho().getElem(), null, null));
                cloneAux(aux.getDerecho(), nodo.getDerecho());
            }
        }
    }

    //toString():String
    public String toString() {
        String info = "";
        if (!esVacio()) {
            info = stringAux(this.raiz, "");
        } else {
            info = " Arbol vacio";
        }
        return info;
    }

    private String stringAux(NodoArbol n, String resultado) {
        if (n != null) {
            NodoArbol i = n.getIzquierdo();
            NodoArbol d = n.getDerecho();
            resultado += " Nodo: " + n.getElem();
            if (i != null && d != null) {
                resultado += "  Hijo Izquierdo: " + i.getElem() + " Hijo Derecho: " + d.getElem() + "\n";
            } else {
                if (i != null && d == null) {
                    resultado += "  Hijo Izquierdo: " + i.getElem() + " Hijo Derecho: -" + "\n";
                } else {
                    if (d != null && i == null) {
                        resultado += "  Hijo Izquierdo: - Hijo Derecho: " + d.getElem() + "\n";
                    } else {
                        if (i == null && d == null) {
                            resultado += "  Hijo Izquierdo: - Hijo Derecho: - \n";
                        }
                    }
                }
            }
            resultado = stringAux(n.getIzquierdo(), resultado);
            resultado = stringAux(n.getDerecho(), resultado);
        }
        return resultado;
    }

    //listarPreorden():Lista
    public Lista listarPreorden() {
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPreordenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            listarPreordenAux(nodo.getIzquierdo(), lis);
            listarPreordenAux(nodo.getDerecho(), lis);
        }
    }

    //listarPosorden():Lista
    public Lista listarPosorden() {
        Lista lis = new Lista();
        posOrdenAux(this.raiz, lis);
        return lis;
    }

    private void posOrdenAux(NodoArbol raiz, Lista lis) {
        if (raiz != null) {
            posOrdenAux(raiz.getIzquierdo(), lis);
            posOrdenAux(raiz.getDerecho(), lis);
            lis.insertar(raiz.getElem(), lis.longitud() + 1);
        }
    }

    //listarInorden():Lista
    public Lista listarInorden() {
        Lista lis = new Lista();
        inOrdenAux(this.raiz, lis);
        return lis;
    }

    private void inOrdenAux(NodoArbol raiz, Lista lis) {
        if (raiz != null) {
            inOrdenAux(raiz.getIzquierdo(), lis);
            lis.insertar(raiz.getElem(), lis.longitud() + 1);
            inOrdenAux(raiz.getDerecho(), lis);
        }
    }

    //listarPorNiveles():Lista
    public Lista listarPorNiveles() {
        Lista lis = new Lista();
        Cola q = new Cola();
        NodoArbol n;
        int i = 1;
        if (!esVacio()) {
            q.poner(this.raiz);
            while (!(q.esVacia())) {
                n = (NodoArbol) q.obtenerFrente();
                q.sacar();
                lis.insertar(n.getElem(), i);
                i++;
                if (n.getIzquierdo() != null) {
                    q.poner(n.getIzquierdo());
                }
                if (n.getDerecho() != null) {
                    q.poner(n.getDerecho());
                }
            }
        }
        return lis;
    }

    //frontera(): Lista
    public Lista frontera() {
        Lista lis = new Lista();
        fronteraAux(this.raiz, lis);
        return lis;
    }

    private void fronteraAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            NodoArbol d = nodo.getDerecho();
            NodoArbol i = nodo.getIzquierdo();
            if (d == null && i == null) {
                lis.insertar(nodo.getElem(), lis.longitud() + 1);
            } else {
                fronteraAux(i, lis);
                fronteraAux(d, lis);
            }
        }
    }
}


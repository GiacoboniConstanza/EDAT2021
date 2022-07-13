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
public class ArbolAVL {

    //raiz:NodoAVL
    private NodoAVL raiz;

    //ArbolAVL()
    public ArbolAVL() {
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

    private boolean perteneceAux(NodoAVL n, Comparable e) {
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

    //insertar(TipoElemento):boolean (se modifica por el balanceo)
    public boolean insertar(Comparable e) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoAVL(e, null, null);
        } else {
            exito = insertarAux(this.raiz, e);
            chequearBalanceo(this.raiz, null);
            this.raiz.recalcularAltura();
        }
        return exito;
    }

    private boolean insertarAux(NodoAVL n, Comparable e) {
        boolean exito = true;
        if (e.compareTo(n.getElem()) == 0) {
            exito = false;
        } else {
            if (e.compareTo(n.getElem()) < 0) {
                if (n.getIzquierdo() != null) {
                    exito = insertarAux(n.getIzquierdo(), e);
                    chequearBalanceo(n.getIzquierdo(), n);
                } else {
                    n.setIzquierdo(new NodoAVL(e, null, null));
                }
                n.recalcularAltura();
            } else {
                if (n.getDerecho() != null) {
                    exito = insertarAux(n.getDerecho(), e);
                    chequearBalanceo(n.getDerecho(), n);
                } else {
                    n.setDerecho(new NodoAVL(e, null, null));
                }
                n.recalcularAltura();
            }
        }
        return exito;
    }

    private void chequearBalanceo(NodoAVL n, NodoAVL p) {
        int balance = 0;

        if (n.getElem() != null) {
            if (n.getIzquierdo() != null && n.getClass() != null) {
                balance = n.getIzquierdo().getAltura() - n.getDerecho().getAltura();
            } else {
                if(n.getIzquierdo() != null){
                    balance = n.getIzquierdo().getAltura() - (-1);
                } else {
                    balance = -1 - n.getDerecho().getAltura();
                }
            }
            
            if (balance == 2 || balance == -2) {
                balancear(n, p, balance);
            }
        }
    }

    private void balancear(NodoAVL n, NodoAVL p, int balanceP) {

    }

    //rotacion simple a izquierda sobre pivote r
    private NodoAVL simpleIzquierda(NodoAVL r) {
        NodoAVL h = r.getDerecho();
        NodoAVL aux = h.getIzquierdo();
        h.setIzquierdo(r);
        r.setDerecho(aux);
        h.recalcularAltura();
        return h;
    }

    //rotacion simple a derecha con pivote r
    private NodoAVL simpleDerecha(NodoAVL r) {
        NodoAVL h = r.getIzquierdo();
        NodoAVL aux = h.getDerecho();
        h.setDerecho(r);
        r.setIzquierdo(aux);
        h.recalcularAltura();
        return h;
    }

    //rotacion doble derecha-izquierda
    private NodoAVL dobleDerIzq(NodoAVL r) {
        NodoAVL h;
        r.setDerecho(simpleDerecha(r.getDerecho()));
        h = simpleIzquierda(r);
        return h;
    }

    //rotacion doble izquierda-derecha
    private NodoAVL dobleIzqDer(NodoAVL r) {
        NodoAVL h;
        r.setIzquierdo(simpleIzquierda(r.getIzquierdo()));
        h = simpleDerecha(r);
        return h;
    }

    //eliminar(TipoElemento):boolean (se modifica por el balanceo)
    //listar():Lista
    public Lista listar() {
        Lista lis = new Lista();
        if (this.raiz != null) {
            listarAux(this.raiz, lis);
        }
        return lis;
    }

    private void listarAux(NodoAVL n, Lista lis) {
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

    private void listarRangoAux(NodoAVL n, Comparable min, Comparable max, Lista lis) {
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
        NodoAVL n = this.raiz;
        while (n.getIzquierdo() != null) {
            n = n.getIzquierdo();
        }
        return n.getElem();
    }

    //maximoElem():TipoElemento
    public Comparable maximoElem() {
        NodoAVL n = this.raiz;
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

    //clone():ArbolAVL
    public ArbolAVL clone() {
        ArbolAVL copia = new ArbolAVL();
        if (this.raiz != null) {
            NodoAVL aux = new NodoAVL(this.raiz.getElem(), null, null);
            copia.raiz = aux;
            cloneAux(aux, this.raiz);
        }
        return copia;
    }

    private void cloneAux(NodoAVL aux, NodoAVL nodo) {
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
                aux.setIzquierdo(new NodoAVL(nodo.getIzquierdo().getElem(), null, null));
                cloneAux(aux.getIzquierdo(), nodo.getIzquierdo());
            }
            if (nodo.getDerecho() != null) {
                aux.setDerecho(new NodoAVL(nodo.getDerecho().getElem(), null, null));
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

    private String stringAux(NodoAVL n, String res) {
        if (n != null) {
            NodoAVL i = n.getIzquierdo();
            NodoAVL d = n.getDerecho();
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
}

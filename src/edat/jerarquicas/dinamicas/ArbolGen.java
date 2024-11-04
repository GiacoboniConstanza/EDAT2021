package edat.jerarquicas.dinamicas;

import edat.lineales.dinamicas.Lista;
import edat.lineales.dinamicas.Cola;

public class ArbolGen {

    //raiz: NodoArbolGen
    private NodoGen raiz;

    //ArbolGen
    public ArbolGen() {
        this.raiz = null;
    }

    //insertar(TipoElemento, TipoElemento):boolean
    public boolean insertar(Object elemH, Object elemP) {
        boolean exito = false;
        if (this.raiz == null) {
            this.raiz = new NodoGen(elemH, null, null);
            exito = true;
        } else {
            NodoGen padre = obtenerNodo(this.raiz, elemP);
            if (padre != null) {
                NodoGen n = new NodoGen(elemH, null, padre.getHijoIzquierdo());
                padre.setHijoIzquierdo(n);
                exito = true;
            }
        }
        return exito;
    }

    private NodoGen obtenerNodo(NodoGen n, Object e) {
        NodoGen encontrado = null;
        if (n != null) {
            if (n.getElem().equals(e)) {
                encontrado = n;
            } else {
                encontrado = obtenerNodo(n.getHijoIzquierdo(), e);
                if (encontrado == null) {
                    encontrado = obtenerNodo(n.getHermanoDerecho(), e);
                }
            }
        }
        return encontrado;
    }

    //pertenece (TipoElemento):boolean
    public boolean pertenece(Object b) {
        return (obtenerNodo(this.raiz, b) != null);
    }

    //esVacio():boolean
    public boolean esVacio() {
        return this.raiz == null;
    }

    //padre(TipoElemento):TipoElemento
    public Object padre(Object elem) {
        Object p = null;
        if (this.raiz != null) {
            if (!this.raiz.getElem().equals(elem)) {
                p = padreAux(this.raiz, elem, this.raiz.getElem());
            }
        }
        return p;
    }

    private Object padreAux(NodoGen n, Object e, Object p) {
        Object r = null;
        if (n != null) {
            if (n.getElem().equals(e)) {
                r = p;
            } else {
                r = padreAux(n.getHermanoDerecho(), e, p);
                if (r == null) {
                    r = padreAux(n.getHijoIzquierdo(), e, n.getElem());
                }
            }
        }
        return r;
    }

    //altura():int
    public int altura() {
        int a = -1;
        if (this.raiz != null) {
            a = contarNiveles(this.raiz);
        }
        return a;
    }

    private int contarNiveles(NodoGen n) {
        int izq = -1, der = -1, max;
        if (n != null) {

            izq = contarNiveles(n.getHijoIzquierdo()) + 1;
            der = contarNiveles(n.getHermanoDerecho());
        }
        if (izq < der) {
            max = der;
        } else {
            max = izq;
        }
        return max;
    }

    //nivel(TipoElemento):int
    public int nivel(Object b) {
        int niv;
        niv = buscarNivel(this.raiz, b, -1);
        return niv;
    }

    private int buscarNivel(NodoGen n, Object b, int niv) {
        if (n != null) {
            if (n.getElem().equals(b)) {
                niv++;
            } else {
                niv = buscarNivel(n.getHijoIzquierdo(), b, niv);
                if (niv == -1) {
                    niv = buscarNivel(n.getHermanoDerecho(), b, niv);
                } else {
                    niv++;
                }
            }
        }
        return niv;
    }

    //ancestros(TipoElemento):Lista
    public Lista ancestros(Object e) {
        Lista lis = new Lista();
        ancestrosAux(this.raiz, lis, e);
        return lis;
    }

    private boolean ancestrosAux(NodoGen n, Lista l, Object e) {
        boolean exito = false;
        if (n != null) {
            if (n.getElem().equals(e)) {
                exito = true;
            } else {
                NodoGen h = n.getHijoIzquierdo();
                while (h != null && !exito) {
                    exito = ancestrosAux(h, l, e);
                    h = h.getHermanoDerecho();
                }
                if (exito) {
                    l.insertar(n.getElem(), l.longitud() + 1);
                }
            }
        }
        return exito;
    }

    //clone():ArbolGen
    public ArbolGen clone() {
        ArbolGen copia = new ArbolGen();
        if (this.raiz != null) {
            copia.raiz = new NodoGen(this.raiz.getElem(), null, null);
            cloneAux(this.raiz, copia.raiz);
        }
        return copia;
    }

    private void cloneAux(NodoGen n, NodoGen c) {
        NodoGen h, hCopia;
        if (n.getHijoIzquierdo() != null) {
            c.setHijoIzquierdo(new NodoGen(n.getHijoIzquierdo().getElem(), null, null));
            n = n.getHijoIzquierdo();
            c = c.getHijoIzquierdo();
            h = n.getHermanoDerecho();
            hCopia = c;
            while (h != null) {
                hCopia.setHermanoDerecho(new NodoGen(h.getElem(), null, null));
                h = h.getHermanoDerecho();
                hCopia = hCopia.getHermanoDerecho();
            }
            h = n;
            hCopia = c;
            while (h != null) {
                cloneAux(h, hCopia);
                h = h.getHermanoDerecho();
                hCopia = hCopia.getHermanoDerecho();
            }
        }
    }

    //vaciar()
    public void vaciar() {
        this.raiz = null;
    }

    //listarPreorden():Lista
    public Lista listarPreorden() {
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPreordenAux(NodoGen n, Lista l) {
        if (n != null) {
            l.insertar(n.getElem(), l.longitud() + 1);
            NodoGen h = n.getHijoIzquierdo();
            if (h != null) {
                while (h != null) {
                    listarPreordenAux(h, l);
                    h = h.getHermanoDerecho();
                }
            }
        }
    }

    //listarInOrden():Lista
    public Lista listarInorden() {
        Lista lis = new Lista();
        listarInordenAux(this.raiz, lis);
        return lis;
    }

    private void listarInordenAux(NodoGen n, Lista l) {
        if (n != null) {
            if (n.getHijoIzquierdo() != null) {
                listarInordenAux(n.getHijoIzquierdo(), l);
            }
            l.insertar(n.getElem(), l.longitud() + 1);
            if (n.getHijoIzquierdo() != null) {
                NodoGen h = n.getHijoIzquierdo().getHermanoDerecho();
                while (h != null) {
                    listarInordenAux(h, l);
                    h = h.getHermanoDerecho();
                }
            }
        }
    }

    //listarPosorden():Lista
    public Lista listarPosorden() {
        Lista lis = new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPosordenAux(NodoGen n, Lista l) {
        if (n != null) {
            NodoGen h = n.getHijoIzquierdo();
            while (h != null) {
                listarPosordenAux(h, l);
                h = h.getHermanoDerecho();
            }
            l.insertar(n.getElem(), l.longitud() + 1);
        }
    }

    //listarPorNiveles():Lista
    public Lista listarPorNiveles() {
        Lista lis = new Lista();
        Cola q = new Cola();
        NodoGen n;
        int i = 1;
        if (!(this.raiz == null)) {
            q.poner(this.raiz);
            while (!(q.esVacia())) {
                n = (NodoGen) q.obtenerFrente();
                q.sacar();
                lis.insertar(n.getElem(), i);
                i++;
                NodoGen h = n.getHijoIzquierdo();
                while (h != null) {
                    q.poner(h);
                    h = h.getHermanoDerecho();
                }

            }
        }
        return lis;
    }

    //toString():String
    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n) {
        String info = "";
        NodoGen h;
        if (n != null) {
            info += n.getElem().toString() + " -> ";
            h = n.getHijoIzquierdo();
            while (h != null) {
                info += h.getElem().toString() + " , ";
                h = h.getHermanoDerecho();
            }
            h = n.getHijoIzquierdo();
            while (h != null) {
                info += "\n" + toStringAux(h);
                h = h.getHermanoDerecho();
            }
        }
        return info;
    }

    //grado()
    public int grado() {
        int h = -1;
        if (this.raiz != null) {
            h = gradoAux(this.raiz, 0);
        }
        return h;
    }

    private int gradoAux(NodoGen n, int maximo) {
        int g = 0;
        if (n != null && n.getHijoIzquierdo() != null) {
            NodoGen h = n.getHijoIzquierdo();
            while (h != null) {
                g++;
                maximo = Math.max(g, gradoAux(h, maximo));
                h = h.getHermanoDerecho();
            }
        }
        return maximo;
    }

    //gradoSubarbol(nodo)
    public int gradoSubarbol(Object e) {
        int cantHijos = -1;
        NodoGen aux = null;
        if (this.raiz != null) {
            aux = obtenerNodo(this.raiz, e);
            if (aux != null) {
                cantHijos = gradoAux(aux, 0);
            }
        }
        return cantHijos;
    }
    
    //metodos extras del parcial
    public boolean esPadre(Object p, Object h){
        boolean esPadre = false;
        if(this.raiz !=null){
            esPadre = buscarSuPadre(this.raiz,p,h);
        }
        return esPadre;
    }

    private boolean buscarSuPadre(NodoGen n, Object p, Object h) {
        boolean encontrado = false;
        if (n != null && !encontrado) {
            if (n.getElem().equals(p)) {
                NodoGen hijo = n.getHijoIzquierdo();
                while (hijo != null && !encontrado) {
                    if (hijo.getElem().equals(h)) {
                        encontrado = true;
                    } else {
                        hijo.getHermanoDerecho();
                    }
                }
            }
        }
        if (!encontrado && n.getHijoIzquierdo() != null) {
            encontrado = buscarSuPadre(n.getHijoIzquierdo(), p, h);
        }
        if (!encontrado && n.getHermanoDerecho() != null) {
            encontrado = buscarSuPadre(n.getHermanoDerecho(), p, h);
        }
        return encontrado;
    }
}


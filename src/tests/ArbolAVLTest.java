package tests;

import edat.conjuntistas.ArbolAVL;
import edat.lineales.dinamicas.Lista;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArbolAVLTest {
    private ArbolAVL arbol;

    @Before
    public void setUp() {
        arbol = new ArbolAVL();
    }

    @Test
    public void testInsertarYBalanceoSimple() {
        // Test rotación simple a la derecha
        assertTrue(arbol.insertar(30));
        assertTrue(arbol.insertar(20));
        assertTrue(arbol.insertar(10));
        
        // Verificar estructura después de rotación
        Lista lista = arbol.listar();
        assertEquals(3, lista.longitud());
        assertEquals(20, lista.recuperar(1));
        assertEquals(10, lista.recuperar(2));
        assertEquals(30, lista.recuperar(3));
    }

    @Test
    public void testInsertarYBalanceoDoble() {
        // Test rotación doble izquierda-derecha
        assertTrue(arbol.insertar(30));
        assertTrue(arbol.insertar(10));
        assertTrue(arbol.insertar(20));
        
        // Verificar estructura después de rotación
        Lista lista = arbol.listar();
        assertEquals(3, lista.longitud());
        assertEquals(20, lista.recuperar(1));
        assertEquals(10, lista.recuperar(2));
        assertEquals(30, lista.recuperar(3));
    }

    @Test
    public void testInsertarElementosDuplicados() {
        assertTrue(arbol.insertar(10));
        assertFalse(arbol.insertar(10));  // No debería permitir duplicados
        assertEquals(1, arbol.listar().longitud());
    }

    @Test
    public void testPertenece() {
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);

        assertTrue(arbol.pertenece(50));
        assertTrue(arbol.pertenece(20));
        assertTrue(arbol.pertenece(70));
        assertFalse(arbol.pertenece(100));
        assertFalse(arbol.pertenece(25));
    }

    @Test
    public void testListarRango() {
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        Lista rango = arbol.listarRango(35, 65);
        assertEquals(3, rango.longitud());
        assertEquals(40, rango.recuperar(1));
        assertEquals(50, rango.recuperar(2));
        assertEquals(60, rango.recuperar(3));
    }

    @Test
    public void testMinMaxElem() {
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);

        assertEquals(20, arbol.minimoElem());
        assertEquals(70, arbol.maximoElem());
    }

    @Test
    public void testBalanceoComplejo() {
        // Insertar varios elementos que requieran múltiples rotaciones
        int[] valores = {50, 25, 75, 10, 30, 60, 80, 5, 15, 27, 35};
        for (int valor : valores) {
            assertTrue(arbol.insertar(valor));
        }

        // Verificar que el árbol mantiene el balance
        Lista lista = arbol.listar();
        assertEquals(11, lista.longitud());
        
        // Verificar que todos los elementos insertados pertenecen al árbol
        for (int valor : valores) {
            assertTrue(arbol.pertenece(valor));
        }
    }

    @Test
    public void testVaciarYEsVacio() {
        assertTrue(arbol.esVacio());
        
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        
        assertFalse(arbol.esVacio());
        
        arbol.vaciar();
        assertTrue(arbol.esVacio());
    }

    @Test
    public void testClone() {
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);

        ArbolAVL clon = arbol.clone();
        
        // Verificar que el clon tiene los mismos elementos
        Lista listaOriginal = arbol.listar();
        Lista listaClonada = clon.listar();
        
        assertEquals(listaOriginal.longitud(), listaClonada.longitud());
        
        for (int i = 1; i <= listaOriginal.longitud(); i++) {
            assertEquals(listaOriginal.recuperar(i), listaClonada.recuperar(i));
        }
        
        // Verificar que son independientes
        arbol.insertar(90);
        assertFalse(clon.pertenece(90));
    }
} 
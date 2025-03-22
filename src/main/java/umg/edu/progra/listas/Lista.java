package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Lista {

    private Nodo primero;

    @Override
    public String toString() {
        return "=>" + primero;
    }

    /**
     * Constructor para inicializar una lista
     */
    public Lista() {
        primero = null;
    }

    /**
     * Devuelve el nodo inicial
     *
     * @return
     */
    public Nodo leerPrimero() {
        return primero;
    }

    /**
     * Inserta valores a la lista
     *
     * @param entrada
     */
    public void insertarCabezaLista(int entrada) {
        Nodo nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;
    }

    /**
     * Inserta un elemento a partir de un nodo anterior
     *
     * @param anterior
     * @param entrada
     */
    public void insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;
    }

    /**
     * Elimina un elemento de la lista
     *
     * @param entrada
     */
    public void eliminar(int entrada) {
        Nodo actual = primero, anterior = null;

        while (actual != null && actual.dato != entrada) {
            anterior = actual;
            actual = actual.enlace;
        }

        if (actual != null) {
            if (anterior == null) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
        }
    }

    /**
     * Busca un elemento en la lista
     *
     * @param destino
     * @return Nodo encontrado o null si no existe
     */
    public Nodo buscarLista(int destino) {
        Nodo indice = primero;
        while (indice != null) {
            if (indice.dato == destino) {
                return indice;
            }
            indice = indice.enlace;
        }
        return null;
    }

    /**
     * Muestra los elementos de la lista
     */
    public void visualizar() {
        Nodo actual = primero;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.enlace;
        }
        System.out.println();
    }

    /**
     * 1 - Método para invertir la lista enlazada
     */
    public void invertir() {
        Nodo anterior = null, actual = primero, siguiente;

        while (actual != null) {
            siguiente = actual.enlace;
            actual.enlace = anterior;
            anterior = actual;
            actual = siguiente;
        }

        primero = anterior;
    }

    /**
     * 2 - Método para obtener el elemento en la posición n desde el final
     */
    public int obtenerDesdeElFinal(int n) {
        int tamaño = obtenerTamaño();
        int posicion = tamaño - n;

        if (posicion < 0) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }

        Nodo actual = primero;
        for (int i = 0; i < posicion; i++) {
            actual = actual.enlace;
        }

        return actual.dato;
    }

    /**
     * 3 - Método para eliminar duplicados en una lista enlazada
     */
    public void eliminarDuplicados() {
        Nodo actual = primero;

        while (actual != null) {
            Nodo runner = actual;
            while (runner.enlace != null) {
                if (runner.enlace.dato == actual.dato) {
                    runner.enlace = runner.enlace.enlace;
                } else {
                    runner = runner.enlace;
                }
            }
            actual = actual.enlace;
        }
    }

    /**
     * 4 - Método para obtener el tamaño de la lista enlazada
     */
    public int obtenerTamaño() {
        int tamaño = 0;
        Nodo actual = primero;

        while (actual != null) {
            tamaño++;
            actual = actual.enlace;
        }

        return tamaño;
    }

    /**
     * Método para ordenar la lista en orden ascendente (Burbuja)
     */
    public void ordenarLista() {
        if (primero == null || primero.enlace == null) {
            return;
        }

        boolean intercambiado;
        do {
            intercambiado = false;
            Nodo actual = primero;

            while (actual.enlace != null) {
                if (actual.dato > actual.enlace.dato) {
                    int temp = actual.dato;
                    actual.dato = actual.enlace.dato;
                    actual.enlace.dato = temp;
                    intercambiado = true;
                }
                actual = actual.enlace;
            }
        } while (intercambiado);
    }

    /**
     * Método para unir dos listas enlazadas
     */
    public static Lista unirListas(Lista lista1, Lista lista2) {
        Lista nuevaLista = new Lista();
        Nodo actual = lista1.primero;
        while (actual != null) {
            nuevaLista.insertarCabezaLista(actual.dato);
            actual = actual.enlace;
        }

        actual = lista2.primero;
        while (actual != null) {
            nuevaLista.insertarCabezaLista(actual.dato);
            actual = actual.enlace;
        }

        nuevaLista.ordenarLista();
        return nuevaLista;
    }

    /**
     * Método para separar números pares e impares en dos listas diferentes
     */
    public void separarParesImpares(Lista pares, Lista impares) {
        Nodo actual = primero;
        while (actual != null) {
            if (actual.dato % 2 == 0) {
                pares.insertarCabezaLista(actual.dato);
            } else {
                impares.insertarCabezaLista(actual.dato);
            }
            actual = actual.enlace;
        }
    }
}

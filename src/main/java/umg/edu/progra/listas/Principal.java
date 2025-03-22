package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {

        Lista lista = new Lista();
        lista.insertarCabezaLista(1);
        lista.insertarCabezaLista(2);
        lista.insertarCabezaLista(3);
        lista.insertarCabezaLista(4);
        lista.insertarCabezaLista(5);
        lista.insertarCabezaLista(6);
        
        System.out.println("Lista original:");
        lista.visualizar();        
        
        System.out.println("\nPrimero: " + lista.leerPrimero());
        
        lista.eliminar(3);
        System.out.println("Lista después de eliminar el 3: " + lista);
        
        Nodo dato = lista.buscarLista(4);  
        System.out.println("Dato encontrado: " + dato);
        
        lista.insertarLista(dato, 10);
        System.out.println("Lista después de insertar 10: " + lista);
        
        dato = lista.buscarLista(5);        
        System.out.println("Dato encontrado: " + dato);
        lista.insertarLista(dato, 600);
        
        System.out.println("Lista después de insertar 600: " + lista);
        
        lista.visualizar();
        
        /**
         * Resolver lo que se solicita a continuación
         * Ejercicio 1: Ordenar la lista de forma ascendente
         * Ejercicio 2: Unir dos listas enlazadas
         * Ejercicio 3: Separar números pares e impares en dos listas enlazadas diferentes
         */

        // Ejercicio 1: Ordenar la lista en orden ascendente
        lista.ordenarLista();
        System.out.println("\nLista ordenada:");
        lista.visualizar();

        // Ejercicio 2: Unir dos listas enlazadas
        Lista lista2 = new Lista();
        lista2.insertarCabezaLista(7);
        lista2.insertarCabezaLista(8);
        lista2.insertarCabezaLista(9);

        Lista listaUnida = Lista.unirListas(lista, lista2);
        System.out.println("\nLista unida:");
        listaUnida.visualizar();

        // Ejercicio 3: Separar números pares e impares en dos listas diferentes
        Lista pares = new Lista();
        Lista impares = new Lista();
        lista.separarParesImpares(pares, impares);

        System.out.println("\nLista de números pares:");
        pares.visualizar();

        System.out.println("\nLista de números impares:");
        impares.visualizar();
    }
}

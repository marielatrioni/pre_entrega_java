import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /* static significa que la variable pertenece a la clase y no a una instancia de la clase, por lo tanto se puede acceder a ella sin crear un objeto de la clase
    en este caso, la lista de artículos es compartida por todas las instancias de la clase Main y se puede acceder a ella directamente desde los métodos estáticos
    // void significa que el método no devuelve ningún valor, no devuelve nada porque solo realizan acciones como crear, listar, modificar o eliminar artículos
    // public significa que el método es accesible desde cualquier parte del programa, por eso los métodos son públicos para que puedan ser llamados desde el método main
    // static void main es el punto de entrada del programa, es el primer método que se ejecuta cuando se inicia el programa
    // en este caso, el método main es estático porque no se necesita crear un objeto de la clase Main para ejecutarlo */
    // atributos de la clase porque tienen la palabra reservada static
    static ArrayList<Articulo> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


   // INICIO metodo que se ejecuta al iniciar el programa
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- Menú de Artículos ---");
            System.out.println("1. Cargar un nuevo artículo");
            System.out.println("2. Ver Listado de Artículos cargados");
            System.out.println("3. Modificar un Artículo");
            System.out.println("4. Eliminar un Artículo");
            System.out.println("5. Salir del Sistema");
            System.out.print("Por favor seleccione un número de opción para continuar: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> crear_articulo();
                case 2 -> listar_articulos();
                case 3 -> modificar_articulo();
                case 4 -> eliminar_articulo();
                case 5 -> System.out.println("Saliendo del Sistema...");
                default -> System.out.println("Opción inválida, vuelva a intertarlo");
            }
        } while (opcion != 5);
    } // FIN del metodo que se ejecuta al iniciar el programa
    
    // INICIO método que crea un artículo con validaciones
    public static void crear_articulo() {
    int id;
    while (true) {
        System.out.print("ID: ");
        id = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea
        boolean idExistente = false;
        for (Articulo art : lista) {
            if (art.getId() == id) {
                idExistente = true;
                break;
            }
        }
        if (idExistente) {
            System.out.println("El ID ya existe. Por favor, ingrese otro ID.");
        } else {
            break;
        }
    }

    String nombre;
    while (true) {
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío. Por favor, ingrese un nombre válido.");
        } else {
            break;
        }
    }

    double precio;
    while (true) {
        System.out.print("Precio: ");
        precio = sc.nextDouble();
        sc.nextLine(); // Consumir el salto de línea
        if (precio <= 0) {
            System.out.println("El precio debe ser mayor a 0. Por favor, ingrese un precio válido.");
        } else {
            break;
        }
    }

    Articulo nuevo = new Articulo(id, nombre, precio);
    lista.add(nuevo);
    System.out.println("Artículo agregado.");
    } // FIN del método que crea un artículo con validaciones

    // INICIO método que lista los articulo llamando al "MOSTRAR" de Articulo.java
    public static void listar_articulos() {
        if (lista.isEmpty()) {
            System.out.println("No hay artículos cargados.");
        } else {
            for (Articulo articulo : lista) {
                articulo.mostrar();
            }
        }
    }// FIN del método que lista artículos

    // public = puedo acceder desde cualquier parte del programa
    // static = no necesito crear un objeto de la clase para acceder al método

    // INICIO método que modifica un artículo
    public static void modificar_articulo() {
        System.out.print("ID del artículo a modificar: ");
        int id = sc.nextInt();
        for (Articulo a : lista) {
            if (a.id == id) {
                sc.nextLine();
                System.out.print("Nuevo nombre: ");
                a.nombre = sc.nextLine();
                System.out.print("Nuevo precio: ");
                a.precio = sc.nextDouble();
                System.out.println("Artículo actualizado.");
                return;
            }
        }
        System.out.println("Artículo no encontrado.");
    } // FIN del método que modifica un artículo

    // INICIO método que elimina un artículo
    public static void eliminar_articulo() {
        System.out.print("ID del artículo a eliminar: ");
        int idAEliminar = sc.nextInt();
       // funcion flecha o lambda, estructura de la funcion
       // parametros -> cuerpo
        // PARA LA PRE ENTREGA QUE MUESTRE UN MSJ DE ARTICULO NO ENCONTRADO SI NO LOGRA ELIMINAR NINGUN ARTICULO
        lista.removeIf(articuloLista -> articuloLista.id == idAEliminar);
        System.out.println("Artículo eliminado si existía.");
    } // FIN del método que modifica un artículo

    
    // METHOD QUE CONSULTE UN ARTICULO POR SU ID 
    // close para cerrar el scanner
    // sc.close();
    // no es necesario cerrar el scanner en este caso porque el programa termina
}
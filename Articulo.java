// plantilla de un artículo
public class Articulo {
    // primero van los atributos del artículo, o del objeto
    int id;
    String nombre;
    double precio;

    // constructor de la clase Articulo
    // se utiliza para crear un objeto de la clase Articulo
    // el constructor tiene el mismo nombre que la clase
    public Articulo(int id_parametro, String nombre_parametro, double precio_parametro) {
        // LA PALABRA RESERVADA this alude al objeto actual de la clase que se esta llamando
        // que se esta creando
        // el objeto cuando se crea en memoria, se le asigna una dirección de memoria
        this.id = id_parametro;
        this.nombre = nombre_parametro;
        this.precio = precio_parametro;
    }

    // Getter para el atributo id (solo lectura)
    // public: se puede acceder desde cualquier parte del programa
    //int es el tipo de dato que devuelve el método

    public int getId() {
        return id; // retorna el id del articulo desde donde es llamado este method
    }

    public String getNombre() {
    return nombre;
    }

    public double getPrecio() {
    return precio;
    }

    void mostrar() {
        System.out.println("ID: " + this.id + " | Nombre: " + this.nombre + " | Precio: $" + this.precio);
    }
}
import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private ArrayList<Articulo> articulos;
    private ArrayList<Integer> cantidades;

    public Pedido(int idPedido) {
        this.idPedido = idPedido;
        this.articulos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
    }

    public void agregarArticulo(Articulo articulo, int cantidad) {
        articulos.add(articulo);
        cantidades.add(cantidad);
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < articulos.size(); i++) {
            total += articulos.get(i).getPrecio() * cantidades.get(i);
        }
        return total;
    }

    public void mostrarPedido() {
        System.out.println("Pedido ID: " + idPedido);
        for (int i = 0; i < articulos.size(); i++) {
            Articulo art = articulos.get(i);
            int cantidad = cantidades.get(i);
            System.out.println("- " + art.getNombre() + " | Precio: $" + art.getPrecio() + " | Cantidad: " + cantidad + " | Subtotal: $" + (art.getPrecio() * cantidad));
        }
        System.out.println("TOTAL: $" + calcularTotal());
    }
}

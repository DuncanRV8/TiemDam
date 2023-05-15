import java.util.ArrayList;

public class Pedido {
    
    //Atributos
    private static int contador = 0;
    private String nombre;
    private double porcentajedesc;
    private double subtotal, preciofinal;
    private static ArrayList<Articulo> carrito = new ArrayList<>();

    //Setter y Getter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setPorcentajedesc(double porcentajedesc) {
        this.porcentajedesc = porcentajedesc;
    }
    public double getPorcentajedesc() {
        return porcentajedesc;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public void setPreciofinal(double preciofinal) {
        this.preciofinal = preciofinal;
    }
    public double getPreciofinal() {
        return preciofinal;
    }

    //metodos
    // ver el carrito
    public static void verCarrito(){
        for (int i = 0; i < carrito.size(); i++) {
            System.out.print(i + ". ");
            carrito.get(i).imprimir();
        }
    }
    
    //añadir al carrito
    public static boolean añadirCarro(int pos, int cantidad){
        boolean comprobar = true;
        if (pos >= 0) {
            carrito.add(Almacen.almacen.get(pos));
            carrito.get(contador).setCantidad(cantidad);
            System.out.println("Se ha añadido al carrito");
            contador++;
            comprobar = true;
            return true;
        }
        else{
            System.out.println("No se ha podido añadir al carrito");
            comprobar = false;
            return comprobar;
        }
    }
    //eliminar del carrito
    public static boolean eliminardelCarro(int pos){
        if (pos >= 0) {
            carrito.remove(pos);
            System.out.println("Se ha eliminado");
            contador--;
            return true;
        }
        else{
            System.out.println("No se ha podido eliminar");
            return false;
        }
    }

    //modificar carrito
    public static boolean modificarcarro(int pos, int cantidad){
        
        
        return true;
    }
    //aplicar descuento
    public static boolean aplicarDesc(int pos, int desc){
        if (desc > 0 ) {
            int cantidad = carrito.get(pos).getCantidad();
            double precio = carrito.get(pos).getPrecio();
            double sindesc = precio * cantidad;
            double condesc = sindesc - (desc);
            double loquedesc = sindesc - condesc;
            System.out.println("Sin descuento: " + sindesc);
            System.out.println("Lo que descontamos: " + loquedesc);
            System.out.println("El total del descuento se queda como: " + condesc);
            return true;
        }
        else{
            System.out.println("No se ha podido hacer el descuento");
            return false;
        }
    }  
}

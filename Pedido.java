import java.util.ArrayList;

public class Pedido {
    
    //Atributos
    private String nombre;
    private double porcentajedesc;
    private double subtotal, preciofinal;
    private ArrayList<Articulo> carrito = new ArrayList<>();

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
    public void verCarrito(){
        for (int i = 0; i < carrito.size(); i++) {
            System.out.println("Articulo " + (i+1));
            carrito.get(i).imprimir();
        }
    }
    
    //añadir al carrito
    public boolean agregarCarro(Articulo articulo){
        if (carrito.add(articulo) && articulo.getCantidad() > 0) {
            System.out.println("Se añadido al carrito");
            return true;
        }
        else{
            System.out.println("No se ha podido añadir");
            return false;
        }
    }

    //eliminar del carrito
    public boolean eliminardelCarro(int pos){
        if (pos >= 0) {
            carrito.remove(pos);
            System.out.println("Se ha eliminado");
            return true;
        }
        else{
            System.out.println("No se ha podido eliminar");
            return false;
        }
    }

    //modificar carrito
    public boolean modificarcarro(int pos, int cantidad){
        if (cantidad > 0) {
            try {
                carrito.get(pos).setCantidad(cantidad);
            } catch (Exception e) {
                    System.out.println("No se ha añadido");
            }
            System.out.println("Se ha modificado");
            return true;
        }
        else{
            System.out.println("ERROR: no puedes modificar artículos que no están");
            return false;
        }
    }

    //calcular precio
    public void calcularSubtotal(){
        double todoSubTotal = 0;
        for (int i = 0; i < carrito.size(); i++) {
           double subtotal = carrito.get(i).getPrecio() * carrito.get(i).getCantidad();
           System.out.println("Nombre: " + carrito.get(i).getNombre() + "Precio: " + subtotal);
           todoSubTotal += subtotal;
        }
        System.out.println("Todo en total es: " + todoSubTotal);
    }
    //aplicar descuento
    public boolean aplicarDesc(int pos, int desc){
        if (desc > 0 ) {
           carrito.get(pos);
           return true;
        }
        else{
            System.out.println("No se ha podido hacer el descuento");
            return false;
        }
    }
    
    //imprimir informacion
    public void imprimirPedido(){
        System.out.println("");
    }
}

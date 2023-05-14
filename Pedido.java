import java.util.ArrayList;

public class Pedido {
    
    //Atributos
    private String nombre;
    private double porcentajedesc;
    private double subtotal, preciofinal;
    ArrayList<Articulo> carrito = new ArrayList<>();

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
}

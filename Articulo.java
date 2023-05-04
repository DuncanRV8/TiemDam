public class Articulo {

    //atributos
    private String nombre;
    private double precio;
    final private double iva = 21;
    private int cantidad;


    //constructor
    public Articulo(String nombre, double precio, int cantidad){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //Setter/Getter
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getCantidad() {
        return cantidad;
    }
    
    //Metodos
    public void aumentar(int cant){
        System.out.println("Se ha sumado la cantidad");
        this.cantidad =+ cant;
    }

    public void disminuir(int cant){
        if (cant > cantidad) {
            System.out.println("Error no se puede quitar tanta cantidad");
        }
        else{
            System.out.println("Se ha restado la cantidad");
            cantidad =- cant;
        }
    }



}

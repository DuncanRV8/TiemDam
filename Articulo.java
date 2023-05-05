public class Articulo {


    //enum
    public enum IVA{
        Normal,Reducido,SuperReducido;

    }

    //atributos
    private String nombre;
    private double precio;
    private IVA iva; 
    private int cantidad;


    //constructor
    public Articulo(String nombre, IVA iva, double precio, int cantidad){
        this.nombre = nombre;
        this.iva = iva;
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

    public boolean disminuir(int cant){
        if (cant > cantidad) {
            System.out.println("Error no se puede quitar tanta cantidad");
            return false;
        }
        else{
            System.out.println("Se ha restado la cantidad");
            cantidad =- cant;
            return true;
        }
    }

    public void imprimir(){
      System.out.println(nombre + " " + precio + " " + cantidad + " " + iva  );
    }
}

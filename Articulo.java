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
    public Articulo() {
        
    }
    public Articulo(String nombre, IVA iva, double precio, int cantidad){
        setNombre(nombre);
        setIva(iva);
        setPrecio(precio);
        setCantidad(cantidad);
    }

    //Setter/Getter
    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        }
        else{
            System.out.println("No puedes introducir numeros negativos o 0");
        }
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setIva(IVA iva) {
        this.iva = iva;
    }
    public IVA getIva() {
        return iva;
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
        System.out.println("Nombre: "  + nombre + " Precio: " + precio + " Cantidad: " + cantidad + " Iva: " + iva );
        System.out.println(" ");
    }
}

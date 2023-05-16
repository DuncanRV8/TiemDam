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
    public Articulo(String nombre,  double precio, int cantidad, IVA iva){
        setNombre(nombre);
        setIva(iva);
        try {
            setPrecio(precio);
            setCantidad(cantidad);
        } catch (Exception e) {
            System.err.println("No se puede crear5");
        }
        
        
    }

    //Setter/Getter
    public void setPrecio(double precio) throws Exception{
        if (precio > 0) {
            this.precio = precio;
        }
        else{
            throw new Exception("No puedes introducir numeros negativos o 0");
        }
    }
    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) throws Exception {
        if (cantidad > 0) {
            this.cantidad = cantidad;
        }
        else{
            throw new Exception("No puedes introducir numeros negativos o 0");
        }
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
      if (cant != 0) {
        System.out.println("Se ha sumado la cantidad");
        this.cantidad += cant;
      }
      else{
        System.out.println("ERROR no se ha podido añadir");
      }
    }

    public boolean disminuir(int cant){
        if (cant > cantidad) {
            System.out.println("Error no se puede quitar tanta cantidad");
            return false;
        }
        else{
            System.out.println("Se ha restado la cantidad");
            cantidad -= cant;
            return true;
        }
    }

    public void imprimir(){
        System.out.println("Nombre: "  + nombre + " Precio: " + precio + " Cantidad: " + cantidad + " Iva: " + iva );
        System.out.println(" ");
    }
}

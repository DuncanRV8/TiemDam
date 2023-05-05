public class Almacen {

    //atributos
    Articulo[] articulos;
    private int maxArticulos;
    private int indice = 0;

    //constructor
    public Almacen(int maxArticulos) {
        this.maxArticulos = maxArticulos;
    }

   public boolean añadirArticulo(String nombre, Articulo.IVA iva, double precio, int cantidad){
        Articulo articulo = new Articulo(nombre,iva, precio, cantidad); 
        if (indice > maxArticulos) {
            System.out.println("No hay mas espacio");
            return false;
        }
        
        else{
            articulos[indice] = articulo;
            System.out.println("Se ha sumado un articulo a tu carrito");
            indice++;
            return true;
        }
    }

    public boolean eliminarArticulo(int eliminar){
        if (eliminar <= 0 && eliminar > indice) {
            System.out.println("ERROR");
            return false;
        }
        else{
            articulos[eliminar] = null;
            for (int i = eliminar+1; i < indice; i++) {
                articulos[eliminar] = articulos[i];
                eliminar++;
            }
            indice--;
            System.out.println("Se ha eliminado el articulo del carrito");
            return true;
        }
    }

    public boolean modificarArticulo(int modificar, int cantidad, double precio){
        if (modificar < 0 && modificar > indice) {
            System.out.println("Error");
            return false;
        }
        else{
            articulos[modificar].setCantidad(cantidad);
            articulos[modificar].setPrecio(precio);
            System.out.println("Se ha modificado el articulo");
            return true;
        }
    }

    public boolean buscarArticulo(){
        return true;
    }
}

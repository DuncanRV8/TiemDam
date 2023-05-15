import java.util.ArrayList;

public class Almacen {
    //Atributos
    public static ArrayList<Articulo> almacen = new ArrayList<>();
    
    //articulos creados ya en el almacen
    public static void articulosEnAlmacen(){
        for (int i = 0; i < almacen.size(); i++) {
            System.out.print(i + ". ");
            almacen.get(i).imprimir();
        }
    }

    //Iniciar con algunos ya
    public static void iniciar(){
        //articulo1
        Articulo articulo1 = new Articulo("tomate", Articulo.IVA.Normal, 20, 12);
        almacen.add(articulo1);
        //articulo2
        Articulo articulo2 = new Articulo("manzana", Articulo.IVA.Reducido, 5, 20);
        almacen.add(articulo2);
        //articulo3
        Articulo articulo3 = new Articulo("pizza", Articulo.IVA.SuperReducido, 12, 5);
        almacen.add(articulo3);
    }

    //añadir articulo
    public static boolean añadirArticulo(String nombre, double precio, int cantidad){
        boolean comprobar = true;
        if (precio > 0) {
            Articulo nuevoart = new Articulo();
            nuevoart.setNombre(nombre);
            nuevoart.setPrecio(precio);
            nuevoart.setCantidad(cantidad);
            almacen.add(nuevoart);
            System.out.println("Se ha creado el objeto");
            comprobar = true;
            return comprobar;
        }else{
            System.out.println("No se ha podido añadir tu articulo");
            comprobar = false;
            return comprobar; 
        }
    }

    //Eliminar articulo
    public static boolean eliminarArticulo(int pos){
        almacen.remove(pos);
        System.out.println("Se ha eliminado el artículo");
        return true;
    }
    //Modificar articulo
    public static boolean modificarArticulo(String nombre, double precio, int cantidad, int pos){
        almacen.get(pos).setNombre(nombre);
        almacen.get(pos).setPrecio(precio);
        almacen.get(pos).setCantidad(cantidad);
        return true;
    }

    //Buscar articulo
    public static void buscarArticulo(String nombre){
        boolean comprobar = true;
        for (int i = 0; i < almacen.size(); i++) {
            if (almacen.get(i).getNombre().contains(nombre)) {
                
                System.out.println("Aquí tienes todos los articulos con ese nombre: ");
                almacen.get(i).imprimir();
                comprobar = true;
            } 
            else{
                comprobar = false;
            }
        }
        if (comprobar == false ) {
            System.out.println("No se ha encontrado el nombre;");
        }
    }

    //Recibir Articulo
    public static void recibirArticulo(int pos, int cantidad){
        int tmp = almacen.get(pos).getCantidad();
        tmp = tmp + cantidad;
        almacen.get(pos).setCantidad(tmp);
    }

    //devolver Articulo
    public static void devolverArticulo(int pos , int cantidad){
        int tmp = almacen.get(pos).getCantidad();
        if (cantidad > tmp) {
           System.out.print("No se ha podido descontar"); 
        }
        else{
            System.out.println("Se ha podido eliminar la cantidad");
            tmp = tmp - cantidad;
            almacen.get(pos).setCantidad(tmp);
        }
    }

    //Constructores
    public Almacen() {

    }



}
 

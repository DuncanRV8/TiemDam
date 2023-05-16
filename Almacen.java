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
    public static boolean agregarArticulo(String nombre, double precio,int cantidad, int eleccion){
        boolean comprobar = true;
        if (precio > 0 && cantidad > 0) {
            Articulo nuevoart = new Articulo();
            nuevoart.setNombre(nombre);
            nuevoart.setPrecio(precio);
            nuevoart.setCantidad(cantidad);
            switch (eleccion) {
                case 1:
                    nuevoart.setIva(Articulo.IVA.Normal);
                break;
                case 2:
                    nuevoart.setIva(Articulo.IVA.Reducido);
                break;
                case 3:
                    nuevoart.setIva(Articulo.IVA.SuperReducido); 
                break;
            }
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
        if (pos >= 0 && pos <= almacen.size()) {
            almacen.remove(pos);
            System.out.println("Se ha eliminado el artículo");
            return true;
        }
        else{
            System.out.println("ERROR: No puedes poner numeros negativos o no hay tantos articulos");
            System.out.println(" ");
            return false;
        }
       
    }
    //Modificar articulo
    public static boolean modificarArticulo(String nombre, double precio, int cantidad, int pos){
        if (precio > 0 && cantidad > 0) {
            almacen.get(pos).setNombre(nombre);
            almacen.get(pos).setPrecio(precio);
            almacen.get(pos).setCantidad(cantidad);
            System.out.println("Se ha modificado");
            return true;
        }
        else{
            System.out.println("ERROR: No puedes poner numeros negativos o no hay tantos articulos");
            return false;
        }
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
    public static boolean recibirArticulo(int pos, int cantidad){
        if (cantidad > 0) {
            almacen.get(pos).aumentar(cantidad);
            System.out.println("Se ha aumentado la cantidad");
            return true;
        }
        else{
            System.out.println("No se ha podido aumentar porque es negativo o 0");
            return false;
        }
        
    }

    //devolver Articulo
    public static boolean devolverArticulo(int pos , int cantidad){
        int tmp = almacen.get(pos).getCantidad();
        if (cantidad > tmp) {
           System.out.print("No se ha podido descontar"); 
           return false;
        }
        else{
            System.out.println("Se ha podido eliminar la cantidad");
            tmp = tmp - cantidad;
            almacen.get(pos).setCantidad(tmp);
            return true;
        }
    }

    //Constructores
    public Almacen() {

    }
}
 

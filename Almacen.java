import java.util.ArrayList;
public class Almacen {
    //Atributos
    public ArrayList<Articulo> articulos = new ArrayList<>();
    
    //articulos creados ya en el articulos
    public void articulosEnAlmacen(){
        for (int i = 0; i < articulos.size(); i++) {
            System.out.println("Articulo " + (i+1));
            articulos.get(i).imprimir();
        }
    }

    //Iniciar con algunos ya
    public void iniciar(){
        //articulo1
        Articulo articulo1 = new Articulo("tomate",  20, 12, Articulo.IVA.Normal);
        articulos.add(articulo1);
        //articulo2
        Articulo articulo2 = new Articulo("manzana", 5, 20, Articulo.IVA.Reducido);
        articulos.add(articulo2);
        //articulo3
        Articulo articulo3 = new Articulo("pizza", 12, 5, Articulo.IVA.SuperReducido);
        articulos.add(articulo3);
    }

    //añadir articulo
    public boolean agregarArticulo(String nombre, double precio,int cantidad, int eleccion){
        boolean comprobar = true;
        if (precio > 0 && cantidad > 0 && eleccion >=1 && eleccion <= 3) {
            Articulo nuevoArticulo = new Articulo();
            nuevoArticulo.setNombre(nombre);
            nuevoArticulo.setPrecio(precio);
            nuevoArticulo.setCantidad(cantidad);
            switch (eleccion) {
                case 1:
                    nuevoArticulo.setIva(Articulo.IVA.Normal);
                break;
                case 2:
                    nuevoArticulo.setIva(Articulo.IVA.Reducido);
                break;
                case 3:
                    nuevoArticulo.setIva(Articulo.IVA.SuperReducido); 
                break;
            }
            articulos.add(nuevoArticulo);
            System.out.println("Se ha creado el objeto");
            System.out.println(" ");
            comprobar = true;
            return comprobar;
        }
        else{
            System.out.println("No se ha podido añadir tu articulo");
            System.out.println(" ");
            comprobar = false;
            return comprobar; 
        }
    }

    //Eliminar articulo
    public boolean eliminarArticulo(int pos){
        if (pos >= 0 && pos <= articulos.size()) {
            articulos.remove(pos);
            System.out.println("Se ha eliminado el artículo");
            return true;
        }
        else{
            System.out.println("ERROR: No puedes eliminar articulos que no estan");
            System.out.println(" ");
            return false;
        }
       
    }
    //Modificar articulo
    public boolean modificarArticulo(String nombre, double precio, int cantidad, int pos){
        if (precio > 0 && cantidad > 0) {
            articulos.get(pos).setNombre(nombre);
            articulos.get(pos).setPrecio(precio);
            articulos.get(pos).setCantidad(cantidad);
            System.out.println("Se ha modificado");
            return true;
        }
        else{
            System.out.println("ERROR: No puedes modificar articulos que no estan");
            return false;
        }
    }

    //Buscar articulo
    public void buscarArticulo(String nombre){
        boolean comprobar = true;
        for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).getNombre().contains(nombre)) {
                System.out.println("Aquí tienes todos los articulos con ese nombre: ");
                articulos.get(i).imprimir();
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
    public boolean recibirArticulo(int pos, int cantidad){
        if (cantidad > 0) {
            articulos.get(pos).aumentar(cantidad);
            System.out.println("Se ha aumentado la cantidad");
            return true;
        }
        else{
            System.out.println("No se ha podido aumentar porque es negativo o 0");
            return false;
        }
        
    }

    //devolver Articulo
    public boolean devolverArticulo(int pos , int cantidad){
        int tmp = articulos.get(pos).getCantidad();
        if (cantidad > tmp) {
           System.out.print("No se ha podido descontar"); 
           return false;
        }
        else{
            System.out.println("Se ha podido eliminar la cantidad");
            tmp = tmp - cantidad;
            articulos.get(pos).setCantidad(tmp);
            return true;
        }
    }

    //Constructores
    public Almacen() {

    }
}
 

import java.util.Scanner;
public class TienDam {

    //Variables
    private static final Scanner lector = new Scanner(System.in);
    public static Almacen almacen = new Almacen();


    //menu Principal
    public static void menuPricipal(){
        System.out.println("1. Almacen");
        System.out.println("2. Pedido");
        System.out.println("3. Salir");
    }

   //Menu Almacen
   public static void menuAlmacen(){
    System.out.println("1. Ver articulos");
    System.out.println("2. Buscar articulos");
    System.out.println("3. Añadir articulos");
    System.out.println("4. Eliminar articulo");
    System.out.println("5. Modificar articulo");
    System.out.println("6. Recibir articulos");
    System.out.println("7. Devolver articulos");
    System.out.println("8. Volver al menu principal");
    System.out.println("9. Salir");
   }  

   public static void menuPedido(){
    System.out.println("1. Comprar articulos");
    System.out.println("2. Añadir articulo");
    System.out.println("3. Quitar articulo");
    System.out.println("4. Modificar articulo");
    System.out.println("5. Aplicar descuento");
    System.out.println("6. Mostrar ticket");
    System.out.println("7. Volver al menu principal");
    System.out.println("8. Salir");
   }
//********************************************************************************

//Switch del menu principal
public static void elegirMenu(int eleccion){
    switch (eleccion) {
        //Menu de Almacen
        case 1:
           almacenn();
        break;

        //Menu de Pedido
        case 2:
            pedido();
        break;

        //Salir
        case 3:
            System.exit(0);
        break;
    
        default:
            System.out.println("No se puede elegir esa opción");
    }
}

//Switch del menu de almacen
public static void elegirAlmacen(int eleccion){
    switch (eleccion) {
        case 1:
            Almacen.articulosEnAlmacen();
        break;

        case 2:
            buscarArticulo();
        break;

        case 3:
            añadirArticulo();
        break;

        case 4:
            eliminarArticulo();
        break;

        case 5:
            modificarArticulo();
        break;

        case 6:
            recibirArticulo();
        break;

        case 7:
            devolverArticulo();
        break;

        case 8:
            menu();
        break;

        case 9:
            System.exit(0);
        break;
    
        default:
        System.out.println("No se puede elegir esa opción");
    }
}

//Switch del menu de pedido
public static void elegirPedido(int eleccion){
    switch (eleccion) {
        case 1:
            
        break;

        case 2:

        break;

        case 3:

        break;

        case 4:

        break;

        case 5:

        break;

        case 6:

        break;

        case 7:
            menu();
        break;

        case 8:
            System.exit(0);
        break;
    
        default:
            System.out.println("No se puede elegir esa opción");
    }
}

//********************************************************************************
//Bucle Menu principal
public static void menu(){
    while (true) {
        Almacen.iniciar();
        menuPricipal();
        elegirMenu(lector.nextInt());
    }
}

//Bucle de Almacen
public static void almacenn(){
    while (true) {
        menuAlmacen();
        elegirAlmacen(lector.nextInt());
    }
}

//Bucle de Pedido
public static void pedido(){
    while (true) {
        menuPedido();
        elegirPedido(lector.nextInt());
    }
}



//********************************************************************************
//ALMACEN
//Añadir articulo al almacen
public static void añadirArticulo(){
    System.out.print("Dime el nombre del articulo: ");
    String nombre = lector.next();
    System.out.print("Dime el precio: ");
    double precio = lector.nextDouble();
    System.out.print("Dime la cantidad: ");
    int cantidad = lector.nextInt();

    almacen.añadirArticulo(nombre,precio,cantidad);
}
//Eliminar articulo del almacen
public static void eliminarArticulo(){
    Almacen.articulosEnAlmacen();
    System.out.print("Dime la posición: " );
    int pos = lector.nextInt();
    almacen.eliminarArticulo(pos);
}
//Modificar articulo del almacen
public static void modificarArticulo(){
    Almacen.articulosEnAlmacen();
    System.out.print("Dime la posición en la que esta: ");
    int pos = lector.nextInt();
    System.out.print("Dime el nuevo nombre: ");
    String nombre = lector.next();
    System.out.print("Dime el nuevo precio: ");
    double precio = lector.nextDouble();
    System.out.print("Dime la cantidad: ");
    int cantidad = lector.nextInt();
    almacen.modificarArticulo(nombre, precio, cantidad, pos);
}

//Buscar articulo del almacen
public static void buscarArticulo(){
    Almacen.articulosEnAlmacen();
    System.out.print("Dime el nombre del articulo: ");
    String nombre = lector.next();
    almacen.buscarArticulo(nombre);
}

//Recibir articulo
public static void recibirArticulo(){
    Almacen.articulosEnAlmacen();
    System.out.print("Dime la posicion en la que se encuentra: ");
    int pos = lector.nextInt();
    System.out.print("Cuanta cantidad quieres añadir? ");
    int cantidad = lector.nextInt();
    almacen.recibirArticulo(pos, cantidad);
}

//Devolver Articulo
public static void devolverArticulo(){
    Almacen.articulosEnAlmacen();
    System.out.print("Dime la posicion en la que se encuentra: ");
    int pos = lector.nextInt();
    System.out.print("Cuanta cantidad quieres quitar? ");
    int cantidad = lector.nextInt();
    almacen.devolverArticulo(pos, cantidad);
}
//********************************************************************************
//PEDIDO


//********************************************************************************





    public static void main(String[] args) {
        menu();
    }
}

import java.net.SocketTimeoutException;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;
public class TienDam {

    //Variables
    private static final Scanner lector = new Scanner(System.in);
    public static Almacen almacen = new Almacen();


    //menu Principal
    public static void menuPricipal(){
        System.out.println("1. Almacen");
        System.out.println("2. Pedido");
        System.out.println("3. Salir");
        System.out.println(" ");
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
    System.out.println(" ");
   }  

   public static void menuPedido(){
    System.out.println("1. Comprar articulos");
    System.out.println("2. Añadir articulo");
    System.out.println("3. Quitar articulo");
    System.out.println("4. Modificar articulo");
    System.out.println("5. Aplicar descuento");
    System.out.println("6. Mostrar carro");
    System.out.println("7. Volver al menu principal");
    System.out.println("8. Salir");
    System.out.println(" ");
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
            System.out.println(" ");
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
            agregarArticulo();
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
        System.out.println(" ");
    }
}

//Switch del menu de pedido
public static void elegirPedido(int eleccion){
    switch (eleccion) {
        case 1:
            
        break;

        case 2:
            agregarCarro();
        break;

        case 3:
            eliminarDelCarro();
        break;

        case 4:
            modificarCarro();
        break;

        case 5:
            aplicarDesc();
        break;

        case 6:
            Pedido.verCarrito();
        break;

        case 7:
            menu();
        break;

        case 8:
            System.exit(0);
        break;
    
        default:
            System.out.println("No se puede elegir esa opción");
            System.out.println(" ");
    }
}

//********************************************************************************
//Bucle Menu principal
public static void menu(){
    while (true) {
        Almacen.iniciar();
        menuPricipal();
        int opcion = 0;
        try {
           opcion = pedirInt("Elige una opción: ");
        } catch (Exception e) {
            System.out.println("valor introducido incorrecto");
            System.out.println(" ");
            lector.nextLine();
        }
        elegirMenu(opcion);
    }
}

//Bucle de Almacen
public static void almacenn(){
    while (true) {
        menuAlmacen();
        int opcion = 0;
        try {
            opcion = pedirInt("Elige una opcion: ");
        } catch (Exception e) {
            System.out.println("Valor introducido incorrecto");
            System.out.println(" ");
            lector.nextLine();
        }
        elegirAlmacen(opcion);
    }
}

//Bucle de Pedido
public static void pedido(){
    while (true) {
        menuPedido();
        int opcion = 0;
        try {
            opcion = pedirInt("Elige una opcion: ");
        } catch (Exception e) {
            System.out.println("Valor introducido incorrecto");
            System.out.println(" ");
            lector.nextLine();
        }
        elegirPedido(opcion);
    }
}
//********************************************************************************
//Método pedir int
public static int pedirInt(String mensaje){
    System.out.print(mensaje);
    int eleccion = lector.nextInt();
    return eleccion;
    
}

//Método pedir double
public static double pedirDouble(String mensaje){
    System.out.print(mensaje);
    double eleccion = lector.nextDouble();
    return eleccion;
}
//********************************************************************************
//ALMACEN
//Añadir articulo al almacen
public static void agregarArticulo(){
    double precio = 0;
    int cantidad = 0;
    int elegir = 0;
    System.out.print("Dime el nombre del articulo: ");
    String nombre = lector.next();
    try {
        precio = pedirDouble("Dime el precio: ");
        cantidad = pedirInt("Dime la cantidad: ");
        elegir = pedirInt("Dime el tipo de iva: 1.Normal 2.Reducida 3.Superreducida");
    } catch (Exception e) {
        System.out.println("Valor introducido incorrecto");
        lector.nextLine();
    }
    almacen.agregarArticulo(nombre,precio,cantidad,elegir);
}
//Eliminar articulo del almacen
public static void eliminarArticulo(){
    Almacen.articulosEnAlmacen();
    int pos = 0;
    try {
        pos = pedirInt("Dime la posición: ");
    } catch (Exception e) {
        System.out.println("Valor introducido incorrecto");
    }
    almacen.eliminarArticulo(pos);
}
//Modificar articulo del almacen
public static void modificarArticulo(){
    Almacen.articulosEnAlmacen();
    int pos = 0;
    double precio = 0;
    int cantidad = 0;
    String nombre = null;
    try {
        pos = pedirInt("Dime la posición: ");
        System.out.print("Dime el nuevo nombre: ");
        nombre = lector.next();
        precio = pedirInt("Dime el precio: ");
        cantidad = pedirInt("Dime la cantidad: ");
    } catch (Exception e) {
        System.out.println("Valor introducido incorrecto");
    }
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

//añadir al carro
public static void agregarCarro(){
    Almacen.articulosEnAlmacen();
    System.out.print("Dime en que posicion se encuentra: ");
    int pos = lector.nextInt();
    System.out.print("Dime cuanta cantidad quieres: ");
    int cantidad = lector.nextInt();
    Pedido.agregarCarro(pos, cantidad);
}

//eliminar del carrito
public static void eliminarDelCarro(){
    System.out.println("Dime en la posicion que está: ");
    int pos = lector.nextInt();
    Pedido.eliminardelCarro(pos);
}

//modificar carro
public static void modificarCarro(){
    System.out.print("Dime que posicion quieres modificar: ");
    int pos = lector.nextInt();
    System.out.print("Dime la cantidad: ");
    int cantidad = lector.nextInt();
    Pedido.modificarcarro(pos, cantidad);
}

//aplicar descuento
public static void aplicarDesc(){
    Pedido.verCarrito();
    System.out.print("A que articulo le quiieres descontar: ");
    int pos = lector.nextInt();
    System.out.print("Dime cuanto le quieres poner de descuento: ");
    int desc = lector.nextInt();
    Pedido.aplicarDesc(pos, desc);
}

//********************************************************************************
    public static void main(String[] args) {
        menu();
    }
}

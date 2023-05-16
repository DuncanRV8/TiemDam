import java.util.Scanner;
public class TienDam {

    //Variables
    private static final Scanner lector = new Scanner(System.in);
    public static Almacen almacen = new Almacen();
    public static Pedido pedidos = new Pedido();


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
           almacen();
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
            verAlmacen();
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
            pedidos.verCarrito();
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
public static void almacen(){
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
    int num= 0;
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

//iniciar con algunos articulos
public static void inicarArticulos(){
    almacen.iniciar();
}

//Ver articulos
public static void verAlmacen(){
    almacen.articulosEnAlmacen();
}
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
        elegir = pedirInt("Dime el tipo de iva: " + "\n" +  "1.Normal " + "\n" + "2.Reducida"  + "\n" + "3.Superreducida" + "\n");
    } catch (Exception e) {
        System.out.println("Valor introducido incorrecto");
        lector.nextLine();
    }
    almacen.agregarArticulo(nombre,precio,cantidad,elegir);
}
//Eliminar articulo del almacen
public static void eliminarArticulo(){
    verAlmacen();
    int pos = 0;
    try {
        pos = pedirInt("Dime la posición: ") -1;
    } catch (Exception e) {
        System.out.println("Valor introducido incorrecto");
        lector.nextLine();
    }
    almacen.eliminarArticulo(pos);
}
//Modificar articulo del almacen
public static void modificarArticulo(){
    verAlmacen();
    int pos = 0;
    double precio = 0;
    int cantidad = 0;
    String nombre = null;
    try {
        pos = pedirInt("Dime la posición: ") -1;
        System.out.print("Dime el nuevo nombre: ");
        nombre = lector.next();
        precio = pedirInt("Dime el precio: ");
        cantidad = pedirInt("Dime la cantidad: ");
    } catch (Exception e) {
        System.out.println("Valor introducido incorrecto");
        lector.nextLine();
    }
    almacen.modificarArticulo(nombre, precio, cantidad, pos);
}

//Buscar articulo del almacen
public static void buscarArticulo(){
    verAlmacen();
    System.out.print("Dime el nombre del articulo: ");
    String nombre = lector.next();
    almacen.buscarArticulo(nombre);
}

//Recibir articulo
public static void recibirArticulo(){
    verAlmacen();
    int pos = 0;
    int cantidad = 0;

    try {
        pos = pedirInt("Dime la posición en la que se encuentra: ") -1; 
        cantidad = pedirInt("Dime la cantidad que quieres añadir");
    } catch (Exception e) {
        System.out.println("Valor introducido incorrecto");
        lector.nextLine();
    }
    almacen.recibirArticulo(pos, cantidad);
}

//Devolver Articulo
public static void devolverArticulo(){
    verAlmacen();
    int pos = 0;
    int cantidad = 0;
    try {
        pos = pedirInt("Dime la posición en la que se encuentra: ") -1;
        cantidad = pedirInt("Dime la cantidad que quieres añadir");
    } catch (Exception e) {
        System.out.println("Valor introducido incorrecto");
        lector.nextLine();
    }
    almacen.devolverArticulo(pos, cantidad);
}
//********************************************************************************
//PEDIDO

//añadir al carro
public static void agregarCarro(){
    verAlmacen();
    int pos = 0;
    int cantidad = 0;
    try {
        pos = pedirInt("Dime la posicion en la que esta: ") -1;
        cantidad = pedirInt("Dime la cantidad que quieres: ");
    } catch (Exception e) {
        System.out.println("No se ha podido añadir");
    }
    Articulo art = new Articulo(almacen.articulos.get(pos).getNombre(), almacen.articulos.get(pos).getPrecio(),cantidad, almacen.articulos.get(pos).getIva());
    pedidos.agregarCarro(art);
}

//eliminar del carrito
public static void eliminarDelCarro(){
    pedidos.verCarrito();
    int pos = 0;
    pos = pedirInt("Dime la posicion que quieres eliminar: ") -1;
    pedidos.eliminardelCarro(pos);
}

//modificar carro
public static void modificarCarro(){
    System.out.print("Dime que posicion quieres modificar: ");
    int pos = lector.nextInt();
    System.out.print("Dime la cantidad: ");
    int cantidad = lector.nextInt();
    pedidos.modificarcarro(pos, cantidad);
}

//aplicar descuento
public static void aplicarDesc(){
    pedidos.verCarrito();
    System.out.print("A que articulo le quiieres descontar: ");
    int pos = lector.nextInt();
    System.out.print("Dime cuanto le quieres poner de descuento: ");
    int desc = lector.nextInt();
    pedidos.aplicarDesc(pos, desc);
}

//********************************************************************************
    public static void main(String[] args) {
        inicarArticulos();
        menu();
    }

    /*
    boolean comprobar = true;

     */
}

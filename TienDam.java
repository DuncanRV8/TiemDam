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
    System.out.println("5. Aplicar descuento"); // no lo he hecho
    System.out.println("6. Mostrar carro");
    System.out.println("7. Mostrar el subtotal de los articulos sin IVA");
    System.out.println("8. Mostrar total de los articulos con IVA");
    System.out.println("9. Volver al menu principal");
    System.out.println("10. Salir");
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
            ticket();
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
            subtotalCarrito();
        break;

        case 8:
            totalCarrito();
        break;

        case 9:
            menu();
        break;

        case 10:
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
        int opcion = pedirInt("Elige una opción: ");
        elegirMenu(opcion);
    }
}

//Bucle de Almacen
public static void almacen(){
    while (true) {
        menuAlmacen();
        int opcion = pedirInt("Elige una opcion: ");
        elegirAlmacen(opcion);
    }
}

//Bucle de Pedido
public static void pedido(){
    while (true) {
        menuPedido();
        int opcion = pedirInt("Elige una opcion: ");
        elegirPedido(opcion);
    }
}
//********************************************************************************
//Método pedir int
public static int pedirInt(String mensaje){
    int num = 0;
    boolean continuar = true;
    do {
        try {
            System.out.println(mensaje);
            num = lector.nextInt();
            continuar = false;
        } catch (Exception e) {
            System.err.println("ERROR: parámetro no valido");
            lector.nextLine();
        }
    } while (continuar);
    return num;
}

//Método pedir double
public static double pedirDouble(String mensaje){
    double num = 0;
    boolean continuar = true;
    do {
        try {
            System.out.println(mensaje);
            num = lector.nextDouble();
            continuar = false;
        } catch (Exception e) {
            System.err.println("ERROR: parámetro no valido");
            lector.nextLine();
        }  
    } while (continuar);
    return num;
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
    System.out.print("Dime el nombre del articulo: ");
    String nombre = lector.next();
    lector.nextLine();
    double precio = pedirDouble("Dime el precio: ");
    int cantidad = pedirInt("Dime la cantidad: ");
    int elegir = pedirInt("Dime el tipo de iva: " + "\n" +  "1.Normal " + "\n" + "2.Reducida"  + "\n" + "3.Superreducida" + "\n");
    almacen.agregarArticulo(nombre,precio,cantidad,elegir);
}
//Eliminar articulo del almacen
public static void eliminarArticulo(){
    verAlmacen();
    int pos = pedirInt("Dime la posición: ")-1;
    almacen.eliminarArticulo(pos);
}
//Modificar articulo del almacen
public static void modificarArticulo(){
    verAlmacen();
    int pos = pedirInt("Dime la posición: ")-1;
    double precio = pedirInt("Dime el precio: ");
    int cantidad = pedirInt("Dime la cantidad: ");
    almacen.modificarArticulo(precio, cantidad, pos);
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
    int pos = pedirInt("Dime la posición en la que se encuentra: ")-1; 
    int cantidad = pedirInt("Dime la cantidad que quieres añadir");
    almacen.recibirArticulo(pos, cantidad);
}

//Devolver Articulo
public static void devolverArticulo(){
    verAlmacen();
    int pos = pedirInt("Dime la posición en la que se encuentra: ") -1;
    int cantidad = pedirInt("Dime la cantidad que quieres quitar");
    almacen.devolverArticulo(pos, cantidad);
}
//********************************************************************************
//PEDIDO

//ticket
public static void ticket(){
    pedidos.imprimirPedido();
}
//añadir al carro
public static void agregarCarro(){
    verAlmacen();
    int pos = pedirInt("Dime la posicion en la que esta: ") -1;
    int cantidad = pedirInt("Dime la cantidad que quieres: ");
    Articulo art = new Articulo(almacen.articulos.get(pos).getNombre(), almacen.articulos.get(pos).getPrecio(),cantidad, almacen.articulos.get(pos).getIva());
    pedidos.agregarCarro(art);
}

//eliminar del carrito
public static void eliminarDelCarro(){
    pedidos.verCarrito();
    int pos = pedirInt("Dime la posicion que quieres eliminar: ")-1;
    pedidos.eliminardelCarro(pos);
}

//modificar carrito
public static void modificarCarro(){
    pedidos.verCarrito();
    int pos = pedirInt("Dime que posicion quieres modificar: ")-1;
    int cantidad = pedirInt("Dime la cantidad: ");
    pedidos.modificarcarro(pos, cantidad);
}

//subtotal carrito
public static void subtotalCarrito(){
    pedidos.calcularSubtotal();
}

//total carrito
public static void totalCarrito(){
    pedidos.calcularTotal();
}

//aplicar descuento
public static void aplicarDesc(){
    pedidos.verCarrito();
    int pos = pedirInt("A que articulo le quires descontar: ")-1;
    int desc = pedirInt("Dime cuanto le quieres poner de descuento: ");
    pedidos.aplicarDesc(pos, desc);
}



//********************************************************************************
    public static void main(String[] args) {
        inicarArticulos();
        menu();
    }
}

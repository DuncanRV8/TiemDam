import java.util.Scanner;


public class TienDam {

    //Scanner
    public static Scanner lector = new Scanner(System.in);
    
    //Menu principal
    public static void menu(){
        System.out.println("1. Almacen");
        System.out.println("2. Pedido");
        System.out.println("3. Salir");
    }

    //menu de almacen
    public static void menuAlmacen(){
        System.out.println("1. Ver artículos");
        System.out.println("2. Buscar artículos");
        System.out.println("3. Añadir artículos");
        System.out.println("4. Recibir artículos");
        System.out.println("5. Devolver arículos");
    }

    //menu pedido
    public static void menuPedido(){
        System.out.println("1. Añadir artículo");
        System.out.println("2. Eliminar artículo");
        System.out.println("3. Modificar atículo");
    }

    //Eleccion del menu
    public static void eleccion(int elegir){
        switch (elegir) {
            case 1:
                //almacen
                menuAlmacen();    
            break;

            case 2:
                //pedido
                menuPedido();
            break;
        
            default:
                break;
        }
    }
    
    public static void main(String[] args) {
        while (true) {
            menu();
            eleccion(lector.nextInt());
        }    
    }
}

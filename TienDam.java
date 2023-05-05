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


    public static void menuAlmacen(int opcion){
       
        imprimeSubmenu(opcion);
        opcionAlmacen();
    }

    public static void menuPedido(int opcion){
        
        while(true){
          imprimeSubmenu(opcion);  
          opcionPedido();
        }
    }
    
    public static void opcionAlmacen(){
        int opcion = lector.nextInt();
        switch (opcion) {
            case 1:
                
                break;
        
            default:
                break;
        }
    }

    public static void opcionPedido(){
        int opcion = lector.nextInt();
        switch (opcion) {
            case 1:
                
                break;
        
            default:
                break;
        }
    }


    public static void imprimeSubmenu(int opcion){
        switch (opcion) {
            case 1:
                System.out.println("1. Ver artículos");
                System.out.println("2. Buscar artículos");
                System.out.println("3. Añadir artículos");
                System.out.println("4. Recibir artículos");
                System.out.println("5. Devolver arículos");
                System.out.println("6. Volver al menu principal");
                break;
        
            case 2:
                System.out.println("1. Añadir artículo");
                System.out.println("2. Eliminar artículo");
                System.out.println("3. Modificar atículo");        
                break;
        }
    }

    //Eleccion del menu
    public static void eleccion(int elegir){
        switch (elegir) {
            case 1:
                //almacen
                menuAlmacen(elegir);    
            break;

            case 2:
                //pedido
                menuPedido(elegir);
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

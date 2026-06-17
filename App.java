
import java.util.Scanner;


public class App {

    public static void Registrar(Producto [] productos, Producto mercancia){
        for(int i = 0; i < productos.length; i++){
            if(productos[i] == null){
                productos[i] = mercancia;
                System.out.println("Producto registrado Exitosamente.");
                break;
            }
        }
        System.out.println("Capacidad maxima de inventario alcanzada. Por favor ampliar.");
    }

    public static void RegistrarVenta(Producto [] productos, String codigo, int cantidadVendida){
        for(int i = 0; i < productos.length; i++){
            if(productos[i].getCodigo().equals(codigo)){
                productos[i].setStock(productos[i].getStock() - cantidadVendida);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Producto [] productos = new Producto[100];
        Scanner leer = new Scanner(System.in);
        boolean salir = true;
        int opcion;

        while (salir) {
            System.out.println("""
                ------------------------------
                    SISTEMA DE INVENTARIO
                ------------------------------
                1. Registrar producto
                3. Buscar producto
                4. Mostrar productos
                5. Revisar datos
                5. Salir

                """);
            System.out.print("Seleccione la opcion deseada: ");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    Producto nuevoProducto = new Producto();
                    System.out.println("""
                        ---REGISTRO DE NUEVO PRODUCTO---
                    Rellene los siguientes datos del producto.
                    """);
                    System.out.print("NOMBRE: ");
                    nuevoProducto.setCodigo(leer.nextLine());

                    System.out.print("CODIGO: ");
                    nuevoProducto.setCodigo(leer.nextLine());

                    System.out.print("PRECIO: ");
                    nuevoProducto.setPrecio(leer.nextDouble());

                    System.out.println("CANTIDAD EN STOCK: ");
                    nuevoProducto.setStock(leer.nextInt());

                    Registrar(productos, nuevoProducto);
                    
                    break;

                case 2:
                    System.out.println("---BUSQUEDA POR CODIGO---");

                    System.out.print("Ingrese el codigo del producto: ");
                    String codigoBuscado = leer.nextLine();

                    Producto.buscarCodigo(productos, codigoBuscado);
                    break;
                case 3:
                    System.out.println("---LISTA DE PRODUCTOS REGISTRADOS---");

                    Producto.imprimirProductos(productos);
                case 4: 
                    salir = false;
                    leer.close();
                    break; 
            
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
            
        }
        
    }
}

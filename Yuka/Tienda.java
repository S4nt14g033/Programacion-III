import java.util.Scanner;

public class Tienda {

    public class Precios {
        //Precios de los productos
    private int precioGaseosa = 3000;
    private int precioAgua = 2000;
    private int precioPapas = 2500;
    private int precioGalletas = 1500;

    private int ventasGaseosa = 0;
    private int ventasAgua = 0;
    private int ventasPapas = 0;
    private int ventasGalletas = 0;
    private double totalVendido = 0;
        
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                comprarProducto(scanner);
            }if (opcion == 2) {
                mostrarEstadisticas();
            }if (opcion == 3) {
                salir = true;
                System.out.println("¡Gracias por usar la máquina expendedora!");
            }else {
                System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== MÁQUINA EXPENDEDORA ===");
        System.out.println("1. Comprar producto");
        System.out.println("2. Configurar (Ver estadísticas)");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void comprarProducto(Scanner scanner){
        System.out.println("\n=== PRODUCTOS DISPONIBLES ===");
        System.out.println("1. Gaseosa - " + precioGaseosa);
        System.out.println("2. Agua - $2000");
        System.out.println("3. Papas fritas - $2500");
        System.out.println("4. Galletas - $1500");
        System.out.print("Seleccione un producto (1-4): ");
    }
}

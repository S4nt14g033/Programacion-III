import java.util.Scanner;

public class MaquinaExpendedora {
    // Precios de los productos
    private static final double PRECIO_GASEOSA = 3000;
    private static final double PRECIO_AGUA = 2000;
    private static final double PRECIO_PAPAS = 2500;
    private static final double PRECIO_GALLETAS = 1500;

    // Estadísticas de ventas
    private static int ventasGaseosa = 0;
    private static int ventasAgua = 0;
    private static int ventasPapas = 0;
    private static int ventasGalletas = 0;
    private static double totalVendido = 0.0;

    // Historial de ventas con arreglos
    private static final int MAX_VENTAS = 100;
    private static String[] productosVendidos = new String[MAX_VENTAS];
    private static double[] preciosVendidos = new double[MAX_VENTAS];
    private static int contadorVentas = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                comprarProducto(scanner);
            } else if (opcion == 2) {
                mostrarEstadisticas();
            } else if (opcion == 3) {
                salir = true;
                System.out.println("¡Gracias por usar la máquina expendedora!");
            } else {
                System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== MÁQUINA EXPENDEDORA ===");
        System.out.println("1. Comprar producto");
        System.out.println("2. Configurar (Ver estadísticas)");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void comprarProducto(Scanner scanner) {
        System.out.println("\n=== PRODUCTOS DISPONIBLES ===");
        System.out.println("1. Gaseosa - $" + PRECIO_GASEOSA);
        System.out.println("2. Agua - $" + PRECIO_AGUA);
        System.out.println("3. Papas fritas - $" + PRECIO_PAPAS);
        System.out.println("4. Galletas - $" + PRECIO_GALLETAS);
        System.out.print("Seleccione un producto (1-4): ");

        int producto = scanner.nextInt();
        double precio = 0.0;
        String productoNombre = "";

        if (producto == 1) {
            precio = PRECIO_GASEOSA;
            ventasGaseosa++;
            productoNombre = "Gaseosa";
            System.out.println("Ha seleccionado Gaseosa.");
        } else if (producto == 2) {
            precio = PRECIO_AGUA;
            ventasAgua++;
            productoNombre = "Agua";
            System.out.println("Ha seleccionado Agua.");
        } else if (producto == 3) {
            precio = PRECIO_PAPAS;
            ventasPapas++;
            productoNombre = "Papas fritas";
            System.out.println("Ha seleccionado Papas fritas.");
        } else if (producto == 4) {
            precio = PRECIO_GALLETAS;
            ventasGalletas++;
            productoNombre = "Galletas";
            System.out.println("Ha seleccionado Galletas.");
        } else {
            System.out.println("Producto inválido.");
            return;
        }

        // Aplicar descuento cada 5 ventas
        if (contadorVentas % 5 == 4) { // Cada 5 ventas (0-based index)
            precio *= 0.95; // 5% descuento
            System.out.println("Felicidades cliente número " + (contadorVentas + 1) + ", tienes un 5% de descuento");
        }

        System.out.println("Has Comprado: " + productoNombre + " - $" + precio);
        totalVendido += precio;

        // Registrar en arreglos
        productosVendidos[contadorVentas] = productoNombre;
        preciosVendidos[contadorVentas] = precio;
        contadorVentas++;

        // Reiniciar si llega a 100 ventas
        if (contadorVentas == MAX_VENTAS) {
            reiniciarRegistros();
        }
    }

    private static void mostrarEstadisticas() {
        System.out.println("\n=== MENÚ DE CONFIGURACIÓN ===");
        System.out.println("1. Ver historial de ventas");
        System.out.println("2. Ver producto más vendido");
        System.out.println("3. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");

        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            mostrarHistorialVentas();
        } else if (opcion == 2) {
            mostrarProductoMasVendido();
        } else if (opcion == 3) {
            // Regresar al menú principal
        } else {
            System.out.println("Opción inválida.");
        }
    }

    private static void mostrarHistorialVentas() {
        System.out.println("\n=== HISTORIAL DE VENTAS ===");
        if (contadorVentas == 0) {
            System.out.println("No hay ventas registradas.");
        } else {
            for (int i = 0; i < contadorVentas; i++) {
                System.out.println("Producto: " + productosVendidos[i] + ", Precio: $" + preciosVendidos[i]);
            }
        }
        System.out.println("Total vendido: $" + totalVendido);
    }

    private static void mostrarProductoMasVendido() {
        int maxVentas = Math.max(Math.max(ventasGaseosa, ventasAgua), Math.max(ventasPapas, ventasGalletas));
        System.out.println("\n=== PRODUCTO MÁS VENDIDO ===");
        if (maxVentas == 0) {
            System.out.println("No hay ventas registradas.");
        } else {
            if (ventasGaseosa == maxVentas) {
                System.out.println("Gaseosa: " + ventasGaseosa + " unidades");
            }
            if (ventasAgua == maxVentas) {
                System.out.println("Agua: " + ventasAgua + " unidades");
            }
            if (ventasPapas == maxVentas) {
                System.out.println("Papas fritas: " + ventasPapas + " unidades");
            }
            if (ventasGalletas == maxVentas) {
                System.out.println("Galletas: " + ventasGalletas + " unidades");
            }
        }
    }

    private static void reiniciarRegistros() {
        // Reiniciar contadores de productos
        ventasGaseosa = 0;
        ventasAgua = 0;
        ventasPapas = 0;
        ventasGalletas = 0;
        totalVendido = 0.0;

        // Reiniciar arreglos
        productosVendidos = new String[MAX_VENTAS];
        preciosVendidos = new double[MAX_VENTAS];
        contadorVentas = 0;

        System.out.println("Registros reiniciados después de 100 ventas.");
    }
}

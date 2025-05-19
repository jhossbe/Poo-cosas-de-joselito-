import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Creación de Tabla ---");
            System.out.println("1. Crear y Mostrar Tabla");
            System.out.println("2. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    crearYMostrarTabla(scanner);
                    break;
                case 2:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 2);

        scanner.close();
    }

    private static void crearYMostrarTabla(Scanner scanner) {
        // Solicitar número de columnas
        System.out.print("Ingrese el número de columnas: ");
        int numColumnas = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        // Solicitar nombres de columnas
        List<String> columnas = new ArrayList<>();
        for (int i = 0; i < numColumnas; i++) {
            System.out.printf("Ingrese el nombre de la columna %d: ", i + 1);
            columnas.add(scanner.nextLine());
        }

        // Solicitar número de filas
        System.out.print("Ingrese el número de filas: ");
        int numFilas = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        // Solicitar datos de las filas
        List<List<String>> datos = new ArrayList<>();
        for (int i = 0; i < numFilas; i++) {
            List<String> fila = new ArrayList<>();
            System.out.printf("\nIngrese datos para la fila %d:\n", i + 1);

            for (int j = 0; j < numColumnas; j++) {
                System.out.printf("%s: ", columnas.get(j));
                fila.add(scanner.nextLine());
            }
            datos.add(fila);
        }

        // Llamar al método de la clase TablaConsola para imprimir la tabla
        TablaConsola.imprimirTabla(columnas, datos);
    }
}

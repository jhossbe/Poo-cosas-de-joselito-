import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String archivo = "mi_archivo.txt";
        TextFileHandler manejador = new TextFileHandler(archivo);
        Scanner scanner = new Scanner(System.in); // Creamos un Scanner para leer la entrada del usuario
        int opcion;

        do {
            mostrarMenu(); // Mostramos el menú
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumimos la nueva línea después de leer el entero

            try {
                switch (opcion) {
                    case 1:
                        leerArchivoYMostrar(manejador);
                        break;
                    case 2:
                        escribirEnArchivo(manejador, scanner);
                        break;
                    case 3:
                        anadirAlArchivo(manejador, scanner);
                        break;
                    case 4:
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } catch (IOException e) {
                System.err.println("Error al manejar el archivo: " + e.getMessage());
            }

            System.out.println(); // Añadimos una línea en blanco para separar las iteraciones

        } while (opcion != 4);

        scanner.close(); // Cerramos el Scanner para liberar recursos
    }

    private static void mostrarMenu() {
        System.out.println("--- Menú ---");
        System.out.println("1. Leer el archivo");
        System.out.println("2. Sobreescribir el archivo");
        System.out.println("3. Añadir al archivo");
        System.out.println("4. Salir");
    }

    private static void leerArchivoYMostrar(TextFileHandler manejador) throws IOException {
        String contenido = manejador.leerArchivoCompleto();
        System.out.println("Contenido del archivo:\n" + contenido);
    }

    private static void escribirEnArchivo(TextFileHandler manejador, Scanner scanner) throws IOException {
        System.out.println("Ingrese el contenido para sobreescribir el archivo:");
        String contenido = scanner.nextLine();
        manejador.sobreescribirArchivo(contenido);
        System.out.println("Se ha sobreescrito el archivo.");
    }

    private static void anadirAlArchivo(TextFileHandler manejador, Scanner scanner) throws IOException {
        System.out.println("Ingrese el contenido para añadir al archivo:");
        String contenido = scanner.nextLine();
        manejador.anadirAlArchivo(contenido);
        System.out.println("Se ha añadido al archivo.");
    }
}

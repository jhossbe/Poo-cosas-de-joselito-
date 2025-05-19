import java.util.List;

public class TablaConsola {

    public static void imprimirTabla(List<String> columnas, List<List<String>> datos) {
        if (columnas == null || columnas.isEmpty()) {
            System.out.println("No hay columnas para mostrar.");
            return;
        }

        int numColumnas = columnas.size();
        int[] anchos = calcularAnchos(columnas, datos);

        System.out.println("\nTabla resultante:\n");
        imprimirLinea(anchos);
        imprimirFila(columnas, anchos);
        imprimirLinea(anchos);

        for (List<String> fila : datos) {
            imprimirFila(fila, anchos);
        }

        imprimirLinea(anchos);
    }

    private static int[] calcularAnchos(List<String> columnas, List<List<String>> datos) {
        int numColumnas = columnas.size();
        int[] anchos = new int[numColumnas];
        for (int i = 0; i < numColumnas; i++) {
            anchos[i] = columnas.get(i).length();
            if (datos != null) {
                for (List<String> fila : datos) {
                    if (i < fila.size() && fila.get(i).length() > anchos[i]) {
                        anchos[i] = fila.get(i).length();
                    }
                }
            }
        }
        return anchos;
    }

    private static void imprimirLinea(int[] anchos) {
        System.out.print("+");
        for (int ancho : anchos) {
            System.out.print("-".repeat(ancho + 2) + "+");
        }
        System.out.println();
    }

    private static void imprimirFila(List<String> fila, int[] anchos) {
        System.out.print("|");
        for (int i = 0; i < fila.size(); i++) {
            String formato = " %-" + anchos[i] + "s |";
            System.out.printf(formato, fila.get(i));
        }
        System.out.println();
    }
}
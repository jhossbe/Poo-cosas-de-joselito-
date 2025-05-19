import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileHandler {
    private String rutaArchivo;

    public TextFileHandler(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<String> leerArchivo() throws IOException {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }

    public void escribirArchivo(@org.jetbrains.annotations.NotNull List<String> lineas, boolean append) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, append))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        }
    }

    public void anadirAlArchivo(List<String> lineas) throws IOException {
        escribirArchivo(lineas, true);
    }

    public void sobreescribirArchivo(List<String> lineas) throws IOException {
        escribirArchivo(lineas, false);
    }

    public String leerArchivoCompleto() throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public void escribirArchivoCompleto(String contenido, boolean append) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, append))) {
            bw.write(contenido);
        }
    }

    public void anadirAlArchivo(String contenido) throws IOException {
        escribirArchivoCompleto(contenido, true);
    }

    public void sobreescribirArchivo(String contenido) throws IOException {
        escribirArchivoCompleto(contenido, false);
    }
}



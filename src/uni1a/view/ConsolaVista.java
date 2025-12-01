// Archivo: src/uni1a/view/ConsolaVista.java
package uni1a.view;

import uni1a.model.*;
import java.util.List;
import java.util.Scanner;

public class ConsolaVista {
    private Scanner scanner;

    public ConsolaVista() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {
        System.out.println("\n--- SISTEMA DE GESTIÓN AUDIOVISUAL ---");
        System.out.println("1. Mostrar todo el contenido");
        System.out.println("2. Agregar Película");
        System.out.println("3. Agregar Serie");
        System.out.println("4. Guardar cambios en archivo");
        System.out.println("5. Cargar datos del archivo");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(">> " + mensaje);
    }

    public void mostrarListaContenido(List<ContenidoAudiovisual> lista) {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("\n=== LISTADO DE CONTENIDOS ===");
        for (ContenidoAudiovisual c : lista) {
            System.out.println("ID: " + c.getId() + " | Tipo: " + c.getTipoContenido() + " | Título: " + c.getTitulo());
            
            // Aquí la vista decide cómo formatear detalles específicos según el tipo
            if (c instanceof Pelicula) {
                Pelicula p = (Pelicula) c;
                System.out.println("   Estudio: " + p.getEstudio() + " | Actores: " + p.getElenco());
            } else if (c instanceof SerieDeTV) {
                SerieDeTV s = (SerieDeTV) c;
                System.out.println("   Temporadas: " + s.getTemporadas());
            } else if (c instanceof Documental) {
                Documental d = (Documental) c;
                System.out.println("   Tema: " + d.getTema() + " | Inv.: " + d.getInvestigadores());
            }
            System.out.println("--------------------------------");
        }
    }

    // Métodos para capturar datos (Input)
    public String pedirDato(String etiqueta) {
        System.out.print("Ingrese " + etiqueta + ": ");
        return scanner.nextLine();
    }
    
    public int pedirEntero(String etiqueta) {
        System.out.print("Ingrese " + etiqueta + ": ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
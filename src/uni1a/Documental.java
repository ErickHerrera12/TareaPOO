/**
 * Class Documental
 */
package uni1a;

import java.util.ArrayList;
import java.util.List;

// Subclase Documental que extiende de ContenidoAudiovisual
public class Documental extends ContenidoAudiovisual {
    private String tema;
    private List<Investigador> investigadores; // Agregación: Lista de investigadores

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>(); // Se inicializa la lista vacía
    }

    // Método para agregar un investigador
    public void agregarInvestigador(Investigador investigador) {
        this.investigadores.add(investigador);
    }
    
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + this.tema);
        System.out.println("Investigadores Presentados:");
        if (investigadores.isEmpty()) {
            System.out.println("  - No hay investigadores registrados.");
        } else {
            for (Investigador investigador : investigadores) {
                investigador.mostrarInfo();
            }
        }
        System.out.println();
    }
}
/**
 * Class Pelicula
 */
package uni1a;

import java.util.ArrayList;
import java.util.List;

// Subclase Pelicula que extiende de ContenidoAudiovisual
public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    private List<Actor> elenco; // Agregación: Lista de actores

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
        this.elenco = new ArrayList<>(); // Se inicializa la lista vacía
    }

    // Método para agregar un actor al elenco
    public void agregarActor(Actor actor) {
        this.elenco.add(actor);
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + this.estudio);
        System.out.println("Elenco:");
        if (elenco.isEmpty()) {
            System.out.println("  - No hay actores registrados.");
        } else {
            for (Actor actor : elenco) {
                actor.mostrarInfo();
            }
        }
        System.out.println();
    }
}
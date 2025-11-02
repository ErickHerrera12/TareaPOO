package uni1a;

import java.util.ArrayList;
import java.util.List;

public class Cortometraje extends ContenidoAudiovisual {
    private String festivalParticipacion;
    private List<Actor> elenco; // Reutilizamos la agregación con Actor

    public Cortometraje(String titulo, int duracionEnMinutos, String genero, String festivalParticipacion) {
        super(titulo, duracionEnMinutos, genero);
        this.festivalParticipacion = festivalParticipacion;
        this.elenco = new ArrayList<>();
    }

    // Método para agregar un actor al elenco
    public void agregarActor(Actor actor) {
        this.elenco.add(actor);
    }
    
    public String getFestivalParticipacion() {
        return festivalParticipacion;
    }

    public void setFestivalParticipacion(String festivalParticipacion) {
        this.festivalParticipacion = festivalParticipacion;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Cortometraje:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Festival: " + this.festivalParticipacion);
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
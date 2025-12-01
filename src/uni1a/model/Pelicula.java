// Archivo: src/uni1a/model/Pelicula.java
package uni1a.model;

import java.util.ArrayList;
import java.util.List;

public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    private List<Actor> elenco;

    public Pelicula(String titulo, int duracion, String genero, String estudio) {
        super(titulo, duracion, genero);
        this.estudio = estudio;
        this.elenco = new ArrayList<>();
    }

    // Constructor sobrecargado para carga de archivos
    public Pelicula(int id, String titulo, int duracion, String genero, String estudio) {
        super(id, titulo, duracion, genero);
        this.estudio = estudio;
        this.elenco = new ArrayList<>();
    }

    public void agregarActor(Actor actor) {
        this.elenco.add(actor);
    }

    public String getEstudio() { return estudio; }
    public List<Actor> getElenco() { return elenco; }

    @Override
    public String getTipoContenido() {
        return "PELICULA";
    }
}
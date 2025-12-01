// Archivo: src/uni1a/model/SerieDeTV.java
package uni1a.model;

import java.util.ArrayList;
import java.util.List;

public class SerieDeTV extends ContenidoAudiovisual {
    private List<Temporada> temporadas;

    public SerieDeTV(String titulo, int duracionPromedio, String genero) {
        super(titulo, duracionPromedio, genero);
        this.temporadas = new ArrayList<>();
    }

    public SerieDeTV(int id, String titulo, int duracion, String genero) {
        super(id, titulo, duracion, genero);
        this.temporadas = new ArrayList<>();
    }

    public void agregarTemporada(Temporada temporada) {
        this.temporadas.add(temporada);
    }

    public List<Temporada> getTemporadas() { return temporadas; }

    @Override
    public String getTipoContenido() {
        return "SERIE";
    }
}
/**
 * Class SerieDeTV
 */
package uni1a;

import java.util.ArrayList;
import java.util.List;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private List<Temporada> temporadas; // Composición: Lista de temporadas

    // El constructor ya no recibe el número de temporadas
    public SerieDeTV(String titulo, int duracionEnMinutos, String genero) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = new ArrayList<>(); // La serie controla la creación de sus temporadas
    }

    // Método para agregar una temporada. La serie crea y gestiona el objeto Temporada.
    public void agregarTemporada(int numeroTemporada, int cantidadEpisodios) {
        Temporada nuevaTemporada = new Temporada(numeroTemporada, cantidadEpisodios);
        this.temporadas.add(nuevaTemporada);
    }

    // Este método ahora devuelve el tamaño de la lista
    public int getNumeroDeTemporadas() {
        return temporadas.size();
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la Serie de TV:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración promedio por episodio (min): " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Número de Temporadas: " + this.getNumeroDeTemporadas());
        if (temporadas.isEmpty()) {
            System.out.println("  - No hay temporadas registradas.");
        } else {
            for (Temporada temporada : temporadas) {
                temporada.mostrarInfo();
            }
        }
        System.out.println();
    }
}
package uni1a;

public class Temporada {
    private int numeroTemporada;
    private int cantidadEpisodios;

    public Temporada(int numeroTemporada, int cantidadEpisodios) {
        this.numeroTemporada = numeroTemporada;
        this.cantidadEpisodios = cantidadEpisodios;
    }

    // Getter para 'numeroTemporada'
    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    // Setter para 'numeroTemporada'
    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    // Getter para 'cantidadEpisodios'
    public int getCantidadEpisodios() {
        return cantidadEpisodios;
    }

    // Setter para 'cantidadEpisodios'
    public void setCantidadEpisodios(int cantidadEpisodios) {
        this.cantidadEpisodios = cantidadEpisodios;
    }
    
    // Método para mostrar la información de la temporada
    public void mostrarInfo() {
        System.out.println("  - Temporada " + numeroTemporada + ": " + cantidadEpisodios + " episodios.");
    }
}
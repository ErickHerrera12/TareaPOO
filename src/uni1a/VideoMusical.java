package uni1a;

public class VideoMusical extends ContenidoAudiovisual {
    private Artista artista; // Agregación con Artista
    private String album;

    public VideoMusical(String titulo, int duracionEnMinutos, String genero, Artista artista, String album) {
        super(titulo, duracionEnMinutos, genero);
        this.artista = artista; // Se asocia un artista existente
        this.album = album;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Video Musical:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Álbum: " + this.album);
        if (artista != null) {
            artista.mostrarInfo();
        }
        System.out.println();
    }
}
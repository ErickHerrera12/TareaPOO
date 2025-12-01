// Archivo: src/uni1a/model/ContenidoAudiovisual.java
package uni1a.model;

/**
 * Clase abstracta que representa la base de cualquier contenido.
 * Cumple con OCP: Abierta para extensión (nuevos tipos), cerrada para modificación.
 */
public abstract class ContenidoAudiovisual {
    // Identificador único para persistencia
    private static int contadorIds = 1; 
    protected int id;
    private String titulo;
    private int duracionEnMinutos;
    private String genero;

    public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
        this.id = contadorIds++;
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
    }
    
    // Constructor para carga desde archivo (preserva ID)
    public ContenidoAudiovisual(int id, String titulo, int duracionEnMinutos, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
        if (id >= contadorIds) contadorIds = id + 1;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getDuracionEnMinutos() { return duracionEnMinutos; }
    public String getGenero() { return genero; }

    /**
     * Método abstracto para obtener el tipo de contenido en formato String.
     * Útil para la persistencia en CSV.
     */
    public abstract String getTipoContenido();
}
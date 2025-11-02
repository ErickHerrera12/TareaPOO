package uni1a;

public class Artista {
    private String nombre;
    private String generoMusical;

    public Artista(String nombre, String generoMusical) {
        this.nombre = nombre;
        this.generoMusical = generoMusical;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
    
    public void mostrarInfo() {
        System.out.println("  - Artista: " + nombre + " (Género: " + generoMusical + ")");
    }
}
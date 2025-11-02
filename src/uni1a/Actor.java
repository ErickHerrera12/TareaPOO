package uni1a;

public class Actor {
    private String nombre;
    private String nacionalidad;

    public Actor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    // Getter para 'nombre'
    public String getNombre() {
        return nombre;
    }

    // Setter para 'nombre'
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para 'nacionalidad'
    public String getNacionalidad() {
        return nacionalidad;
    }

    // Setter para 'nacionalidad'
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    // Método para mostrar la información del actor
    public void mostrarInfo() {
        System.out.println("  - Actor: " + nombre + " (" + nacionalidad + ")");
    }
}
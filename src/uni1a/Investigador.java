package uni1a;

public class Investigador {
    private String nombre;
    private String especialidad;

    public Investigador(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Getter para 'nombre'
    public String getNombre() {
        return nombre;
    }

    // Setter para 'nombre'
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para 'especialidad'
    public String getEspecialidad() {
        return especialidad;
    }

    // Setter para 'especialidad'
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Método para mostrar la información del investigador
    public void mostrarInfo() {
        System.out.println("  - Investigador: " + nombre + ", Especialista en: " + especialidad);
    }
}
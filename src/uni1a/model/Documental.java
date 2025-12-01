// Archivo: src/uni1a/model/Documental.java
package uni1a.model;

import java.util.ArrayList;
import java.util.List;

public class Documental extends ContenidoAudiovisual {
    private String tema;
    private List<Investigador> investigadores;

    public Documental(String titulo, int duracion, String genero, String tema) {
        super(titulo, duracion, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    public Documental(int id, String titulo, int duracion, String genero, String tema) {
        super(id, titulo, duracion, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    public void agregarInvestigador(Investigador inv) {
        this.investigadores.add(inv);
    }

    public String getTema() { return tema; }
    public List<Investigador> getInvestigadores() { return investigadores; }

    @Override
    public String getTipoContenido() {
        return "DOCUMENTAL";
    }
}
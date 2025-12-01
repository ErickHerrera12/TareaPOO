// Archivo: src/uni1a/persistence/ManejadorArchivos.java
package uni1a.persistence;

import uni1a.model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de la persistencia de datos en archivos CSV.
 * Permite guardar y recuperar el estado de los objetos del sistema.
 */
public class ManejadorArchivos {
    private String rutaArchivo;
    
    // Constantes para el formato del CSV
    private static final String SEPARADOR = ";";
    private static final String SEPARADOR_LISTA_REGEX = "\\|"; // Para split (escapado)
    private static final String SEPARADOR_LISTA_JOIN = "|";    // Para join
    private static final String SEPARADOR_ATTR = ":";

    /**
     * Constructor por defecto. Usa el archivo de producción.
     */
    public ManejadorArchivos() {
        this.rutaArchivo = "data_contenidos.csv";
    }

    /**
     * Constructor para pruebas. Permite inyectar un archivo temporal.
     * @param rutaArchivo Ruta del archivo a utilizar.
     */
    public ManejadorArchivos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    /**
     * Guarda la lista de contenidos en el archivo CSV configurado.
     * Formato: TIPO;ID;TITULO;DURACION;GENERO;DATO_EXTRA;LISTA_DETALLES
     */
    public void guardarContenidos(List<ContenidoAudiovisual> contenidos) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.rutaArchivo))) {
            for (ContenidoAudiovisual c : contenidos) {
                StringBuilder linea = new StringBuilder();
                
                // Datos comunes
                linea.append(c.getTipoContenido()).append(SEPARADOR)
                     .append(c.getId()).append(SEPARADOR)
                     .append(c.getTitulo()).append(SEPARADOR)
                     .append(c.getDuracionEnMinutos()).append(SEPARADOR)
                     .append(c.getGenero()).append(SEPARADOR);

                // Datos específicos según el tipo (Polimorfismo)
                if (c instanceof Pelicula) {
                    Pelicula p = (Pelicula) c;
                    linea.append(p.getEstudio()).append(SEPARADOR);
                    
                    // Serializar lista de actores (Nombre:Nacionalidad|...)
                    List<String> actoresStr = new ArrayList<>();
                    for (Actor a : p.getElenco()) {
                        actoresStr.add(a.getNombre() + SEPARADOR_ATTR + a.getNacionalidad());
                    }
                    linea.append(String.join(SEPARADOR_LISTA_JOIN, actoresStr));
                    
                } else if (c instanceof SerieDeTV) {
                    SerieDeTV s = (SerieDeTV) c;
                    linea.append("N/A").append(SEPARADOR); // Placeholder para mantener estructura
                    
                    // Serializar lista de temporadas (Num:Eps|...)
                    List<String> tempStr = new ArrayList<>();
                    for (Temporada t : s.getTemporadas()) {
                        tempStr.add(t.getNumero() + SEPARADOR_ATTR + t.getEpisodios());
                    }
                    linea.append(String.join(SEPARADOR_LISTA_JOIN, tempStr));

                } else if (c instanceof Documental) {
                    Documental d = (Documental) c;
                    linea.append(d.getTema()).append(SEPARADOR);
                    
                    // Serializar lista de investigadores (Nombre:Especialidad|...)
                    List<String> invStr = new ArrayList<>();
                    for (Investigador i : d.getInvestigadores()) {
                        invStr.add(i.getNombre() + SEPARADOR_ATTR + i.getEspecialidad());
                    }
                    linea.append(String.join(SEPARADOR_LISTA_JOIN, invStr));
                }
                
                writer.write(linea.toString());
                writer.newLine();
            }
        }
    }

    /**
     * Carga los contenidos desde el archivo CSV.
     * @return Lista de objetos ContenidoAudiovisual recuperados.
     */
    public List<ContenidoAudiovisual> cargarContenidos() throws IOException {
        List<ContenidoAudiovisual> lista = new ArrayList<>();
        File archivo = new File(this.rutaArchivo);
        
        if (!archivo.exists()) {
            return lista; // Retorna lista vacía si no hay archivo previo
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                String[] datos = linea.split(SEPARADOR);
                // Validación básica de integridad
                if (datos.length < 6) continue;

                String tipo = datos[0];
                int id = Integer.parseInt(datos[1]);
                String titulo = datos[2];
                int duracion = Integer.parseInt(datos[3]);
                String genero = datos[4];
                String datoExtra = datos[5];
                String listaDatos = (datos.length > 6) ? datos[6] : "";

                switch (tipo) {
                    case "PELICULA":
                        Pelicula p = new Pelicula(id, titulo, duracion, genero, datoExtra);
                        parsearActores(p, listaDatos);
                        lista.add(p);
                        break;
                    case "SERIE":
                        SerieDeTV s = new SerieDeTV(id, titulo, duracion, genero);
                        parsearTemporadas(s, listaDatos);
                        lista.add(s);
                        break;
                    case "DOCUMENTAL":
                        Documental d = new Documental(id, titulo, duracion, genero, datoExtra);
                        parsearInvestigadores(d, listaDatos);
                        lista.add(d);
                        break;
                }
            }
        }
        return lista;
    }

    // --- Métodos auxiliares para parseo de sub-listas ---

    private void parsearActores(Pelicula p, String data) {
        if (data == null || data.isEmpty()) return;
        String[] items = data.split(SEPARADOR_LISTA_REGEX);
        for (String item : items) {
            String[] attr = item.split(SEPARADOR_ATTR);
            if (attr.length == 2) {
                p.agregarActor(new Actor(attr[0], attr[1]));
            }
        }
    }

    private void parsearTemporadas(SerieDeTV s, String data) {
        if (data == null || data.isEmpty()) return;
        String[] items = data.split(SEPARADOR_LISTA_REGEX);
        for (String item : items) {
            String[] attr = item.split(SEPARADOR_ATTR);
            if (attr.length == 2) {
                try {
                    s.agregarTemporada(new Temporada(Integer.parseInt(attr[0]), Integer.parseInt(attr[1])));
                } catch (NumberFormatException e) {
                    // Ignorar registro corrupto de temporada
                }
            }
        }
    }

    private void parsearInvestigadores(Documental d, String data) {
        if (data == null || data.isEmpty()) return;
        String[] items = data.split(SEPARADOR_LISTA_REGEX);
        for (String item : items) {
            String[] attr = item.split(SEPARADOR_ATTR);
            if (attr.length == 2) {
                d.agregarInvestigador(new Investigador(attr[0], attr[1]));
            }
        }
    }
}
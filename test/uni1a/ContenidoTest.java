// Archivo: test/uni1a/ContenidoTest.java
package uni1a;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uni1a.model.*;
import uni1a.persistence.ManejadorArchivos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContenidoTest {

    private static final String ARCHIVO_TEST = "test_data.csv";
    
    // Se ejecuta después de cada test para borrar el archivo de prueba y dejar todo limpio
    @AfterEach
    public void tearDown() {
        File file = new File(ARCHIVO_TEST);
        if (file.exists()) {
            file.delete();
        }
    }

    // --- PRUEBAS DE MODELO ---

    @Test
    public void testPeliculaDetalles() {
        Pelicula p = new Pelicula("Inception", 148, "Sci-Fi", "Warner Bros");
        p.agregarActor(new Actor("Leo DiCaprio", "USA"));
        
        assertNotNull(p);
        assertEquals("Inception", p.getTitulo());
        assertEquals("Warner Bros", p.getEstudio());
        assertEquals(1, p.getElenco().size());
        assertEquals("PELICULA", p.getTipoContenido());
    }

    @Test
    public void testSerieTemporadas() {
        SerieDeTV serie = new SerieDeTV("Dark", 60, "Misterio");
        serie.agregarTemporada(new Temporada(1, 10));
        serie.agregarTemporada(new Temporada(2, 8));

        assertEquals(2, serie.getTemporadas().size());
        assertEquals(10, serie.getTemporadas().get(0).getEpisodios());
        assertEquals("SERIE", serie.getTipoContenido());
    }

    @Test
    public void testDocumentalInvestigadores() {
        Documental doc = new Documental("Cosmos", 50, "Ciencia", "Astronomía");
        doc.agregarInvestigador(new Investigador("Carl Sagan", "Astrofísica"));

        assertEquals("Astronomía", doc.getTema());
        assertFalse(doc.getInvestigadores().isEmpty());
        assertEquals("Carl Sagan", doc.getInvestigadores().get(0).getNombre());
        assertEquals("DOCUMENTAL", doc.getTipoContenido());
    }

    @Test
    public void testGeneracionDeIdsUnicos() {
        // Al crear objetos secuenciales, los IDs deben incrementar
        ContenidoAudiovisual c1 = new Pelicula("A", 1, "A", "A");
        ContenidoAudiovisual c2 = new SerieDeTV("B", 1, "B");
        ContenidoAudiovisual c3 = new Documental("C", 1, "C", "C");

        // Verificamos que no sean iguales
        assertNotEquals(c1.getId(), c2.getId());
        assertNotEquals(c2.getId(), c3.getId());
        
        // Verificamos que el segundo sea mayor que el primero
        assertTrue(c2.getId() > c1.getId());
    }

    // --- PRUEBAS DE PERSISTENCIA (ARCHIVOS) ---

    @Test
    public void testGuardarYCargarDatos() throws IOException {
        // 1. Preparar datos
        ManejadorArchivos manejador = new ManejadorArchivos(ARCHIVO_TEST);
        List<ContenidoAudiovisual> listaOriginal = new ArrayList<>();
        
        Pelicula p = new Pelicula("Test Movie", 120, "Test", "Studio X");
        p.agregarActor(new Actor("Actor Test", "Nacion Test"));
        
        SerieDeTV s = new SerieDeTV("Test Serie", 30, "Comedy");
        s.agregarTemporada(new Temporada(1, 12));
        
        listaOriginal.add(p);
        listaOriginal.add(s);

        // 2. Guardar en archivo temporal
        manejador.guardarContenidos(listaOriginal);

        // 3. Verificar que el archivo se creó
        File file = new File(ARCHIVO_TEST);
        assertTrue(file.exists(), "El archivo CSV debería existir");

        // 4. Cargar datos de nuevo
        List<ContenidoAudiovisual> listaCargada = manejador.cargarContenidos();

        // 5. Validaciones (Asserts)
        assertEquals(2, listaCargada.size(), "Debería haber recuperado 2 elementos");

        // Validar Película recuperada
        ContenidoAudiovisual recuperado1 = listaCargada.get(0);
        assertTrue(recuperado1 instanceof Pelicula);
        assertEquals("Test Movie", recuperado1.getTitulo());
        assertEquals("Studio X", ((Pelicula) recuperado1).getEstudio());
        assertEquals("Actor Test", ((Pelicula) recuperado1).getElenco().get(0).getNombre());

        // Validar Serie recuperada
        ContenidoAudiovisual recuperado2 = listaCargada.get(1);
        assertTrue(recuperado2 instanceof SerieDeTV);
        assertEquals(1, ((SerieDeTV) recuperado2).getTemporadas().size());
    }

    @Test
    public void testCargaArchivoVacio() throws IOException {
        ManejadorArchivos manejador = new ManejadorArchivos(ARCHIVO_TEST);
        // Creamos un archivo vacío manualmente
        new File(ARCHIVO_TEST).createNewFile();
        
        List<ContenidoAudiovisual> lista = manejador.cargarContenidos();
        assertTrue(lista.isEmpty(), "La lista debería estar vacía si el archivo no tiene contenido");
    }
    
    @Test
    public void testCargaArchivoNoExistente() throws IOException {
        ManejadorArchivos manejador = new ManejadorArchivos("archivo_fantasma.csv");
        List<ContenidoAudiovisual> lista = manejador.cargarContenidos();
        
        assertNotNull(lista);
        assertTrue(lista.isEmpty(), "Debería devolver lista vacía y no lanzar error si el archivo no existe");
    }
}
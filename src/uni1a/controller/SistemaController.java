// Archivo: src/uni1a/controller/SistemaController.java
package uni1a.controller;

import uni1a.model.*;
import uni1a.persistence.ManejadorArchivos;
import uni1a.view.ConsolaVista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SistemaController {
    private List<ContenidoAudiovisual> contenidos;
    private ConsolaVista vista;
    private ManejadorArchivos archivos;

    public SistemaController() {
        this.contenidos = new ArrayList<>();
        this.vista = new ConsolaVista();
        this.archivos = new ManejadorArchivos();
    }

    public void iniciar() {
        boolean ejecutando = true;
        while (ejecutando) {
            int opcion = vista.mostrarMenuPrincipal();
            switch (opcion) {
                case 1:
                    vista.mostrarListaContenido(contenidos);
                    break;
                case 2:
                    crearPelicula();
                    break;
                case 3:
                    crearSerie();
                    break;
                case 4:
                    guardarDatos();
                    break;
                case 5:
                    cargarDatos();
                    break;
                case 0:
                    ejecutando = false;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }

    private void crearPelicula() {
        String titulo = vista.pedirDato("Título");
        int duracion = vista.pedirEntero("Duración (min)");
        String genero = vista.pedirDato("Género");
        String estudio = vista.pedirDato("Estudio");
        
        Pelicula p = new Pelicula(titulo, duracion, genero, estudio);
        
        // Agregar un actor de prueba (en un sistema real sería un bucle)
        String nombreActor = vista.pedirDato("Nombre Actor Principal");
        String nacionActor = vista.pedirDato("Nacionalidad Actor");
        p.agregarActor(new Actor(nombreActor, nacionActor));
        
        contenidos.add(p);
        vista.mostrarMensaje("Película agregada exitosamente.");
    }

    private void crearSerie() {
        String titulo = vista.pedirDato("Título");
        int duracion = vista.pedirEntero("Duración prom. episodio");
        String genero = vista.pedirDato("Género");
        
        SerieDeTV s = new SerieDeTV(titulo, duracion, genero);
        
        // Agregar temporada inicial
        int numTemp = vista.pedirEntero("Número de temporada");
        int numEps = vista.pedirEntero("Cantidad episodios");
        s.agregarTemporada(new Temporada(numTemp, numEps));
        
        contenidos.add(s);
        vista.mostrarMensaje("Serie agregada exitosamente.");
    }

    private void guardarDatos() {
        try {
            archivos.guardarContenidos(contenidos);
            vista.mostrarMensaje("Datos guardados en data_contenidos.csv");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al guardar: " + e.getMessage());
        }
    }

    private void cargarDatos() {
        try {
            contenidos = archivos.cargarContenidos();
            vista.mostrarMensaje("Datos cargados. Total registros: " + contenidos.size());
        } catch (IOException e) {
            vista.mostrarMensaje("Error al cargar: " + e.getMessage());
        }
    }
}
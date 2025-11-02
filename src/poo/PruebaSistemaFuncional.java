package poo;
import uni1a.*;

public class PruebaSistemaFuncional {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("==   Sistema de Gestión de Contenido Audiovisual  ==");
        System.out.println("==================================================");
        System.out.println();

        // --- ETAPA 1: Crear objetos independientes (para Agregación) ---
        // Estos objetos existen por sí mismos y luego se asociarán a un contenido.
        
        System.out.println("--- Creando Actores, Investigadores y Artistas... ---");
        Actor actor1 = new Actor("Leonardo DiCaprio", "Estadounidense");
        Actor actor2 = new Actor("Kate Winslet", "Británica");
        Actor actor3 = new Actor("Cillian Murphy", "Irlandés");
        
        Investigador inv1 = new Investigador("Carl Sagan", "Astrofísica");
        Investigador inv2 = new Investigador("Jane Goodall", "Primatología");

        Artista artista1 = new Artista("Michael Jackson", "Pop");
        System.out.println("¡Objetos independientes creados!");
        System.out.println();


        // --- ETAPA 2: Crear instancias de ContenidoAudiovisual y establecer relaciones ---

        System.out.println("--- Creando y configurando el contenido audiovisual... ---");

        // 1. Crear una Película y agregarle actores (Agregación)
        Pelicula pelicula1 = new Pelicula("Titanic", 195, "Drama", "20th Century Studios");
        pelicula1.agregarActor(actor1);
        pelicula1.agregarActor(actor2);

        // 2. Crear una Serie de TV y agregarle temporadas (Composición)
        // Las temporadas se crean DENTRO de la serie, no pueden existir por sí solas.
        SerieDeTV serie1 = new SerieDeTV("Peaky Blinders", 55, "Drama Histórico");
        serie1.agregarTemporada(1, 6);
        serie1.agregarTemporada(2, 6);
        serie1.agregarTemporada(3, 6);

        // 3. Crear un Documental y agregarle investigadores (Agregación)
        Documental docu1 = new Documental("Cosmos: A Personal Voyage", 60, "Ciencia", "Universo");
        docu1.agregarInvestigador(inv1);

        // 4. Crear un Cortometraje, nuestra nueva subclase
        Cortometraje corto1 = new Cortometraje("Bao", 8, "Animación", "Festival de Tribeca");
        corto1.agregarActor(new Actor("Sindy Lau", "Canadiense")); // Podemos crear actores al vuelo también

        // 5. Crear un Video Musical, nuestra otra nueva subclase
        VideoMusical video1 = new VideoMusical("Thriller", 14, "Video Musical", artista1, "Thriller");
        
        System.out.println("¡Contenido creado y configurado!");
        System.out.println();


        // --- ETAPA 3: Almacenar todo en un arreglo y mostrar detalles (Polimorfismo) ---
        
        ContenidoAudiovisual[] catalogo = new ContenidoAudiovisual[5];
        catalogo[0] = pelicula1;
        catalogo[1] = serie1;
        catalogo[2] = docu1;
        catalogo[3] = corto1;
        catalogo[4] = video1;

        System.out.println("--- MOSTRANDO EL CATÁLOGO COMPLETO ---");
        System.out.println();

        // Gracias al polimorfismo, Java sabe qué método .mostrarDetalles() llamar para cada objeto.
        for (ContenidoAudiovisual contenido : catalogo) {
            contenido.mostrarDetalles();
        }
    }
}
# Sistema de Gestión de Contenido Audiovisual (Refactorizado)

Este proyecto es una evolución del sistema de gestión de contenidos audiovisuales (Películas, Series, Documentales, etc.). El objetivo principal de esta versión es aplicar principios de ingeniería de software avanzada, incluyendo **Código Limpio**, principios **SOLID**, patrón **MVC** y **Persistencia de Datos**.

##  Tabla de Contenidos
- [Descripción del Proyecto](#descripción-del-proyecto)
- [Cambios Implementados](#cambios-implementados)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Requisitos Previos](#requisitos-previos)
- [Instalación y Clonación](#instalación-y-clonación)
- [Cómo Ejecutar el Proyecto](#cómo-ejecutar-el-proyecto)
- [Ejecución de Pruebas](#ejecución-de-pruebas)
- [Autor](#autor)

##  Descripción del Proyecto
El sistema permite gestionar un catálogo de contenidos audiovisuales. Los usuarios pueden agregar películas, series de TV y documentales, así como visualizar los detalles de cada uno.

En esta actualización, el sistema ha dejado de ser volátil (datos en memoria) para guardar la información en archivos físicos (CSV), permitiendo recuperar los datos tras reiniciar la aplicación.

##  Cambios Implementados

### 1. Manejo de Archivos (Persistencia)
- Se implementó la clase `ManejadorArchivos` para leer y escribir en formato **CSV**.
- Se utiliza `BufferedReader` y `BufferedWriter` para un rendimiento óptimo.
- **Serialización personalizada:** Los objetos complejos (listas de actores, temporadas) se almacenan en una sola columna utilizando separadores especiales (`|`) para mantener la integridad en un archivo plano.

### 2. Refactorización y Código Limpio
- **Nombres Significativos:** Se renombraron variables y métodos para que expliquen por sí mismos su función.
- **Métodos Pequeños:** Se dividieron métodos largos (como la lectura del archivo) en sub-métodos privados más pequeños (`parsearActores`, `parsearTemporadas`).
- **Eliminación de redundancia:** Se optimizó el uso de constructores y herencia.

### 3. Principios SOLID
- **SRP (Responsabilidad Única):** Las clases del modelo (`Pelicula`, `Actor`) ya no imprimen en consola. Esa responsabilidad se delegó exclusivamente a la Vista.
- **OCP (Abierto/Cerrado):** El sistema permite agregar nuevos tipos de contenido extendiendo `ContenidoAudiovisual` sin modificar la lógica base de persistencia.
- **DIP (Inversión de Dependencias):** El `ManejadorArchivos` no depende de una ruta fija, permitiendo inyectar archivos de prueba.

### 4. Patrón MVC (Modelo-Vista-Controlador)
Se reestructuró el código separando las responsabilidades:
- **Model:** Lógica de negocio y entidades.
- **View:** Interfaz de usuario por consola.
- **Controller:** Orquestador que conecta el modelo, la vista y la persistencia.

##  Estructura del Proyecto

```text
src/
├── poo/
│   └── PruebaSistemaFuncional.java  # Punto de entrada (Main)
├── uni1a/
│   ├── controller/
│   │   └── SistemaController.java   # Controlador principal
│   ├── model/                       # Entidades de negocio
│   │   ├── Actor.java
│   │   ├── ContenidoAudiovisual.java (Abstracta)
│   │   ├── Pelicula.java
│   │   ├── SerieDeTV.java
│   │   ├── Documental.java
│   │   ├── Temporada.java
│   │   └── Investigador.java
│   ├── persistence/
│   │   └── ManejadorArchivos.java   # Lógica de lectura/escritura CSV
│   └── view/
│       └── ConsolaVista.java        # Interfaz de usuario (System.out)
test/
└── uni1a/
    └── ContenidoTest.java           # Pruebas Unitarias (JUnit 5)
```

##  Requisitos Previos
- **Java JDK:** Versión 11 o superior.
- **IDE:** IntelliJ IDEA, Eclipse o NetBeans.
- **JUnit 5:** Para ejecutar las pruebas unitarias.

##  Instalación y Clonación

Para obtener una copia del proyecto en tu máquina local, ejecuta el siguiente comando en tu terminal:

```bash
git clone https://github.com/ErickHerrera12/TareaPOO.git
```

Luego, abre el proyecto en tu IDE de preferencia.

## ▶️ Cómo Ejecutar el Proyecto

1. Navega a la carpeta `src/poo/`.
2. Ubica la clase `PruebaSistemaFuncional.java`.
3. Haz clic derecho sobre el archivo y selecciona **Run 'PruebaSistemaFuncional.main()'**.
4. La aplicación iniciará en la consola mostrándote el menú principal.

**Nota:** La primera vez que guardes datos, se creará automáticamente el archivo `data_contenidos.csv` en la raíz del proyecto.

##  Ejecución de Pruebas

El proyecto cuenta con pruebas unitarias que verifican la lógica de negocio y la persistencia de datos.

1. Navega a la carpeta `test/uni1a/`.
2. Ubica el archivo `ContenidoTest.java`.
3. Haz clic derecho y selecciona **Run 'ContenidoTest'**.
4. Verifica que todos los tests pasen (barra verde).

Las pruebas incluyen:
- Creación de objetos y validación de atributos.
- Verificación de relaciones (Actores en Películas, Temporadas en Series).
- **Prueba de Integración:** Guardado y carga de datos desde un archivo temporal para asegurar que la persistencia funciona correctamente.

##  Autor
**Erick Herrera** - *Desarrollo, Refactorización y Documentación*
```
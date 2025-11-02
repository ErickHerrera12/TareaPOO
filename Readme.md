# Proyecto de Gestión de Contenido Audiovisual (POO)

## Descripción del Proyecto

Este proyecto es una aplicación de consola desarrollada en Java que sirve como un sistema de gestión para un catálogo de contenido audiovisual. Su propósito principal es demostrar la aplicación de conceptos avanzados de Programación Orientada a Objetos (POO) de una manera práctica y cohesiva.

El sistema modela una jerarquía de clases de contenido audiovisual, partiendo de una clase abstracta `ContenidoAudiovisual` y especializándose en tipos concretos como `Pelicula`, `SerieDeTV`, `Documental`, `Cortometraje` y `VideoMusical`.

### Características Principales

*   **Herencia:** Utiliza una clase base abstracta (`ContenidoAudiovisual`) para definir atributos y comportamientos comunes, que luego son extendidos por subclases específicas.
*   **Polimorfismo:** Permite tratar a todos los objetos de contenido audiovisual de manera uniforme a través de la clase base, por ejemplo, al mostrarlos en un catálogo general.
*   **Agregación:** Modela relaciones "tiene un" donde los objetos tienen ciclos de vida independientes, como una `Pelicula` que tiene un elenco de `Actores`.
*   **Composición:** Implementa relaciones "es parte de" donde el ciclo de vida de un objeto depende de otro, como una `SerieDeTV` que se compone de `Temporadas`.
*   **Código Extensible:** La estructura del proyecto está diseñada para ser fácilmente ampliable con nuevos tipos de contenido audiovisual o nuevas relaciones.

### Problema que Resuelve

Este proyecto resuelve el desafío educativo de aplicar la teoría de la POO en un escenario práctico. Proporciona un modelo funcional que organiza datos complejos y sus interrelaciones (como el elenco de una película o las temporadas de una serie), demostrando cómo la POO ayuda a crear software más organizado, mantenible y escalable.

---

## Instrucciones de Instalación y Uso

Para clonar y ejecutar este proyecto en tu máquina local, sigue los siguientes pasos.

### Prerrequisitos

*   **Git:** Debes tener Git instalado para clonar el repositorio.
*   **Java Development Kit (JDK):** Asegúrate de tener instalado un JDK (versión 8 o superior).

### Pasos para la Instalación

1.  **Clonar el Repositorio:**
    Abre una terminal o consola y ejecuta el siguiente comando. 

    ```bash
    git clone https://github.com/ErickHerrera12/TareaPOO.git
    ```

### Cómo Ejecutar la Aplicación

Puedes ejecutar la aplicación desde un IDE como Eclipse o directamente desde la línea de comandos.

**Opción 1: Ejecutar desde un IDE (Recomendado)**

1.  Abre Eclipse (o tu IDE de preferencia).
2.  Ve a `File > Import...`.
3.  Selecciona `General > Existing Projects into Workspace` y haz clic en `Next`.
4.  En `Select root directory`, busca la carpeta del proyecto que acabas de clonar.
5.  Asegúrate de que el proyecto esté seleccionado y haz clic en `Finish`.
6.  En el explorador de paquetes, navega a `src/poo/`.
7.  Haz clic derecho en el archivo `PruebaSistemaFuncional.java` y selecciona `Run As > Java Application`.

**Opción 2: Ejecutar desde la Línea de Comandos**

1.  Abre una terminal en la raíz del directorio del proyecto.
2.  **Compilar el código:**
    El siguiente comando compila todos los archivos `.java` que se encuentran en el paquete `uni1a`.

    ```bash
    javac -d . src/uni1a/*.java
    ```
    *Nota: Si el comando anterior da problemas, prueba compilando desde la carpeta `src`:*
    ```bash
    cd src
    javac uni1a/*.java
    cd ..
    ```

3.  **Ejecutar la clase principal:**
    Este comando ejecuta el método `main` de la clase `PruebaSistemaFuncional`, especificando que el classpath (`-cp`) es el directorio actual (`.`).

    ```bash
    java uni1a.PruebaSistemaFuncional
    ```

### Salida Esperada

Al ejecutar la aplicación, deberías ver en la consola un resumen detallado de todo el contenido audiovisual creado, incluyendo sus actores, temporadas, investigadores y artistas asociados, demostrando que todas las funcionalidades y relaciones se han implementado correctamente.
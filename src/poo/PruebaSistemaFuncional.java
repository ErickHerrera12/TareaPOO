// Archivo: src/poo/PruebaSistemaFuncional.java
package poo;

import uni1a.controller.SistemaController;

public class PruebaSistemaFuncional {
    public static void main(String[] args) {
        // Inicializamos el controlador que maneja todo el flujo MVC
        SistemaController app = new SistemaController();
        app.iniciar();
    }
}
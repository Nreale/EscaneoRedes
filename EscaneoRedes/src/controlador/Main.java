package controlador;

import vista.Vista;

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        new Controlador(vista);
        vista.setVisible(true);
    }
}

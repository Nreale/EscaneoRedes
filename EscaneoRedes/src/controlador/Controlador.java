package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Vista;

public class Controlador implements ActionListener {

    private Vista vista;

    public Controlador(Vista vista) {
        this.vista = vista;
        this.vista.establecerControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("Comenzar Escaneo")) {
            iniciarEscaneo();
        } else if (comando.equals("Limpiar")) {
            vista.limpiarResultados();
        } else if (comando.equals("Guardar Resultados")) {
            vista.agregarResultado("[SISTEMA] Guardando archivo de resultados...");
        }
    }

    private void iniciarEscaneo() {
        String ipInicio = vista.getIpInicio();
        String ipFin = vista.getIpFin();
        String timeoutStr = vista.getTimeout();

        // 1. Probar la validación de campos vacíos
        if (ipInicio.isEmpty() || ipFin.isEmpty() || timeoutStr.isEmpty()) {
            vista.mostrarError("Por favor, completa todos los campos.");
            return;
        }

        // 2. Simular lectura de datos y escritura en el JTextArea
        vista.agregarResultado("=== SIMULACIÓN DE ESCANEO DE RED ===");
        vista.agregarResultado("Probando rango: " + ipInicio + " -> " + ipFin);
        
        // 3. Simular resultados de IP (Datos simulados / Mock)
        vista.actualizarProgreso(25);
        vista.agregarResultado("IP: " + ipInicio + " | Host: Equipo-Prueba-1 | Estado: ACTIVO | Tiempo: 12 ms");
        
        vista.actualizarProgreso(75);
        vista.agregarResultado("IP: 192.168.1.2 | Host: Desconocido | Estado: INACTIVO | Tiempo: N/A");
        
        vista.actualizarProgreso(100);
        vista.agregarResultado("=== ESCANEO FINALIZADO ===");
    }
}

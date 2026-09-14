package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Vista extends JFrame implements ActionListener {

    private JTextField txtIpInicio;
    private JTextField txtIpFin;
    private JTextField txtTimeout;
    private JButton btnEscanear;
    private JButton btnLimpiar;
    private JButton btnGuardar;
    private JTextArea txtResultados;
    private JProgressBar barraProgreso;

    public Vista() {
        setTitle("Escaner de Red");
        setSize(750, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 5, 5));

        panelFormulario.add(new JLabel("IP Inicial:"));
        txtIpInicio = new JTextField("127.0.0.1");
        panelFormulario.add(txtIpInicio);

        panelFormulario.add(new JLabel("IP Final:"));
        txtIpFin = new JTextField("127.0.0.3");
        panelFormulario.add(txtIpFin);

        panelFormulario.add(new JLabel("Timeout (ms):"));
        txtTimeout = new JTextField("1000");
        panelFormulario.add(txtTimeout);

        add(panelFormulario, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel(new BorderLayout(5, 5));
        txtResultados = new JTextArea(12, 40);
        txtResultados.setEditable(false);
        JScrollPane scrollResultados = new JScrollPane(txtResultados);

        barraProgreso = new JProgressBar(0, 100);
        barraProgreso.setStringPainted(true);

        panelCentro.add(barraProgreso, BorderLayout.NORTH);
        panelCentro.add(scrollResultados, BorderLayout.CENTER);

        add(panelCentro, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());
        btnEscanear = new JButton("Comenzar Escaneo");
        btnLimpiar = new JButton("Limpiar");
        btnGuardar = new JButton("Guardar Resultados");

        panelBotones.add(btnEscanear);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnGuardar);

        add(panelBotones, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    public void establecerControlador(ActionListener controlador) {
        btnEscanear.addActionListener(controlador);
        btnLimpiar.addActionListener(controlador);
        btnGuardar.addActionListener(controlador);
    }

    public String getIpInicio() { return txtIpInicio.getText().trim(); }
    public String getIpFin() { return txtIpFin.getText().trim(); }
    public String getTimeout() { return txtTimeout.getText().trim(); }

    public void agregarResultado(String texto) { txtResultados.append(texto + "\n"); }

    public void limpiarResultados() { 
        txtResultados.setText(""); 
        barraProgreso.setValue(0);
    }

    public void actualizarProgreso(int porcentaje) { barraProgreso.setValue(porcentaje); }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
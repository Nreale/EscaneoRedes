package vista.proyec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setTitle("Escáner de Red");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 5, 5));
        
        
        panelFormulario.add(new JLabel("IP Inicial:"));
        txtIpInicio = new JTextField("");
        panelFormulario.add(txtIpInicio); 

        panelFormulario.add(new JLabel("IP Final:"));
        txtIpFin = new JTextField("");
        panelFormulario.add(txtIpFin);

        panelFormulario.add(new JLabel("Timeout (ms):"));
        txtTimeout = new JTextField("");
        panelFormulario.add(txtTimeout);

        add(panelFormulario, BorderLayout.NORTH);

        
        JPanel panelCentro = new JPanel(new BorderLayout(5, 5));
        txtResultados = new JTextArea(15, 40);
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

        btnEscanear.addActionListener(this);
        btnLimpiar.addActionListener(this);
        btnGuardar.addActionListener(this);

        panelBotones.add(btnEscanear);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnGuardar);

        add(panelBotones, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEscanear) {
            txtResultados.append("Iniciando escaneo desde " + txtIpInicio.getText() + "...\n");
        } else if (e.getSource() == btnLimpiar) {
            txtResultados.setText("");
            barraProgreso.setValue(0);
        }
    }

    public static void main(String[] args) {
        new Vista();
    }
}
package vista;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Vista extends JFrame implements ActionListener{
	
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
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Configuración del Escaneo"));
        
        panelFormulario.add(new JLabel("IP Inicial:"));
        txtIpInicio = new JTextField(""); 
        panelFormulario.add(txtIpInicio);
        
        panelFormulario.add(new JLabel("IP Final:"));
        txtIpFin = new JTextField("");
        panelFormulario.add(txtIpFin);

        panelFormulario.add(new JLabel("Timeout (ms):"));
        txtTimeout = new JTextField("1000");
        panelFormulario.add(txtTimeout);
        
        add(panelFormulario, BorderLayout.NORTH);
        setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
	    new Vista();
	}		 
	
}

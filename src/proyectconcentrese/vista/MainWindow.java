package proyectconcentrese.vista;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import proyectconcentrese.controller.Controller;

public class MainWindow extends JFrame{
	
	//private static final long serialVersionUID = 1L;
	private PanelCartas panelCartas;
	private JButton jBReiniciar, jBMostrar;

	public MainWindow(Controller c,String[][] m, int aciertos, int vidas){
		init(c,m);
		this.setSize(700,750);
    	this.setLayout(null);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setLocationRelativeTo(null);
    	this.setTitle("Concentrese");
    	ImageIcon aux = new ImageIcon(getClass().getResource("/img/icomoon_e634(0)_32.png"));
    	this.setIconImage(aux.getImage());
		initContadores(aciertos, vidas);
		this.setVisible(true);
	}
	
	public void init(Controller control, String[][] m) {
    	panelCartas = new PanelCartas(m,control);
    	panelCartas.setBounds(5, 90, 675, 525);
    	    	
    	jBReiniciar = new JButton("Reiniciar Partida");
    	jBReiniciar.setBounds(5,620,675,40);
    	jBReiniciar.addActionListener(control);
    	jBReiniciar.setActionCommand("Reiniciar Partida");
        jBReiniciar.setBorder(new LineBorder(Color.BLACK, 2));
    	
    	jBMostrar = new JButton("Mostrar Tablero");
    	jBMostrar.setBounds(5,665,675,40);
    	jBMostrar.addActionListener(control);
    	jBMostrar.setActionCommand("Mostrar Tablero");
        jBMostrar.setBorder(new LineBorder(Color.BLACK, 2));
    	
    	this.add(panelCartas);
    	this.add(jBReiniciar);
    	this.add(jBMostrar);
	}
	
	public void initContadores(int aciertos, int vidas){
		JLabel lAciertos = new JLabel("Aciertos:");
		lAciertos.setBounds(10, 0, 330, 40);
		lAciertos.setBackground(Color.GRAY);
		lAciertos.setBorder(new LineBorder(Color.BLACK,4));
		
		JLabel lVidas = new JLabel("Vidas Restastes:");
		lVidas.setBounds(10, 45, 330, 40);
		lVidas.setBackground(Color.GRAY);
		lVidas.setBorder(new LineBorder(Color.BLACK,4));
		
		JTextField jTAcierto = new JTextField(""+aciertos);
		jTAcierto.setBounds(345, 0, 330, 40);
		jTAcierto.setBorder(new LineBorder(Color.BLACK,4));
                jTAcierto.setEditable(false);
		
		JTextField jTVidas = new JTextField(""+vidas);
		jTVidas.setBounds(345, 45, 330, 40);
		jTVidas.setBorder(new LineBorder(Color.BLACK,4));
                jTVidas.setEditable(false);
		
		this.add(lAciertos);
		this.add(lVidas);  
		this.add(jTAcierto);
		this.add(jTVidas);
	}

	
}

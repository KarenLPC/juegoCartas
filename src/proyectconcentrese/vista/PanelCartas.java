package proyectconcentrese.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import proyectconcentrese.controller.Controller;


public class PanelCartas extends JPanel implements ActionListener{

	//private static final long serialVersionUID = 1L;
	private JButton xD1, xD2, xD3, xD4, xD5, xD6, xD7, xD8, xD9, xD10, xD11, xD12;
	private String[][] matrizAux;
	private String[] listaOpciones;
	public int opcionA;
	public int opcionB;
	public boolean empezoJugada;
	public ImageIcon back;
	private JButton jBopcionA;
	private JButton jBopcionB;
	private Controller c;
	private int contadorW;

	public PanelCartas(String[][] matriz, Controller c) {
		this.setBackground(Color.WHITE);
		this.c = c;
		contadorW = 0;
		listaOpciones = new String[12];
		empezoJugada = false;
		opcionA = -1;
		opcionB = -1;
		this.setLayout(null);
		matrizAux = matriz;
		this.init();
		int cont = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				listaOpciones[cont] = matriz[i][j];
				cont++;
			}
		}
	}
	
	public void init(){
		back = new ImageIcon(getClass().getResource("/img/Back.jpg"));
		xD1 = new JButton();
    	xD1.setIcon(back);
    	xD1.setBounds(0, 0, 168, 175);
    	xD1.setBorder(new LineBorder(Color.BLACK,2));
    	xD1.setActionCommand("0");
    	xD1.addActionListener(this);
    	this.add(xD1);
    	
    	xD2 = new JButton();
		xD2.setIcon(back);
		xD2.setBounds(169, 0, 168, 175);
		xD2.setBorder(new LineBorder(Color.BLACK,2));
		xD2.setActionCommand("1");
    	xD2.addActionListener(this);
    	this.add(xD2);
    	
    	xD3 = new JButton();
		xD3.setIcon(back);
		xD3.setBounds(337, 0, 168, 175);
		xD3.setBorder(new LineBorder(Color.BLACK,2));
		xD3.setActionCommand("2");
    	xD3.addActionListener(this);
    	this.add(xD3);
    	
    	xD4 = new JButton();
		xD4.setIcon(back);
		xD4.setBounds(504, 0, 168, 175);
		xD4.setBorder(new LineBorder(Color.BLACK,2));
		xD4.setActionCommand("3");
    	xD4.addActionListener(this);
    	this.add(xD4);
    	
    	xD5 = new JButton();
		xD5.setIcon(back);
		xD5.setBounds(0, 175, 168, 175);
		xD5.setBorder(new LineBorder(Color.BLACK,2));
		xD5.setActionCommand("4");
    	xD5.addActionListener(this);
    	this.add(xD5);
    	
    	xD6 = new JButton();
		xD6.setIcon(back);
		xD6.setBounds(169, 175, 168, 175);
		xD6.setBorder(new LineBorder(Color.BLACK,2));
		xD6.setActionCommand("5");
    	xD6.addActionListener(this);
    	this.add(xD6);
    	
    	xD7 = new JButton();
		xD7.setIcon(back);
		xD7.setBounds(337, 175, 168, 175);
		xD7.setBorder(new LineBorder(Color.BLACK,2));
		xD7.setActionCommand("6");
    	xD7.addActionListener(this);
    	this.add(xD7);
    	
    	xD8 = new JButton();
		xD8.setIcon(back);
		xD8.setBounds(504, 175, 168, 175);
		xD8.setBorder(new LineBorder(Color.BLACK,2));
		xD8.setActionCommand("7");
    	xD8.addActionListener(this);
    	this.add(xD8);
    	
    	xD9 = new JButton();
		xD9.setIcon(back);
		xD9.setBounds(0, 350, 168, 175);
		xD9.setBorder(new LineBorder(Color.BLACK,2));
		xD9.setActionCommand("8");
    	xD9.addActionListener(this);
    	this.add(xD9);
    	
    	xD10 = new JButton();
		xD10.setIcon(back);
		xD10.setBounds(169, 350, 168, 175);
		xD10.setBorder(new LineBorder(Color.BLACK,2));
		xD10.setActionCommand("9");
    	xD10.addActionListener(this);
    	this.add(xD10);
    	
    	xD11 = new JButton();
		xD11.setIcon(back);
		xD11.setBounds(337, 350, 168, 175);
		xD11.setBorder(new LineBorder(Color.BLACK,2));
		xD11.setActionCommand("10");
    	xD11.addActionListener(this);
    	this.add(xD11);
    	
    	xD12 = new JButton();
		xD12.setIcon(back);
		xD12.setBounds(504, 350, 168, 175);
		xD12.setBorder(new LineBorder(Color.BLACK,2));
		xD12.setActionCommand("11");
    	xD12.addActionListener(this);
    	this.add(xD12);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("0")) {
			ImageIcon aux = new ImageIcon(getClass().getResource("/img/"+matrizAux[0][0]+".jpg"));
			xD1.setIcon(aux);
			this.revalidate();
			if(empezoJugada == false) {
				opcionA = 0;
				empezoJugada = true;
				jBopcionA = xD1;
			}else {
				opcionB = 0;
				jBopcionB = xD1;
				comprobarRepuestas();
				comprobarFinal();
			}
		}else if(e.getActionCommand().equals("1")){
			ImageIcon aux = new ImageIcon(getClass().getResource("/img/"+matrizAux[0][1]+".jpg"));
			xD2.setIcon(aux);
			this.revalidate();
			if(empezoJugada == false) {
				opcionA = 1;
				empezoJugada = true;
				jBopcionA = xD2;
			}else {
				opcionB = 1;
				jBopcionB = xD2;
				comprobarRepuestas();
				comprobarFinal();
			}
		}else if(e.getActionCommand().equals("2")) {
			ImageIcon aux = new ImageIcon(getClass().getResource("/img/"+matrizAux[0][2]+".jpg"));
			xD3.setIcon(aux);
			this.revalidate();
			if(empezoJugada == false) {
				opcionA = 2;
				empezoJugada = true;
				jBopcionA = xD3;
			}else {
				opcionB = 2;
				jBopcionB = xD3;
				comprobarRepuestas();
				comprobarFinal();
			}
		}else if(e.getActionCommand().equals("3")) {
			ImageIcon aux = new ImageIcon(getClass().getResource("/img/"+matrizAux[0][3]+".jpg"));
			xD4.setIcon(aux);
			this.revalidate();
			if(empezoJugada == false) {
				opcionA = 3;
				empezoJugada = true;
				jBopcionA = xD4;
			}else {
				opcionB = 3;
				jBopcionB = xD4;
				comprobarRepuestas();
				comprobarFinal();
			}
		}else if(e.getActionCommand().equals("4")) {
			ImageIcon aux = new ImageIcon(getClass().getResource("/img/"+matrizAux[1][0]+".jpg"));
			xD5.setIcon(aux);
			if(empezoJugada == false) {
				opcionA = 4;
				empezoJugada = true;
				jBopcionA = xD5;
			}else {
				opcionB = 4;
				jBopcionB = xD5;
				comprobarRepuestas();
				comprobarFinal();
			}
			this.revalidate();
		}else if(e.getActionCommand().equals("5")) {
			ImageIcon aux = new ImageIcon(getClass().getResource("/img/"+matrizAux[1][1]+".jpg"));
			xD6.setIcon(aux);
			this.revalidate();
			if(empezoJugada == false) {
				opcionA = 5;
				empezoJugada = true;
				jBopcionA = xD6;
			}else {
				opcionB = 5;
				jBopcionB = xD6;
				comprobarRepuestas();
				comprobarFinal();
			}
		}else if(e.getActionCommand().equals("6")) {
			ImageIcon aux = new ImageIcon(getClass().getResource("/img/"+matrizAux[1][2]+".jpg"));
			xD7.setIcon(aux);
			this.revalidate();
			if(empezoJugada == false) {
				opcionA = 6;
				empezoJugada = true;
				jBopcionA = xD7;
			}else {
				opcionB = 6;
				jBopcionB = xD7;
				comprobarRepuestas();
				comprobarFinal();
			}
		}else if(e.getActionCommand().equals("7")) {
			ImageIcon aux = new ImageIcon(getClass().getResource("/img/"+matrizAux[1][3]+".jpg"));
			xD8.setIcon(aux);
			this.revalidate();
			if(empezoJugada == false) {
				opcionA = 7;
				empezoJugada = true;
				jBopcionA = xD8;
			}else {
				opcionB = 7;
				jBopcionB = xD8;
				comprobarRepuestas();
				comprobarFinal();
			}
		}else if(e.getActionCommand().equals("8")) {
			ImageIcon aux = new ImageIcon(getClass().getResource("/img/"+matrizAux[2][0]+".jpg"));
			xD9.setIcon(aux);
			this.revalidate();
			if(empezoJugada == false) {
				opcionA = 8;
				empezoJugada = true;
				jBopcionA = xD9;
			}else {
				opcionB = 8;
				jBopcionB = xD9;
				comprobarRepuestas();
				comprobarFinal();
			}
		}else if(e.getActionCommand().equals("9")) {
			ImageIcon aux = new ImageIcon(getClass().getResource("/img/"+matrizAux[2][1]+".jpg"));
			xD10.setIcon(aux);
			this.revalidate();
			if(empezoJugada == false) {
				opcionA = 9;
				empezoJugada = true;
				jBopcionA = xD10;
			}else {
				opcionB = 9;
				jBopcionB = xD10;
				comprobarRepuestas();
				comprobarFinal();
			}
		}else if(e.getActionCommand().equals("10")) {
			ImageIcon aux = new ImageIcon(getClass().getResource("/img/"+matrizAux[2][2]+".jpg"));
			xD11.setIcon(aux);
			this.revalidate();
			if(empezoJugada == false) {
				opcionA = 10;
				empezoJugada = true;
				jBopcionA = xD11;
			}else {
				opcionB = 10;
				jBopcionB = xD11;
				comprobarRepuestas();
				comprobarFinal();
			}
		}else if(e.getActionCommand().equals("11")) {
			ImageIcon aux = new ImageIcon(getClass().getResource("/img/"+matrizAux[2][3]+".jpg"));
			xD12.setIcon(aux);
			this.revalidate();
			if(empezoJugada == false) {
				opcionA = 11;
				empezoJugada = true;
				jBopcionA = xD12;
			}else {
				opcionB = 11;
				jBopcionB = xD1;
				comprobarRepuestas();
				comprobarFinal();
			}
		}
	}
	
	public void comprobarRepuestas(){
		if(listaOpciones[opcionA] == listaOpciones[opcionB]) {
			JOptionPane.showMessageDialog(null, "La combinación es Correcta. Sigue Así :D");
			empezoJugada = false;
			opcionA = -1;
			opcionB = -1;
			c.setAciertos(c.getAciertos()+1);
			c.refrescarDatos();
			contadorW++;
		}else {
			empezoJugada = false;
			opcionA = -1;
			opcionB = -1;
			JOptionPane.showMessageDialog(null, "Lo siento ha fallado");
			jBopcionA.setIcon(back);
			jBopcionB.setIcon(back);
			c.setVidas(c.getVidas()-1);
			c.refrescarDatos();
		}
	}

	public void comprobarFinal() {
		if(contadorW == 6) {
			JOptionPane.showMessageDialog(null, "Ha completado todas las combinaciones. \n Felicidades");
			c.reiniciarPartida();
		}
	}
}

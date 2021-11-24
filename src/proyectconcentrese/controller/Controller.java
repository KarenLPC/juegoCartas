package proyectconcentrese.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import proyectconcentrese.model.Logic;
import proyectconcentrese.vista.MainWindow;

public class Controller implements ActionListener{
	
	public MainWindow mainWindow;
	public Logic logica;
	public int aciertos = 0;
	public int vidas = 6;
	
	public Controller() {
		logica = new Logic();
		mainWindow = new MainWindow(this, logica.getMatriz(),aciertos, vidas);
	}

	public void mostrarMatriz() {
		System.out.println("Mostrar Tablero.");
		System.out.println("Salida:\n");
		System.out.println("Tablero Revelado:");
		for (int i = 0; i < logica.getMatriz().length; i++) {
			for (int j = 0; j < logica.getMatriz()[i].length; j++) {
				System.out.print(logica.getMatriz()[i][j]+" | ") ;
			}
			System.out.println("\n----+----+----+----");
		}
	}
	
	public void refrescarDatos() {
		if(vidas>=1) {
			mainWindow.initContadores(aciertos,vidas);
		}else {
			JOptionPane.showMessageDialog(null, "Ha acabado el juego. Suerte para la Proxima");
			System.exit(1);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Mostrar Tablero")) {
			mostrarMatriz();
		}else if(e.getActionCommand().equals("Reiniciar Partida")){
			reiniciarPartida();
		}
	}
	
	public void reiniciarPartida() {
		aciertos = 0;
		logica.rellenarMatriz();
		vidas = 6;
		//mainWindow.dispose();
		JOptionPane.showMessageDialog(null, "Bienvenido a una nueva partida");
		mainWindow = new MainWindow(this, logica.getMatriz(), aciertos, vidas);
	}

	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getAciertos() {
		return aciertos;
	}

	public int getVidas() {
		return vidas;
	}

}

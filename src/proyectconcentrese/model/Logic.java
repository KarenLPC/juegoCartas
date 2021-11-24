package proyectconcentrese.model;

import java.util.ArrayList;
import java.util.Random;

public class Logic{
	
	private String[][] matriz;
	private String[] auxM;
		
	public Logic(){
		matriz = new String[3][4];
		auxM = new String[52];
		auxM[0] = "2_C"; auxM[1] = "2_D"; auxM[2] = "2_H"; auxM[3] = "2_S"; auxM[4] = "3_C"; auxM[5] = "3_D";
		auxM[6] = "3_H"; auxM[7] = "3_S"; auxM[8] = "4_C"; auxM[9] = "4_D"; auxM[10] = "4_H"; auxM[11] = "4_S";
		auxM[12] = "5_C"; auxM[13] = "5_D"; auxM[14] = "5_H"; auxM[15] = "5_S"; auxM[16] = "6_C"; auxM[17] = "6_D";
		auxM[18] = "6_H"; auxM[19] = "6_S"; auxM[20] = "7_C"; auxM[21] = "7_D"; auxM[22] = "7_H"; auxM[23] = "7_S";
		auxM[24] = "8_C"; auxM[25] = "8_D"; auxM[26] = "8_H"; auxM[27] = "8_S"; auxM[28] = "9_C"; auxM[29] = "9_D";
		auxM[30] = "9_H"; auxM[31] = "9_S"; auxM[32] = "10_C"; auxM[33] = "10_D"; auxM[34] = "10_H"; auxM[35] = "10_S";
		auxM[36] = "A_C"; auxM[37] = "A_D"; auxM[38] = "A_H"; auxM[39] = "A_S"; auxM[40] = "J_C"; auxM[41] = "J_D";
		auxM[42] = "J_H"; auxM[43] = "J_S"; auxM[44] = "K_C"; auxM[45] = "K_D"; auxM[46] = "K_H"; auxM[47] = "K_S";
		auxM[48] = "Q_C"; auxM[49] = "Q_D"; auxM[50] = "Q_H"; auxM[51] = "Q_S";
		rellenarMatriz();
	}
	
	public void rellenarMatriz() {
		String[] aux = new String[12];
		String[] aux2 = generarCartasAleatorias();
		for (int i = 0; i < aux.length; i++) {
			if(i<=5) {
				aux[i] = aux2[i];
			}else {
				aux[i] = aux[i-6];
			}
		}
		int[] x = generarAleatoriosSinRepetir();
		int count = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = aux[x[count]];
				count++;
			}
		}
	}
	
	private int[] generarAleatoriosSinRepetir() {
		ArrayList<Integer> numbers = new ArrayList<>(12);
		int[] val = new int[12];
		int count = 0;
		for (int i=0;i<12;i++){
		   numbers.add(i);
		}
		Random random = new Random();
		while (numbers.size()>0){
		   int randomIndex = random.nextInt(numbers.size());
		   val[count] = numbers.get(randomIndex);
		   count++;
		   numbers.remove(randomIndex);
		}
		
		return val;
	}

	private String[] generarCartasAleatorias() {
		ArrayList<Integer> numbers = new ArrayList<>(52);
		String[] letras = new String[6];
		int count = 0;
		for (int i=0;i<52;i++){
		   numbers.add(i);
		}
		Random random = new Random();
		while (numbers.size()>0 && count<6){
		   int randomIndex = random.nextInt(numbers.size());
		   letras[count] = auxM[random.nextInt(numbers.size())];
		   count++;
		   numbers.remove(randomIndex);
		}
		return letras;
	}
	
	public String[][] getMatriz(){
		return matriz;
	}
}

package prova;
import java.util.Scanner;
public class provateste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		int i, j, matriz[][] = new int[40][40];
		int vetor[] = new int[1600];
		int posicao;
		double porcentagem, contador=0;
	//A) colocar zero em ambas diagonais da matriz
		for (i = 0; i < 40; i++) {
		     for (j = 0; j < 40; j++) {
		    	 if (j == i) {
		   		 		matriz[i][j] = 0;
		   		 		matriz[i][40 - j - 1] = 0;
		    	 } else {
	//c) matriz[i][j]seja igual i+j		    		 
		    		 	matriz[i][j] = i + j;
		    	 }
		     }
		}

		for (i = 0; i < 40; i++) {
			for (j = 0; j < 40; j++) {
				if (j == i) {
					matriz[i][j] = 0;
					matriz[i][40 - j - 1] = 0;
				}
				System.out.print(matriz[i][j] + " | ");

			}
			System.out.println("");
		}
		System.out.println();
	//b) porcentagem de numeros maiores que 10 na matriz 
		for (i = 0; i < 40; i++) {
			for (j = 0; j < 40; j++) {
				if (matriz[i][j] > 10) {
					contador = contador + 1;
				}
			}
		}
		porcentagem = (contador / 1600)*100;
		System.out.println(" porcentagem de num maiores que 10 : " + porcentagem);
		System.out.println("");
		System.out.println("");
	//d) 
		for (i = 0; i < 40; i++) {
			for (j = 0; j < 40; j++) {
				if (j == i) {
					matriz[i][j] = i + 1;
				}
				System.out.print(matriz[i][j] + " | ");
			}
			System.out.println("");
		}
	//e) copie los elementos de la matriz MAT para un vector V[80].		
		posicao = 0;
		for (i = 0; i < 40; i++) {
			for (j = 0; j < 40; j++) {
				vetor[posicao] = matriz[i][j];
				posicao = posicao + 1;
			}
		}
		System.out.println("");
		System.out.println("");

	//f) Copiar os elementos da matriz para um vetor de[80]
		for (i = 0; i < 1600; i++) {
			System.out.print(vetor[i] + " ");
		}

	}





	

	

}

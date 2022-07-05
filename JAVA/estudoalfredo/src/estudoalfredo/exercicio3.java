package estudoalfredo;

import java.util.Random;

public class exercicio3 {

	public static void main(String[] args) {
int[][] numerosaleatorios = new int [10] [10];
        
		Random numeroRandom = new Random();
	for (int i=0; i<numerosaleatorios.length; i++) {
		for (int j=0; j<numerosaleatorios[i].length; j++) {
			numerosaleatorios[i][j] = numeroRandom.nextInt(100);
		}
	}
	for (int i=0; i<numerosaleatorios.length; i++) {
		for (int j=0; j<numerosaleatorios[i].length; j++) {
			System.out.print(numerosaleatorios[i][j] + " ");
			}
		System.out.println();
		}
	int maiorl5= 0;
	int menorl5= 101;
	int linha5= 5;
	for(int i=0; i<numerosaleatorios[linha5].length; i++) {
		if(numerosaleatorios[linha5][i]> maiorl5) {
			maiorl5 = numerosaleatorios[linha5] [i];
		}
		if(numerosaleatorios[linha5][i]< menorl5) {
	    menorl5 = numerosaleatorios[linha5][i];
		}
	}
	System.out.println("maior valor da linha 5 = " + maiorl5);
	System.out.println("menor valor da linha 5 = " + menorl5);
	int maiorc7 = 0;
	int menorc7 = 101;
	int col7 = 7;
	for(int i=0;i<numerosaleatorios.length;i++) {
		if (numerosaleatorios[i][col7]> maiorc7){
			maiorc7 = numerosaleatorios[i][col7];
		}
		if (numerosaleatorios[i][col7]< menorc7) {
			menorc7 = numerosaleatorios[i][col7];
		}
		}
	System.out.println("Maior valor da coluna 7 = " + maiorc7);
	System.out.println("Menor valor da coluna 7 = " + menorc7 );
	}

}

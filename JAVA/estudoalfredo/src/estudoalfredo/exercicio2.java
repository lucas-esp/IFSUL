package estudoalfredo;
import java.util.Random;
public class exercicio2 {

	public static void main(String[] args) {
		
		int[][] numerosaleatorios = new int [4] [4];
        
		Random numeroRandom = new Random();
	for (int i=0; i<numerosaleatorios.length; i++) {
		for (int j=0; j<numerosaleatorios[i].length; j++) {
			numerosaleatorios[i][j] = numeroRandom.nextInt(100);
		}
	}
	int maior = 0;
	int linha= 0;
	int col= 0;
	for (int i=0; i<numerosaleatorios.length; i++) {
		for (int j=0; j<numerosaleatorios[i].length; j++) {
			if(numerosaleatorios[i][j]>maior){
				maior = numerosaleatorios[i][j];
				linha= i;
				col = j;
			}
		}
	}
	for (int i=0; i<numerosaleatorios.length; i++) {
		for (int j=0; j<numerosaleatorios[i].length; j++) {
			System.out.print(numerosaleatorios[i][j] + " ");
			}
		System.out.println();
		}
	System.out.println("maior valor=" + maior);
	System.out.println("linha = " + linha);
	System.out.println("Coluna = " + col);
	}

}

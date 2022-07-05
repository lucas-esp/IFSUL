package estudoalfredo;
import java.util.Random;
public class testa {
	
	public static void main(String[] args) {
		Random numero = new Random();
		int [][] matriz = new int [5][5];
		int [] vetor = new int [25];
		int [] vetorc = new int [25];
		int x= 0;
		int c= 0;
		for(int i=0; i<matriz.length; i++) {
			for(int j=0;j<matriz[i].length;j++) {
			matriz[i][j] = numero.nextInt(10);
			}
			}
			
		for(int i=0; i<matriz.length; i++) {
			for(int j=0;j<matriz[i].length;j++) {
			System.out.print(matriz[i][j] + " ");
			}
	System.out.println();
	}
		
		for(int i=0; i<matriz.length; i++) {
			for(int j=0;j<matriz[i].length;j++) {
			vetor [x] = matriz[i][j]; 
			x++;
			}
	}
     for(x=0 ; x<vetor.length; x++){
		System.out.print(vetor[x] + " ");    
     }
    for( x=25; c>=0; c--) {
    	vetorc[c] = vetor[x];
    	c++;
    	System.out.print(vetorc[c] + " ");
    }
	}
}

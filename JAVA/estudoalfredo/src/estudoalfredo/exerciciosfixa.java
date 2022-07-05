
package estudoalfredo;
import java.util.Scanner;

public class exerciciosfixa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mes, dias = 31;
		Scanner entrada = newScanner(System.in);
		System.out.print("Digite o Mes [1-12]:");
		mes = entrada.nextint();
		if(mes>12 && mes<1) {
			System.out.println("Mes invalido");
			return;
		}
				switch(mes){
					case 2:
						dias -=2;
					case 4: case 5: case 9: case 11:
						dias --;
				}

	}

}

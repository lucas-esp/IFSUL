package prova;

import java.util.Scanner;

public class menusao {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0;
		Scanner input = new Scanner(System.in);
		System.out.println("Escolha uma das opções abaixo: \n 1 - Palindromo \n 2 - Banco \n 3- Piramide \n 4 - Sair do programa");
        a = input.nextInt();
	if(a == 1) {
         prova.palin classe = new prova.palin();
         palin.main(args);
	
	} if( a==2 ) {
		prova.banco classe = new prova.banco();
		banco.main(args);
	}if(a == 3) {
		prova.piramide classe = new prova.piramide();
		piramide.main(args);
	}if(a == 4){
		System.out.print("até mais\n");
		input.close();
	}
	}
}



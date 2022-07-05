package exercicios1;
import java.util.Scanner;
public class retomada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		System.out.print("Escreva dois numeros aleatórios\n");
		int num1 = ler.nextInt();
		int num2 = ler.nextInt();
		if (num1 > num2) {
			System.out.print("o numero maior eh num1\n"+ num1);
			
		}
		if(num2>num1) {
			System.out.print("o numero maior eh o \n" + num2 );
		}
		if(num1 == num2){
			System.out.print("os numeros sao iguais\n");
		}
		String word1 = "";
		Scanner word = new Scanner(System.in);
		System.out.print("Digite uma palavra\n");
		word1 = word.next();
		System.out.println(word1.length());
		System.out.println("a primeira letra eh : "+ word1.charAt(0));
		System.out.println("ultima letra da palavra: " + word1.substring(word1.length()-1));
		System.out.println(word1.toUpperCase());
		String word3 = "";
		word3=word1.replace("a", "A");
		word3=word1.replace("e", "E");
		word3=word1.replace("i", "I");
		word3=word1.replace("o", "O");
		word3=word1.replace("u", "U");
		System.out.println(word3);
		String revert = "";
		for (int b=word1.length()-1; b>=0;b--) {
			revert += String.valueOf(word1.charAt(b));
			}
		System.out.println(revert);
		
	}


	
}

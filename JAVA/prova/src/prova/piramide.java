package prova;
import java.util.Scanner;

public class piramide {
	public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String frase;

        System.out.println("Digite uma string: ");
        frase = input.nextLine();
        String espaco = frase.replaceAll(" ","");
        for (int i = 0; i < frase.length(); i++) {
            
            System.out.println(frase.substring(0, i));
        }
         for(int x= 0; x<espaco.length(); x++) {
            System.out.println(espaco.substring(x,espaco.length()));
        }
	
        input.close();
	}
}


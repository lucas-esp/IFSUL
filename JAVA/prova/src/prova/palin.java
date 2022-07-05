package prova;

import java.util.Scanner;

public class palin {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String data;

        System.out.println("Escreva uma data nesse formato: (Formato:m/dd/aa)");
        data = input.nextLine();
        data = data.replace("/", "");

        if (palindromo(data)) {
            System.out.println("eh um palindromo");
        } else {
            System.out.println("nao eh um palindromo");
        }

        input.close();
    }

    public static boolean palindromo(String teste) {

        int inicio = 0;
        int fin = teste.length() - 1;
        boolean x = true;

        while ((inicio < fin) && x) {

            if (teste.charAt(inicio) == teste.charAt(fin)) {
                inicio++;
                fin--;
            } else {
                x = false;
            }
        }

        if (x) {
            return true;
        } else {
            return false;
        }
    }
}
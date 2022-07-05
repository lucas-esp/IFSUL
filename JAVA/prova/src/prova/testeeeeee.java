package prova;


import java.io.Console;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Doadores_De_Sangue {

	
		

		public static void Doadores() {
			// TODO Auto-generated method stub
			
			 Scanner entrada = new Scanner(System.in);
			
			
			boolean avancar = false;
			
			
			System.out.println("Quantos doadores de sangue serão informados? ");
			Scanner input;
			int qtdedoadores = new Scanner(System.in).nextInt();
			String[] nome = new String[qtdedoadores];
			String[] sexo = new String[qtdedoadores];
			double[] peso = new double[qtdedoadores];
			int[] idade = new int[qtdedoadores];
			String[] tipo_s = new String[qtdedoadores];
			String[] fator = new String[qtdedoadores];
			int[] telefone = new int[qtdedoadores];


			System.out.println("Digite as informações do doador de sangue: ");

		
			
			for (int i = 0; i <qtdedoadores; i++) {
				System.out.println("Doador: " + i);

				
				avancar = false;
				while(!avancar) {
					try {
				System.out.println("Informe o nome: ");
				nome[i] = new Scanner(System.in).next();
				avancar = true;
					}catch(InputMismatchException e) {
					System.out.println("Informe apenas letras!");	
					}
					}
				
				avancar = false;
				while(!avancar) {
					try {
				System.out.println("Informe o sexo: 1 - feminino 2 - masculino");
				sexo[i] = new Scanner(System.in).next();
				avancar = true;
					}catch(InputMismatchException e) {
					System.out.println("Escolha somente uma das opções!");	
					}
					}
				
				avancar = false;
				while(!avancar) {
					try {
				System.out.println("Informe o peso: ");
				peso[i] = new Scanner(System.in).nextDouble();
				avancar = true;
					}catch(InputMismatchException e) {
					System.out.println("Informe somente números!");	
					}
					}
				
				avancar = false;
				while(!avancar) {
					try {
				System.out.println("Informe a idade: ");
				idade[i] = new Scanner(System.in).nextInt();
				avancar = true;
					}catch(InputMismatchException e) {
					System.out.println("Informe somente números: !");	
					}
					}
				
				avancar = false;
				while(!avancar) {
					try {
				System.out.println("Informe o tipo sanguíneo: ");
				tipo_s[i] = new Scanner(System.in).next();
				avancar = true;
					}catch(InputMismatchException e) {
					System.out.println("Escolha somente letras!");	
					}
					}
				
				avancar = false;
				while(!avancar) {
					try {
				System.out.println("Informe o fator: 1 - Positivo 2 - Negativo");
				fator[i] = new Scanner(System.in).next();
				avancar = true;
					}catch(InputMismatchException e) {
					System.out.println("Escolha somente uma das opções!");	
					}
					}
				
				avancar = false;
				while(!avancar) {
					try {
				System.out.println("Informe telefone: ");
				telefone[i] = new Scanner(System.in).nextInt();
				avancar = true;
					}catch(InputMismatchException e) {
					System.out.println("Informe somente números!");	
					}
					}
				
				System.out.println("---------------------------");


			
			}
			


			System.out.println("Escolha uma opção:");
			
			int opcao = 0;
			while (opcao!=3) {
			System.out.println("Digite 1 para buscar por tipo sanguíneo e fator");
	        System.out.println("Digite 2 para buscar por nome de doador ");
	        System.out.println("Digite 3 para sair");
	     
	        System.out.println("---------------------------");
	        opcao = entrada.nextInt();
	       
	    
	    	
			switch (opcao) {
			
			case 1:
			System.out.println("Opções de sangue - Informe um tipo: ");
			
			int opcao1 = 0;
			while (opcao!=4) {
			System.out.println("1 - A");
	        System.out.println("2 - B ");
	        System.out.println("3 - AB");
	        System.out.println("4 - O");
	        opcao1 = entrada.nextInt();

			for (int i = 0; i<qtdedoadores; i++) {
				System.out.println(tipo_s[i]);
				
	        	System.out.println("---------------------------");


			}
			}
			break;
			
		        
			
			
	        	case 2:
	    			System.out.println("Digite o nome do doador: ");
	    			for (int i = 0; i <qtdedoadores; i++) {
	    				System.out.println(i);
	    			}
	    			int x = new Scanner(System.in).nextInt();
					System.out.println("Nome: " + nome[x] + "\nSexo: " + sexo[x] + "\nPeso: " + peso[x] + "\nIdade: " + idade[x] + "\nTipo Sanguíneo: " + tipo_s[x] + "\nFator: " + fator[x] + "\nTelefone: " + telefone[x]);

	        	   
	        	    
				break;
			
			
				
				
			}
			
			
			
			}
			
			
			
			
			
		
	}
		
			
	}
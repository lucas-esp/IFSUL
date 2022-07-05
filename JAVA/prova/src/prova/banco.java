package prova;
import java.util.Scanner;
public class banco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		int contador=0;
		System.out.println("Digite o valor de contas que deseja criar:");
		
		int nconta = input.nextInt();
		String cont[] = new String [nconta];
		double saldo[] = new double [nconta];
		
				
		for (int i=0; i<nconta; i++ ) {
			System.out.println("Nome do cliente");
			cont[i] = input.next();
			System.out.println("saldo inicial");
			saldo[i] = input.nextDouble();
		}
	    
		Scanner input2 = new Scanner(System.in);
		
		while(contador!=1) {
		        System.out.println("--- Menu do Banco --- \n1 - Depositar  \n2 - Sacar  \n3 - Transferir  \n4 - Imprimir uma conta  \n5 - Imprimir todas as contas  \n6 - Sair ");
			    int num=input.nextInt(); 
		        int posi=0;
		        int posi2=0;
		        double valordep =0;
		        double valorsac =0;
		        double retir=0;
		        switch (num) {
		        case 1: 
		        	System.out.println("Informe o número da conta");	
		        	posi=input2.nextInt();
		        
		        	System.out.println("\nValor a Depositar");
		            valordep= input2.nextDouble();
		            saldo[posi]+=valordep;
		        	
		            System.out.println("\nSaldo atual " + saldo[posi]);
		        	break;
		        case 2:
		          System.out.println("Informe o número da conta");
		          posi=input2.nextInt();
		          System.out.println("\nValor a Sacar");
		          valorsac= input2.nextDouble();
		          if (valorsac > saldo[posi]) {
		        	  System.out.println("Saldo insuficiente");
		        	  break;
		          }
		          saldo[posi]-=valorsac;
		               
		          System.out.println("Saldo atual " + saldo[posi]);
		          break;
		          
		        case 3:
		        	System.out.println("Informe o ID da conta da conta de onde será retirado");
			        posi=input2.nextInt();
			        if (posi > nconta) {
			        	System.out.println("Número de conta Errado");
			        	break;
			        }
			        System.out.println("\nInforme o valor que será sacado");
			        retir=input2.nextInt();
			        if (retir > saldo[posi]) {
			        	  System.out.println("Saldo insuficiente");
			        	  break;
			        }	  
			        saldo[posi]-= retir;
			        System.out.println("\nInforme o número do ID da conta de onde será depositado");
			        posi2=input2.nextInt();
			        saldo[posi2]+=retir;
			        
			        System.out.println("\nConta do cliente: " + cont[posi] + " Saldo atual " + saldo[posi]);
			        System.out.println("\nConta do cliente: " + cont[posi2] + " Saldo atual " + saldo[posi2]);
			        
			        break;
		        case 4:
		        	System.out.println("Informe o ID da conta da conta");
			        posi=input2.nextInt();
		        	System.out.println("\nConta do cliente: " + cont[posi] + " Saldo atual " + saldo[posi]);
		            break;
		        
		        case 5:
			      for (int j=0; j<nconta; j++) {
			    	  System.out.println("\nConta do cliente: " + j + " Nome do cliente: " + cont[j] + " Saldo atual " + saldo[j]);
			      }
			    	  break;
		        case 6:
		        	contador=1;
		        	System.out.println("Encerrado");
		        	break;
		        }
        }
}
}
		

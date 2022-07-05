package exercicios1;

import java.util.Scanner;
public class exercicio1 {
	
	  public static void main(String[] args) {
	        // TODO Auto-generated method stub


	                String nome, telefone, email, tipoConta;
	                double documento;
	                double deposito=0,s;
	                boolean status;
	                Scanner input = new Scanner(System.in);

	                System.out.println("Insira os seguintes dados:"); 
	                try {
	                System.out.print("Digite seu nome\n");
	                nome = input.nextLine();
	                System.out.print("Sucesso\n");
	                System.out.print("Digite seu Telefone\n");
	                telefone = input.nextLine();
	                System.out.print("Sucesso\n");
	                System.out.print("Digite seu Email\n");
	                email = input.nextLine();
	                System.out.print("Sucesso\n");
	                System.out.print("Digite seu tipo de conta( corrente ou poupança)\n");
	                tipoConta = input.nextLine();
	                System.out.print("Sucesso\n");
	                System.out.print("Digite seu documento:\n");
	                documento = input.nextDouble();
	                System.out.print("Sucesso\n");
	                System.out.print("Digitel o quanto deseja depositar:\n");
	                deposito = input.nextDouble();
	                System.out.print("Sucesso\n");
	                
	                } catch (java.util.InputMismatchException e) {
	                    System.out.println("Recomece"+ e);
	                }
	                System.out.println("Digite o Status da Da Conta (true = ativada ou false = desativada)");
                    status=input.nextBoolean(); 
                 if(status == true) {
                  System.out.println("Ativada\n");
              }if(status == false) {
                  System.out.println("Desativada.");
                 
              }
	                
	                int random = 100 + (int) (Math.random() * 1000);
	                int x,din=0,a=0;
	                double trans=0,d=0,bol=0;
                    while(a!=1) {
	                System.out.println("Escolha uma opção: \n1 para Sacar  \n2 para Depositar \n3 para visualizar seu saldo \n4 para efetuar uma transferencia \n5 para Pagamentos \n6 para Sair");

	                x=input.nextInt();
	                switch (x) {
	                case 1:
	                  System.out.println("==Saque==\n Quanto deseja sacar:\n seu saldo atual:" + deposito);
	                  d = input.nextDouble();
	                  if(d<deposito) {
	                	  d=deposito-d;
	                	  System.out.println("Seu saldo atual:"+ d );
	                	  break;
	                  }else {
	                	  System.out.println("Saldo insuficiente\n");
	                	  break;
	                  }
	                  
	                case 2:
	                  System.out.println("==Deposito==\n Quanto deseja depositar:\n");
	                  d = input.nextInt();
	                  d = deposito + d;
	                  System.out.println("Novo saldo;"+ d);
	                		  break;
	                case 3:
	                  System.out.println("Saldo atual =" + deposito);
	                  break;
	                case 4:
	                  System.out.println("==Transferencia==\n Digite a conta para qual deseja transferir:\n");
	                  trans = input.nextDouble();
	                  System.out.println("Digite o valor para transferir:");
	                  d = input.nextDouble();
	                  
	                  if(d<deposito) {
	                	  d = deposito - d;
	                  System.out.println("Transferido com sucesso\n Seu novo saldo eh:"+ d);
	                  }else{
	                   System.out.println("saldo insuficiente");
	                	  break;
	                  }
	                  case 5:
	                  System.out.println("==Pagamento==\n Digite o numero do boleto:\n");
	                  bol = input.nextDouble();
	                  System.out.println("Digite o valor para transferir:");
	                  d = input.nextDouble();
	                  if(d<deposito) {
	                	  d = deposito - d;
	                  System.out.println("Boleto Pago");
	                  System.out.println("Transferido com sucesso\n Seu novo saldo eh:"+ d);
	                  }else{
	                   System.out.println("saldo insuficiente");
	                	  break;
	                  }
	                  break;
	                case 6:
	                    a=1;
	                	break;
	                	default:
	                		System.out.println("Numero errado, tente novamente");
	                }
	                }
}}
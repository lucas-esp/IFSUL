package prova;
import java.util.Scanner;
public class trabalhadores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		float x = 0; 
		float y = 0;
		float a = 600; 
		float resul = 0;
		float b = 8;
		int resultado = 0;
	System.out.println("Em 5 dias, um oper�rio produz 600 pe�as, trabalhando 8 horas di�rias. Se trabalhasse X horas por dia, quantos dias ele gostaria para produzir Y pe�as ?\n");
	System.out.println("Digite o numero de horas ");
	x = ler.nextFloat();
	System.out.println("Digite o numero de pe�as");
	y = ler.nextFloat();
	x = x*a;
	y = y*b;
	resul = 5*y;
	resul = resul/x;
	System.out.println("Resultado: "+ resul +"dias");	
	
	
	}

}

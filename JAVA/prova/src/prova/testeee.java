package prova;
import java.lang.Math;
import java.util.Scanner;
public class testeee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int quantidade;

		   int i;

		     System.out.print ("Digite a quantidade de alunos: ");

		   Scanner cadastroaluno = new Scanner (System.in);

		     quantidade = cadastroaluno.nextInt ();

		   int aluno[] = new int[quantidade];

		   double matricula[] = new double[quantidade];

		     System.out.println ("-----Cadastro de alunos----- ");

		   for (i = 0; i < quantidade; i++) //cadastro de matrC-cula

		     {

		System.out.print ("Digite a matricula do aluno " + (i+1) + ": ");

		Scanner matriculaaluno = new Scanner (System.in);

		  matricula[i] = matriculaaluno.nextDouble ();

		  aluno[i] = i;

		     }

		   System.out.println ("-----Sistema de avaliacao----- ");

		   

		   int validar;

		   do{

		   

		    validar = 0;

		   

		    System.out.print ("Digite a matricula do aluno: ");

		   

		    int validarmatricula;

		   

		    Scanner matriculaaluno = new Scanner (System.in);

		   

		    validarmatricula = matriculaaluno.nextInt ();

		   

		    for (i = 0; i < quantidade; i++){

		   

		        if (validarmatricula == matricula[i]){

		         double nota[] = new double[3];

		         double media;;

		         int j;

		         media = 0;

		       

		         for (j = 0; j < 3; j++) //cadastro de matrC-cula

		       

		           {

		       

		             System.out.print ("Digite a " + (j + 1) + "ª nota do aluno " + (i+1) + ": ");

		       

		             Scanner notaaluno = new Scanner (System.in);

		       

		             nota[j] = notaaluno.nextDouble();

		             

		             int k;

		             

		             media = media + nota[j];

		             

		           }

		           

		           media = media/3;

		           

		           System.out.println ("As notas do aluno " + (i+1) + " foram cadastradas com sucesso!");

		           System.out.println ("-----------RESULTADO-----------");

		           System.out.println (" A media do aluno " + (i+1) + " foi: " + media);

		           

		          

		           

		           i = quantidade;

		           

		           System.out.println("------------------------");

		           //System.out.println(" Novo lançamento/Correcao");

		           System.out.println("------------------------");

		           validar = 0;

		        }else{

		         validar = 1;

		     }

		  }

		     }while(validar == 0);

		     System.out.println(" MATRICULA INVÁLIDA. PROGRAMA FINALIZADO");

		 }

	
	

}

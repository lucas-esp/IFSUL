package trabeverto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.DirectoryStream;
import java.util.*;


public class Trabeverto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------Urna Eletronica---------);
        el();
	}
public static void el() throws IOException {
	Scanner ler = new Scanner(System.in);
	String currentDirectory = System.getProperty("dados.dir");
	 System.out.println("1 - Criar secao \n 2 - Listar eleitores \n 3 - Buscar secao \n 4 - Votar \n 5-Fechar Urna");
	 int el = ler.nextInt();
}
	 switch (el) {
     case 1:
         System.out.printf("Criando secao do eleitor ... aguarde \n");
         criarsecao();
         break;
     case 2:
         System.out.printf("Listando eleitores cadastrados..\n");
         listareleitor(currentDirectory);
         break;
     case 3:
         System.out.printf("Buscando secao... aguarde\n");
         buscarsecao();
         break;
     case 4:
         System.out.printf("Selecione seu candidato com sabedoria\n");
         votar(currentDirectory);
     case 5:
         System.exit(1);
         break;
     default:
         el();
         break;
     }

	 //criando a secao
	 public static void criarsecao() {
		  String nome = "", endereco = "";
	        int num = 0;
	        boolean bdb = false;
	        Scanner in = new Scanner(System.in);
	        
	        try {
	            System.out.print("nome:");
	            nome = in.nextLine();
	            System.out.print("Endereço:");
	            endereco = in.nextLine();
	            System.out.print("Numero da seção:");
	            num = in.nextInt();
	            bdb = true;
	        } catch (InputMismatchException e) {
	            System.out.println("tipo errado de dado: ");
	            Opt();
	        } catch (NoSuchElementException e) {
	            System.out.println("tu fez merda viste: ");
	            Opt();
	        } finally {



}
}

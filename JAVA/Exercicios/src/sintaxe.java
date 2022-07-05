import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class sintaxe {
	 
	public static void main(String[] args) {
		teste();
}
  public static void teste (){
	  ArrayList<String> palavras = new ArrayList<String>();
	  Scanner input = new Scanner (System.in);
	  System.out.println("Digite suas palavras:");
	  String x = input.Nextline();
	  
	  if((x.indexOf("sair")>=0) || (x.indexOf("salir")>=0)) {
		  System.out.println("Voce decidiu sair do programa\n");
		 
  }else {
	  palavras.add(x);
	 return;
  }
}
}
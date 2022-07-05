import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.DirectoryStream;
import java.util.*;

public class eleicoes {

    public static void main(String[] args) throws IOException {

        System.out.println(" - - - - - - - SISTEMINHA - - - - - - -");

        Opt();
    }

    public static void Opt() throws IOException {
        Scanner ler = new Scanner(System.in);
        String currentDirectory = System.getProperty("user.dir");

        System.out.println("1 - ler || 2 - Listar: || 3 - CRIAR || 4 - BUSCAR");
        int opt = ler.nextInt();

        switch (opt) {
        case 1:
            System.out.printf("LER \n\n");
            lerArquivo();
            break;
        case 2:
            System.out.printf("LISTANDO..\n\n");
            listarArquivo(currentDirectory);
            break;
        case 3:
            System.out.printf("criarSecao..\n\n");
            criarSecao();
            break;
        case 4:
            System.out.printf("bucar..\n\n");
            buscar(currentDirectory);
        case 5:
            System.exit(1);
            break;
        default:
            Opt();
            break;

        }
    }

    public static void criarSecao() throws IOException {
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

            if (bdb == true) {

                String currentDirectory = System.getProperty("user.dir");
                System.out.println("diretorio" + currentDirectory);

                // File arq = new File(currentDirectory + "/" + num + "_" + nome + ".txt");
                // ----------------------------------------------------------------------------------
                String PATH = currentDirectory + "/";
                Path lista_dir = Paths.get(currentDirectory + "/lista/");
                File arquivo = new File(currentDirectory + "/lista/" + num + "_" + nome + ".txt");
                try{

                    

                    if(!Files.exists(lista_dir)){
                        try {
                            System.out.println("criando diretorio...\n");
                            Files.createDirectories(lista_dir);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                        if(!arquivo.exists()) {
                            //cria um arquivo (vazio)
                            arquivo.createNewFile();
                        }
                            //caso seja um diretório, é possível listar seus arquivos e diretórios
                            // File[] arquivos = arquivo.listFiles();
                            //escreve no arquivo
                            FileWriter fw = new FileWriter(arquivo, true);
                            BufferedWriter bw = new BufferedWriter(fw);

                            System.out.println("Resgistrando eleitores || 1-registrar, 0-cancelar");
                            int action = in.nextInt();
                            
                            while(action != 0){
                                System.out.println("nome do eleitor");
                                String nomeeleitor = in.next();
                                System.out.println("documento do eleitor");
                                String documentoeleitor = in.next();
                                bw.write(nomeeleitor + ", " + documentoeleitor);
                                // gravarArq.printf(nomeeleitor + ", " + documentoeleitor + "\n");
                                bw.newLine();
                                System.out.println("Resgistrando eleitores || 1-registrar, 0-cancelar");
                                action = in.nextInt();
                            }                            
                            
                            bw.close();
                            fw.close();

                            } catch(IOException ex) {
                                    ex.printStackTrace();
                            }
            }

        }
        Opt();
        in.close();

    }

    public static void lerArquivo() throws IOException {
        Scanner ler = new Scanner(System.in);

        System.out.printf("Informe o nome de arquivo texto:\n");
        String nomedoarq = ler.nextLine();

        System.out.printf("\nConteúdo do arquivo texto:\n");
        try {
            String currentDirectory = System.getProperty("user.dir");
            FileReader arq = new FileReader(currentDirectory + "/lista/" + nomedoarq);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                System.out.printf("%s\n", linha);

                linha = lerArq.readLine(); // lê da segunda até a última linha
            }

            lerArq.close();
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        Opt();
    }

    public static void listarArquivo(String currentDirectory) throws IOException {

        Path path = Paths.get(currentDirectory + "/lista/");

        File file = new File(currentDirectory + "/lista/");
        File afile[] = file.listFiles();
        int i = 0;
        for (int j = afile.length; i < j; i++) {
            File arquivos = afile[i];
            // System.out.println(arquivos.getName());
            String name = arquivos.getName();
            if (name.lastIndexOf('.') == name.indexOf('.')){ 
                System.out.println(name.split("\\.")[0]);
            } 
        }

        Opt();
    }

    public static void buscar(String currentDirectory) throws IOException {
        
        Scanner lendo = new Scanner(System.in);
        System.out.println("entre com o nome ou doc do eleitor.. (sem grcinhas só aceito uma string)");
        String buneco = lendo.next();

        File file = new File(currentDirectory + "/lista/");
        File afile[] = file.listFiles();
        int i = 0;
        for (int j = afile.length; i < j; i++) {
            File arquivos = afile[i];
            // System.out.println(arquivos.getName());
            String nomedoarq = arquivos.getName();
            
            try {
                
                FileReader arq = new FileReader(currentDirectory + "/lista/" + nomedoarq);
                BufferedReader lerArq = new BufferedReader(arq);
    
                // String linha = lerArq.readLine();
                System.out.println("\t lendo "+nomedoarq+" \n");
                String s = "";
                String[] words=null;
                while((s=lerArq.readLine())!=null)   //Reading Content from the file
                {
                    words=s.split(" ");  //Split the word using space
                    for (String word : words) 
                    {
                            if (word.equals(buneco))   //Search for the given word
                            {
                            String extensionRemoved = nomedoarq.split("\\.")[0];
                            System.out.println("achei  aqui ó " + extensionRemoved);
                            }
                    }
                }
                lerArq.close();
                arq.close();
            } catch (IOException e) {
                System.err.printf("\nErro na abertura do arquivo: %s.\n", e.getMessage());
                Opt();
            }
        }

        Opt();
    }


}
package trabJDBC;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetRow;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class trabJDBC {

	private static final String email = null;

	public static void main(String[] args) throws IOException {
		Scanner ler = new Scanner(System.in);
		System.out.println("Login");
        System.out.println("Email");
        String email = ler.next();
        System.out.println("Password");
        String senha = ler.next();

        Login(email, senha);

    }

    public static void app() throws IOException {

        final String url = "jdbc:mysql://localhost/trabJDBC";
        Scanner ler = new Scanner(System.in);

        System.out.println("\n1 - Listar  2 - Criar \n 3 - Saida  4 - Buscar \n 5 - Entrada  6 - Excluir \n 7 - CriarCliente  8 - Sair");
        int app = ler.nextInt();

        switch (app) {
            case 1:
                System.out.printf("Loading ...\n");
                Listar(url);
                break;
            case 2:
                System.out.printf("Criando Produto..\n");
                Criar(url);
                break;
            case 3:
                System.out.printf("Saida..\n");
                Saida(url);
                break;
            case 4:
                System.out.printf("Buscar..\n");
                System.out.println("Digite o nome do produto");
                String str = ler.next();
                Buscar(url, str);
            case 5:
                System.out.printf("Entrada..\n");
                Entrada(url);
            case 6:
                System.out.printf("Exclusao..\n\n");
                Excluir(url);
            case 7:
                System.out.printf("Vamos ao cadastro..\n\n");
                CriarCliente(url);
            case 8:
                System.exit(1);
                break;
            default:
                app();
                break;

        }
    }

    public static void Listar(String url) throws IOException {
        final String sql = "Select * FROM produtos";
        try (
                Connection conexao = DriverManager.getConnection(url, "root", "");
                Statement statement = conexao.createStatement();            
                ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numeroColunas = metaData.getColumnCount();
            for (int i = 1; i <= numeroColunas; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            }
            System.out.println();
           
            while (resultSet.next()) {
                for (int i = 1; i <= numeroColunas; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();

            }
        } catch (SQLException e) {
            e.printStackTrace();
            app();
        }

        app();
    }

    public static void Criar(String url) throws IOException {
        final String sql = "Select * FROM produtos";

        String nome = "";
        int quant = 0;
        double preco = 0.0;

        try {
            Scanner ler = new Scanner(System.in);
            System.out.println("Nome do produto:");
            nome = ler.next();
            System.out.println("Quantidade do produto:");
            quant = ler.nextInt();
            System.out.println("Preco do produto:");
            preco = ler.nextDouble();

        } catch (Exception e) {
            System.out.println(e);
            Criar(url);
        }

        try {
            Connection conexao = DriverManager.getConnection(url, "root", "");
            PreparedStatement insert = (PreparedStatement) conexao.prepareStatement("INSERT INTO produtos(nome, quantidade, preco) VALUES (?,?,?)");
            insert.setString(1, nome);
            insert.setInt(2, quant);
            insert.setDouble(3, preco);

            int retorno = insert.executeUpdate();
            if (retorno > 0) {
                System.out.println("Sucesso");
            } else {
                System.out.println("Sem sucesso");
            }
            Statement select = conexao.createStatement();
            ResultSet resultSet = select.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numeroColunas = metaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= numeroColunas; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();

            }
            conexao.close();
            insert.close();
            select.close();
        } catch (SQLException e) {
            e.printStackTrace();
            app();
        }
        app();
    }

    public static void CriarCliente(String url) throws IOException {
        final String sql = "Select * FROM usuario";

        String nome = "";
        String email = "";
        String senha = "";

        try {
            Scanner ler = new Scanner(System.in);
            System.out.println("nome");
            nome = ler.next();
            System.out.println("email");
            email = ler.next();
            System.out.println("senha");
            senha = ler.next();

        } catch (Exception e) {
            System.out.println(e);
            CriarCliente(url);
        }

        try {
            Connection conexao = DriverManager.getConnection(url, "root", "");
            PreparedStatement insert = (PreparedStatement) conexao.prepareStatement("INSERT INTO usuario(nome, email, senha) VALUES (?,?,?)");
            insert.setString(1, nome);
            insert.setString(2, email);
            insert.setString(3, senha);
            int retorno = insert.executeUpdate();

            if (retorno > 0) {
                System.out.println("Sucesso");
            } else {
                System.out.println("Sem sucesso");
            }
            Statement select = conexao.createStatement();
            ResultSet resultSet = select.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numeroColunas = metaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= numeroColunas; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();
            }
            conexao.close();
            insert.close();
            select.close();
        } catch (SQLException e) {
            e.printStackTrace();
            app();
        }
        app();
    }

    public static void Saida(String url) throws IOException {
        int id = 0;
        int quant = 0;
        try {
            Scanner ler = new Scanner(System.in);
            System.out.println("ID do produto:");
            id = ler.nextInt();
            System.out.println("Quantidade do produto:");
            quant = ler.nextInt();

        } catch (Exception e) {
            System.out.println(e);
            Saida(url);
        }

        int qatual = QuantidadeAtual(url, id);

        if (quant > qatual) {
            System.out.println("Quantidade ultrapassa o estoque");
            quant = qatual;
            Saida(url);
        }

        try {
            final String sql = "Select * FROM produtos";
            Connection conexao = DriverManager.getConnection(url, "root", "");

            //� usado para criar um objeto que representa a instru��o SQL que ser� executada, sendo que � invocado atrav�s do objeto Connetion.
            PreparedStatement insert = (PreparedStatement) conexao.prepareStatement("UPDATE `produtos` SET `quantidade`= ? WHERE id = ?");

            int novaquantidade = (qatual - quant);

            insert.setInt(1, novaquantidade);
            insert.setInt(2, id);

            //retorna numero de linhas atualizadas
            int retorno = insert.executeUpdate();

            if (retorno > 0) {
                System.out.println("Sucesso");
            } else {
                System.out.println("Sem sucesso");
            }

            //seleciona todas as categorias do banco e imprime.
            Statement select = conexao.createStatement();
            ResultSet resultSet = select.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numeroColunas = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= numeroColunas; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();

            }

            //encerra as conex�es o objetos
            conexao.close();
            insert.close();
            select.close();
        } catch (SQLException e) {
            e.printStackTrace();
            app();
        }
        app();
    }

    public static void Entrada(String url) throws IOException {
        int id = 0;
        int quant = 0;

        try {
            Scanner ler = new Scanner(System.in);

            System.out.println("produto id");
            id = ler.nextInt();

            System.out.println("produto quantidade");
            quant = ler.nextInt();

        } catch (Exception e) {
            System.out.println(e);
        }

        int qa = QuantidadeAtual(url, id);

        try {
            final String sql = "Select * FROM produtos";
            Connection conexao = DriverManager.getConnection(url, "root", "");

            //� usado para criar um objeto que representa a instru��o SQL que ser� executada, sendo que � invocado atrav�s do objeto Connetion.
            PreparedStatement insert = (PreparedStatement) conexao.prepareStatement("UPDATE `produtos` SET `quantidade`= ? WHERE id = ?");

            int novaquantidade = (qa + quant);

            insert.setInt(1, novaquantidade);
            insert.setInt(2, id);

            //retorna numero de linhas atualizadas
            int retorno = insert.executeUpdate();

            if (retorno > 0) {
                System.out.println("Sucesso");
            } else {
                System.out.println("Sem sucesso");
            }

            //seleciona todas as categorias do banco e imprime.
            Statement select = conexao.createStatement();
            ResultSet resultSet = select.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numeroColunas = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= numeroColunas; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();

            }

            //encerra as conex�es o objetos
            conexao.close();
            insert.close();
            select.close();
        } catch (SQLException e) {
            e.printStackTrace();
            app();
        }
        app();
    }

    public static void Excluir(String url) throws IOException {
        int id = 0;
        try {
            Scanner ler = new Scanner(System.in);

            System.out.println("produto id");
            id = ler.nextInt();

        } catch (Exception e) {
            System.out.println(e);
            Excluir(url);
        }

        try {
            final String sql = "Select * FROM produtos";
            Connection conexao = DriverManager.getConnection(url, "root", "");

            //� usado para criar um objeto que representa a instru��o SQL que ser� executada, sendo que � invocado atrav�s do objeto Connetion.
            PreparedStatement insert = (PreparedStatement) conexao.prepareStatement("DELETE FROM `produtos` WHERE id = ?");

            insert.setInt(1, id);

            //retorna numero de linhas atualizadas
            int retorno = insert.executeUpdate();

            if (retorno > 0) {
                System.out.println("Sucesso");
            } else {
                System.out.println("Sem sucesso");
            }

            //seleciona todas as categorias do banco e imprime.
            Statement select = conexao.createStatement();
            ResultSet resultSet = select.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numeroColunas = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= numeroColunas; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();

            }

            //encerra as conex�es o objetos
            conexao.close();
            insert.close();
            select.close();
        } catch (SQLException e) {
            e.printStackTrace();
            app();
        }
        app();
    }

    public static int QuantidadeAtual(String url, int id) {

        int quantidade = 0;
        try {
            final String sql = "Select * FROM produtos where id = " + id;
            Connection conexao = DriverManager.getConnection(url, "root", "");
            Statement select = conexao.createStatement();
            ResultSet resultSet = select.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numeroColunas = metaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= numeroColunas; i++) {
//                    System.out.printf("%-8s\t", resultSet.getObject(i));
//                    System.out.println("ID: "+ resultSet.getInt("id"));
                    quantidade = resultSet.getInt("quantidade");
                }

            }
            conexao.close();
            select.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quantidade;
    }

    public static void Buscar(String url, String carro) throws IOException {
        String nome = "";
        String[] words = null;
        try {
            final String sql = "Select * FROM produtos where nome like '%" + carro + "%'";
            Connection conexao = DriverManager.getConnection(url, "root", "");
            Statement select = conexao.createStatement();
            ResultSet resultSet = select.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numeroColunas = metaData.getColumnCount();
            if (numeroColunas < 1) {
                System.out.println("sem retorno " + numeroColunas);
            }
            while (resultSet.next()) {
                for (int i = 1; i <= numeroColunas; i++) {
                    nome = resultSet.getString("nome");
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println("\n ");
            }

            conexao.close();
            select.close();
        } catch (SQLException e) {
            e.printStackTrace();
            app();
        }
        app();
    }

    public static void Login(String email, String senha) throws IOException {

        String email1 = "";
        String senha1 = "";
        String nome = "";

        try {
            final String url = "jdbc:mysql://localhost/trabJDBC";
//            final String sql = "Select * FROM usuario where email like '" + emailL + "'";
            final String sql = "Select * FROM usuario where email like '" + email1 + "' and senha like '"+senha1+"'";
            Connection conexao = DriverManager.getConnection(url, "root", "");
            Statement select = conexao.createStatement();
            ResultSet resultSet = select.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numeroColunas = metaData.getColumnCount();
            if (!resultSet.next()) {
                System.out.println("Usuario ou senha Incorretos");
                Scanner ler = new Scanner(System.in);
                System.out.println("Login");
                System.out.println("Email");
                email1 = ler.next();
                System.out.println("Senha");
                senha1 = ler.next();
                
                Login(email1, senha1);
                conexao.close();
                select.close();
            } else {
                do {
                    for (int i = 1; i <= numeroColunas; i++) {
                        nome = resultSet.getString("Nome");
                    }
                    System.out.println("\n ");
                } while (resultSet.next());
                System.out.println("Bem vindo, "+nome);
                app();
            }
            
            conexao.close();
            select.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface de uma Agenda de Contatos, que se utiliza de Menus Texto para Guiar o usuário.
 * 
 * @author Jose A. O. Rufino
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print(
					"(C)adastrar Contato\n" + 
					"(L)istar Contatos\n" + 
					"(E)xibir Contato\n" + 
					"(F)avoritos\n" +
					"(A)dicionar Favorito\n" +
					"(S)air\n" + 
					"\n" + 
					"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}
	
	/**
	 * Imprime lista de contatos favoritados da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	public static void listaFavoritos(Agenda agenda) {
		System.out.println("\n" + agenda.listaFavoritos());
	}
	
	/**
	 * Adiciona um contato aos Favoritos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir posição do contato na agenda e
	 * a posição que o contato vai estar na lista de favoritos da agenda.
	 */
	public static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int posicaoContato = scanner.nextInt();
		System.out.print("Posição> ");
		int posicaoFavorito = scanner.nextInt();
		
		if (posicaoContato < 1 || posicaoContato > 100 ||
				(posicaoFavorito < 1) || (posicaoFavorito > 10)) {
			System.out.println("POSIÇÃO INVÁLIDA\n");
		}
		
		else {
			if (agenda.adicionaFavorito(posicaoContato, posicaoFavorito)) {
				agenda.adicionaFavorito(posicaoContato, posicaoFavorito);
				System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + posicaoFavorito + "!\n");
			}
			else {
				System.out.println("CONTATO JÁ FAVORITADO\n");
			}
		}	
	}
	

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\n" + agenda.listaContatos());
	}

	/**
	 * Imprime os detalhes/dados de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int posicao = scanner.nextInt();
		
		if (agenda.exibeContato(posicao) == null) {
			System.out.println("\nPOSIÇÃO INVÁLIDA\n");
		}
		else {
			System.out.println("\n" + agenda.exibeContato(posicao));
		}
	}

	/**
	 * Cadastra um contato na agenda, utilizando de seus dados: Nome, Sobrenome,
	 * Telefone Prioritário, Telefone Whatsapp e Telefone Adicional.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir os dados do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição: ");
		int posicao = scanner.nextInt();
		if (posicao < 1 || posicao > 100) {
			System.out.println("POSIÇÃO INVÁLIDA\n");
		}
		else {
			scanner.nextLine();
			System.out.print("Nome: ");
			String nome = scanner.nextLine();
			System.out.print("Sobrenome: ");
			String sobrenome = scanner.nextLine();
			System.out.print("Prioritario: ");
			String prioritario = scanner.nextLine();
			System.out.print("Whatsapp: ");
			String whatsapp = scanner.nextLine();
			System.out.print("Adicional: ");
			String adicional = scanner.nextLine();
			if (agenda.cadastraContato(posicao, nome, sobrenome, prioritario, whatsapp, adicional)) {
				agenda.cadastraContato(posicao, nome, sobrenome, prioritario, whatsapp, adicional);
				System.out.println("CADASTRO REALIZADO\n");
			}
			else {
				System.out.println("CONTATO JA CADASTRADO\n");
			}
		}
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.\n");
	}
}
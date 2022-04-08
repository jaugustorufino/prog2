package controleDeAlunos;

import java.util.Scanner;

/**
 * Interface de um Controle de Alunos, que se utiliza de Menus Texto para Guiar o usuário e
 * tem diversas funcionalidades, são elas: cadastrar de alunos, exibir aluno, criar grupos,
 * alocar alunos em grupos, registrar alunos que responderam questões no quadro,
 * imprimir esses alunos e a contar quantos grupos têm restrição de curso.
 * 
 * @author Jose A. O. Rufino
 *
 */
public class MainControle {
	public static void main(String[] args) {
		ControleDeAlunos controle = new ControleDeAlunos();
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, controle, scanner);
		}
	}
	
	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * 
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print(
				"(C)adastrar Aluno\n" +
				"(E)xibir Aluno\n" +
				"(N)ovo Grupo\n" +
				"(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n" +
				"(R)egistrar Aluno que Respondeu\n" +
				"(I)mprimir Alunos que Responderam\n" +
				"(O)xe, e a contagem dos grupos com restrição de curso?\n" +
				"(S)im, quero fechar o programa!\n" +
				"\nOpção> ");
		return scanner.nextLine().toUpperCase();
	}
	
	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param controle  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, ControleDeAlunos controle, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraAluno(controle, scanner);
			break;
		case "E":
			exibeAluno(controle, scanner);
			break;
		case "N":
			cadastraGrupo(controle, scanner);
			break;
		case "A":
			System.out.print("\n(A)locar Aluno ou (P)ertinência a Grupo? ");
			String escolha = scanner.next().toUpperCase();
			
			if (escolha.equals("A")) {
				alocaAluno(controle, scanner);
			}
			
			else if (escolha.equals("P")) {
				pertenceAGrupo(controle, scanner);
			}
			break;
		case "R":
			registraRespondente(controle, scanner);
			break;
		case "I":
			imprimeRespondente(controle);
			break;
		case "O":
			gruposComRestricao(controle, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			throw new IllegalArgumentException("Entrada Inválida (Nula OU Vazia)");
		}
	}
	
	/**
	 * Cadastra um aluno no Controle de Alunos, utilizando seus dados:
	 * matrícula, nome e curso. Além disso, captura as possíveis exceções lançadas, imprimindo
	 * apenas a mensagem da exceção lançada.
	 * 
	 * @param controle O Controle de Alunos.
	 * @param scanner Scanner para pedir os dados do aluno.
	 */
	private static void cadastraAluno(ControleDeAlunos controle, Scanner scanner) {
		System.out.print("\nMatricula: ");
		String matricula = scanner.nextLine();
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Curso: ");
		String curso = scanner.nextLine();
		
		try {
			if (controle.cadastraAluno(matricula, nome, curso)) {
				controle.cadastraAluno(matricula, nome, curso);
				System.out.println("CADASTRO REALIZADO!\n");
			}
			else {
				System.out.println("MATRÍCULA JÁ CADASTRADA!\n");
			}
		}
		catch (NullPointerException npe) {
			System.out.println(npe.getMessage() + "\n");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage() + "\n");
		}
	}
	
	/**
	 * Imprime os detalhes/dados de um dos alunos do Controle. 
	 * 
	 * @param controle O Controle de Alunos.
	 * @param scanner Scanner para capturar qual aluno.
	 */
	private static void exibeAluno(ControleDeAlunos controle, Scanner scanner) {
		System.out.print("\nMatricula: ");
		String matricula = scanner.nextLine();
		System.out.println("\n" + controle.exibeAluno(matricula) + "\n");
	}
	
	/**
	 * Cadastra um grupo no Controle de Alunos, utilizando seus dados: nome e restrição.
	 * Além disso, captura as possíveis exceções lançadas, imprimindo apenas a mensagem da exceção lançada.
	 * 
	 * @param controle O Controle de Alunos.
	 * @param scanner Scanner para pedir os dados do grupo.
	 */
	private static void cadastraGrupo(ControleDeAlunos controle, Scanner scanner) {
		System.out.print("\nGrupo: ");
		String nome = scanner.nextLine();
		System.out.print("Restrição? ");
		String restricao = scanner.nextLine();
		
		try {
			if (controle.cadastraGrupo(nome, restricao)) {
				controle.cadastraGrupo(nome, restricao);
				System.out.println("CADASTRO REALIZADO!\n");
			}
			else {
				System.out.println("GRUPO JÁ CADASTRADO!\n");
			}
			
		}
		catch (NullPointerException npe) {
			System.out.println(npe.getMessage() + "\n");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage() + "\n");
		}
	}
	
	/**
	 * Aloca um Aluno em um Grupo, a partir dos dados Matrícula e Nome do Grupo, respectivamente.
	 * Além disso, captura a possível IllegalArgumentException lançada, imprimindo apenas a
	 * mensagem dela.
	 * 
	 * @param controle O Controle de Alunos.
	 * @param scanner Scanner para pedir a matrícula do aluno e o nome do grupo.
	 */
	private static void alocaAluno(ControleDeAlunos controle, Scanner scanner) {
		scanner.nextLine();
		System.out.print("\nMatricula: ");
		String matriculaAluno = scanner.nextLine();
		System.out.print("Grupo: ");
		String nomeGrupo = scanner.nextLine();
		
		try {
			if (!controle.alocaAluno(matriculaAluno, nomeGrupo)) {
				System.out.println("GRUPO COM RESTRIÇÃO DE CURSO\n");
			}
			
			else {
				controle.alocaAluno(matriculaAluno, nomeGrupo);
				System.out.println("ALUNO ALOCADO!\n");
			}
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage() + "\n");
		}
	}
	
	/**
	 * Verifica a pertinência ou não de um aluno a determinado grupo, a partir do nome do grupo e
	 * da matrícula do aluno.
	 * Além disso, captura a possível IllegalArgumentException lançada, imprimindo apenas a
	 * mensagem dela.
	 * 
	 * @param controle O Controle de Alunos.
	 * @param scanner Scanner para pedir o nome do grupo e a matrícula do aluno.
	 */
	private static void pertenceAGrupo(ControleDeAlunos controle, Scanner scanner) {
		scanner.nextLine();
		System.out.print("\nGrupo: ");
		String nomeGrupo = scanner.nextLine();
		System.out.print("Aluno: ");
		String matriculaAluno = scanner.nextLine();
		
		try {
			if (!controle.pertenceAGrupo(nomeGrupo, matriculaAluno)) {
				System.out.println("ALUNO NÃO PERTENCE AO GRUPO\n");
			}
			
			else {
				controle.pertenceAGrupo(nomeGrupo, matriculaAluno);
				System.out.println("ALUNO PERTENCE AO GRUPO\n");
			}
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage() + "\n");
		}
	}
	
	/**
	 * Registra, dentro do Controle de Alunos, o aluno que respondeu questões no quadro.
	 * 
	 * @param controle O Controle de Alunos.
	 * @param scanner Scanner para pedir a matrícula do aluno a ser registrado.
	 */
	private static void registraRespondente(ControleDeAlunos controle, Scanner scanner) {
		System.out.print("\nMatricula: ");
		String matriculaAluno = scanner.nextLine();
		if (controle.registraRespondente(matriculaAluno)) {
			System.out.println("ALUNO REGISTRADO!\n");
		}
		else {
			System.out.println("Aluno não cadastrado.\n");
		}
	}
	
	/**
	 * Imprime lista de alunos que responderam questões no quadro.
	 * 
	 * @param controle O controle de alunos sendo manipulado.
	 */
	private static void imprimeRespondente(ControleDeAlunos controle) {
		System.out.println("\n" + controle.imprimeRespondentes());
	}
	
	/**
	 * Imprime a quantidade de grupos com restrição de curso por curso.
	 * 
	 * @param controle O controle de alunos sendo manipulado.
	 * @param scanner Scanner para pedir o curso a ser verificado.
	 */
	private static void gruposComRestricao(ControleDeAlunos controle, Scanner scanner) {
		System.out.print("\nCurso: ");
		String curso = scanner.nextLine();
		System.out.println(curso + " " + controle.gruposComRestricao(curso) + "\n");
	}
	
	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.exit(0);
	}
}
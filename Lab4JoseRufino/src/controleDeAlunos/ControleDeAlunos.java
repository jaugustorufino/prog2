package controleDeAlunos;

import java.util.*;

/**
 * Classe que sustenta um Sistema de Controle de Alunos, sendo possível o cadastro de alunos,
 * exibição de aluno, criação de grupos, alocação de alunos em grupos, registro de alunos que
 * responderam questões no quadro, impressão desses alunos e
 * a contagem de grupos com restrição de curso.
 * Cada Aluno é armazenado em um Mapa contendo sua Matrícula (Chave) e o próprio Aluno (Valor).
 * De forma semelhante, os Grupos, também são armazenados em um Mapa, este contém o Nome do Grupo
 * (Chave) e o próprio Grupo (Valor). Além disso, há uma Lista de Alunos que responderam
 * as questões no quadro.
 *    
 * @author Jose A. O. Rufino
 *
 */
public class ControleDeAlunos {	
	
	private Map<String, Aluno> mapaMatriculaAlunos;
	private Map<String, Grupo> mapaNomeGrupos;
	private List<Aluno> alunosRespondentes;
	
	/**
	* Constrói/Cria um Controle de Alunos, criando um HashMap de Matrícula e Alunos vazio, um HashMap
	* Nome do Grupo e Grupos vazio e um ArrayList dos Alunos Respondentes.
	*/
	public ControleDeAlunos() {
		this.mapaMatriculaAlunos = new HashMap<String, Aluno>();
		this.mapaNomeGrupos = new HashMap<String, Grupo>();
		this.alunosRespondentes = new ArrayList<Aluno>();
	}

	/**
	 * Cadastra um Aluno no MapaMatriculaAlunos e Cria esse Aluno com seus dados (Matrícula,
	 * Nome e Curso). Um cadastro de um Aluno já cadastrado não é realizado e o retorno é false.
	 * Se o Cadastro for de um novo aluno, este é cadastrado com sucesso e o retorno é true.
	 * 
	 * @param matricula Matrícula do Aluno a ser cadastrado.
	 * @param nome Nome do Aluno a ser cadastrado.
	 * @param curso Curso do Aluno a ser cadastrado.
	 * 
	 * @return boolean true para Aluno cadastrado com sucesso ou false para o contrário.
	 */
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		
		Aluno alunoNovo = new Aluno(matricula, nome, curso);
		
		if (this.mapaMatriculaAlunos.containsKey(matricula)) {  
			return false;
		}
		
		this.mapaMatriculaAlunos.put(matricula, alunoNovo);
		return true;
	}

	/**
	 * Exibe os dados de um Aluno, dada sua matrícula.
	 * 
	 * @param matricula Matrícula do contato.
	 * 
	 * @return Se o aluno já foi cadastrado, retorna a String que o representa.
	 * Se não, retorna "Aluno não cadastrado".
	 */
	public String exibeAluno(String matricula) {
		if (!this.mapaMatriculaAlunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		}
		Aluno alunoAExibir = this.mapaMatriculaAlunos.get(matricula);
		return "Aluno: " + alunoAExibir.toString();
	}

	/**
	 * Cadastra um Grupo no MapaNomeGrupos e Cria esse Grupo com seus dados (Nome e Restrição)
	 * Um cadastro de um Grupo já cadastrado não é realizado e o retorno é false.
	 * Se o Cadastro for de um novo grupo, este é cadastrado com sucesso e o retorno é true. 
	 * 
	 * @param nome Nome do Grupo a ser cadastrado.
	 * @param restricao Curso permitido a participar do grupo.
	 * 
	 * @return boolean true para Grupo cadastrado com sucesso ou false para o contrário.
	 */
	public boolean cadastraGrupo(String nome, String restricao) {
		Grupo grupoNovo = new Grupo(nome, restricao);
		
		if (this.mapaNomeGrupos.containsKey(nome.toUpperCase())) {
			return false;
		}
		
		this.mapaNomeGrupos.put(nome.toUpperCase(), grupoNovo);
		return true;
	}

	/**
	 * Aloca um Aluno em um Grupo, partindo de suas identificações principais:
	 * Matrícula e Nome, respectivemente. Além disso, lança uma IllegalArgumentException, caso a
	 * Matrícula passada ou o Nome do Grupo passado não tenham sido cadastrados no Controle.
	 * 
	 * @param matriculaAluno Matrícula do Aluno a ser alocado.
	 * @param nomeGrupo Nome do Grupo, o qual o aluno vai ser alocado.
	 * 
	 * @return boolean true para Aluno alocado ou false para o contrário ou para Aluno null.
	 */
	public boolean alocaAluno(String matriculaAluno, String nomeGrupo) {
		
		if (!mapaMatriculaAlunos.containsKey(matriculaAluno)) {
			throw new IllegalArgumentException("Aluno não cadastrado.");
		}
		
	    if (!mapaNomeGrupos.containsKey(nomeGrupo.toUpperCase())) {
			throw new IllegalArgumentException("Grupo não cadastrado.");
		}
	    
	    Aluno alunoGrupo = this.mapaMatriculaAlunos.get(matriculaAluno);
	    Grupo grupoAluno = this.mapaNomeGrupos.get(nomeGrupo.toUpperCase());
	    
	    if (!grupoAluno.cadastraAlunoNoGrupo(alunoGrupo)) {
	    	return false;
	    }
	    
	    grupoAluno.cadastraAlunoNoGrupo(alunoGrupo);
	    return true;
	}
	
	/**
	 * Verifica a pertinência ou não de um aluno a de terminado grupo, partindo do nome do grupo
	 * e da matrícula do aluno. Além disso, lança uma IllegalArgumentException, caso a
	 * Matrícula passada ou o Nome do Grupo passado não tenham sido cadastrados no Controle.
	 * 
	 * @param nomeGrupo Nome do Grupo, o qual o aluno vai ser alocado.
	 * @param matriculaAluno Matrícula do Aluno a ser alocado.
	 * 
	 * @return boolean true para Aluno pertence ao grupo ou false para o contrário.
	 */
	public boolean pertenceAGrupo(String nomeGrupo, String matriculaAluno) {
		
		if (!this.mapaNomeGrupos.containsKey(nomeGrupo.toUpperCase())) {
			throw new IllegalArgumentException("Grupo não cadastrado.");
		}
		
		if (!mapaMatriculaAlunos.containsKey(matriculaAluno)) {
			throw new IllegalArgumentException("Aluno não cadastrado.");
		}
		
		Aluno alunoGrupo = this.mapaMatriculaAlunos.get(matriculaAluno);
	    Grupo grupoAluno = this.mapaNomeGrupos.get(nomeGrupo.toUpperCase());
	    
	    if (!grupoAluno.pertenceAGrupo(alunoGrupo)) {
	    	return false;
	    }
	    return true;
	}

	/**
	 * Registra um Aluno que respondeu questões no quadro. Esse registro é feito a partir da
	 * matrícula do aluno respondente e retorna um valor booleano para representar
	 * um registro feito com sucesso ou não. Se o aluno não foi cadastrado ainda, o retorno é false.
	 * 
	 * @param matriculaAluno Representação em String da matrícula do Aluno.
	 * 
	 * @return boolean true para Aluno registrado com sucesso ou false para o contrário.
	 */
	public boolean registraRespondente(String matriculaAluno) {
		
		if (!this.mapaMatriculaAlunos.containsKey(matriculaAluno)) {
			return false;
		}
		Aluno aluno = mapaMatriculaAlunos.get(matriculaAluno);
	    this.alunosRespondentes.add(aluno);
	    return true;
	}
	
	/**
	 * Exibe os dados dos Alunos registrados como respondentes.
	 * 
	 * @return String representando os dados de cada aluno respondente (matrícula, nome e curso)
	 * respondente separados por "\n".
	 */
	public String imprimeRespondentes() {
		String result = "Alunos:\n";
		int conta = 1;
		
		for (Aluno aluno : alunosRespondentes) {
			result += conta + ". " + aluno.toString() + "\n";
			conta += 1;
		}
		
		return result;
	}

	/**
	 * Exibe o número de grupos que contém a restrição de curso, que é o curso passado como parâmetro.
	 
	 * @param curso Curso a ser verificado para saber quais grupos contém restrição dele.
	 * 
	 * @return Contagem de grupos com dada restrição.
	 */
	public int gruposComRestricao(String curso) {
		int contagem = 0;
		
		for (Grupo grupo : this.mapaNomeGrupos.values()) {
			if (grupo.getRestricao().equals(curso)) {
				contagem++;
			}
		}
		
		return contagem;
	}
}
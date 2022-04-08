package controleDeAlunos;

import java.util.*;

/**
 * Classe que representa um Grupo criado para ser colocado dentro de um Sistema, o
 * Controle De Alunos. Cada Grupo tem seu nome, sua restrição de curso (Apenas Alunos dentro
 * dessa restrição podem fazer parte do grupo e um conjunto de Alunos.
 * 
 * @author Jose A. O. Rufino
 *
 */
public class Grupo {
	private String nome;
	private String restricao;
	private HashSet<Aluno> alunosGrupo;
	
	/**
	* Constrói/Cria um Grupo, partindo de seus dados (parâmetros): nome e restrição.
	* Ainda, cria um conjunto de alunos vazio, onde os alunos desse grupo serão inseridos.
	* Além disso, lança uma exceção caso um ou mais dos parâmetros recebidos seja nulo
	* (NullPointerException) ou o nome seja inválido (IllegalArgumentException).
	* 
	* @param matricula matrícula do aluno a ser criado.
	* @param nome nome do aluno a ser criado.
	* @param curso curso do aluno a ser criado.
	*/
	public Grupo(String nome, String restricao) {
		if ((nome == null) || (restricao == null)) {
		       throw new NullPointerException();
		    }
		else {
			if (nome.trim().equals("")) {
				throw new IllegalArgumentException("Entrada Inválida.");
			}
			else {
				this.nome = nome.toUpperCase();
				this.restricao = restricao;
				this.alunosGrupo = new HashSet<Aluno>();
			}
		}
	}
	
	/**
	* Retorna a restrição de curso que Grupo exige.
	* 
	* @return String contendo restrição de curso do grupo.
	*/
	public String getRestricao() {
		return this.restricao;
	}
	
	/**
	* Aloca (Cadastra) um aluno passado como parâmetro no Grupo.
	* Retorna false para Aluno nulo ou Aluno que não faz parte do curso restringido.
	* Retorna true para Aluno alocado com sucesso.
	* 
	* @param aluno aluno a ser cadastrado no grupo.
	* @return true para aluno alocado com sucesso ou false para não alocado.
	*/
	public boolean cadastraAlunoNoGrupo(Aluno aluno) {
		if (aluno == null) {
			return false;
		}
		if (aluno.getCurso().equals(this.restricao) ||
				this.restricao.trim().equals("")) {
			this.alunosGrupo.add(aluno);
			return true;
		}
		
		return false;
	}
	
	/**
	* Verifica a Pertinência de um Aluno em um Grupo, retornando true para pertence
	* e false para que não pertence ou o aluno passado como parâmetro é nulo.
	* 
	* @param aluno aluno a ser verificado se pertence ao grupo.
	* 
	* @return true para aluno pertence ao grupo ou false para o contrário.
	* 
	*/
	public boolean pertenceAGrupo(Aluno aluno) {
		if (aluno == null) {
			return false;
		}
		if (this.alunosGrupo.contains(aluno)) {
			return true;
		}
		return false;
	}
	
	/**
	* Retorna o HashCode do Objeto Aluno, a partir da sua matrícula.
	* 
	* @return int com o HashCode do Aluno.
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	* Retorna a comparação entre o Objeto, passado como parâmetro, e o Grupo,
	* partindo do nome desse grupo.
	* 
	* @return boolean true para objeto igual ao objeto Grupo e false para o contrário.
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
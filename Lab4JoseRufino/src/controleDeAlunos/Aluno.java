package controleDeAlunos;

/**
 * Classe que representa um Aluno criado para ser colocado dentro de um Sistema, o
 * Controle De Alunos. Cada Aluno tem:
 * matrícula, nome e curso.
 * 
 * @author Jose A. O. Rufino
 *
 */
public class Aluno {
	private String matricula;
	private String nome;
	private String curso;
	
	/**
	* Constrói/Cria um Aluno, partindo de seus dados (parâmetros): matricula, nome e curso.
	* Além disso, lança uma exceção caso um ou mais dos parâmetros recebidos seja nulo
	* (NullPointerException) ou inválido (IllegalArgumentException).
	* 
	* @param matricula matrícula do aluno a ser criado.
	* @param nome nome do aluno a ser criado.
	* @param curso curso do aluno a ser criado.
	*/
	public Aluno(String matricula, String nome, String curso) {
		if ((matricula == null) || (nome == null) || (curso == null)) {
		       throw new NullPointerException();
		    }
		else {
			if (matricula.trim().equals("") || nome.trim().equals("")) {
				throw new IllegalArgumentException("Entrada Inválida.");
			}
			else {
				this.matricula = matricula;
				this.nome = nome;
				this.curso = curso;
			}
		}
	}

	/**
	* Retorna o curso que o Aluno está fazendo.
	* 
	* @return String contendo o curso do aluno.
	*/
	public String getCurso() {
		return curso;
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
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	* Retorna a comparação entre o Objeto, passado como parâmetro, e o Aluno,
	* partindo da matrícula desse aluno.
	* 
	* @return boolean true para objeto igual ao objeto Aluno e false para o contrário.
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
	/**
	* Cria a representação em String dos dados do Aluno.
	* 
	* @return String contendo a representação dos dados do aluno,
	* contendo matrícula, nome e curso, separados por " - "
	*/
	@Override
	public String toString() {
		return matricula + " - " + nome + " - " + curso;
	}
}
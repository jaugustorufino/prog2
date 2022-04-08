package lab2;

/**
* Representação de dada disciplina de um usuário, de suas respectivas notas
* e das horas de estudos para a tal disciplina.
* 
* @author Jose A. O. Rufino
*/

public class Disciplina {
	/**
	* Horas de estudo dedicadas para dada disciplina pelo usuário.
	*/
	private int horasDeEstudo = 0;
	/**
	* Nome da disciplina que vai ser analisada.
	*/
	private String nomeDisciplina;
	/**
	* Array double[] de todas as 4 notas do usuário, iniciadas por 0.
	*/
	private double[] notas = {0.0, 0.0, 0.0, 0.0};
	/**
	* Média das 4 notas na disciplina, iniciada por 0.
	*/
	private double media = 0.0;
	/**
	* Lista com todas as notas do usuário.
	*/
	private String listaNotas;

	/**
	* Constrói uma disciplina, partindo de seu nome.
	* @param nomeDisciplina nome da disciplina que está sendo criada.
	*/
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;	
	}
	
	/**
	* Cadastra ou Incrementa horas dedicadas a disciplina. (Sem Retorno)
	* @param horas número de horas de estudo dedicadas para a disciplina.
	*/
	public void cadastraHoras(int horas) {
		if (this.horasDeEstudo > 0) {
			this.horasDeEstudo += horas;
		}
		else {
			this.horasDeEstudo = horas;
		}
	}
	
	/**
	* Cadastra a nota para determinada etapa (1,2,3 ou 4). (Sem Retorno)
	* @param nota número de qual nota está sendo cadastrada(1,2,3 ou 4).
	* @param valorNota Pontuação adquirida para tal nota.
	*/
	public void cadastraNota(int nota, double valorNota) { // notas possíveis: 1, 2, 3 e 4
		notas[nota-1] = valorNota;
	}
	
	/**
	 * Retorna um tipo booleano que determina se o aluno está aprovado ou não.
	 * 
	 * @return true (o aluno passou na disciplina)
	 * @return false (o aluno não passou na disciplina)
	*/
	public boolean aprovado() {
		double soma = 0.0;
		for (int i = 0; i < 4; i++) {
			soma += notas[i];
		}
		this.media = soma/4;

		if (this.media >= 7.0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	* Retorna a String que contém a representação da disciplina, horas dedicadas
	* a ela, média de todas as notas da disciplina e uma lista com todas as notas.
	* 
	* @return a representação dos dados da disciplina em String.
	*/
	public String toString() {
		this.listaNotas = "[";
		for (int i = 0; i < 4; i++) {
			this.listaNotas += notas[i];
			if (i != 3) {
				this.listaNotas += ", ";
			}
			else {
				this.listaNotas += "]";
			}
		}
		return this.nomeDisciplina +  " " + this.horasDeEstudo +  " " + this.media +  " " + this.listaNotas;
	}

}

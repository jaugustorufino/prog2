package lab2;

/**
* Representação do registro da quantidade de horas de internet que o aluno tem dedicado
* para uma dada disciplina remota.
* 
* @author Jose A. O. Rufino
*/

public class RegistroTempoOnline{
	/**
	 * Tempo online esperado padrão(horas): Caso o usuário não coloque qual o tempo
	 * esperado, este é o que vai ser usado.
	 */
	private int tempoOnlineEsperado = 120;
	/**
	 * Nome da disciplina que será registrada.
	 */
	private String nomeDisciplina;
	/**
	 * Tempo online gasto pelo usuário para dedicação à disciplina.
	 */
	private int tempoOnlineGasto;
	
	/**
	 * Constrói um registro de tempo, a partir do nome da disciplina.
	 * O tempo esperado é 120, por padrão.
	 * Todo tempo gasto começa com 0.
	 * 
	 * @param nomeDisciplina nome da disciplina a ser registrada.
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.tempoOnlineEsperado = 120;
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineGasto = 0;
	}
	/**
	 * Constrói um registro de tempo a partir do nome da disciplina e do
	 * tempo online esperado.
	 * Todo tempo gasto começa com 0.
	 * 
	 * @param nomeDisciplina nome da disciplina a ser registrada.
	 * @param tempoOnlineEsperado quantidade de horas que o usuário deve
	 * cumprir na disciplina remota. 
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.tempoOnlineEsperado = tempoOnlineEsperado;
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineGasto = 0;
	}
	
	/**
	 * Adiciona uma quantidade de horas cumpridas ao tempo online gasto.(Sem Retorno)
	 * 
	 * @param tempo quantidade de horas a ser incrementada ao tempo gasto.
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnlineGasto += tempo;
	}
	
	/**
	 * Retorna o boolean que mostra se o usuário atingiu o tempo esperado (true)
	 * ou não (false).
	 * 
	 * @return true, caso o usuário tenha cumprido a meta e false, caso contrário.
	 */
	public boolean atingiuMetaTempoOnline() {
		if (this.tempoOnlineGasto >= this.tempoOnlineEsperado) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Retorna a String que representa a Disciplina em que o registro foi feito
	 * junto ao tempo gasto na disciplina e ao tempo esperado da mesma.
	 * 
	 * @return String com o nome da disciplina, o tempo gasto nela e o tempo
	 * esperado dela.
	 */	
	public String toString() {
		return this.nomeDisciplina + " " + this.tempoOnlineGasto + "/" + this.tempoOnlineEsperado;
	}
}
package lab2;

/**
* Representação da saúde de um estudante (Física, Mental e Geral).
* 
* @author Jose A. O. Rufino
*/

public class Saude {
	/**
	* Saúde física do aluno.
	*/
	private String saudeFisica = "boa";
	/**
	* Saúde mental do aluno.
	*/
	private String saudeMental = "boa";
	
	/**
	* É definida a Saúde Mental do aluno (Sem Retorno).
	*
	* @param valor qualidade da saúde mental (boa ou fraca)
	*/
	public void defineSaudeMental(String valor) { 
		this.saudeMental = valor;
	}
	/**
	* É definida a Saúde Física do aluno (Sem Retorno).
	*
	* @param valor qualidade da saúde física (boa ou fraca)
	*/
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
	}
	
	/**
	* Retorna String que contém a saúde geral do aluno, que pode ser boa (saúde
	* fisica boa e saúde mental boa), ok (saúde fisica/mental boa e saúde mental
	* /fisica ruim) ou fraca (saúde física ruim e saúde mental ruim.
	*
	* @return a representação da saúde geral do aluno.
	*/
	public String getStatusGeral() {
		if (this.saudeFisica == "boa" && this.saudeMental == "boa") {
			return "boa";
		}
		else if (this.saudeFisica == "fraca" && this.saudeMental == "fraca") {
			return "fraca";
		}
		else {
			return "ok";
		}
	}
	
}

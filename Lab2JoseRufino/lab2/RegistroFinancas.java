package lab2;

/**
* Representação do registro das finanças (em centavos) de um aluno em determinado
* curso da Universidade.
* 
* @author Jose A. O. Rufino
*/

public class RegistroFinancas {
	/**
	* Receitas do aluno. Array que contém as receitas do aluno, que pode ser
	* de 4 tipos, por isso 4 elementos no Array (família, projetos institucionais
	*  com bolsa, auxílio institucional e doações externas
	*/
	private int[] receitas = {0, 0, 0, 0};
	/**
	* Receita Acumulada. Receita total do aluno, tudo que ele recebeu.
	*/
	private int receitaAcumulada = 0;
	/**
	* Receita Atual. Receita total menos as despesas, o que o aluno tem.
	*/
	private int receitaAtual = 0;
	/**
	* Despesas. Tudo que o aluno teve que gastar.
	*/
	private int despesas = 0;

	/**
	* Constrói um registro de finanças a partir da receita inicial do tipo 1.
	* Soma à receita acumalada o valor recebido.
	*
	* @param receitaInicialDoTipo1 primeira receita (tipo 1).
	*/
	public RegistroFinancas(int receitaInicialDoTipo1) {
		receitas[0] = receitaInicialDoTipo1;
		receitaAcumulada += receitaInicialDoTipo1;
	}
	
	/**
	* Aumenta determinado valor (centavos) na Receita determinada pelo tipo fonte.
	* (Sem Retorno).
	*
	* @param valorCentavos valor em centavos a ser incrementado.
	* @param tipoFonte tipo da receita que vai ser incrementada (1,2,3 ou 4).
	*/
	public void aumentaReceita(int valorCentavos, int tipoFonte) {
		receitas[tipoFonte-1] += valorCentavos;
		receitaAcumulada += valorCentavos;
	}
	
	/**
	* Paga despesa do aluno. (Sem Retorno).
	*
	* @param valorCentavos valor em centavos da despesa
	*/
	public void pagaDespesa(int valorCentavos) {
		despesas += valorCentavos;
	}
	
	/**
	* Retorna a String que representa o valor de cada receita, diferenciadas
	* pelo tipo de fonte.
	*
	* @return String contendo cada valor de cada receita, de acordo com o tipo
	* fonte da mesma.
	*/
	public String exibeFontes() {
		receitaAtual = receitaAcumulada - despesas;
		String fontes = "";
		for (int i = 0; i < receitas.length; i++) {
			fontes += (i+1) + " - " + receitas[i];
			if (i!= 3) {
				fontes += "\n";
			}
		}
		return fontes;
	}
	/**
	* Retorna a String que representa os registro final das finanças do aluno,
	* com a receita total do aluno (acumalada), a receita atual e as despesas totais.
	*
	* @return String contendo cada valor, separados por vírgula, da receita total,
	* da receita atual e das despesas totais.
	*/
	public String toString() {
		
		String rFinal = "Receita total: " + receitaAcumulada + ", Receita atual: " + receitaAtual + ", Despesas totais: " + despesas;
		return rFinal;
	}	
}

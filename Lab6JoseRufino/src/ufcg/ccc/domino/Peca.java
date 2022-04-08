package ufcg.ccc.domino;

/**
 * Uma peça de dominó com dois lados.
 *
 */
public class Peca implements Comparable<Peca> {

	private int numEsquerdo;
	private int numDireito;

	/**
	 * Cria uma peça.
	 * 
	 * @param numEsquerdo Número do lado esquerdo.
	 * @param numDireito  Número do lado direito.
	 */
	public Peca(int numEsquerdo, int numDireito) {
		this.numEsquerdo = numEsquerdo;
		this.numDireito = numDireito;
	}

	/**
	 * Inverte os lados dos números na peça.
	 */
	public void gira() {
		int tmp = numEsquerdo;
		numEsquerdo = numDireito;
		numDireito = tmp;
	}

	/**
	 * 
	 * @return O número da direita.
	 */
	public int getNumDireito() {
		return numDireito;
	}

	/**
	 * 
	 * @return O número da esquerda.
	 */
	public int getNumEsquerdo() {
		return numEsquerdo;
	}

	@Override
	public String toString() {
		return this.getNumEsquerdo() + ":" + this.getNumDireito();
	}

	/**
	 * Testa se a peça encaixa com um número.
	 * 
	 * @param numero O número a testar.
	 * @return true se um dos lados ao menos combinar com o número.
	 */
	public boolean encaixa(int numero) {
		return this.numDireito == numero || this.numEsquerdo == numero;
	}
	
	/**
	 * Retorna a Soma de Pontos da peça.
	 * 
	 * @return int soma de pontos da peça
	 */
	private int getSomaPeca() {
		return this.getNumDireito() + this.getNumEsquerdo();
	}
	
	/**
	 * Compara duas peças, a partir da soma de pontos de cada uma.
	 * 
	 * @param outraPeca peça a ser comparada.
	 * @return -1 se esta peça for maior que a outra, em termos de soma de pontos.
	 * 0 se as duas peças são iguais, em termos de soma de pontos.
	 * 1 se a outra peça for maior que a esta, em termos de soma de pontos.
	 */
	@Override
	public int compareTo(Peca outraPeca) {
		return Integer.compare(outraPeca.getSomaPeca(), this.getSomaPeca());
	}

}

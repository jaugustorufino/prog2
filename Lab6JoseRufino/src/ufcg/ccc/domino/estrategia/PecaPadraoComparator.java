package ufcg.ccc.domino.estrategia;

import java.util.Comparator;

import ufcg.ccc.domino.Peca;

/**
 * Comparator que ordena uma lista de peças de acordo com o número esquerdo e o número direito,
 * sendo a peça mais próxima, àquela que tiver número esquerdo e direito inferiores e, sendo a peça
 * mais distante, àquela que tiver números esquerdo e direito maiores.
 */
public class PecaPadraoComparator implements Comparator<Peca> {
	
	@Override
	public int compare(Peca peca1, Peca peca2) {
		if (peca1.getNumEsquerdo() < peca2.getNumEsquerdo()) {
			return -1;
		}

		if (peca1.getNumEsquerdo() > peca2.getNumEsquerdo()) {
			return 1;
		}

		if (peca1.getNumDireito() > peca2.getNumDireito()) {
			return 1;
		}

		if (peca1.getNumDireito() < peca2.getNumDireito()) {
			return -1;
		}
		return 0;
	}

}

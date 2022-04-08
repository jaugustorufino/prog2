package ufcg.ccc.domino.estrategia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;

/**
 * Ordena as peças do Jogador, sendo a mais próxima, àquela que tiver o numero esquerdo menor que
 * as outras e, em segundo lugar, a que tiver o numero direito menor que o das outras.
 * Joga sempre a primeira peça que encaixa. Tenta primeiro no lado direito e
 * depois esquerdo, se encaixar em ambas.
 */
public class JogaPrimeiraPossivelComparadora implements EstrategiaDeJogo {
	private Comparator<Peca> comparador;
	
	public JogaPrimeiraPossivelComparadora(Comparator<Peca> comparador) {
		this.comparador = new PecaPadraoComparator();
	}
	
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		List<Peca> maoOrdenada = new ArrayList<Peca>(mao);
		Collections.sort(maoOrdenada, this.comparador);

		if (mesa.getNumPecas() == 0) {
			return new Jogada(mao.get(0), TipoJogada.NA_DIREITA);
		}

		for (Peca peca : maoOrdenada) {
			if (peca.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.NA_ESQUERDA);
			}
		}

		return new Jogada();
	}
	
}

package ufcg.ccc.domino.estrategia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Peca;

/**
 * Joga sempre a maior peça (número de pontos) que encaixa. Tenta primeiro no lado direito e
 * depois esquerdo, se encaixar em ambas. Se há duas peças com o mesmo número de pontos, joga a primeira que encaixa.
 * Se a maior peça não encaixa, passa para a próxima, até encontrar uma que encaixe.
 */
public class JogaMaiorPeca implements EstrategiaDeJogo {

	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		List<Peca> maoOrdenada = new ArrayList<Peca>(mao);
		Collections.sort(maoOrdenada);

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

	@Override
	public String toString() {
		return "Joga Maior Peça Possível";
	}

}

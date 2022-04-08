package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Peca;

/**
 * Joga sempre a primeira peça de carroça que encaixa. Tenta primeiro no lado direito e depois esquerdo, se encaixar
 * em ambas. Se há mais de uma carroça, joga a primeira carroça possível. Se não há carroças ou não há carroças que
 * encaixem, joga a primeira peça possível que encaixa na mesa ou, ainda, se não houver, passa.
 */
public class JogaCarroca implements EstrategiaDeJogo {

	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		for (Peca pecaCarroca : mao) {
			if (pecaCarroca.getNumDireito() == pecaCarroca.getNumEsquerdo()) {
				if (mesa.getNumPecas() == 0) {
					return new Jogada(pecaCarroca, TipoJogada.NA_DIREITA);
				}
				if (pecaCarroca.encaixa(mesa.getNumNaDireita())) {
					return new Jogada(pecaCarroca, TipoJogada.NA_DIREITA);
				}
				if (pecaCarroca.encaixa(mesa.getNumNaEsquerda())) {
					return new Jogada(pecaCarroca, TipoJogada.NA_ESQUERDA);
				}
			}
		}

		for (Peca peca : mao) {
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
		return "Joga Carroça (Se houver)";
	}
}

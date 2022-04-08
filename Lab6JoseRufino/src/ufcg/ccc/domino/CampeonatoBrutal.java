package ufcg.ccc.domino;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaCarroca;
import ufcg.ccc.domino.estrategia.JogaMaiorPeca;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;

/**
 * Um campeonato onde todas as estratégias jogam 50 mil vezes contra todas as
 * outras, e, ao final, tem-se um ranking das estratégias que mais pontuaram.
 * 
 */
public class CampeonatoBrutal {

	private static final int NUM_PECAS_INICIAL = 12;
	private static final int REPETICOES = 50000;

	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {

		int pontuacaoJ1 = 0, pontuacaoJ2 = 0, pontuacaoJ3 = 0;

		EstrategiaDeJogo estrategia1 = new JogaMaiorPeca(), estrategia2 = new JogaCarroca(),
				estrategia3 = new JogaPrimeiraPossivel();

		// 50000 Partidas entre J1 e J2
		for (int i = 0; i < REPETICOES; i++) {

			Jogo j;

			// Cada estratégia começa jogando metade das partidas.
			if (i < REPETICOES / 2) {
				j = new Jogo("J1", estrategia1, "J2", estrategia2, NUM_PECAS_INICIAL);
			} else {
				j = new Jogo("J2", estrategia2, "J1", estrategia1, NUM_PECAS_INICIAL);
			}

			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.getVencedor() == "J1") {
				pontuacaoJ1 += historico.getPontuacaoVencedor();
			} else if (historico.getVencedor() == "J2") {
				pontuacaoJ2 += historico.getPontuacaoVencedor();
			}
		}

		// 50000 Partidas entre J1 e J3
		for (int i = 0; i < REPETICOES; i++) {

			Jogo j;

			// Cada estratégia começa jogando metade das partidas.
			if (i < REPETICOES / 2) {
				j = new Jogo("J1", estrategia1, "J3", estrategia3, NUM_PECAS_INICIAL);
			} else {
				j = new Jogo("J3", estrategia3, "J1", estrategia1, NUM_PECAS_INICIAL);
			}

			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.getVencedor() == "J1") {
				pontuacaoJ1 += historico.getPontuacaoVencedor();
			} else if (historico.getVencedor() == "J3") {
				pontuacaoJ3 += historico.getPontuacaoVencedor();
			}
		}

		// 50000 Partidas entre J3 e J2
		for (int i = 0; i < REPETICOES; i++) {

			Jogo j;

			// Cada estratégia começa jogando metade das partidas.
			if (i < REPETICOES / 2) {
				j = new Jogo("J3", estrategia3, "J2", estrategia2, NUM_PECAS_INICIAL);
			} else {
				j = new Jogo("J2", estrategia2, "J3", estrategia3, NUM_PECAS_INICIAL);
			}

			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.getVencedor() == "J3") {
				pontuacaoJ3 += historico.getPontuacaoVencedor();
			} else if (historico.getVencedor() == "J2") {
				pontuacaoJ2 += historico.getPontuacaoVencedor();
			}
		}

		List<Integer> pontuacoes = Arrays.asList(pontuacaoJ1, pontuacaoJ2, pontuacaoJ3);

		Collections.sort(pontuacoes);

		System.out.println("E1: " + estrategia1.toString() + "\nE2: " + estrategia2.toString() + "\nE3: "
				+ estrategia3.toString() + "\nJogos:\t" + (REPETICOES * 3) + "\n");
		
		int posicaoRanking = 1;
		for (int i = pontuacoes.size() - 1; i >= 0; i--) {
			if (pontuacaoJ1 == pontuacoes.get(i)) {
				System.out.println(posicaoRanking + "º lugar | E1: " + estrategia1.toString() + " | " + pontuacaoJ1 + " pontos");
			}
			else if (pontuacaoJ2 == pontuacoes.get(i)) {
				System.out.println(posicaoRanking + "º lugar | E2: " + estrategia2.toString() + " | " + pontuacaoJ2 + " pontos");
			}
			else if (pontuacaoJ3 == pontuacoes.get(i)) {
				System.out.println(posicaoRanking + "º lugar | E3: " + estrategia3.toString() + "   | " + pontuacaoJ3 + " pontos");
			}
			posicaoRanking++;
		}
	}

}

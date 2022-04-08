package ufcg.ccc.domino;

import ufcg.ccc.domino.Jogo.TipoVitoria;
import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaCarroca;
import ufcg.ccc.domino.estrategia.JogaMaiorPeca;

/**
 * Exemplo de como fazer um um main com uma disputa de muuuitos jogos entre duas
 * estratégias.
 * 
 */
public class DominoBrutalRepetido {

	private static final int NUM_PECAS_INICIAL = 12;
	private static final int REPETICOES = 50000;

	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
		
		float empates = 0;
		EstatisticasJogador estaticasJ1 = new EstatisticasJogador();
		EstatisticasJogador estaticasJ2 = new EstatisticasJogador();

		EstrategiaDeJogo estrategia1 = new JogaCarroca(), estrategia2 = new JogaMaiorPeca();

		for (int i = 0; i < REPETICOES; i++) {

			Jogo j;

			// Cada estratégia começa jogando metade das partidas.
			if (i < REPETICOES / 2) {
				j = new Jogo("J1", estrategia1, "J2", estrategia2, NUM_PECAS_INICIAL);
			} else {
				j = new Jogo("J2", estrategia2, "J1", estrategia1, NUM_PECAS_INICIAL);
			}
			
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates++;
			} else if (historico.getVencedor() == "J1") {
				estaticasJ1.incrementaVitorias();
				estaticasJ1.incrementaPontuacao(historico.getPontuacaoVencedor());
				if (historico.getTipoVitoria() == TipoVitoria.NORMAL) {
					estaticasJ1.incrementaVitoria(TipoVitoria.NORMAL);
				} else if (historico.getTipoVitoria() == TipoVitoria.CARROCA) {
					estaticasJ1.incrementaVitoria(TipoVitoria.CARROCA);
				} else if (historico.getTipoVitoria() == TipoVitoria.LA_E_LO) {
					estaticasJ1.incrementaVitoria(TipoVitoria.LA_E_LO);
				} else if (historico.getTipoVitoria() == TipoVitoria.CRUZADA) {
					estaticasJ1.incrementaVitoria(TipoVitoria.CRUZADA);
				}
			} else if (historico.getVencedor() == "J2") {
				estaticasJ2.incrementaVitorias();
				estaticasJ2.incrementaPontuacao(historico.getPontuacaoVencedor());
				if (historico.getTipoVitoria() == TipoVitoria.NORMAL) {
					estaticasJ2.incrementaVitoria(TipoVitoria.NORMAL);
				} else if (historico.getTipoVitoria() == TipoVitoria.CARROCA) {
					estaticasJ2.incrementaVitoria(TipoVitoria.CARROCA);
				} else if (historico.getTipoVitoria() == TipoVitoria.LA_E_LO) {
					estaticasJ2.incrementaVitoria(TipoVitoria.LA_E_LO);
				} else if (historico.getTipoVitoria() == TipoVitoria.CRUZADA) {
					estaticasJ2.incrementaVitoria(TipoVitoria.CRUZADA);
				}
			}
		}

		System.out.println("E1: " + estrategia1.toString() + "\nE2: " + estrategia2.toString() + "\nJogos:\t"
				+ (REPETICOES) + "\n\n- Vitórias E1:\t" + estaticasJ1.getVitorias() + " vitórias ("
				+ Math.round(estaticasJ1.getVitorias() / REPETICOES * 100) + "%)" 
				+ "\n   Vitórias Normais: " + estaticasJ1.getVitoria(TipoVitoria.NORMAL) + "\n   Vitórias de Carroça: " + estaticasJ1.getVitoria(TipoVitoria.CARROCA)
				+ "\n   Vitórias Lá e Lô: " + estaticasJ1.getVitoria(TipoVitoria.LA_E_LO) + "\n   Vitórias de Cruzada: " + estaticasJ1.getVitoria(TipoVitoria.CRUZADA)
				+ "\n- Pontuação E1:\t" + estaticasJ1.getPontuacao() + " pontuação (" 
				+ Math.round(estaticasJ1.getPontuacao() / (estaticasJ1.getPontuacao()+estaticasJ2.getPontuacao()) * 100) + "%)" 
				+ "\n\n- Vitórias E2:\t" + estaticasJ2.getVitorias() + " vitórias (" + Math.round(estaticasJ2.getVitorias() / REPETICOES * 100) + "%)"
				+ "\n   Vitórias Normais: " + estaticasJ2.getVitoria(TipoVitoria.NORMAL) + "\n   Vitórias de Carroça: " + estaticasJ2.getVitoria(TipoVitoria.CARROCA) 
				+ "\n   Vitórias Lá e Lô: " + estaticasJ2.getVitoria(TipoVitoria.LA_E_LO) + "\n   Vitórias de Cruzada: " + estaticasJ2.getVitoria(TipoVitoria.CRUZADA)
				+ "\n- Pontuação E2:\t" + estaticasJ2.getPontuacao() + " pontuação ("
				+ Math.round(estaticasJ2.getPontuacao() / (estaticasJ1.getPontuacao()+estaticasJ2.getPontuacao()) * 100) + "%)" 
				+ "\n\n- Empates:\t" + empates + "\t\t(" + Math.round(empates / REPETICOES * 100) + "%)");
	}
}

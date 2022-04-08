package ufcg.ccc.domino;

import java.util.HashMap;
import java.util.Map;

import ufcg.ccc.domino.Jogo.TipoVitoria;

/**
 * As estatísticas de um jogador que jogou um número de partidas n, tal que n > 1.
 *
 */
public class EstatisticasJogador {
	float vitorias, pontuacao;
	Map<Jogo.TipoVitoria, Integer> mapaVitoriaQuant;
	
	public EstatisticasJogador() {
		this.vitorias = 0;
		this.pontuacao = 0;
		this.mapaVitoriaQuant = new HashMap<Jogo.TipoVitoria, Integer>();
		this.mapaVitoriaQuant.put(TipoVitoria.NORMAL, 0);
		this.mapaVitoriaQuant.put(TipoVitoria.CARROCA, 0);
		this.mapaVitoriaQuant.put(TipoVitoria.LA_E_LO, 0);
		this.mapaVitoriaQuant.put(TipoVitoria.CRUZADA, 0);
	}
	
	/**
	 * Retorna a quantidade de vitórias totais do jogador.
	 * 
	 * @return float quant de vitórias totais do jogador.
	 */
	public float getVitorias() {
		return vitorias;
	}
	
	/**
	 * Adiciona um a quantidade de vitórias totais do jogador.
	 * 
	 * @return float quant de vitórias totais do jogador.
	 */
	public void incrementaVitorias() {
		this.vitorias++;
	}
	
	/**
	 * Retorna a quantidade de vitórias do jogador.
	 * 
	 * @return float Pontuação do jogador até o momento
	 */
	public float getPontuacao() {
		return this.pontuacao;
	}
	
	public void incrementaPontuacao(int incremento) {
		this.pontuacao += incremento;
	}
	
	/**
	 * Retorna a quantidade de vitórias de dado tipo de vitória do jogador.
	 * 
	 * @param tipoVitoria Tipo de vitoria esperada.
	 * @return int quant de vitórias do tipo de vitoria passado do jogador
	 */
	public int getVitoria(Jogo.TipoVitoria tipoVitoria) {
		return this.mapaVitoriaQuant.get(tipoVitoria);
	}
	
	/**
	 * Incrementa o número de vitórias de dado tipo de vitória do jogador.
	 * 
	 * @param tipoVitoria Tipo de vitoria esperada.
	 * @return int quant de vitórias do tipo de vitoria passado do jogador
	 */
	public void incrementaVitoria(Jogo.TipoVitoria tipoVitoria) {
		int valor = this.mapaVitoriaQuant.get(tipoVitoria);
		this.mapaVitoriaQuant.replace(tipoVitoria, valor+1);
	}
}

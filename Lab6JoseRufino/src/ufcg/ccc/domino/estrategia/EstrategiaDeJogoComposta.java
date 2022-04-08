package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

/**
 * Dentre duas ou mais estratégias possíveis, decide qual delas utilizar, sendo a primeira a ser
 * usada a que vier primeiro na lista com as estratégias passadas, seguindo essa ordem.
 * Realiza tal estratégia com o método decideJogada.
 */
public class EstrategiaDeJogoComposta implements EstrategiaDeJogo {
	private List<EstrategiaDeJogo> estrategias;
	private int indiceProximaEstrategia;
	private EstrategiaDeJogo estrategiaASerUtilizada;
	
	
	public EstrategiaDeJogoComposta(List<EstrategiaDeJogo> estrategias) {
		this.estrategias = estrategias;
		this.indiceProximaEstrategia = -1;
	}
	
	private EstrategiaDeJogo decideEstrategia() {
		
		if (indiceProximaEstrategia == -1) {
			this.estrategiaASerUtilizada = this.estrategias.get(0);
			this.indiceProximaEstrategia = 1;
		}
		else {
			this.estrategiaASerUtilizada = this.estrategias.get(this.indiceProximaEstrategia);
			this.indiceProximaEstrategia++;
			if (this.indiceProximaEstrategia > 2) {
				this.indiceProximaEstrategia = 0;
			}
		}
		return estrategiaASerUtilizada;
	}
	
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		return this.decideEstrategia().decideJogada(mao, mesa);
	}
	
	@Override
	public String toString() {
		return "Joga uma das Estratégias Compostas";
	}
}

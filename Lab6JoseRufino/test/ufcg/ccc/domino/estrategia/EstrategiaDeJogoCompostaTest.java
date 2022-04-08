package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaDeJogoComposta;
import ufcg.ccc.domino.estrategia.JogaMaiorPeca;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;
import ufcg.ccc.domino.Jogada.TipoJogada;

class EstrategiaDeJogoCompostaTest {

	private Mesa mesa;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
	}

	@Test
	void testPassa() {
		List<EstrategiaDeJogo> estrategias = List.of(new JogaPrimeiraPossivel(), new JogaMaiorPeca());
		EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(0, 3)), mesa);

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}

	@Test
	void testJogaPrimeiraPossivel() {
		List<EstrategiaDeJogo> estrategias = List.of(new JogaPrimeiraPossivel(), new JogaMaiorPeca());
		EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);
		JogaPrimeiraPossivel estrategia1 = new JogaPrimeiraPossivel();
		
		Jogada j1 = estrategia.decideJogada(List.of(new Peca(6, 2), new Peca(0, 2), new Peca(3, 2)), mesa);
		Jogada j2 = estrategia1.decideJogada(List.of(new Peca(6, 2), new Peca(0, 2), new Peca(3, 2)), mesa);
		
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(j1.getPeca().getNumEsquerdo(), j2.getPeca().getNumEsquerdo());
		assertEquals(j1.getPeca().getNumDireito(), j2.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaMaiorPeca() {
		List<EstrategiaDeJogo> estrategias = List.of(new JogaPrimeiraPossivel(), new JogaMaiorPeca());
		EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);
		JogaPrimeiraPossivel estrategia1 = new JogaPrimeiraPossivel();
		JogaMaiorPeca estrategia2 = new JogaMaiorPeca();
		
		estrategia.decideJogada(List.of(new Peca(6, 2), new Peca(0, 2), new Peca(3, 2)), mesa);
		estrategia1.decideJogada(List.of(new Peca(6, 2), new Peca(0, 2), new Peca(3, 2)), mesa);
		
		Jogada outraJ1 = estrategia.decideJogada(List.of(new Peca(0, 2), new Peca(3, 2)), mesa);
		Jogada outraJ2 = estrategia2.decideJogada(List.of(new Peca(0, 2), new Peca(3, 2)), mesa);
		
		
		assertEquals(TipoJogada.NA_DIREITA, outraJ1.getTipo());
		assertEquals(outraJ1.getPeca().getNumEsquerdo(), outraJ2.getPeca().getNumEsquerdo());
		assertEquals(outraJ1.getPeca().getNumDireito(), outraJ2.getPeca().getNumDireito());
	}
}

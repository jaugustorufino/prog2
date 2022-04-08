package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;

class JogaMaiorPecaTest {

	private Mesa mesa;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
	}

	@Test
	void testPassa() {
		JogaMaiorPeca estrategia = new JogaMaiorPeca();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(0, 3)), mesa);

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}

	@Test
	void testJogaMaiorPeca() {
		JogaMaiorPeca estrategia = new JogaMaiorPeca();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 2), new Peca(0, 2), new Peca(6, 2)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(6, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}

	@Test
	void testSomaIgual() { // Prefere a primeira peça na ordem original
		JogaMaiorPeca estrategia = new JogaMaiorPeca();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 2), new Peca(1, 4), new Peca(6, 3)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(3, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}

	@Test
	void testPrefereDireita() {
		JogaMaiorPeca estrategia = new JogaMaiorPeca();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(5, 6), new Peca(2, 1), new Peca(3, 3)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
	}

	@Test
	void testJogaNaEsquerda() {
		JogaMaiorPeca estrategia = new JogaMaiorPeca();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(4, 4), new Peca(1, 6)), mesa);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());

	}
}

package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

class JogaPrimeiraPossivelComparadoraTest {

	private Mesa mesa;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 3));
		mesa.jogaNaEsquerda(new Peca(0, 1));
	}

	@Test
	void testPassa() {
		PecaPadraoComparator comparador = new PecaPadraoComparator();
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(comparador);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 1), new Peca(5, 4)), mesa);

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}

	@Test
	void testJogaPrimeira() {
		PecaPadraoComparator comparador = new PecaPadraoComparator();
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(comparador);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(0, 2), new Peca(2, 6)), mesa);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(0, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}

	@Test
	void testPrefereDireita() {
		PecaPadraoComparator comparador = new PecaPadraoComparator();
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(comparador);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 5), new Peca(2, 1), new Peca(2, 6)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(3, j1.getPeca().getNumEsquerdo());
		assertEquals(5, j1.getPeca().getNumDireito());
	}

	@Test
	void testJogaNaEsquerda() {
		PecaPadraoComparator comparador = new PecaPadraoComparator();
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(comparador);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(0, 4), new Peca(1, 6)), mesa);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(0, j1.getPeca().getNumEsquerdo());
		assertEquals(4, j1.getPeca().getNumDireito());
	}

}

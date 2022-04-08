package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;

class JogaCarrocaTest {

	private Mesa mesa;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
	}

	@Test
	void testPassa() {
		JogaCarroca estrategia = new JogaCarroca();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(0, 3)), mesa);

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}

	@Test
	void testJogaCarroca() {
		JogaCarroca estrategia = new JogaCarroca();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 2), new Peca(3, 3), new Peca(2, 2)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testJogoComMaisDeUmaCarrocaPossivel() { // Joga a primeira carroça possível, partindo da ordem original
		JogaCarroca estrategia = new JogaCarroca();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 1), new Peca(3, 3), new Peca(2, 2)), mesa);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testJogoSemCarrocasQueEncaixamNaMesa() {
		JogaCarroca estrategia = new JogaCarroca();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(6, 6), new Peca(0, 0), new Peca(0, 2)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(0, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testJogoSemCarrocas() {
		JogaCarroca estrategia = new JogaCarroca();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(2, 3), new Peca(2, 1), new Peca(1, 6)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(3, j1.getPeca().getNumDireito());
	}

}

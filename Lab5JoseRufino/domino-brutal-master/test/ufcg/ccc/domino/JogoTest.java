package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogo.TipoVitoria;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;

class JogoTest {

	@Test
	void testRodadaInicial() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 14);

		assertEquals(0, j.getNumRodadas());
		assertEquals(14, j.getNumPecasJ1());
		assertEquals(14, j.getNumPecasJ2());

		j.rodada();

		assertEquals(1, j.getNumRodadas());
		assertEquals(13, j.getNumPecasJ1());
		assertEquals(13, j.getNumPecasJ2());
	}
	
	@Test
	void testJogoAleatorio() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 10, new Random(1));

		HistoricoDeJogo historico = j.jogaJogoCompleto();

		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		
		System.out.println(historico.toString());
	}

	@Test
	void testVencedorJ1Simples() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 1));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		assertEquals(TipoVitoria.NORMAL, j.jogaJogoCompleto().getTipoVitoria());
		assertEquals(1, j.jogaJogoCompleto().getPontuacaoVencedor());
	}
	
	@Test
	void testVencedorJ1Carrocao() throws Exception {
		List<Peca> mao1 = List.of(new Peca(2, 3), new Peca(2, 2), new Peca(0, 0));
		List<Peca> mao2 = List.of(new Peca(0, 3), new Peca(1, 2), new Peca(4, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		assertEquals(TipoVitoria.CARROCA, j.jogaJogoCompleto().getTipoVitoria());
		assertEquals(2, j.jogaJogoCompleto().getPontuacaoVencedor());
	}
	
	@Test
	void testVencedorJ1LaELo() throws Exception {
		List<Peca> mao1 = List.of(new Peca(3, 5), new Peca(3, 3), new Peca(0, 1));
		List<Peca> mao2 = List.of(new Peca(0, 5), new Peca(1, 3), new Peca(4, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		assertEquals(TipoVitoria.LA_E_LO, j.jogaJogoCompleto().getTipoVitoria());
		assertEquals(3, j.jogaJogoCompleto().getPontuacaoVencedor());
	}
	
	@Test
	void testVencedorJ1Cruzada() throws Exception {
		List<Peca> mao1 = List.of(new Peca(3, 2), new Peca(2, 2), new Peca(1, 1));
		List<Peca> mao2 = List.of(new Peca(3, 1), new Peca(2, 1), new Peca(4, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		assertEquals(TipoVitoria.CRUZADA, j.jogaJogoCompleto().getTipoVitoria());
		assertEquals(6, j.jogaJogoCompleto().getPontuacaoVencedor());
	}
	
	@Test
	void testEmpate() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertNull(j.getVencedor());
	}
	
	@Test
	void testVitoriaJ2Simples() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(6, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(1, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
		assertEquals(TipoVitoria.NORMAL, j.jogaJogoCompleto().getTipoVitoria());
		assertEquals(1, j.jogaJogoCompleto().getPontuacaoVencedor());
	}
	
	@Test
	void testVencedorJ2Carrocao() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 3), new Peca(1, 2), new Peca(4, 1));
		List<Peca> mao2 = List.of(new Peca(2, 3), new Peca(1, 2), new Peca(0, 0));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
		assertEquals(TipoVitoria.CARROCA, j.jogaJogoCompleto().getTipoVitoria());
		assertEquals(2, j.jogaJogoCompleto().getPontuacaoVencedor());
	}
	
	@Test
	void testVencedorJ2LaELo() throws Exception {
		List<Peca> mao1 = List.of(new Peca(3, 5), new Peca(3, 4), new Peca(3, 1));
		List<Peca> mao2 = List.of(new Peca(1, 5), new Peca(5, 1), new Peca(4, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
		assertEquals(TipoVitoria.LA_E_LO, j.jogaJogoCompleto().getTipoVitoria());
		assertEquals(3, j.jogaJogoCompleto().getPontuacaoVencedor());
	}
	
	@Test
	void testVencedorJ2Cruzada() throws Exception {
		List<Peca> mao1 = List.of(new Peca(3, 1), new Peca(1, 4), new Peca(5, 3));
		List<Peca> mao2 = List.of(new Peca(3, 2), new Peca(4, 2), new Peca(2, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
		assertEquals(TipoVitoria.CRUZADA, j.jogaJogoCompleto().getTipoVitoria());
		assertEquals(6, j.jogaJogoCompleto().getPontuacaoVencedor());
	}
	
	
	@Test
	void testDesempateMenosPecas() throws Exception {
		List<Peca> mao1 = new ArrayList<Peca>();
		mao1.add(new Peca(1, 1));
		mao1.add(new Peca(2, 2));
		
		List<Peca> mao2 = new ArrayList<Peca>();
		mao2.add(new Peca(1, 5));
		mao2.add(new Peca(2, 2));
		mao2.add(new Peca(4, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());

	}
	
	@Test
	void testDesempateSomaMenorDePontos() throws Exception {
		List<Peca> mao1 = new ArrayList<Peca>();
		mao1.add(new Peca(1, 1));
		mao1.add(new Peca(2, 6));
		
		List<Peca> mao2 = new ArrayList<Peca>();
		mao2.add(new Peca(1, 5));
		mao2.add(new Peca(2, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
	}
	
	@Test
	void testPontuacaoVencedor() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertNull(j.getVencedor());
	}
	
}

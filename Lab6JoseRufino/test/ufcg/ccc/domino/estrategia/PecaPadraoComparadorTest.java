package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Peca;

class PecaPadraoComparadorTest {
	private Peca peca1;
	private Peca peca2;
	private Peca peca3;
	private Peca peca4;
	private Peca peca5;
	private Peca peca6;
	private Peca peca7;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.peca1 = new Peca(4, 6);
		this.peca2 = new Peca(2, 5);
		this.peca3 = new Peca(6, 2);
		this.peca4 = new Peca(1, 4);
		this.peca5 = new Peca(0, 1);
		this.peca6 = new Peca(3, 5);
		this.peca7 = new Peca(0, 0);
	}
	
	@Test
	void testOrdenaPeca() {
		Comparator<Peca> comparador = new PecaPadraoComparator();
		
		List<Peca> mao = Arrays.asList(peca1, peca2, peca3, peca4, peca5, peca6, peca7);
		List<Peca> maoOrdenada = Arrays.asList(peca7, peca5, peca4, peca2, peca6, peca1, peca3);
		Collections.sort(mao, comparador);
		
		assertEquals(mao, maoOrdenada);
	}
	
	@Test
	void testOrdenaPeca2() {
		Comparator<Peca> comparador = new PecaPadraoComparator();
		
		List<Peca> mao = Arrays.asList(peca6, peca7, peca1, peca5, peca4, peca3, peca2);
		List<Peca> maoOrdenada = Arrays.asList(peca7, peca5, peca4, peca2, peca6, peca1, peca3);
		Collections.sort(mao, comparador);
		
		assertEquals(mao, maoOrdenada);
	}
}

package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PecaTest {


	@Test
	void testGetNumDireito() {
		assertEquals(1, (new Peca(6, 1)).getNumDireito());
		assertEquals(3, (new Peca(3, 3)).getNumDireito());
	}

	@Test
	void testGetNumEsquerdo() {
		assertEquals(6, (new Peca(6, 1)).getNumEsquerdo());
		assertEquals(3, (new Peca(3, 3)).getNumEsquerdo());
	}

	@Test
	void testGira() {
		Peca peca = new Peca(6, 1); 
		
		peca.gira();
		assertEquals(6, peca.getNumDireito());
		assertEquals(1, peca.getNumEsquerdo());
		
		peca.gira();
		assertEquals(1, peca.getNumDireito());
		assertEquals(6, peca.getNumEsquerdo());
	}
	
	@Test
	void testToString() throws Exception {
		assertEquals("6:1", (new Peca(6, 1)).toString());
		assertEquals("3:3", (new Peca(3, 3)).toString());
	}
	
	@Test
	void testEncaixa() {
		Peca peca1 = new Peca(0, 5);
		assertEquals(true, peca1.encaixa(0));
		assertEquals(false, peca1.encaixa(2));
	}
	
	@Test
	void testCompareTo() {
		Peca peca1 = new Peca(0, 5);
		Peca peca2 = new Peca(4, 0);
		Peca peca3 = new Peca(2, 3);
		assertEquals(-1, peca1.compareTo(peca2));
		assertEquals(1, peca2.compareTo(peca3));
		assertEquals(0, peca1.compareTo(peca3));
	}
	
}

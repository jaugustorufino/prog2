import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Contato;

/**
 * Classe que representa os testes da classe Contato, que cria um Contato, que pode ser usado
 * numa lista de contatos.
 * 
 * @author Jose A. O. Rufino
 * 
 */
class ContatoTest {
	
	private Contato contatoBase;
	
	@BeforeEach
	void preparaContatos() { // Preparando cada método de teste da classe
		this.contatoBase = new Contato("Matheus", "Gaudencio",
				"(83) 99999-0000", "(83) 99999-0001", "");
	}
	
	@Test
	void testNomeCompleto() { // Testando se o método getNomeCompleto funciona corretamente
		String msg = "Esperando obter o nome completo";
		assertEquals("Matheus Gaudencio", this.contatoBase.getNomeCompleto(), msg);
	}
	
	@Test
	void testToString() { // Testando se o método toString, da classe Contato, retorna os dados corretamente
		String msg = "Esperando obter a representação toString";
		assertEquals(("Matheus Gaudencio" + 
				"\n(83) 99999-0000 (Prioritario)" + 
				"\n(83) 99999-0001 (Whatsapp)\n"), this.contatoBase.toString(), msg);
	}
	
	@Test
	void testEquals() { // Testando se o método equals funciona corretamente (Nome e Sobrenome Iguais)
		Contato c1 = new Contato("Robson", "Silva",
				"(83) 99999-0000", "(83) 99999-0001", "");
		assert this.contatoBase.equals(c1) == false; // Testando se o método equals funciona para contatos diferentes
		
		Contato c2 = new Contato("Matheus", "Gaudencio",
				"(83) 99999-1111", "(83) 99999-2222", "");
		assert this.contatoBase.equals(c2); // Testando se o método equals funciona para contatos iguais
	}
	
	@Test
	void testNomeInvalido() {
		try { // Testando o que ocorre quando o nome é uma String vazia.
			new Contato("", "Gaudencio", "21010000", "", "");
	
			fail("Era esperado exceção ao passar código nulo");
		 } 
		catch (IllegalArgumentException iae) {
	
		}
		
		try { // Testando o que ocorre quando o nome é uma String com espaços.
			new Contato("  ", "Gaudencio", "21010000", "", "");
	
			fail("Era esperado exceção ao passar código nulo");
		 } 
		catch (IllegalArgumentException iae) {
	
		}
	}
	
	@Test
	void testArgumentosNull() {
		
		try { // Testando o que ocorre quando o nome é nulo.
			new Contato(null, "Gaudencio", "21010000", "", "");
	
			fail("Era esperado exceção ao passar código nulo");
		 } 
		catch (NullPointerException npe) {
	
		}
		
		try { // Testando o que ocorre quando o sobrenome é nulo.
			new Contato("Matheus", null, "21010000", "", "");
	
			fail("Era esperado exceção ao passar código nulo");
		 } 
		catch (NullPointerException npe) {
	
		}
		
		try { // Testando o que ocorre quando o tel prioritário é nulo.
			new Contato("Matheus", "Gaudencio", null, "11111", "5555");
	
			fail("Era esperado exceção ao passar código nulo");
		 } 
		catch (NullPointerException npe) {
	
		}
		
		try { // Testando o que ocorre quando o tel whatsapp é nulo.
			new Contato("Matheus", "Gaudencio", "21010000", null, "5555");
	
			fail("Era esperado exceção ao passar código nulo");
		 } 
		catch (NullPointerException npe) {
	
		}
		
		try { // Testando o que ocorre quando o tel adicional é nulo.
			new Contato("Matheus", "Gaudencio", "21010000", "22222", null);
	
			fail("Era esperado exceção ao passar código nulo");
		 } 
		catch (NullPointerException npe) {
	
		}
	}
}
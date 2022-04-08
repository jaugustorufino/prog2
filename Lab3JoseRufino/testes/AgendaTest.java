import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;

/**
 * Classe que visa testar todos os métodos necessários da classe Agenda, que
 * cria uma lista de contatos, podendo cadastrar um contato, listar todos os já cadastrados,
 * exibir cada contato com seus dados e adicionar e imprimir os contatos favoritos.
 * 
 * @author Jose A. O. Rufino
 *
 */
class AgendaTest {
	
	private Agenda agendaBase;

	@BeforeEach
	void preparaAgenda() { // Preparando cada método de teste da classe
		this.agendaBase = new Agenda();
		this.agendaBase.cadastraContato(1, "Matheus", "Gaudencio",
				"(83) 99999-0000", "(83) 99999-0001", "");
		this.agendaBase.cadastraContato(100, "José", "Augusto",
				"(83) 8888-7777", "(83) 8888-8888", "888-1234");
		this.agendaBase.cadastraContato(5, "Maria", "da Silva",
				"111-1111", "222-2222", "");
		this.agendaBase.cadastraContato(10, "Joana", "dos Santos",
				"333-1221", "444-2322", "");
		this.agendaBase.adicionaFavorito(1, 1);
		this.agendaBase.adicionaFavorito(5, 2);
	}

	@Test
	void testCadastraContato() { // Testando se o método cadastraContato da classe Agenda funciona corretamente
		assert this.agendaBase.cadastraContato(5, "Josué", "da Silva", // Cadastro realizado normalmente
				"(83) 99999-0000", "(83) 99999-0001", "");
		assert this.agendaBase.cadastraContato(0, "Ouvidoria", "UFCG", // Posição menor que 1 (limite inferior)
				"(83) 91234-1234", "(83) 92312-1223", "3333-3333") == false;
		assert this.agendaBase.cadastraContato(101, "Ouvidoria", "UFCG", // Posição do limite superior ultrapassada
				"(83) 91234-1234", "(83) 92312-1223", "3333-3333") == false; 
		assert this.agendaBase.cadastraContato(10, "Matheus", "Gaudencio", // Contato ja cadastrado
				"(83) 98888-2222", "(83) 98888-1111", "1234") == false;
		assert this.agendaBase.cadastraContato(100, "João", "da Silva", // Sobreescrita de contato
				"(83) 98821-3423", "(83) 98123-1233", "");
	}
	
	@Test
	void testExibeContato() { // Testando se o método exibeContato da classe Agenda retorna os dados do contato ou não
		String msg = "Esperando obter a exibição do Contato";
		assertEquals(("José Augusto" +  // Contao já cadastrado, com todos os dados pedidos.
				"\n(83) 8888-7777 (Prioritario)" + 
				"\n(83) 8888-8888 (Whatsapp)" +
				"\n888-1234 (Adicional)\n"), this.agendaBase.exibeContato(100), msg);
		assertEquals(("❤️ Matheus Gaudencio" + 
				"\n(83) 99999-0000 (Prioritario)" + 
				"\n(83) 99999-0001 (Whatsapp)\n"), this.agendaBase.exibeContato(1), msg); // Contato Favoritado e sem Adicional.
		assertEquals(null, this.agendaBase.exibeContato(2), msg); // Contato ainda não cadastrado.
	}
	
	@Test
	void testListaContatos() { // Testando se o método listaContato da classe Agenda imprime os contatos corretamente
		String msg = "Esperando obter a listagem dos Contatos";
		assertEquals(("1 - Matheus Gaudencio\n" +
				"5 - Maria da Silva\n" +
				"10 - Joana dos Santos\n" +
				"100 - José Augusto\n"), this.agendaBase.listaContatos(), msg);
	}
	
	@Test
	void testAdicionaFavorito() { // Testando se o método adicionaFavorito da classe Agenda funciona corretamente
		assert this.agendaBase.adicionaFavorito(100, 3); // Adiciona contato a lista de favoritos numa posição vazia
		assert this.agendaBase.adicionaFavorito(10, 1); // Substitui o contato favoritado anteriormente
		assert this.agendaBase.adicionaFavorito(100, 11) == false; // Posição maior que 10 (limite superior - Favoritos)
		assert this.agendaBase.adicionaFavorito(100, 0) == false; // Posição menor que 1 (limite inferior - Favoritos)
		assert this.agendaBase.adicionaFavorito(101, 3) == false; // Posição maior que 100 (limite superior - Contatos)
		assert this.agendaBase.adicionaFavorito(0, 3) == false; // Posição menor que 1 (limite inferior - Contatos)
		assert this.agendaBase.adicionaFavorito(5, 5) == false; // Contato já favoritado
	}
	
	@Test
	void testListaFavoritos() { // Testando se o método listaFavoritos da classe Agenda imprime os favoritos corretamente
		String msg = "Esperando obter a listagem dos Contatos Favoritos";
		assertEquals("1 - Matheus Gaudencio\n" +
					"2 - Maria da Silva\n", this.agendaBase.listaFavoritos(), msg);
		this.agendaBase.adicionaFavorito(100, 1); // Exclusão do contato ex favoritado da lista de favoritos
		assertEquals("1 - José Augusto\n" +
				"2 - Maria da Silva\n", this.agendaBase.listaFavoritos(), msg);
	}

}

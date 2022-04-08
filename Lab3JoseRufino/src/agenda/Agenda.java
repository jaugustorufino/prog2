package agenda;

/**
 * Classe que sustenta uma listagem de contatos e cada contato pode estar em uma de 100 posições da Agenda.
 * Cada posição representa um Contato, que tem:
 * Nome, Sobrenome, Telefone Prioritário, Telefone Whatsapp e Telefone Adicional. 
 * Com a classe Agenda é possível cadastrar um contato, listar todos os já cadastrados, exibir cada contato
 * com seus dados, adicionar um contato a lista de favoritos e imprimir os contatos favoritos.
 * 
 * @author Jose A. O. Rufino
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private static final int TAMANHO_AGENDA_FAVORITOS = 10;
	
	private Contato[] contatos;
	
	private Contato[] favoritos;

	/**
	 * Cria uma agenda de contatos de tamanho 100.
	 * Cria uma agenda de contatos favoritados de tamanho 10.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_AGENDA_FAVORITOS];
	}
	
	/**
	* Verifica a existência de um contato na Agenda.
	* @return Se o contato existe na Agenda, o retorno é true, mas se não existe, o retorno é false.
	*/
	private boolean existeContato(Contato contato) {
		for (int i = 0; i < contatos.length; i++) {
			if ((contatos[i] != null) && (contatos[i].equals(contato))) {
					return true;
			}
		}
		return false;
	}

	/**
	 * Cadastra um contato em uma posição da agenda e Cria esse contato com seus dados (Nome, Sobrenome,
	 * Telefone Prioritário, Telefone Whatsapp e Telefone Adicional).
	 * Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * Um cadastro em uma posiçao maior ou menor que os limites, ou seja, inválida é ignorado.
	 * Um cadastro de um contato já cadastrado, sendo isto verificado pelo seu nome e seu sobrenome, é ignorado.
	 * 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param prioritario Telefone prioritário do contato.
	 * @param whatsapp Telefone Whatsapp do contato.
	 * @param adicional Telefone Adicional do contato.
	 * 
	 * @return int Para Posição Inválida (-1); Para Contato já cadastrado (0); Para Cadastro Realizado (posicao).
	 */
	public boolean cadastraContato(int posicao, String nome, String sobrenome,
			String prioritario, String whatsapp, String adicional) {
		if (posicao < 1 || posicao > 100) {
			return false;
		}
		else {
			Contato c1 = new Contato(nome, sobrenome, prioritario, whatsapp, adicional);
			if (existeContato(c1)) {
				return false;
			}
			else {
				this.contatos[posicao - 1] = c1;
				return true;
			}
		}
	}
	
	/**
	 * Exibe os dados de um Contato, dada sua posição.
	 * 
	 * @param posicao Posição do contato.
	 * 
	 * @return Se o contato já foi cadastrado, retorna a String que o representa.
	 * Se não, retorna null.
	 */
	public String exibeContato(int posicao) {
		if (this.contatos[posicao-1] != null) {
			Contato contatoAExibir = this.contatos[posicao-1];
			
			for (int i = 0; i < this.favoritos.length; i++) {
				if (this.favoritos[i] != null) {
					if (this.favoritos[i].equals(contatoAExibir)) {
						return "❤️ " + contatoAExibir.toString();
					}
				}
			}
			
			return contatoAExibir.toString();
		}
		else {
			return null;
		}
	}
	
	/**
	 * Lista todos os contatos cadastrados na Agenda até o momento.
	 * 
	 * @return String contendo todos os contatos cadastrados na Agenda ou
	 * se não há nenhum contato cadastrado, o retorno é uma String vazia.
	 */
	public String listaContatos() {
		String listaContatos = ""; 
		
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null) {
					listaContatos += (i+1) + " - " + this.contatos[i].getNomeCompleto() + "\n";
			}
		}
		return listaContatos;
	}
	
	/**
	 * Adiciona um contato a Lista de Favoritos da Agenda
	 * 
	 * Um acréscimo de favorito em uma posição que já existe sobrescreve o anterior.
	 * Um acréscimo de favorito em uma posiçao maior ou menor que os limites, ou seja, inválida é ignorado.
	 * Um acréscimo de favorito de um contato já favoritado, sendo isto verificado pelo seu nome e seu sobrenome, é ignorado.
	 * 
	 * @param posicaoContato Posição do contato.
	 * @param posicaoFavorito Posição do contato a ser favoritado.
	 * 
	 * @return int Para Posição Inválida (-1); Para Contato já favoritado (0);
	 * Para Contato Adicionado a lista de favoritos com sucesso (posicao).
	 */
	public boolean adicionaFavorito(int posicaoContato, int posicaoFavorito) {
		if ((posicaoContato < 1) || (posicaoContato > 100) || 
				(posicaoFavorito < 1) || (posicaoFavorito > 10)) {
			return false;
		}
		
		Contato contatoAFavoritar = this.contatos[posicaoContato - 1];
		
		for (int i = 0; i < this.favoritos.length; i++) {
			if (this.favoritos[i] != null) {
				if (this.favoritos[i].equals(contatoAFavoritar)) {
					return false;
				}
			}
		}
		
		this.favoritos[posicaoFavorito-1] = contatoAFavoritar;
		this.contatos[posicaoContato-1] = contatoAFavoritar;
		return true;
	}
	
	/**
	 * Lista todos os contatos favoritados na Agenda até o momento.
	 * 
	 * @return String contendo todos os contatos favoritados na Agenda ou
	 * se não há nenhum contato favoritado, o retorno é uma String vazia.
	 */
	public String listaFavoritos() {
		String listaFavoritos = ""; 
		
		for (int i = 0; i < this.favoritos.length; i++) {
			if (this.favoritos[i] != null) {
				listaFavoritos += (i+1) + " - " + this.favoritos[i].getNomeCompleto() + "\n";
			}
		}
		return listaFavoritos;
	}
}

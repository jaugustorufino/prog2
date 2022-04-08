package agenda;

/**
 * Classe que representa um Contato que pode ser colocado em uma Agenda de Contatos.
 * Cada Contato tem:
 * nome, sobrenome, telefone prioritário, telefone whatsapp e telefone adicional.
 * 
 * @author Jose A. O. Rufino
 *
 */
public class Contato {
	private String nome;
	private String sobrenome;
	private String prioritario;
	private String adicional;
	private String whatsapp;
	
	/**
	* Constrói/Cria um Contato, partindo de seus dados (argumentos): nome, sobrenome, tel.
	* prioritário, tel. whatsapp, tel. adicional. Além disso, lança uma exceção
	* NullPointerException caso um dos argumentos seja nulo.
	* 
	* @param nome nome do contato a ser criado.
	* @param sobrenome sobrenome do contato a ser criado.
	* @param prioritario telefone prioritario do contato a ser criado.
	* @param whatsapp telefone whatsapp do contato a ser criado.
	* @param adicional telefone adicional do contato a ser criado.
	*/
	public Contato(String nome, String sobrenome,
			String prioritario, String whatsapp, String adicional) {
		if ((nome == null) || (sobrenome == null) || (prioritario == null)
				|| (whatsapp == null) || (adicional == null)) {
		       throw new NullPointerException();
		    }
		else {
			if (!nome.trim().equals("")) {
				this.nome = nome;
				this.sobrenome = sobrenome;
				this.prioritario = prioritario;
				this.whatsapp = whatsapp;
				this.adicional = adicional;
			}
			else {
				 throw new IllegalArgumentException("o nome não pode ser uma string vazia"
				 		+ " ou composta apenas por espaços.");
			}
		}
	}
	
	/**
	* Retorna o nome completo do contato.
	* 
	* @return Nome Completo (nome + sobrenome) do contato criado.
	*/
	public String getNomeCompleto() {
		if (this.sobrenome.trim().equals("")) {
			return this.nome;
		}
		return this.nome + " " + this.sobrenome;
	}
	
	/**
	* Cria a representação em String dos dados do Contato.
	* 
	* @return String contendo a representação dos dados, separados por "\n".
	*/
	@Override
	public String toString() {
		String result = this.getNomeCompleto();
		
		if (!(this.prioritario.trim().equals("") || this.prioritario.trim().equals("\"\""))) {
			result += "\n" + this.prioritario + " (Prioritario)";
		}
		if (!(this.whatsapp.trim().equals("") || this.whatsapp.trim().equals("\"\""))) {
			result += "\n" + this.whatsapp + " (Whatsapp)";
		}
		if (!(this.adicional.trim().equals("") || this.adicional.trim().equals("\"\""))) {
			result += "\n" + this.adicional + " (Adicional)";	
		}
		
		return result + "\n";
	}

	/**
	* Compara dois contatos, sendo utilizados seus nomes e sobrenomes para a comparação.
	* 
	* @return boolean contendo true (para Contatos iguais)
	* ou false (para Contatos Diferentes).
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}
}
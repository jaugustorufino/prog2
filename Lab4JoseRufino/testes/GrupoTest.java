import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleDeAlunos.Aluno;
import controleDeAlunos.Grupo;

class GrupoTest {
	
	private Grupo grupoBase;
	private Aluno aluno1;
	private Aluno aluno2;
	
	@BeforeEach
	void preparaGrupo() {
		this.grupoBase = new Grupo("Listas", "Computação");
		this.aluno1 = new Aluno("12", "José", "Computação");
		this.aluno2 = new Aluno("14", "Maria", "Engenharia");
		this.grupoBase.cadastraAlunoNoGrupo(aluno1);
	}
	
	@Test
	void testRestricao() { // Testando se o método getRestricao funciona corretamente
		Grupo g1 = new Grupo("Kabum!", "");
		String msg = "Esperando obter a restrição do grupo";
		assertEquals("Computação", this.grupoBase.getRestricao(), msg);
		assertEquals("", g1.getRestricao());
	}
	
	@Test
	void testCadastraAlunoNull() {
		Aluno a1 = null;
		assertEquals(false, this.grupoBase.cadastraAlunoNoGrupo(a1));
	}
	@Test
	void testCadastraAlunoRestricao() {
		Aluno aluno = new Aluno("15", "João", "Computação");
		// a1 está no curso da restrição
		assertEquals(true, this.grupoBase.cadastraAlunoNoGrupo(aluno));
		// aluno2 não está no curso restringido
		assertEquals(false, this.grupoBase.cadastraAlunoNoGrupo(aluno2));
	}
	
	@Test
	void testPertenceAGrupoNull() {
		Aluno a1 = null;
		assertEquals(false, this.grupoBase.pertenceAGrupo(a1));
	}
	
	@Test
	void testPertenceAGrupo() {
		assertEquals(true, this.grupoBase.pertenceAGrupo(aluno1));
		assertEquals(false, this.grupoBase.pertenceAGrupo(aluno2));
	}
	
	@Test
	void testHashCode() {
		Grupo g1 = new Grupo("listas", "");
		Grupo g2 = new Grupo("Dicionários", "Computação");
		assertEquals(g1.hashCode(), this.grupoBase.hashCode());
		assertNotEquals(g2.hashCode(), this.grupoBase.hashCode());
	}
	
	@Test
	void testEquals() {
		Grupo g1 = new Grupo("listas", "");
		Grupo g2 = new Grupo("Dicionários", "Computação");
		assertEquals(g1, this.grupoBase);
		assertNotEquals(g2, this.grupoBase);
	}
}

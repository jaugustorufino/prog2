import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleDeAlunos.ControleDeAlunos;

class ControleDeAlunosTest {
	
	private ControleDeAlunos controleBase;
	
	@BeforeEach
	void preparaGrupo() {
		this.controleBase = new ControleDeAlunos();
		this.controleBase.cadastraAluno("250", "Gabriel Reyes", "Computação");
		this.controleBase.cadastraAluno("200", "Lili Camposh", "Computação");
		this.controleBase.cadastraAluno("202", "Angela Ziegler", "Medicina");
		this.controleBase.cadastraAluno("201", "Torbjorn Lindholm", "Engenharia Mecânica");
		this.controleBase.cadastraGrupo("Programação OO", "");
		this.controleBase.cadastraGrupo("Listas", "Computação");
		this.controleBase.alocaAluno("250", "Listas");
		this.controleBase.alocaAluno("200", "Programação OO");
		this.controleBase.registraRespondente("200");
		this.controleBase.registraRespondente("202");
	}
	
	@Test
	void testCadastraAluno() {
		// Cadastro de Aluno ainda não cadastrado.
		assertEquals(true, this.controleBase.cadastraAluno("12", "José", "Computação"));
		// Cadastro de Aluno com uma matrícula já cadastrada.
		assertEquals(false, this.controleBase.cadastraAluno("250", "Michael", "Administração"));
	}
	
	@Test
	void testExibeAluno() {
		// Exibir Aluno ainda não cadastrado.
		assertEquals("Aluno não cadastrado.", this.controleBase.exibeAluno("12"));
		// Exibir Aluno cadastrado com sucesso.
		assertEquals("Aluno: 250 - Gabriel Reyes - Computação", this.controleBase.exibeAluno("250"));
	}
	
	@Test
	void testCadastraGrupo() {
		// Cadastro de um grupo ainda não cadastrado.
		assertEquals(true, this.controleBase.cadastraGrupo("Strings", "Computação"));
		// Cadastro de um grupo já cadastrado.
		assertEquals(false, this.controleBase.cadastraGrupo("listas", ""));
	}
	
	@Test
	void testAlocaAlunoGrupoSemRestricao() {
		assertEquals(true, this.controleBase.alocaAluno("201", "Programação OO"));
		assertEquals(true, this.controleBase.alocaAluno("202", "Programação OO"));
	}
	
	@Test
	void testAlocaAlunoJaAlocado() {
		assertEquals(true, this.controleBase.alocaAluno("200", "Programação OO"));
	}

	@Test
	void testAlocaAlunoNaoCadastrado() {
		try {
			this.controleBase.alocaAluno("100", "Programação OO");
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Aluno não cadastrado.", iae.getMessage());
		}
	}
	
	@Test
	void testAlocaAlunoGrupoNaoCadastrado() {
		try {
			this.controleBase.alocaAluno("200", "Programação OO");
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Grupo não cadastrado.", iae.getMessage());
		}
	}
	
	@Test
	void testAlocaAlunoGrupoComRestricao() {
		// Aluno de Computação pode fazer parte do Grupo Listas, onde a restrição é Computação.
		assertEquals(true, this.controleBase.alocaAluno("200", "LiStAS"));
		// Aluno que não é de Computação não pode fazer parte do Grupo Listas.
		assertEquals(false, this.controleBase.alocaAluno("202", "LiStAS"));
	}
	
	@Test
	void testPertinenciaAGrupo() {
		assertEquals(true, this.controleBase.pertenceAGrupo("Listas", "250"));
		assertEquals(false, this.controleBase.pertenceAGrupo("Listas", "202"));
	}
	
	@Test
	void testPertinenciaAGrupoAlunoOuGrupoNaoCadastrado() {
		try {
			this.controleBase.pertenceAGrupo("Programação OO", "100");
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Aluno não cadastrado.", iae.getMessage());
		}
		
		try {
			this.controleBase.pertenceAGrupo("Anatomia", "200");
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Grupo não cadastrado.", iae.getMessage());
		}
	}
	
	@Test
	void testRegistraRespondente() {
		// Aluno não ainda não cadastrado.
		assertEquals(false, this.controleBase.registraRespondente("100"));
		// Aluno já cadastrado pode ser registrado.
		assertEquals(true, this.controleBase.registraRespondente("250"));
	}
	
	@Test
	void testImprimeRespondentes() {
		assertEquals("Alunos:\n"
				+ "1. 200 - Lili Camposh - Computação\n"
				+ "2. 202 - Angela Ziegler - Medicina\n", this.controleBase.imprimeRespondentes());
	}
	
	@Test
	void testGruposComRestricao() {
		assertEquals(1, this.controleBase.gruposComRestricao("Computação"));
		assertEquals(0, this.controleBase.gruposComRestricao("Medicina"));
		assertEquals(0, this.controleBase.gruposComRestricao("Engenharia Mecânica"));
	}
}
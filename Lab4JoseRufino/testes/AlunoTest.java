import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleDeAlunos.Aluno;

class AlunoTest {
	
	private Aluno alunoBase;
	private Aluno aluno2;
	
	@BeforeEach
	void preparaGrupo() {
		this.alunoBase = new Aluno("12", "José", "Computação");
		this.aluno2 = new Aluno("14", "Maria", "Engenharia");
	}
	@Test
	void testCurso() {
		String msg = "Esperando obter o Curso do Aluno";
		assertEquals("Computação", this.alunoBase.getCurso(), msg);
	}
	
	@Test
	void testHashCode() {
		Aluno a1 = new Aluno("12", "João", "Medicina");
		assertEquals(a1.hashCode(), this.alunoBase.hashCode());
		assertNotEquals(this.aluno2.hashCode(), this.alunoBase.hashCode());
	}
	
	@Test
	void testEquals() {
		Aluno a1 = new Aluno("12", "João", "Medicina");
		assertEquals(a1, this.alunoBase);
		assertNotEquals(this.aluno2, this.alunoBase);
	}
	
	@Test
	void testToString() {
		assertEquals("14 - Maria - Engenharia", this.aluno2.toString());
	}
}

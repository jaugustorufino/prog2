package agenda;

public class Testes {
	public static void main(String[] args) {
	
		Agenda agenda = new Agenda();
		
		agenda.cadastraContato(1, "Matheus", "Gaudencio",
		"(83) 99999-0000", "(83) 99999-0001", "");
		agenda.adicionaFavorito(1, 1);
//		assert agenda.cadastraContato(22, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002") == 12;
		
		System.out.println(agenda.exibeContato(1));
//		agenda.cadastraContato(1,  "Matheus", "Gaudencio",
//			"(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
	}
}

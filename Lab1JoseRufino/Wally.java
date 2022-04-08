/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * José A. O. Rufino - 120110844
 */

import java.util.Scanner;

public class Wally {
	public static String[] copiaAumentada(String[] listaNomes) {
		String[] novaLista = new String[listaNomes.length + 100];
		for (int i = 0; i < listaNomes.length; i++) {
			novaLista[i] = listaNomes[i];
		}
		return novaLista;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] possiveisNomes = new String[100];
		int cont = 0;
		String nome = ""; 
		while (true) {
			nome = "";
			String linha = sc.nextLine();
			for (String nomePossivel : linha.split(" ")) {
				if (nomePossivel.length() == 5) {
					nome = nomePossivel;
				}
			}
			if (cont >= possiveisNomes.length) {
				possiveisNomes = copiaAumentada(possiveisNomes);
			}
			if (nome.equals("")) {
				nome = "?";
			}
			if (nome.equals("wally")) {
				break;
			}
			possiveisNomes[cont] = nome;
			cont++;
		}
		for (int i = 0; i < cont; i++) {
			System.out.println(possiveisNomes[i]);
		}
	}
}
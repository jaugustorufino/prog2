/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * José A. O. Rufino - 120110844
 */

import java.util.Scanner;

public class Prova {
	public static int[] copiaAumentada(int[] listaNotas) {
		int[] novaLista = new int[listaNotas.length + 100];
		for (int i = 0; i < listaNotas.length; i++) {
			novaLista[i] = listaNotas[i];
		}
		return novaLista;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String linha = "";
		int[] notas = new int[100];
		int cont = 0;
		int soma = 0;
		while (true) {
			linha = sc.nextLine();
			if (linha.equals("-")) {
				break;
			}
			int nota = Integer.parseInt(linha.split(" ")[1]);
			notas[cont] = nota;
			cont++;
			soma += nota;
		}
		double media = soma / cont;
		int maior = 0;
		int menor = 1000;
		int acima = 0;
		int abaixo = 0;
		for (int i = 0; i < cont; i++) {
			if (notas[i] >= maior) {
				maior = notas[i];
			}
			if (notas[i] <= menor) {
				menor = notas[i];
			}
			if (notas[i] >= 700) {
				acima++;
			}
			if (notas[i] < 700) {
				abaixo++;
			}
		}
		System.out.println("maior: " + maior);
		System.out.println("menor: " + menor);
		System.out.println("media: " + (int) media);
		System.out.println("acima: " + acima);
		System.out.println("abaixo: " + abaixo);
	}
}
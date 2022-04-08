/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * José A. O. Rufino - 120110844
 */

import java.util.Scanner;

public class AcimaMedia {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String linha = sc.nextLine();
		int soma = 0;
		int quant = 0;
		for (String num : linha.split(" ")) {
			soma += Integer.parseInt(num);
			quant++;
		}
		String r = "";
		double media = soma/quant;
		for (String num : linha.split(" ")) {
			if (Integer.parseInt(num) > media) {
				r += num;
				r += " ";
			}
		}
		r = r.trim();
		System.out.println(r);
	}
}
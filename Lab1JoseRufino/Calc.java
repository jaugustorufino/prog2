/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * José A. O. Rufino - 120110844
 */

import java.util.Scanner;

public class Calc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String op = sc.nextLine();

		if ((! (op.equals("+"))) && (! (op.equals("-"))) && (! (op.equals("*"))) && (! (op.equals("/")))) {
			System.out.println("ENTRADA INVALIDA");
			System.exit(0);
		}

		float n1 = sc.nextFloat();
		float n2 = sc.nextFloat();

		if (op.equals("+")) {
			System.out.println("RESULTADO: " + (n1+n2));
		}
		else if (op.equals("-")) {
			System.out.println("RESULTADO: " + (n1-n2));
		}
		else if (op.equals("*")) {
			System.out.println("RESULTADO: " + (n1*n2));
		}
		else if ((op.equals("/")) && (n2 != 0)) {
			System.out.println("RESULTADO: " + (n1/n2));
		}
		else if (n2 == 0) {
			System.out.println("ERRO");
		}
	}
}
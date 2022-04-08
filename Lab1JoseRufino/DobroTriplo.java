/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * José A. O. Rufino - 120110844
 */

import java.util.Scanner;

public class DobroTriplo {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int num = sc.nextInt();
		int dobro = 2*num;
		int triplo = 3*num;
		System.out.println("dobro: " + dobro + ", triplo: " + triplo);
	}
}
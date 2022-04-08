import java.util.Scanner;

public class Arrays {
	public static void main(String[] args) {
		String[] palavras = new String[10];  // Array de 10 strings

		int[][] matriz = new int[4][2];   // Array multidimensional (matriz) de 4 linhas e 2 colunas

		String[][] tabela = new String[10][];  // você pode definir o tamanho de cada String[] interno no futuro

		int[] exemplo = { 1, 2, 3, 4 };  // pode inicializar elementos já de cara

		System.out.println(exemplo[0]);  // elemento de valor 1
		exemplo[0] = 2;  // exemplo agora é {2, 2, 3, 4}
		System.out.println(exemplo.length);  // o tamanho do array
		
		// System.out.println(palavras);
		// System.out.println(matriz);
		// System.out.println(tabela);
		System.out.println(exemplo);
	}
}
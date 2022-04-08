import java.util.Scanner;

public class IdadePreferencialInteligente {
    public static void main(String[] args) {  // Definindo uma função
        Scanner sc = new Scanner(System.in);
        System.out.println("Idade?");
        int idade = sc.nextInt();

        if (idade >= 60) {
            System.out.println("Voce tem " + idade
                   + " anos. Preferencial Idoso.");
        }
        else {
            sc.nextLine();
            System.out.println("Você está grávida?");
            String gravida = sc.nextLine();
            System.out.println(gravida);
        }
    //     else if (cdcolo >= 1) {
    //     	System.out.println("Criança de colo: Preferencial pois está com "
    //     		+ cdcolo + " crianças de colo.");
    //     } else if (gravida == "sim") {
    //     	System.out.println("Grávida: Preferencial Gestante.");
    //     } else {
    //     System.out.println("Voce tem " + idade + " anos. Voce ainda nao pode usar o atendimento especial.");
    //     }
    }
}


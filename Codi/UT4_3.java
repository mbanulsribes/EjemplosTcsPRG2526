import java.util.Scanner;

public class UT4_3 {
    public static void main(String[] args) throws Exception {
        ej7();
    }

    public static void ej7() {
        Scanner sc = new Scanner(System.in);
        //inicialitzar vbles
        //totalPrestecs
        //llibres endarrerits
        // total de recarrecs
        // Permet introduir diversos préstecs fins que l'usuari escriga "fi"
        String codi = "";
        do {
            System.out.println("Introdueix el codi del llibre (o 'fi' per acabar):");
            codi = sc.nextLine();
            //TOTS els string te un métode per a comparar paraules --> equals
            // per ano diferenciar entre maj i min ----- equalsIgnoreCase---------
            if (!codi.equalsIgnoreCase("fi")) {
                System.out.println("Introdueix el títol del llibre:");
                String titol = sc.nextLine();
                System.out.println("Introdueix el dia de devolució prevista:");
                int dia = sc.nextInt();
                System.out.println("Introdueix el mes de devolució prevista:");
                int mes = sc.nextInt();
                System.out.println("Introdueix l'any de devolució prevista:");
                int any = sc.nextInt();
                System.out.println();
                System.out.println("--- Informació del préstec ---");
                System.out.println("Codi: " + codi);
                System.out.println("Títol: " + titol);
                System.out.println("Data devolució prevista: " + dia + "/" + mes + "/" + any);
            }
            sc.nextLine(); // buidar el scanner.
        } while (!codi.equalsIgnoreCase("fi"));
        //while !codi == "fi"
        //!true --> false
        //!false --> true
    }
}
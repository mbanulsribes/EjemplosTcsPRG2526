import java.util.Scanner;

public class UT4_3 {
    public static void main(String[] args) throws Exception {
        //resolució exercici7  --> https://ggpro-java.github.io/UF4-fRcm3wHyfk2FQFp86GHV/ca/6-exercicis.html
        ej7();
    }

    public static void ej7() {
        Scanner sc = new Scanner(System.in);
        //inicialitzar vbles
        //totalPrestecs
        int totalPrestecs = 0;
        //llibres endarrerits
        int llibresEndarrerits = 0;
        // total de recarrecs
        double totalRecarrecs = 0.0;

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

                boolean endarrerit = false;

                // Data actual
                int avuiDia = 27;
                int avuiMes = 10;
                int avuiAny = 2025;

                if (avuiAny > any || (avuiAny == any && avuiMes > mes)
                        || (avuiAny == any && avuiMes == mes && avuiDia > dia)) {
                    endarrerit = true;

                    int diesPrevistos = any * 365 + mes * 30 + dia;
                    int diesAvui = avuiAny * 365 + avuiMes * 30 + avuiDia;

                    int diesRetard = diesAvui - diesPrevistos;

                    double recarrec = diesRetard * 0.50;

                    llibresEndarrerits++;
                    totalRecarrecs += recarrec;

                    System.out.println("Està endarrerit! Dies de retard: " + diesRetard);
                    System.out.println("Recàrrec: " + recarrec + " €");

                } else {
                    System.out.println("No està endarrerit.");
                }

                totalPrestecs++;
                System.out.println("------------------------------\n");

            }
            sc.nextLine(); // buidar el scanner.
        } while (!codi.equalsIgnoreCase("fi"));
        //while !codi == "fi"
        //!true --> false
        //!false --> true
        System.out.println();
        System.out.println("=== Resum Final ===");
        System.out.println("Nombre de llibres prestats: " + totalPrestecs);
        System.out.println("Llibres endarrerits: " + llibresEndarrerits);
        System.out.println("Recàrrecs totals: " + totalRecarrecs + " €");

    }
}
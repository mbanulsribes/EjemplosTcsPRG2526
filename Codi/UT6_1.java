import java.util.Scanner;

public class UT6_1 {
    /**
     * Crear un programa en Java amb diverses funcions:
    
        ➤ sumar ,  
        ➤ restar,    
        ➤ multiplicar,    
        ➤ dividir,    
        ➤ mostrar el menú,    
        ➤ funció recursiva
     */
    /*
    Explicar:
    ✔ què és el main
    ✔ punt d’entrada del programa
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*comença el programa ací */
        int op;
        do {
            mostrarMenu();
            System.out.println("opció: ");
            op = sc.nextInt();
            switch (op) {
                case 1:

                    int valor1 = 4, valor2 = 6;
                    sumar1(valor1, valor2);
                    /*sumar1(4,6) */

                    break;
            
                default:
                    break;
            }

        } while (op != 0);

    }


    public static void sumar1(int a, int b) {
        System.out.println(a + b);
    }
    

    
    public static void mostrarMenu() {
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Factorial");
        System.out.println("0. Eixir");

    }
    
    public static String unafuncio1() {
        boolean entrada = false;
        if (entrada) {
            return "Entrada";
        } else {
            return null;
        }
    }

    /*
    Explicar:
    ✔ Declaració
    ✔ Paràmetres
    ✔ Tipus retorn
    ✔ return
    */

    /*Mostrar menú */

    /* Explicar:
    ✔ cridar funcions
    ✔ variables locals
    ✔ àmbit
    */

    /*Explicar:
    Recursivitat
    ✔ cas base
    ✔ crida recursiva
    */

}

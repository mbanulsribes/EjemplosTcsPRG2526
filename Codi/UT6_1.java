import java.util.HashMap;
import java.util.Scanner;
/**
 * Esta clase representa un ejemplo de documentación Javadoc.
 * @author María
 * @version 1.0
 */
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
            sc.nextLine();
            switch (op) {
                case 1: {
                    int valor1 = 4, valor2 = 6;
                    sumar1(valor1, valor2);
                    /*sumar1(4,6) */
                    break;
                }
                case 2: {
                    System.out.println("donam nom");
                    String paraula1 = sc.nextLine();
                    System.out.println("donam cognom");
                    String paraula2 = sc.nextLine();
                    System.out.println(Salutacio(paraula1, paraula2));
                    break;
                }
                case 3: {
                    
                    int v[] = { 1, 1, 2 };
                    int x[] = { 0, 1, 2 };
                    sumaV(x, v);
                }
                default:
                    break;
            }

        } while (op != 0);

    }

    public static void sumar1(int valor1, int valor2) {
        valor1 = 10;
        System.out.println(valor1 + valor2);
    }
        public static void sumaV(int v[], int x[]) {
           
            v[0] = x[1];
        
    }


    public static String Salutacio(String elNom, String elCognom) {
        /*demanar algo a l'usuari i tornar  */

        return ("Hola " + elNom + " " + elCognom);
    }


    public static String concatParaules(String a, String b) {
        //System.out.println(a + b);
        String aux = a + b;
        return aux;
    }
    

    
    public static void mostrarMenu() {
        System.out.println("1. Sumar");
        System.out.println("2. Saludar");
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


/*
“Escriu només la capçalera d’una funció que retorne un double, es diga area, 
        i tinga dos paràmetres: base i altura.”
*/

import java.util.Scanner;
import java.util.Random;

public class MansionEmbrujada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int pasos = 5;

        boolean encontradaSalida = false;

        System.out.println("🎃 Bienvenido a la Mansión Embrujada 🎃");
        System.out.println("Tienes " + pasos + " pasos para encontrar la salida... ¡Buena suerte!");

        while (pasos > 0 && !encontradaSalida) {

            System.out.println("\n¿Puerta izquierda (1) o derecha (2)?");

            int eleccion = 0;

            do {

                System.out.print("Elige 1 o 2: ");
                eleccion = sc.nextInt();
            } while (eleccion != 1 && eleccion != 2);

            int puertaCorrectaAlAzar = rand.nextInt(2) + 1;

            if (eleccion == puertaCorrectaAlAzar) {
                System.out.println("✅ ¡Has encontrado la salida! Escapas de la mansión...");
                encontradaSalida = true;
            } else {

                pasos--;
                System.out.println("👻 ¡Un fantasma te asusta! Te quedan " + pasos + " pasos.");

            }
        }
        if (!encontradaSalida) {
            System.out.println("💀 Se acabaron los pasos... ¡La mansión te atrapa para siempre!");
        }
        sc.close();
    }
}
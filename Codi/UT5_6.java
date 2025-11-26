import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class UT5_6 {
public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        // Estructura: pregunta → (puntuació → recompte)
        HashMap<Integer, HashMap<Integer, Integer>> resultats = new HashMap<>();

        /* resultats
        0 -<puntuacio 1a5, num de vots>
        1 - <4,1000>
        2 - <5,1>
        3 -<3,100>
        ....
        10 - <1,10000>
        
        */
        for(int i=0, i<10;i++){
              HashMap<Integer, Integer> puntuacions = new HashMap<>();
            resultats.put(i+1,puntuacions)
        }
          /* resultats
        0 -<,>
        1 - <,>
        2 - <,>
        3 -<,>
        ....
        10 - <,>
        
        */
        HashMap<Integer, Integer> puntuacions = new HashMap<>(); puntuacions.put(4,1000);
        resultats.put(1,puntuacions);

        HashMap<Integer, Integer> puntuacions2 = new HashMap<>(); puntuacions2.put(5,1);
        resultats.put(2,puntuacions2);




        // a) Inicialitzar amb valors aleatoris
        for (int pregunta = 1; pregunta <= 10; pregunta++) {
            HashMap<Integer, Integer> puntuacions = new HashMap<>();
            for (int puntuacio = 1; puntuacio <= 5; puntuacio++) {
                // Generem un recompte d'usuaris aleatori entre 0 i 5
                puntuacions.put(puntuacio, rand.nextInt(6));
            }
            resultats.put(pregunta, puntuacions);
        }

        // b) Demanar número de pregunta
        System.out.print("Introdueix el número de pregunta (1-10): ");
        int numPregunta = sc.nextInt();

        HashMap<Integer, Integer> puntuacionsPregunta = resultats.get(numPregunta);

        // Mostrar histograma
        System.out.println("\nPregunta " + numPregunta + ":");
        for (int puntuacio = 1; puntuacio <= 5; puntuacio++) {
            int recompte = puntuacionsPregunta.get(puntuacio);
            System.out.print(puntuacio + ": ");
            for (int i = 0; i < recompte; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // c) Calcular mitjana
        double suma = 0;
        double totalRespostes = 0;

        for (int puntuacio = 1; puntuacio <= 5; puntuacio++) {
            int nRespostes = puntuacionsPregunta.get(puntuacio);
            suma += puntuacio * nRespostes;
            totalRespostes += nRespostes;
        }

        double mitjana = (totalRespostes > 0) ? (suma / totalRespostes) : 0;
        System.out.println("Mitjana = " + String.format("%.2f", mitjana));
    }
}
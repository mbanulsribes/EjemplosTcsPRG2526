import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class UT5_5 {

    public static void main(String[] args) {

        // ------------------ HASHMAP ------------------
        System.out.println("--- HASHMAP: recompte de lletres ---");
        System.out.println();
        HashMap<String, Integer> contador = new HashMap<>();

        String frase = "tu m'ensenyes i jo t'ensenye";
        String[] paraules = frase.split(" ");

        for (String p : paraules) {
            contador.put(p, p.length());
        }

        for (Map.Entry<String, Integer> entrada : contador.entrySet()) {
            String paraula = entrada.getKey();
            Integer numLletres = entrada.getValue();

            System.out.println(paraula + " -> " + numLletres);
        }

        // ------------------ QUEUE ------------------
        System.out.println();
        System.out.println("--- QUEUE: cua de clients ---");
        System.out.println();
        Queue<String> clients = new LinkedList<>();
        clients.add("Anna");
        clients.add("Marc");
        clients.add("Joan");

        while (!clients.isEmpty()) {
            System.out.println("Servint client: " + clients.poll());
        }

        // ------------------ STACK ------------------
        System.out.println();
        System.out.println("--- STACK: invertir frase ---");
        System.out.println();
        Stack<String> pila = new Stack<>();

        for (String p : paraules) {
            pila.push(p);
        }
        System.out.println("Frase: " + frase);
        System.out.print("Frase invertida: ");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop() + " ");
        }
    }
}

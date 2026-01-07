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
        //paraules={"tu", "m'ensenyes","i","jo","t'ensenye"}

        for (String p : paraules) {
            contador.put(p, p.length());
            
        }
        /*contador
        ------------------
        tu- 2
        m'ensenyes - 10
        i-1
        jo-2
        t'ensenye - 9
         */
         /*contador -> entrades -> 5 entrades --> entrySet() --> Map.Entry<String, Integer>
         
         Map.Entry ---- getKey() torna la clau
                   ---- getValue() torna el valor
         
         */

        for (Map.Entry<String, Integer> entrada : contador.entrySet()) {
            String paraula = entrada.getKey();
            //tu-  m'ensenyes 
            Integer numLletres = entrada.getValue();
            //2 -10

            System.out.println(paraula + " -> " + numLletres);
            /* tu -> 2
               m'ensenyes -> 10
               ....
             */
        }

        // ------------------ QUEUE ------------------
        System.out.println();
        System.out.println("--- QUEUE: cua de clients ---");
        System.out.println();
        Queue<String> clients = new LinkedList<>();
        clients.add("Anna");
        clients.add("Marc");
        clients.add("Joan");
        /* clients:
        Anna - Marc - Joan
        0       1       2
         */

        while (!clients.isEmpty()) {
            System.out.println("Servint client: " + clients.poll());
        }


        // ------------------ STACK ------------------
        System.out.println();
        System.out.println("--- STACK: invertir frase ---");
        System.out.println();
        Stack<String> pila = new Stack<>();
          //paraules={"tu", "m'ensenyes","i","jo","t'ensenye"}

        for (String p : paraules) {
            pila.push(p);
        }
        /* pila
        |t'ensenye   |
        |jo          |
        |i           |
        |m'ensenyes  |
        |tu          |
        _____________ 
        
        */
        System.out.println("Frase: " + frase);
        System.out.print("Frase invertida: ");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop() + " ");
        }
                /* pila
        |   |
        |          |
        |          |
        |  |
        |tu          |
        _____________ 
        frase: tu m'ensenyes i jo t'ensenye
        */
       // frase invertida: t'ensenye jo i m'ensenyes tu
    }
}

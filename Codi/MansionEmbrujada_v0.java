
import java.util.Scanner;
import java.util.Random;

/*
------------------------------------------------------------
Ejercicio: Escapa de la Mansión Embrujada 🎃
------------------------------------------------------------
Descripción:
Crea un programa en Java que simule un juego de Halloween en la consola.
El jugador está atrapado en una mansión embrujada y debe encontrar la salida
antes de que se agoten sus pasos.

Requisitos:
- Mostrar un mensaje inicial indicando la situación.
- El jugador tiene 5 pasos para encontrar la salida.
- En cada paso, debe elegir entre dos puertas: izquierda (1) o derecha (2).
- Usar estructuras de control:
    * if / if-else: para comprobar si la elección es correcta.
    * while: para repetir el juego mientras queden pasos y no haya escapado.
    * do-while: para validar que la entrada sea 1 o 2.
- Si el jugador elige la puerta correcta, gana y escapa.
- Si se queda sin pasos, pierde y queda atrapado en la mansión.


------------------------------------------------------------
*/
public class MansionEmbrujada_v0 {
    public static void main(String[] args) {
        //crear la variables scannerpara leer por pantalla
        
        Random rand = new Random();

        // crear vble entera pasos

        //crear la vble booleana encontradaSalida
       
        //sacar por pantalla 🎃 Bienvenido a la Mansión Embrujada 🎃
        
        //sacar pr pantalla "Tienes X pasos para encontrar la salida... ¡Buena suerte!")
        
        //Mientras que pasos sea mayor que 0 y no se haya encontrado la salida

            //sacar por pantalla "¿Puerta izquierda (1) o derecha (2)?"
            //crear vable para elección de usuario

            //recoger elección de usuario con la vble scanner

            int puertaCorrectaAlAzar = rand.nextInt(2) + 1;

            //si la elección es igual a puertaCorrectaAlAzar
                //sacar por pantalla "✅ ¡Has encontrado la salida! Escapas de la mansión...") y cambiar encontradaSalida a true
            //sino resto pasos y saco por pantalla "👻 ¡Un fantasma te asusta! Te quedan " + pasos + " pasos."

        
            //si no has encontrado la salida sacar por pantalla "💀 Se acabaron los pasos... ¡La mansión te atrapa para siempre!"
            
        
        
    }
}
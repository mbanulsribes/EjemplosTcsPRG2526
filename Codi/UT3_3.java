
/**
 * TC UT3_3
 * Ejemplo App.java
 * Este programa muestra conceptos básicos de Java:
 * comentarios, variables, constantes, operadores, entrada/salida, condicionales.
 */

import java.util.Scanner; // Importación para entrada por teclado

public class UT3_3 {
    public static void main(String[] args) {
        // Comentario de una línea

        /* Comentario
           de varias líneas */

        /** Comentario de documentación
         * Método principal del programa
         */

        // Declaración y definición de variables
        int edad = 20; // Variable entera (número entero)
        double altura = 1.75; // Variable decimal
        String nombre = "Adelaida"; // Variable tipo String

        // Constante
        final double PI = 3.1416;

        
        /*  NOMENCLATURA DE VARIABLES
        
        Palabras clave prohibidas: no se pueden usar como nombres de variables
            ❌ class, int, public, static → están reservadas

        No puede comenzar con un número
            ❌ 1edad → Error
            ✅ edad1 → Correcto

        Puede contener letras, números, _ y $ (no lo usamos)
            ✅ nombre_usuario, precioTotal, $_valor 

        No puede contener espacios ni caracteres especiales
            ❌ nombre usuario, precio-total    

        */

        //  BUENAS PRÁCTICAS
         // 1. camelCase para variables
            int edadUsuario;
            double precioTotal;
            String nombreCompleto;

         // 2. MAYÚSCULAS para constantes  
            final int MAX_USUARIOS = 100;
        
         //3. Nombres descriptivos
            int numeroDeAlumnos;
            String mensajeDeBienvenida;
        

        /*EJERCICIO: Corrige los nombres incorrectos */
            //int 1edad;
            //double AlturaUsuario;
            //String nombre completo;
            //boolean es_mayor_de_edad; 
            //int class;
            //final double pi = 3.1416;
            //String $nombre; 
            //int cnt;

        // Operadores aritméticos
        int suma = edad + 5;
        int resta = edad - 2;
        int producto = edad * 2;
        double division = edad / 2.0;
        int modulo = edad % 3;

        // Operadores de incremento/decremento
        edad++; // edad = edad + 1
        edad--; // edad = edad - 1
  
        // Concatenación de Strings
        String saludo = "Hola " + nombre;

        // Operadores relacionales
        boolean esMayor = edad > 18;
        boolean esIgual = edad == 20;

        // Operadores lógicos
        boolean condicion = (edad > 18 && altura > 1.70) || nombre.equals("Adelaida");

        // Operadores de asignación
        edad += 5; // edad = edad + 5

        // Funciones matemáticas
        double potencia = Math.pow(2, 3); // 2^3
        double raiz = Math.sqrt(16); // raíz cuadrada
        double constanteE = Math.E; //numero irracional 2.718281828459045

        // Entrada por teclado
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        edadUsuario = entrada.nextInt();

        // Salida por pantalla
        System.out.println("Tu edad es: " + edadUsuario);

        // Condicionales
        if (edadUsuario >= 18) {
            System.out.println("Eres mayor de edad.");
        } else {
            System.out.println("Eres menor de edad.");
        }
        //forma compacta de condicional
        System.out.println(edadUsuario >= 18 ? "Eres mayor de edad." : "Eres menor de edad.");


        //condicional
        String mensaje="";
        if (edadUsuario >= 18) {
                mensaje="es mayor de edad.";
            } else {
                mensaje= "Eres menor de edad.";
            }
          //forma compacta
          mensaje = (edadUsuario >= 18) ? "Eres mayor de edad." : "Eres menor de edad.";  

        // Switch-case
        System.out.print("Introduce un número del 1 al 3: ");
        int opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Elegiste uno.");
                break;
            case 2:
                System.out.println("Elegiste dos.");
                break;
            case 3:
                System.out.println("Elegiste tres.");
                break;
            default:
                System.out.println("Opción no válida.");
        }

        entrada.close(); // Cerramos el Scanner
    }
}
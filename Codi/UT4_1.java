import java.util.Scanner;

public class UT4_1 {
    //TC UT4_1
    // Archivo: App.java
    // ------------------------------------------------------------
    // Ejemplos completos de bucles for, while y do-while en Java
    // con explicaciones, lectura de usuario y ejercicios propuestos.
    //    
    // ------------------------------------------------------------

    public static void main(String[] args) {
        // Scanner único para toda la app (lo pasaremos a los métodos que lo necesiten)
        Scanner sc = new Scanner(System.in);

        System.out.println("\n==============================");
        System.out.println("   EJEMPLOS DE BUCLES EN JAVA  ");
        System.out.println("==============================\n");

        ejemploForBasico();
        ejemploWhileBasico();
        ejemploDoWhileBasico();
        ejemploForAnidado();
        ejemploLecturaUsuarioConWhile(sc);
        ejemploMenuDoWhile(sc);

        // Cerrar el Scanner al final del programa
        sc.close();

        System.out.println("\nFin de la demostración. ¡Buen estudio!\n");
    }

    // ------------------------------------------------------------
    // EJEMPLO 1: FOR BÁSICO
    // Se usa cuando conocemos el número de iteraciones por adelantado.
    // Estructura: for (inicialización; condición; actualización) { bloque }
    // ------------------------------------------------------------
    static void ejemploForBasico() {
       
        System.out.println("=== FOR básico: contar del 1 al 5 ===");

        for (int i = 1; i <= 5; i++) { // i++ equivale a i = i + 1
            System.out.println("FOR -> i = " + i);
        }
        System.out.println();
    }

    // ------------------------------------------------------------
    // EJEMPLO 2: WHILE BÁSICO
    // Ejecuta el bloque MIENTRAS la condición sea verdadera.
    // OJO: si la condición nunca cambia a false, se crea un bucle infinito.
    // ------------------------------------------------------------
    static void ejemploWhileBasico() {
        System.out.println("=== WHILE básico: contar del 1 al 5 ===");
        int j = 1; // inicialización antes del while
        while (j <= 5) { // se evalúa ANTES de entrar al bloque
            System.out.println("WHILE -> j = " + j);
            j++; // actualización dentro del bloque
        }
        System.out.println();
    }

    // ------------------------------------------------------------
    // EJEMPLO 3: DO-WHILE BÁSICO
    // Ejecuta el bloque AL MENOS UNA VEZ, porque la condición se evalúa al final.
    // ------------------------------------------------------------
    static void ejemploDoWhileBasico() {
        System.out.println("=== DO-WHILE básico: contar del 1 al 5 ===");
        int k = 1;
        do { // se ejecuta primero
            System.out.println("DO-WHILE -> k = " + k);
            k++;
        } while (k <= 5); // luego se evalúa la condición
        System.out.println();
    }

    // ------------------------------------------------------------
    // EJEMPLO 4: FOR ANIDADO (nesting)
    // Demostración con un pequeño "triángulo" de asteriscos.
    // ------------------------------------------------------------
    static void ejemploForAnidado() {
        System.out.println("=== FOR anidado: triángulo de asteriscos ===");
        int filas = 5;
        for (int fila = 1; fila <= filas; fila++) { // bucle externo: controla filas
            for (int col = 1; col <= fila; col++) { // bucle interno: controla columnas
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

   

    // ------------------------------------------------------------
    // EJEMPLO 6: Lectura del usuario + WHILE
    // Pedimos un entero positivo y calculamos la suma 1..N con while.
    // Incluye validación sencilla.
    // ------------------------------------------------------------
    static void ejemploLecturaUsuarioConWhile(Scanner sc) {
        System.out.println("=== Lectura de usuario con WHILE ===");

        int n;
        System.out.print("Introduce un entero positivo (N): ");
        n = sc.nextInt();

        // Validación: mientras N sea <= 0, volvemos a pedirlo
        while (n <= 0) {
            System.out.print("N debe ser > 0. Inténtalo de nuevo: ");
            n = sc.nextInt();
        }

        int suma = 0;
        int contador = 1;
        while (contador <= n) {
            suma += contador;
            contador++;
        }
        System.out.println("Suma de 1.." + n + " = " + suma + "\n");
    }

    // ------------------------------------------------------------
    // EJEMPLO 7: Menú interactivo con DO-WHILE
    // Repite el menú hasta que el usuario elija salir (opción 0).
    // ------------------------------------------------------------
static void ejemploMenuDoWhile(Scanner sc) {
    System.out.println("=== Menú con DO-WHILE ===");
    int opcion;
    do {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1) Sumar dos números");
        System.out.println("2) Restar dos números");
        System.out.println("0) Salir");
        System.out.print("Elige una opción: ");
        opcion = sc.nextInt();

        if (opcion == 1) {
            System.out.print("a = ");
            int a = sc.nextInt();
            System.out.print("b = ");
            int b = sc.nextInt();
            System.out.println("Resultado: " + (a + b));
        } else if (opcion == 2) {
            System.out.print("a = ");
            int a = sc.nextInt();
            System.out.print("b = ");
            int b = sc.nextInt();
            System.out.println("Resultado: " + (a - b));
        } else if (opcion == 0) {
            System.out.println("Saliendo del menú...");
        } else {
            System.out.println("Opción no válida. Intenta de nuevo.");
        }
    } while (opcion != 0);
    System.out.println();
}

}
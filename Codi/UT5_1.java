/**
 * Classe demostrativa per entendre vectors i matrius
 * utilitzant els símils de:
 * - Vector: una fila de calaixos
 * - Matriu: seients d'un cinema
 */
public class UT5_1{

    public static void main(String[] args) {

        // ----------------------------
        // SÍMIL 1: VECTOR = FILA DE CALAIXOS
        // ----------------------------
        // Cada calaix té un número (índex) i un contingut (valor)
        int[] calaixos = { 10, 5, 8, 12 };

        System.out.println("SÍMIL VECTOR (fila de calaixos):");
        for (int i = 0; i < calaixos.length; i++) {
            System.out.println("Calaix " + i + " conté: " + calaixos[i]);
        }

        // ----------------------------
        // SÍMIL 2: MATRIU = SEIENTS D'UN CINEMA
        // ----------------------------
        // Cada seient té coordenades: fila i columna
        //int[][] cinema = { {----}, {----}, {----}, {----} }
        int[][] cinema = {
                { 0, 0, 0, 0 },
                { 3, 5, 7, 7 },
                { 1, 4, 9, 9 },
                { 0, 2, 2, 6 }
        };

        System.out.println("\nSÍMIL MATRIU (seients de cinema):");
        for (int fila = 0; fila < cinema.length; fila++) {
            for (int columna = 0; columna < cinema[fila].length; columna++) {
                System.out.println("Seient (" + fila + "," + columna + ") conté: " + cinema[fila][columna]);
            }
        }
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Gestió de reserves d'un hotel.
 */
public class Hotel {

    // --------- CONSTANTS I VARIABLES GLOBALS ---------

    // Tipus d'habitació
    public static final String TIPUS_ESTANDARD = "Estàndard";
    public static final String TIPUS_SUITE = "Suite";
    public static final String TIPUS_DELUXE = "Deluxe";

    // Serveis addicionals
    public static final String SERVEI_ESMORZAR = "Esmorzar";
    public static final String SERVEI_GIMNAS = "Gimnàs";
    public static final String SERVEI_SPA = "Spa";
    public static final String SERVEI_PISCINA = "Piscina";

    // Capacitat inicial
    public static final int CAPACITAT_ESTANDARD = 30;
    public static final int CAPACITAT_SUITE = 20;
    public static final int CAPACITAT_DELUXE = 10;

    // IVA
    public static final float IVA = 0.21f;

    // Scanner únic
    public static Scanner sc = new Scanner(System.in);

    // HashMaps de consulta
    public static HashMap<String, Float> preusHabitacions = new HashMap<String, Float>();
    public static HashMap<String, Integer> capacitatInicial = new HashMap<String, Integer>();
    public static HashMap<String, Float> preusServeis = new HashMap<String, Float>();

    // HashMaps dinàmics
    public static HashMap<String, Integer> disponibilitatHabitacions = new HashMap<String, Integer>();
    public static HashMap<Integer, ArrayList<String>> reserves = new HashMap<Integer, ArrayList<String>>();

    // Generador de nombres aleatoris per als codis de reserva
    public static Random random = new Random();

    // --------- MÈTODE MAIN ---------

    /**
     * Mètode principal. Mostra el menú en un bucle i gestiona l'opció triada
     * fins que l'usuari decideix eixir.
     */
    public static void main(String[] args) {
        inicialitzarPreus();

        int opcio = 0;
        do {
            mostrarMenu();
            opcio = llegirEnter("Seleccione una opció: ");
            gestionarOpcio(opcio);
        } while (opcio != 6);

        System.out.println("Eixint del sistema... Gràcies per utilitzar el gestor de reserves!");
    }

    // --------- MÈTODES DEMANATS ---------

    /**
     * Configura els preus de les habitacions, serveis addicionals i
     * les capacitats inicials en els HashMaps corresponents.
     */
    public static void inicialitzarPreus() {
        // Preus habitacions
        preusHabitacions.put(TIPUS_ESTANDARD, 50f);
        preusHabitacions.put(TIPUS_SUITE, 100f);
        preusHabitacions.put(TIPUS_DELUXE, 150f);

        // Capacitats inicials
        capacitatInicial.put(TIPUS_ESTANDARD, CAPACITAT_ESTANDARD);
        capacitatInicial.put(TIPUS_SUITE, CAPACITAT_SUITE);
        capacitatInicial.put(TIPUS_DELUXE, CAPACITAT_DELUXE);

        // Disponibilitat inicial (comença igual que la capacitat)
        disponibilitatHabitacions.put(TIPUS_ESTANDARD, CAPACITAT_ESTANDARD);
        disponibilitatHabitacions.put(TIPUS_SUITE, CAPACITAT_SUITE);
        disponibilitatHabitacions.put(TIPUS_DELUXE, CAPACITAT_DELUXE);

        // Preus serveis
        preusServeis.put(SERVEI_ESMORZAR, 10f);
        preusServeis.put(SERVEI_GIMNAS, 15f);
        preusServeis.put(SERVEI_SPA, 20f);
        preusServeis.put(SERVEI_PISCINA, 25f);
    }

    /**
     * Mostra el menú principal amb les opcions disponibles per a l'usuari.
     */
    public static void mostrarMenu() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Reservar una habitació");
        System.out.println("2. Alliberar una habitació");
        System.out.println("3. Consultar disponibilitat");
        System.out.println("4. Llistar reserves per tipus");
        System.out.println("5. Obtindre una reserva");
        System.out.println("6. Ixir");
    }

    /**
     * Processa l'opció seleccionada per l'usuari i crida el mètode corresponent.
     */
    public static void gestionarOpcio(int opcio) {
       switch (opcio) {
            case 1:
                reservarHabitacio();
                break;
            case 2:
                alliberarHabitacio();
                break;
            case 3:
                consultarDisponibilitat();
                break;
            case 4:
                obtindreReserva();
                break;
            case 5:
                obtindreReservaPerTipus();
                break;
            case 6:
                System.out.println("Sortint del sistema de reserves.");
                break;
            default:
                System.out.println("Opció no vàlida.");
        }
    }

    /**
     * Gestiona tot el procés de reserva: selecció del tipus d'habitació,
     * serveis addicionals, càlcul del preu total i generació del codi de reserva.
     */
    public static void reservarHabitacio() {
        System.out.println("\n===== RESERVAR HABITACIÓ =====");
       String tipusHabitacio = seleccionarTipusHabitacioDisponible();
        if (tipusHabitacio == null) return;

        // Seleccionar servei addicional
        ArrayList<String> serveisSeleccionats = seleccionarServeis();

        // Calcular el preu total
        float preuTotal = calcularPreuTotal(tipusHabitacio, serveisSeleccionats);

        // Generar un codi de reserva
        int codiReserva = generarCodiReserva();

        //Emplenar ArrayList de detalls de la reserva
        ArrayList<String> reservaDetalls = new ArrayList<>();
        reservaDetalls.add(0, tipusHabitacio);
        reservaDetalls.add(1, String.valueOf(preuTotal));
        reservaDetalls.addAll(serveisSeleccionats);
        
        // Guardar la reserva en el HashMap
        reserves.put(codiReserva, reservaDetalls);
        
        // Actualitzar la disponibilitat
        int disponibles = disponibilitatHabitacions.get(tipusHabitacio) - 1;
        disponibilitatHabitacions.put(tipusHabitacio, disponibles);

        System.out.println("Reserva creada correctament.");
        System.out.println("Codi de reserva: " + codiReserva);
        System.out.printf("Preu total de la reserva: %.2f€%n", preuTotal);
        
    }

    /**
     * Pregunta a l'usuari un tipus d'habitació en format numèric i
     * retorna el nom del tipus.
     */
    public static String seleccionarTipusHabitacio() {
       int opc;
        do {
            System.out.print("Introdueix un tipus d'habitació: 1(Estàndard), 2(Suite) o 3(Deluxe): ");
            opc = sc.nextInt();
            sc.nextLine();
            switch(opc) {
                case 1:
                    return "Estàndard";
                case 2:
                    return "Suite";
                case 3:
                    return "Deluxe";
                default:
                    System.out.println("No has triat una opció correcta.");
            }
        } while(opc < 1 || opc > 3);
        return null;
    }

    /**
     * Mostra la disponibilitat i el preu de cada tipus d'habitació,
     * demana a l'usuari un tipus i només el retorna si encara hi ha
     * habitacions disponibles. En cas contrari, retorna null.
     */
    public static String seleccionarTipusHabitacioDisponible() {
    String tipusHabitacio;
        
        System.out.println("\nTipus d'habitació disponibles:");
        for (String tipus : preusHabitacions.keySet()) {
            int disponibles = disponibilitatHabitacions.get(tipus);
            System.out.println("- " + tipus + " (" + disponibles + " disponibles) - " + preusHabitacions.get(tipus) + "€ per nit");
        }
        
        tipusHabitacio = seleccionarTipusHabitacio();

        int disponibles = disponibilitatHabitacions.get(tipusHabitacio);
        if (disponibles > 0) {
            return tipusHabitacio;
        } else {
            System.out.println("No queden habitacions disponibles de tipus " + tipusHabitacio + ".");
            return null;
        }
    }

    /**
     * Permet triar serveis addicionals (entre 0 i 4, sense repetir) i
     * els retorna en un ArrayList de String.
     */
    public static ArrayList<String> seleccionarServeis() {
 int opc;
        String servei;
        ArrayList<String> serveis = new ArrayList();

        System.out.println("\nSelecciona un servei addicional:");
        System.out.println("Opcions: 1(Esmorzar - 10€), 2(Gimnàs - 15€), 3(Spa - 20€), 4(Piscina - 25€) o 0(Finalitzar)");
        do {
            System.out.print("Introdueix el servei: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch(opc) {
                case 1:
                    servei = "Esmorzar";
                    if(!serveis.contains(servei)) serveis.add(servei);
                    else System.out.println("Ja has afegit " + servei);
                    break;
                case 2:
                    servei = "Gimnàs";
                    if(!serveis.contains(servei)) serveis.add(servei);
                    else System.out.println("Ja has afegit " + servei);
                    break;
                case 3:
                    servei = "Spa";
                    if(!serveis.contains(servei)) serveis.add(servei);
                    else System.out.println("Ja has afegit " + servei);
                    break;
                case 4:
                    servei = "Piscina";
                    if(!serveis.contains(servei)) serveis.add(servei);
                    else System.out.println("Ja has afegit " + servei);
                    break;
                case 0:
                    System.out.println("S'ha finalitzat la introducció de serveis adicionals");
                    break;
                default:
                    System.out.println("L'opció triada no és correcta.");
            }
        } while(opc != 0);

        return serveis;
    }

    /**
     * Calcula i retorna el cost total de la reserva, incloent l'habitació,
     * els serveis seleccionats i l'IVA.
     */
    public static float calcularPreuTotal(String tipusHabitacio, ArrayList<String> serveisSeleccionats) {
        float preuTotal = preusHabitacions.get(tipusHabitacio);
        
        for(String servei : serveisSeleccionats){
            preuTotal += preusServeis.get(servei);
        }

        preuTotal *= (1 + IVA / 100f);
        return preuTotal;
    }

    /**
     * Genera i retorna un codi de reserva únic de tres xifres
     * (entre 100 i 999) que no estiga repetit.
     */
    static int generarCodiReserva() {
        int codi;
        do {
            codi = (int) (Math.random()*900) + 100; // Genera un número de tres xifres (entre 100 i 999)
        } while (reserves.containsKey(codi));
        return codi;
    }


    /**
     * Permet alliberar una habitació utilitzant el codi de reserva
     * i actualitza la disponibilitat.
     */
    public static void alliberarHabitacio() {
        System.out.println("\n===== ALLIBERAR HABITACIÓ =====");
        String tipusHabitacio;
        
        System.out.print("Introdueix el codi de reserva per alliberar l'habitació: ");
        int codiReserva = sc.nextInt();
        sc.nextLine(); // Neteja el buffer
    
        if(reserves.containsKey(codiReserva)){
            tipusHabitacio = reserves.get(codiReserva).get(0);
            reserves.remove(codiReserva);
            disponibilitatHabitacions.put(tipusHabitacio, disponibilitatHabitacions.get(tipusHabitacio) + 1);
            System.out.println("Reserva alliberada correctament.");
        } else {
            System.out.println("Codi de reserva no trobat.");
        }
    }

    /**
     * Mostra la disponibilitat actual de les habitacions (lliures i ocupades).
     */
    public static void consultarDisponibilitat() {
        System.out.println("\nDisponibilitat d'habitacions:");
        for (String tipus : disponibilitatHabitacions.keySet() ){
            int disponibles = disponibilitatHabitacions.get(tipus);
            int ocupades = capacitatInicial.get(tipus) - disponibles;
            System.out.println("- " + tipus + ": " + disponibles + " lliures, " + ocupades + " ocupades");
        }
    }

    /**
     * Funció recursiva. Mostra les dades de totes les reserves
     * associades a un tipus d'habitació.
     */
    public static void llistarReservesPerTipus(int[] codis, String tipus) {
        int codi = codis[0];
        if(reserves.get(codi).get(0).equals(tipus)){
            mostrarDadesReserva(codi);
        }
        if(codis.length > 1){
            int[] newCodis = new int[codis.length - 1];
           
            System.arraycopy(codis, 1, newCodis, 0, newCodis.length);
            llistarReservesPerTipus(newCodis, tipus);
        }
    }

    /**
     * Permet consultar els detalls d'una reserva introduint el codi.
     */
    public static void obtindreReserva() {
        System.out.println("\n===== CONSULTAR RESERVA =====");
        System.out.print("Introdueix el codi de reserva: ");
        int codiReserva = sc.nextInt();
        sc.nextLine(); // Neteja el buffer
        mostrarDadesReserva(codiReserva);
 
    }

    /**
     * Mostra totes les reserves existents per a un tipus d'habitació
     * específic.
     */
    public static void obtindreReservaPerTipus() {
        System.out.println("\n===== CONSULTAR RESERVES PER TIPUS =====");
        String tipus = seleccionarTipusHabitacio();
        
        int [] codis = new int[reserves.size()];
        int i = 0;
        for (Integer codi : reserves.keySet()) {
            codis[i] = codi;
            i++;
        }
        llistarReservesPerTipus(codis, tipus);
    }

    /**
     * Consulta i mostra en detall la informació d'una reserva.
     */
    public static void mostrarDadesReserva(int codi) {
              ArrayList<String> detallsReserva = reserves.get(codi);
        if (detallsReserva != null) {
            System.out.println("Dades de la reserva:");
            System.out.println("- Codi de reserva: " + codi);
            System.out.println("- Tipus d'habitació: " + detallsReserva.get(0));
            System.out.println("- Preu total: " +  detallsReserva.get(1) + "€");
            System.out.println("- Serveis adicionals: ");
            for(int i= 2; i < detallsReserva.size(); i++){
                System.out.println("   -> " +  detallsReserva.get(i));
            }            
        } else {
            System.out.println("Codi de reserva no trobat.");
        }
    }

    // --------- MÈTODES AUXILIARS (PER MILLORAR LEGIBILITAT) ---------

    /**
     * Llig un enter per teclat mostrant un missatge i gestiona possibles
     * errors d'entrada.
     */
    static int llegirEnter(String missatge) {
        int valor = 0;
        boolean correcte = false;
        while (!correcte) {
                System.out.print(missatge);
                valor = sc.nextInt();
                correcte = true;
        }
        return valor;
    }

    /**
     * Mostra per pantalla informació d'un tipus d'habitació: preu i
     * habitacions disponibles.
     */
    static void mostrarInfoTipus(String tipus) {
        int disponibles = disponibilitatHabitacions.get(tipus);
        int capacitat = capacitatInicial.get(tipus);
        float preu = preusHabitacions.get(tipus);
        System.out.println("- " + tipus + " (" + disponibles + " disponibles de " + capacitat + ") - " + preu + "€");
    }

    /**
     * Mostra la disponibilitat (lliures i ocupades) d'un tipus d'habitació.
     */
    static void mostrarDisponibilitatTipus(String tipus) {
        int lliures = disponibilitatHabitacions.get(tipus);
        int capacitat = capacitatInicial.get(tipus);
        int ocupades = capacitat - lliures;

        String etiqueta = tipus;
        if (etiqueta.length() < 8) {
            etiqueta = etiqueta + "\t"; // per a quadrar la taula
        }

        System.out.println(etiqueta + "\t" + lliures + "\t" + ocupades);
    }
}

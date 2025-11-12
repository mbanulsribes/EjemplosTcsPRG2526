import java.util.ArrayList;
import java.util.Collections;

public class UT5_3 {
    public static void main(String[] args) {



        // int, double, char, boolean
        // Integer, Double, Character,  Boolean
       
        int[] arrayNombres = new int[2];

        ArrayList<Integer> nombres = new ArrayList<>();
        nombres.add(1);
        nombres.add(2);

        int unNum = nombres.get(0); 
        Integer dosNum = nombres.get(0);
        /*operacions
        add
        get()
        set - modificar un element
         * remove
         * size()
         * conprovacions -- contains
         * indexOf
         * Collections.sort()
         */
        nombres.set(0, 5);
        nombres.size();

        if(nombres.contains("5")){

        }
        nombres.indexOf(2);

        Collections.sort(nombres);

        for (int num : nombres) {

        }
        
        for(int i=0; i<nombres.size();i++)
        {
            nombres.get(i);
        }
        //----------------------------
        ArrayList<String> noms = new ArrayList<>();
        noms.add("Paco");
        noms.add("Pepe");
        noms.add("Raul");

        //borrar
        noms.remove(1);

        //----------------------------------------
        String[] arrayNoms = { "Paco", "Pepe", "Raul" };

        String[] nouArrayNoms = new String[2];
        int posicioNouArray=0;

        for (int i = 0; i < arrayNoms.length; i++) {
            if (i != 1) {
                nouArrayNoms[posicioNouArray] = arrayNoms[i];
                posicioNouArray++;
            }
        }
        











            

    }
}
import java.util.Arrays;

public class UT5_2 {

    public static void main(String[] args) {
        // Tu código aquí

        int alt = 7;
        int ample = 5;

        char[][] matriu = new char[alt][ample];

        //omplir el array amb valor buits
        for (int i = 0; i < matriu.length; i++) {
            Arrays.fill(matriu[i], ' ');
        }

        /*
         char[][] matriu {{-----},{-----},{-----},{-----},{-----},{-----},{-----}}
         
         char[][] matriu {
                          {-,-,-,-,-},
                          {-,-,-,-,-},
                          {-,-,-,-,-},
                          {-,-,-,-,-},
                          {-,-,-,-,-},
                          {-,-,-,-,-},
                          {-,-,-,-,-}
        
                          };
                          
                            char[][] matriu {
                        0 {*,-,-,-,*},
                        1 {*,-,-,-,*},
                        2 {*,-,-,-,*},
                        3 {*,*,*,*,*},
                        4 {*,-,-,-,*},
                        5 {*,-,-,-,*},
                        6 {*,-,-,-,*}
                          
                          };
         
         */

        for (int i = 0; i < alt; i++) {
            //pimera fila de cada columna
            matriu[i][0] = '*';

            //ultima fila de cada columna
            matriu[i][ample - 1] = '*';
        }

        //volem modificar la  quarta fila  (index 3)
        for (int i = 0; i < ample; i++) {
            matriu[3][i] = '*';
        }

        // Mostrar la matriu
        for (int i = 0; i < alt; i++) {
            for (int j = 0; j < ample; j++) {
                System.out.print(matriu[i][j]);
            }
            System.out.println();
        }

    }
    

 /*
         Letra A
           *  
          * * 
         *   *
         *****
         *   *
         *   *
         *   *

         Letra E
         *****
         *    
         *    
         *****
         *    
         *    
         *****

         Letra H
         *   *
         *   *
         *   *
         *****
         *   *
         *   *
         *   *

         Letra I
         *****
           *  
           *  
           *  
           *  
           *  
         *****

         Letra O
          *** 
         *   *
         *   *
         *   *
         *   *
         *   *
          *** 

         Letra U
         *   *
         *   *
         *   *
         *   *
         *   *
         *   *
          *** 
        */

}

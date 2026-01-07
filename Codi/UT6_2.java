public class UT6_2 {
    public static void main(String[] args) {
        String[] arr = { "x", "a", "b", "x" };
         System.out.println(contarParaula(arr, 0, "x"));



    }

    /*la primera volta el index = 0 */
    public static int contarParaula(String[] arr, int index, String paraula) {

        //cas base  

        if (index == arr.length) {
            return 0;
        }

        //cas general
        /*augmentar el index */
        if (arr[index].equals(paraula)) {
            return 1 + contarParaula(arr, index + 1, paraula);
        } else
            return contarParaula(arr, index + 1, paraula);

    }

}

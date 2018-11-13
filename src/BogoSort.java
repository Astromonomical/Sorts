public class BogoSort {

    private static boolean isSorted(int[] array) {
        for (int i = 0 ; i < array.length ; i++) {
            if (i == array.length) {
                return true;
            } else if (array[i] > array[i+1]) {
                return false;
            }
        }
        
        return true;
    }
}

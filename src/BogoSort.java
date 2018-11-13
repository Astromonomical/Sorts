import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BogoSort {

    private static boolean isSorted(int[] array) {
        for (int i = 0 ; i < array.length ; i++) {
            try {
                if (i == array.length) {
                    return true;
                } else if (array[i] > array[i + 1]) {
                    return false;
                }
            } catch(ArrayIndexOutOfBoundsException e) {
                return true;
            }
        }

        return true;
    }

    private static int[] shuffle(int[] array) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);

            // Swap elements
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
        return array;
    }

    public static void bogoSort(int[] array) {
        int i = 0;

        while(!isSorted(array)) {
            array = shuffle(array);

            if (!isSorted(array)) {
                i++;
            }
        }
        System.out.println("It took: " + i+1 + " attempts to sort this! Almost constant time!");

        for (int x = 0 ; x < array.length ; x++) {
            System.out.print("[" + array[x] + "], ");
        }

    }
}
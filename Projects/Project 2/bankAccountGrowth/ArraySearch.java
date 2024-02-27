
public class ArraySearch {
    public static void main(String[] args) {
        int[] array = { 101, 103, 100, 99, 101, 108 };
        int[] finalArray = searchArray(array, 101);
        System.out.println(finalArray);
    }

    public static int[] searchArray(int[] array, int target) {

        int[] newArray = new int[array.length];

        int j = 0;

        for (int i : array) {
            if (array[i] == target) {
                newArray[j] = i;
                j++;
            }
        }

        int[] finalArray = new int[j];
        for (int k : finalArray) {
            finalArray[k] = newArray[k];
        }

        if (j == 0) {
            return null;
        } else {

            return finalArray;
        }
    }
}
public class dog {
    public static void main(String[] args) {

    }

    public static int findDogAge(Dog dogArray, int targetAge) {
        int numDogs = 0;
        for (int i = 0; i < dogArray.length; i++) {
            if (dogArray.age > targetAge) {
                numDogs++;
            }
        }
        return numDogs;
    }
}

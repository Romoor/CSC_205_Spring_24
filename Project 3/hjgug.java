public class hjgug {
    public static void main(String[] args) {

    }

    public static int findDogAge(Dog dogArray, int targetAge, int numDogs) {

        for (int i = 0; i < numDogs; i++) {
            if (dogArray[i].age > targetAge) {
                numDogs++;
            }
        }
        return numDogs;
    }
}
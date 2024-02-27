public class Fibonacci {
    public static void main(String[] args) {
        int numOfValues = 13;
        int n1 = 1;
        int n2 = 1;
        for (int i = 0; i < numOfValues; i++) {
            System.out.println(n1);
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
    }
}

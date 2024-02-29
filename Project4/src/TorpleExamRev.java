import java.util.Scanner;

public class TorpleExamRev {
    public static void main(String[] args) {
        Torple newTorple = new Torple('A', 3, .1);
        Scanner scanner = new Scanner(System.in);
        double weight = -1;
        do {
            System.out.print("Enter the torple's initial weight (positive): ");
            weight = scanner.nextDouble();
        } while (weight < 0);
        System.out.println("Gen:     Weight (g):   ");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "      " + newTorple.weight);
            newTorple = newTorple.genTorple(newTorple);
        }
    }
}

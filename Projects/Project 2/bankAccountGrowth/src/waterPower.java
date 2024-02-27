import java.util.Scanner;

public class waterPower {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Water Power Calculation \n");

        System.out.print("Diameter: ");
        Double pDiameter = scanner.nextDouble();

        System.out.print("Velocity: ");
        Double velocity = scanner.nextDouble();

        System.out.print("Head: ");
        Double head = scanner.nextDouble();

        pipeMeasurments measuments = returnValues(pDiameter, velocity, head);

        System.out.println("Throughput: " + measuments.throughput + "\nHorsepower: " + measuments.horsepower);
        scanner.close();

    }

    public static pipeMeasurments returnValues(double pDiameter, double velocity, double head) {
        pipeMeasurments measurments = new pipeMeasurments();
        measurments.throughput = 2.448 * Math.pow(pDiameter, 2) * velocity;
        measurments.horsepower = measurments.throughput * head;
        return measurments;
    }

}

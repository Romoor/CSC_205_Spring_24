
/**
 * This program calculates the money in a bank account after a select number of years
 * @author Olivia Romo
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class program2 {
    static Scanner scanner = new Scanner(System.in);
    static DecimalFormat dFormat = new DecimalFormat(".##");

    public static void main(String[] args) {
        boolean continueLoop = false;
        System.out.println("\n\t\tBank Account Growth Calculator");
        System.out.println("This calculator will calculate the growth of your "
                + "bank account after a number of years\n");
        do {

            System.out.print("Please enter the bank threshold (dollars): ");
            double threshold = scanner.nextDouble();
            threshold = inputError("Please enter the bank threshold (dollars): ");

            System.out.print("Please enter the bank bonus: ");
            double bonus = scanner.nextDouble();
            bonus = inputError("Please enter the bank bonus: ");

            System.out.print("Now please enter the initial account balance: ");
            double balance = scanner.nextDouble();
            balance = inputError("Please enter the initial account balance: ");

            System.out.print("Please enter the anuual interest rate as a decimal: ");
            double annIntRate = scanner.nextDouble();
            while (annIntRate < 0) {
                System.out.print("Please enter the bank threshold (decimal form) (cannot be negative): ");
                annIntRate = scanner.nextDouble();
            }
            System.out.print("Now please enter the length of investment (in years): ");
            // make int
            int investLength = scanner.nextInt();
            while (investLength <= 0) {
                System.out.print("Please enter the bank threshold (decimal form) (cannot be negative): ");
                investLength = scanner.nextInt();
            }

            System.out.print("Do you want a table of your values? (Y/N) ");
            char tablePrint = scanner.next().charAt(0);
            // System.out.println("tb " + tablePrint);
            boolean wantsTable = false;
            while (tablePrint != 'Y' || tablePrint != 'y' || tablePrint != 'n' || tablePrint != 'N') {
                System.out.print("Please enter Y or N: ");
                tablePrint = scanner.next().charAt(0);
            }
            if (tablePrint == 'Y' || tablePrint == 'y') {
                wantsTable = true;
            }

            System.out.println("\nYear\t\t\tBalance\n");

            balance = computeBalance(balance, annIntRate, bonus, threshold, investLength, wantsTable);
            System.out.println("\nFinal balance:\t\t" + dFormat.format(balance));

            System.out.print("Do you want to calculate everything again? (Y/N) ");
            char userChoice = scanner.next().charAt(0);
            // System.out.println("tb " + tablePrint);
            while (userChoice != 'Y' || userChoice != 'y' || userChoice != 'n' || userChoice != 'N') {
                System.out.print("Please enter Y or N: ");
                tablePrint = scanner.next().charAt(0);
            }
            if (tablePrint == 'Y' || tablePrint == 'y') {
                continueLoop = true;
            }
        } while (continueLoop == true);

        System.out.println("Goodbye!");

    }

    public static double computeBalance(double balance, double annIntRate, double bonus, double threshold,
            double investLength, boolean wantsTable) {
        // System.out.println("og balance " + balance);
        for (int i = 0; i < investLength; i++) {
            // System.out.println("for loop called");

            double balIntRate = annIntRate * balance;
            // System.out.println("ballint " + balIntRate);
            balance += balIntRate;
            // System.out.println("balance after ballint " + balance);
            if (balance > threshold) {
                if (balance % threshold >= 100) {
                    balance += 100 * bonus;
                } else if (balance % threshold >= 10) {

                    balance += 10 * bonus;
                } else {
                    balance += bonus;
                }
            }
            if (wantsTable)
                System.out.println((i + 1) + "\t\t\t" + dFormat.format(balance));
        }
        return balance;
    }

    public static double inputError(String value) {
        System.out.print(value);
        double number = scanner.nextDouble();
        while (number <= 0) {
            System.out.print(value);
            number = scanner.nextDouble();
            if (number == 0) {
                System.out.println("Cannot be zero");
            } else if (number < 0) {
                System.out.println("Cannot be negative");
            }
            // System.out.println(value);
        }
        return number;
    }
}

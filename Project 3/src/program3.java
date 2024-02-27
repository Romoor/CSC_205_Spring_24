
/**
 * Description: Offers user four options for a data file
 * @author: Olivia Romo
 */
import java.util.Scanner;

public class program3 {
    public static void main(String[] args) {

        designerInfo dInfo = new designerInfo();

        designerInfo[] data = dInfo.loadDataArray();
        boolean contWLoop = false;

        String wantCont = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Designer Brands File Options");

        // do {
        do {
            System.out.println("Please choose what you would like to do with the data (enter number):");
            System.out.println("1. Display all data");
            System.out.println("2. Display selected record");
            System.out.println("3. Take a quiz on the brands' country of origin!");
            System.out.println("4. Make a histogram of years founded");

            System.out.print("What would you like to choose? ");
            int choice = scanner.nextInt();
            int count = dInfo.count(data);

            switch (choice) {
                case 1:
                    dInfo.displayData(data, count);
                    break;
                case 2:
                    System.out.print("What brand do you want to search for? ");
                    String bName = scanner.next();
                    System.out.println(dInfo.displayRecord(data, bName));
                    break;
                case 3:
                    dInfo.brandQuiz(data);
                    break;
                case 4:
                    // System.out.println(count);

                    // designerInfo[] dInfos = dInfo.bubbleSortDInfo(data, count);
                    int min = dInfo.computeMinYear(data, count);
                    int max = dInfo.computeMaxYear(data, count);
                    System.out.println("max: " + max + "    min: " + min);
                    dInfo.histogram(min, max, data, count);

                    break;

                default:
                    System.out.println("Please enter a valid choice (1-4)");
            }
            System.out.print("Please enter Y to go again: ");
            wantCont = scanner.next();
            // System.out.println(wantCont);
            if (wantCont.equals("Y") || wantCont.equals("y")) {
                // System.out.println("true");
                contWLoop = true;
            }
        } while (contWLoop = true);
        scanner.close();
        /*
         * System.out.println("would you like to go again (y/n): ");
         * askAgain = scanner.next().charAt(0);
         * // System.out.println("tb " + tablePrint);
         * while (askAgain != 'Y' || askAgain != 'y' || askAgain != 'n' || askAgain !=
         * 'N') {
         * System.out.print("Please enter Y or N: ");
         * askAgain = scanner.next().charAt(0);
         * }
         * 
         * scanner.close();
         * } while (askAgain == 'Y');
         */
    }
}

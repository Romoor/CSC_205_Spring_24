import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class designerInfo {
    private String bName;
    private String creatDir;
    private String country;
    private int year;
    private double annRev;

    public designerInfo() {

    }

    public designerInfo(String _bName, String _creatDir, String _country, int _year, double _annRev) {
        bName = _bName;
        creatDir = _creatDir;
        country = _country;
        year = _year;
        annRev = _annRev;
    }

    // load data file
    // dont use static
    public designerInfo[] loadDataArray() {
        designerInfo[] dInfo = new designerInfo[100];

        try {

            File designerData = new File(
                    "/Users/roseromo/Desktop/Code/CSC 205 Spring 24/Project 3/src/DesignerData.txt");

            Scanner scanner = new Scanner(new FileReader(designerData));
            int i = 0;
            do {

                dInfo[i] = new designerInfo();

                dInfo[i].bName = scanner.next();
                dInfo[i].creatDir = scanner.next();
                dInfo[i].country = scanner.next();
                dInfo[i].year = Integer.parseInt(scanner.next());
                dInfo[i].annRev = Double.parseDouble(scanner.next());

                i++;
            } while (!dInfo[i - 1].bName.equals("EOF"));
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }

        return dInfo;

    }

    public int count(designerInfo[] dInfos) {
        int i = 0;

        do {

            i++;

        } while (!dInfos[i].bName.equals("EOF"));
        return i;
    }

    public void displayData(designerInfo[] dInfo, int count) {
        System.out.println("\nDesigner Brands Data");
        System.out
                .println(
                        "\nBrand Name           Creative Director      Country       Year Founded    Annual Revenue (Bil.)");
        int i = 0;

        do {

            System.out.printf("%-17s    %-17s      %-7s           %4d           %6.3f", dInfo[i].bName,
                    dInfo[i].creatDir,
                    dInfo[i].country, dInfo[i].year, dInfo[i].annRev);
            System.out.println();
            i++;

        } while (i != 15);
        Scanner scanner = new Scanner(System.in);
        // System.out.println("Press 'Y' to continue: ");
        String continueDis = "";
        // System.out.println(continueDis);
        boolean continuePrint = false;

        // make ignore case
        while (continuePrint != true) {
            System.out.print("Please enter Y to continue: ");
            continueDis = scanner.next();
            if (continueDis.equals("Y") || continueDis.equals("y")) {
                System.out.println("true");
                continuePrint = true;
            }
        }

        do {

            System.out.printf("%-17s    %-17s      %-7s           %4d           %6.3f", dInfo[i].bName,
                    dInfo[i].creatDir,
                    dInfo[i].country, dInfo[i].year, dInfo[i].annRev);
            System.out.println();
            i++;

        } while (i != count);

        // scanner.close();
    }

    // option 2

    public String displayRecord(designerInfo[] dInfo, String bName) {
        int i = 0;
        do {

            if (dInfo[i].bName.equalsIgnoreCase(bName)) {

                System.out
                        .println(
                                "\nBrand Name           Creative Director      Country       Year Founded    Annual Revenue (Bil.)");
                return String.format("%-17s    %-17s      %-7s           %4d           %6.3f", dInfo[i].bName,
                        dInfo[i].creatDir,
                        dInfo[i].country, dInfo[i].year, dInfo[i].annRev);
            }
            i++;
        } while (!dInfo[i].bName.equals("EOF"));

        return "Brand was not found";

    }

    // option 3

    public void brandQuiz(designerInfo[] dInfos) {
        System.out.println("\nQuiz Time!");
        Scanner scanner = new Scanner(System.in);
        int points = 0;
        int i = 0;
        try {

            String answer = "";

            do {

                if (!dInfos[i].bName.equals("EOF")) {
                    System.out.print("What is the country of origin for " + dInfos[i].bName + "? ");
                    String guess = scanner.next();
                    if (guess.equalsIgnoreCase(dInfos[i].country)) {
                        System.out.println("That's correct! +1 points");
                        points++;
                    } else {
                        System.out.println("Incorrect. The answer is " + dInfos[i].country);
                    }
                    i++;
                    System.out.print("Do you want to go again? (Y/N): ");
                    answer = scanner.next();
                } else {
                    break;
                }
            } while (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes"));

            double score = 100 * (double) points / i;
            System.out.println("You got " + points + " correct over " + i + " tries. That's " + score + "%!");
        } catch (InputMismatchException e) {
            System.out.println("That was not a valid input");
        }
    }

    // compute max
    // REDO
    public int computeMaxYear(designerInfo[] dInfos, int count) {
        int max = dInfos[0].year;
        for (int i = 0; i < count; i++) {
            if (max < dInfos[i].year) {
                max = dInfos[i].year;
            }
        }
        return max;
    }

    // compute min
    // REDO
    public int computeMinYear(designerInfo[] dInfos, int count) {
        int min = dInfos[0].year;
        for (int i = 0; i < count; i++) {
            if (min > dInfos[i].year) {
                min = dInfos[i].year;
            }
        }
        return min;
    }

    // option 4
    public void histogram(int min, int max, designerInfo[] dInfos, int dInfoLength) {
        int range = max - min;

        // rounds UP to int
        int decWidth = (int) Math.ceil(range / 10.0);
        System.out.println(decWidth);

        System.out.println("Decade:    Count: ");
        int[] decadeArray = new int[10];
        // int numInDec = min;
        for (int i = 0; i < 10; i++) {
            decadeArray[i] = decWidth * i + min;
        }

        int[] count = new int[10];
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        int index = 0;
        for (int i = 0; i < dInfoLength; i++) {
            index = (int) ((dInfos[i].year - min) / decWidth);
            count[index]++;

        }

        // while (numInDec <= max) {

        String asterisk = "*";
        // for each decade
        for (int i = 0; i < decadeArray.length; i++) {
            // print "count" number of *
            System.out.println(decadeArray[i] + "   " + count[i] + " " + asterisk.repeat(count[i]));
        }

        // }

    }

    // create & fill array

}
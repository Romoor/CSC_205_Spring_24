
/**
 * @author: Olivia Romo
 * Description: calculates total volume of N number of spheres
 */

//Use if/else statements!
//Use for loop: when you know how many timees it will repeat
//use do while if idk num times but want at least once
//use while idk times idc it iterates

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println("\n\t\tTotal Sphere Volume Calculator\n");

        System.out.print("Please enter the number of spheres: ");
        Scanner scan = new Scanner(System.in);
        int numSpheres = scan.nextInt();

        int iterations = 1;
        double total = 0;
        do {
            System.out.println("What is the radius of sphere " + iterations + "? ");
            double radius = scan.nextDouble();
            while (radius <= 0) {
                System.out.println("What is the radius of this sphere? Enter a positive number");
                radius = scan.nextDouble();
            }
            double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
            total += volume;
            iterations++;
        } while (iterations < numSpheres);

        System.out.println("Your total volume is " + total + " cubic inches");
        scan.close();
    }
}

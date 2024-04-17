package Homework;

public class ComissionedEmployee extends Employee {
    double totalSales;

    public ComissionedEmployee() {
        totalSales = 0;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public double computePay() {
        double comissRate = 0;
        if (totalSales < 1000) {
            comissRate = 0.01;
        } else if (totalSales < 10000) {
            comissRate = 0.025;
        } else {
            comissRate = 0.05;
        }
        return bonus + totalSales * comissRate;
    }

    public String toString() {
        return super.toString() + "\nTotal Sales (dollars): " + totalSales;
    }
}

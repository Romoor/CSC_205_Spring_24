package Homework;

public class HourlyEmployee extends Employee {
    private double hourRate;
    private int totalHour;

    public HourlyEmployee() {
        hourRate = 0;
        totalHour = 0;
    }

    public Double getHourRate() {
        return hourRate;
    }

    public int getTotalHour() {
        return totalHour;
    }

    public double computePay() {
        return bonus + totalHour * hourRate;
    }

    public String toString() {
        return super.toString() + "\nTotal Weekly Hours: " + totalHour + "\nHourly Rate (dollars per hour): "
                + hourRate;
    }

}

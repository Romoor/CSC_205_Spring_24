package Homework;

public class Employee {
    protected String name;
    protected int years;
    protected double bonus;

    public Employee() {
        name = "null";
        years = 0;
        bonus = 0;
    }

    public String getName() {
        return name;
    }

    public int getYears() {
        return years;
    }

    public Double getBonus() {
        return bonus;
    }

    public double computePay() {
        return bonus * ((100 - years) / 100);
    }

    public String toString() {
        return "Name: " + name + "\nYears: " + years + "\nBonus: " + bonus;
    }

}

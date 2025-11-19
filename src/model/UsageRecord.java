package model;

import java.time.LocalDate;

public class UsageRecord {
    private LocalDate date;
    public java.time.LocalDate getDate() { return date; }
    private double electricityKWh;
    private double lpgKg;
    private double vehicleLiters;

    // Constructor
    public UsageRecord(LocalDate date, double electricityKWh, double lpgKg, double vehicleLiters) {
        this.date = date;
        this.electricityKWh = electricityKWh;
        this.lpgKg = lpgKg;
        this.vehicleLiters = vehicleLiters;
    }

    // Getters
    public double getElectricityKWh() { return electricityKWh; }
    public double getLpgKg() { return lpgKg; }
    public double getVehicleLiters() { return vehicleLiters; }

    @Override
    public String toString() {
        return date + " | " + electricityKWh + " kWh | " + lpgKg + " kg LPG | " + vehicleLiters + " liters vehicle";
    }
}

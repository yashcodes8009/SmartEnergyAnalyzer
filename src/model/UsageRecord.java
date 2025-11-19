package model;

import java.time.LocalDate;

public class UsageRecord {
    private LocalDate date;
    private double electricityKWh;
    private double lpgKg;
    private double vehicleLiters;

    public UsageRecord(LocalDate date, double electricityKWh, double lpgKg, double vehicleLiters) {
        this.date = date;
        this.electricityKWh = electricityKWh;
        this.lpgKg = lpgKg;
        this.vehicleLiters = vehicleLiters;
    }

    // Getters and setters
}

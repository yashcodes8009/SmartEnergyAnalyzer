package model;

public class CarbonAnalyzer {

    // Emission factors (examples, can adjust as needed)
    public static final double ELECTRICITY_EMISSION_FACTOR = 0.82; // kg CO2 per kWh (India average)
    public static final double LPG_EMISSION_FACTOR = 2.983;        // kg CO2 per kg LPG
    public static final double PETROL_EMISSION_FACTOR = 2.31;      // kg CO2 per litre petrol

    public static double calculateCarbonFootprint(double electricityKWh, double lpgKg, double vehicleLiters) {
        double electricityCO2 = electricityKWh * ELECTRICITY_EMISSION_FACTOR;
        double lpgCO2 = lpgKg * LPG_EMISSION_FACTOR;
        double vehicleCO2 = vehicleLiters * PETROL_EMISSION_FACTOR;
        return electricityCO2 + lpgCO2 + vehicleCO2;
    }
}

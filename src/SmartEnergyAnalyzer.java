import java.util.Scanner;
import model.UsageRecord;
import java.util.ArrayList;
import java.time.LocalDate;
import model.CarbonAnalyzer;
import java.io.*;

public class SmartEnergyAnalyzer {

// In class body
private static ArrayList<UsageRecord> records = new ArrayList<>();
private static final String FILE_PATH = "../db/records.csv";

// Call this after adding a new record
private static void saveRecordsToFile() {
    try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
        for (UsageRecord rec : records) {
            pw.println(rec.getDate() + "," + rec.getElectricityKWh() + "," + rec.getLpgKg() + "," + rec.getVehicleLiters());
        }
    } catch (IOException e) {
        System.out.println("Error saving records: " + e.getMessage());
    }
}

// Call this at the start of main()
private static void loadRecordsFromFile() {
    records.clear();
    File file = new File(FILE_PATH);
    if (!file.exists()) return;
    try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 4) {
                records.add(new UsageRecord(
                    java.time.LocalDate.parse(parts[0]),
                    Double.parseDouble(parts[1]),
                    Double.parseDouble(parts[2]),
                    Double.parseDouble(parts[3])
                ));
            }
        }
    } catch (IOException e) {
        System.out.println("Error loading records: " + e.getMessage());
    }
}


    public static void main(String[] args) {
        loadRecordsFromFile();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=== Smart Energy Usage & Carbon Footprint Analyzer ===");
            System.out.println("1. Add Energy Usage Record");
            System.out.println("2. View Past Usage Records");
            System.out.println("3. Calculate Carbon Footprint");
            System.out.println("4. Get Suggestions to Reduce Carbon Footprint");
            System.out.println("5. Delete a Usage Record");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch(choice) {
                case 1:
    System.out.print("Enter electricity usage (kWh): ");
    double electricity = scanner.nextDouble();
    System.out.print("Enter LPG usage (kg): ");
    double lpg = scanner.nextDouble();
    System.out.print("Enter vehicle fuel usage (liters): ");
    double vehicle = scanner.nextDouble();

    UsageRecord rec = new UsageRecord(LocalDate.now(), electricity, lpg, vehicle);
    records.add(rec);
    saveRecordsToFile();
    System.out.println("Record added!\n");
    break;

                case 2:
    if (records.isEmpty()) {
        System.out.println("No records found.");
    } else {
        System.out.println("Date | Electricity | LPG | Vehicle");
        for (UsageRecord recItem : records) {
            System.out.println(recItem);
        }
    }
    break;

                case 3:
    if (records.isEmpty()) {
        System.out.println("No records found to calculate carbon footprint.");
    } else {
        double totalElectricity = 0.0, totalLpg = 0.0, totalVehicle = 0.0;
        for (UsageRecord recItem : records) {
            totalElectricity += recItem.getElectricityKWh();
            totalLpg += recItem.getLpgKg();
            totalVehicle += recItem.getVehicleLiters();
        }
        double totalCO2 = model.CarbonAnalyzer.calculateCarbonFootprint(totalElectricity, totalLpg, totalVehicle);

        System.out.printf("Your total carbon footprint for ALL records: %.2f kg CO2\n", totalCO2);
        System.out.printf("Breakdown: Electricity: %.2f kg | LPG: %.2f kg | Vehicle: %.2f kg\n",
            totalElectricity * model.CarbonAnalyzer.ELECTRICITY_EMISSION_FACTOR,
            totalLpg * model.CarbonAnalyzer.LPG_EMISSION_FACTOR,
            totalVehicle * model.CarbonAnalyzer.PETROL_EMISSION_FACTOR
        );
    }
    break;

                case 4:
    if (records.isEmpty()) {
        System.out.println("No records to analyze. Add some usage records first.");
    } else {
        double totalElectricity = 0.0, totalLpg = 0.0, totalVehicle = 0.0;
        for (UsageRecord recItem : records) {
            totalElectricity += recItem.getElectricityKWh();
            totalLpg += recItem.getLpgKg();
            totalVehicle += recItem.getVehicleLiters();
        }
        System.out.println("--- Eco Suggestions ---");
        if (totalElectricity > 60) {
            System.out.println("Consider switching to LED bulbs and turning off unused appliances to lower power usage.");
        } else {
            System.out.println("Your electricity usage is within eco-friendly limits!");
        }
        if (totalLpg > 40) {
            System.out.println("Try to optimize cooking habits or switch to induction cooktops to reduce LPG consumption.");
        } else {
            System.out.println("Your LPG usage is within sustainable limits!");
        }
        if (totalVehicle > 30) {
            System.out.println("Limit short trips, carpool, or use public transport/bike to cut vehicle emissions.");
        } else {
            System.out.println("Great job keeping your vehicle fuel usage low!");
        }
        System.out.println("------------------------");
    }
    break;
            case 5:
    if (records.isEmpty()) {
        System.out.println("No records to delete.");
    } else {
        System.out.println("Available records:");
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i+1) + ". " + records.get(i));
        }
        System.out.print("Enter the record number to delete: ");
        int delIdx = scanner.nextInt();
        if (delIdx < 1 || delIdx > records.size()) {
            System.out.println("Invalid record number.");
        } else {
            UsageRecord removed = records.remove(delIdx - 1);
            saveRecordsToFile();
            System.out.println("Deleted: " + removed);
        }
    }
    break;


                case 0:
                    System.out.println("Thank you for using the analyzer!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while(choice != 0);

        scanner.close();
    }
}

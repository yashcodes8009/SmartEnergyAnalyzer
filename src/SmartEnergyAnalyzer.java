// public class SmartEnergyAnalyzer {
//     public static void main(String[] args) {
//         System.out.println("Welcome to Smart Energy Usage & Carbon Footprint Analyzer!");
//         // TODO: Add menu and implementation
//     }
// }
import java.util.Scanner;
import model.UsageRecord;
import java.util.ArrayList;
import java.time.LocalDate;


public class SmartEnergyAnalyzer {

// In class body
private static ArrayList<UsageRecord> records = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=== Smart Energy Usage & Carbon Footprint Analyzer ===");
            System.out.println("1. Add Energy Usage Record");
            System.out.println("2. View Past Usage Records");
            System.out.println("3. Calculate Carbon Footprint");
            System.out.println("4. Get Suggestions to Reduce Carbon Footprint");
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
                    // TODO: Carbon calculation logic
                    break;
                case 4:
                    // TODO: Suggestions logic
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

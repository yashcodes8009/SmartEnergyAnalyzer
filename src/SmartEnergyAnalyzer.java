// public class SmartEnergyAnalyzer {
//     public static void main(String[] args) {
//         System.out.println("Welcome to Smart Energy Usage & Carbon Footprint Analyzer!");
//         // TODO: Add menu and implementation
//     }
// }
import java.util.Scanner;

public class SmartEnergyAnalyzer {
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
                    // TODO: Add record logic
                    break;
                case 2:
                    // TODO: View records logic
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
